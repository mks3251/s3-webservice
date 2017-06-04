package com.mks.s3bucket.controller;

import com.mks.s3bucket.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.JavaLangAccess;

/**
 * Created by MK on 6/2/2017.
 */
@RestController
public class AmazonS3Controller {
    @Autowired
    S3Service s3Service;

    @RequestMapping(method= RequestMethod.GET, value = "/moodledeployables?modified=LATEST")
    public void getObjectsInBucket() {
        s3Service.getObjectsInBucket();
    }



}
