package pl.javastart.sellegro.auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepositiry extends JpaRepository<Auction,Long>{

    @Query(value = "select * from Auction order by Price DESC LIMIT 4", nativeQuery = true)
    List<Auction> findFourMostExpensive();

    List<Auction> findAllByOrderByTitle();

    List<Auction> findAllByOrderByCarMake();

    List<Auction> findAllByOrderByCarModel();

    List<Auction> findAllByOrderByColor();

}
