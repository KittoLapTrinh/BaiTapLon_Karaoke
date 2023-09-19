package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entity.NhanVien;
import Entity.Taikhoan;
import connectDB.ConnectDB;

public class Taikhoan_dao {
	private Connection con;
	
	public ArrayList<Taikhoan>getAllNhanVien(){
		ArrayList<Taikhoan>listtaikhoan = new ArrayList<Taikhoan>();
		String sql = "select * from TaiKhoan";
		con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Taikhoan x=new Taikhoan();
				x.setNametk(rs.getString(1));
				x.setMatkhau(rs.getString(2));
				x.setManv(rs.getInt(3));
			    listtaikhoan.add(x);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listtaikhoan;
	}
	
	
	public Taikhoan gettaikhoan(int maNV){
		Taikhoan tk = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from TaiKhoan where MaNV = ?");
			stm.setInt(1, maNV);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				 String nametk =rs.getString("TenTK");
				 String mk= rs.getString("MatKhau");
				 tk=new Taikhoan(nametk, mk);	 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tk;
	}
	public boolean addtk(Taikhoan tk,int manv) {
        try {
        	ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
            PreparedStatement tkAdd = con.prepareStatement("INSERT INTO TaiKhoan(TenTK,MatKhau,MaNV) VALUES(?,?,?)");
            tkAdd.setString(1,tk.getNametk());
            tkAdd.setString(2,tk.getMatkhau());
            tkAdd.setInt(3, manv);
            int n = tkAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	
}
