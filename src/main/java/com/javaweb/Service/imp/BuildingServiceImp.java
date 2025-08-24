package com.javaweb.Service.imp;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Bean.BuildingDTO;
import com.javaweb.Entity.BuildingEntity;
import com.javaweb.Entity.DistrictEntity;
import com.javaweb.Service.BuildingService;

@Service
public class BuildingServiceImp implements BuildingService{
@Autowired
private BuildingRepository buildingRepository;

@Override
public List<BuildingDTO> FindAll(String name,String nameDistrict) {
	List<BuildingDTO> listbdto=new ArrayList<>();
	List<BuildingEntity> buildingEntity=buildingRepository.FindAll(name,nameDistrict);
	List<DistrictEntity> districtEntity=buildingRepository.FindAll1();
	int i=0;
	for(BuildingEntity bett : buildingEntity) {
		BuildingDTO bdto=new BuildingDTO();
		DistrictEntity dett=new DistrictEntity();
		dett=districtEntity.get(i);
		bdto.setName(bett.getName());
		bdto.setNumberOfBasement(bett.getNumberOfBasement());
		bdto.setAddress(":"+bett.getWay()+"-"+bett.getWard()+"-"+dett.getName());
		i++;
		listbdto.add(bdto);
	}
	
	return listbdto;
}
}
