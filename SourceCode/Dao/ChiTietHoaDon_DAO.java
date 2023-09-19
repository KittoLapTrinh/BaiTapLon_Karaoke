package Dao;

import connectDB.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entity.ChiTietHoaDon;

public class ChiTietHoaDon_DAO {
	
	public ArrayList<ChiTietHoaDon> getAllChiTietHoaDon(){
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		Statement stm  = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sqlString = "select * from ChiTietHoaDon";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlString);
			
			while (rs.next()) {
				int maHD = rs.getInt("MaHD");
				double donGia = rs.getDouble("DonGia");
				double tongGioHat = rs.getDouble("TongGioHat");
				Date gioVao = rs.getDate("GioVao");
				Date gioRa = rs.getDate("GioRa");
				ChiTietHoaDon cthd = new ChiTietHoaDon(maHD, donGia, tongGioHat, gioVao, gioRa);
				dsCTHD.add(cthd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsCTHD;
	}
	public boolean modifieldCTHD(ChiTietHoaDon cthd) {
		PreparedStatement stm = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sqlQuery = "UPDATE ChiTietHoaDon "
					+ "set DonGia = ?, "
					+ "TongGioHat = ?, "
					+ "GioVao = ?, "
					+ "GioRa = ? "
					+ "Where MaHD = ?";
			stm = con.prepareStatement(sqlQuery);
			stm.setDouble(1, cthd.getDonGia());
			stm.setDouble(2, cthd.getTongGioHat());
			stm.setDate(3,  new java.sql.Date(cthd.getGioRa().getTime()));
			stm.setDate(4,  new java.sql.Date(cthd.getGioRa().getTime()));
			int num = stm.executeUpdate();
			if (num == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean addCTHD(ChiTietHoaDon cthd) {
		PreparedStatement stm = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sqlQuery = "INSERT INTO ChiTietHoaDon VALUES(?, ?, ?, ?)";
			stm = con.prepareStatement(sqlQuery);
			stm.setDouble(1, cthd.getDonGia());
			stm.setDouble(2, cthd.getTongGioHat());
			stm.setDate(3,  new java.sql.Date(cthd.getGioRa().getTime()));
			stm.setDate(4,  new java.sql.Date(cthd.getGioRa().getTime()));
			int count = stm.executeUpdate();
			if (count == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean deleteCTHD(String maHD) {
		PreparedStatement stm = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sqlQuery = "delete from [dbo].[ChiTietHoaDon] where [MaHD] = ?";
			stm = con.prepareStatement(sqlQuery);
			stm.setString(1, maHD);
			int row = stm.executeUpdate();
			if (row == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
}
