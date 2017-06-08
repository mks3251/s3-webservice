package com.mks.s3bucket.controller;


import com.mks.s3bucket.Bucket.MoodleDeployment;
import com.mks.s3bucket.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by MK on 6/2/2017.
 */
@RestController
public class AmazonS3Controller {

    //The autowired tag injects a "bean" (a spring bean)
    //the bean is an instance of a S3Service object
    //s3Service is an implementation of the S3ServiceImpl
    @Autowired
    S3Service s3Service;

    //The request mapping dictates where the method is exposed.
    //in this case, when deployed locally, you would hit this
    //method at: localhost:8080/moodledeployables?modified=LATEST
    @RequestMapping(value="/moodledeployables", method = RequestMethod.GET)
    public MoodleDeployment getObjectLastModified (@RequestParam String modified) {
        if (modified.contentEquals("LATEST"))
        {
            return s3Service.getObjectLastModified();
        }
        else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

    }


}
