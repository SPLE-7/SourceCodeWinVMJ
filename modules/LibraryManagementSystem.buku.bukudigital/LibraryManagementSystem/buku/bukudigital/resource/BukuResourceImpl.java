package LibraryManagementSystem.buku.bukudigital;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuResourceDecorator;
import LibraryManagementSystem.buku.core.BukuImpl;
import LibraryManagementSystem.buku.core.BukuResourceComponent;
import LibraryManagementSystem.buku.core.BukuServiceComponent;

public class BukuResourceImpl extends BukuResourceDecorator {
    private BukuServiceImpl bukuServiceImpl;

	public BukuResourceImpl (BukuResourceComponent record, BukuServiceComponent bukuServiceComponent) {
        super(record);
		this.bukuServiceImpl = new BukuServiceImpl(bukuServiceComponent);
    }

    // @Restriced(permission = "")
	@Route(url="call/bukudigital/create")
    public HashMap<String, Object> create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return (bukuServiceImpl.createBukuDigital(vmjExchange.getPayload())).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/bukudigital/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return bukuServiceImpl.getAllBukuDigital(vmjExchange.getPayload());
	}

}
