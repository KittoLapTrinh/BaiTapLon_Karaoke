package Entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PhieuIn {
	
	private int maHD, maKH, maPhong, maHDDV, maNV;
	private String loaiPhong, trangThai, tenPhong, tenNV, gioiTinh;
	private Timestamp ngayDat, gioBD;
	private Double tongTien;
	
	
	public PhieuIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PhieuIn(int maHD, int maKH, int maPhong, int maHDDV, int maNV, String loaiPhong, String trangThai,
			String tenPhong, String tenNV, String gioiTinh, Timestamp ngayDat, Timestamp gioBD, Double tongTien) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maPhong = maPhong;
		this.maHDDV = maHDDV;
		this.maNV = maNV;
		this.loaiPhong = loaiPhong;
		this.trangThai = trangThai;
		this.tenPhong = tenPhong;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.ngayDat = ngayDat;
		this.gioBD = gioBD;
		this.tongTien = tongTien;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public int getMaHDDV() {
		return maHDDV;
	}

	public void setMaHDDV(int maHDDV) {
		this.maHDDV = maHDDV;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Timestamp getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Timestamp ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Timestamp getGioBD() {
		return gioBD;
	}

	public void setGioBD(Timestamp gioBD) {
		this.gioBD = gioBD;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	
	
}
