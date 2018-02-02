package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.plugin.game.d.e.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class e$4 extends b {
    final /* synthetic */ int aEe;
    final /* synthetic */ int aEf;
    final /* synthetic */ e nxj;
    final /* synthetic */ b nxq;
    final /* synthetic */ int nxr = 0;
    final /* synthetic */ String val$url;

    e$4(e eVar, b bVar, int i, int i2, int i3, String str) {
        this.nxj = eVar;
        this.nxq = bVar;
        this.aEe = i;
        this.aEf = i2;
        this.val$url = str;
    }

    public final void a(View view, Bitmap bitmap) {
        x.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap a = e.a(bitmap, this.aEe, this.aEf);
            x.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
            if (this.nxr != 0) {
                a = d.a(a, true, (float) this.nxr);
            }
            e.b(this.nxj).l(this.val$url, a);
            if (this.nxq != null) {
                this.nxq.a(view, a);
            }
        }
    }
}
