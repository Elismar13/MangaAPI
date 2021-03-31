package com.thushima.MangaAPI.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.thushima.MangaAPI.constans.MangaConstant.ENDPOINT_DYNAMO;
import static com.thushima.MangaAPI.constans.MangaConstant.REGION_DYNAMO;

public class MangaData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Manga_Api_Table");

        Item manga = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Fairy Tail")
                .withString("author", "Hiro Mashima")
                .withNumber("chapters", 546);

        Item manga2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Tokyo Ghoul")
                .withString("author", "Sui Ishida")
                .withNumber("chapters", 143);

        Item manga3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Shingeki no Kyojin")
                .withString("author", "Hajime Isayama")
                .withNumber("chapters", 138);

        PutItemOutcome outcome1 = table.putItem(manga);
        PutItemOutcome outcome2 = table.putItem(manga2);
        PutItemOutcome outcome3 = table.putItem(manga3);
    }
}
