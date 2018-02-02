package com.tencent.mm.plugin.voip_cs.b.a;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;

class b$4 extends af {
    final /* synthetic */ b sxB;

    b$4(b bVar) {
        this.sxB = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 12:
                if (this.sxB.sxA != null) {
                    b.g(this.sxB).setImageDrawable(this.sxB.sxA);
                    return;
                } else {
                    b.g(this.sxB).setImageResource(R.g.bBB);
                    return;
                }
            default:
                return;
        }
    }
}
