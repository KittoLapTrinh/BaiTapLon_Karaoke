package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import Entity.KhachHang;

public class KhachHang_DAO {
	private Connection con;
	

	public ArrayList<KhachHang>getAllKhachHang(){
		ArrayList<KhachHang>listKhachHang = new ArrayList<KhachHang>();
		String sql = "select * from KhachHang";
		con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				KhachHang x=new KhachHang();
				x.setMaKH(rs.getInt("MaKH"));
				x.setTenKH(rs.getString("TenKH"));
				x.setGioiTinh(rs.getString("GioiTinh"));
				x.setPhone(rs.getString("Phone"));
				x.setEmail(rs.getString("Email"));
				x.setDiaChi(rs.getString("DiaChi"));	
				Date myDateObj = rs.getDate("NgaySinh");
				x.setNgaySinh(myDateObj);
				listKhachHang.add(x);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listKhachHang;
	}
	
	public boolean addKhachHang(KhachHang kh) {
        try {
            PreparedStatement khAdd = con.prepareStatement("INSERT INTO KhachHang ([TenKH],[GioiTinh],[Phone]," +
                    "[DiaChi],[NgaySinh],[Email]) VALUES(?,?,?,?,?,?)");
            khAdd.setString(1,kh.getTenKH());
            khAdd.setString(2, kh.getGioiTinh());
            khAdd.setString(3,kh.getPhone());
            khAdd.setString(6,kh.getEmail());
            khAdd.setString(4,kh.getDiaChi());
            Date myDateObj = kh.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(myDateObj.getTime());
            khAdd.setDate(5, sqlDate);
            int n = khAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	
	public boolean xoaKhachHang(String MaKH) throws SQLException{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm =null;
		String sql ="delete KhachHang where MaKH=?";
		int n=0;
		try {
			stm =con.prepareStatement(sql);
			stm.setString(1, MaKH);
			n=stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			stm.close();
		}
		return n > 0;
	}
	
	public boolean capNhatKhachHang(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "update KhachHang set TenKH = ?, "
                + " GioiTinh = ?, NgaySinh = ?, Phone = ?, Email = ?,DiaChi = ? where MaKH = ?";
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1,kh.getTenKH());
			stmt.setString(2,kh.getGioiTinh());
            stmt.setString(4, kh.getPhone());
            stmt.setString(5,kh.getEmail());
            stmt.setString(6,kh.getDiaChi());
            Date myDateObj = kh.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(myDateObj.getTime());
            stmt.setDate(3, sqlDate);
            stmt.setInt(7, kh.getMaKH());
            int n = stmt.executeUpdate();
            if(n > 0)
            	return true;
          	} catch (SQLException e) {
          		e.printStackTrace();
          	}

			return false;
		}
	
	 public KhachHang getKhachHang(int maKH){
			KhachHang kh = null;
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where MaKH = ?");
				stm.setInt(1, maKH);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					 int maKhachHang =rs.getInt("MaKH");
					 String ten= rs.getString("TenKH");
					 String gioiTinh= rs.getString("GioiTinh");
					 Date ngaySinh = rs.getDate("NgaySinh");
					 String phone= rs.getString("Phone");
					 String email= rs.getString("Email");
					 String diaChi=rs.getString("DiaChi");
					 kh = new KhachHang(maKhachHang, ten, gioiTinh, ngaySinh, phone, email, diaChi);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kh;
		}
	 
	 public KhachHang getKhachHangPhone(String phone){
			KhachHang kh = null;
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where Phone = ?");
				stm.setString(1, phone);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					 int maKhachHang =rs.getInt("MaKH");
					 String ten= rs.getString("TenKH");
					 String gioiTinh = rs.getString("gioiTinh");
					 Date ngaySinh = rs.getDate("NgaySinh");
					 String sdt= rs.getString("Phone");
					 String email= rs.getString("Email");
					 String diaChi=rs.getString("DiaChi");
				
					 kh = new KhachHang(maKhachHang, ten, gioiTinh, ngaySinh, sdt, email, diaChi);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kh;
		}
	 public KhachHang getKhachHangemail(String khemail){
			KhachHang kh = null;
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where Email = ?");
				stm.setString(1, khemail);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					 int maKhachHang =rs.getInt("MaKH");
					 String ten= rs.getString("TenKH");
					 String gioiTinh = rs.getString("gioiTinh");
					 Date ngaySinh = rs.getDate("NgaySinh");
					 String sdt= rs.getString("Phone");
					 String email= rs.getString("Email");
					 String diaChi=rs.getString("DiaChi");
				
					 kh = new KhachHang(maKhachHang, ten, gioiTinh, ngaySinh, sdt, email, diaChi);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kh;
		}
	 public KhachHang getKhachHangmakh(String ipmakh){
			KhachHang kh = null;
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where MaKh = ?");
				stm.setString(1, ipmakh);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					 int maKhachHang =rs.getInt("MaKH");
					 String ten= rs.getString("TenKH");
					 String gioiTinh = rs.getString("gioiTinh");
					 Date ngaySinh = rs.getDate("NgaySinh");
					 String sdt= rs.getString("Phone");
					 String email= rs.getString("Email");
					 String diaChi=rs.getString("DiaChi");
				
					 kh = new KhachHang(maKhachHang, ten, gioiTinh, ngaySinh, sdt, email, diaChi);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kh;
		}
	 public KhachHang getKhachHangdiachi(String ipdiachi){
			KhachHang kh = null;
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where DiaChi = ?");
				stm.setString(1, ipdiachi);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					 int maKhachHang =rs.getInt("MaKH");
					 String ten= rs.getString("TenKH");
					 String gioiTinh = rs.getString("gioiTinh");
					 Date ngaySinh = rs.getDate("NgaySinh");
					 String sdt= rs.getString("Phone");
					 String email= rs.getString("Email");
					 String diaChi=rs.getString("DiaChi");
				
					 kh = new KhachHang(maKhachHang, ten, gioiTinh, ngaySinh, sdt, email, diaChi);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return kh;
		}
	 
