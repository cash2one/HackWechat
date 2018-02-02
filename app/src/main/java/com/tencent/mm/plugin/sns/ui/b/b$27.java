package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ui.ak;

class b$27 implements e {
    final /* synthetic */ b rPY;

    b$27(b bVar) {
        this.rPY = bVar;
    }

    public final void d(b bVar, int i) {
        if (bVar != null && i == 0) {
            View view = bVar.qtv != null ? (View) bVar.qtv.get() : null;
            if (view != null && (view instanceof a)) {
                a aVar = (a) view;
                aVar.Ur();
                if (aVar.bsE() != null && (aVar.bsE() instanceof ak)) {
                    aVar.bsE();
                }
            }
        }
    }
}
