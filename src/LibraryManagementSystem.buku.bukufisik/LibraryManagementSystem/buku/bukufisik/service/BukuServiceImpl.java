package LibraryManagementSystem.buku.bukufisik;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.BukuServiceDecorator;
import LibraryManagementSystem.buku.core.BukuImpl;
import LibraryManagementSystem.buku.core.BukuServiceComponent;

public class BukuServiceImpl extends BukuServiceDecorator {
    public BukuServiceImpl (BukuServiceComponent record) {
        super(record);
    }

    
}
