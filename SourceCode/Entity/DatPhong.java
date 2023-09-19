package Entity;

public class DatPhong {
	private int maPhong, maNV;

	public DatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatPhong(int maPhong, int maNV) {
		super();
		this.maPhong = maPhong;
		this.maNV = maNV;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return "DatPhong [maPhong=" + maPhong + ", maNV=" + maNV + "]";
	}
	
}
