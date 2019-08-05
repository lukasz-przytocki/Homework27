package pl.javastart.sellegro.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuctionController {

    private AuctionRepositiry auctionRepositiry;


    public AuctionController(AuctionRepositiry auctionRepositiry) {
        this.auctionRepositiry = auctionRepositiry;
    }

    @GetMapping("/auctions")
    public String auctions(Model model,
                           @RequestParam(required = false) String sort,
                           String auctionFilters) {
        List<Auction> auctions;

        if (sort==null) {
            auctions = auctionRepositiry.findAll();
        }else if (auctionFilters.contains("title")) {
            auctions = auctionRepositiry.findAllByOrderByTitle();
        } else if (auctionFilters.contains("carMaker")) {
            auctions = auctionRepositiry.findAllByOrderByCarMake();
        } else if (auctionFilters.contains("carModel")) {
            auctions = auctionRepositiry.findAllByOrderByCarModel();
        } else {
            auctions = auctionRepositiry.findAllByOrderByColor();
        }

        model.addAttribute("cars", auctions);
        model.addAttribute("filters", auctionFilters);
        return "auctions";
    }
}
