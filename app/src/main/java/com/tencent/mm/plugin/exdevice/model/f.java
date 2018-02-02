package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

public final class f {

    static class AnonymousClass1 implements a {
        final /* synthetic */ Runnable fgd;
        final /* synthetic */ long lkU;

        public AnonymousClass1(long j, Runnable runnable) {
            this.lkU = j;
            this.fgd = runnable;
        }

        public final void v(String str, boolean z) {
            if (z) {
                x.v("MicroMsg.exdevice.ExdeviceLogic", "getContact suc; cost=" + (bh.Wp() - this.lkU) + " ms");
                b.I(str, 3);
                if (this.fgd != null) {
                    this.fgd.run();
                    return;
                }
                return;
            }
            x.w("MicroMsg.exdevice.ExdeviceLogic", "getContact failed");
        }
    }

    public static boolean V(Context context, String str) {
        if (bh.ov(str)) {
            x.i("MicroMsg.exdevice.ExdeviceLogic", "Jump to webview failed, url is null or nil.");
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    public static void a(com.tencent.mm.plugin.exdevice.h.b bVar, ajr com_tencent_mm_protocal_c_ajr, ajs com_tencent_mm_protocal_c_ajs) {
        if (com_tencent_mm_protocal_c_ajs != null) {
            bVar.field_connProto = com_tencent_mm_protocal_c_ajs.wqK;
            bVar.field_connStrategy = com_tencent_mm_protocal_c_ajs.wqL;
            bVar.field_closeStrategy = com_tencent_mm_protocal_c_ajs.wqM;
            bVar.field_mac = com.tencent.mm.plugin.exdevice.j.b.zu(com.tencent.mm.plugin.exdevice.j.b.zv(com_tencent_mm_protocal_c_ajs.vLs));
            bVar.field_authKey = com_tencent_mm_protocal_c_ajs.vJh;
            bVar.field_brandName = com_tencent_mm_protocal_c_ajs.wqJ;
            bVar.cZ(com_tencent_mm_protocal_c_ajs.hvy);
            bVar.an(com_tencent_mm_protocal_c_ajs.gfS);
            bVar.dN(com_tencent_mm_protocal_c_ajs.wqS);
            bVar.dM(com_tencent_mm_protocal_c_ajs.wqR);
            bVar.dL(com_tencent_mm_protocal_c_ajs.wqQ);
            bVar.eY(com_tencent_mm_protocal_c_ajs.wqT);
            bVar.dJ(com_tencent_mm_protocal_c_ajs.nfT);
            bVar.eZ(com_tencent_mm_protocal_c_ajs.gfR);
            bVar.dK(com_tencent_mm_protocal_c_ajs.nfg);
            bVar.dO(com_tencent_mm_protocal_c_ajs.gfT);
            bVar.dP(com_tencent_mm_protocal_c_ajs.gfU);
            bVar.dQ(com_tencent_mm_protocal_c_ajs.gfV);
            bVar.dR(com_tencent_mm_protocal_c_ajs.gfW);
        }
        if (com_tencent_mm_protocal_c_ajr != null) {
            bVar.field_deviceID = com_tencent_mm_protocal_c_ajr.ksX;
            bVar.field_deviceType = com_tencent_mm_protocal_c_ajr.vJA;
            bVar.field_md5Str = g.s(new String(com_tencent_mm_protocal_c_ajr.vJA + com_tencent_mm_protocal_c_ajr.ksX).getBytes());
            if (bh.ov(bVar.field_brandName)) {
                bVar.field_brandName = com_tencent_mm_protocal_c_ajr.vJA;
            }
        }
    }

    public static boolean b(com.tencent.mm.plugin.exdevice.h.b bVar) {
        return bVar != null && (bVar.gfS & 1) == 1;
    }
}
