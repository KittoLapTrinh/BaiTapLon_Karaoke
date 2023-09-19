package Dao;

import connectDB.ConnectDB;
import Entity.LoaiDichVu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LoaiDichVu_DAO {
	
	public List<LoaiDichVu> getAllLoaiDV(){
		 List<LoaiDichVu>  dsLoaiDV= new ArrayList<LoaiDichVu>();
		 ConnectDB.getInstance();
		 Connection con= ConnectDB.getConnection();
		 try {
			 Statement  stm = con.createStatement();
			 ResultSet rs = stm.executeQuery("select * from LoaiDichVu");
			 while(rs.next()) {
				 int MaLDV = rs.getInt(1);
				 String TenLDV = rs.getString(2);
				 LoaiDichVu ldv = new LoaiDichVu(MaLDV, TenLDV);
				 dsLoaiDV.add(ldv);
			 }
		}  catch (SQLException e) {
		}
		 
		return dsLoaiDV;
	}

}
