package LibraryManagementSystem.peminjamanbuku.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

@Entity
@Table(name="peminjamanbuku_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PeminjamanBukuComponent implements PeminjamanBuku{
	@Id
	protected UUID idPeminjamanBuku; 
	protected String status;

	// AMBIL DARI EXTERNAL LIBRARY
	@ManyToOne(targetEntity=vmj.auth.model.core.UserComponent.class)
	public User akunimpl;

	@ManyToOne(targetEntity=LibraryManagementSystem.buku.core.BukuComponent.class)
	public Buku daftarbukuimpl;

	protected String tanggalPeminjaman;
	protected String tanggalPengembalian;
	protected String objectName = PeminjamanBukuComponent.class.getName();

	public PeminjamanBukuComponent() {

	} 

	public PeminjamanBukuComponent(
        UUID idPeminjamanBuku, String status, User akunimpl, Buku daftarbukuimpl, String tanggalPeminjaman, String tanggalPengembalian
    ) {
        this.idPeminjamanBuku = idPeminjamanBuku;
        this.status = status;
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
    }

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
	
	public User getAkunimpl() {
		return this.akunimpl;
	}

	public void setAkunimpl(User akunimpl) {
		this.akunimpl = akunimpl;
	}

    public Buku getDaftarbukuimpl() {
		return this.daftarbukuimpl;
	}

	public void setDaftarbukuimpl(Buku daftarbukuimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
	}
	
	public String getTanggalPeminjaman() {
		return this.tanggalPeminjaman;
	}

	public void setTanggalPeminjaman(String tanggalPeminjaman) {
		this.tanggalPeminjaman = tanggalPeminjaman;
	}
	public String getTanggalPengembalian() {
		return this.tanggalPengembalian;
	}

	public void setTanggalPengembalian(String tanggalPengembalian) {
		this.tanggalPengembalian = tanggalPengembalian;
	}
 

	@Override
    public String toString() {
        return "{" +
            " idPeminjamanBuku='" + getIdPeminjamanBuku() + "'" +
            " status='" + getStatus() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            " tanggalPeminjaman='" + getTanggalPeminjaman() + "'" +
            " tanggalPengembalian='" + getTanggalPengembalian() + "'" +
            "}";
    }
	
}
