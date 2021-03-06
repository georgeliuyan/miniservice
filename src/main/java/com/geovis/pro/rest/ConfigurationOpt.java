package com.geovis.pro.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geovis.pro.common.ResultEntity;
import com.geovis.pro.config.ApplicationProperties;
import com.geovis.pro.config.LocalConfigProperties;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rest")
@Api("miniService api")
public class ConfigurationOpt {
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	@Autowired
	LocalConfigProperties localConfigProperties;
	
	@Value("${spring.datasource.url}")
	private String DatabaseUrl;
	
	@ApiOperation(value = "getconfig", notes = "getconfig")
	@GetMapping("/getconfig")
	@ResponseBody
    public ResultEntity getConfig(){
		System.out.println("DATABASE URL IS : "+DatabaseUrl);
		return ResultEntity.success(applicationProperties);
    }
	
	@ApiOperation(value = "getLocalConfig", notes = "getLocalConfig")
	@GetMapping("/getLocalConfig")
	@ResponseBody
    public ResultEntity getLocalConfig(){
		System.out.println("filename is : "+localConfigProperties.getFilename());
		return ResultEntity.success(localConfigProperties.getFilename());
    }


}
