package LibraryManagementSystem.statistik.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import LibraryManagementSystem.buku.core.Buku;


@Entity(name="statistik_impl")
@Table(name="statistik_impl")
public class StatistikImpl extends StatistikComponent {

	public StatistikImpl(Buku daftarbukuimpl) {
    this.idStatistik = UUID.randomUUID();
		this.daftarbukuimpl = daftarbukuimpl;
	}

	public StatistikImpl() { }

  public StatistikImpl(UUID idStatistik, Buku daftarbukuimpl) {
    this.idStatistik = idStatistik;
    this.daftarbukuimpl = daftarbukuimpl;
  }

  public UUID getIdStatistik() {
    return this.idStatistik;
  }

  public void setIdStatistik(UUID idStatistik) {
    this.idStatistik = idStatistik;
  }

  public Buku getDaftarbukuimpl() {
    return this.daftarbukuimpl;
  }

  public void setDaftarbukuimpl(Buku daftarbukuimpl) {
    this.daftarbukuimpl = daftarbukuimpl;
  }
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> statistikMap = new HashMap<String,Object>();
		statistikMap.put("daftarbukuimpl",getDaftarbukuimpl());

        return statistikMap;
    }
}
