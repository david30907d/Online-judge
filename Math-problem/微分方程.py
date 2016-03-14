def differentiate(e) :
    def calc(x) :
        dx = 0.000001    
        return (e(x+dx) - e(x)) / dx  
    return calc  
equation = lambda x : x**3 + x + 1 #please input the equation you want to differatiate.
calc = differentiate(equation)  
print(calc(3))
print(calc(5))	