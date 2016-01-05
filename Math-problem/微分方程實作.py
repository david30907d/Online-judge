def d(f) :
    print(f)
    def calc(x) :
        print('x:'+str(x))
        dx = 0.000001  # 表示无穷小的Δx        
        return (f(x+dx) - f(x)) / dx  # 计算斜率。注意，此处引用了外层作用域的变量 f
    return calc  # 此处用函数作为返回值（也就是函数 f 的导数）
f = lambda y : y**2 + y + 1  # 先把二次函数用代码表达出来
f1 = d(f)  # 这个f1 就是 f 的一阶导数啦。注意，导数依然是个函数
print(f1(3))
print('f():'+str(f(5)))
#如果要想得到二阶导数（导数的导数），只需依样画葫芦（瞧这代码写得多优雅）
#f2 = d(f1)