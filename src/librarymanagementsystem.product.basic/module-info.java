module librarymanagementsystem.product.basic {
    requires vmj.auth.model;
    requires vmj.routing.route;
    requires vmj.hibernate.integrator;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires LibraryManagementSystem.buku.core;
    requires LibraryManagementSystem.buku.bukufisik;
    requires LibraryManagementSystem.statistik.core;
    requires LibraryManagementSystem.statistik.genrestatistik;
    requires LibraryManagementSystem.peminjamanbuku.core;
    requires LibraryManagementSystem.review.core;
    requires LibraryManagementSystem.review.reviewkomentar;
    requires LibraryManagementSystem.wishlist.core;
    requires LibraryManagementSystem.wishlist.wishlistwithstatus;
    requires LibraryManagementSystem.recommendation.core;
    requires LibraryManagementSystem.recommendation.recommendationbygenre;

}