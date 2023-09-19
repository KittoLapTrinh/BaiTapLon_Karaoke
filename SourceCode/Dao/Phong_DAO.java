package Dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectDB.ConnectDB;
import Entity.NhanVien;
import Entity.Phong;


public class Phong_DAO {
private Connection con;
	
	public ArrayList<Phong>getAllPhong(){
		ArrayList<Phong>Listphong = new ArrayList<Phong>();
		String sql = "select * from Phong";
		con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				Phong x=new Phong();
				x.setMaPhong(rs.getInt(1));
				x.setLoaiPhong(rs.getString(2));
				x.setTenPhong(rs.getString(3));
				x.setTrangThai(rs.getString(4));
				x.setGiobatdau(rs.getTimestamp(5));
				x.setGiagio(rs.getInt(7));
				x.setMakh(rs.getInt(6));
				Listphong.add(x);
			}
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Listphong;
	}
	
	
	
	public Phong getPhong(String maphong){
		Phong p = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Phong where MaPhong = ?");
			stm.setString(1, maphong);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				 int map =rs.getInt("MaPhong");
				 String Loaiphong= rs.getString("LoaiPhong");
				 String tenphong= rs.getString("TenPhong");
				 String trangthai= rs.getString("TrangThai");
				 java.sql.Timestamp giobatdau=rs.getTimestamp("GioBatDau");
				 int giaohong=rs.getInt(7);
				 int makh=rs.getInt(6);
				 p = new Phong(map,Loaiphong,tenphong,trangthai,giobatdau,giaohong,makh);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public ArrayList<Phong>getAllPhongtrangthai(String trangthai){
		ArrayList<Phong>Listphong = new ArrayList<Phong>();
		
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Phong where TrangThai like ?");
			stm.setString(1, trangthai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				Phong x=new Phong();
				x.setMaPhong(rs.getInt(1));
				x.setLoaiPhong(rs.getString(2));
				x.setTenPhong(rs.getString(3));
				x.setTrangThai(rs.getString(4));
				x.setGiobatdau(rs.getTimestamp(5));
				x.setGiagio(rs.getInt(7));
				x.setMakh(rs.getInt(6));
		
			
				Listphong.add(x);
			}
			stm.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Listphong;
	}
	public ArrayList<Phong>getAllPhongkhachhang(String makh){
		ArrayList<Phong>Listphong = new ArrayList<Phong>();
		
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Phong where MaKH like ?");
			stm.setString(1, makh);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				Phong x=new Phong();
				x.setMaPhong(rs.getInt(1));
				x.setLoaiPhong(rs.getString(2));
				x.setTenPhong(rs.getString(3));
				x.setTrangThai(rs.getString(4));
				x.setGiobatdau(rs.getTimestamp(5));
				x.setGiagio(rs.getInt(7));
				x.setMakh(rs.getInt(6));
		
			
				Listphong.add(x);
			}
			stm.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Listphong;
	}
	public Phong getPhongtheoma(String ma){
		
		Phong x=new Phong();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Phong where MaPhong like ?");
			stm.setString(1, ma);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				
				x.setMaPhong(rs.getInt(1));
				x.setLoaiPhong(rs.getString(2));
				x.setTenPhong(rs.getString(3));
				x.setTrangThai(rs.getString(4));
				x.setGiobatdau(rs.getTimestamp(5));
				x.setGiagio(rs.getInt(7));
				x.setMakh(rs.getInt(6));
			
				
			}
			stm.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	public ArrayList<Phong>getAllPhongloaiphong(String loaiphong){
		ArrayList<Phong>Listphong = new ArrayList<Phong>();
		
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Phong where LoaiPhong like ?");
			stm.setString(1, loaiphong);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				Phong x=new Phong();
				x.setMaPhong(rs.getInt(1));
				x.setLoaiPhong(rs.getString(2));
				x.setTenPhong(rs.getString(3));
				x.setTrangThai(rs.getString(4));
				x.setGiobatdau(rs.getTimestamp(5));
				x.setGiagio(rs.getInt(7));
				x.setMakh(rs.getInt(6));
			
				Listphong.add(x);
			}
			stm.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Listphong;
	}
	public boolean updateTrangThaiPhong(String maphong,String trangthai) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "update Phong set TrangThai = ? where MaPhong = ?";
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1,trangthai);
			stmt.setString(2,maphong);
            int n = stmt.executeUpdate();
            if(n > 0)
            	return true;
          	} catch (SQLException e) {
          		e.printStackTrace();
          	}

			return false;
		}
	public boolean updategiagio(String maphong,int giagio) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "update Phong set Giagio = ? where MaPhong = ?";
		try {
			stmt =con.prepareStatement(sql);
			stmt.setInt(1,giagio);
			stmt.setString(2,maphong);
            int n = stmt.executeUpdate();
            if(n > 0)
            	return true;
          	} catch (SQLException e) {
          		e.printStackTrace();
          	}

			return false;
		}
	public boolean cleardatphong(String maphong) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "UPDATE Phong SET GioBatDau = null, MaKH = null WHERE MaPhong like ?";
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1,maphong);
            int n = stmt.executeUpdate();
            if(n > 0)
            	return true;
          	} catch (SQLException e) {
          		e.printStackTrace();
          	}

			return false;
		}
	public boolean datPhong(String maphong,int maKH,String trangthai,String date) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "update Phong set TrangThai = ?,MaKH=?,GioBatDau=? where MaPhong = ?";
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1,trangthai);
			stmt.setString(3,date);
			stmt.setString(4,maphong);
			stmt.setInt(2, maKH);
            int n = stmt.executeUpdate();
            if(n > 0)
            	return true;
          	} catch (SQLException e) {
          		e.printStackTrace();
          	}

			return false;
		}

	public ArrayList<Phong>getAllPhongtheoten(String name){
		ArrayList<Phong>Listphong = new ArrayList<Phong>();
		
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from Phong where TenPhong like ?");
			stm.setString(1, name+"%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				Phong x=new Phong();
				x.setMaPhong(rs.getInt(1));
				x.setLoaiPhong(rs.getString(2));
				x.setTenPhong(rs.getString(3));
				x.setTrangThai(rs.getString(4));
				x.setGiobatdau(rs.getTimestamp(5));
				x.setGiagio(rs.getInt(7));
				x.setMakh(rs.getInt(6));
				Listphong.add(x);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Listphong;
	}
}


