package DuAnCuoiKhoaOop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DanhSachTask implements NhapXuat {
//	1. Attributes
	ArrayList<Task> dsTask;

//	2. Get, set methods

	public ArrayList<Task> getDsTask() {
		return dsTask;
	}

	public void setDsTask(ArrayList<Task> dsTask) {
		this.dsTask = dsTask;
	}

	// 3. Constructors
	public DanhSachTask() {
		this.dsTask = new ArrayList<Task>();
	}
//	4. Input, output methods
//	5. Business methods
	@Override
	public void xuat() {
		for(Task task: this.dsTask) {
			task.xuat();
		}

	}
	
	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSTask.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				Task task;
				task = new Task(listInfo[0], listInfo[1], Float.parseFloat(listInfo[2]));
				dsTask.add(task);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
