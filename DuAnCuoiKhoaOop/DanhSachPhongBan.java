package DuAnCuoiKhoaOop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachPhongBan implements NhapXuat {
//	1. Attributes
	ArrayList<PhongBan> dsPhongBan;

//	2. Get, set methods

	public ArrayList<PhongBan> getDsPhongBan() {
		return dsPhongBan;
	}

	public void setDsPhongBan(ArrayList<PhongBan> dsPhongBan) {
		this.dsPhongBan = dsPhongBan;
	}

	// 3. Constructors
	public DanhSachPhongBan() {
		this.dsPhongBan = new ArrayList<PhongBan>();
	}
//	4. Input, output methods
//	5. Business methods
	@Override
	public void xuat() {
		for(PhongBan pb: this.dsPhongBan) {
			pb.xuat();
		}

	}
	
	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSPhongBan.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				PhongBan pb;
				
				pb = new PhongBan(listInfo[0], listInfo[1]);
				this.dsPhongBan.add(pb);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
