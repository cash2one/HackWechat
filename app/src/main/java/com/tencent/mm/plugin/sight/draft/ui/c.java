package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;

public abstract class c {
    f<String, Bitmap> qvV = new f(24);
    private Bitmap qvW;

    public abstract void r(String str, Bitmap bitmap);

    public final Bitmap n(String str, String str2, boolean z) {
        if (bh.ov(str)) {
            return btp();
        }
        Bitmap bitmap = (Bitmap) this.qvV.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Object aVar = new a((byte) 0);
        aVar.aAM = str;
        aVar.path = str2;
        aVar.qvX = z;
        aVar.qvY = new WeakReference(this);
        if (z) {
            ar.Dm().F(aVar);
        } else {
            aVar.run();
            bitmap = (Bitmap) this.qvV.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return btp();
    }

    private Bitmap btp() {
        if (this.qvW == null) {
            this.qvW = d.CZ(R.k.dAd);
        }
        return this.qvW;
    }
}
