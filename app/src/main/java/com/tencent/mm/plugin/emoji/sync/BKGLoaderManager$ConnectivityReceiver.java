package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

final class BKGLoaderManager$ConnectivityReceiver extends BroadcastReceiver {
    final /* synthetic */ BKGLoaderManager lzX;

    public BKGLoaderManager$ConnectivityReceiver(BKGLoaderManager bKGLoaderManager) {
        this.lzX = bKGLoaderManager;
    }

    public final void onReceive(Context context, Intent intent) {
        int netType = an.getNetType(context);
        if (this.lzX.mNetWorkType != netType) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[]{Integer.valueOf(netType)});
            if (BKGLoaderManager.aAP()) {
                this.lzX.aCa();
            } else if (BKGLoaderManager.aCc()) {
                this.lzX.aBZ();
            } else if (an.isConnected(ac.getContext())) {
                this.lzX.aCb();
            } else {
                this.lzX.aCa();
            }
            this.lzX.mNetWorkType = netType;
        }
    }
}
