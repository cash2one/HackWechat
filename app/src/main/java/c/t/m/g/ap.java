package c.t.m.g;

final class ap implements Runnable {
    private /* synthetic */ al a;

    ap(al alVar) {
        this.a = alVar;
    }

    public final void run() {
        if (this.a.f.size() == 0) {
            this.a.a.incrementAndGet();
            this.a.b(false, true);
            return;
        }
        this.a.a(true, true);
    }
}
