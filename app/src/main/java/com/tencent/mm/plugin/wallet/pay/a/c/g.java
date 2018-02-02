package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class g extends e {
    public g(PayInfo payInfo, int i) {
        super(payInfo, i);
    }

    public final int Hr() {
        return 1688;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_tf_qrcodeusebindquery";
    }
}
