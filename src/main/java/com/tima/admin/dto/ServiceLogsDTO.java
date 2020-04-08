package com.tima.admin.dto;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "logs")
public class ServiceLogsDTO {
    @Field
    private String ip;
    @Field
    private String url;
    @Field
    private String httpMethord;
    @Field
    private String classMethod;
    @Field
    private String args;
    @Field
    private  String headInfo;
    @Field
    private String time;




}
