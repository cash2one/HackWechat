package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$j implements h {
    final String aAM;
    private final WeakReference<ImageView> hkd;
    private final b hke;
    boolean hkf;

    final ImageView Jr() {
        return (ImageView) this.hkd.get();
    }

    private b$j(ImageView imageView, b bVar) {
        this.hkf = false;
        this.hkd = new WeakReference(imageView);
        this.hke = bVar;
        this.aAM = "ImageView#" + imageView.hashCode();
    }

    private void Js() {
        if (this.hkd.get() != null) {
            b.c(this.hke).remove(Integer.valueOf(((ImageView) this.hkd.get()).hashCode()));
        }
    }

    public void Jm() {
    }

    public final void j(Bitmap bitmap) {
        Js();
        ImageView imageView = (ImageView) this.hkd.get();
        if (imageView != null) {
            if (!ag.isMainThread()) {
                x.j("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
            }
            imageView.setImageDrawable(new e(imageView.getResources(), bitmap));
        }
        this.hkf = true;
    }

    public final void Jn() {
        Js();
    }

    public final String Jo() {
        return this.aAM;
    }
}