	    public ArrayList<KhachHang> getKhachHanggioitinhnam(String Gioitinh){
	    	ArrayList<KhachHang>listKhachHanggioitinh = new ArrayList<KhachHang>();
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where GioiTinh = ?");
				stm.setString(1, Gioitinh);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(rs.getInt("MaKH"));
					kh.setTenKH(rs.getString("TenKH"));
					 kh.setGioiTinh(rs.getString("GioiTinh"));
					 kh.setPhone(rs.getString("Phone"));
					 kh.setEmail(rs.getString("Email"));
						kh.setDiaChi(rs.getString("DiaChi"));
					 Date myDateObj = rs.getDate("NgaySinh");
					    kh.setNgaySinh(myDateObj);
					    
					 listKhachHanggioitinh.add(kh);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listKhachHanggioitinh;
		}
	    
	    public ArrayList<KhachHang> getKhachHanggioitinhnu(String Gioitinh){
	    	ArrayList<KhachHang>listKhachHanggioitinh = new ArrayList<KhachHang>();
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where GioiTinh not like ?");
				stm.setString(1, Gioitinh);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					KhachHang kh = new KhachHang();
					 kh.setMaKH(rs.getInt("MaKH"));
					kh.setTenKH(rs.getString("TenKH"));
					 kh.setGioiTinh(rs.getString("GioiTinh"));
		
					 kh.setPhone(rs.getString("Phone"));
					 kh.setEmail(rs.getString("Email"));
						kh.setDiaChi(rs.getString("DiaChi"));
					 Date myDateObj = rs.getDate("NgaySinh");
					    kh.setNgaySinh(myDateObj);
					   
					 listKhachHanggioitinh.add(kh);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listKhachHanggioitinh;
		}
	 
	    public ArrayList<KhachHang>getAllKhachHangtheoten(String tenkh){
			ArrayList<KhachHang>listKhachHang = new ArrayList<KhachHang>();
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement("select * from KhachHang where TenKH like ?");
				stm.setString(1, tenkh+"%");
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					KhachHang x=new KhachHang();
					x.setMaKH(rs.getInt("MaKH"));
					x.setTenKH(rs.getString("TenKH"));
					x.setGioiTinh(rs.getString("GioiTinh"));
					x.setPhone(rs.getString("Phone"));
					x.setEmail(rs.getString("Email"));
					x.setDiaChi(rs.getString("DiaChi"));	
					Date myDateObj = rs.getDate("NgaySinh");
					x.setNgaySinh(myDateObj);
					listKhachHang.add(x);
				}
				rs.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listKhachHang;
		}
	    public ArrayList<KhachHang>getAllKhachHangtheonamsinh(String namsinh){
			ArrayList<KhachHang>listKhachHang = new ArrayList<KhachHang>();
			try {
				PreparedStatement stm = null;
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				stm = con.prepareStatement(" select * from KhachHang where YEAR(NgaySinh) like ?");
				stm.setString(1, namsinh);
				ResultSet rs = stm.executeQuery();
				while(rs.next()) {
					KhachHang x=new KhachHang();
					x.setMaKH(rs.getInt("MaKH"));
					x.setTenKH(rs.getString("TenKH"));
					x.setGioiTinh(rs.getString("GioiTinh"));
					x.setPhone(rs.getString("Phone"));
					x.setEmail(rs.getString("Email"));
					x.setDiaChi(rs.getString("DiaChi"));	
					Date myDateObj = rs.getDate("NgaySinh");
					x.setNgaySinh(myDateObj);
					listKhachHang.add(x);
				}
				rs.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listKhachHang;
		}
	 
}


