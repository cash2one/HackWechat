package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.az.b;

class j$1 implements b {
    final /* synthetic */ Context val$context;
    final /* synthetic */ j zaR;

    j$1(j jVar, Context context) {
        this.zaR = jVar;
        this.val$context = context;
    }

    public final void Hv() {
        this.zaR.zaQ.post(new Runnable(this) {
            final /* synthetic */ j$1 zaS;

            {
                this.zaS = r1;
            }

            public final void run() {
                if (this.zaS.zaR.zaQ != null) {
                    this.zaS.zaR.zaQ.setVisibility(8);
                    this.zaS.zaR.zaQ.removeAllViews();
                }
                a a = e.a(this.zaS.val$context, e.a.zaC, null);
                if (a == null) {
                    a = e.a(this.zaS.val$context, e.a.zaw, null);
                }
                if (a != null && a.getView() != null) {
                    x.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[]{a, a.getView()});
                    this.zaS.zaR.zaQ.setVisibility(0);
                    this.zaS.zaR.zaQ.addView(a.getView(), new LayoutParams(-1, -2));
                }
            }
        });
    }
}
