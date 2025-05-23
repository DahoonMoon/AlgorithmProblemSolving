package aps.programers.level2;
import java.util.*;

public class Stack_Back_Big_Number {
    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numbers.length; i++){
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
