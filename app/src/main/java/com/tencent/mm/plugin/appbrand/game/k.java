package com.tencent.mm.plugin.appbrand.game;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class k {
    boolean iXC = false;
    j iXD;
    f iXE;
    a iXF;
    a iXG;
    private Boolean iXH = null;

    public k(j jVar, b bVar) {
        if (jVar == null || bVar == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Input failed. service is [%s] jsRuntime = [%s]", jVar, bVar);
            return;
        }
        f fVar = (f) bVar.v(f.class);
        if (fVar == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Input failed. jsRuntime not support subContext");
        } else if (fVar.adS() == null) {
            x.e("MicroMsg.WAGameWeixinJSContextLogic", "Input failed. subContext has no main jscontext, you should to init it first.");
        } else {
            synchronized (this) {
                this.iXD = jVar;
                this.iXE = fVar;
                this.iXF = fVar.adS();
                this.iXC = true;
            }
        }
    }

    public final boolean adZ() {
        if (this.iXH == null) {
            boolean z;
            long Wq = bh.Wq();
            SharedPreferences cft = ac.cft();
            int i = cft != null ? cft.getInt("useisolatectxwxalibrary", 0) : 0;
            if (i == 1) {
                z = true;
            } else {
                if (i != -1) {
                    com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = a$b.gNk;
                    c fn = com.tencent.mm.ipcinvoker.wx_extension.a.a.fn("100378");
                    if (fn == null || !fn.isValid()) {
                        z = false;
                    } else if (bh.getInt((String) fn.chI().get("useisolatectxwxalibrary"), 0) == 1) {
                        z = true;
                    }
                }
                z = false;
            }
            this.iXH = Boolean.valueOf(z);
            x.i("MicroMsg.WAGameWeixinJSContextLogic", "read ShouldUseIsolateCtxWxaLibrary cost time = [%d]", Long.valueOf(bh.bA(Wq)));
        }
        return this.iXH.booleanValue();
    }
}
