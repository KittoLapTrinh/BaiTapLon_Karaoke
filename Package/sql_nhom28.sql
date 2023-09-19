create database ql_karaoke

go

use ql_karaoke

go

create table NhanVien (
MaNV int identity(1001,1) not null,
TenNV nvarchar(30) not null,
GioiTinh nvarchar(3) not null check (GioiTinh in (N'Nam',N'Nữ')),
CCCD varchar(10) not null,
Phone varchar(10),
ChucVu nvarchar(4) not null check (ChucVu in ('NVQL','NVTN')),
DiaChi nvarchar(100),
NgaySinh Date,
Luong money check (Luong > 0)	
constraint PK_NhanVien primary key (MaNV))
go

create table DatPhong (
MaPhong int,
MaNV  int
)
go
create table Phong (
MaPhong int identity(01,1) not null,
LoaiPhong nvarchar(10) not null check (LoaiPhong in (N'Vip',N'Thường')),
TenPhong as 'P0'+ cast (MaPhong as varchar(10)),
TrangThai nvarchar(20) not null check (TrangThai in (N'Đang sử dụng', N'Bảo trì', N'Còn trống')),
GioBatDau datetime,
MaKH int,
Giagio int 

constraint PK_Phong primary key (MaPhong))
go 


create table TaiKhoan (
TenTK nvarchar(10) not null,
MatKhau nvarchar(10) not null,
MaNV int not null
constraint PK_TK primary key (TenTK))

go

create table HoaDon (
MaHD int identity (2000,1)not null,
MaKH  int not null,
MaPhong int not null,
NgayDatPhong datetime,
Tongtiendichvu int,
TongTienPhong money check (TongTienPhong > 0),
MaNV int not null
constraint PK_HD primary key (MaHD))
go
create table KhachHang (
MaKh int identity(1001,1) not null,
TenKH nvarchar(30) not null,
GioiTinh nvarchar(3) not null check (GioiTinh in (N'Nam',N'Nữ')),
NgaySinh date,
Phone varchar(10),
Email nvarchar(30),
DiaChi nvarchar(255)
constraint PK_KH primary key (MaKH))
go
create table ChiTietDichVu (
MaDV int not null,
DonGia int check (DonGia >=0),
SoLuong int check (SoLuong > 0)
)
go
create table DichVu (
MaDV int identity(3000,1) not null,
MaLoaiDV int,
MaHDDV int,
TenDV nvarchar(20) not null,
DonGia money not null check (DonGia > 0),
constraint PK_DV primary key (MaDV))
go
create table HoaDonDichVu(
MaHDDV int identity(1,1) not null,
MaPhong int not null,
NgayLap datetime
constraint PK_HDDV primary key(MaHDDV))
go
create table ChiTietHoaDonDichVu (
MaDV int not null,
MaHDDV int not null,
SoLuong int check (SoLuong > 0)
)
go
create table LoaiDichVu(
MaLoaiDV int identity(1,1) NOT NULL,
TenLoaiDV nvarchar(20),
constraint PK_LOAIDICHVU primary key (MaLoaiDV)
)
go 
alter table TaiKhoan add constraint FK_TK_NV foreign key (MaNV) references NhanVien (MaNV)
alter table DatPhong add constraint FK_DP_NV foreign key (MaNV ) references NhanVien (MaNV )
alter table HoaDon add constraint FK_HD_NV foreign key (MaNV ) references NhanVien (MaNV )
alter table DatPhong add constraint FK_p foreign key (MaPhong) references Phong (MaPhong)
alter table HoaDon add constraint FK_HD_P foreign key (MaPhong) references Phong (MaPhong)
alter table HoaDon add constraint FK_HD_KH foreign key (MaKH) references KhachHang (MaKH)



