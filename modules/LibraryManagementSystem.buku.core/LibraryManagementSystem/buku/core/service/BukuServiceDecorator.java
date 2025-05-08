package LibraryManagementSystem.buku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class BukuServiceDecorator extends BukuServiceComponent{
	protected BukuServiceComponent record;

    public BukuServiceDecorator(BukuServiceComponent record) {
        this.record = record;
    }

	public Buku createBuku(Map<String, Object> requestBody){
		return record.createBuku(requestBody);
	}

	public HashMap<String, Object> getBuku(Map<String, Object> requestBody){
		return record.getBuku(requestBody);
	}

	public List<HashMap<String,Object>> getAllBuku(Map<String, Object> requestBody){
		return record.getAllBuku(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Buku> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteBuku(Map<String, Object> requestBody){
		return record.deleteBuku(requestBody);
	}

}
