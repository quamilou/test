public class TestStaticSet {

    public boolean testContains() {
        StaticSet s = new StaticSet(10);
        s.add(1);
        s.add(2);
        s.add(3);

        return s.contains(1) && !s.contains(5);
    }

    public boolean testToString() {
        StaticSet s = new StaticSet(10);
        s.add(2);
        s.add(1);
        s.add(3);
        s.add(2);
        for(int i=0; i<15; i++) {
        s.add(i);
        }
        String expectedRes = "0-1-2-3-4-5-6-7-8-9";
        String res = s.toString();
        //System.out.println(s.toString());

        return res.equals(expectedRes);
    }

    public boolean test() {
        System.out.println("Test toString\t\t[" + this.testToString() + "]");
        System.out.println("Test Contains\t\t[" + this.testContains() + "]");

        return this.testToString() && this.testContains();
    }

    public static void main(String[] argx) {
        TestStaticSet t = new TestStaticSet();

        if (!t.test()) {
            System.out.println("\n\n Échec");
        }
    }

}