alter table ChiTietDichVu add constraint FK_CTDV_DV foreign key (MaDV) references DichVu (MaDV)
alter table DichVu add constraint FK_DV_LDV foreign key (MaLoaiDV) references LoaiDichVu (MaLoaiDV)
alter table HoaDonDichVu add constraint FK_HDDV foreign key (MaPhong) references Phong(MaPhong)
alter table ChiTietHoaDonDichVu add constraint FK_CTHDDV foreign key (MaHDDV) references HoaDonDichVu (MaHDDV)
alter table ChiTietHoaDonDichVu add constraint FK_CTHDDV_DV foreign key (MaDV) references DichVu (MaDV)
alter table Phong add constraint FK_PKH_KH foreign key (MaKH) references KhachHang (MaKH)

go

insert into dbo.NhanVien values (N'Nguyễn Minh Tú',N'Nam','1234567890','0935334999',N'NVTN',N'Nguyễn Văn Bảo','2001-10-05','10000000')
insert into dbo.NhanVien values (N'Vũ Thế Kiệt',N'Nam','1234567891','0935334991',N'NVTN',N'Nguyễn Văn Bảo','2001-10-06','10100000')
insert into dbo.NhanVien values (N'Nguyễn Thành Doanh',N'Nam','1234567892','0935334765',N'NVTN',N'Nguyễn Văn Bảo','2001-10-07','10200000')
insert into dbo.NhanVien values (N'Dương Tuấn Kiệt',N'Nam','1234567893','0935334998',N'NVTN',N'Nguyễn Văn Bảo','2001-10-08','10300000')
insert into dbo.NhanVien values (N'Nguyễn Thúc Thùy Tiên',N'Nữ','1234555421','0949489270',N'NVQL',N'Sa Đéc','2001-12-11','20000000')
insert into dbo.NhanVien values (N'Nguyễn Thanh Tùng',N'Nam','1237854211','0949475621',N'NVQL',N'Thái Bình','2009-09-17','2000000')
insert into dbo.NhanVien values (N'Trần Thùy Chi',N'Nữ','0754555421','0949178901',N'NVTN',N'Hải Dương','2002-04-03','20000000')
insert into dbo.NhanVien values (N'Nguyễn Minh Tùng',N'Nam','0123456789','0973768651',N'NVQL',N'Quận 1','1997-01-16','11111111')
insert into dbo.NhanVien values (N'Khánh Vi',N'Nữ','1075438742','0945881905',N'NVTN',N'Tân Bình','2001-09-13','20000000')
insert into dbo.NhanVien values (N'Thanh Tú',N'Nam','1099215682','0338313043',N'NVTN',N'Quận 4','2000-04-19','10000000')
insert into dbo.NhanVien values (N'Lê Ngô Đồng',N'Nam','1018255542','0978154509',N'NVQL',N'Đà Lạt','2000-12-29','10000000')
insert into dbo.NhanVien values (N'Nguyễn Xuân Ảnh',N'Nữ','1072155542','0915467229',N'NVTN',N'Hải Dương','2002-04-03','10000000')
insert into dbo.NhanVien values (N'Lê Thị Hồng Quyên',N'Nữ','1023456542','0397008329',N'NVTN',N'Hải Dương','2002-04-03','10000000')
insert into dbo.NhanVien values (N'Nguyễn Thị Minh Tâm',N'Nữ','1234567890','0935123469',N'NVTN',N'Tây Ninh','2001-11-15','10000000')
insert into dbo.NhanVien values (N'Trịnh Minh Hiếu',N'Nam','1241257845','0356853029',N'NVQL',N'Vũng Tàu','1998-09-23','30000000')

go

insert into dbo.TaiKhoan values (N'admin',N'12345','1005')
insert into dbo.TaiKhoan values (N'nvtn001',N'nvtn1','1001')
insert into dbo.TaiKhoan values (N'nvtn002',N'nvtn2','1002')
insert into dbo.TaiKhoan values (N'nvtn003',N'nvtn3','1003')
insert into dbo.TaiKhoan values (N'nvtn004',N'nvtn4','1004')

