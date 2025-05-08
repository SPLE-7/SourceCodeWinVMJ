package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class BukuResourceComponent implements BukuResource{
	
	public BukuResourceComponent() { }
 
    public abstract HashMap<String, Object> createBuku(VMJExchange vmjExchange);    
    public abstract HashMap<String, Object> getBuku(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllBuku(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteBuku(VMJExchange vmjExchange);

}
