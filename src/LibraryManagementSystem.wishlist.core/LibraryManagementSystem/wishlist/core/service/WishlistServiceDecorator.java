package LibraryManagementSystem.wishlist.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class WishlistServiceDecorator extends WishlistServiceComponent{
	protected WishlistServiceComponent record;

    public WishlistServiceDecorator(WishlistServiceComponent record) {
        this.record = record;
    }

	public Wishlist createWishlist(Map<String, Object> requestBody){
		return record.createWishlist(requestBody);
	}

	public HashMap<String, Object> getWishlist(Map<String, Object> requestBody){
		return record.getWishlist(requestBody);
	}

	public List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody){
		return record.getAllWishlist(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody){
		return record.deleteWishlist(requestBody);
	}
}