go

insert into dbo.KhachHang  values (N'Văn Quyết',N'Nam','2001-10-12','0935334211',N'bundau112@gmail.com',N'Quận 12')
insert into dbo.KhachHang  values (N'Vũ Thị Thu Trang',N'Nữ','1999-03-17','0935367532',N'bacxiumaidinh@gmail.com',N'Gò Vấp')
insert into dbo.KhachHang  values (N'Trần Thị Thanh Vân',N'Nữ','2001-04-21','0935378908',N'comtam001@gmail.com',N'Gò Vấp')
insert into dbo.KhachHang  values (N'Nguyễn Văn Hải',N'Nam','2000-01-23','0935123578',N'mitom@gmail.com',N'Gò Vấp')
insert into dbo.KhachHang  values (N'Nguyễn Thị Xuân Hương ',N'Nữ','1976-09-18','0957445511',N'conmeo12@gmail.com',N'Cần Thơ')
insert into dbo.KhachHang  values (N'Huỳnh Trọng Thoại',N'Nam','1987-06-24','0876448899',N'buonmasx@gmail.com',N'Đà Nẵng')
insert into dbo.KhachHang  values (N'Nguyễn Văn Khải',N'Nam','2000-12-13','0904183670',N'haiauxanh@gmail.com',N'Đồng Tháp')
insert into dbo.KhachHang  values (N'Vũ Đức Thọ',N'Nam','1999-11-27','0913005356',N'kkylin21@gmail.com',N'TPHCM')
insert into dbo.KhachHang  values (N'Trần Thúy Hằng',N'Nữ','2002-04-11','0989304825',N'luckyluck@gmail.com',N'Quận 1')
insert into dbo.KhachHang  values (N'Lê Thị Thu',N'Nữ','2002-06-21','0985023327',N'thithu121@gmail.com',N'Quận 1')
insert into dbo.KhachHang  values (N'Vũ Thị Hà',N'Nữ','2002-02-11','0904902487',N'thiha21@gmail.com',N'Quận 1')
insert into dbo.KhachHang  values (N'Kiều Thị Bích Ngọc',N'Nữ','2002-10-08','0166095559',N'bichngoc1@gmail.com',N'Quận 1')
insert into dbo.KhachHang  values (N'Phạm Đỗ Chung',N'Nam','2000-01-12','0912479960',N'dochung87@gmail.com',N'Bến Tre')
insert into dbo.KhachHang  values (N'Nguyễn Văn Hợp',N'Nam','2004-07-17','0935151177',N'vanhoppp@gmail.com',N'Phú Yên')
insert into dbo.KhachHang  values (N'Đinh Quang Vinh',N'Nam','2003-05-23','0965117577',N'wangzinh@gmail.com',N'Nam Định')
insert into dbo.KhachHang  values (N'Bùi Văn Phúc',N'Nam','2003-03-05','0931719621',N'danphucc@gmail.com',N'Sơn La')
insert into dbo.KhachHang  values (N'Vũ Đình Giáp',N'Nam','2000-07-11','0935123578',N'dinhgiap@gmail.com',N'Gò Vấp')
insert into dbo.KhachHang  values (N'Châu',N'Nữ','2002-06-19','0169450540',N'chauga@gmail.com',N'Quận 11')
insert into dbo.KhachHang  values (N'Đào Như Mai',N'Nữ','2000-05-29','0971553661',N'daonhumai@gmail.com',N'Gò Vấp')
insert into dbo.KhachHang  values (N'Nguyễn Thị Lụa',N'Nữ','2001-11-03','0988906107',N'thiluaa@gmail.com',N'Tân Phú')
insert into dbo.KhachHang  values (N'Lê Hoàng Yến',N'Nữ','2002-12-01','0336768369',N'hoangyin@gmail.com',N'Quận 8')
insert into dbo.KhachHang  values (N'Trần Văn Hồ',N'Nam','2001-08-25','0988338703',N'vanhooo@gmail.com',N'Quận 7')
insert into dbo.KhachHang  values (N'Nguyễn Minh Chí',N'Nam','2003-04-14','0918236431',N't1maidinh@gmail.com',N'Quận 12')
insert into dbo.KhachHang  values (N'Nguyễn Văn Dư Nhân',N'Nam','2001-12-11','0912614141',N'dunhaann@gmail.com',N'Quận 4')
insert into dbo.KhachHang  values (N'Huỳnh Minh Trí',N'Nam','2003-02-24','0989622414',N'minhtriii@gmail.com',N'Quận 5')
insert into dbo.KhachHang  values (N'Phạm Tuyết Sương',N'Nữ','2000-10-17','0986558641',N'tutetsuong@gmail.com',N'Quận 12')
insert into dbo.KhachHang  values (N'Dương Hồng Phúc',N'Nam','1973-01-02','0353477489',N'hongphuc@gmail.com',N'Bình Thuận')
insert into dbo.KhachHang  values (N'Nguyễn Thị Yến Vy',N'Nữ','2002-02-19','0167896143',N'vynguyen22@gmail.com',N'Quảng Ngãi')
insert into dbo.KhachHang  values (N'Đào Duy Anh',N'Nam','1986-09-12','0906994074',N'duyanh@gmail.com',N'Bắc Ninh')
insert into dbo.KhachHang  values (N'Vũ Phương Nhi',N'Nữ','1994-10-20','0167558648',N'sironhi20@gmail.com',N'Nam Định')
insert into dbo.KhachHang  values (N'Võ Quốc Huy',N'Nam','1999-11-30','0976556712',N'huyvo@gmail.com',N'Quảng Ngãi')
insert into dbo.KhachHang  values (N'Trần Thị Kim Phụng',N'Nữ','1989-12-06','0343774961',N'phungtran@gmail.com',N'Cà Mau')
insert into dbo.KhachHang  values (N'Võ Văn Kiệt',N'Nam','1979-03-07','0935151177',N'vokiet@gmail.com',N'Đồng Tháp')
insert into dbo.KhachHang  values (N'Nguyễn Thị Đào',N'Nữ','1993-10-06','0906918273',N'daonguyen03@gmail.com',N'Kiêng Giang')
insert into dbo.KhachHang  values (N'Trần Dần',N'Nam','1967-10-09','0165778912',N'trandanbrvt@gmail.com',N'Đà Nẵng')
insert into dbo.KhachHang  values (N'Dương Thị Mưởng',N'Nữ','2000-08-28','0935151177',N'muongduong2000@gmail.com',N'Tân Phú')
insert into dbo.KhachHang  values (N'Võ Ngọc Anh Tú',N'Nam','1981-05-15','0906919394',N'tuvo1981@gmail.com',N'Bình Thuận')
insert into dbo.KhachHang  values (N'Đỗ Thị Ngọc Bích',N'Nữ','1983-07-29','0907557612',N'bichdoh1983@gmail.com',N'Huế')
insert into dbo.KhachHang  values (N'Lương Duy Cường',N'Nam','1995-10-12','0906156812',N'cuongluongth1@gmail.com',N'Thanh hóa')
insert into dbo.KhachHang  values (N'Phan Anh Tuấn',N'Nam','1975-09-18','0935378908',N'tuanphan18@gmail.com',N'Tây Ninh')
insert into dbo.KhachHang  values (N'Lý Nhã Kỳ',N'Nữ','1989-05-22','0876448899',N'nhakybtn@gmail.com',N'Đà Nẵng')
insert into dbo.KhachHang  values (N'Phạm Thị Hồng Ngọc',N'Nữ','1999-07-19','0904902487',N'hongngoc1999@gmail.com',N'Bình Dương')
insert into dbo.KhachHang  values (N'Cao Tùng Anh',N'Nam','1980-01-11','0918236431',N'tunganh1980@gmail.com',N'Tiền Giang')
insert into dbo.KhachHang  values (N'Vũ Thị Tường Vy',N'Nữ','1997-04-25','0971553661',N'tuongvy@gmail.com',N'Lào Cai')
insert into dbo.KhachHang  values (N'Đồng Ngoc Huy',N'Nam','1984-12-09','0906994074',N'huydong@gmail.com',N'Sơn La')
insert into dbo.KhachHang  values (N'Phạm Thị Hòa',N'Nữ','1992-09-09','0167896143',N'hoapham09@gmail.com',N'Phú Yên')
insert into dbo.KhachHang  values (N'Võ Văn Vũ',N'Nam','1999-11-06','0353477489',N'vuvan@gmail.com',N'Đồng Tháp')
insert into dbo.KhachHang  values (N'Nguyễn Thị Hòa Khánh',N'Nữ','1989-11-22','0134778765',N'khanhnguyen22@gmail.com',N'Hải Phòng')

