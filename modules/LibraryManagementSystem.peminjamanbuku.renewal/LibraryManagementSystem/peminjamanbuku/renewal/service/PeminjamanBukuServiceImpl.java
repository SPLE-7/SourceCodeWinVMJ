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

    public PeminjamanBuku createPeminjamanBukuRenewal(Map<String, Object> requestBody){
  
        Double renewalCountDouble = (Double) requestBody.get("renewalCount");
        int renewalCount = renewalCountDouble.intValue();

        PeminjamanBuku peminjamanBukuRenewal = PeminjamanBukuFactory.createPeminjamanBuku(
          "LibraryManagementSystem.peminjamanbuku.renewal.PeminjamanBukuImpl"
        , record.createPeminjamanBuku(requestBody)
        , renewalCount
        );

        peminjamanRepository.saveObject(peminjamanBukuRenewal);
        return peminjamanBukuRenewal;
      }

      public List<HashMap<String,Object>> getAllPeminjamanBukuRenewal(Map<String, Object> requestBody){
        String table = "peminjamanbuku_renewal";
        List<PeminjamanBuku> List = peminjamanRepository.getAllObject(table);
        return this.transformListToHashMap(List);
      }
    
        public List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
            for(int i = 0; i < List.size(); i++) {
                resultList.add(List.get(i).toHashMap());
            }
    
            return resultList;
      }
}
