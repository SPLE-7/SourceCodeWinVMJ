package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class BukuResourceDecorator extends BukuResourceComponent{
	protected BukuResourceComponent record;

    public BukuResourceDecorator(BukuResourceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> createBuku(VMJExchange vmjExchange){
		return record.createBuku(vmjExchange);
	}
	
    public HashMap<String, Object> getBuku(VMJExchange vmjExchange){
		return record.getBuku(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllBuku(VMJExchange vmjExchange){
		return record.getAllBuku(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteBuku(VMJExchange vmjExchange){
		return record.deleteBuku(vmjExchange);
	}

}
