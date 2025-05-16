package LibraryManagementSystem.peminjamanbuku.renewal;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceDecorator;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBuku;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceComponent;
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuFactory;

public class PeminjamanBukuServiceImpl extends PeminjamanBukuServiceDecorator {
    public PeminjamanBukuServiceImpl (PeminjamanBukuServiceComponent record) {
        super(record);
    }

	public boolean RequestRenewal() {
		// TODO: implement this method
        return true;
	}

    public PeminjamanBuku createPeminjamanBukuRenewal(Map<String, Object> requestBody){
  
        // Buku buku = this.record.createBuku(requestBody);
  
        Double renewalCountDouble = (Double) requestBody.get("renewalCount");
        int renewalCount = renewalCountDouble.intValue();
        
        System.out.println("renewalCount: " + renewalCount);

        PeminjamanBuku peminjamanBukuRenewal = PeminjamanBukuFactory.createPeminjamanBuku(
          "LibraryManagementSystem.peminjamanbuku.renewal.PeminjamanBukuImpl"
        , record.createPeminjamanBuku(requestBody)
        , renewalCount
        );

        System.out.println("peminjamanBukuRenewal: " + peminjamanBukuRenewal);

        peminjamanRepository.saveObject(peminjamanBukuRenewal);
        return peminjamanBukuRenewal;
      }
}
