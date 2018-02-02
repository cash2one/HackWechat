package com.tencent.mm.plugin.card.a;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class g$1 implements a {
    final /* synthetic */ g kIU;

    g$1(g gVar) {
        this.kIU = gVar;
    }

    public final boolean uF() {
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
        g gVar = this.kIU;
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
        if (gVar.kIv != null) {
            for (int i = 0; i < gVar.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) gVar.kIv.get(i);
                if (weakReference != null) {
                    g$a com_tencent_mm_plugin_card_a_g_a = (g$a) weakReference.get();
                    if (com_tencent_mm_plugin_card_a_g_a != null) {
                        com_tencent_mm_plugin_card_a_g_a.aub();
                    }
                }
            }
        }
        return true;
    }
}
