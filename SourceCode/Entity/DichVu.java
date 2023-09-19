package Entity;

import java.util.Objects;

public class DichVu {
	
	private int maDV;
	private int maLDV;
	private String tenDV;
	private Double donGia;
	private int MaHDDV;
	
	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DichVu(int maDV, int maLDV, String tenDV, Double donGia, int maHDDV) {
		super();
		this.maDV = maDV;
		this.maLDV = maLDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
		MaHDDV = maHDDV;
	}



	public int getMaHDDV() {
		return MaHDDV;
	}



	public void setMaHDDV(int maHDDV) {
		MaHDDV = maHDDV;
	}



	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public int getMaLDV() {
		return maLDV;
	}

	public void setMaLDV(int maLDV) {
		this.maLDV = maLDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return maDV == other.maDV;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", maLDV=" + maLDV + ", tenDV=" + tenDV + ", donGia=" + donGia + "]";
	}
	
}
