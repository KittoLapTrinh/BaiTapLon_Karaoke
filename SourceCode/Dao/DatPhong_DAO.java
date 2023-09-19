package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Entity.DatPhong;

import connectDB.ConnectDB;

public class DatPhong_DAO {
	
	private Connection con;
	
	public ArrayList<DatPhong>getAllPhong(){
		ArrayList<DatPhong>Listphong = new ArrayList<DatPhong>();
		String sql = "select * from DatPhong";
		con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				DatPhong x=new DatPhong();
				x.setMaPhong(rs.getInt(1));
				x.setMaNV(rs.getInt(2));
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
	
	public DatPhong getMaNV(int maP) {
		DatPhong dp = null;
		try {
			PreparedStatement stm = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stm = con.prepareStatement("select * from DatPhong where MaPhong = ?");
			stm.setInt(1, maP);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				 int maPhong =rs.getInt("MaPhong");
				 int maNV= rs.getInt("MaNV");
				 dp = new DatPhong(maPhong, maNV);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dp;
	}

	public boolean addDatPhong(DatPhong dp) {
		PreparedStatement stm = null;
		int isInserted = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sqlQuery = "INSERT INTO DatPhong([MaPhong],[MaNV]) VALUES(?,?)";
			stm = con.prepareStatement(sqlQuery);
			stm.setInt(1, dp.getMaPhong());
			stm.setInt(2, dp.getMaNV());
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
	public boolean xoadatphong(String maphong) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt =null;
        String sql = "DELETE FROM DatPhong WHERE MaPhong like ?";
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
}
