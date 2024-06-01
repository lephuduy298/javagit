package DuAnCuoiKhoaOop;

import java.util.Scanner;

public class XuLy {

	public static void main(String[] args) {
		CongTy cty = new CongTy();
		Scanner scan = new Scanner(System.in);
		cty.taoDuLieu();
		cty.xuatNS();
//		cty.xuatPB();
//		cty.phanBoNhanVien();
//		cty.phanBoTruongPhong();
//		cty.xuatNS();
//		cty.xuatPB();
//		cty.phanBoTask(scan);
//		cty.xuatNS();
//		cty.xuatTask();
//		cty.timNVLamNhieuTaskNhat();
//		cty.timNVLamNhieuTaskNhatandTreNhat();
//		cty.timPhongBanCoNVTreNhat();
//		cty.xoaNhanVien(scan);
//		cty.xuatNS();
//		System.out.println("Danh Sach Task: ");
//		cty.xuatTask();
//		cty.xuatPB();
//		System.out.println("================");
//		System.out.println("Danh sach nhan vien sau khi sap xep theo so luong task: ");
//		cty.sxSLTaskNVLamQuickSort();
//		cty.xuatNS();
		cty.sapXepTheoTenNV();
		System.out.println("Nhan vien sau khi sap xep theo ten la: ");
		cty.xuatNS();
	}

}
