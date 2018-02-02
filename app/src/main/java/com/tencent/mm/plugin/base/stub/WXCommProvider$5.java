package com.tencent.mm.plugin.base.stub;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$5 extends bc<Integer> {
    final /* synthetic */ WXCommProvider kvd;
    final /* synthetic */ Uri kvf;
    final /* synthetic */ int kvg;
    final /* synthetic */ String[] kvh;

    WXCommProvider$5(WXCommProvider wXCommProvider, Integer num, Uri uri, int i, String[] strArr) {
        this.kvd = wXCommProvider;
        this.kvf = uri;
        this.kvg = i;
        this.kvh = strArr;
        super(2000, num);
    }

    protected final /* synthetic */ Object run() {
        x.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", new Object[]{this.kvf.toString(), Integer.valueOf(this.kvg)});
        if (this.kvg != 1) {
            x.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", new Object[]{Integer.valueOf(this.kvg)});
            return null;
        }
        int i = 0;
        for (String str : this.kvh) {
            if (!bh.ov(str)) {
                int i2 = (WXCommProvider.a(this.kvd).contains(str) && WXCommProvider.a(this.kvd).edit().remove(str).commit()) ? 1 : 0;
                if (i2 != 0) {
                    i++;
                }
            }
        }
        x.d("MicroMsg.WXCommProvider", "delete result = %d", new Object[]{Integer.valueOf(i)});
        return Integer.valueOf(i);
    }
}
