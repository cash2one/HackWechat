package android.support.b;

class a$e {
    public final long oC;
    public final long oD;

    private a$e(long j, long j2) {
        if (j2 == 0) {
            this.oC = 0;
            this.oD = 1;
            return;
        }
        this.oC = j;
        this.oD = j2;
    }

    public final String toString() {
        return this.oC + "/" + this.oD;
    }
}
