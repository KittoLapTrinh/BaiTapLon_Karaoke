package Entity;

public class Dichvudadat {
	
	private int maDV;
	private int maHD;
	private Double donGia;
	private int soLuong;
	private String loaidv;
	private double tongtien;
	
	public Dichvudadat(int maDV, Double donGia, int soLuong, String loaidv, double tongtien) {
		super();
		this.maDV = maDV;
		this.maHD = maHD;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.loaidv = loaidv;
		this.tongtien = tongtien;	
	}
	public Dichvudadat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaDV() {
		return maDV;
	}
	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public Double getDonGia() {
		return donGia;
	}
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getLoaidv() {
		return loaidv;
	}
	public void setLoaidv(String loaidv) {
		this.loaidv = loaidv;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	
	
	
	
}
