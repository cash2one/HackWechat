package c.t.m.g;

final class by implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ bx b;

    by(bx bxVar, int i) {
        this.b = bxVar;
        this.a = i;
    }

    public final void run() {
        bx.a(this.b).a(this.a);
    }
}
