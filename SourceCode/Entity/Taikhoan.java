package Entity;

public class Taikhoan {
private String nametk;
private String matkhau;
private int manv;
public Taikhoan(String nametk, String matkhau) {
	super();
	this.nametk = nametk;
	this.matkhau = matkhau;
}

public Taikhoan(String nametk, String matkhau, int manv) {
	super();
	this.nametk = nametk;
	this.matkhau = matkhau;
	this.manv = manv;
}

public int getManv() {
	return manv;
}

public void setManv(int manv) {
	this.manv = manv;
}

public Taikhoan() {
	super();
	// TODO Auto-generated constructor stub
}

public String getNametk() {
	return nametk;
}
public void setNametk(String nametk) {
	this.nametk = nametk;
}
public String getMatkhau() {
	return matkhau;
}
public void setMatkhau(String matkhau) {
	this.matkhau = matkhau;
}


}
