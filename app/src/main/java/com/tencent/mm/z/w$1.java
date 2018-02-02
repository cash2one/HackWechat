package com.tencent.mm.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.aq.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.w.c;

class w$1 extends af {
    final /* synthetic */ w hfC;

    w$1(w wVar, Looper looper) {
        this.hfC = wVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            if (this.hfC.hfB != null) {
                c cVar = (c) message.obj;
                if (cVar.hfG && q.PE()) {
                    String ly = q.ly(cVar.url);
                    x.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", new Object[]{ly, cVar.filename, cVar.url});
                    Bitmap UN = d.UN(cVar.filename);
                    if (UN == null) {
                        x.d("MicroMsg.GetPicService", "decode webp picture failed");
                        w.a(this.hfC, 14, 1);
                    } else if (!bh.ov(ly)) {
                        if (ly.toLowerCase().contains("png")) {
                            x.d("MicroMsg.GetPicService", "convert webp to png");
                            d.a(UN, 100, CompressFormat.PNG, cVar.filename, true);
                        } else {
                            x.d("MicroMsg.GetPicService", "convert webp to jpg");
                            d.a(UN, 100, CompressFormat.JPEG, cVar.filename, true);
                        }
                    }
                }
                int bN = e.bN(cVar.filename);
                if (bN > 0 && g.Dh().Cy()) {
                    a.hfM.aV(bN, 0);
                }
                ag.y(new 1(this, cVar));
            }
        } catch (Throwable e) {
            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bh.i(e)});
        }
    }
}
