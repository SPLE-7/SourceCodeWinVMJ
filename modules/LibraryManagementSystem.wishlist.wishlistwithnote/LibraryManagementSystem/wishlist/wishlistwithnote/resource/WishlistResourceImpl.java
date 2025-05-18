package LibraryManagementSystem.wishlist.wishlistwithnote;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.wishlist.core.WishlistResourceDecorator;
import LibraryManagementSystem.wishlist.core.WishlistImpl;
import LibraryManagementSystem.wishlist.core.WishlistResourceComponent;
import LibraryManagementSystem.wishlist.core.WishlistServiceComponent;

public class WishlistResourceImpl extends WishlistResourceDecorator {
    private WishlistServiceImpl wishlistServiceImpl;
	public WishlistResourceImpl (WishlistResourceComponent record, WishlistServiceComponent wishlistServiceComponent) {
        super(record);
		this.wishlistServiceImpl = new WishlistServiceImpl(wishlistServiceComponent);
    }

    // @Restriced(permission = "")
    @Route(url="call/wishlistwithnote/create")
    public HashMap<String, Object> create(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		return wishlistServiceImpl.createWishlistNotes(vmjExchange.getPayload()).toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/wishlistwithnote/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		return wishlistServiceImpl.getAllWishlistNotes(vmjExchange.getPayload());
	}
}
