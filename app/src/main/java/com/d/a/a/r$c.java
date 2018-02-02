package com.d.a.a;

class r$c extends r$a {
    private final String bjQ;
    private final long bjR;
    private final int bjS;

    private r$c(r rVar, String str, long j, int i) {
        super(rVar);
        this.bjQ = str;
        this.bjR = j;
        this.bjS = i;
    }

    public final void run() {
        try {
            switch (this.bjS) {
                case 0:
                    r.a(sj(), this.bjQ, this.bjR);
                    return;
                case 1:
                    r.a(sj(), this.bjQ);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }
}
