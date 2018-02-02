package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b$h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.i;
import com.tencent.mm.y.m;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class k {

    static class AnonymousClass2 implements b$h {
        final /* synthetic */ m yrK;

        AnonymousClass2(m mVar) {
            this.yrK = mVar;
        }

        public final void Jm() {
        }

        public final void j(Bitmap bitmap) {
            x.d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", new Object[]{this.yrK.hen});
        }

        public final void Jn() {
        }

        public final String Jo() {
            return com.tencent.mm.plugin.appbrand.p.k.bi(this);
        }
    }

    public static void b(String str, a aVar, String str2) {
        Bitmap bitmap = null;
        try {
            byte[] bArr = new byte[0];
            if (!bh.ov(str2) && (str2.startsWith("http://") || str2.startsWith("https://"))) {
                bitmap = b.Jj().a(str2, null);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                x.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
            } else {
                x.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            int i = s.eV(str) ? 1 : 0;
            l.a(aVar, aVar.hdy, aVar.title, str, null, bArr);
            g.pQN.h(14127, new Object[]{aVar.hdy, aVar.hdx, aVar.hdw, aVar.title, aVar.description, "", aVar.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", e, "", new Object[0]);
            x.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
    }

    public static a a(String str, m mVar) {
        a aVar = new a();
        aVar.title = mVar.title;
        aVar.description = mVar.hef;
        aVar.type = 33;
        aVar.hdx = mVar.hei;
        aVar.hdw = mVar.hej;
        aVar.hdy = mVar.hem;
        aVar.hdE = mVar.hel;
        aVar.hdF = mVar.hek;
        aVar.hdA = "";
        aVar.hdz = 2;
        aVar.url = mVar.url;
        aVar.hdG = mVar.heo;
        aVar.fGF = "wxapp_" + mVar.hem + mVar.hej;
        aVar.fGz = mVar.hei;
        aVar.fGA = mVar.hep;
        d aVar2 = new com.tencent.mm.y.a();
        aVar2.haz = false;
        aVar2.haA = "";
        aVar.a(aVar2);
        if (bh.ov(aVar.thumburl)) {
            h jm = n.JQ().jm(str);
            if (jm != null) {
                aVar.thumburl = jm.JG();
            }
        }
        return aVar;
    }

    public static boolean e(au auVar, int i) {
        if (auVar == null || !auVar.ciV()) {
            return false;
        }
        List list = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content).hdX;
        if (bh.cA(list)) {
            return false;
        }
        if (i < 0 || i >= list.size()) {
            i = 0;
        }
        if (i.fV(((m) list.get(i)).hei)) {
            return true;
        }
        return false;
    }
}