go


insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values (N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai,MaKH)values(N'Thường',N'Còn Trống',null)
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')
insert into dbo.Phong(LoaiPhong,TrangThai)values(N'Vip',N'Còn Trống')

go




go

go 












go

insert into dbo.LoaiDichVu values(N'Nước giải khát')
insert into dbo.LoaiDichVu values(N'Thức ăn')

go

insert into dbo.DichVu values('1','1',N'Nước suối','50000')
insert into dbo.DichVu values('1','2',N'Trái Cây','100000')
insert into dbo.DichVu values('2','3',N'Mì Xào','50000')
insert into dbo.DichVu values('1','4','Bò Húc','90000')
insert into dbo.DichVu values('2','5',N'Cơm trộn','75000')
insert into dbo.DichVu values('1','6',N'Bia','100000')
insert into dbo.DichVu values('1','7',N'Chivas 19','1000000')
insert into dbo.DichVu values('1','8',N'Chivas 21','1200000')
insert into dbo.DichVu values('1','9',N'Soju','200000')
insert into dbo.DichVu values('2','10','Bánh mì','10000')
insert into dbo.DichVu values('1','11',N'Rượu gạo','150000')
insert into dbo.DichVu values('2','12',N'Lẩu','300000')
insert into dbo.DichVu values('2','13',N'Đậu phộng','50000')
insert into dbo.DichVu values('2','14',N'Phô mai','80000')
insert into dbo.DichVu values('2','15',N'Hạt điều','30000')
insert into dbo.DichVu values('2','16',N'Hạt dẻ','50000')
insert into dbo.DichVu values('1','17',N'Bia Heneken','30000')
insert into dbo.DichVu values('2','18',N'Khô mực','310000')
insert into dbo.DichVu values('2','19',N'Chả dò','250000')
insert into dbo.DichVu values('1','20',N'Cam vắt','50000')
insert into dbo.DichVu values('1','22',N'Cam vắt mật ong','55000')
insert into dbo.DichVu values('1','23',N'Cam xí muội','60000')
insert into dbo.DichVu values('1','24',N'Chanh đá','40000')
insert into dbo.DichVu values('1','25',N'Chanh muối','40000')
insert into dbo.DichVu values('1','26',N'Bia Heneken bạc','35000')
insert into dbo.DichVu values('1','27',N'Bia Tiger','25000')
insert into dbo.DichVu values('2','29',N'Mì Kim Chi','200000')
insert into dbo.DichVu values('2','30',N'Cơm Chiên','200000')
insert into dbo.DichVu values('2','31',N'Khô Cá Đuối','450000')
insert into dbo.DichVu values('2','32',N'Ốc Giác','400000')
insert into dbo.DichVu values('1','33',N'Trà Lipton','40000')
insert into dbo.DichVu values('1','34',N'Trà Gừng','40000')



