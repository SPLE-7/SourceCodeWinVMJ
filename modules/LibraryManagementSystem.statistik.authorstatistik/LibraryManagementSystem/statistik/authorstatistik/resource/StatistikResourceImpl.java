package LibraryManagementSystem.statistik.authorstatistik;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.statistik.core.StatistikResourceDecorator;
import LibraryManagementSystem.statistik.core.StatistikImpl;
import LibraryManagementSystem.statistik.core.StatistikResourceComponent;
import LibraryManagementSystem.statistik.core.StatistikServiceComponent;

public class StatistikResourceImpl extends StatistikResourceDecorator {
    private StatistikServiceImpl statistikServiceImpl;
	public StatistikResourceImpl (StatistikResourceComponent record, StatistikServiceComponent statistikServiceComponent) {
        super(record);
		this.statistikServiceImpl = new StatistikServiceImpl(statistikServiceComponent);
    }

	// @Restriced(permission = "")
    @Route(url="call/authorstatistik/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return statistikServiceImpl.getAllStatistik(vmjExchange.getPayload());
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
		return statistikServiceImpl.hitungTotalBuku();
	}
}
