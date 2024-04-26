import java.util.Scanner;

public class Repeat {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String DNA = scn.next();
        DNA += "N";//Null. outofbound방지

        int Repeat = 0;
        for (int i = 1; i < DNA.length(); i++){//몇 글자씩 자를 지
            for (int n = 0; n + i + i < DNA.length(); n++){//어디서 시작할지
                if (DNA.substring(n, n + i).equals(DNA.substring(n + i, n + i + i))){//n부터 i만큼, n+i부터 i만큼 붙어있게 자르기
                    Repeat = i;
                }
            }
        }
        System.out.println(Repeat);
    }
}