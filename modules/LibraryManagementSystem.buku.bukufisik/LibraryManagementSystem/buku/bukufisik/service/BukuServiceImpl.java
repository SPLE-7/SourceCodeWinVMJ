package LibraryManagementSystem.buku.bukufisik;

import LibraryManagementSystem.buku.BukuFactory;
import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuServiceDecorator;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.bukufisik.BukuImpl;
import LibraryManagementSystem.buku.core.BukuServiceComponent;


public class BukuServiceImpl extends BukuServiceDecorator {
    BukuServiceComponent record;
  
      public BukuServiceImpl (BukuServiceComponent record) {
          super(record);
          this.record = record;
      }
  
      public Buku createBukuFisik(Map<String, Object> requestBody){
  
        Buku buku = this.record.createBuku(requestBody);
  
        Double jumlahBukuDouble = (Double) requestBody.get("jumlahBuku");
        int jumlahBuku = jumlahBukuDouble.intValue();
        
        Buku bukuFisik = BukuFactory.createBuku(
          "LibraryManagementSystem.buku.bukufisik.BukuImpl"
        , buku
        , jumlahBuku
        );
        bukuRepository.saveObject(buku);
        return bukuFisik;
      }
  }