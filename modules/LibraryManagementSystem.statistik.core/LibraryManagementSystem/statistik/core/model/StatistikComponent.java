package LibraryManagementSystem.statistik.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

import LibraryManagementSystem.buku.core.Buku;

@Entity
@Table(name="statistik_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class StatistikComponent implements Statistik{
  @Id
	protected UUID idStatistik; 
	
	@ManyToOne(targetEntity=LibraryManagementSystem.buku.core.BukuComponent.class)
	public Buku daftarbukuimpl;
	
	protected String objectName = StatistikComponent.class.getName();

	public StatistikComponent() {

	} 

	public StatistikComponent(
        Buku daftarbukuimpl
    ) {
        this.daftarbukuimpl = daftarbukuimpl;
    }

  public UUID getIdStatistik() {
    return this.idStatistik;
  }

	public Buku getDaftarbukuimpl() {
		return this.daftarbukuimpl;
	}

	public void setDaftarbukuimpl(Buku daftarbukuimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
	}
 
	public abstract int hitungTotalBuku();

	@Override
    public String toString() {
        return "{" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }
	
}
