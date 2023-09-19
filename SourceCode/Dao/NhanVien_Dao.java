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

import Entity.NhanVien;
import connectDB.ConnectDB;


public class NhanVien_Dao {
	
	private Connection con;
	
	public ArrayList<NhanVien>getAllNhanVien(){
		ArrayList<NhanVien>listNhanVien = new ArrayList<NhanVien>();
		String sql = "select * from NhanVien";
		con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NhanVien x=new NhanVien();
				x.setMaNV(rs.getInt("MaNV"));
				x.setTenNV(rs.getString("TenNV"));
				x.setCCCD(rs.getString("CCCD"));
				x.setPhone(rs.getString("Phone"));
				x.setChucVu(rs.getString("ChucVu"));
				x.setDiaChi(rs.getString("DiaChi"));
				x.setGioiTinh(rs.getString("GioiTinh"));
				Date myDateObj = rs.getDate("NgaySinh");
			    x.setNgaySinh(myDateObj);
			    x.setLuong(rs.getDouble("Luong"));
				
				listNhanVien.add(x);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listNhanVien;
	}
	
	public boolean addNhanVien(NhanVien nv) {
        try {
            PreparedStatement nvAdd = con.prepareStatement("INSERT INTO NhanVien ([TenNV],[GioiTinh],[CCCD],[Phone],[ChucVu]," +
                    "[DiaChi],[NgaySinh],[Luong]) VALUES(?,?,?,?,?,?,?,?)");
            nvAdd.setString(1,nv.getTenNV());
            nvAdd.setString(2,nv.getGioiTinh());
            nvAdd.setString(3,nv.getCCCD());
            nvAdd.setString(4,nv.getPhone());
            nvAdd.setString(5,nv.getChucVu());
            nvAdd.setString(6,nv.getDiaChi());
            Date myDateObj = nv.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(myDateObj.getTime());
            nvAdd.setDate(7,sqlDate);
            nvAdd.setDouble(8,nv.getLuong());
            int n = nvAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	public boolean xoaNhanVien(String MaNV) throws SQLException{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm =null;
		String sql ="delete NhanVien where MaNV=?";
		int n=0;
		try {
			stm =con.prepareStatement(sql);
			stm.setString(1, MaNV);
			n=stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			stm.close();
		}
		return n > 0;
	}
//    public boolean updateNhanVien(String maNV, NhanVien nv) {
//        String sql = "update NhanVien set TenNV = ?, "
//                + "CCCD = ?,Phone = ? ,ChucVu = ?,DiaChi = ? ,NgaySinh = ? ,Luong = ?,MaCa = ?  where MaNV = ?";
//        try {
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1,nv.getTenNV());
//            stmt.setString(2, nv.getGioiTinh());
//            stmt.setString(3,nv.getCCCD());
//            stmt.setString(4,nv.getPhone());
//            stmt.setString(5,nv.getChucVu());
//            stmt.setString(6,nv.getDiaChi());
//            stmt.setDate(7,(java.sql.Date) nv.getNgaySinh());
//            stmt.setDouble(8,nv.getLuong());
//            
//
//            int n = stmt.executeUpdate();
//            if(n > 0)
//                return true;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
    
    public boolean capNhatNhanVien(NhanVien nv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "update NhanVien set TenNV = ?, "
                + " GioiTinh = ?, CCCD = ?,Phone = ? ,ChucVu = ?,DiaChi = ? ,NgaySinh = ? ,Luong = ? where MaNV = ?";
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1,nv.getTenNV());
            stmt.setString(2, nv.getGioiTinh());
            stmt.setString(3,nv.getCCCD());
            stmt.setString(4,nv.getPhone());
            stmt.setString(5,nv.getChucVu());
            stmt.setString(6,nv.getDiaChi());
            Date myDateObj = nv.getNgaySinh();
            java.sql.Date sqlDate = new java.sql.Date(myDateObj.getTime());
            stmt.setDate(7,sqlDate);
            stmt.setDouble(8,nv.getLuong());
            stmt.setInt(9, nv.getMaNV());
            int n = stmt.executeUpdate();
            if(n > 0)
            	return true;
          	} catch (SQLException e) {
          		e.printStackTrace();
          	}

