package Entity;

import java.util.Objects;

public class LoaiDichVu {
	
	private int maLDV;
	private String tenLDV;
	
	
	public LoaiDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoaiDichVu(int maLDV, String tenLDV) {
		super();
		this.maLDV = maLDV;
		this.tenLDV = tenLDV;
	}


	public int getMaLDV() {
		return maLDV;
	}


	public void setMaLDV(int maLDV) {
		this.maLDV = maLDV;
	}


	public String getTenLDV() {
		return tenLDV;
	}


	public void setTenLDV(String tenLDV) {
		this.tenLDV = tenLDV;
	}


	@Override
	public int hashCode() {
		return Objects.hash(maLDV, tenLDV);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiDichVu other = (LoaiDichVu) obj;
		return maLDV == other.maLDV && Objects.equals(tenLDV, other.tenLDV);
	}


	@Override
	public String toString() {
		return "LoaiDichVu [maLDV=" + maLDV + ", tenLDV=" + tenLDV + "]";
	}
	
	
}
