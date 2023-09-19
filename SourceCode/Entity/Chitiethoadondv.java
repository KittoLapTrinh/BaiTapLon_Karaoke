package Entity;

public class Chitiethoadondv {
private int MaDV;
private int MaHDDV;
private int soluong;
public Chitiethoadondv(int maDV, int maHDDV, int soluong) {
	super();
	MaDV = maDV;
	MaHDDV = maHDDV;
	this.soluong = soluong;
}
public int getMaDV() {
	return MaDV;
}
public void setMaDV(int maDV) {
	MaDV = maDV;
}
public int getMaHDDV() {
	return MaHDDV;
}
public void setMaHDDV(int maHDDV) {
	MaHDDV = maHDDV;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}

}