go

/* Hóa đơn new
*/
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1006','3','2022-10-15 11:15:08.047','350000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1003','6','2022-07-30 11:15:08.047','180000','130000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1026','9','2022-02-22 11:15:08.047','140000','430000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1005','11','2022-01-27 11:15:08.047','260000','150000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1001','8','2022-12-08 11:15:08.047','155000','360000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1008','2','2022-03-19 11:15:08.047','550000','245000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1017','5','2022-12-16 11:15:08.047','365000','375000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1035','10','2022-08-16 11:15:08.047','180000','150000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1011','11','2022-12-30 11:15:08.047','290000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1038','4','2022-09-27 11:15:08.047','350000','5000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1016','3','2022-07-22 11:15:08.047','750000','375000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1029','7','2022-04-07 11:15:08.047','440000','430000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1010','3','2022-02-16 11:15:08.047','670000','130000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1027','9','2022-03-08 11:15:08.047','25000','260000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1016','3','2022-05-24 11:15:08.047','260000','190000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1001','6','2022-11-07 11:15:08.047','685000','250000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1025','8','2022-07-22 11:15:08.047','475000','360000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1038','2','2022-12-16 11:15:08.047','180000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1045','10','2022-08-16 11:15:08.047','670000','430000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1021','4','2022-03-16 11:15:08.047','670000','250000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1019','6','2022-12-24 11:15:08.047','350000','150000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1015','7','2022-04-16 11:15:08.047','180000','245000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1033','2','2022-07-19 11:15:08.047','140000','130000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1041','3','2022-01-16 11:15:08.047','750000','360000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1022','9','2022-08-07 11:15:08.047','550000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1006','3','2022-10-15 11:15:08.047','350000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1003','6','2022-07-30 11:15:08.047','180000','130000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1026','9','2022-02-22 11:15:08.047','140000','430000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1005','11','2022-01-27 11:15:08.047','260000','150000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1001','8','2022-12-08 11:15:08.047','155000','360000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1008','2','2022-03-19 11:15:08.047','550000','245000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1017','5','2022-12-16 11:15:08.047','365000','375000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1035','10','2022-08-16 11:15:08.047','180000','150000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1011','11','2022-12-30 11:15:08.047','290000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1038','4','2022-09-27 11:15:08.047','350000','5000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1016','3','2022-07-22 11:15:08.047','750000','375000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1029','7','2022-04-07 11:15:08.047','440000','430000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1010','3','2022-02-16 11:15:08.047','670000','130000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1027','9','2022-03-08 11:15:08.047','25000','260000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1016','3','2022-05-24 11:15:08.047','260000','190000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1001','6','2022-11-07 11:15:08.047','685000','250000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1025','8','2022-07-22 11:15:08.047','475000','360000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1038','2','2022-12-16 11:15:08.047','180000','650000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1045','10','2022-08-16 11:15:08.047','670000','430000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1021','4','2022-03-16 11:15:08.047','670000','250000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1019','6','2022-12-24 11:15:08.047','350000','150000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1015','7','2022-04-16 11:15:08.047','180000','245000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1033','2','2022-07-19 11:15:08.047','140000','130000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1041','3','2022-01-16 11:15:08.047','750000','360000','1003')
INSERT INTO HoaDon([MaKH], [MaPhong], [NgayDatPhong], [Tongtiendichvu], [TongTienPhong], [MaNV]) values ('1022','9','2022-08-07 11:15:08.047','550000','650000','1003')
go

go

update Phong
  set Giagio = case 
                  when LoaiPhong LIKE 'Vip' then 300000
                  else 150000
                 end

go

select *from HoaDonDichVu
select *from ChiTietDichVu
select *from DichVu
select *from LoaiDichVu
select *from HoaDon
select *from DatPhong
select *from Phong
select *from KhachHang
select *from TaiKhoan
select *from NhanVien
select *from ChiTietHoaDonDichVu
select * from HoaDonDichVu