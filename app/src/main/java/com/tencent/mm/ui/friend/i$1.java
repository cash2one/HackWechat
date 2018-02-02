package com.tencent.mm.ui.friend;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class i$1 extends af {
    final /* synthetic */ i zdK;

    i$1(i iVar) {
        this.zdK = iVar;
    }

    public final void handleMessage(Message message) {
        if ((i.a(this.zdK) == null || i.a(this.zdK).isShowing()) && !i.b(this.zdK)) {
            i.a(this.zdK, i.c(this.zdK) + 1);
            i.d(this.zdK).setProgress(i.c(this.zdK));
            if (i.c(this.zdK) < i.d(this.zdK).getMax() - 2) {
                sendEmptyMessageDelayed(0, 1000);
                return;
            }
            i.e(this.zdK);
            i.d(this.zdK).setIndeterminate(true);
            if (!i.f(this.zdK)) {
                if (i.a(this.zdK) != null) {
                    i.a(this.zdK).dismiss();
                }
                i.g(this.zdK);
            }
        }
    }
}
