package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.Buku;

public abstract class StatistikServiceComponent implements StatistikService{
	protected RepositoryUtil<Statistik> statistikRepository;
    protected RepositoryUtil<Buku> bukuRepository;

    public StatistikServiceComponent(){
        this.statistikRepository = new RepositoryUtil<Statistik>(LibraryManagementSystem.statistik.core.StatistikComponent.class);
        this.bukuRepository = new RepositoryUtil<Buku>(LibraryManagementSystem.buku.core.BukuComponent.class);
    }	

    public abstract List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List);
    public abstract List<Buku> getListObject();
	public abstract int hitungTotalBuku();
}
