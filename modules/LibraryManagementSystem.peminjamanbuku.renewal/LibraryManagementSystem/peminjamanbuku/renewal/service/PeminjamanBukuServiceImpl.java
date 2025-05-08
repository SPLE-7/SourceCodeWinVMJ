package LibraryManagementSystem.peminjamanbuku.renewal;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceDecorator;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuImpl;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuServiceComponent;

public class PeminjamanBukuServiceImpl extends PeminjamanBukuServiceDecorator {
    public PeminjamanBukuServiceImpl (PeminjamanBukuServiceComponent record) {
        super(record);
    }

	public boolean RequestRenewal() {
		// TODO: implement this method
        return true;
	}
}
