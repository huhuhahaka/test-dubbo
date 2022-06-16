package com.example.consumer.entry;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 用户类。
 * @author ggl
 */
@Document(indexName = "user")
public class User {

    @Id
    @NotNull(message = "ID 不能为空")
    /**
     * 用户 ID
     */
    private Integer id;

    @Field(type = FieldType.Keyword)
    @NotEmpty(message = "姓名不能为空")
    /**
     * 姓名
     */
    private String name;

    @Field(type = FieldType.Auto)
    @Min(value = 1,message = "年龄不能小于 1 岁")
    /**
     * 年龄
     */
    private Integer age;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    @Size(max = 200, message = "个人信息不能超过 200 字")
    /**
     * 个人信息
     */
    private String info;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
