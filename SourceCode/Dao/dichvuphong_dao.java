package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.DichVu;
import Entity.dichvuphong;
import connectDB.ConnectDB;

public class dichvuphong_dao {
	public List<dichvuphong> getdichvu(int maphong){
		List<dichvuphong>  dvphong= new ArrayList<dichvuphong>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("\r\n"
					+ "SELECT    Phong.MaPhong, HoaDonDichVu.MaHDDV, ChiTietHoaDonDichVu.MaDV, DichVu.MaLoaiDV, DichVu.TenDV, DichVu.DonGia, ChiTietHoaDonDichVu.SoLuong\r\n"
					+ "FROM         ChiTietHoaDonDichVu INNER JOIN\r\n"
					+ "                      DichVu ON ChiTietHoaDonDichVu.MaDV = DichVu.MaDV INNER JOIN\r\n"
					+ "                      HoaDonDichVu ON ChiTietHoaDonDichVu.MaHDDV = HoaDonDichVu.MaHDDV INNER JOIN\r\n"
					+ "                      Phong ON HoaDonDichVu.MaPhong = Phong.MaPhong\r\n"
					+ "where Phong.MaPhong like ?");
			stm.setInt(1, maphong);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				
				 int maphongdv =rs.getInt(1);
				 int MaHDDV =rs.getInt(2);
				 int Madv=rs.getInt(3);
				 int soluong=rs.getInt(7);
				 String tenDV=rs.getString(5);
				 int maloaidv=rs.getInt(4);
				 double dongia=rs.getDouble(6);
				 dichvuphong dvp=new dichvuphong(maphongdv, MaHDDV, Madv, soluong, tenDV, maloaidv,dongia);
				 dvphong.add(dvp);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dvphong;
	}
	
	public boolean deletedichvuphong2(String maphong) throws SQLException{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm =null;
		String sql ="delete FROM  HoaDonDichVu where MaPhong like ?";
		int n=0;
		try {
			stm =con.prepareStatement(sql);
			stm.setString(1, maphong);
			n=stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			stm.close();
		}
		return n > 0;
	}
		public boolean deletedichvuphong1(int mahddv) throws SQLException{
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stm =null;
			String sql ="delete FROM  ChiTietHoaDonDichVu where MaHDDV like ?";
			int n=0;
			try {
				stm =con.prepareStatement(sql);
				stm.setInt(1, mahddv);
				n=stm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				stm.close();
			}
			return n > 0;
		}
}
