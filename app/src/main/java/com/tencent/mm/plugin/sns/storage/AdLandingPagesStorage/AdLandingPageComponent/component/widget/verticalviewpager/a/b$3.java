package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ String gBF;
    final /* synthetic */ String jqI;
    final /* synthetic */ b rnf;
    final /* synthetic */ String rng;

    b$3(b bVar, String str, String str2, String str3) {
        this.rnf = bVar;
        this.gBF = str;
        this.rng = str2;
        this.jqI = str3;
    }

    public final void run() {
        float f = 1.0f;
        Bitmap bitmap = null;
        x.i("ContentFragment", "download bg ok path %s ", this.gBF);
        try {
            if (b.d(this.rnf).rnO) {
                b.e(this.rnf);
                String ei = d.ei(this.rng, this.jqI + "_blurimg");
                if (FileOp.bO(ei)) {
                    bitmap = BitmapFactory.decodeFile(ei);
                } else {
                    Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(this.gBF, null);
                    if (decodeFile != null) {
                        n a;
                        if (decodeFile.getHeight() < b.f(this.rnf) || decodeFile.getWidth() < b.g(this.rnf)) {
                            f = Math.max((((float) b.g(this.rnf)) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) b.f(this.rnf))) / ((float) decodeFile.getHeight()));
                        }
                        Bitmap a2 = com.tencent.mm.sdk.platformtools.d.a(decodeFile, f, f);
                        try {
                            a2 = Bitmap.createBitmap(a2, (a2.getWidth() - b.g(this.rnf)) >>> 1, (a2.getHeight() - b.f(this.rnf)) >>> 1, b.g(this.rnf), b.f(this.rnf));
                        } catch (Throwable e) {
                            x.printErrStackTrace("ContentFragment", e, "", new Object[0]);
                            a2 = null;
                        }
                        if (a2 != null) {
                            a = a.a(a2, ei, Color.argb(b.CTRL_INDEX, 0, 0, 0), 180);
                        } else {
                            a = null;
                        }
                        if (a != null) {
                            bitmap = a.ED();
                        }
                    }
                }
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.d.decodeFile(this.gBF, null);
            }
            ag.y(new Runnable(this) {
                final /* synthetic */ b$3 rni;

                public final void run() {
                    if (bitmap == null) {
                        x.i("ContentFragment", "decode img fail, set bg color %s", this.rni.jqI);
                        b.h(this.rni.rnf);
                        return;
                    }
                    x.i("ContentFragment", "set bg with bitmap");
                    b.i(this.rni.rnf).put(this.rni.jqI, bitmap);
                    b.a(this.rni.rnf, bitmap);
                }
            });
        } catch (Exception e2) {
            x.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e2.toString());
        }
    }
}
