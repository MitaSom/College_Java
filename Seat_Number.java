import java.util.Scanner;

public class Seat_Number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int M  = scn.nextInt();

        int[][] SeatTable = new int[M][N];
        int x = 0;
        int y = 0;
        int MinX = 0;
        int MinY = 0;
        int MaxX = N - 1;
        int MaxY = M - 1;
        for (int i = 1; i <= N * M; i++){
            SeatTable[y][x] = i;

            if (x == MinX && y != MaxY){
                y++;
                if (y == MaxY)
                    MinX ++;
            }
            else if (y == MaxY && x != MaxX){
                x++;
                if ( x == MaxX)
                    MaxY--;
            }
            else if (x == MaxX && y != MinY){
                y--;
                if (y == MinY)
                    MaxX--;
            }
            else if (y == MinY && x != MinX){
                x--;
                if (x == MinX)
                    MinY++;
            }
            else {break;}
        }

        for (int i = 0; i < 3; i++){
            int SearchNum = scn.nextInt();
            if (SearchNum > N * M) {
                System.out.println(0 + " " + 0);
                continue;
            }
            for (int a = 0; a < M; a++){
                for (int b = 0; b < N; b++){
                    if (SeatTable[a][b] == SearchNum)
                        System.out.println((b+1) + " " + (a+1));
                }
            }
        }
    }
}