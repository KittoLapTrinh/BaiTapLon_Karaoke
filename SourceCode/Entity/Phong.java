package Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class Phong {
	private int maPhong;
	private String loaiPhong;
	private String tenPhong;
	private String trangThai;
	private Timestamp Giobatdau;
	private int giagio;
	private int makh;
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phong(int maPhong, String loaiPhong, String tenPhong, String trangThai, Timestamp giobatdau, int giagio,
			int makh) {
		super();
		this.maPhong = maPhong;
		this.loaiPhong = loaiPhong;
		this.tenPhong = tenPhong;
		this.trangThai = trangThai;
		Giobatdau = giobatdau;
		this.giagio = giagio;
		this.makh = makh;
	}
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Timestamp getGiobatdau() {
		return Giobatdau;
	}
	public void setGiobatdau(Timestamp giobatdau) {
		Giobatdau = giobatdau;
	}
	public int getGiagio() {
		return giagio;
	}
	public void setGiagio(int giagio) {
		this.giagio = giagio;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	
}
