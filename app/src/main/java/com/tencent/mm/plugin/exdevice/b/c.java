package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c {
    public long kAq = -1;
    public short lKa = (short) -1;
    public e lKb = null;
    protected a lKc = null;

    public abstract short aDG();

    public abstract short aDH();

    public abstract byte[] aDI();

    protected final e U(int i, String str) {
        this.lKb = new e();
        this.lKb.lOr = i;
        this.lKb.lOs = str;
        return this.lKb;
    }
}
