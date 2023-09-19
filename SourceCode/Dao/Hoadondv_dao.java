package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import Entity.DichVu;
import Entity.Hoadondv;
import Entity.NhanVien;
import connectDB.ConnectDB;

public class Hoadondv_dao {
	private Connection con;
	public boolean addhoadondv(int maphong,Timestamp ngaylap) {
        try {
        	con = ConnectDB.getConnection();
            PreparedStatement nvAdd = con.prepareStatement("INSERT INTO HoaDonDichVu ([MaPhong],[NgayLap]) VALUES(?,?)");
            nvAdd.setInt(1,maphong);
            nvAdd.setTimestamp(2,ngaylap);
            int n = nvAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public Hoadondv gethddichvu(int maphong){
		Hoadondv dv = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from HoaDonDichVu where MaPhong = ?");
			stm.setInt(1, maphong);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int MaHDDV = rs.getInt(1);
				 int maPhong = rs.getInt(2);
				 Timestamp ngaylap=rs.getTimestamp(3);
				  dv = new Hoadondv(MaHDDV, maPhong, ngaylap);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dv;
	}
//	public boolean xoahddv(String maphong) throws SQLException{
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stm =null;
//		String sql ="delete NhanVien where MaNV=?";
//		int n=0;
//		try {
//			stm =con.prepareStatement(sql);
//			stm.setString(1, MaNV);
//			n=stm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			stm.close();
//		}
//		return n > 0;
//	}
}
