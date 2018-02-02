package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.e;

public final class k {
    public String appId;
    public int fIm;
    public int fno;
    public final String fqu;
    public final e irF;
    public volatile long jIB;
    public volatile boolean jIC = false;
    public int jID;
    public int jIE;
    public long jIF;
    public long jIG;
    public String jIa;
    public int scene;

    public k(e eVar) {
        this.irF = eVar;
        this.fqu = eVar.iqw.irG;
    }

    public final String toString() {
        return "kv_14576{, networkType='" + this.jIa + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.fIm + ", appState=" + this.fno + ", scene=" + this.scene + ", sessionId='" + this.fqu + '\'' + ", is_download_code=" + this.jID + ", is_load_x5=" + this.jIE + ", cost_time=" + this.jIF + ", event_time=" + this.jIG + '}';
    }
}
