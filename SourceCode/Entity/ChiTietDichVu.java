package Entity;

public class ChiTietDichVu {
	
	private int maDV;
	private int maHD;
	private Double donGia;
	private int soLuong;
	
	public ChiTietDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietDichVu(int maDV, int maHD, Double donGia, int soLuong) {
		super();
		this.maDV = maDV;
		this.maHD = maHD;
		this.donGia = donGia;
		this.soLuong = soLuong;
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

	@Override
	public String toString() {
		return "ChiTietDichVu [maDV=" + maDV + ", maHD=" + maHD + ", donGia=" + donGia + ", soLuong=" + soLuong + "]";
	}
	
}
