package LibraryManagementSystem.peminjamanbuku.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

import vmj.auth.model.core.User;

import LibraryManagementSystem.buku.core.Buku;

public interface PeminjamanBuku {
	public UUID getIdPeminjamanBuku();
	public void setIdPeminjamanBuku(UUID idPeminjamanBuku);
	public String getStatus();
	public void setStatus(String status);
	public User getAkunimpl();
	public void setAkunimpl(User akunimpl);
	public Buku getDaftarbukuimpl();
	public void setDaftarbukuimpl(Buku daftarbukuimpl);
	public String getTanggalPeminjaman();
	public void setTanggalPeminjaman(String tanggalPeminjaman);
	public String getTanggalPengembalian();
	public void setTanggalPengembalian(String tanggalPengembalian);
	HashMap<String, Object> toHashMap();
}
