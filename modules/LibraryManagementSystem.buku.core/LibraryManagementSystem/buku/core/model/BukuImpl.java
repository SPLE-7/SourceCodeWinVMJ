package LibraryManagementSystem.buku.core;

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


@Entity(name="buku_impl")
@Table(name="buku_impl")
public class BukuImpl extends BukuComponent {

  public BukuImpl(String judulBuku, String penulis, String penerbit, int jumlahHalaman, String deskripsiBuku, String genre) {
		this.idBuku =  UUID.randomUUID();
		this.judulBuku = judulBuku;
		this.penulis = penulis;
		this.penerbit = penerbit;
		this.jumlahHalaman = jumlahHalaman;
		this.deskripsiBuku = deskripsiBuku;
		this.genre = genre;
	}

	public BukuImpl(UUID idBuku, String judulBuku, String penulis, String penerbit, int jumlahHalaman, String deskripsiBuku, String genre) {
		this.idBuku = idBuku;
		this.judulBuku = judulBuku;
		this.penulis = penulis;
		this.penerbit = penerbit;
		this.jumlahHalaman = jumlahHalaman;
		this.deskripsiBuku = deskripsiBuku;
		this.genre = genre;
	}

  public BukuImpl() {}

	public UUID getIdBuku() {
		return this.idBuku;
	}

	public void setIdBuku(UUID idBuku) {
		this.idBuku = idBuku;
	}
	public String getJudulBuku() {
		return this.judulBuku;
	}

	public void setJudulBuku(String judulBuku) {
		this.judulBuku = judulBuku;
	}
	public String getPenulis() {
		return this.penulis;
	}

	public void setPenulis(String penulis) {
		this.penulis = penulis;
	}
	public String getPenerbit() {
		return this.penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}
	public int getJumlahHalaman() {
		return this.jumlahHalaman;
	}

	public void setJumlahHalaman(int jumlahHalaman) {
		this.jumlahHalaman = jumlahHalaman;
	}
	public String getDeskripsiBuku() {
		return this.deskripsiBuku;
	}

	public void setDeskripsiBuku(String deskripsiBuku) {
		this.deskripsiBuku = deskripsiBuku;
	}
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> bukuMap = new HashMap<String,Object>();
		bukuMap.put("idBuku",getIdBuku());
		bukuMap.put("judulBuku",getJudulBuku());
		bukuMap.put("penulis",getPenulis());
		bukuMap.put("penerbit",getPenerbit());
		bukuMap.put("jumlahHalaman",getJumlahHalaman());
		bukuMap.put("deskripsiBuku",getDeskripsiBuku());
		bukuMap.put("genre",getGenre());

        return bukuMap;
    }

}
