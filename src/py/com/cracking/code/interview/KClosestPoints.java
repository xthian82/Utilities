package py.com.cracking.code.interview;

import java.util.TreeSet;

public class KClosestPoints {

    public static void main(String[] args) {
        TreeSet<Coord> values = new TreeSet<>();

        values.add(new Coord(1,4));
        values.add(new Coord(2,6));
        values.add(new Coord(1,-8));
        values.add(new Coord(0,2));
        values.add(new Coord(4,0));

        values.forEach(val -> System.out.println(val));
    }
}

class Coord implements Comparable<Coord> {

    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance() {
        return Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) );
    }

    @Override
    public int compareTo(Coord o) {
        double thisD = this.getDistance();
        double oD = o.getDistance();

        if (thisD < oD) {
            return -1;
        } else if (thisD > oD) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ") ";
    }
}