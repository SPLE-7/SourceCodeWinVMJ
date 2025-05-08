package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface PeminjamanBukuResource {
    HashMap<String, Object> getPeminjamanBuku(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllPeminjamanBuku(VMJExchange vmjExchange);
	HashMap<String, Object> createPeminjamanBuku(VMJExchange vmjExhange);
}
