package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class PeminjamanBukuServiceDecorator extends PeminjamanBukuServiceComponent{
	protected PeminjamanBukuServiceComponent record;

    public PeminjamanBukuServiceDecorator(PeminjamanBukuServiceComponent record) {
        this.record = record;
    }

	public PeminjamanBuku createPeminjamanBuku(Map<String, Object> requestBody){
		return record.createPeminjamanBuku(requestBody);
	}

	public HashMap<String, Object> getPeminjamanBuku(Map<String, Object> requestBody){
		return record.getPeminjamanBuku(requestBody);
	}

	public List<HashMap<String,Object>> getAllPeminjamanBuku(Map<String, Object> requestBody){
		return record.getAllPeminjamanBuku(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<PeminjamanBuku> List){
		return record.transformListToHashMap(List);
	}

}
