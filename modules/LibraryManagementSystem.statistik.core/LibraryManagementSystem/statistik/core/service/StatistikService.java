package LibraryManagementSystem.statistik.core;
import java.util.*;

import LibraryManagementSystem.buku.core.Buku;

import vmj.routing.route.VMJExchange;

public interface StatistikService {
    List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Statistik> List);
}
