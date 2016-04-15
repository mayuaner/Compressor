with open('states.txt') as f:
    lines = f.readlines()
f = open('out2.txt','w')
for line in lines:
	arr = line.split("\t")
	subarr = arr[1].split('-')
	temp = "else if (zip >= " + subarr[0] + " && zip <= " + subarr[1] + ") return \"" + arr[0] + "\";\n"
	f.write(temp)
f.close()



