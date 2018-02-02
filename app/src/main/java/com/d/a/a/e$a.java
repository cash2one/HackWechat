package com.d.a.a;

class e$a implements Runnable {
    private boolean bgN;
    final /* synthetic */ e bgO;
    private boolean started;

    private e$a(e eVar) {
        this.bgO = eVar;
    }

    public final void run() {
        if (!this.bgN) {
            this.bgO.rV();
            this.bgO.handler.postDelayed(this, this.bgO.bgM);
        }
    }

    static /* synthetic */ void a(e$a com_d_a_a_e_a, long j) {
        if (!com_d_a_a_e_a.started && !com_d_a_a_e_a.bgN) {
            com_d_a_a_e_a.bgO.handler.postDelayed(com_d_a_a_e_a, j);
            com_d_a_a_e_a.started = true;
        }
    }

    static /* synthetic */ void a(e$a com_d_a_a_e_a) {
        com_d_a_a_e_a.bgN = true;
        com_d_a_a_e_a.bgO.handler.removeCallbacks(com_d_a_a_e_a);
    }
}
