package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sight.draft.ui.b.e;
import com.tencent.mm.sdk.platformtools.bh;

class b$1 extends c {
    final /* synthetic */ b qvI;

    b$1(b bVar) {
        this.qvI = bVar;
    }

    public final void r(String str, Bitmap bitmap) {
        for (e eVar : b.a(this.qvI)) {
            if (eVar.qvP != null && bh.az(str, "").equals(eVar.qvP.field_fileName)) {
                eVar.qvN.B(bitmap);
                return;
            }
        }
    }
}
