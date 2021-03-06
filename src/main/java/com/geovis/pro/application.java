package com.geovis.pro;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication  
/*
 * Spring Boot 应用标注某个类上说明这个类是SpringBoot主配置类,注解包括如下：
 * 
 * @SpringBootConfiguration ：Spring Boot配置类，标注上某个类上，表示这个一个SpringBoot 配置类
 * @EnableAutoConfiguration ：开启自动配置功能，以前需要配置的东西，SpringBoot帮我们自动配置；
 * @ComponentScan(excludeFilters={@Filter(type=CUSTOM, classes={TypeExcludeFilter.class})})
 * @Target(value={TYPE})
 * @Retention(value=RUNTIME)
 * @Documented
 * @Inherited
 */
@EnableCaching //打开redis缓存机制，主要用于@Cacheable @CacheEvict等注释功能
//@ServletComponentScan
public class application {
	
 	public static void main(String[] args) {
 		SpringApplication.run(application.class, args);
 	}
 	
 	@PostConstruct
 	public void func1(){
 		System.out.println("[" + new Date()+"] start program ... ");
 	}
 	
 	@PreDestroy
 	public void func2(){
 		System.out.println("[" + new Date()+"] end program ... ");
 	}
}
