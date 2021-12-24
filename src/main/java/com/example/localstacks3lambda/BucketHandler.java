package com.example.localstacks3lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.model.S3Object;
import com.example.localstacks3lambda.s3.S3Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Component
public class BucketHandler implements RequestHandler<S3Event, String> {

    @Autowired
    private S3Repository repository;

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        String bucket = s3Event.getRecords().get(0).getS3().getBucket().getName();

        String key = s3Event.getRecords().get(0).getS3().getObject().getKey();

        context.getLogger().log("contextLogger: "+bucket+key);
        log.info("sl4j log: " + bucket+key);
        if(repository==null){
            log.info("repository is null");
        } else {
            log.info("repository is not null");
        }

        S3Object obj = repository.getObject(bucket, key);
        try (InputStream stream = obj.getObjectContent()) {
            // TODO: Do something with the file contents here
            stream.transferTo(System.out);
            System.out.println();
        } catch (IOException ioe) {
            //throw ioe;
            ioe.printStackTrace();
        }

        return obj.getObjectMetadata().getContentType();
    }
}
