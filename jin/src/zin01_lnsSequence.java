package codingTest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class zin01_lnsSequence {
    public static void lnsSequence(Scanner sc) {
        int a;
        int b;
        System.out.printf("*************************%n개미수열 생성기%n*************************%n");
        while (true) {
            System.out.println(">첫 숫자 입력: ");
            try {
                a = sc.nextInt();
            } catch (InputMismatchException ime) {
                sc = new Scanner(System.in);
                System.out.println("0 이상의 정수를 입력해주세요");
                continue;
            }//try~catch
            if (a < 0) {
                System.out.println("0 이상의 정수를 입력해주세요");
                continue;
            }
            break;
        }//while
        while (true) {
            System.out.println(">구하는 열의 갯수 입력: ");
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
        System.out.printf("%d부터 시작하여 %d열 까지 출력%n", a, b);
        System.out.println("*************************");

        String preSequence = Integer.toString(a);               //직전 첫항을 문자형 변환
        System.out.printf("1: %s%n", preSequence);              //첫줄 출력

        for (int i = 2; i <= b; i++) {                          //2~b번째 줄까지 반복
            String[] sequence = preSequence.split("");
            preSequence = "";

            List<String> nextSequence = new ArrayList();
            nextSequence.add(sequence[0]);                      //sequence의 첫번째를 다음 항에 추가
            int times = 1;

            for (int j = 1; j <= sequence.length; j++) {        //sequence의 첫번째~마지막 요소까지 반복
                if (j == sequence.length) {                     //sequence의 길이가 j와 같을 경우
                    nextSequence.add(Integer.toString(times));  //nextSequence에 times의 값 추가후 반복 종료
                    break;
                }//if
                if (nextSequence.get(nextSequence.size() - 1).equals(sequence[j])) {
                    //
                    times++;
                } else {//같지않을 경우
                    nextSequence.add(Integer.toString(times));  //nextSequence에 times의 값 추가
                    times = 1;
                    nextSequence.add(sequence[j]);
                }//if
            }//for j
            for (String s : nextSequence) {
                preSequence += s;
            }//for s
            System.out.printf("%d: %s%n", i, preSequence);
        }//for i
    }//lnsSequence

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lns: while (true) {
            lnsSequence(sc);
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
                            break lns;
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


/***************************************************
 * ----- i++ ----- 줄
 * 1. 문자열 preSequence를 글자별로 분해
 *    > 배열 sequence에 담음
 * 2. preSequence 공백으로 초기화
 * 3. 리스트 nextSequence 선언 & sequence[0] 추가
 * 4. 정수형 times 선언 & 1로 초기화
 *
 * ----- j++ ----- 읽기
 * 5-1. 배열이 끝났을 경우
 *      nextSequence에 times 추가
 *      6번으로
 *
 * 5-2. nextSequence의 마지막 요소 & sequence[j] 비교
 *      >같을 경우
 *          time++
 *          5번으로 돌아감
 *
 *      >같지않을 경우
 *          nextSequence에 times 추가
 *          times 1로 초기화
 *          nextSequence에 sequence[j] 추가
 *          5번으로 돌아감
 *
 *
 * 6. nextSequence를 String 변환
 *    > preSequence에 담음
 * 7. 문자열 preSequence를 출력
 *    1번으로 돌아감
 ****************************************************/