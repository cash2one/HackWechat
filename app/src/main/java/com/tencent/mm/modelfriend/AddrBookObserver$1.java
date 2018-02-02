package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

class AddrBookObserver$1 extends af {
    AddrBookObserver$1(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        Context context = (Context) message.obj;
        if (AddrBookObserver.Nl() == null) {
            AddrBookObserver.n(new Intent());
            AddrBookObserver.Nl().setClass(context, AddrBookService.class);
        }
        AddrBookObserver.Nl().putExtra(AddrBookService.huV, new Random(System.currentTimeMillis()).nextFloat());
        try {
            x.i("MicroMsg.AddrBookObserver", "time's up, start AddrBookObserver, session:%f", new Object[]{Float.valueOf(new Random(System.currentTimeMillis()).nextFloat())});
            context.startService(AddrBookObserver.Nl());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrBookObserver", e, "startService failed", new Object[0]);
        }
    }
}
