package com.mks.s3bucket.controller;


import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mks.s3bucket.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MK on 6/2/2017.
 */
@RestController
public class AmazonS3Controller {
    @Autowired
    S3Service s3Service;

    @RequestMapping(value="/api")
    public List<S3ObjectSummary> getObjectInBucket() {
        return s3Service.getObjectInBucket();
    }

    @RequestMapping(value= "/moodledeployables?modified={modified}", method = RequestMethod.GET)
    public Date getBucket(@RequestParam String modified) {
        if(modified.equals("LATEST"){
            return s3Service.getBucket();
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }


}
