package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements a {
    final /* synthetic */ f mUF;
    final /* synthetic */ f.a mUJ;

    f$2(f fVar, f.a aVar) {
        this.mUF = fVar;
        this.mUJ = aVar;
    }

    public final void aOn() {
        x.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", Integer.valueOf(this.mUJ.mRY.getWidth()), Integer.valueOf(this.mUJ.mRY.getHeight()));
    }
}