			return false;
		}
    public NhanVien getNhanVien(int maNV){
		NhanVien nv = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where MaNV = ?");
			stm.setInt(1, maNV);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				 int maNhanVien =rs.getInt("MaNV");
				 String ten= rs.getString("TenNV");
				 String gioiTinh= rs.getString("GioiTinh");
				 String cccd= rs.getString("CCCD");
				 String sdt=rs.getString("Phone");
				 Date ngaySinh=rs.getDate("NgaySinh");;
				 String chucVu=rs.getString("ChucVu");
				 String diaChi=rs.getString("DiaChi");;
				 Double luong=rs.getDouble("Luong");
				 nv = new NhanVien(maNhanVien, ten, gioiTinh, cccd, sdt, chucVu, diaChi, ngaySinh, luong);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}
    public NhanVien getNhanViencccd(String incccd){
		NhanVien nv = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where CCCD = ?");
			stm.setString(1, incccd);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				 int maNhanVien =rs.getInt("MaNV");
				 String ten= rs.getString("TenNV");
				 String gioiTinh= rs.getString("GioiTinh");
				 String cccd= rs.getString("CCCD");
				 String sdt=rs.getString("Phone");
				 Date ngaySinh=rs.getDate("NgaySinh");;
				 String chucVu=rs.getString("ChucVu");
				 String diaChi=rs.getString("DiaChi");;
				 Double luong=rs.getDouble("Luong");
				 nv = new NhanVien(maNhanVien, ten, gioiTinh, cccd, sdt, chucVu, diaChi, ngaySinh, luong);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}
    public NhanVien getNhanVienphone(String phone){
		NhanVien nv = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where Phone = ?");
			stm.setString(1, phone);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				 int maNhanVien =rs.getInt("MaNV");
				 String ten= rs.getString("TenNV");
				 String gioiTinh= rs.getString("GioiTinh");
				 String cccd= rs.getString("CCCD");
				 String sdt=rs.getString("Phone");
				 Date ngaySinh=rs.getDate("NgaySinh");;
				 String chucVu=rs.getString("ChucVu");
				 String diaChi=rs.getString("DiaChi");;
				 Double luong=rs.getDouble("Luong");
				 nv = new NhanVien(maNhanVien, ten, gioiTinh, cccd, sdt, chucVu, diaChi, ngaySinh, luong);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}
		
    public ArrayList<NhanVien> getNhanViengioitinhnam(String Gioitinh){
    	ArrayList<NhanVien>listNhanViengioitinh = new ArrayList<NhanVien>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where GioiTinh = ?");
			stm.setString(1, Gioitinh);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				 nv.setMaNV(rs.getInt("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				 nv.setGioiTinh(rs.getString("GioiTinh"));
				 nv.setCCCD(rs.getString("CCCD"));
				 nv.setPhone(rs.getString("Phone"));
					nv.setDiaChi(rs.getString("DiaChi"));
				 Date myDateObj = rs.getDate("NgaySinh");
				    nv.setNgaySinh(myDateObj);
				    nv.setLuong(rs.getDouble("Luong"));
				    nv.setChucVu(rs.getString("ChucVu"));
				 listNhanViengioitinh.add(nv);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanViengioitinh;
	}
    public ArrayList<NhanVien> getNhanVienchucvu(String chucvu){
    	ArrayList<NhanVien>listNhanViengioitinh = new ArrayList<NhanVien>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where ChucVu = ?");
			stm.setString(1, chucvu);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				 nv.setMaNV(rs.getInt("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				 nv.setGioiTinh(rs.getString("GioiTinh"));
				 nv.setCCCD(rs.getString("CCCD"));
				 nv.setPhone(rs.getString("Phone"));
					nv.setDiaChi(rs.getString("DiaChi"));
				 Date myDateObj = rs.getDate("NgaySinh");
				    nv.setNgaySinh(myDateObj);
				    nv.setLuong(rs.getDouble("Luong"));
				    nv.setChucVu(rs.getString("ChucVu"));
				 listNhanViengioitinh.add(nv);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanViengioitinh;
	}
    public ArrayList<NhanVien> getNhanViengioitinhnu(String Gioitinh){
    	ArrayList<NhanVien>listNhanViengioitinh = new ArrayList<NhanVien>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where GioiTinh not like ?");
			stm.setString(1, Gioitinh);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				 nv.setMaNV(rs.getInt("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				 nv.setGioiTinh(rs.getString("GioiTinh"));
				 nv.setCCCD(rs.getString("CCCD"));
				 nv.setPhone(rs.getString("Phone"));
					nv.setDiaChi(rs.getString("DiaChi"));
				 Date myDateObj = rs.getDate("NgaySinh");
				    nv.setNgaySinh(myDateObj);
				    nv.setLuong(rs.getDouble("Luong"));
				    nv.setChucVu(rs.getString("ChucVu"));
				 listNhanViengioitinh.add(nv);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanViengioitinh;
	}
    public ArrayList<NhanVien> getNhanVientheoten(String name){
    	ArrayList<NhanVien>listNhanViengioitinh = new ArrayList<NhanVien>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where TenNV like ?");
			stm.setString(1, name+"%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				 nv.setMaNV(rs.getInt("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				 nv.setGioiTinh(rs.getString("GioiTinh"));
				 nv.setCCCD(rs.getString("CCCD"));
				 nv.setPhone(rs.getString("Phone"));
					nv.setDiaChi(rs.getString("DiaChi"));
				 Date myDateObj = rs.getDate("NgaySinh");
				    nv.setNgaySinh(myDateObj);
				    nv.setLuong(rs.getDouble("Luong"));
				    nv.setChucVu(rs.getString("ChucVu"));
				 listNhanViengioitinh.add(nv);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanViengioitinh;
	}
    public ArrayList<NhanVien> getNhanVientheonamsinh(String namsinh){
    	ArrayList<NhanVien>listNhanViengioitinh = new ArrayList<NhanVien>();
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from NhanVien where YEAR(NgaySinh) like ?");
			stm.setString(1, namsinh+"%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				 nv.setMaNV(rs.getInt("MaNV"));
				nv.setTenNV(rs.getString("TenNV"));
				 nv.setGioiTinh(rs.getString("GioiTinh"));
				 nv.setCCCD(rs.getString("CCCD"));
				 nv.setPhone(rs.getString("Phone"));
					nv.setDiaChi(rs.getString("DiaChi"));
				 Date myDateObj = rs.getDate("NgaySinh");
				    nv.setNgaySinh(myDateObj);
				    nv.setLuong(rs.getDouble("Luong"));
				    nv.setChucVu(rs.getString("ChucVu"));
				 listNhanViengioitinh.add(nv);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanViengioitinh;
	}
    
}
