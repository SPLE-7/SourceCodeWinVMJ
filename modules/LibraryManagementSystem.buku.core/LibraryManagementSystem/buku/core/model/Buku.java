package LibraryManagementSystem.buku.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Buku {
	public UUID getIdBuku();
	public void setIdBuku(UUID idBuku);
	public String getJudulBuku();
	public void setJudulBuku(String judulBuku);
	public String getPenulis();
	public void setPenulis(String penulis);
	public String getPenerbit();
	public void setPenerbit(String penerbit);
	public int getJumlahHalaman();
	public void setJumlahHalaman(int jumlahHalaman);
	public String getDeskripsiBuku();
	public void setDeskripsiBuku(String deskripsiBuku);
	public String getGenre();
	public void setGenre(String genre);
	HashMap<String, Object> toHashMap();
}
