package LibraryManagementSystem.recommendation.core;

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

@Entity(name="recommendation_impl")
@Table(name="recommendation_impl")
public class RecommendationImpl extends RecommendationComponent {

  public RecommendationImpl(Buku daftarbukuimpl) {
		this.idRecommendation = UUID.randomUUID();
		this.daftarbukuimpl = daftarbukuimpl;
	}

	public RecommendationImpl(UUID idRecommendation, Buku daftarbukuimpl) {
		this.idRecommendation = idRecommendation;
		this.daftarbukuimpl = daftarbukuimpl;
	}

	public RecommendationImpl() { }

  public UUID getIdRecommendation() {
		return this.idRecommendation;
	}

	public void setIdRecommendation(UUID idRecommendation) {
		this.idRecommendation = idRecommendation;
	}

	public Buku getDaftarbukuimpl() {
		return this.daftarbukuimpl;
	}

	public void setDaftarbukuimpl(Buku daftarbukuimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> recommendationMap = new HashMap<String,Object>();
        recommendationMap.put("idRecommendation",getIdRecommendation());
		recommendationMap.put("daftarbukuimpl",getDaftarbukuimpl());

        return recommendationMap;
    }
}
