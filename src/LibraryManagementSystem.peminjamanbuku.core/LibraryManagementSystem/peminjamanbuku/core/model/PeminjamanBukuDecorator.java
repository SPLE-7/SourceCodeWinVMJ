package LibraryManagementSystem.peminjamanbuku.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class PeminjamanBukuDecorator extends PeminjamanBukuComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected PeminjamanBukuComponent record;

	public PeminjamanBukuDecorator () {
		super();
		this.record = record;
		this.idPeminjamanBuku =  idPeminjamanBuku.randomUUID();
	}
		
	public PeminjamanBukuDecorator (PeminjamanBukuComponent record) {
		this.idPeminjamanBuku =  idPeminjamanBuku.randomUUID();
		this.record = record;
	}

	public PeminjamanBukuDecorator (UUID idPeminjamanBuku, PeminjamanBukuComponent record) {
		this.idPeminjamanBuku =  idPeminjamanBuku;
		this.record = record;
	}
	
	public PeminjamanBukuDecorator (PeminjamanBukuComponent record, String objectName) {
		this.idPeminjamanBuku =  idPeminjamanBuku.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public UUID getIdPeminjamanBuku() {
		return record.getIdPeminjamanBuku();
	}
	public void setIdPeminjamanBuku(UUID idPeminjamanBuku) {
		record.setIdPeminjamanBuku(idPeminjamanBuku);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}
	public Date getTanggalPeminjaman() {
		return record.getTanggalPeminjaman();
	}
	public void setTanggalPeminjaman(Date tanggalPeminjaman) {
		record.setTanggalPeminjaman(tanggalPeminjaman);
	}
	public Date getTanggalPengembalian() {
		return record.getTanggalPengembalian();
	}
	public void setTanggalPengembalian(Date tanggalPengembalian) {
		record.setTanggalPengembalian(tanggalPengembalian);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
