package com.thushima.MangaAPI.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import io.netty.util.internal.StringUtil;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories

public class DynamoConfig {
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${aws_access_key_id}")
    private String amazonAWSAccessKey;

    @Value("${aws_secret_access_key}")
    private String AmazonAWSSecretKey;

    @Bean()
    public AmazonDynamoDB amazonDynamoDB () {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredential());
        if(!StringUtil.isNullOrEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }

    @Bean()
    public AWSCredentials amazonAWSCredential () {
        return new BasicAWSCredentials(amazonAWSAccessKey, AmazonAWSSecretKey);
    }
}
