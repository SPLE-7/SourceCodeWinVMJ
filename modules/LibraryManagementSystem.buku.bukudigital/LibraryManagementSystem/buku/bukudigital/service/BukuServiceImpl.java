package LibraryManagementSystem.buku.bukudigital;

import LibraryManagementSystem.buku.BukuFactory;
import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuServiceDecorator;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.bukudigital.BukuImpl;
import LibraryManagementSystem.buku.core.BukuServiceComponent;


public class BukuServiceImpl extends BukuServiceDecorator {
    BukuServiceComponent record;
  
      public BukuServiceImpl (BukuServiceComponent record) {
          super(record);
          this.record = record;
      }
  
      public Buku createBukuDigital(Map<String, Object> requestBody){
  
        Buku buku = this.record.createBuku(requestBody);
  
        String linkBuku = (String) requestBody.get("linkBuku");
        
        //to do: fix association attributes
        Buku bukuDigital = BukuFactory.createBuku(
          "LibraryManagementSystem.buku.bukudigital.BukuImpl"
        , buku
        , linkBuku
        );
        bukuRepository.saveObject(buku);
        return bukuDigital;
        

      }
  }
