package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.bh;

public final class b {
    long ibv = 0;
    long orG = bh.Wq();
    long orH = bh.Wq();
    private String tag = "default";
    long value = 0;

    public b(String str) {
        this.tag = str;
    }

    public final void dN(long j) {
        if (this.ibv == 0) {
            this.orG = bh.Wq();
        }
        this.value += j;
        this.ibv++;
        this.orH = bh.Wq();
    }

    public final String getValue() {
        String str = "";
        if (this.ibv == 0) {
            return "";
        }
        double d = ((double) (this.orH - this.orG)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[]{str, this.tag, Long.valueOf(this.ibv), Double.valueOf(d), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.ibv)), Double.valueOf((((double) this.ibv) * 1.0d) / d), Double.valueOf((1.0d * ((double) this.value)) / d), Long.valueOf(this.orG), Long.valueOf(this.orH), Long.valueOf(this.orH - this.orG)});
    }

    public final String aZV() {
        if (this.ibv == 0) {
            return "";
        }
        double d = ((double) (this.orH - this.orG)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return ((1.0d * ((double) this.ibv)) / d);
    }

    public final void reset() {
        this.value = 0;
        this.ibv = 0;
    }
}
