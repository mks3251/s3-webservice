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

    @Autowired
    S3Service s3Service;

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
