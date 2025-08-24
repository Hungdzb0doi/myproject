package com.javaweb.Service;

import java.util.List;

import com.javaweb.Bean.BuildingDTO;

public interface BuildingService {
	
List<BuildingDTO> FindAll(String name,String nameDistrict);
}
