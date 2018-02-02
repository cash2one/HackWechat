package com.tencent.mm.plugin.appbrand.page;

abstract class e$b implements Runnable {
    boolean Mu;
    private boolean jDd;

    public abstract void aiO();

    private e$b() {
        this.jDd = false;
        this.Mu = false;
    }

    public void run() {
        boolean z = (this.jDd || this.Mu) ? false : true;
        if (z) {
            this.jDd = true;
            aiO();
        }
    }
}
