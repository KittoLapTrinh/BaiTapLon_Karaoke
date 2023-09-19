package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.PhieuIn;
import connectDB.ConnectDB;

public class PhieuIn_DAO {
	public PhieuIn getPhieuInTheoMa(int ma){
		PhieuIn x=new PhieuIn();
		
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("SELECT HoaDon.*, Phong.LoaiPhong, Phong.TenPhong, Phong.TrangThai, Phong.GioBatDau, NhanVien.TenNV, NhanVien.GioiTinh\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDon.MaNV = NhanVien.MaNV INNER JOIN\r\n"
					+ "                  Phong ON HoaDon.MaPhong = Phong.MaPhong\r\n"
					+ "where HoaDon.MaPhong like ? ");
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				
				x.setMaHD(rs.getInt(1));
				x.setMaKH(rs.getInt(2));
				x.setMaPhong(rs.getInt(3));
				x.setNgayDat(rs.getTimestamp(4));
				x.setMaHDDV(rs.getInt(5));
				x.setTongTien(rs.getDouble(6));
				x.setMaNV(rs.getInt(7));
				x.setLoaiPhong(rs.getString(8));
				x.setTenPhong(rs.getString(9));
				x.setTrangThai(rs.getString(10));
				x.setGioBD(rs.getTimestamp(11));
				x.setTenNV(rs.getString(12));
				x.setGioiTinh(rs.getString(13));
				
			}
			stm.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
}
