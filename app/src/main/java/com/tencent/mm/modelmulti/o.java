package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.storage.au;

public final class o implements com.tencent.mm.plugin.messenger.foundation.a.o {
    private final a hGo = new a();
    private f hGp;

    private static final class a extends com.tencent.mm.cd.a<k> implements k {
        private a() {
        }

        public final void a(ara com_tencent_mm_protocal_c_ara, au auVar) {
            a(new 1(this, com_tencent_mm_protocal_c_ara, auVar));
        }
    }

    public final String s(au auVar) {
        if (this.hGp != null) {
            return this.hGp.s(auVar);
        }
        return null;
    }

    public final void a(k kVar) {
        this.hGo.aE(kVar);
    }

    public final void a(f fVar) {
        this.hGp = fVar;
    }

    public final k Qa() {
        return this.hGo;
    }
}
