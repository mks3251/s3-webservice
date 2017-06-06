package com.mks.s3bucket.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;

/**
 * Created by MK on 6/3/2017.
 */
public interface S3Service {
    S3Object getBucket();


}
