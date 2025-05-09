package LibraryManagementSystem.buku.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class BukuDecorator extends BukuComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected BukuComponent record;

	public BukuDecorator () {
		super();
		this.record = record;
		this.idBuku =  UUID.randomUUID();
	}

	public BukuDecorator (BukuComponent record) {
		this.idBuku =  UUID.randomUUID();
		this.record = record;
	}

	public BukuDecorator (UUID idBuku, BukuComponent record) {
		this.idBuku =  idBuku;
		this.record = record;
	}
	
	public BukuDecorator (BukuComponent record, String objectName) {
		this.idBuku =  UUID.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public UUID getIdBuku() {
		return record.getIdBuku();
	}
	public void setIdBuku(UUID idBuku) {
		record.setIdBuku(idBuku);
	}
	public String getJudulBuku() {
		return record.getJudulBuku();
	}
	public void setJudulBuku(String judulBuku) {
		record.setJudulBuku(judulBuku);
	}
	public String getPenulis() {
		return record.getPenulis();
	}
	public void setPenulis(String penulis) {
		record.setPenulis(penulis);
	}
	public String getPenerbit() {
		return record.getPenerbit();
	}
	public void setPenerbit(String penerbit) {
		record.setPenerbit(penerbit);
	}
	public int getJumlahHalaman() {
		return record.getJumlahHalaman();
	}
	public void setJumlahHalaman(int jumlahHalaman) {
		record.setJumlahHalaman(jumlahHalaman);
	}
	public String getDeskripsiBuku() {
		return record.getDeskripsiBuku();
	}
	public void setDeskripsiBuku(String deskripsiBuku) {
		record.setDeskripsiBuku(deskripsiBuku);
	}
	public String getGenre() {
		return record.getGenre();
	}
	public void setGenre(String genre) {
		record.setGenre(genre);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
