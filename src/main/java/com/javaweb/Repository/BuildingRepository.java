package com.javaweb.Repository;

import java.util.List;

import com.javaweb.Entity.BuildingEntity;
import com.javaweb.Entity.DistrictEntity;

public interface BuildingRepository {
List<BuildingEntity>FindAll(String name,String nameDistrict);
List<DistrictEntity>FindAll1();
}
