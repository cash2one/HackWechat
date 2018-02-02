package com.tencent.mm.plugin.translate;

import com.tencent.mm.g.a.rn;
import com.tencent.mm.plugin.translate.a.2;
import com.tencent.mm.plugin.translate.a.c;
import com.tencent.mm.plugin.translate.a.c$c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class a$2$1 implements Runnable {
    final /* synthetic */ rn sfZ;
    final /* synthetic */ 2 sga;

    a$2$1(2 2, rn rnVar) {
        this.sga = 2;
        this.sfZ = rnVar;
    }

    public final void run() {
        c cVar = this.sga.sfW.sfR;
        String str = this.sfZ.fJp.fJq;
        String str2 = this.sfZ.fJp.id;
        int i = this.sfZ.fJp.type;
        String str3 = this.sfZ.fJp.bhd;
        boolean z = this.sfZ.fJp.fJr;
        x.d("MicroMsg.TranslateServiceManager", "doTranslate msgId : %s, type: %d", new Object[]{str2, Integer.valueOf(i)});
        if (cVar.Mx(str2)) {
            x.d("MicroMsg.TranslateServiceManager", "doTranslate msgId %s is inQueue", new Object[]{str2});
            return;
        }
        c$c com_tencent_mm_plugin_translate_a_c_c = new c$c(str, str2, i, str3);
        if (z) {
            ((LinkedList) cVar.sgd).add(0, com_tencent_mm_plugin_translate_a_c_c);
        } else {
            cVar.sgd.add(com_tencent_mm_plugin_translate_a_c_c);
        }
        cVar.sge.put(com_tencent_mm_plugin_translate_a_c_c.id, Integer.valueOf(com_tencent_mm_plugin_translate_a_c_c.sgg));
        x.d("MicroMsg.TranslateServiceManager", "requestCount : %s", new Object[]{Integer.valueOf(cVar.kIS)});
        cVar.bFA();
    }
}
