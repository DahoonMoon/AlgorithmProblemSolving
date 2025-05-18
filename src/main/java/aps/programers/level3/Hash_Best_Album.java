package aps.programers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Hash_Best_Album {

	public static int[] solution(String[] genres, int[] plays) {
//		int[] answer = {};

		List<Integer> answerList = new ArrayList<>();


		Map<String, Integer> genreMap = new HashMap<>();
		Map<String, HashMap<Integer, Integer>> genreSongMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			if (genreMap.containsKey(genres[i])) {
				genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
				genreSongMap.get(genres[i]).put(i, plays[i]);
			} else {
				genreMap.put(genres[i], plays[i]);
				HashMap<Integer, Integer> map = new HashMap<>();
				map.put(i, plays[i]);
				genreSongMap.put(genres[i], map);
			}
		}


		Comparator<Entry<String, Integer>> comparator = (o1, o2) -> o2.getValue().compareTo(o1.getValue());
		List<Entry<String, Integer>> list = new LinkedList<>(genreMap.entrySet());
		Collections.sort(list, comparator);

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey());

			HashMap<Integer, Integer> songs = genreSongMap.get(entry.getKey());

			List<Entry<Integer, Integer>> songList = new LinkedList<>(songs.entrySet());
			Collections.sort(songList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

			answerList.add(songList.get(0).getKey());

			if (songList.size() > 1) {
				answerList.add(songList.get(1).getKey());
			}
		}

		System.out.println(answerList);

		int[] answer = new int[answerList.size()];

		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}


	public static void main(String[] args) {

		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
//[4, 1, 3, 0]
		int[] answer = solution(genres, plays);
		System.out.println(answer);

	}

}
