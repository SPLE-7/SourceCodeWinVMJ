package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PeminjamanBukuService {
	PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody);
	HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<PeminjamanBuku> List);
}
