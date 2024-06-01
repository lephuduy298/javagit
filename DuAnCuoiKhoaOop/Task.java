/*
 * 	Quản lý cac nghiep vụ liên quan đến Task cho Nhân Viên
 * */

package DuAnCuoiKhoaOop;

public class Task implements NhapXuat{
//	1.	Attributes
	private String maTask;
	private String tenTask;
	private float soNgayLamViec;
	private String maNV; 
//	2. Get, set methods
	public String getMaTask() {
		return maTask;
	}
	public void setMaTask(String maTask) {
		this.maTask = maTask;
	}
	public String getTenTask() {
		return tenTask;
	}
	public void setTenTask(String tenTask) {
		this.tenTask = tenTask;
	}
	public float getGioLam() {
		return soNgayLamViec;
	}
	public void setGioLam(float gioLam) {
		this.soNgayLamViec = gioLam;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
//	3. Constructors
	public Task() {
		this.maNV = "-1";
	}
	public Task(String maTask, String tenTask, float gioLam, String maNV) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.soNgayLamViec = gioLam;
		this.maNV = maNV;
	}
	
	public Task(String maTask, String tenTask, float gioLam) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.soNgayLamViec = gioLam;
	}
	
//	4. Input, output methods
	public void xuat() {
		System.out.println("Ma Task: " + this.maTask + "\tTen Task: " + this.tenTask + "\tGio Lam: " + this.soNgayLamViec + "\tMa NV: " + this.maNV);
	}
//	5. Business methods
}
