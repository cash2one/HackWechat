package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ay.r;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;

public final class d implements c, h {
    r ooA;
    bd ooB;
    ai ooC;
    ad oow;
    bg oox;
    av ooy;
    af ooz;

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.d EX() {
        g.Dk();
        g.Dh().Ct();
        return this.ooA;
    }

    public final /* synthetic */ ar EY() {
        g.Dk();
        g.Dh().Ct();
        return this.oow;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.g EZ() {
        g.Dk();
        g.Dh().Ct();
        return this.oox;
    }

    public final /* synthetic */ b FJ() {
        g.Dk();
        g.Dh().Ct();
        return this.ooC;
    }

    public final /* synthetic */ as Fd() {
        g.Dk();
        g.Dh().Ct();
        return this.ooz;
    }

    public final /* synthetic */ f Fg() {
        g.Dk();
        g.Dh().Ct();
        return this.ooB;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.c aZi() {
        g.Dk();
        g.Dh().Ct();
        return this.ooy;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        if (this.oow != null) {
            ad adVar = this.oow;
            adVar.xxZ.clear();
            adVar.xya.clear();
        }
        if (this.ooA != null) {
            com.tencent.mm.ae.e eVar = this.ooA;
            g.Dk();
            g.Di().gPJ.b(681, eVar);
        }
    }
}
