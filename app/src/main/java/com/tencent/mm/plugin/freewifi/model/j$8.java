package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bg.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class j$8 extends c<bg> {
    final /* synthetic */ j mEM;

    j$8(j jVar) {
        this.mEM = jVar;
        this.xen = bg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bg bgVar = (bg) bVar;
        x.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
        if (d.getNetworkType() != 0) {
            x.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
        } else {
            j.aLN();
            bgVar.fpw.fpy = h.b.aLc().aLa();
            bgVar.fpw.fpx = h.b.aLc().aKZ();
            String aLD = d.aLD();
            String aLB = d.aLB();
            if (!(bh.ov(aLD) || bh.ov(aLB))) {
                com.tencent.mm.plugin.freewifi.g.c AR = j.aLO().AR(aLD);
                if (AR != null) {
                    bgVar.fpw.fpz = AR.field_url;
                }
                bgVar.fpw.ssid = aLD;
                bgVar.fpw.bssid = m.AE("MicroMsg.FreeWifi.FreeWifiManager");
                bgVar.fpw.fpA = m.AF("MicroMsg.FreeWifi.FreeWifiManager");
                if (AR != null && aLD.equalsIgnoreCase(AR.field_ssid) && aLB.equalsIgnoreCase(AR.field_mac)) {
                    a aVar = bgVar.fpw;
                    if (AR == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                        aLD = null;
                    } else {
                        aLD = w.cfi();
                        aLD = aLD.equals("zh_CN") ? AR.field_showWordCn : (aLD.equals("zh_TW") || aLD.equals("zh_HK")) ? AR.field_showWordTw : AR.field_showWordEn;
                    }
                    aVar.fpB = aLD;
                    if (!(m.AA(bgVar.fpw.fpB) || i$a.mCp.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                        i$a.mCp.bm("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                    }
                    if (AR.field_expiredTime - bh.Wo() < 0) {
                        j.aLT().aLw();
                    }
                }
            }
        }
        return false;
    }
}
