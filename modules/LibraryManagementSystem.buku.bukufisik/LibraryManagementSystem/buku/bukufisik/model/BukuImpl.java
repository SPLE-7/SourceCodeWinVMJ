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
  	public BukuImpl(BukuComponent record, int jumlahBuku) {
		super(record);
		this.jumlahBuku = jumlahBuku;
		this.objectName = BukuImpl.class.getName();
	}

	public BukuImpl() {        
		super();
        this.objectName = BukuImpl.class.getName();
    }
    
    public BukuImpl(int jumlahBuku) {
    	super();
		this.jumlahBuku = jumlahBuku;
		this.objectName = BukuImpl.class.getName();
    }

	public int getJumlahBuku() {
		return this.jumlahBuku;
	}

	public void setJumlahBuku(int jumlahBuku) {
		this.jumlahBuku = jumlahBuku;
	}


	@Override
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bukuMap = new HashMap<String,Object>();
		bukuMap.put("idBuku",getIdBuku());
		bukuMap.put("judulBuku",getJudulBuku());
		bukuMap.put("penulis",getPenulis());
		bukuMap.put("penerbit",getPenerbit());
		bukuMap.put("jumlahHalaman",getJumlahHalaman());
		bukuMap.put("deskripsiBuku",getDeskripsiBuku());
		bukuMap.put("genre",getGenre());
		bukuMap.put("jumlahBuku",getJumlahBuku());

        return bukuMap;
    }

	@Override
	public String toString() {
        return "{" +
            " idBuku='" + getIdBuku() + "'" +
            " judulBuku='" + getJudulBuku() + "'" +
            " penulis='" + getPenulis() + "'" +
            " penerbit='" + getPenerbit() + "'" +
            " jumlahHalaman='" + getJumlahHalaman() + "'" +
            " deskripsiBuku='" + getDeskripsiBuku() + "'" +
            " genre='" + getGenre() + "'" +
			" jumlahBuku='" + getJumlahBuku() + "'" +
            "}";
    }
}