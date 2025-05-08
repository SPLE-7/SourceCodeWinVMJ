package LibraryManagementSystem.buku.bukudigital;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.buku.core.BukuDecorator;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.core.BukuComponent;

@Entity(name="buku_bukudigital")
@Table(name="buku_bukudigital")
public class BukuImpl extends BukuDecorator {

	protected String linkBuku;
	public BukuImpl() {
        super();
        this.objectName = BukuImpl.class.getName();
    }
    
    public BukuImpl(String linkBuku) {
    	super();
		this.linkBuku = linkBuku;
		this.objectName = BukuImpl.class.getName();
    }
	
	public BukuImpl(BukuComponent record, String linkBuku) {
		super(record);
		this.linkBuku = linkBuku;
		this.objectName = BukuImpl.class.getName();
	}

	public String getLinkBuku() {
		return this.linkBuku;
	}

	public void setLinkBuku(String linkBuku) {
		this.linkBuku = linkBuku;
	}


}
