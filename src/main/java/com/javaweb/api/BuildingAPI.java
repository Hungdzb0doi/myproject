package com.javaweb.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.Bean.BuildingDTO;
import com.javaweb.Bean.ErrorResponeDTO;
import com.javaweb.Service.BuildingService;

import CostumException.CheckNullException;
import java.sql.*;
 

@RestController
public class BuildingAPI {
	@Autowired
	BuildingService buildingService;
	@RequestMapping(value="/api/building",method=RequestMethod.GET)
    public void building(@RequestParam (value="name",required=false) String name ,
    		             @RequestParam (value="namsinh",required=false) Integer namsinh) {
        System.out.print(name+"sinh nam:"+namsinh );
    
    }
	public void validate(BuildingDTO bdto1) {
		if(bdto1.getName()==null||bdto1.getName()==""||bdto1.getNumberOfBasement()==null) {
			throw new CheckNullException("Ten va nam sinh bi trong");
		}
	}
    @RequestMapping(value="/api/building",method=RequestMethod.POST)
    public void building(@RequestParam HashMap<String,String>params) {
       for(String i: params.keySet()) {
    	   System.out.println(i+":"+params.get(i));
       }}
    @RequestMapping(value="/api/building",method=RequestMethod.PUT)
    public Object building ( @RequestBody BuildingDTO bdto ){
    	try {
    		validate(bdto);
    	}catch(CheckNullException e){
    		ErrorResponeDTO errordto=new ErrorResponeDTO(); 
    		errordto.setError(e.getMessage());
    		List<String>detail1=new ArrayList<>();
    		detail1.add("name va namsinh dang trong nen check lai");
    		errordto.setDetail(detail1);
    		return errordto;
    	}
    	return bdto;
    }
    @DeleteMapping(value="/api/building/{id}")
    public void building ( @PathVariable String id ){
    	System.out.println(id);
    }
    
    @RequestMapping(value="/api/buildings",method=RequestMethod.PUT)
    public Object building1 ( @RequestBody BuildingDTO bdto ) {
    	
    		validate(bdto);
    	
    	return bdto;
    }
    @RequestMapping(value="/api/buildings",method=RequestMethod.GET)
    public List<BuildingDTO> building2(@RequestParam(value="name",required=false) String name,
    		                           @RequestParam(value="district",required=false) String district,
    		                           @RequestParam(value="typecode",required=false)List<String>typecode){
    	
    	
    	
		return buildingService.FindAll(name,district) ;
    }
    
}