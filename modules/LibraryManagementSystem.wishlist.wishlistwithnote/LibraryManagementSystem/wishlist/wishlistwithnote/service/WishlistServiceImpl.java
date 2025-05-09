package LibraryManagementSystem.wishlist.wishlistwithnote;

import java.util.*;

import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.wishlist.core.WishlistServiceDecorator;
import LibraryManagementSystem.wishlist.WishlistFactory;
import LibraryManagementSystem.wishlist.core.Wishlist;
import LibraryManagementSystem.wishlist.core.WishlistImpl;
import LibraryManagementSystem.wishlist.core.WishlistServiceComponent;

public class WishlistServiceImpl extends WishlistServiceDecorator {
    public WishlistServiceImpl (WishlistServiceComponent record) {
        super(record);
    }

    public Wishlist createWishlistNote(Map<String, Object> requestBody){
  
        Wishlist wishlist = this.record.createWishlist(requestBody);
  
        String notes = (String) requestBody.get("notes");
        
        //to do: fix association attributes
        Wishlist wishlistwithnote = WishlistFactory.createWishlist(
          "LibraryManagementSystem.wishlist.wishlistwithnote.WishlistImpl"
        , wishlist
        , notes
        );
        wishlistRepository.saveObject(wishlistwithnote);
        return wishlistwithnote;
    
    }
}
