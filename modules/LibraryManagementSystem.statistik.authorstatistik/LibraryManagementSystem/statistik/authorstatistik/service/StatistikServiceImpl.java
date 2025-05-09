package LibraryManagementSystem.statistik.authorstatistik;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.statistik.core.StatistikServiceDecorator;
import LibraryManagementSystem.statistik.core.StatistikImpl;
import LibraryManagementSystem.buku.core.Buku;
import LibraryManagementSystem.statistik.core.StatistikResourceComponent;
import LibraryManagementSystem.statistik.core.StatistikServiceComponent;

public class StatistikServiceImpl extends StatistikServiceDecorator {
    StatistikServiceComponent record;

    public StatistikServiceImpl (StatistikServiceComponent record) {
        super(record);
        this.record = record;
    }

    public List<Buku> getListObject(Map<String, Object> requestBody){
        return bukuRepository.getAllObject("buku_comp");
    }

}
