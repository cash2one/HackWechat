package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.lang.ref.WeakReference;

class e$5 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ float npR;
    final /* synthetic */ e nxj;
    final /* synthetic */ WeakReference nxs;

    e$5(e eVar, String str, float f, WeakReference weakReference) {
        this.nxj = eVar;
        this.fgU = str;
        this.npR = f;
        this.nxs = weakReference;
    }

    public final void a(String str, l lVar) {
        if (this.fgU.equals(str)) {
            Bitmap b = g.b(this.fgU, 1, this.npR);
            if (b != null) {
                if (!(this.nxs == null || this.nxs.get() == null)) {
                    ((ImageView) this.nxs.get()).setImageBitmap(b);
                }
                e.a(this.nxj).put(this.fgU, b);
                an.bin().j(this);
            }
        }
    }
}
