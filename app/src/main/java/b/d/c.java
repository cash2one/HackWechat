package b.d;

public final class c extends a {
    private static final c AuZ = new c(1, 0);
    public static final a Ava = new a((byte) 0);

    public c(int i, int i2) {
        super(i, i2);
    }

    public final boolean isEmpty() {
        return this.cid > this.AuU;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((isEmpty() && ((c) obj).isEmpty()) || (this.cid == ((c) obj).cid && this.AuU == ((c) obj).AuU));
    }

    public final int hashCode() {
        return isEmpty() ? -1 : (this.cid * 31) + this.AuU;
    }

    public final String toString() {
        return this.cid + ".." + this.AuU;
    }
}
