package LibraryManagementSystem.peminjamanbuku.renewal;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceDecorator;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceComponent;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuResourceComponent;

public class PeminjamanBukuResourceImpl extends PeminjamanBukuResourceDecorator {
    private PeminjamanBukuServiceImpl peminjamanBukuServiceImpl;

	public PeminjamanBukuResourceImpl (PeminjamanBukuResourceComponent record, PeminjamanBukuServiceComponent peminjamanBukuServiceComponent) {
        super(record);
		this.peminjamanBukuServiceImpl = new PeminjamanBukuServiceImpl(peminjamanBukuServiceComponent);
    }

	@Route(url="call/renewal/create")
    public HashMap<String, Object> create(VMJExchange vmjExchange){
		String renewalCountStr = (String) vmjExchange.getRequestBodyForm("renewalCount");
		int renewalCount = Integer.parseInt(renewalCountStr);
		
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return peminjamanBukuServiceImpl.createPeminjamanBuku(vmjExchange.getPayload()).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/renewal/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return peminjamanBukuServiceImpl.getPeminjamanBuku(vmjExchange.getPayload());
	}

	// @Restriced(permission = "")
    @Route(url="call/renewal/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return peminjamanBukuServiceImpl.getAllPeminjamanBuku(vmjExchange.getPayload());
	}

	public boolean RequestRenewal() {
		// TODO: implement this method
		return true;
	}
}
