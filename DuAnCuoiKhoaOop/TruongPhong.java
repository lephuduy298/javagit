package DuAnCuoiKhoaOop;

public class TruongPhong extends NhanSu {

	final int LUONG_NGAY = 300;
	final int PHU_CAP = 200;
	final int SO_NGAY = 30;
//	1. Attributes
//	2. Get, set methods
//	3. Constructors
	public TruongPhong() {
		super();
	}
	
	public TruongPhong(String maNV, String tenNV, String namSinh, String email, String soDT, String maPB,
			float soNgayLamViec) {
		super(maNV, tenNV, namSinh, email, soDT, maPB, soNgayLamViec);
	}
//	4. Input, output methods
//	5. Business methods
	@Override
	public void tinhLuong() {
		// TODO Auto-generated method stub

	}

}
