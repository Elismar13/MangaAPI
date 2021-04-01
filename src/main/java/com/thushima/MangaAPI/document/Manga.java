package com.thushima.MangaAPI.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Manga_Api_Table")
public class Manga {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBHashKey(attributeName = "name")
    private String name;

    @DynamoDBHashKey(attributeName = "author")
    private String author;

    @DynamoDBHashKey(attributeName = "chapters")
    private Long chapters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Manga(String id, String name, String author, Long chapters) {
        setId(id);
        setName(name);
        setAuthor(author);
        setChapters(chapters);
    }
}
