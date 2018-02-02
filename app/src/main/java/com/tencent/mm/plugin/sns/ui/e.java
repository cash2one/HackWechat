package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class e<T> {
    private af handler;
    List<Integer> rqk;

    public abstract void bT(List<T> list);

    public abstract List<T> byT();

    public e() {
        this.handler = null;
        this.rqk = new LinkedList();
        this.handler = ae.aNT();
        this.rqk.clear();
    }

    protected final void fC(boolean z) {
        int i = z ? 0 : 1;
        if (i == 1) {
            boolean z2;
            for (Integer intValue : this.rqk) {
                if (intValue.intValue() == 1) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (z2) {
                x.e("MicroMsg.AdapterLoader", "thread is loading ui should be not load any");
                return;
            }
        }
        if (z) {
            x.d("MicroMsg.AdapterLoader", "thread load" + this.rqk.size());
        } else {
            x.d("MicroMsg.AdapterLoader", "ui load");
        }
        if (this.rqk.size() <= 1) {
            this.rqk.add(Integer.valueOf(i));
            if (z) {
                ae.bvf().post(new 1(this, z));
            } else {
                b(true, byT());
            }
        }
    }

    final void b(boolean z, List<T> list) {
        this.handler.post(new 2(this, list, true));
    }
}
