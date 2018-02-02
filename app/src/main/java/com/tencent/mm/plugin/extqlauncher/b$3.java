package com.tencent.mm.plugin.extqlauncher;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$3 extends af {
    final /* synthetic */ b mck;

    b$3(b bVar, Looper looper) {
        this.mck = bVar;
        super(looper);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public final void handleMessage(Message message) {
        if (ac.getContext() == null || !ar.Hj()) {
            x.w("MicroMsg.SubCoreExtQLauncher", "wrong status");
        } else if (b.a(this.mck)) {
            int aGc = b.aGc();
            if (aGc > 0 || aGc < this.mck.mci) {
                x.d("MicroMsg.SubCoreExtQLauncher", "notify unread");
                Intent intent = new Intent("com.tencent.mm.ext.ACTION_EXT_NOTIFY");
                intent.putExtra("EXTRA_EXT_NOTIFY_TYPE", "NEW_UNREAD");
                ac.getContext().sendBroadcast(intent);
                this.mck.mci = aGc;
            }
        }
    }
}
