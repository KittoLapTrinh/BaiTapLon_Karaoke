package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.DichVu;
import Entity.NhanVien;
import connectDB.ConnectDB;

public class DichVu_DAO {
	
	public List<DichVu> getAllDV(){
		 List<DichVu>  dsDV= new ArrayList<DichVu>();
		 ConnectDB.getInstance();
		 Connection con= ConnectDB.getConnection();
		 try {
			 Statement  stm = con.createStatement();
			 ResultSet rs = stm.executeQuery("select * from DichVu");
			 while(rs.next()) {
				 int MaDV = rs.getInt(1);
				 int MaLDV = rs.getInt(2);
				 int MaHDDV=rs.getInt(3);
				 String TenDV = rs.getString(4);
				 Double DonGia = rs.getDouble(5);
				 DichVu dv = new DichVu(MaDV, MaLDV, TenDV, DonGia,MaHDDV);
				 dsDV.add(dv);
			 }
		}  catch (SQLException e) {
		}
		 
		return dsDV;
	}
	public DichVu getdichvu(int madv){
		DichVu dv = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Dichvu where MaDV = ?");
			stm.setInt(1, madv);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int MaDV = rs.getInt(1);
				 int MaLDV = rs.getInt(2);
				 int MaHDDV=rs.getInt(3);
				 String TenDV = rs.getString(4);
				 Double DonGia = rs.getDouble(5);
				  dv = new DichVu(MaDV, MaLDV, TenDV, DonGia,MaHDDV);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dv;
	}
	public List<DichVu> getAllDVtheoten(String name){
		 List<DichVu>  dsDV= new ArrayList<DichVu>();
		
		 try {
			 PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement(" select * from DichVu where TenDV like ?");
				stm.setString(1, name+"%");
				ResultSet rs = stm.executeQuery();
			 while(rs.next()) {
				 int MaDV = rs.getInt(1);
				 int MaLDV = rs.getInt(2);
				 int MaHDDV=rs.getInt(3);
				 String TenDV = rs.getString(4);
				 Double DonGia = rs.getDouble(5);
				 DichVu dv = new DichVu(MaDV, MaLDV, TenDV, DonGia,MaHDDV);
				 dsDV.add(dv);
			 }
		}  catch (SQLException e) {
		}
		 
		return dsDV;
	}

}
