package basic1.baseballGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class model {
    //배열 4개를 해야하나
    // 넘버를 생성하면 랜덤이 4개를 만드는거지
    private int []arr = new int[4];

    public model() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < 4; i++) {
            arr[i] = numbers.get(i);
        }
    }

    public int[] getArr() {
        return arr;
    }
    /**
     * 포인트 설명
     *
     * int arr[4] → 자바에서는 int[] arr = new int[4]; 이렇게 써야 해요.
     *
     * new ArrayList()는 배열이 아니라 리스트 타입이에요.
     *
     * Collections.shuffle()을 쓰면 중복 없이 랜덤 섞기가 가능합니다.
     *
     * 생성자에서 바로 랜덤 생성이 이루어지도록 했어요.
     */
}
