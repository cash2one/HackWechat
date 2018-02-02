package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements b {
    final /* synthetic */ Bitmap qhx;
    final /* synthetic */ f vjS;

    f$1(f fVar, Bitmap bitmap) {
        this.vjS = fVar;
        this.qhx = bitmap;
    }

    public final int ba(int i, int i2) {
        f.a(this.vjS).JD();
        x.i("MicroMsg.GetHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            n.Jz();
            Bitmap je = d.je(f.b(this.vjS));
            if (je != null) {
                f fVar = this.vjS;
                n.Jz();
                f.a(fVar, je, d.x(f.b(this.vjS), true));
            } else {
                f.a(this.vjS, this.qhx, null);
            }
            if (f.c(this.vjS) != null) {
                f.c(this.vjS);
                f.b(this.vjS);
            }
        } else {
            f.a(this.vjS, this.qhx, null);
            if (f.c(this.vjS) != null) {
                f.c(this.vjS);
                f.b(this.vjS);
            }
        }
        return 0;
    }
}
