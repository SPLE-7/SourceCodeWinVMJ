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

        String linkBuku = (String) requestBody.get("linkBuku");
        
        Buku bukuDigital = BukuFactory.createBuku(
          "LibraryManagementSystem.buku.bukudigital.BukuImpl"
        , record.createBuku(requestBody)
        , linkBuku
        );

        bukuRepository.saveObject(bukuDigital);
        return bukuDigital;
      }

      public List<HashMap<String,Object>> getAllBukuDigital(Map<String, Object> requestBody){
        String table = "buku_bukudigital";
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

      public HashMap<String, Object> getBukuDigital(Map<String, Object> requestBody){
        List<HashMap<String, Object>> bukuList = getAllBukuDigital(requestBody);
        UUID idRequest = UUID.fromString((String) requestBody.get("idBuku"));
        for (HashMap<String, Object> buku : bukuList){
          UUID recordId = (UUID) buku.get("idBuku");
          if (recordId.equals(idRequest)) {
            return buku;
          }
        }
        return null;
      }

      public List<HashMap<String,Object>> deleteBukuDigital(Map<String, Object> requestBody){
        HashMap<String, Object> buku = getBukuDigital(requestBody);
        UUID recordId = (UUID) buku.get("base_component_id");
        System.out.println("recordId: " + recordId + "base_component_id");
        bukuRepository.deleteObject(recordId);
        return getAllBukuDigital(requestBody);
      }
}
