# For the given length n, find all n-length Strobogrammatic numbers.

# Strobogrammatic Number is a number whose numeral is rotationally symmetric so that it appears the same when rotated 180 degrees. In other words, Strobogrammatic Number appears the same right-side up and upside down.
# 0 after 180° rotation : (0 → 0)
# 1 after 180° rotation : (1 → 1)
# 8 after 180° rotation : (8 → 8)
# 6 after 180° rotation : (6 → 9)
# 9 after 180° rotation : (9 → 6)

# Examples :
# Input : n = 2
# Output : 88  11  96  69

# Input : n = 4
# Output : 8008 1001 9006 6009 8888 1881 9886 6889 8118 1111
#          9116 6119 8968 1961 9966 6969 8698 1691 9696 6699

def strobogrammatic_num(n): 
      
    result = numdef(n, n) 
    return result 
      
# definition function 
def numdef(n, length): 
      
    if n == 0: return [""] 
    if n == 1: return ["1", "0", "8"] 
      
    middles = numdef(n - 2, length) 
    result = [] 
      
    for middle in middles: 
        if n != length:             
            result.append("0" + middle + "0") 
  
        result.append("8" + middle + "8") 
        result.append("1" + middle + "1") 
        result.append("9" + middle + "6") 
        result.append("6" + middle + "9") 
    return result 
  
# Driver Code 
if __name__ == '__main__': 
      
    # Print all Strobogrammatic  
    # number for n = 3 
    print(strobogrammatic_num(3)) 