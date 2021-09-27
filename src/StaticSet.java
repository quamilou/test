import java.util.Arrays;

public class StaticSet {

    private int[] data;
    private int lastEl;

    public StaticSet(int taille) {
        this.data = new int[taille];
        this.lastEl = 0;
    }

    public boolean add(int el) {

        if (this.contains(el)) {
            return true;
        }

        if (this.lastEl >= this.data.length) {
            return false;
        }

        this.data[this.lastEl] = el;
        this.lastEl += 1;

        return true;
    }

    public boolean contains(int el) {
        for (int i = 0; i < this.lastEl; i++) {
            if (this.data[i] == el) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        Arrays.sort(this.data, 0, this.lastEl);
        String resul = "";

        for (int i = 0; i < this.lastEl; i++) {
            resul += this.data[i] + "-";
        }

        return resul.substring(0, resul.length() - 1);
    }

}
