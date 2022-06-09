package com.example.consumer.repository;

import com.example.consumer.entry.User;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsUserRepository extends ElasticsearchRepository<User, Integer> {

    //根据name查询
    List<User> findByName(String name);

    //根据name查询
    List<User> findByInfo(String info);

    //根据name和info查询
    List<User> findByNameAndInfo(String name, String info);

}
