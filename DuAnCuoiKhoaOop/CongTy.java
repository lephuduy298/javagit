package DuAnCuoiKhoaOop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CongTy implements NhapXuat {

//	1. Attributes
	private String tenCongTy;
	private String maSoThue;
	private float tongLuong;
	private DanhSachNhanSu objDSNhanSu;
	private DanhSachPhongBan objDSPhongBan;
	private DanhSachTask objDSTask;
	private ArrayList<TruongPhong> dsTruongPhong;
//	2. Get, set methods

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public DanhSachNhanSu getObjDSNhanSu() {
		return objDSNhanSu;
	}

	public void setObjDSNhanSu(DanhSachNhanSu objDSNhanSu) {
		this.objDSNhanSu = objDSNhanSu;
	}

	public DanhSachPhongBan getObjDSPhongBan() {
		return objDSPhongBan;
	}

	public void setObjDSPhongBan(DanhSachPhongBan objDSPhongBan) {
		this.objDSPhongBan = objDSPhongBan;
	}

	public DanhSachTask getObjDSTask() {
		return objDSTask;
	}

	public void setObjDSTask(DanhSachTask objDSTask) {
		this.objDSTask = objDSTask;
	}

	public ArrayList<TruongPhong> getDsTruongPhong() {
		return dsTruongPhong;
	}

	public void setDsTruongPhong(ArrayList<TruongPhong> dsTruongPhong) {
		this.dsTruongPhong = dsTruongPhong;
	}

	// 3. Constructors
	public CongTy() {
		this.dsTruongPhong = new ArrayList<TruongPhong>();
	}

	//	4. Input, output methods
//	5. Business methods
	@Override
	public void xuat() {
		// TODO Auto-generated method stub

	}

	public void xuatNS() {
		this.objDSNhanSu.xuat();
	}

	public void xuatTask() {
		this.objDSTask.xuat();
	}

	public void xuatPB() {
		this.objDSPhongBan.xuat();
	}

	public void taoDuLieu() {
		this.objDSNhanSu = new DanhSachNhanSu();
		this.objDSNhanSu.taoDuLieu();

		this.objDSTask = new DanhSachTask();
		this.objDSTask.taoDuLieu();

		this.objDSPhongBan = new DanhSachPhongBan();
		this.objDSPhongBan.taoDuLieu();
		
		layDSTruongPhong();
	}

	public void inLuaChon() {
		System.out.println("1. Phan Bo NV");
		System.out.println("2. Bo Qua va tiep tuc");
		System.out.print("Moi ban lua chon: ");
	}
	
	public String luaChonPhongBan(Scanner scan) {
		String maP = "-1";
		while (maP.equalsIgnoreCase("-1")) {
			System.out.print("Vui long nhap phong ban cho nhan vien: ");
			String maPh = scan.nextLine();
			for (PhongBan pb : this.objDSPhongBan.getDsPhongBan()) {
				if (pb.getMaPhongBan().equalsIgnoreCase(maPh)) {
					maP = maPh;
					break;
				}
			}
		}
		return maP;
	}

	public void phanBoNhanVien() {

		// Duyet danh sach nhan vien
		// In ra nhan vien do
		// Hoi xem co muon phan bo nhan vien nay hay khong
		// 1. Co phan bo nhan vien => In danh sach phong ban => Chon phong ban
		// 2. Tiep tuc, khong phan bo
		Scanner scan = new Scanner(System.in);
		for (NhanSu ns : this.objDSNhanSu.getDsNhanSu()) {
			if (ns instanceof NhanVienThuong) {
				boolean flag = true;
				while (flag) {
					System.out.println("Day la thong tin nhan vien");
					ns.xuatTenvaMa();
					inLuaChon();
					int choice = Integer.parseInt(scan.nextLine());
					switch (choice) {
					case 1:
						System.out.println("Day la danh sach phong ban");
						xuatPB();
						String maPhong = luaChonPhongBan(scan);
						PhongBan pb = layPhongBan(maPhong);
						if (pb != null) {
							// them ma phong ban cho nha vien
							ns.setMaPB(maPhong);
							// them nhan vien vao phong ban
							pb.getDsNV().add((NhanVienThuong) (ns));
							System.out.println("Phan bo nhan vien thanh cong");
						}
						flag = false;
						break;
					case 2:
						flag = false;
						break;
					default:
						System.out.println("Chỉ được nhập 1 hoặc 2");
					}
				}
			}
		}
	}

	private PhongBan layPhongBan(String maPhong) {
		for (PhongBan pb : this.objDSPhongBan.getDsPhongBan()) {
			if (pb.getMaPhongBan().equalsIgnoreCase(maPhong)) {
				return pb;
			}
		}
		return null;
	}

	public void phanBoTruongPhong() {

		// Duyet danh sach truong phong
		// In ra danh sach truong phong
		// Hoi xem co muon phan bo truong phong nay hay khong
		// 1. Co phan bo nhan vien => In danh sach phong ban => Chon phong ban
		// 2. Tiep tuc, khong phan bo
		Scanner scan = new Scanner(System.in);
		for (TruongPhong tp : this.dsTruongPhong) {
			boolean flag = true;
			while (flag) {
				System.out.println("Day la thong tin truong phong");
				tp.xuatTenvaMa();
				inLuaChon();
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					System.out.println("Day la danh sach phong ban");
					xuatPB();
					System.out.print("Vui long nhap phong ban cho truong phong: ");
					String maPhong = scan.nextLine();
					PhongBan pb = layPhongBan(maPhong);
					if (pb != null) {
						// them ma phong ban cho nha vien
						tp.setMaPB(maPhong);
						// them nhan vien vao phong ban
						pb.setTruongPhong(tp);
					}
					flag = false;
					break;
				case 2:
					flag = false;
					break;
				default:
					System.out.println("Chỉ được nhập 1 hoặc 2");
				}
			}
		}
	}

	private void layDSTruongPhong() {
		for (NhanSu ns : this.objDSNhanSu.getDsNhanSu()) {
			if (ns instanceof TruongPhong) {
				this.dsTruongPhong.add((TruongPhong) (ns));
			}
		}
	}

	public void phanBoTask(Scanner scan) {
		// 1. Duyet danh sach Task
		// 2. Cho phep nguoi dung nhap vao 1 ma nhan dang phan bo, nhap den khi nao duoc
		// 1 nhan vien
		// 3. Phan task hoac chon lai hoac huy bo khong phan task
		for (Task task : this.objDSTask.getDsTask()) {
			System.out.println("Task dang phan bo");
			task.xuat();
			NhanSu ns = timNhanSuTheoMa(scan);
			boolean flag = true;
			while (flag) {
				inChucNang();
				int chon = Integer.parseInt(scan.nextLine());
				switch (chon) {
				case 1:
					task.setMaNV(ns.getMaNV());
					ns.getObjDsTask().getDsTask().add(task);
					System.out.println("Phan task thanh cong");
					flag = false;
					break;
				case 2:
					ns = timNhanSuTheoMa(scan);
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.println("Vui long nhap (1 - 3): ");
				}
			}
		}
	}

	public NhanSu timNhanSuTheoMa(Scanner scan) {
		NhanSu ns = null;
		while (ns == null) {
			System.out.print("Nhap ma nhan vien muon phan task: ");
			String maNS = scan.nextLine();
			for (NhanSu nSu : this.objDSNhanSu.getDsNhanSu()) {
				if (nSu.getMaNV().equalsIgnoreCase(maNS)) {
					ns = nSu;
					System.out.println("Day la nhan su duoc chon");
					ns.xuatTenvaMa();
					break;
				}
			}
		}
		return ns;
	}

	public void inChucNang() {
		System.out.println("1. Phan Task cho nhan vien");
		System.out.println("2. Lua chon lai nhan vien");
		System.out.println("3. Bo qua Task");

	}
	
	public ArrayList<NhanSu> listNVThucHienNhieuTaskNhat() {
		NhanSu nsMax = this.objDSNhanSu.getDsNhanSu().get(0);
		for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
			if(ns.getObjDsTask().getDsTask().size() > nsMax.getObjDsTask().getDsTask().size()) {
				nsMax = ns;
			}
		}
		
		ArrayList<NhanSu> nvThucHienNhieuTaskNhat = new ArrayList<NhanSu>();
		for(NhanSu nSu: this.objDSNhanSu.getDsNhanSu()) {
			if(nSu.getObjDsTask().getDsTask().size() == nsMax.getObjDsTask().getDsTask().size()) {
				nvThucHienNhieuTaskNhat.add(nSu);
			}
		}
		return nvThucHienNhieuTaskNhat;
	}
	
	public void timNVLamNhieuTaskNhat() {
		ArrayList<NhanSu> listNVLamNhieuTask = listNVThucHienNhieuTaskNhat();
		System.out.println("Cac NV thuc hien nhieu task nhat la:");
		for(NhanSu ns: listNVLamNhieuTask) {
			ns.xuatTenvaMa();
		}
	}

	public void timNVLamNhieuTaskNhatandTreNhat() {
		ArrayList<NhanSu> listNVLamNhieuTask = listNVThucHienNhieuTaskNhat();
		NhanSu nSuMinAge = listNVLamNhieuTask.get(0);
		for(NhanSu ns: listNVLamNhieuTask) {
			if(Integer.parseInt(ns.getNamSinh()) > Integer.parseInt(nSuMinAge.getNamSinh())) {
				nSuMinAge = ns;
			}
		}
		System.out.println("Nhan Vien tre nhat thuc hien nhieu task nhat la");
		nSuMinAge.xuatTenvaMa();
		nSuMinAge.getObjDsTask().xuat();
	}
	
	public void timPhongBanCoNVTreNhat() {
		//tim tuoi tre nhat
		NhanSu nsAgeMin = this.objDSNhanSu.getDsNhanSu().get(0);
		for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
			if (Integer.parseInt(ns.getNamSinh()) > Integer.parseInt(nsAgeMin.getNamSinh())) {
				nsAgeMin = ns;
			}
		}
		
		
		//lap danh sach cac phong chua nhan vien tre nhat
		ArrayList<String> maPhongMin = new ArrayList<String>();
		
		//tim ma phong chua nhan vien tre nhat
		for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
			if (ns.getNamSinh().equalsIgnoreCase(nsAgeMin.getNamSinh())) {
				String maPhong = ns.getMaPB();
				maPhongMin.add(maPhong);
			}
		}
		
