package Checkregex;

import javax.swing.JLabel;

public class RegexDangNhap {
	public boolean check(JLabel ErrorTaiKhoan, JLabel ErrorMatKhau, String txtTaiKhoan, String txtMatKhau) {
		boolean flag = true;
		if(txtTaiKhoan.equals("")) {
			ErrorTaiKhoan.setText("Không được để trống tên đăng nhập");
			ErrorTaiKhoan.setVisible(true);
			flag= false;
		}
		
		else if(!(txtTaiKhoan.matches("^[a-zA-Z]{1}[a-zA-Z\\d]{3,31}$"))) {
			ErrorTaiKhoan.setText("Tài khoản bắt đầu bằng chữ cái không dấu, từ 4-32 ký tự");
			ErrorTaiKhoan.setVisible(true);
			flag=false;
		}
		else {
			ErrorTaiKhoan.setVisible(false);


		} 
		
		if (txtMatKhau.equals("")) {
			ErrorMatKhau.setText("Không được để trống mật khẩu");
			ErrorMatKhau.setVisible(true);
			flag = false;
		}
		else if(!(txtMatKhau.matches("[a-z\\d]{4,32}"))) {
			ErrorMatKhau.setText("Mật khẩu phải có độ dài từ 4-32 ký tự không dấu");
			ErrorMatKhau.setVisible(true);
			flag=false;
		}
		else {
			ErrorMatKhau.setVisible(false);

		}
return flag;
	}

}

