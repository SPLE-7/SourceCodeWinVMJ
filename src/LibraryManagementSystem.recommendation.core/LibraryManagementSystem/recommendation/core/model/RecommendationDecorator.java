package LibraryManagementSystem.recommendation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class RecommendationDecorator extends RecommendationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected RecommendationComponent record;

	public RecommendationDecorator () {
		super();
		this.record = record;
    this.idRecommendation =  idRecommendation.randomUUID();
	}
  
  public RecommendationDecorator (UUID idRecommendation, RecommendationComponent record) {
		this.record = record;
    this.idRecommendation =  idRecommendation;
	}
		
	public RecommendationDecorator (RecommendationComponent record) {
		this.record = record;
    this.idRecommendation =  idRecommendation.randomUUID();
	}
	
	public RecommendationDecorator (RecommendationComponent record, String objectName) {
		this.record = record;	
		this.objectName=objectName;
    this.idRecommendation =  idRecommendation.randomUUID();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
