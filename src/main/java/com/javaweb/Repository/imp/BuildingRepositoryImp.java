package com.javaweb.Repository.imp;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.Entity.BuildingEntity;
import com.javaweb.Entity.DistrictEntity;
import com.javaweb.Repository.BuildingRepository;
@Repository
public class BuildingRepositoryImp implements BuildingRepository {
	static final String Link="jdbc:mysql://localhost:3306/db_building";
	static final String user="root";
	static final String password="123456";
	List<BuildingEntity> danhsach =new ArrayList<>();
	List<DistrictEntity> danhsach1=new ArrayList<>();
	@Override 
	public List<BuildingEntity> FindAll(String name,String nameDistrict){
         StringBuilder sql=new StringBuilder("SELECT * FROM building WHERE 1=1 ");
         if(name!=null&&!name.equals("")) {
        	 sql.append("AND BuildingName like '%"+name+"%' ");
         }
         if(nameDistrict!=null&&!nameDistrict.equals("")) {
        	 sql.insert(13," district," );
        	 sql.append("AND building.IdDistrict=district.IdDistrict AND DistrictName like '%"+nameDistrict+"%' ");
         }
		try(Connection con=DriverManager.getConnection(Link,user,password);
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql.toString());){
			while(rs.next()) {
				BuildingEntity bett=new BuildingEntity();
				DistrictEntity dett=new DistrictEntity();
				bett.setName(rs.getString("BuildingName"));
				bett.setNumberOfBasement(rs.getInt("NumberOfBasement"));
				bett.setWard(rs.getString("Ward"));
				bett.setWay(rs.getString("Way"));
				dett.setName(rs.getString("DistrictName"));
				dett.setCodeDistrict(rs.getString("CodeDistrict"));
				dett.setIdDistrict(rs.getInt("IdDistrict"));
				danhsach.add(bett);
				danhsach1.add(dett);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return danhsach;
	}
	public List<DistrictEntity> FindAll1(){
		return danhsach1;
	}
	
}
