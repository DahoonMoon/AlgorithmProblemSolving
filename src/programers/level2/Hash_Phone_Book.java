package programers.level2;
import java.util.*;

public class Hash_Phone_Book {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], true);
        }

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(map.get(phone_book[i].substring(0, j)) != null){
                    return false;
                }
            }
        }

        return answer;
    }
}
