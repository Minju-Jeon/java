package codingTest;

import java.util.InputMismatchException;
import java.util.Scanner;

/*********************************
 순차합을 생성하는 클래스를 작성
 input > a / b
 a로 시작하여 오름차순 b개의 숫자를 합산하여 출력
 ex) 2 & 5 > 2 + 3 + 4 + 5 + 6
 >> 20
 *********************************/

public class zin02_linearSum {
    public static void linearSum(Scanner sc) {
        int a;
        int b;
        System.out.printf("*************************%n순차합 생성기%n*************************%n");
        while (true) {
            System.out.println(">시작 숫자 입력: ");
            try {
                a = sc.nextInt();
            } catch (InputMismatchException ime) {
                sc = new Scanner(System.in);
                System.out.println("정수를 입력해주세요");
                continue;
            }//try~catch
            break;
        }//while
        while (true) {
            System.out.println(">합산 횟수 입력: ");
            try {
                b = sc.nextInt();
            } catch (InputMismatchException ime) {
                sc = new Scanner(System.in);
                System.out.println("양의 정수를 입력해주세요");
                continue;
            }//try~catch
            if (b < 1) {
                System.out.println("양의 정수를 입력해주세요");
                continue;
            }
            break;
        }//while
        int sum = 0;

        System.out.printf("%d부터 %d개의 숫자 합산 :%n", a, b);
        for (int i = 0; i < b; i++) {
            sum += a + i;
            System.out.printf(i > 0 ? " + %d" : "%d", a + i);
        }//for
        System.out.printf("%n= %d%n", sum);
    }//linearSum

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        linear: while (true) {
            linearSum(sc);
            menu: while (true) {
                System.out.println("*************************");
                System.out.println("1. 재실행 / 2. 종료");
                try {
                    int q = sc.nextInt();
                    switch (q){
                        case 1:
                            break menu;
                        case 2:
                            System.out.println("********** 종료 ***********");
                            sc.close();
                            break linear;
                        default:
                            System.out.println("1과 2 중에서 입력해주세요");
                            continue;
                    }//switch
                } catch (InputMismatchException ime) {
                    sc = new Scanner(System.in);
                    System.out.println("1과 2 중에서 입력해주세요");
                    continue;
                }//try~catch
            }//while
        }//while
    }//main
}//class

