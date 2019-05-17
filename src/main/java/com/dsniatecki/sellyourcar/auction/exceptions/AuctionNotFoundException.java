package com.dsniatecki.sellyourcar.auction.exceptions;


public class AuctionNotFoundException extends RuntimeException {
    public AuctionNotFoundException(){
        super();
    }
    public AuctionNotFoundException(String message){
        super(message);
    }
    public AuctionNotFoundException(String message, Throwable cause){
        super( message, cause);
    }
}
