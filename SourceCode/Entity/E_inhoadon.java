package Entity;

public class E_inhoadon {
private String tendv;
private double dongia;
private int soluong;
private double tongtien;
public E_inhoadon(String tendv, double dongia, int soluong, double tongtien) {
	super();
	this.tendv = tendv;
	this.dongia = dongia;
	this.soluong = soluong;
	this.tongtien = tongtien;
}
public String getTendv() {
	return tendv;
}
public void setTendv(String tendv) {
	this.tendv = tendv;
}
public double getDongia() {
	return dongia;
}
public void setDongia(double dongia) {
	this.dongia = dongia;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}
public double getTongtien() {
	return tongtien;
}
public void setTongtien(double tongtien) {
	this.tongtien = tongtien;
}

}
