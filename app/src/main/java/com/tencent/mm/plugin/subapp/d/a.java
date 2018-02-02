package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.g.a.fi;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<fi> {
    public a() {
        this.xen = fi.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fi fiVar = (fi) bVar;
        if (fiVar == null) {
            return false;
        }
        if (bh.ov(fiVar.fuz.fileName)) {
            x.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo fileName is null");
            return false;
        }
        p of = m.UD().of(fiVar.fuz.fileName);
        if (of == null) {
            x.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo voiceInfo is null");
            return false;
        }
        String str;
        int i;
        if (fiVar.fuz.fuA == 1 || fiVar.fuz.fuA == 2) {
            str = of.clientId;
            i = fiVar.fuz.scene;
            x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
            g.pQN.h(14220, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
        } else if (fiVar.fuz.fuA == 3) {
            str = of.clientId;
            i = fiVar.fuz.scene;
            x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextDoubleClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
            g.pQN.h(14220, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
        }
        return true;
    }
}
