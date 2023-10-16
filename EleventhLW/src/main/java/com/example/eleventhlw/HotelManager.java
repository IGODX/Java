package com.example.eleventhlw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HotelManager {
    private Map<String, HotelDetails> detailsMap = new HashMap<>();

    public HotelManager(){
        detailsMap.put("Hotel1", new HotelDetails(Arrays.asList("Some additional info1"), "Short desc1"));
        detailsMap.put("Hotel2", new HotelDetails(Arrays.asList("Some additional info2"), "Short desc2"));
        detailsMap.put("Hotel3", new HotelDetails(Arrays.asList("Some additional info3"), "Short desc3"));
    }

    public HotelDetails getHotelDetails(String hotelName){
        return detailsMap.get(hotelName);
    }
}
