package com.mks.s3bucket.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import org.springframework.stereotype.Service;

/**
 * Created by MK on 6/3/2017.
 */
@Service
public class S3Service {

    public void getObjectsInBucket() {
        String bucketName = "moodle-elasticbeanstalk-deployables-us-east-1";
        String key        = "moodle/moodledeployment64.zip";
        String prefix 	  = "moodle/";
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIAJXPJEZA7OJSFQOUQ",
                "po9/irZPytz81QZdV8YfxrhKWTKMDxrX1ErMTGDm");
        AmazonS3Client s3Client = new AmazonS3Client(awsCredentials);

        try {

			/*
             * List objects in your bucket by prefix - There are many options for
             * listing the objects in your bucket.  Keep in mind that buckets with
             * many objects might truncate their results when listing their objects,
             * so be sure to check if the returned object listing is truncated, and
             * use the AmazonS3.listNextBatchOfObjects(...) operation to retrieve
             * additional results.
             */
            System.out.println("Listing objects");
            ObjectListing objectListing = s3Client.listObjects(new ListObjectsRequest()
                    .withBucketName(bucketName).withPrefix(prefix));
            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println(" - " + objectSummary.getKey() + "  " +
                        "(size = " + objectSummary.getSize() + ")" + " " + objectSummary.getLastModified());
            }
            System.out.println();
			/*
             * Download an object - When you download an object, you get all of
             * the object's metadata and a stream from which to read the contents.
             * It's important to read the contents of the stream as quickly as
             * possibly since the data is streamed directly from Amazon S3 and your
             * network connection will remain open until you read all the data or
             * close the input stream.
             *
             * GetObjectRequest also supports several other options, including
             * conditional downloading of objects based on modification times,
             * ETags, and selectively downloading a range of an object.
             */
            System.out.println("Downloading an object");
            S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, key));
            System.out.println("Object: "  + object.getKey());
            System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
            System.out.println("Last-Modified: "  + object.getObjectMetadata().getLastModified());





        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it "
                    + "to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
    }




}
