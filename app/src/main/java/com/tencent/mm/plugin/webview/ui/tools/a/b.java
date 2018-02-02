package com.tencent.mm.plugin.webview.ui.tools.a;

import android.content.Context;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.pluginsdk.ui.tools.r.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    private static final byte[] lNj = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static b tBY;
    public String frn;
    public boolean hasInit = false;
    public byte[] tBO = null;
    public boolean tBQ = false;
    public a tBX;
    public int tBZ = -1;
    public boolean tCa = false;

    private b() {
    }

    public static b bTq() {
        if (tBY == null) {
            tBY = new b();
        }
        return tBY;
    }

    public final String getName() {
        return "WebViewExDeviceMgr";
    }

    public final void bTo() {
        com.tencent.mm.sdk.b.b dwVar;
        x.i("MicroMsg.webview.WebViewExDeviceMgr", "stopPlugin, isScaning = %s", new Object[]{Boolean.valueOf(this.tBQ)});
        if (this.tBQ) {
            dwVar = new dw();
            dwVar.fsu.fro = false;
            dwVar.fsu.frn = this.frn;
            com.tencent.mm.sdk.b.a.xef.m(dwVar);
            if (!dwVar.fsv.frp) {
                x.e("MicroMsg.webview.WebViewExDeviceMgr", "stopScanWXDevice fail");
            }
            this.tBQ = false;
        }
        this.hasInit = false;
        if (this.tBX != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.tBX.tCb);
            com.tencent.mm.sdk.b.a.xef.c(this.tBX.tCc);
            com.tencent.mm.sdk.b.a.xef.c(this.tBX.tCd);
            com.tencent.mm.sdk.b.a.xef.c(this.tBX.tBR);
            com.tencent.mm.sdk.b.a.xef.c(this.tBX.qsg);
            this.tBX = null;
        }
        this.tBO = null;
        dwVar = new ec();
        dwVar.fsL.ffq = "";
        dwVar.fsL.direction = 0;
        dwVar.fsL.clear = true;
        com.tencent.mm.sdk.b.a.xef.m(dwVar);
        x.i("MicroMsg.webview.WebViewExDeviceMgr", "stop EcDeviceMgr for webview %s", new Object[]{Boolean.valueOf(dwVar.fsM.frp)});
    }

    public static boolean aZ(byte[] bArr) {
        if (bArr != null && bArr.length >= 9 && bArr[bArr.length - 7] == (byte) 1 && bArr[bArr.length - 8] == (byte) 1 && bArr[bArr.length - 9] == (byte) -2) {
            return true;
        }
        return false;
    }

    public final void dP(Context context) {
    }

    public final void bTp() {
    }
}
