package com.ttlabs.server.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.ttlabs.server.models.Time;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * Service controller to convert at UTC time
 */
@RestController
public class TimeController {

   
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   
    public @ResponseBody Time UtcTimeService(@DateTimeFormat(pattern = "HH:mm") @RequestParam("time") LocalTime time,

            @RequestParam(required = true, defaultValue = "-4") int timezone) {

        Time ntime = new Time();
        
        ntime.setTime(toUtcLocalTime(time, timezone));
        ntime.setTimezone("utc");

        return ntime;

    }


    public static LocalTime toUtcLocalTime(LocalTime time, int timezone) {

        /* "Current  time in a particular timezone : " */
        ZoneId zone = ZoneId.of("UTC" + timezone);
        ZonedDateTime zoneTime = time.atDate(LocalDate.now()).atZone(zone);

        /* "Current  time in utc : " */
        ZonedDateTime utcTime = zoneTime.withZoneSameInstant(ZoneOffset.UTC);

        return utcTime.toLocalTime();

    }
}