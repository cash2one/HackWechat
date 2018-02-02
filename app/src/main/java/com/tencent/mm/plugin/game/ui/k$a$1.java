package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class k$a$1 implements a {
    final /* synthetic */ String fgU;
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ float npR;

    k$a$1(String str, float f, ImageView imageView) {
        this.fgU = str;
        this.npR = f;
        this.lOQ = imageView;
    }

    public final void a(String str, l lVar) {
        if (this.fgU.equals(str)) {
            Bitmap b = g.b(this.fgU, 1, this.npR);
            if (b != null) {
                this.lOQ.setImageBitmap(b);
                an.bin().j(this);
            }
        }
    }
}
