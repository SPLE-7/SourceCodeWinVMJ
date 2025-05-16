package LibraryManagementSystem.wishlist.wishlistwithstatus;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.wishlist.core.WishlistServiceDecorator;
import LibraryManagementSystem.wishlist.core.WishlistImpl;
import LibraryManagementSystem.wishlist.WishlistFactory;
import LibraryManagementSystem.wishlist.core.Wishlist;
import LibraryManagementSystem.wishlist.core.WishlistServiceComponent;

public class WishlistServiceImpl extends WishlistServiceDecorator {
    public WishlistServiceImpl (WishlistServiceComponent record) {
        super(record);
    }

	public void updateStatus(UUID bookId, String newStatus) {
		// TODO: implement this method
	}

    public Wishlist createWishlistStatus(Map<String, Object> requestBody){
    
        String status = (String) requestBody.get("status");
        
        Wishlist wishlistStatus = WishlistFactory.createWishlist(
          "LibraryManagementSystem.wishlist.wishlistwithstatus.WishlistImpl"
        , record.createWishlist(requestBody)
        , status
        );

        wishlistRepository.saveObject(wishlistStatus);
        return wishlistStatus;
    }

    public List<HashMap<String,Object>> getAllWishlistStatus(Map<String, Object> requestBody){
        String table = "wishlist_wishlistwithstatus";
        List<Wishlist> List = wishlistRepository.getAllObject(table);
        return this.transformListToHashMap(List);
      }
    
        public List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
            for(int i = 0; i < List.size(); i++) {
                resultList.add(List.get(i).toHashMap());
            }
    
            return resultList;
      }
  
      public HashMap<String, Object> getWishlistStatus(Map<String, Object> requestBody){
        List<HashMap<String, Object>> wishlistList = getAllWishlistStatus(requestBody);
        for (HashMap<String, Object> wishlist : wishlistList){
          UUID recordId = (UUID) wishlist.get("idWishlist");
          if (recordId.equals(requestBody.get("idWishlist"))) {
            return wishlist;
          }
        }
        return null;
      }
  
      public List<HashMap<String,Object>> deleteWishlistStatus(Map<String, Object> requestBody){
        HashMap<String, Object> wishlist = getWishlistStatus(requestBody);
        UUID recordId = (UUID) wishlist.get("base_component_id");
        wishlistRepository.deleteObject(recordId);
        return getAllWishlistStatus(requestBody);
      }
}
