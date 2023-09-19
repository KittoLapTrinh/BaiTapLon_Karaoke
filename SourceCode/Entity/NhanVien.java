package Entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
private int MaNV;
private String TenNV;
private String GioiTinh;
private String CCCD;
private String Phone;
private String ChucVu;
private String DiaChi;
private Date NgaySinh;
private double Luong;



public NhanVien() {
	super();
}

public NhanVien(int maNV, String tenNV, String gioiTinh, String cCCD, String phone, String chucVu, String diaChi,
		Date ngaySinh, double luong) {
	super();
	MaNV = maNV;
	TenNV = tenNV;
	GioiTinh = gioiTinh;
	CCCD = cCCD;
	Phone = phone;
	ChucVu = chucVu;
	DiaChi = diaChi;
	NgaySinh = ngaySinh;
	Luong = luong;
}

public int getMaNV() {
	return MaNV;
}

public void setMaNV(int maNV) {
	MaNV = maNV;
}

public String getTenNV() {
	return TenNV;
}

public void setTenNV(String tenNV) {
	TenNV = tenNV;
}

public String getGioiTinh() {
	return GioiTinh;
}

public void setGioiTinh(String gioiTinh) {
	GioiTinh = gioiTinh;
}

public String getCCCD() {
	return CCCD;
}

public void setCCCD(String cCCD) {
	CCCD = cCCD;
}

public String getPhone() {
	return Phone;
}

public void setPhone(String phone) {
	Phone = phone;
}

public String getChucVu() {
	return ChucVu;
}

public void setChucVu(String chucVu) {
	ChucVu = chucVu;
}

public String getDiaChi() {
	return DiaChi;
}

public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
}

public Date getNgaySinh() {
	return NgaySinh;
}

public void setNgaySinh(Date ngaySinh) {
	NgaySinh = ngaySinh;
}

public double getLuong() {
	return Luong;
}

public void setLuong(double luong) {
	Luong = luong;
}

@Override
public int hashCode() {
	return Objects.hash(CCCD, MaNV);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	NhanVien other = (NhanVien) obj;
	return Objects.equals(CCCD, other.CCCD) && MaNV == other.MaNV;
}

@Override
public String toString() {
    return "NhanVien [MaNV=" + MaNV + ", TenNV=" + TenNV + ", CCCD=" + CCCD + ", Phone=" + Phone
            + ", ChucVu=" + ChucVu + ", DiaChi=" + DiaChi + ", NgaySinh=" + NgaySinh + ", Luong=" + Luong + ", GioiTinh=" + GioiTinh + "]";
}

}

