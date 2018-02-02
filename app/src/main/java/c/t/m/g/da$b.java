package c.t.m.g;

class da$b implements Runnable {
    dn a;
    private cr b;

    public da$b(cr crVar) {
        this.b = crVar;
    }

    public final void run() {
        cr crVar = this.b;
        dn dnVar = this.a;
        if (dnVar != null) {
            dnVar.a(ea.c(crVar));
            crVar.c(dnVar);
        }
    }
}
