package Entity;

import java.sql.Timestamp;

public class Hoadondv {
private int MaHDDV;
private int maphong;
private Timestamp ngaylap;
public Hoadondv(int maHDDV, int maphong, Timestamp ngaylap) {
	super();
	MaHDDV = maHDDV;
	this.maphong = maphong;
	this.ngaylap = ngaylap;
}
public int getMaHDDV() {
	return MaHDDV;
}
public void setMaHDDV(int maHDDV) {
	MaHDDV = maHDDV;
}
public int getMaphong() {
	return maphong;
}
public void setMaphong(int maphong) {
	this.maphong = maphong;
}
public Timestamp getNgaylap() {
	return ngaylap;
}
public void setNgaylap(Timestamp ngaylap) {
	this.ngaylap = ngaylap;
}

}
