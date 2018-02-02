package com.tencent.mm.plugin.ipcall.a.e;

public class a {
    public boolean fAs = false;

    public void start() {
        reset();
        this.fAs = true;
    }

    public void reset() {
    }

    protected void aUb() {
    }

    public final void finish() {
        if (this.fAs) {
            aUb();
            this.fAs = false;
        }
    }
}
