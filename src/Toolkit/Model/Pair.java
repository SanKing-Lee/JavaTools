package Toolkit.Model;

public class Pair {
    private String name;
    private String value;

    public Pair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
