package com.mks.s3bucket.controller;


import com.amazonaws.services.s3.model.S3Object;
import com.mks.s3bucket.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MK on 6/2/2017.
 */
@RestController
public class AmazonS3Controller {
    @Autowired
    S3Service s3Service;

    @RequestMapping("/api")
    public S3Object getBucket() {
        return s3Service.getBucket();
    }


}
