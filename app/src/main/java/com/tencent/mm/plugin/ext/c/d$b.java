package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;

class d$b {
    byte[] fFw;
    int fFy;
    public String fqR;
    int mbk;
    int mbl;
    Rect mbm;

    public d$b(byte[] bArr, int i, int i2, int i3, Rect rect, String str) {
        this.fFw = bArr;
        this.mbk = i;
        this.mbl = i2;
        this.fFy = i3;
        this.mbm = rect;
        this.fqR = str;
    }

    public final String toString() {
        return "RetrieveResult{yuvDataLength=" + (this.fFw != null ? Integer.valueOf(this.fFw.length) : "null") + ", previewWidth=" + this.mbk + ", previewHeight=" + this.mbl + ", rotate=" + this.fFy + ", scanRect=" + this.mbm + ", md5=" + this.fqR + '}';
    }
}
