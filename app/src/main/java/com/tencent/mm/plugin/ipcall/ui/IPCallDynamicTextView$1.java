package com.tencent.mm.plugin.ipcall.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;

class IPCallDynamicTextView$1 extends af {
    final /* synthetic */ IPCallDynamicTextView nJU;

    IPCallDynamicTextView$1(IPCallDynamicTextView iPCallDynamicTextView) {
        this.nJU = iPCallDynamicTextView;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if ((IPCallDynamicTextView.a(this.nJU) <= 0.0d || IPCallDynamicTextView.b(this.nJU) >= IPCallDynamicTextView.c(this.nJU)) && (IPCallDynamicTextView.a(this.nJU) >= 0.0d || IPCallDynamicTextView.b(this.nJU) <= IPCallDynamicTextView.c(this.nJU))) {
                    IPCallDynamicTextView.a(this.nJU, false);
                    IPCallDynamicTextView.a(this.nJU, IPCallDynamicTextView.c(this.nJU));
                    return;
                }
                IPCallDynamicTextView.a(this.nJU, true);
                IPCallDynamicTextView.a(this.nJU, IPCallDynamicTextView.b(this.nJU));
                IPCallDynamicTextView.b(this.nJU, IPCallDynamicTextView.b(this.nJU) + IPCallDynamicTextView.a(this.nJU));
                IPCallDynamicTextView.e(this.nJU).sendEmptyMessageDelayed(1, (long) IPCallDynamicTextView.d(this.nJU));
                return;
            default:
                return;
        }
    }
}
