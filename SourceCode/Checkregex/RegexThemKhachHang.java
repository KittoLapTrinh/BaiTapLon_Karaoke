package Checkregex;

import java.sql.Date;

import javax.swing.JLabel;

public class RegexThemKhachHang {
	public boolean check( JLabel ErrorTenKH, JLabel ErrorPhone, JLabel ErrorEmail, JLabel ErrorDiaChi, String tenKH, String phone, String email, String diaChi) {
		boolean flag = true;
		
		//maKH
		
		//tenKH
		if(tenKH.equals("")) {
			ErrorTenKH.setText("Không được để trống tên khách hàng");
			ErrorTenKH.setVisible(true);
			flag = false;
		}else if((tenKH.matches("^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđA-ZỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1}$"))) {
			ErrorTenKH.setText("Tên phải bắt đầu từ 2 ký tự và in hoa chữ cái đầu");
			ErrorTenKH.setVisible(true);
			flag=false;
		} 
		
		else if(!(tenKH.matches("^[A-ZỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1}[a-zaàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵ]+(\\s[A-ZỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1}[a-zaàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵ]*)*$"))) {
			ErrorTenKH.setText("Các ký tự đầu tiên phải in hoa, các ký tự đi theo sau in thường");
			ErrorTenKH.setVisible(true);
			flag=false;
		}
		else {
			ErrorTenKH.setVisible(false);

		}
		
		
		//sdt
		if (phone.equals("")) {
			ErrorPhone.setText("Không được để trống số điện thoại");
			ErrorPhone.setVisible(true);
			flag=false;
		}
		else if(!(phone.matches("^[0]{1}[973]{1}\\d{8}$"))) {
			ErrorPhone.setText("Sđt bao gồm 10 số và bắt đầu bằng 09 - 07 - 03");
			ErrorPhone.setVisible(true);
			flag=false;
		}
		else {
			ErrorPhone.setVisible(false);

		}
		
		//email
		/*
		 * sau @ là kí tự thường
		 * sau . là là kí tự có độ dài từ 2-4 ( edu|com|vn|net)
		 */
		if((email.equals(""))) {
			ErrorEmail.setText("Không được để trống email");
			ErrorEmail.setVisible(true);
			flag=false;
		}
		else if(!(email.matches("^[a-zA-Z\\d]+@[a-z]+(.[a-z]{2,4})$"))) {
			ErrorEmail.setText("Email không đúng định dạng (@gmail.com)");
			ErrorEmail.setVisible(true);
			flag=false;
		}
		else {
			ErrorEmail.setVisible(false);
		}	
		
		//dia chi
		if((diaChi.equals(""))) {
			ErrorDiaChi.setText("Không được để trống địa chỉ");
			ErrorDiaChi.setVisible(true);
			flag=false;
		}
		else {
			ErrorDiaChi.setVisible(false);
		}
		
		return flag;
	}
}
