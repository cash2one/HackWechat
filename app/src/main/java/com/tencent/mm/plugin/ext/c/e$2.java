package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.sdk.platformtools.bc;

class e$2 extends bc<Boolean> {
    final /* synthetic */ e mbp;
    final /* synthetic */ int mbr;
    final /* synthetic */ int mbs;
    final /* synthetic */ String val$url;

    public e$2(e eVar, Boolean bool, String str, int i, int i2) {
        this.mbp = eVar;
        this.val$url = str;
        this.mbr = i;
        this.mbs = i2;
        super(5000, bool, true);
    }

    protected final /* synthetic */ Object run() {
        return ajr();
    }

    private Boolean ajr() {
        g.Di().gPJ.a(782, new 1(this));
        g.Di().gPJ.a(new a(this.val$url, this.mbr, this.mbs), 0);
        return Boolean.valueOf(true);
    }
}
