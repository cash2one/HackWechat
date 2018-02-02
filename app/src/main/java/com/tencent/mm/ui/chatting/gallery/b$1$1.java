package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.gallery.b.1;

class b$1$1 implements a {
    final /* synthetic */ 1 yDg;

    b$1$1(1 1) {
        this.yDg = 1;
    }

    public final void ev(int i, int i2) {
        if (i == i2) {
            Bitmap oq;
            x.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[]{Long.valueOf(this.yDg.heR.field_msgId)});
            j.N(this.yDg.yDe.yGt, 8);
            try {
                oq = j.oq(this.yDg.jqK);
            } catch (OutOfMemoryError e) {
                x.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[]{this.yDg.jqK});
                Runtime.getRuntime().gc();
                Runtime.getRuntime().runFinalization();
                oq = j.op(this.yDg.jqK);
            }
            if (oq != null) {
                this.yDg.yDe.yGx.rCd = false;
                l.k(this.yDg.yDe.yGx, oq.getWidth(), oq.getHeight());
                this.yDg.yDe.yGx.eS(oq.getWidth(), oq.getHeight());
                this.yDg.yDe.yGx.setImageBitmap(oq);
                this.yDg.yDe.yGx.invalidate();
            }
        }
    }
}
