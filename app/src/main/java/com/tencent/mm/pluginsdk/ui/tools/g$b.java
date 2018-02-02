package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class g$b implements Runnable {
    private int mvv;
    private int nUr;
    private String url;
    final /* synthetic */ g vxl;
    private String[] vxu;
    private String vxv;

    private g$b(g gVar) {
        this.vxl = gVar;
    }

    private Bitmap SP(String str) {
        if (str == null) {
            return null;
        }
        if (this.mvv <= 0 || this.nUr <= 0) {
            return j.op(str);
        }
        String str2 = str + "_" + this.nUr + "_" + this.mvv;
        Bitmap m = j.m(str2, this.nUr, this.mvv);
        if (m != null) {
            return m;
        }
        int UJ = ExifHelper.UJ(str);
        if (90 == UJ || 270 == UJ) {
            m = d.d(str, this.nUr, this.mvv, true);
        } else {
            m = d.d(str, this.mvv, this.nUr, true);
        }
        if (m == null) {
            return m;
        }
        m = d.b(m, (float) UJ);
        try {
            d.a(m, 100, CompressFormat.PNG, str2, false);
            return m;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ImageEngine", e, "", new Object[0]);
            return m;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        if (this.vxl.vxa) {
            x.w("MicroMsg.ImageEngine", "on load image jog, isQuit, return");
            return;
        }
        synchronized (this.vxl.gSF) {
            if (this.vxl.vxd.get(this.vxv) == null) {
                x.w("MicroMsg.ImageEngine", "check before decode, no match wait to render view, renderKey is %s, return", new Object[]{this.vxv});
            }
        }
    }
}
