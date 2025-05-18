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
}
