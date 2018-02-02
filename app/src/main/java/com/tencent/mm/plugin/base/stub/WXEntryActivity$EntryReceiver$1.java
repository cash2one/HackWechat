package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver;

class WXEntryActivity$EntryReceiver$1 implements g {
    final /* synthetic */ Intent kvq;
    final /* synthetic */ EntryReceiver kvr;
    final /* synthetic */ Context val$context;

    WXEntryActivity$EntryReceiver$1(EntryReceiver entryReceiver, Context context, Intent intent) {
        this.kvr = entryReceiver;
        this.val$context = context;
        this.kvq = intent;
    }

    public final void ul() {
        com.tencent.mm.kernel.g.Dk().b((g) this);
        EntryReceiver.a(this.kvr, this.val$context, this.kvq);
    }

    public final void aG(boolean z) {
    }
}
