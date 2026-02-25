import sys
sys.setrecursionlimit(10000)

N = int(input())                  #큰 종이 한 변의 길이
square = []                       #전체 배열
white=0
blue = 0                    #정답 출력용 
for _ in range(N):                #입력받기
    square.append(list(map(int,input().split())))

def division(x, y,n):               
    global blue,white
    for i in range(x,x+n):
        for j in range(y,y+n):
            if square[i][j] != square[x][y]:
                n //=2
                division(x,y,n)         #1사분면
                division(x,y+n,n)       #2사분면
                division(x+n,y,n)       #4사분면
                division(x+n,y+n,n)     #3사분면
                return
    if square[x][y] ==1:
            blue +=1
    else:
            white +=1
        
division(0,0,N)
print(white)
print(blue)