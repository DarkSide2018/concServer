package com.concurrent;

import com.concurrent.config.CascadeSaveMongoEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableMongoRepositories("com.concurrent.repository")
public class ConcurrentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConcurrentApplication.class, args);
     }
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
                                       MongoMappingContext context) {

        MappingMongoConverter converter =
                new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return new MongoTemplate(mongoDbFactory, converter);

    }
    @Bean
    public CascadeSaveMongoEventListener userCascadingMongoEventListener() {
        return new CascadeSaveMongoEventListener();
    }
}



