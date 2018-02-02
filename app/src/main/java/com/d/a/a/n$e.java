package com.d.a.a;

class n$e {
    long bjr;
    boolean bjs;
    final /* synthetic */ n bjt;

    private n$e(n nVar) {
        this.bjt = nVar;
        this.bjs = y.bmQ;
    }

    final void ax(boolean z) {
        if ((this.bjs ^ z) != 0) {
            this.bjs = !this.bjs;
            this.bjt.biT.sk();
            this.bjt.biT.sm();
            this.bjt.biQ.ax(this.bjs);
            this.bjt.rZ();
            if (y.bmL) {
                String str = "vehicle mode: " + (this.bjs ? "enable" : "disable");
                o.o("filter_input_log_" + y.bmS, str);
                o.o("filter_output_log_" + y.bmS, str);
            }
        }
    }

    final void reset() {
        this.bjr = 0;
        this.bjs = y.bmQ;
    }
}
