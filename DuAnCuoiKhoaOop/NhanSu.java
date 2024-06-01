package DuAnCuoiKhoaOop;

import java.util.ArrayList;

public abstract class NhanSu implements NhapXuat {

//	1. Attriubutes
	protected String maNV;
	protected String tenNV;
	protected String namSinh;
	protected String email;
	protected String soDT;
	protected String maPB;
	protected DanhSachTask objdsTask;
	protected float luong;
	protected float soNgayLamViec;

//	2. Get, set methods
	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public DanhSachTask getObjDsTask() {
		return objdsTask;
	}

	public void setObjDsTask(DanhSachTask objdsTask) {
		this.objdsTask = objdsTask;
	}

	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

//	3. Constructor;	
	
	private void init() {
		this.maPB = "-1";
		this.objdsTask = new DanhSachTask();
	}
	public NhanSu() {
		init();
	}

	public NhanSu(String maNV, String tenNV, String namSinh, String email, String soDT) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDT = soDT;
	}

	public NhanSu(String maNV, String tenNV, String namSinh, String email, String soDT, String maPB,
			float soNgayLamViec) {
		init();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.namSinh = namSinh;
		this.email = email;
		this.soDT = soDT;
		this.maPB = maPB;
		this.soNgayLamViec = soNgayLamViec;
	}

//	4. Input, output methods
	public void xuat() {
		String temp = this.maPB;
		if (this.maPB.equalsIgnoreCase("-1")) {
			temp = "Chua phan bo";
		}
		System.out.println("Ma: " + this.maNV + "\tTen: " + this.tenNV + "\tNam sinh: " + this.namSinh + "\tEmail: " + this.email
				+ "\tSDT: " + this.soDT + "\tMa PB: " + temp + "\tNgay lam: " + this.soNgayLamViec
				+ "\tLuong: " + this.luong);
		
		if (this.objdsTask.getDsTask().size() > 0) {
			System.out.println("Danh sach task ma nhan vien nay dang thuc hien");
			this.objdsTask.xuat();
		}
	}
	
	public void xuatTenvaMa() {
		System.out.println("Ten: "+ this.tenNV + "\tMa: " + this.maNV);
		
	}
//	5. Business methods
	public abstract void tinhLuong();
	

}
