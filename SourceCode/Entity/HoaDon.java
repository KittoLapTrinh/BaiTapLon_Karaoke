package Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class HoaDon {
	private int maHD;
	private int maKH;
	private int maPhong;
	private Timestamp ngayDat;
	private double tongTienDV;
	private Double tongTienPhong;
	private int maNV;
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(int maHD, int maKH, int maPhong, Timestamp ngayDat, double tongTienDV, Double tongTienPhong,
			int maNV) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maPhong = maPhong;
		this.ngayDat = ngayDat;
		this.tongTienDV = tongTienDV;
		this.tongTienPhong = tongTienPhong;
		this.maNV = maNV;
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

	public Timestamp getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Timestamp ngayDat) {
		this.ngayDat = ngayDat;
	}

	public double getTongTienDV() {
		return tongTienDV;
	}

	public void setTongTienDV(double tongTienDV) {
		this.tongTienDV = tongTienDV;
	}

	public Double getTongTienPhong() {
		return tongTienPhong;
	}

	public void setTongTienPhong(Double tongTienPhong) {
		this.tongTienPhong = tongTienPhong;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maKH=" + maKH + ", maPhong=" + maPhong + ", ngayDat=" + ngayDat
				+ ", tongTienDV=" + tongTienDV + ", tongTienPhong=" + tongTienPhong + ", maNV=" + maNV + "]";
	}
	
	
	
}
