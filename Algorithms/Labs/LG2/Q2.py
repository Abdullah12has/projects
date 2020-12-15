def listCourse(year,courses):
    courseYear=[]
    for i in courses:
        if i[0][-3]=="1":
            courseYear.append(i)
    return courseYear

courses=[
    ("CS 125",3),
    ("HIST 200",4),
    ("PHIL 243",6),
    ("POLS 304",3),
    ("ENG 101",3)
    ]
yearOneCourses=listCourse(1,courses)
cred=0
print("First year courses:")
for i in yearOneCourses:
    print(i[0])
    cred+=i[1]
print()
print("Total credits for first year courses:",cred)

