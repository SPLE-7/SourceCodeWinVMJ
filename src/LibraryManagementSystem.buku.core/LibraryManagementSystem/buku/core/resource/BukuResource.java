package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface BukuResource {
    HashMap<String, Object> getBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteBuku(VMJExchange vmjExchange);
	HashMap<String, Object> createBuku(VMJExchange vmjExhange);
}
