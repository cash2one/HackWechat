package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.an;

public final class a {
    public String fqR = "";
    public String mediaId = "";
    public e qQL = null;
    public String qTQ = "";
    public String qTU = "";
    public aqr qTV;
    public boolean qYA = false;
    public int qYB = 0;
    public an qYC;
    public boolean qYz = false;
    public String url = "";

    public a(String str) {
        this.mediaId = str;
    }

    public final boolean init() {
        this.qTQ = am.r(ae.getAccSnsPath(), this.mediaId);
        return true;
    }

    public final String bwf() {
        if (this.qYB == 4) {
            return i.p(this.qTV);
        }
        if (this.qYB == 6) {
            return i.q(this.qTV);
        }
        return this.qYz ? i.n(this.qTV) : i.m(this.qTV);
    }

    public final String getPath() {
        if (bh.ov(this.qTQ)) {
            init();
        }
        return this.qTQ;
    }
}
