package com.dsniatecki.sellyourcar.auction;


import com.dsniatecki.sellyourcar.auction.dto.query.AuctionListItemQueryDTO;
import com.dsniatecki.sellyourcar.auction.dto.query.AuctionCompleteQueryDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
                                                 @RequestParam("order") Optional<String> order,
                                                 @RequestParam("direction") Optional<String> direction){
        return auctionQueryService.getPage(
                    PageRequest.of(page.orElse(1) -1,
                        size.orElse(DEFAULT_PAGE_SIZE),
                        Sort.Direction.fromString(direction.orElse("ASC")),
                        order.orElse("creationDate"))
                );
    }

    @GetMapping("/{id}")
    public AuctionCompleteQueryDTO getById(@PathVariable String id){
        return auctionQueryService.getById(id);
    }



}
