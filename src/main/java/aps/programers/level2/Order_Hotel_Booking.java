package aps.programers.level2;

import java.util.*;

public class Order_Hotel_Booking {
    public int solution(String[][] book_time) {
        int answer = 0;

        List<List<Integer>> time = new ArrayList<>();

        for(int i = 0; i < book_time.length; i++){
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");

            time.add(new ArrayList<>());
            time.get(i).add(Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
            time.get(i).add(Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]));
        }

        List<List<Integer>> sortedTime = time.stream()
            .sorted((o1, o2) -> o1.get(0) - o2.get(0))
            .toList();

        // for(int i = 0; i < book_time.length; i++){
        //     System.out.println(sortedTime.get(i).get(0) + "," + sortedTime.get(i).get(1));
        // }

        List<List<Integer>> bookList = new ArrayList<>();

        for (List<Integer> eachTime : sortedTime) {
            boolean isBooked = false;

            for (List<Integer> book : bookList) {
                if(eachTime.get(0) >= book.get(book.size() - 1) + 10) {
                    book.add(eachTime.get(0));
                    book.add(eachTime.get(1));
                    isBooked = true;
                    break; // 이 객실에 예약됐으므로, 다음 예약으로 넘어간다.
                }
            }

            if(!isBooked) {
                List<Integer> newBook = new ArrayList<>();
                newBook.add(eachTime.get(0));
                newBook.add(eachTime.get(1));
                bookList.add(newBook);
            }
        }

        // for(int i = 0; i < bookList.size(); i++){
        //     for(int j = 0; j < bookList.get(i).size(); j++){
        //         System.out.print(bookList.get(i).get(j)/60 + ",");
        //     }
        //     System.out.println("");
        // }

        return bookList.size();
    }
}
