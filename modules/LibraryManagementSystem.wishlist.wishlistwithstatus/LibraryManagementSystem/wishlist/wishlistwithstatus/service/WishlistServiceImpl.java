package LibraryManagementSystem.wishlist.wishlistwithstatus;

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

	public Wishlist createWishlistStatus(Map<String, Object> requestBody){
  
        Wishlist wishlist = this.record.createWishlist(requestBody);
  
        String status = (String) requestBody.get("status");
        
        Wishlist wishlistwithstatus = WishlistFactory.createWishlist(
          "LibraryManagementSystem.wishlist.wishlistwithstatus.WishlistImpl"
        , wishlist
        , status
        );
        wishlistRepository.saveObject(wishlistwithstatus);
        return wishlistwithstatus;
    
    }
}
