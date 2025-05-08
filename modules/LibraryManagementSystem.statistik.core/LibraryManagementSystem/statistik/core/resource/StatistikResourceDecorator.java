package LibraryManagementSystem.statistik.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.Buku;

public abstract class StatistikResourceDecorator extends StatistikResourceComponent{
	protected StatistikResourceComponent record;

    public StatistikResourceDecorator(StatistikResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> getAllStatistik(VMJExchange vmjExchange){
		return record.getAllStatistik(vmjExchange);
	}

	public int hitungTotalBuku() {
		return record.hitungTotalBuku();
	}

	public List<Buku> getListObject(){
		return record.getListObject();
	}
}
