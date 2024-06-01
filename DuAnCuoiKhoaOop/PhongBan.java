package DuAnCuoiKhoaOop;

import java.util.ArrayList;

public class PhongBan implements NhapXuat {

//	1. Attributes
	private String maPhongBan;
	private String tenPhongBan;
	private TruongPhong truongPhong;
	private ArrayList<NhanVienThuong> dsNV;

//	2. Get, set methods
	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	public ArrayList<NhanVienThuong> getDsNV() {
		return dsNV;
	}

	public void setDsNV(ArrayList<NhanVienThuong> dsNV) {
		this.dsNV = dsNV;
	}

//	3. Constructors
	public PhongBan() {
		this.truongPhong = null;
		this.dsNV = new ArrayList<NhanVienThuong>();
	}

	public PhongBan(String maPhongBan, String tenPhongBan) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.dsNV = new ArrayList<NhanVienThuong>();
	}

//	4. Input, output methods
//	5. Business methods
	@Override
	public void xuat() {
		System.out.println("*************Day la thong tin phong ban*****************");
		System.out.println("Ma PB: " + this.maPhongBan + "\tTen Phong Ban: " + this.tenPhongBan);
		if (this.truongPhong != null) {
			System.out.println("Thong tin truong phong");
			this.truongPhong.xuat();
		} else
			System.out.println("Chua co truong phong");
		for (NhanVienThuong nvt : this.dsNV)
			nvt.xuat();
		
		System.out.println("===========================================");
	}

}
