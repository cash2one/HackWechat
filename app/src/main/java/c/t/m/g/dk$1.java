package c.t.m.g;

class dk$1 implements Runnable {
    private /* synthetic */ dk a;

    dk$1(dk dkVar) {
        this.a = dkVar;
    }

    public final void run() {
        dk.a(this.a);
        if (dk.b(this.a) > 0) {
            this.a.a(dk.b(this.a));
        }
        new StringBuilder("Wifi_Scan_Interval:").append(dk.b(this.a));
    }
}
