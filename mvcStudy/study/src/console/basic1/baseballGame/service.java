package basic1.baseballGame;

public class service {
    // 여기는 핵심 로직
    private int cnt;
    private int strike;
    private int ball;

    // 어떤 입력값을 받을건데 문자열로 받는건가?
    void check(int input){
        int a,b,c,d;
        a= input/1000;
        System.out.println("a = " + a);
        input%=1000;
        b= input/100;
        System.out.println("b = " + b);
        input%=100;
        c= input/10;
        System.out.println("c = " + c);
        input%=10;
        d= input/1;
        System.out.println("d = " + d);


    }
}
