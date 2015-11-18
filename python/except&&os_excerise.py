import os,pickle
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
out=[]
data=[]
try:
    datas=open('mongDocument')
    #mongodocument is a kind of json
    for i in datas:
        try:            
            data.append(str(i))
        except IOError as ex:
            pass           
    datas.close()#please remember to close file
except IOError:
    print('there is no fucking file')

print(str(data))
try:
    with open('mongowrite.json','wb') as moinput:
    #with will automatically close the file, dont worry
    #open type: 'wb' 是pickle規定的
        pickle.dump(data,moinput)
except:
    pass
try:
    with open('mongowrite.json','rb') as moinput:
        inp=pickle.load(moinput)
        #這樣可以把pickle過的的檔案讀取出來,已經是二進制，所以也要用二進制去讀取
    print('===============================================')
    print(inp)
except:
    print("err")
