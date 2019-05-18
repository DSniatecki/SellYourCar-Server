package com.dsniatecki.sellyourcar.auction.command;

import com.dsniatecki.sellyourcar.auction.command.dto.AuctionCreationCommandDTO;
import com.dsniatecki.sellyourcar.auction.model.Auction;
import com.dsniatecki.sellyourcar.auction.tool.AuctionTestGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.verify;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("AuctionCommandServiceUnitTest - Unit Tests")
class AuctionCommandServiceUnitTest {

    @Autowired
    private AuctionCommandService auctionCommandService;

    @MockBean
    private AuctionCommandRepository auctionCommandRepository;

    @Test
    @DisplayName("addNew() - SUCCESS")
    void shouldAddNew() {
        AuctionCreationCommandDTO auctionDTO= AuctionTestGenerator.generateAuctionCreateCommandDTO();
        ArgumentCaptor<Auction> argument = ArgumentCaptor.forClass(Auction.class);

        auctionCommandService.addNew(auctionDTO);

        verify(auctionCommandRepository).save(argument.capture());

        assertAll(
                ()->Assertions.assertSame(argument.getValue().getId(), null),
                ()->Assertions.assertSame(argument.getValue().getIsPremium(), false),
                ()->Assertions.assertSame(argument.getValue().getIsDeleted(), false),
                ()->Assertions.assertEquals(argument.getValue().getTitle(), auctionDTO.getTitle()),
                ()->Assertions.assertEquals(argument.getValue().getPrice(), auctionDTO.getPrice()),
                ()->Assertions.assertSame(argument.getValue().getCar().getId(), null),
                ()->Assertions.assertEquals(argument.getValue().getCar().getBrand(), auctionDTO.getCar().getBrand()),
                ()->Assertions.assertEquals(argument.getValue().getCar().getModel(), auctionDTO.getCar().getModel()),
                ()->Assertions.assertEquals(argument.getValue().getCar().getMileage(),
                        auctionDTO.getCar().getMileage()),
                ()->Assertions.assertSame(argument.getValue().getOwner().getId(), null),
                ()->Assertions.assertSame(argument.getValue().getOwner().getUsername(),
                        auctionDTO.getOwner().getUsername()),
                ()->Assertions.assertSame(argument.getValue().getLocation().getId(), null),
                ()->Assertions.assertEquals(argument.getValue().getLocation().getCountry(),
                        auctionDTO.getLocation().getCountry())
        );
    }

}