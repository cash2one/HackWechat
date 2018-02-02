package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.em;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.pluginsdk.ui.tools.r.a {
    private static String DEVICE_TYPE = "lan";
    private static a tBN;
    public String frn;
    public boolean hasInit = false;
    public a tBM;
    public byte[] tBO = null;
    private int tBP = -1;
    public boolean tBQ = false;

    private a() {
    }

    public static a bTn() {
        if (tBN == null) {
            tBN = new a();
        }
        return tBN;
    }

    public final String getName() {
        return "WebViewExDeviceLanMgr";
    }

    public final void bTo() {
        b emVar;
        x.i("MicroMsg.webview.WebViewExDeviceLanMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.tBQ)});
        if (this.tBQ) {
            emVar = new em();
            emVar.ftd.fro = false;
            com.tencent.mm.sdk.b.a.xef.m(emVar);
            this.tBQ = false;
        }
        this.hasInit = false;
        if (this.tBM != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.tBM.tBR);
            com.tencent.mm.sdk.b.a.xef.c(this.tBM.tBS);
            com.tencent.mm.sdk.b.a.xef.c(this.tBM.tBU);
            com.tencent.mm.sdk.b.a.xef.c(this.tBM.tBT);
            com.tencent.mm.sdk.b.a.xef.c(this.tBM.tBV);
            this.tBM = null;
        }
        this.tBO = null;
        emVar = new dv();
        emVar.fst.fro = false;
        com.tencent.mm.sdk.b.a.xef.m(emVar);
    }

    public final void dP(Context context) {
    }

    public final void bTp() {
    }
}
