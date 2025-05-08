package LibraryManagementSystem.buku.bukufisik;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.buku.core.BukuDecorator;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.buku.core.BukuComponent;

@Entity(name="buku_bukufisik")
@Table(name="buku_bukufisik")
public class BukuImpl extends BukuDecorator {

	protected int jumlahBuku;
	public BukuImpl() {        
		super();
        this.objectName = BukuImpl.class.getName();
    }
    
    public BukuImpl(int jumlahBuku) {
    	super();
		this.jumlahBuku = jumlahBuku;
		this.objectName = BukuImpl.class.getName();
    }
	
	public BukuImpl(BukuComponent record, int jumlahBuku) {
		super(record);
		this.jumlahBuku = jumlahBuku;
		this.objectName = BukuImpl.class.getName();
	}

	public int getJumlahBuku() {
		return this.jumlahBuku;
	}

	public void setJumlahBuku(int jumlahBuku) {
		this.jumlahBuku = jumlahBuku;
	}


}
