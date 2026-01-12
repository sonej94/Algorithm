import java.util.*;

class Solution {
    
    static class Song {
        int idx;
        int play;

        Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
            
        }
        
        List<Map.Entry<String, Integer>> genreOrder = new ArrayList<>(genreTotal.entrySet());
        genreOrder.sort((a, b) -> b.getValue() - a.getValue());
        
        List<Integer> result = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : genreOrder) {
            String g = entry.getKey();
            List<Song> songs = genreSongs.get(g);
            
            songs.sort((s1, s2) -> {
                if (s1.play != s2.play) return s2.play - s1.play;
                return s1.idx - s2.idx;
            });
            
            result.add(songs.get(0).idx);
            if (songs.size() >= 2) {
                result.add(songs.get(1).idx);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}