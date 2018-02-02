package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.d.d.c;

class d$c$c {
    boolean ahf;
    final /* synthetic */ c xjt;
    c xju;
    d$c$c xjv;

    private d$c$c(c cVar) {
        this.xjt = cVar;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder("state=").append(this.xju.getName()).append(",active=").append(this.ahf).append(",parent=");
        if (this.xjv == null) {
            str = "null";
        } else {
            str = this.xjv.xju.getName();
        }
        return append.append(str).toString();
    }
}
