package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b mCf;

    private i() {
        this.mCf = j.aLP();
    }

    public final synchronized long ow(String str) {
        long j = 0;
        synchronized (this) {
            if (!m.AA(str)) {
                try {
                    String AP = this.mCf.AP(str);
                    if (!m.AA(AP)) {
                        j = Long.valueOf(AP).longValue();
                    }
                } catch (Exception e) {
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        if (!m.AA(str)) {
            try {
                String AP = this.mCf.AP(str);
                if (!m.AA(AP)) {
                    i = Integer.valueOf(AP).intValue();
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public final synchronized void A(String str, long j) {
        this.mCf.cD(str, String.valueOf(j));
    }

    public final synchronized void bm(String str, int i) {
        this.mCf.cD(str, String.valueOf(i));
    }
}
