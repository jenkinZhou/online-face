package com.jenkin.onlineface.commons.config;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DozerConfig {
    @Bean
    public Mapper mapper(){
        DozerBeanMapper  mapper = new DozerBeanMapper();
        List<String> mappingFileUrls = Lists.newArrayList("dozer-conveter.xml");
         mapper.setMappingFiles(mappingFileUrls);
        return mapper;
    }
}
