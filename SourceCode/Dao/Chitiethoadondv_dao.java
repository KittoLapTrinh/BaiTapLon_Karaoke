package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entity.Chitiethoadondv;
import Entity.Hoadondv;
import connectDB.ConnectDB;

public class Chitiethoadondv_dao {
	private Connection con;
	public boolean addchitiethoadondv(Chitiethoadondv cthddv) {
        try {
        	con = ConnectDB.getConnection();
            PreparedStatement nvAdd = con.prepareStatement("INSERT INTO ChiTietHoaDonDichVu ([MaDV],[MaHDDV],[SoLuong]) VALUES(?,?,?)");
            nvAdd.setInt(1,cthddv.getMaDV());
            nvAdd.setInt(2,cthddv.getMaHDDV());
            nvAdd.setInt(3, cthddv.getSoluong());
            int n = nvAdd.executeUpdate();
            if(n > 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
