package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.ChiTietDichVu;
import connectDB.ConnectDB;

public class ChiTietDichVu_DAO {
	
	public List<ChiTietDichVu> getAllCTDV(){
		 List<ChiTietDichVu>  dsCTDV= new ArrayList<ChiTietDichVu>();
		 ConnectDB.getInstance();
		 Connection con= ConnectDB.getConnection();
		 try {
			 Statement  stm = con.createStatement();
			 ResultSet rs = stm.executeQuery("select * from DichVu");
			 while(rs.next()) {
				 int MaDV = rs.getInt(1);
				 int MaHD = rs.getInt(2);
				 Double DonGia = rs.getDouble(3);
				 int SoLuong = rs.getInt(4);
				 ChiTietDichVu ctdv = new ChiTietDichVu(MaDV, MaHD, DonGia, SoLuong);
				 dsCTDV.add(ctdv);
			 }
		}  catch (SQLException e) {
		}
		 
		return dsCTDV;
	}
	
}
