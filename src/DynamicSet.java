import java.util.Arrays;
public class DynamicSet {
    //att
    private int[] data;
    private int lastEl;
    //cons
    public DynamicSet(int taille) {
        this.data = new int[taille];
        this.lastEl = 0;
    }
    //met
    public boolean add(int el) {
        if (this.contains(el)) {
            return true;
        }
        if (this.lastEl >= this.data.length) {
            int[] newTab = new int[(this.data.length + 1) * 10];
            System.arraycopy(this.data, 0, newTab, 0, this.data.length);
            this.data = newTab;
        }
        this.data[this.lastEl] = el;
        this.lastEl += 1;
        return true;
    }
    public boolean del(int el) {
        if (!this.contains(el)) {
            return false;
        }
        int i = 0;
        while (this.data[i] != el) {
            i += 1;
        }
        this.data[i] = this.data[this.lastEl - 1];
        this.lastEl -= 1;
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
        String res = "";
        for (int i = 0; i < this.lastEl; i++) {
            res += this.data[i] + "-";
        }
        return res.substring(0, res.length() - 1);
    }
}