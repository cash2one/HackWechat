package com.tencent.mm.plugin.webview.model;

import android.content.ContentValues;
import com.tencent.mm.by.h;
import com.tencent.mm.g.b.bz;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.b;
import com.tencent.mm.sdk.platformtools.au.c;
import com.tencent.mm.z.ar;

public final class d implements c<Integer, Long> {
    public static final String[] gJN = new String[]{i.a(iEJ, "JsLogBlockList")};
    private static final a iEJ = bz.vJ();
    public final h hhp;
    public final au<Integer, Long> trR = new au(this, ar.Dm().oAt.getLooper(), 100, 20, 300000, 1000);
    private long trS;

    public d(h hVar) {
        this.hhp = hVar;
    }

    public final void bQz() {
        this.trR.lE(true);
    }

    public final boolean SY() {
        if (this.hhp.inTransaction()) {
            return false;
        }
        this.trS = this.hhp.dz(Thread.currentThread().getId());
        if (this.trS > 0) {
            return true;
        }
        return false;
    }

    public final void a(au<Integer, Long> auVar, b<Integer, Long> bVar) {
        switch (bVar.xhD) {
            case 1:
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("logId", (Integer) bVar.vxB);
                contentValues.put("liftTime", (Long) bVar.values);
                this.hhp.replace("JsLogBlockList", "logId", contentValues);
                return;
            case 2:
                this.hhp.delete("JsLogBlockList", "logId=" + bVar.vxB, null);
                return;
            default:
                return;
        }
    }

    public final void SZ() {
        if (this.trS > 0) {
            this.hhp.fS(this.trS);
        }
    }
}
