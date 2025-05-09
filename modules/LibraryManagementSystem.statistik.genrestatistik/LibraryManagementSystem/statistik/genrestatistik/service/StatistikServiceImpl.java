package LibraryManagementSystem.statistik.genrestatistik;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.statistik.core.StatistikServiceDecorator;
import LibraryManagementSystem.statistik.core.StatistikImpl;
import LibraryManagementSystem.statistik.core.StatistikServiceComponent;
import LibraryManagementSystem.buku.core.Buku;

public class StatistikServiceImpl extends StatistikServiceDecorator {
    public StatistikServiceImpl (StatistikServiceComponent record) {
        super(record);
    }

    public List<Buku> getListObject(Map<String, Object> requestBody){
        return bukuRepository.getAllObject("buku_comp");
    }
}
