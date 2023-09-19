package Entity;

import java.sql.Date;

public class ChiTietHoaDon {
	
	private int maHD;
	private double donGia;
	private double tongGioHat;
	private Date gioVao;
	private Date gioRa;

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChiTietHoaDon(int maHD, double donGia, double tongGioHat, java.util.Date gioVao, java.util.Date gioRa) {
		super();
		this.maHD = maHD;
		this.donGia = donGia;
		this.tongGioHat = tongGioHat;
		this.gioVao = (Date) gioVao;
		this.gioRa = (Date) gioRa;
	}


	public int getMaHD() {
		return maHD;
	}


	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}


	public double getDonGia() {
		return donGia;
	}


	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}


	public double getTongGioHat() {
		return tongGioHat;
	}


	public void setTongGioHat(double tongGioHat) {
		this.tongGioHat = tongGioHat;
	}


	public Date getGioVao() {
		return gioVao;
	}


	public void setGioVao(Date gioVao) {
		this.gioVao = gioVao;
	}


	public Date getGioRa() {
		return gioRa;
	}


	public void setGioRa(Date gioRa) {
		this.gioRa = gioRa;
	}


	@Override
	public String toString() {
		return "ChiTietHoaDon [maHD=" + maHD + ", donGia=" + donGia + ", tongGioHat=" + tongGioHat + ", gioVao="
				+ gioVao + ", gioRa=" + gioRa + "]";
	}
	
}
