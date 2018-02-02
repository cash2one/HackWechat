package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.plugin.game.d.e.a;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements g {
    final /* synthetic */ ImageView jlT;
    final /* synthetic */ e nxj;
    final /* synthetic */ b nxk;
    final /* synthetic */ a nxl;

    e$2(e eVar, b bVar, a aVar, ImageView imageView) {
        this.nxj = eVar;
        this.nxk = bVar;
        this.nxl = aVar;
        this.jlT = imageView;
    }

    public final void lC(String str) {
        x.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: " + str);
    }

    public final Bitmap a(String str, com.tencent.mm.aq.a.d.b bVar) {
        return null;
    }

    public final void a(String str, View view, com.tencent.mm.aq.a.d.b bVar) {
        x.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: " + str);
        if (bVar != null && bVar.bitmap != null) {
            Bitmap bitmap = bVar.bitmap;
            if (this.nxl.nxt) {
                bitmap = e.x(bitmap);
            }
            if (this.nxl.nxx != 0) {
                bitmap = d.a(bitmap, true, (float) this.nxl.nxx);
            }
            if (this.nxl.hDy) {
                e.b(this.nxj).l(str, bitmap);
            }
            ag.y(new 1(this, bitmap));
            if (this.nxk != null) {
                this.nxk.a(view, bitmap);
            }
        }
    }
}
