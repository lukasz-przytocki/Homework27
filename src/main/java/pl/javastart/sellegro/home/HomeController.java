package pl.javastart.sellegro.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.sellegro.auction.Auction;
import pl.javastart.sellegro.auction.AuctionRepositiry;


import java.util.List;

@Controller
public class HomeController {

    private AuctionRepositiry auctionRepositiry;

    public HomeController(AuctionRepositiry auctionRepositiry) {
        this.auctionRepositiry = auctionRepositiry;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Auction> auctions = auctionRepositiry.findFourMostExpensive();
        model.addAttribute("cars", auctions);
        return "home";
    }
}
