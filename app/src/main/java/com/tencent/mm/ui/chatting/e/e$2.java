package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.gallery.d;
import java.util.List;

class e$2 implements Runnable {
    final /* synthetic */ List juo;
    final /* synthetic */ e yHA;

    e$2(e eVar, List list) {
        this.yHA = eVar;
        this.juo = list;
    }

    public final void run() {
        int b = e.b(this.yHA, this.juo);
        if (this.juo.size() == b) {
            e.d(this.yHA).post(new Runnable(this) {
                final /* synthetic */ e$2 yHB;

                {
                    this.yHB = r1;
                }

                public final void run() {
                    e.c(this.yHB.yHA).FI(R.l.elC);
                }
            });
            return;
        }
        e.a(this.yHA, b > 0);
        List<au> c = e.c(this.yHA, this.juo);
        List<au> d = e.d(this.yHA, this.juo);
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", Integer.valueOf(c.size()), Integer.valueOf(d.size()));
        e.a(this.yHA, c.size() + d.size());
        if (an.isWifi(ac.getContext()) || e.e(this.yHA) != this.juo.size()) {
            for (au auVar : c) {
                e.a(this.yHA, auVar, d.bl(auVar));
            }
            for (au auVar2 : d) {
                e.a(this.yHA, auVar2);
            }
            if (e.f(this.yHA) && e.e(this.yHA) == 0) {
                e.d(this.yHA).post(new 3(this));
            }
            if (e.g(this.yHA) && !e.f(this.yHA)) {
                e.d(this.yHA).post(new Runnable(this) {
                    final /* synthetic */ e$2 yHB;

                    {
                        this.yHB = r1;
                    }

                    public final void run() {
                        if (e.c(this.yHB.yHA) != null) {
                            e.c(this.yHB.yHA).cun();
                        }
                    }
                });
                return;
            }
            return;
        }
        e.d(this.yHA).post(new 2(this));
    }
}
