import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, List<Song>> songMap = new HashMap<>();
        Map<String, Integer> songCntMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<genres.length; i++) {
            songCntMap.put(genres[i], songCntMap.getOrDefault(genres[i], 0) + plays[i]);

            if (!songMap.containsKey(genres[i])) {
                List<Song> songList = new ArrayList<>();
                songList.add(new Song(i, plays[i]));
                songMap.put(genres[i], songList);
            } else {
                System.out.println("songMap = " + songMap);
                songMap.get(genres[i]).add(new Song(i, plays[i]));
            }
        }

        System.out.println("songMap = " + songMap);
        System.out.println("songCntMap = " + songCntMap);

        List<String> songList = new ArrayList<>(songCntMap.keySet());
        songList.sort((o1, o2) ->  songCntMap.get(o2).compareTo(songCntMap.get(o1)));

        System.out.println("songList = " + songList);

        for (String song : songList) {
            List<Song> answerSongList = songMap.get(song);
            Collections.sort(answerSongList);
            
            System.out.println("answerSongList = " + answerSongList);

            if (answerSongList.size() >= 2) {
                answer.add(answerSongList.get(0).index);
                answer.add(answerSongList.get(1).index);
            } else {
                for (Song obj : answerSongList) {
                    answer.add(obj.index);
                }
            }
        }

        return answer;
    }
}

class Song implements Comparable<Song> {

    int index;
    int playCnt;

    public Song(int index, int playCnt) {
        this.index = index;
        this.playCnt = playCnt;
    }

    @Override
    public int compareTo(Song o) {
        if (o.playCnt == playCnt) {
            return index - o.index > 0 ? 1 : -1;
        }

        return playCnt - o.playCnt > 0 ? -1 : 1;
    }
    
    @Override
    public String toString() {
        return "Song{" +
                "index=" + index +
                ", playCnt=" + playCnt +
                '}';
    }
}