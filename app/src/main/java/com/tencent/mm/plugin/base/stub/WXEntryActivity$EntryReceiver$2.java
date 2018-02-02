package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver;
import com.tencent.mm.sdk.platformtools.x;

class WXEntryActivity$EntryReceiver$2 implements Runnable {
    final /* synthetic */ Intent kvq;
    final /* synthetic */ EntryReceiver kvr;
    final /* synthetic */ Context val$context;

    WXEntryActivity$EntryReceiver$2(EntryReceiver entryReceiver, Context context, Intent intent) {
        this.kvr = entryReceiver;
        this.val$context = context;
        this.kvq = intent;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        EntryReceiver.a(this.kvr, this.val$context, this.kvq);
        x.i("MicroMsg.WXEntryActivity", "cost:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
    }
}
