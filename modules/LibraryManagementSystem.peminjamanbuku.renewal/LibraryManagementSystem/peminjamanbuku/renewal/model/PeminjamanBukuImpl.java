package LibraryManagementSystem.peminjamanbuku.renewal;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuDecorator;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBuku;
import LibraryManagementSystem.peminjamanbuku.core.PeminjamanBukuComponent;

@Entity(name="peminjamanbuku_renewal")
@Table(name="peminjamanbuku_renewal")
public class PeminjamanBukuImpl extends PeminjamanBukuDecorator {

	public int renewalCount;
	public PeminjamanBukuImpl() {
        super();
        this.objectName = PeminjamanBukuImpl.class.getName();
    }
    
    public PeminjamanBukuImpl(int renewalCount) {
    	super();
		this.renewalCount = renewalCount;
		this.objectName = PeminjamanBukuImpl.class.getName();
    }
	
	public PeminjamanBukuImpl(PeminjamanBukuComponent record, int renewalCount) {
		super(record);
		this.renewalCount = renewalCount;
		this.objectName = PeminjamanBukuImpl.class.getName();
	}
  
	public int getRenewalCount() {
		return this.renewalCount;
	}

	public void setRenewalCount(int renewalCount) {
		this.renewalCount = renewalCount;
	}

	@Override
    public String toString() {
        return "{" +
            " idPeminjamanBuku='" + getIdPeminjamanBuku() + "'" +
            " status='" + getStatus() + "'" +
            " akunimpl='" + getAkunimpl() + "'" +
            " daftarbukuimpl='" + getDaftarbukuimpl() + "'" +
            " tanggalPeminjaman='" + getTanggalPeminjaman() + "'" +
            " tanggalPengembalian='" + getTanggalPengembalian() + "'" +
			" renewalCount='" + getRenewalCount() + "'" +
            "}";
    }
	
	@Override
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> peminjamanbukuMap = new HashMap<String,Object>();
		peminjamanbukuMap.put("idPeminjamanBuku",getIdPeminjamanBuku());
		peminjamanbukuMap.put("status",getStatus());
		peminjamanbukuMap.put("akunimpl",getAkunimpl());
		peminjamanbukuMap.put("daftarbukuimpl",getDaftarbukuimpl());
		peminjamanbukuMap.put("tanggalPeminjaman",getTanggalPeminjaman());
		peminjamanbukuMap.put("tanggalPengembalian",getTanggalPengembalian());
		peminjamanbukuMap.put("renewalCount",getRenewalCount());

        return peminjamanbukuMap;
    }
}
