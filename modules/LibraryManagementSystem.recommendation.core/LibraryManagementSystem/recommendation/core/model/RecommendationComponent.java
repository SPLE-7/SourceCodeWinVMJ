package LibraryManagementSystem.recommendation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import LibraryManagementSystem.buku.core.Buku;

import javax.persistence.ManyToOne;


@Entity
@Table(name="recommendation_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RecommendationComponent implements Recommendation{

	@ManyToOne(targetEntity=LibraryManagementSystem.buku.core.BukuComponent.class)
	public Buku daftarbukuimpl;

	protected String objectName = RecommendationComponent.class.getName();

	public RecommendationComponent() {

	} 

	public RecommendationComponent(
        Buku daftarbukuimpl
    ) {
        this.daftarbukuimpl = daftarbukuimpl;
    }

	public Buku getDaftarbukuimpl() {
		return this.daftarbukuimpl;
	}

	public void setDaftarbukuimpl(Buku daftarbukuimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
	}

	@Override
    public String toString() {
        return "{" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }
	
}
