package Entity;

import java.time.LocalDateTime;

public class Ca {
	private int MaCa;
	private String TenCa;
	private LocalDateTime ThoiGianBatDau;
	private LocalDateTime ThoiGianKetThuc;
	public Ca(int maCa, String tenCa, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc) {
		super();
		MaCa = maCa;
		TenCa = tenCa;
		ThoiGianBatDau = thoiGianBatDau;
		ThoiGianKetThuc = thoiGianKetThuc;
	}
	public int getMaCa() {
		return MaCa;
	}
	public void setMaCa(int maCa) {
		MaCa = maCa;
	}
	public String getTenCa() {
		return TenCa;
	}
	public void setTenCa(String tenCa) {
		TenCa = tenCa;
	}
	public LocalDateTime getThoiGianBatDau() {
		return ThoiGianBatDau;
	}
	public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
		ThoiGianBatDau = thoiGianBatDau;
	}
	public LocalDateTime getThoiGianKetThuc() {
		return ThoiGianKetThuc;
	}
	public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
		ThoiGianKetThuc = thoiGianKetThuc;
	}
	

}
