package LibraryManagementSystem.recommendation.recommendationbygenre;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.recommendation.core.RecommendationResourceDecorator;
import LibraryManagementSystem.recommendation.core.RecommendationImpl;
import LibraryManagementSystem.recommendation.core.RecommendationResourceComponent;
import LibraryManagementSystem.recommendation.core.RecommendationServiceComponent;

import LibraryManagementSystem.buku.core.Buku;

public class RecommendationResourceImpl extends RecommendationResourceDecorator {
    private RecommendationServiceImpl recommendationServiceImpl;

	public RecommendationResourceImpl (RecommendationResourceComponent record, RecommendationServiceComponent recommendationServiceComponent) {
        super(record);
		this.recommendationServiceImpl = new RecommendationServiceImpl(recommendationServiceComponent);
    }

	// @Restriced(permission = "")
    @Route(url="call/recommendationbygenre/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return recommendationServiceImpl.getAllRecommendation(vmjExchange.getPayload());
	}

	public List<Buku> generateRecommendationGenre() {
		return recommendationServiceImpl.generateRecommendationGenre();
	}
}
