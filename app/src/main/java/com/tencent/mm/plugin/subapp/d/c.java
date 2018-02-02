package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.g.a.fj;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import org.xwalk.core.Log;

public final class c extends com.tencent.mm.sdk.b.c<fj> {
    public c() {
        this.xen = fj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fj fjVar = (fj) bVar;
        if (fjVar == null) {
            return false;
        }
        if (bh.ov(fjVar.fuB.fileName)) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo fileName is null");
            return false;
        }
        p of = m.UD().of(fjVar.fuB.fileName);
        if (of == null) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo voiceInfo is null");
            return false;
        }
        b.b(of.clientId, fjVar.fuB.fuC, fjVar.fuB.fuD, fjVar.fuB.fuE, fjVar.fuB.result);
        return true;
    }
}
