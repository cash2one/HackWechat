package c.t.m.g;

class ak$a {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;

    private ak$a() {
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }

    public final void a() {
        long j = -1;
        this.g = this.b - this.a;
        this.h = this.c - this.b;
        this.i = this.d - this.c;
        this.j = this.e - this.d;
        this.k = this.f - this.e;
        long j2 = this.g;
        if (j2 < 0) {
            j2 = -1;
        }
        this.g = j2;
        j2 = this.h;
        if (j2 < 0) {
            j2 = -1;
        }
        this.h = j2;
        j2 = this.i;
        if (j2 < 0) {
            j2 = -1;
        }
        this.i = j2;
        j2 = this.j;
        if (j2 < 0) {
            j2 = -1;
        }
        this.j = j2;
        j2 = this.k;
        if (j2 >= 0) {
            j = j2;
        }
        this.k = j;
    }

    public final String toString() {
        return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
    }
}