//		in ra phong ban chua nhan vien tre nhat
		System.out.println("Cac phong ban chua nhan vien tre nhat la: ");
		for(PhongBan pb: this.objDSPhongBan.getDsPhongBan()) {
			for(String maPhongmin: maPhongMin) {
				if (pb.getMaPhongBan().equalsIgnoreCase(maPhongmin)) {
					pb.xuat();
				}
			}
		}
	}
	
	//Xóa 1 nhân sự
	//Xét là Nhân Viên Thường -> Xóa liên kết task (reset các mã nhân viên của task đang quản lý bởi NS này là -1)
	//Xét là Trưởng phòng : Xóa trường phòng quản lý trong Phòng ban, reset null 
	
	public void xoaNhanVien(Scanner scan) {
		NhanSu nsDel = timNhanVienMuonDel(scan);
		for(Task task: nsDel.getObjDsTask().getDsTask()) {
			task.setMaNV("-1");
			nsDel.setObjDsTask(null);
		}
		String maPhDel = nsDel.getMaPB();
		PhongBan pbanDel = layPhongBan(maPhDel);
		pbanDel.getDsNV().remove(nsDel);
		if (nsDel instanceof NhanVienThuong) {
			nsDel.setMaPB("-1");
		}
		else if(nsDel instanceof TruongPhong) {
			String maPhongDel = nsDel.getMaPB();
			PhongBan pbDel = layPhongBan(maPhongDel);
			pbDel.setTruongPhong(null);
			nsDel.setMaPB("-1");
		}
		this.objDSNhanSu.getDsNhanSu().remove(nsDel);
		System.out.println("Da xoa thanh con nhan vien: ");
		nsDel.xuatTenvaMa();
	}
	
	public NhanSu timNhanVienMuonDel(Scanner scan) {
		NhanSu nSu = null;
		while(nSu == null) {
			System.out.print("Nhap ma NV muon xoa: ");
			String maDel = scan.nextLine();
			for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
				if(ns.getMaNV().equalsIgnoreCase(maDel)) {
					nSu = ns;
					System.out.println("Day la nhan vien ban muon xoa: ");
					nSu.xuatTenvaMa();
				}
			}
		}
		return nSu;
	}
	
	public void quickSort(NhanSu a[], int left, int right) {
		if (left < right) {
			int pivot = getSizeOfTaskOfNS(a[(left + right)/2]);
			int i = left;
			int j = right;
			while (i < j) {
				while(getSizeOfTaskOfNS(a[i]) < pivot)
					i++;
				while (getSizeOfTaskOfNS(a[j]) > pivot)
					j--;
				if (i <= j) {
					NhanSu nSuTemp = a[i];
					a[i] = a[j];
					a[j] = nSuTemp;
					i++;
					j--;
				}
			}
			quickSort(a, i, right);
			quickSort(a, left, j);
		}
	}
	
	public int getSizeOfTaskOfNS(NhanSu ns) {
		return ns.getObjDsTask().getDsTask().size();
	}
	
