package DuAnCuoiKhoaOop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachNhanSu implements NhapXuat {

//	1. Attributes
	ArrayList<NhanSu> dsNhanSu;

//	2. Get, set methods
	public ArrayList<NhanSu> getDsNhanSu() {
		return dsNhanSu;
	}

	public void setDsNhanSu(ArrayList<NhanSu> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}

//	3. Constructorsư
	public DanhSachNhanSu() {
		this.dsNhanSu = new ArrayList<NhanSu>();
	}

//	4. Input, output methods
//	5. Business methods
	@Override
	public void xuat() {
		for (NhanSu ns : this.dsNhanSu) {
			ns.xuat();
		}

	}

	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSNhanSu.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
				String[] listInfo = line.split(" # ");
				NhanSu ns;
//					System.out.println(info);
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true"))
					ns = new TruongPhong();
				else
					ns = new NhanVienThuong();

				ns.setMaNV(listInfo[0]);
				ns.setTenNV(listInfo[1]);
				ns.setNamSinh(listInfo[2]);
				ns.setEmail(listInfo[3]);
				ns.setSoDT(listInfo[4]);
				this.dsNhanSu.add(ns);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
