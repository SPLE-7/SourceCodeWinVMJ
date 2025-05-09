package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.Buku;

public abstract class StatistikResourceComponent implements StatistikResource{
	
	public StatistikResourceComponent() { }

    public abstract List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange);
}
