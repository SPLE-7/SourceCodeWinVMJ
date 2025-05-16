package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.Buku;

public abstract class StatistikServiceDecorator extends StatistikServiceComponent{
	protected StatistikServiceComponent record;

    public StatistikServiceDecorator(StatistikServiceComponent record) {
        this.record = record;
    }

	public List<HashMap<String,Object>> getAllStatistik(Map<String, Object> requestBody){
		return record.getAllStatistik(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Statistik> List){
		return record.transformListToHashMap(List);
	}
}
