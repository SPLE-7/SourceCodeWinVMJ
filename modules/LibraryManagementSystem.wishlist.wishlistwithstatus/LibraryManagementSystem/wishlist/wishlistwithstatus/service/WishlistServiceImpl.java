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
  
        // Buku buku = this.record.createBuku(requestBody);
  
        String status = (String) requestBody.get("status");
        
        System.out.println("status: " + status);

        Wishlist wishlistStatus = WishlistFactory.createWishlist(
          "LibraryManagementSystem.wishlist.wishlistwithstatus.WishlistImpl"
        , record.createWishlist(requestBody)
        , status
        );

        System.out.println("wishlistNote: " + wishlistStatus);

        wishlistRepository.saveObject(wishlistStatus);
        return wishlistStatus;
    }
}
