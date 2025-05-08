package LibraryManagementSystem.peminjamanbuku.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

@Entity(name="peminjamanbuku_impl")
@Table(name="peminjamanbuku_impl")
public class PeminjamanBukuImpl extends PeminjamanBukuComponent {

	public PeminjamanBukuImpl(UUID idPeminjamanBuku, String status, User akunimpl, Buku daftarbukuimpl, Date tanggalPeminjaman, Date tanggalPengembalian) {
		this.idPeminjamanBuku = idPeminjamanBuku;
		this.status = status;
		this.akunimpl = akunimpl;
		this.daftarbukuimpl = daftarbukuimpl;
		this.tanggalPeminjaman = tanggalPeminjaman;
		this.tanggalPengembalian = tanggalPengembalian;
	}

	public PeminjamanBukuImpl(String status, User akunimpl, Buku daftarbukuimpl, Date tanggalPeminjaman, Date tanggalPengembalian) {
		this.idPeminjamanBuku =  idPeminjamanBuku.randomUUID();
		this.status = status;
		this.akunimpl = akunimpl;
		this.daftarbukuimpl = daftarbukuimpl;
		this.tanggalPeminjaman = tanggalPeminjaman;
		this.tanggalPengembalian = tanggalPengembalian;
	}

	public PeminjamanBukuImpl() { }

	public UUID getIdPeminjamanBuku() {
		return this.idPeminjamanBuku;
	}

	public void setIdPeminjamanBuku(UUID idPeminjamanBuku) {
		this.idPeminjamanBuku = idPeminjamanBuku;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTanggalPeminjaman() {
		return this.tanggalPeminjaman;
	}

	public void setTanggalPeminjaman(Date tanggalPeminjaman) {
		this.tanggalPeminjaman = tanggalPeminjaman;
	}
	public Date getTanggalPengembalian() {
		return this.tanggalPengembalian;
	}

	public void setTanggalPengembalian(Date tanggalPengembalian) {
		this.tanggalPengembalian = tanggalPengembalian;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> peminjamanbukuMap = new HashMap<String,Object>();
		peminjamanbukuMap.put("idPeminjamanBuku",getIdPeminjamanBuku());
		peminjamanbukuMap.put("status",getStatus());
		peminjamanbukuMap.put("akunimpl",getAkunimpl());
		peminjamanbukuMap.put("daftarbukuimpl",getDaftarbukuimpl());
		peminjamanbukuMap.put("tanggalPeminjaman",getTanggalPeminjaman());
		peminjamanbukuMap.put("tanggalPengembalian",getTanggalPengembalian());

        return peminjamanbukuMap;
    }
}
