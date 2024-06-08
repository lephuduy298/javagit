print("====== Đây là phần mềm tính điểm trung bình 3 môn Toán, Văn, Anh ========")
hoten = input("\n\t\tNhập họ tên: ")
diemtoan = float(input("\n\t\tNhập điểm toán: "))

#Giải thích cách dùng hàm type()
# diemtoan = input("\n\t\tNhập điểm toán: ")                                        
# print("Kiểu dữ liệu của điểm toán trước khi ép kiểu là: ", type(diemtoan))
# diemtoan = float(diemtoan)                                                      //ép kiểu float cho biến diemtoan
# print("Kiểu dữ liệu của điểm toán sau khi ép kiểu là: ", type(diemtoan))

diemly = float(input("\n\t\tNhập điểm toán: "))
diemhoa = float(input("\n\t\tNhập điểm toán: "))



diemtb = (diemtoan + diemly + diemhoa)/3 
diemtb = round(diemtb, 1)                       #hàm round dùng để rút gọn số phức

print("\nHọc sinh: ", hoten, " đạt điểm trung bình 3 môn là: ", diemtb)


