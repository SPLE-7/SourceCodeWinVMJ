package LibraryManagementSystem.statistik.authorstatistik;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.statistik.core.StatistikServiceDecorator;
import LibraryManagementSystem.statistik.core.StatistikImpl;
import LibraryManagementSystem.statistik.core.StatistikServiceComponent;

public class StatistikServiceImpl extends StatistikServiceDecorator {
    public StatistikServiceImpl (StatistikServiceComponent record) {
        super(record);
    }

	public int hitungTotalBuku() {
		// TODO: implement this method
        return 0;
	}
}
