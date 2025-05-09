package LibraryManagementSystem.peminjamanbuku.renewal;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceDecorator;
import LibraryManagementSystem.peminjamanbuku.PeminjamanBukuFactory;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBuku;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceComponent;

public class PeminjamanBukuServiceImpl extends PeminjamanBukuServiceDecorator {
    PeminjamanBukuServiceComponent record;

    public PeminjamanBukuServiceImpl (PeminjamanBukuServiceComponent record) {
        super(record);
        this.record = record;
    }

	public PeminjamanBuku requestRenewal(Map<String, Object> requestBody){
  
        PeminjamanBuku peminjamanbuku = this.record.createPeminjamanBuku(requestBody);
  
        Double renewalCount_Double = (Double) requestBody.get("linkBuku");
        Integer renewalCount = renewalCount_Double.intValue(); 
        
        PeminjamanBuku peminjamanbuku_renewal = PeminjamanBukuFactory.createPeminjamanBuku(
          "LibraryManagementSystem.peminjamanbuku.renewal.PeminjamanBukuImpl"
        , peminjamanbuku
        , renewalCount
        );
        peminjamanRepository.saveObject(peminjamanbuku_renewal);
        return peminjamanbuku_renewal;
      }
}
