package LibraryManagementSystem.wishlist.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface WishlistService {
	Wishlist createWishlist(Map<String, Object> requestBody);
	HashMap<String, Object> getWishlist(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Wishlist> List);
}
