package LibraryManagementSystem.wishlist.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import LibraryManagementSystem.buku.core.Buku;
import vmj.auth.model.core.User;

@Entity
@Table(name = "wishlist_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class WishlistComponent implements Wishlist {
    @Id
    public UUID idWishlist;

	// TODO: Import external library 
    @ManyToOne(targetEntity = vmj.auth.model.core.UserComponent.class)
    public User akunimpl;

    @ManyToOne(targetEntity = LibraryManagementSystem.buku.core.BukuComponent.class)
    public Buku daftarbukuimpl;

    protected String objectName = WishlistComponent.class.getName();

    public WishlistComponent() {}

    public WishlistComponent(User akunimpl, Buku daftarbukuimpl) {
        this.akunimpl = akunimpl;
        this.daftarbukuimpl = daftarbukuimpl;
    }

    public User getAkunimpl() {
		return this.akunimpl;
	}

	public void setAkunimpl(User akunimpl) {
		this.akunimpl = akunimpl;
	}

    public Buku getDaftarbukuimpl() {
		return this.daftarbukuimpl;
	}

	public void setDaftarbukuimpl(Buku daftarbukuimpl) {
		this.daftarbukuimpl = daftarbukuimpl;
	}

    @Override
    public String toString() {
        return "{" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            "}";
    }
}