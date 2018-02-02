package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d;

public class d$b implements a {
    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            x.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
            d.reset(context);
            ag.h(new 1(this), 5000);
        }
    }
}
