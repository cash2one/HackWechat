package b.d;

import java.util.Iterator;

public class a implements b.c.b.a.a, Iterable<Integer> {
    public static final a AuV = new a((byte) 0);
    final int AuU;
    final int cid;
    private final int jer = 1;

    public /* synthetic */ Iterator iterator() {
        return new b(this.cid, this.AuU, this.jer);
    }

    public a(int i, int i2) {
        this.cid = i;
        this.AuU = i2 - b.b.a.fQ(b.b.a.fQ(i2, 1) - b.b.a.fQ(i, 1), 1);
    }

    public boolean isEmpty() {
        return this.jer > 0 ? this.cid > this.AuU : this.cid < this.AuU;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((isEmpty() && ((a) obj).isEmpty()) || (this.cid == ((a) obj).cid && this.AuU == ((a) obj).AuU && this.jer == ((a) obj).jer));
    }

    public int hashCode() {
        return isEmpty() ? -1 : (((this.cid * 31) + this.AuU) * 31) + this.jer;
    }

    public String toString() {
        return this.jer > 0 ? this.cid + ".." + this.AuU + " step " + this.jer : this.cid + " downTo " + this.AuU + " step " + (-this.jer);
    }
}
