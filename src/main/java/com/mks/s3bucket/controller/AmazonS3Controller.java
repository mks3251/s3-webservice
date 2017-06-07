package com.mks.s3bucket.controller;


import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mks.s3bucket.service.S3Service;
import com.mks.s3bucket.service.impl.S3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by MK on 6/2/2017.
 */
@RestController
public class AmazonS3Controller {
    @Autowired
    S3Service s3Service;

    @RequestMapping(value="/api")
    public String getObjectInBucket() {
        return s3Service.getObjectInBucket();
    }

    @RequestMapping(value="/moodledeployables", method = RequestMethod.GET)
    public Date getObjectLastModified (@RequestParam String modified) {
        if (modified.contentEquals("LATEST"))
        {
            return s3Service.getBucket();
        }
        else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

    }


}
