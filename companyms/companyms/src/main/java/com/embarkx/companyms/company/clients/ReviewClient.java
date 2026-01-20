package com.embarkx.companyms.company.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="reviewms",
        url="${reviewms-url}")
//@FeignClient(name = "reviewms", url = "${reviewms.url:http://reviewms:8083}")
public interface ReviewClient {

    @GetMapping("/reviews/averageRating")
    public Double getAverageRatingForCompany(@RequestParam("companyID") Long companyId);

}
