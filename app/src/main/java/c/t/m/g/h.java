package c.t.m.g;

final class h implements Runnable {
    private /* synthetic */ k a;
    private /* synthetic */ i b;

    h(k kVar, i iVar) {
        this.a = kVar;
        this.b = iVar;
    }

    public final void run() {
        this.b.a(this.a.a());
        this.b.j.countDown();
    }
}
