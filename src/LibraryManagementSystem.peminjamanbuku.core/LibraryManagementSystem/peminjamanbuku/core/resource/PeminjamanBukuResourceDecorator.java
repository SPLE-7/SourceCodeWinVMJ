package LibraryManagementSystem.peminjamanbuku.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class PeminjamanBukuResourceDecorator extends PeminjamanBukuResourceComponent{
	protected PeminjamanBukuResourceComponent record;

    public PeminjamanBukuResourceDecorator(PeminjamanBukuResourceComponent record) {
        this.record = record;
    }

    public HashMap<String, Object> createPeminjamanBuku(VMJExchange vmjExchange){
		return record.createPeminjamanBuku(vmjExchange);
	}

    public HashMap<String, Object> getPeminjamanBuku(VMJExchange vmjExchange){
		return record.getPeminjamanBuku(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllPeminjamanBuku(VMJExchange vmjExchange){
		return record.getAllPeminjamanBuku(vmjExchange);
	}

}
