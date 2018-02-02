package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ab$2 implements d {
    final /* synthetic */ ab qVi;

    ab$2(ab abVar) {
        this.qVi = abVar;
    }

    public final boolean aZb() {
        x.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ab.a(this.qVi);
        return false;
    }
}
