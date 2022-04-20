package com.fazliddin.library.services;

import com.fazliddin.library.entity.Discount;
import com.fazliddin.library.enums.WeekdaysNameEnum;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author Fazliddin Xamdamov
 * @date 18.04.2022  14:56
 * @project app-fast-food
 */
@Service
public class CommonServices {

    public static WeekdaysNameEnum getCurrentWeekdayName(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        WeekdaysNameEnum[] values = WeekdaysNameEnum.values();
        return values[--day];
    }

    public static boolean validateDiscount(Discount discount) {
        return discount.isActive() && discount.getExpireTime().after(new Timestamp(System.currentTimeMillis())) &&
                discount.getStartTime().before(new Timestamp(System.currentTimeMillis()));
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return (dist * 1000);
    }

    // create

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
