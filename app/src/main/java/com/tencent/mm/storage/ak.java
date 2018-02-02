package com.tencent.mm.storage;

public final class ak {
    public String fqV;
    public String lEM;
    public int xyB;
    private boolean xyC;
    public int xyD;
    public int xyE;
    public String xyF;

    public ak() {
        this.xyC = false;
        this.xyB = -1;
    }

    public ak(String str) {
        this.xyC = false;
        this.fqV = str;
        this.xyB = -1;
    }

    public final void Do(int i) {
        if (!(this.xyB == -1 || this.xyB == i || i != 7)) {
            this.xyC = true;
        }
        this.xyB = i;
    }
}
