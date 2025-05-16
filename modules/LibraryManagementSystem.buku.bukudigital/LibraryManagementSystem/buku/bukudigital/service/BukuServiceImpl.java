package LibraryManagementSystem.buku.bukudigital;

import LibraryManagementSystem.buku.BukuFactory;
import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuServiceDecorator;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.core.BukuImpl;
import LibraryManagementSystem.buku.core.BukuServiceComponent;

public class BukuServiceImpl extends BukuServiceDecorator {
    public BukuServiceImpl (BukuServiceComponent record) {
        super(record);
    }
    
    public Buku createBukuDigital(Map<String, Object> requestBody){
  
        // Buku buku = this.record.createBuku(requestBody);

        String linkBuku = (String) requestBody.get("linkBuku");
        
        System.out.println("linkBuku: " + linkBuku);

        Buku bukuDigital = BukuFactory.createBuku(
          "LibraryManagementSystem.buku.bukudigital.BukuImpl"
        , record.createBuku(requestBody)
        , linkBuku
        );

        System.out.println("bukuFisik: " + bukuDigital);

        bukuRepository.saveObject(bukuDigital);
        return bukuDigital;
      }
}
