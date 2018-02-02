package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public final class bf {
    private boolean jEy = false;
    private String mTag;
    private String xin;
    ArrayList<Long> xio;
    ArrayList<String> xip;

    public bf(String str, String str2) {
        this.mTag = str;
        this.xin = str2;
        if (!this.jEy) {
            if (this.xio == null) {
                this.xio = new ArrayList();
                this.xip = new ArrayList();
            } else {
                this.xio.clear();
                this.xip.clear();
            }
            addSplit(null);
        }
    }

    public final void addSplit(String str) {
        if (!this.jEy) {
            this.xio.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.xip.add(str);
        }
    }

    public final void dumpToLog() {
        if (!this.jEy) {
            x.d(this.mTag, this.xin + ": begin");
            long longValue = ((Long) this.xio.get(0)).longValue();
            int i = 1;
            long j = longValue;
            while (i < this.xio.size()) {
                long longValue2 = ((Long) this.xio.get(i)).longValue();
                x.d(this.mTag, this.xin + ":      " + (longValue2 - ((Long) this.xio.get(i - 1)).longValue()) + " ms, " + ((String) this.xip.get(i)));
                i++;
                j = longValue2;
            }
            x.d(this.mTag, this.xin + ": end, " + (j - longValue) + " ms");
        }
    }
}
