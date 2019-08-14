package com.dsniatecki.sellyourcar.auction.query;


import com.dsniatecki.sellyourcar.auction.query.dto.AuctionCompleteQueryDTO;
import com.dsniatecki.sellyourcar.auction.query.dto.AuctionListItemQueryDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/auctions")
class AuctionQueryController {

    @Value("${values.default.page.size:20}")
    private Integer DEFAULT_PAGE_SIZE;

    private AuctionQueryService auctionQueryService;

    AuctionQueryController(AuctionQueryService auctionQueryService){
        this.auctionQueryService = auctionQueryService;
    }

    @GetMapping("/all")
    public List<AuctionListItemQueryDTO> getAll(){
        return auctionQueryService.getAll();
    }

    @GetMapping("/")
    public Page<AuctionListItemQueryDTO> getPage(@RequestParam("page") Optional<Integer> page,
                                                 @RequestParam("size") Optional<Integer> size,
                                                 @RequestParam("order") Optional<String> order){
        return auctionQueryService.getPage(
                    PageRequest.of(page.orElse(1) -1, size.orElse(DEFAULT_PAGE_SIZE),
                            Sort.by(Sort.Order.desc("isPremium"), Sort.Order.asc(order.orElse("creationDate"))))
                );
    }

    @GetMapping("/search/{word}")
    public Page<AuctionListItemQueryDTO> getPageBy(@PathVariable String word,
                                                   @RequestParam("page") Optional<Integer> page,
                                                   @RequestParam("size") Optional<Integer> size,
                                                   @RequestParam("direction") Optional<String> order){
        return auctionQueryService.getPageBy(word,
                PageRequest.of(page.orElse(1) -1, size.orElse(DEFAULT_PAGE_SIZE),
                            Sort.by(Sort.Order.desc("isPremium"), Sort.Order.asc(order.orElse("creationDate"))))
        );
    }

    @GetMapping("/{id}")
    public AuctionCompleteQueryDTO getById(@PathVariable String id){
        return auctionQueryService.getById(id);
    }

}
