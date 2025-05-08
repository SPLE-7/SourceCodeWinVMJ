package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BukuService {
	Buku createBuku(Map<String, Object> requestBody);
	HashMap<String, Object> getBuku(Map<String, Object> requestBody);    
    List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Buku> List);
}
