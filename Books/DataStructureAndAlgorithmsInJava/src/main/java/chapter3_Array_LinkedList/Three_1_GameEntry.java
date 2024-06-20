package chapter3_Array_LinkedList;

public class Three_1_GameEntry {
    private String name;  // name of the person earning this score
    private int score;  // the score value

    /**
     * Constructs a game entry with given parameters..
     */
    public Three_1_GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "GameEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}