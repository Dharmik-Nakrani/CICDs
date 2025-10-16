import re

def read_file(filename):
    with open(filename, 'r') as f:
        return f.read()
        
        
file1 = read_file("./old.txt")
file2 = read_file("./new.txt")

file_1_array = file1.split()
file_2_array = file2.split()

for val in file_1_array:
	tmp = val.split("@")
	for val2 in file_2_array:
		if re.search(tmp[0], val2):
			match = True
			if not val==val2:
				print("<tr><td>"+val+"</td><td>"+val2+"</td></tr>")
			break
		else:
			match = False
	if not match:
		print("<tr><td>"+val+"</td><td> - </td></tr>")

for val in file_2_array:
	tmp = val.split("@")
	for val2 in file_1_array:
		if re.search(tmp[0], val2):
			match = True
			break
		else:
			match = False
	if not match:
		print("<tr><td> - </td><td>"+val+"</td></tr>")	
	
