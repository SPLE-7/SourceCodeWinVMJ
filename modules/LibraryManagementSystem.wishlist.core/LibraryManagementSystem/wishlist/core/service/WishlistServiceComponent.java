package LibraryManagementSystem.wishlist.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

public abstract class WishlistServiceComponent implements WishlistService{
	protected RepositoryUtil<Wishlist> wishlistRepository;
    protected RepositoryUtil<Buku> bukuRepository;
    protected RepositoryUtil<User> userRepository;


    public WishlistServiceComponent(){
        this.wishlistRepository = new RepositoryUtil<Wishlist>(LibraryManagementSystem.wishlist.core.WishlistComponent.class);
        this.bukuRepository = new RepositoryUtil<Buku>(LibraryManagementSystem.buku.core.BukuComponent.class);
        this.userRepository = new RepositoryUtil<User>(vmj.auth.model.core.UserComponent.class);
    }	

    public abstract Wishlist createWishlist(Map<String, Object> requestBodye);
    public abstract HashMap<String, Object> getWishlist(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllWishlist(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Wishlist> List);
    public abstract List<HashMap<String,Object>> deleteWishlist(Map<String, Object> requestBody);

}
