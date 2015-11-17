import os
print(os.getcwd())#os is a module that is similar to linux command
#os.getcwd == pwd
print('please key in the directory that contains the file you want to read')
path=input()
boolean=isinstance(path,str)
print('is the type of boolean str ? :'+str(boolean))
try:
    os.chdir(path)
    #means cd path
except:
    print('path error')
a=[]
try:
    data=open('mongDocument')
    #mongodocument is a kind of json
    for i in data:
        try:
            a=i.split(':')
            print(a[0]+':'+a[1])
        except IndexError:
            print(i)
except IOError:
    print('there is no fucking file')
