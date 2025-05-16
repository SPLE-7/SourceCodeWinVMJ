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
  
        // Buku buku = this.record.createBuku(requestBody);
  
        String notes = (String) requestBody.get("notes");
        
        System.out.println("notes: " + notes);

        Wishlist wishlistNotes = WishlistFactory.createWishlist(
          "LibraryManagementSystem.wishlist.wishlistwithnote.WishlistImpl"
        , record.createWishlist(requestBody)
        , notes
        );

        System.out.println("wishlistNote: " + wishlistNotes);

        wishlistRepository.saveObject(wishlistNotes);
        return wishlistNotes;
    }
}
