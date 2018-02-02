package com.tencent.mm.lib.riskscanner;

import android.os.Bundle;
import com.tencent.c.a.c.a;

class RiskScannerReqBufferProvider$1 implements a {
    final /* synthetic */ Bundle[] gUq;
    final /* synthetic */ RiskScannerReqBufferProvider gUr;

    RiskScannerReqBufferProvider$1(RiskScannerReqBufferProvider riskScannerReqBufferProvider, Bundle[] bundleArr) {
        this.gUr = riskScannerReqBufferProvider;
        this.gUq = bundleArr;
    }

    public final void e(int i, byte[] bArr) {
        a.gI(i);
        Bundle[] bundleArr = this.gUq;
        Bundle bundle = new Bundle();
        bundleArr[0] = bundle;
        if (i == 0 && bArr != null) {
            bundle.putInt("errCode", i);
            bundle.putByteArray("reqBufferBase64", bArr);
        }
    }
}
