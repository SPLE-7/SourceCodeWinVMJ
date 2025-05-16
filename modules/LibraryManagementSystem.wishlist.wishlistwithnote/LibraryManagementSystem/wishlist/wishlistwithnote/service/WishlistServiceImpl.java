package LibraryManagementSystem.wishlist.wishlistwithnote;

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

    public void updateNote(UUID bookId, String newNotes) {
      // TODO: implement this method
    }

    public Wishlist createWishlistNotes(Map<String, Object> requestBody){
    
        String notes = (String) requestBody.get("notes");
        
        Wishlist wishlistNotes = WishlistFactory.createWishlist(
          "LibraryManagementSystem.wishlist.wishlistwithnote.WishlistImpl"
        , record.createWishlist(requestBody)
        , notes
        );

        wishlistRepository.saveObject(wishlistNotes);
        return wishlistNotes;
    }

    public List<HashMap<String,Object>> getAllWishlistNotes(Map<String, Object> requestBody){
      String table = "wishlist_wishlistwithnote";
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

    public HashMap<String, Object> getWishlistNotes(Map<String, Object> requestBody){
      List<HashMap<String, Object>> wishlistList = getAllWishlistNotes(requestBody);
      UUID idRequest = UUID.fromString((String) requestBody.get("idWishlist"));
      for (HashMap<String, Object> wishlist : wishlistList){
        UUID recordId = (UUID) wishlist.get("idWishlist");
        if (recordId.equals(idRequest)) {
          return wishlist;
        }
      }
      return null;
    }

    public List<HashMap<String,Object>> deleteWishlistNotes(Map<String, Object> requestBody){
      HashMap<String, Object> wishlist = getWishlistNotes(requestBody);
      UUID recordId = (UUID) wishlist.get("base_component_id");
      wishlistRepository.deleteObject(recordId);
      return getAllWishlistNotes(requestBody);
    }
}
