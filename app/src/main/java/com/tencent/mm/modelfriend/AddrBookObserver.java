package com.tencent.mm.modelfriend;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class AddrBookObserver extends ContentObserver {
    private static af handler = new 1(Looper.getMainLooper());
    private static boolean huT = false;
    private static Intent huU;
    private final Context context;

    public AddrBookObserver(Context context) {
        super(af.fetchFreeHandler());
        this.context = context;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        x.i("MicroMsg.AddrBookObserver", "address book changed, start sync after 20 second");
        if (huT) {
            x.e("MicroMsg.AddrBookObserver", "isSyncing:" + huT + ", is time to sync:true , return");
            return;
        }
        handler.removeMessages(0);
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = this.context;
        obtainMessage.what = 0;
        handler.sendMessageDelayed(obtainMessage, 20000);
    }
}
