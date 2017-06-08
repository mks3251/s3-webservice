package com.mks.s3bucket.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mks.s3bucket.Bucket.MoodleDeployment;

import java.util.Date;
import java.util.List;

/**
 * Created by MK on 6/3/2017.
 * Interface class to define all data access methods
 */

public interface S3Service {

    MoodleDeployment getObjectLastModified();

}
