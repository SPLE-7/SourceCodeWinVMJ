package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class PeminjamanBukuResourceComponent implements PeminjamanBukuResource{
	
	public PeminjamanBukuResourceComponent() { }
 
    public abstract HashMap<String, Object> createPeminjamanBuku(VMJExchange vmjExchange);    
    public abstract HashMap<String, Object> getPeminjamanBuku(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllPeminjamanBuku(VMJExchange vmjExchange);

}
