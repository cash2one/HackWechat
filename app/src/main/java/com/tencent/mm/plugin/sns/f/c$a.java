package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bh;

class c$a {
    long mEndTime = -1;
    long mStartTime = -1;
    long qUc;
    d ral;
    int ram = 0;
    int ran = 0;
    String rao = "";
    String rap = "";
    String raq;

    public c$a(long j, long j2, String str, d dVar) {
        this.ral = dVar;
        this.mStartTime = j;
        this.qUc = j2;
        this.raq = str;
    }

    public final void dw(int i, int i2) {
        this.ram = i;
        this.ran = i2;
    }

    public final void q(int i, int i2, int i3, int i4) {
        if (i != -1 && i2 != -1) {
            String str = i + ":" + i2 + ":" + i3 + ":" + i4;
            String str2 = i + ":" + i2;
            if (!str.equals(this.rao)) {
                if (!this.rao.startsWith(str2) || i3 != 0 || i4 != 0) {
                    this.rao = str;
                    str = i + ":" + i2 + ":" + i3 + ":" + i4;
                    if (!bh.ov(this.rap)) {
                        this.rap += "|";
                    }
                    this.rap += str;
                }
            }
        }
    }
}
