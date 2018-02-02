package c.t.m.g;

public final class bw implements bc, bu {
    private static bw a = new bw();
    private bu b;
    private bc c;
    private boolean d = false;

    private bw() {
    }

    public static bw c() {
        return a;
    }

    public final void a() {
        this.b.a();
    }

    public final void a(int i) {
        this.b.a(i);
    }

    public final void a(bc bcVar) {
        this.c = bcVar;
    }

    public final void a(String str, String str2) {
        this.c.a(str, str2);
    }

    public final void a(String str, byte[] bArr, String str2) {
        this.c.a(str, bArr, str2);
    }

    public final void a_() {
        this.c.a_();
    }

    public final void b() {
        this.b.b();
    }

    public final synchronized void d() {
        if (!this.d) {
            this.b = bo.c();
            if (this.b != null) {
                this.b.a(this);
                this.b.d();
            }
            this.d = true;
        }
    }
}
