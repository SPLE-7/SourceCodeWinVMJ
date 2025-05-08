package LibraryManagementSystem.statistik.authorstatistik;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.statistik.core.StatistikDecorator;
import LibraryManagementSystem.statistik.core.Statistik;
import LibraryManagementSystem.statistik.core.StatistikComponent;

import LibraryManagementSystem.buku.core.Buku;

@Entity(name="statistik_authorstatistik")
@Table(name="statistik_authorstatistik")
public class StatistikImpl extends StatistikDecorator {
    
    public StatistikImpl() {
    	super();
		this.objectName = StatistikImpl.class.getName();
    }
	
	public StatistikImpl(StatistikComponent record) {
		super(record);
		this.objectName = StatistikImpl.class.getName();
	}

	public int hitungTotalBuku() {
		// TODO: implement this method
        return 0;
	}
}
