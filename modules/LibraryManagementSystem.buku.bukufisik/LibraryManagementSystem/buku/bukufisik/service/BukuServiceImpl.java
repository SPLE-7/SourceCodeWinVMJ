package LibraryManagementSystem.buku.bukufisik;

import LibraryManagementSystem.buku.BukuFactory;
import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuServiceDecorator;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.bukufisik.BukuImpl;
import LibraryManagementSystem.buku.core.BukuServiceComponent;


public class BukuServiceImpl extends BukuServiceDecorator {
  
      public BukuServiceImpl (BukuServiceComponent record) {
          super(record);
      }
  
      public Buku createBukuFisik(Map<String, Object> requestBody){
  
        Double jumlahBukuDouble = (Double) requestBody.get("jumlahBuku");
        int jumlahBuku = jumlahBukuDouble.intValue();
        
        Buku bukuFisik = BukuFactory.createBuku(
          "LibraryManagementSystem.buku.bukufisik.BukuImpl"
        , record.createBuku(requestBody)
        , jumlahBuku
        );

        bukuRepository.saveObject(bukuFisik);
        return bukuFisik;
      }

      public List<HashMap<String,Object>> getAllBukuFisik(Map<String, Object> requestBody){
        String table = "buku_bukufisik";
        List<Buku> List = bukuRepository.getAllObject(table);
        return this.transformListToHashMap(List);
      }
    
        public List<HashMap<String,Object>> transformListToHashMap(List<Buku> List){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
            for(int i = 0; i < List.size(); i++) {
                resultList.add(List.get(i).toHashMap());
            }
    
            return resultList;
      }

      public HashMap<String, Object> getBukuFisik(Map<String, Object> requestBody){
        List<HashMap<String, Object>> bukuList = getAllBukuFisik(requestBody);
        UUID idRequest = UUID.fromString((String) requestBody.get("idBuku"));
        for (HashMap<String, Object> buku : bukuList){
          UUID recordId = (UUID) buku.get("idBuku");
          if (recordId.equals(idRequest)) {
            return buku;
          }
        }
        return null;
      }

      public List<HashMap<String,Object>> deleteBukuFisik(Map<String, Object> requestBody){
        HashMap<String, Object> buku = this.getBukuFisik(requestBody);
        System.out.println("buku: " + buku);
        // NULL
        UUID recordId = (UUID) buku.get("base_component_id");
        System.out.println("recordId: " + recordId + "base_component_id");
        bukuRepository.deleteObject(recordId);
        return getAllBukuFisik(requestBody);
      }
  }