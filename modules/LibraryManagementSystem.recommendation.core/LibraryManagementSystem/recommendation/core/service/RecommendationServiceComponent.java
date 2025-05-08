package LibraryManagementSystem.recommendation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.Buku;

public abstract class RecommendationServiceComponent implements RecommendationService{
	protected RepositoryUtil<Recommendation> recommendationRepository;
    protected RepositoryUtil<Buku> bukuRepository;

    public RecommendationServiceComponent(){
        this.recommendationRepository = new RepositoryUtil<Recommendation>(LibraryManagementSystem.recommendation.core.RecommendationComponent.class);
        this.bukuRepository = new RepositoryUtil<Buku>(LibraryManagementSystem.buku.core.BukuComponent.class);
    }	
   
    public abstract List<HashMap<String,Object>> getAllRecommendation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Recommendation> List);
}
