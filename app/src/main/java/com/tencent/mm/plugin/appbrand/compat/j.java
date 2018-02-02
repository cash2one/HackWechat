package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.q;
import com.tencent.mm.plugin.appbrand.compat.a.b.r;
import com.tencent.tencentmap.mapsdk.map.f;

final class j implements q {
    final f iMp;

    j(f fVar) {
        this.iMp = fVar;
    }

    public final r abF() {
        return new l(this.iMp.cGo());
    }

    public final double a(b.f fVar, b.f fVar2) {
        return a.a(f.a(fVar), f.a(fVar2));
    }
}
