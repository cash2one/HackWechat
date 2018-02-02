package com.tencent.mm.compatible.g;

import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int fqv;
    public String gHg;
    public long gHh;
    public int gHi;

    public a() {
        this.gHg = null;
        this.gHh = -1;
        this.gHi = -1;
        this.fqv = -1;
        this.gHg = null;
        this.gHh = -1;
        this.gHi = -1;
        this.fqv = -1;
    }

    public final String zb() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.gHg);
        stringBuffer.append(",");
        stringBuffer.append(this.gHh);
        stringBuffer.append(",");
        stringBuffer.append(this.gHi);
        stringBuffer.append(",");
        stringBuffer.append(this.fqv);
        x.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        return stringBuffer.toString();
    }
}
