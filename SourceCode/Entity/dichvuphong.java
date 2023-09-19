package Entity;

public class dichvuphong {

private int maphong;
private int MaHDDV;
private int Madv;
private int soluong;
private String tenDV;
private int maloaidv;
private double dongia;

public dichvuphong( int maphong, int maHDDV, int madv, int soluong, String tenDV, int maloaidv, double dongia) {
	super();
	this.maphong = maphong;
	MaHDDV = maHDDV;
	Madv = madv;
	this.soluong = soluong;
	this.tenDV = tenDV;
	this.maloaidv = maloaidv;
	this.dongia = dongia;
}
public int getMaphong() {
	return maphong;
}
public void setMaphong(int maphong) {
	this.maphong = maphong;
}
public int getMaHDDV() {
	return MaHDDV;
}
public void setMaHDDV(int maHDDV) {
	MaHDDV = maHDDV;
}
public int getMadv() {
	return Madv;
}
public void setMadv(int madv) {
	Madv = madv;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public String getTenDV() {
	return tenDV;
}
public void setTenDV(String tenDV) {
	this.tenDV = tenDV;
}
public int getMaloaidv() {
	return maloaidv;
}
public void setMaloaidv(int maloaidv) {
	this.maloaidv = maloaidv;
}

public double getDongia() {
	return dongia;
}
public void setDongia(double dongia) {
	this.dongia = dongia;
}


}
