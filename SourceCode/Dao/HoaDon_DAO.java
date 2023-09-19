package Dao;

import connectDB.ConnectDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import Entity.HoaDon;
import Entity.Phong;

public class HoaDon_DAO {
	
	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		Statement stm  = null;
		try {
			connectDB.ConnectDB.getInstance();
			Connection con = connectDB.ConnectDB.getConnection();
			String sqlQuery = "select * from HoaDon";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlQuery);
			
			while(rs.next()) {
				int maHD = rs.getInt("MaHD");
				int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
				Timestamp ngayDatPhong = rs.getTimestamp("NgayDatPhong");
				Double tongTienDV = rs.getDouble("Tongtiendichvu");
				Double tongTienPhong = rs.getDouble("TongTienPhong");
				int maNV = rs.getInt("MaNV");
				
				dsHoaDon.add(new HoaDon(maHD, maKH, maPhong, ngayDatPhong, tongTienDV, tongTienPhong, maNV));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsHoaDon;
		
	}
	public boolean addHoaDon(HoaDon hd) {
		PreparedStatement stm = null;
		int isInserted = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sqlQuery = "INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV])"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?, ?)";
			stm = con.prepareStatement(sqlQuery);
			stm.setInt(1, hd.getMaKH());
			stm.setInt(2, hd.getMaPhong());
			stm.setTimestamp(3,hd.getNgayDat());
			stm.setDouble(4, hd.getTongTienDV());
			stm.setDouble(5, hd.getTongTienPhong());
			stm.setInt(6, hd.getMaNV());
			isInserted = stm.executeUpdate();
			if (isInserted == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
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
	public boolean deletehoadonnull() {
		PreparedStatement stm = null;
		int isInserted = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sqlQuery = "DELETE FROM HoaDon WHERE NgayDatPhong is null";
			stm = con.prepareStatement(sqlQuery);
			isInserted = stm.executeUpdate();
			if (isInserted == 0) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
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
	
	public HoaDon getmahoadon(){
		HoaDon p = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("SELECT TOP 1 * FROM HoaDon ORDER BY MaHD DESC");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int maHD = rs.getInt("MaHD");
				int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
				Timestamp ngayDatPhong = rs.getTimestamp("NgayDatPhong");
				Double tongTienDV = rs.getDouble("Tongtiendichvu");
				Double tongTienPhong = rs.getDouble("TongTienPhong");
				int maNV = rs.getInt("MaNV");
				p=new HoaDon(maHD, maKH, maPhong, ngayDatPhong, tongTienDV, tongTienPhong, maNV);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	

	public boolean modifieldHoaDon(HoaDon hd) {
		PreparedStatement stm = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String queryUpdate  = 
					"update [dbo].[HoaDon]"  +
							" set [MaKH] = ?,"
							+"[MaPhong] = ?,"
							+"[NgayDatPhong] = ?,"
							+"[MaHDDV] = ?,"
							+"[Tongtiendichvu] = ?,"
							+"[TongTienPhong] = ?"
							+" where [MaHD] = ?";
;
			stm = con.prepareStatement(queryUpdate);
			stm.setInt(1, hd.getMaKH());
			stm.setInt(2, hd.getMaPhong());
			stm.setDate(3,  new java.sql.Date(hd.getNgayDat().getTime()));
			stm.setDouble(4, hd.getTongTienDV());
			stm.setDouble(5, hd.getTongTienPhong());
			stm.setInt(6, hd.getMaNV());
			
			int inserted = stm.executeUpdate();
			if (inserted == 0) {
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
	
	public ArrayList<HoaDon> getmahoadontheothang(int thang){
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("SELECT * FROM HoaDon where MONTH(NgayDatPhong) = ?");	
			stm.setInt(1,thang);
			ResultSet rs = stm.executeQuery();	
			while (rs.next()) {
				int maHD = rs.getInt("MaHD");
				int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
				Timestamp ngayDatPhong = rs.getTimestamp("NgayDatPhong");
				Double tongTienDV = rs.getDouble("Tongtiendichvu");
				Double tongTienPhong = rs.getDouble("TongTienPhong");
				int maNV = rs.getInt("MaNV");
				dsHoaDon.add(new HoaDon(maHD, maKH, maPhong, ngayDatPhong, tongTienDV, tongTienPhong, maNV));
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getmahoadontheonam(int nam){
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("SELECT * FROM HoaDon where YEAR(NgayDatPhong) = ?");
			stm.setInt(1,nam);
			ResultSet rs = stm.executeQuery();	
			while (rs.next()) {
				int maHD = rs.getInt("MaHD");
				int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
				Timestamp ngayDatPhong = rs.getTimestamp("NgayDatPhong");
				Double tongTienDV = rs.getDouble("Tongtiendichvu");
				Double tongTienPhong = rs.getDouble("TongTienPhong");
				int maNV = rs.getInt("MaNV");
				dsHoaDon.add(new HoaDon(maHD, maKH, maPhong, ngayDatPhong, tongTienDV, tongTienPhong, maNV));
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	public ArrayList<HoaDon> getmahoadonhomnay(int ngay, int thang, int nam){
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("SELECT * FROM HoaDon where MONTH(NgayDatPhong) = ? AND YEAR(NgayDatPhong) = ? AND DAY(NgayDatPhong) = ?");
			stm.setInt(1,thang);
			stm.setInt(2,nam);
			stm.setInt(3,ngay);
			ResultSet rs = stm.executeQuery();	
			while (rs.next()) {
				int maHD = rs.getInt("MaHD");
				int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
				Timestamp ngayDatPhong = rs.getTimestamp("NgayDatPhong");
				Double tongTienDV = rs.getDouble("Tongtiendichvu");
				Double tongTienPhong = rs.getDouble("TongTienPhong");
				int maNV = rs.getInt("MaNV");
				dsHoaDon.add(new HoaDon(maHD, maKH, maPhong, ngayDatPhong, tongTienDV, tongTienPhong, maNV));
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsHoaDon;
	}
}