//	public void xsSLTaskNVLamQuickSort() {
//		NhanSu[] arrayNS = new NhanSu[this.objDSNhanSu.getDsNhanSu().size()];
//		int i = 0;
//		for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
//			arrayNS[i] = ns;
//			i++;
//		}
//		quickSort(arrayNS, 0, arrayNS.length - 1);
//		for(NhanSu ns: arrayNS) {
//			ns.xuat();
//		}
//	}
	
	public void sxSLTaskNVLamQuickSort() {
		NhanSu[] arrayNS = new NhanSu[this.objDSNhanSu.getDsNhanSu().size()];
		int i = 0;
		for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
			arrayNS[i] = ns;
			i++;
		}
		quickSort(arrayNS, 0, arrayNS.length - 1);

		ArrayList<NhanSu> listTemp = new ArrayList<NhanSu>();
		for(int j = 0; j < arrayNS.length; j++) {
			listTemp.add(arrayNS[j]);
		}
		this.objDSNhanSu.setDsNhanSu(listTemp);
	}
	
	public String layTenNV(int n) {
		return this.objDSNhanSu.getDsNhanSu().get(n).getTenNV();
	}
	
//	public ArrayList<NhanSu> layDSNhanSu(int m) {
//		return this.objDSNhanSu.getDsNhanSu();
//	}
	
	public void sapXepTheoTenNV() {
		int size = this.objDSNhanSu.getDsNhanSu().size();
		for(int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if(layTenNV(i).compareTo(layTenNV(j)) > 0) {
					NhanSu nSuTemp = this.objDSNhanSu.getDsNhanSu().get(i);
					this.objDSNhanSu.getDsNhanSu().set(i, this.objDSNhanSu.getDsNhanSu().get(j));
					this.objDSNhanSu.getDsNhanSu().set(j, nSuTemp);
				}
			}
		}

	}
	
	public void tinhLuongNhanVien() {
		for(NhanSu ns: this.objDSNhanSu.getDsNhanSu()) {
			if(ns instanceof NhanVienThuong) {
				ns.tinhLuong();
			}
			else {
				int soNSOfPB = 0;
				if(ns.getMaPB() != null) {
					for(PhongBan pb: this.objDSPhongBan.getDsPhongBan()) {
						if (pb.getTenPhongBan().equalsIgnoreCase(ns.getMaPB())) {
							soNSOfPB = pb.getDsNV().size();
						}
					}
				}
			}
		}
	}
	
}
