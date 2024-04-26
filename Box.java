import java.util.Scanner;

public class Box {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] Squares = new int[8];
        for (int i = 0; i < 8; i++)
            Squares[i] = scn.nextInt();
        scn.close();

        Sortxy(0, 2, Squares);
        Sortxy(1, 3, Squares);
        Sortxy(4, 6, Squares);
        Sortxy(5, 7, Squares);//입력받은 좌표들을 각각 왼쪽,아래-오른쪽,위 (x,y)-(x,y) 좌표로 정렬

        int[] Square1X = MakeLine(Squares[0], Squares[2]);
        int[] Square1Y = MakeLine(Squares[1], Squares[3]);
        int[] Square2X = MakeLine(Squares[4], Squares[6]);
        int[] Square2Y = MakeLine(Squares[5], Squares[7]);//각 사각형이 차지하고 있는 모든 x, y 좌표들을 배열에 저장

        //이제 두 사각형의 x, y 좌표들이 각각 얼마나 겹치는지 확인
        if (Overlap(Square1X, Square2X) == 0 || Overlap(Square1Y, Square2Y) == 0){
            System.out.println("NULL");//x, y중 한쪽이라도 겹치지 않았다면 NULL
        }
        else if (Overlap(Square1X, Square2X) > 1 && Overlap(Square1Y, Square2Y) > 1){
            System.out.println("FACE");//x, y가 모두 두 칸 이상씩 겹쳤다면 FACE
        }
        else if (Overlap(Square1X, Square2X) == 1 && Overlap(Square1Y, Square2Y) == 1){
            System.out.println("POINT");//x, y가 모두 한 점씩 만났다면 POINT
        }
        else {System.out.println("LINE");}//전부 아니면 LINE

    }

    static void Sortxy(int z1, int z2, int[] Squaes){//앞쪽 x, y 좌표가 뒤의 x, y 좌표보다 더 작게 정렬
        int temp;
        if (Squaes[z1] > Squaes[z2]){
            temp = Squaes[z1];
            Squaes[z1] = Squaes[z2];
            Squaes[z2] = temp;
        }
    }

    static int[] MakeLine(int z1, int z2){//x1부터 x2까지의 모든 좌표들을 배열로 생성. y도 마찬가지
        int[] Square = new int[z2-z1+1];
        for (int i = 0; i < z2-z1+1; i++)
            Square[i] = z1+i;
        return Square;
    }

    static int Overlap(int[] Z1, int[] Z2){//두 사각형의 x 좌표가 얼마나 겹치는지 카운트. y도 마찬가지
        int OverlapCount = 0;
        for (int i = 0; i < Z1.length; i++){
            for (int j = 0; j < Z2.length; j++){
                if (Z1[i] == Z2[j]){
                    OverlapCount++;
                }
            }
        }
        return OverlapCount;
    }
}