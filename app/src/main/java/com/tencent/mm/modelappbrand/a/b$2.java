package com.tencent.mm.modelappbrand.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.a.b.j;

class b$2 extends j {
    final /* synthetic */ b hjV;
    final /* synthetic */ Drawable hjW;

    b$2(b bVar, ImageView imageView, b bVar2, Drawable drawable) {
        this.hjV = bVar;
        this.hjW = drawable;
        super(imageView, bVar2, (byte) 0);
    }

    public final void Jm() {
        if (Jr() != null && this.hjW != null) {
            Jr().setImageDrawable(this.hjW);
        }
    }
}
