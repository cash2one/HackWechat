package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class d extends e {
    public d(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int Hr() {
        return 1953;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineqrcodeusebindquery";
    }
}
