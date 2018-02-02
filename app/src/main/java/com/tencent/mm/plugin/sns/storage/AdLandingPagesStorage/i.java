package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i roy = new i();
    private Map<Long, String> mDv = new HashMap();
    public x roA = ae.bvx();
    public Map<String, String> roB = new HashMap();
    private d roz = ae.bvw();

    static /* synthetic */ void a(i iVar) {
        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "clearing old canvasInfo cache");
        Cursor Tj = iVar.roz.Tj();
        if (Tj != null) {
            c cVar;
            long currentTimeMillis = System.currentTimeMillis() - 777600000;
            while (Tj.moveToNext()) {
                cVar = new com.tencent.mm.plugin.sns.storage.c();
                cVar.b(Tj);
                if (cVar.field_createTime < currentTimeMillis) {
                    com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "ad canvas eliminate %d " + cVar.field_canvasId);
                    iVar.roz.a(cVar, new String[0]);
                }
            }
            Tj.close();
            Tj = iVar.roA.Tj();
            if (Tj != null) {
                currentTimeMillis = System.currentTimeMillis() - 777600000;
                while (Tj.moveToNext()) {
                    cVar = new w();
                    cVar.b(Tj);
                    if (cVar.field_createTime < currentTimeMillis) {
                        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "ux canvas eliminate %d " + cVar.field_canvasId);
                        iVar.roA.a(cVar, new String[0]);
                    }
                }
                Tj.close();
            }
        }
    }

    public static i bxQ() {
        return roy;
    }

    private i() {
        HandlerThread Wf = e.Wf("OpenCanvasMgr");
        Wf.start();
        new af(Wf.getLooper()).postDelayed(new Runnable(this) {
            final /* synthetic */ i roC;

            {
                this.roC = r1;
            }

            public final void run() {
                i.a(this.roC);
            }
        }, 5000);
    }

    public final String h(long j, int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "open pageId %d, preLoad %d", Long.valueOf(j), Integer.valueOf(i));
        if (j <= 0) {
            return "";
        }
        String str = "";
        if (i2 != 1) {
            if (this.mDv.containsKey(Long.valueOf(j))) {
                str = (String) this.mDv.get(Long.valueOf(j));
            } else {
                c cVar = new com.tencent.mm.plugin.sns.storage.c();
                cVar.field_canvasId = j;
                this.roz.b(cVar, new String[0]);
                if (TextUtils.isEmpty(cVar.field_canvasXml)) {
                    str = "";
                } else {
                    this.mDv.put(Long.valueOf(j), cVar.field_canvasXml);
                    str = cVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str)) {
            return str;
        }
        final com.tencent.mm.plugin.sns.storage.c cVar2 = new com.tencent.mm.plugin.sns.storage.c();
        cVar2.field_canvasId = j;
        a aVar = new a();
        aVar.hmj = new xo();
        aVar.hmk = new xp();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        aVar.hmi = 1286;
        b JZ = aVar.JZ();
        ((xo) JZ.hmg.hmo).wig = j;
        final long j2 = j;
        final int i3 = i;
        u.a(JZ, new u.a(this) {
            final /* synthetic */ i roC;

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    xp xpVar = (xp) bVar.hmh.hmo;
                    com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(j2), xpVar.wih);
                    if (!TextUtils.isEmpty(xpVar.wih)) {
                        this.roC.mDv.put(Long.valueOf(j2), xpVar.wih);
                        cVar2.field_canvasXml = xpVar.wih;
                        this.roC.roz.a(cVar2);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
        return "";
    }

    public final void o(long j, String str) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            this.mDv.put(Long.valueOf(j), str);
            com.tencent.mm.plugin.sns.storage.c cVar = new com.tencent.mm.plugin.sns.storage.c();
            cVar.field_canvasId = j;
            cVar.field_canvasXml = str;
            this.roz.a(cVar);
        }
    }

    public final String l(final String str, String str2, final int i, int i2) {
        com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "open pageId %s, canvasExt %s, preLoad %d", str, str2, Integer.valueOf(i));
        if (bh.ov(str)) {
            return "";
        }
        String str3 = "";
        if (i2 != 1) {
            Object obj;
            if (bh.ov(str2)) {
                str3 = str;
            } else {
                obj = str + str2;
            }
            if (this.roB.containsKey(obj)) {
                str3 = (String) this.roB.get(obj);
            } else {
                c wVar = new w();
                wVar.field_canvasId = str;
                wVar.field_canvasExt = str2;
                this.roA.b(wVar, new String[]{"canvasId", "canvasExt"});
                if (TextUtils.isEmpty(wVar.field_canvasXml)) {
                    str3 = "";
                } else {
                    this.roB.put(obj, wVar.field_canvasXml);
                    str3 = wVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str3)) {
            return str3;
        }
        final w wVar2 = new w();
        wVar2.field_canvasId = str;
        a aVar = new a();
        aVar.hmj = new adt();
        aVar.hmk = new adu();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_getofficialcanvasinfo";
        aVar.hmi = 1890;
        b JZ = aVar.JZ();
        adt com_tencent_mm_protocal_c_adt = (adt) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_adt.wmk = str;
        com_tencent_mm_protocal_c_adt.wml = str2;
        u.a(JZ, new u.a(this) {
            final /* synthetic */ i roC;

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    Object cdp = ((adu) bVar.hmh.hmo).wmm.cdp();
                    com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", str, cdp);
                    if (!TextUtils.isEmpty(cdp)) {
                        this.roC.roB.put(str, cdp);
                        wVar2.field_canvasXml = cdp;
                        this.roC.roA.a(wVar2);
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", str, Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2));
                }
                return 0;
            }
        });
        return "";
    }
}
