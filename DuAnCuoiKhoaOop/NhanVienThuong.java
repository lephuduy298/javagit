package DuAnCuoiKhoaOop;

public class NhanVienThuong extends NhanSu {
	
	final int LUONG_NGAY = 200;
	final int PHU_CAP_1 = 300;
	final int PHU_CAP_2 = 1000;
	final int SO_NGAY = 30;
//	1. Attributes
//	2. Get, set methods
//	3. Constructors
	public NhanVienThuong() {
		super();
	}
	
	public NhanVienThuong(String maNV, String tenNV, String namSinh, String email, String soDT, String maPB,
			float soNgayLamViec) {
		super(maNV, tenNV, namSinh, email, soDT, maPB, soNgayLamViec);
	}
//	4. Input, output methods
//	5. Business methods
	@Override
	public void tinhLuong() {
		float phuCap = 0;
		float tongGioLam = 0;
		for(Task task: this.objdsTask.getDsTask()) {
			tongGioLam += task.getGioLam();
		}
		if (tongGioLam < 35) {
			phuCap = PHU_CAP_1;
		}
		else if(tongGioLam > 35) {
			phuCap = PHU_CAP_2;
		}
		this.luong = LUONG_NGAY*SO_NGAY + phuCap;
	}

}
