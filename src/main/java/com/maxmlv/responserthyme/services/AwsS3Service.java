package com.maxmlv.responserthyme.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class AwsS3Service {
    final String bucket = System.getenv("AWS_S3_BUCKET");
    final AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();



    public String getObjectUrl(String key) {
        return "https://" + bucket + ".s3." + s3Client.getBucketLocation(bucket) + ".amazonaws.com/" + key;
    }
    public String uploadObject(File file) {
        UUID uuid = UUID.randomUUID();
        String key = uuid.toString() + "_" + file.getName();
        s3Client.putObject(bucket, key, file);
        return key;
    }

    public void deleteObject(String key) {
        s3Client.deleteObject(bucket, key);
    }
}
