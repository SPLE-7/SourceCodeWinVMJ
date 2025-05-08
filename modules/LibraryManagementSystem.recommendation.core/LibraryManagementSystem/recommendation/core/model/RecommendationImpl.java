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
		this.daftarbukuimpl = daftarbukuimpl;
	}

	public RecommendationImpl() { }
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> recommendationMap = new HashMap<String,Object>();
		recommendationMap.put("daftarbukuimpl",getDaftarbukuimpl());

        return recommendationMap;
    }
}
