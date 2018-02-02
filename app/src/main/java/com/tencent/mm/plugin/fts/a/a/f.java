package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.sdk.platformtools.bh;
import java.io.UnsupportedEncodingException;

public abstract class f extends a {
    public g mLN;
    public h mLO;

    public f(g gVar) {
        this.mLN = gVar;
    }

    public void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, false);
        hVar.bjW = -5;
    }

    public final boolean execute() {
        g gVar = this.mLN;
        if (!bh.ov(gVar.fDj)) {
            try {
                gVar.fDj = new String(gVar.fDj.getBytes("UTF8"), "UTF8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.mLO = new h(this.mLN);
        try {
            this.mLO.mMa = this;
            a(this.mLO);
            this.mLO.bjW = 0;
            if (this.mLN.handler == null) {
                this.mLN.mLZ.b(this.mLO);
            } else {
                this.mLN.handler.post(new 1(this));
            }
            return true;
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                this.mLO.bjW = 1;
            } else {
                this.mLO.bjW = -1;
            }
            throw e2;
        } catch (Throwable th) {
            if (this.mLN.handler == null) {
                this.mLN.mLZ.b(this.mLO);
            } else {
                this.mLN.handler.post(new 1(this));
            }
        }
    }
}
