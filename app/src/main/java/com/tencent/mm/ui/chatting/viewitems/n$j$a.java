package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.aq.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public class n$j$a implements g {
    private int yLm;
    private int yLn;
    private int yLo;
    n$j$c yLp;

    public n$j$a() {
        this(0, 0, 0, null);
    }

    public n$j$a(int i, int i2, int i3, n$j$c com_tencent_mm_ui_chatting_viewitems_n_j_c) {
        this.yLm = i;
        this.yLn = i2;
        this.yLo = i3;
        this.yLp = com_tencent_mm_ui_chatting_viewitems_n_j_c;
    }

    public final void lC(String str) {
        x.d("MicroMsg.ChattingItemBizFrom", "onImageLoadStart, url: %s", new Object[]{str});
        com.tencent.mm.plugin.report.service.g.pQN.a(86, 0, 1, false);
    }

    public final Bitmap a(String str, b bVar) {
        if (this.yLm == 0) {
            return null;
        }
        if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
            x.w("MicroMsg.ChattingItemBizFrom", "onProcessBitmap bitmap is null");
            return null;
        } else if (t.ov(str)) {
            x.w("MicroMsg.ChattingItemBizFrom", "onProcessBitmap url is null");
            return null;
        } else {
            try {
                Bitmap a = d.a(bVar.bitmap, this.yLn, this.yLo, true);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.yLn, this.yLo, true);
                if (!(createScaledBitmap == a || a == null || a.isRecycled())) {
                    a.recycle();
                }
                a = d.b(createScaledBitmap, this.yLm);
                if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                    createScaledBitmap.recycle();
                }
                return a;
            } catch (OutOfMemoryError e) {
                x.w("MicroMsg.ChattingItemBizFrom", "onProcessBitmap OutOfMemoryError %s", new Object[]{e.getMessage()});
                return null;
            }
        }
    }

    public final void a(String str, View view, b bVar) {
        if (!(this.yLp == null || bVar.bitmap == null || bVar.bitmap.isRecycled())) {
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ n$j$a yLq;

                {
                    this.yLq = r1;
                }

                public final void run() {
                    this.yLq.yLp.onFinish();
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
            } else {
                ag.y(anonymousClass1);
            }
        }
        if (bVar.fqe == 2) {
            boolean z;
            x.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, url:%s, contentType: %s", new Object[]{str, bVar.aBD});
            if (q.PE() && !bh.ov(bVar.aBD) && q.lx(str) && bVar.aBD.equals("image/webp")) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, isDownloadWebp: %b, status: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(bVar.status)});
            switch (bVar.status) {
                case 0:
                    if (z) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(86, 13, 1, false);
                        return;
                    }
                    return;
                case 1:
                    com.tencent.mm.plugin.report.service.g.pQN.a(86, 2, 1, false);
                    if (z) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(86, 15, 1, false);
                        return;
                    }
                    return;
                case 3:
                    if (z) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(86, 14, 1, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
