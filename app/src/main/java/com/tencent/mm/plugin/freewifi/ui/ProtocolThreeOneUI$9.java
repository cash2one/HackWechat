package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ProtocolThreeOneUI$9 implements OnCancelListener {
    final /* synthetic */ ProtocolThreeOneUI mIQ;

    ProtocolThreeOneUI$9(ProtocolThreeOneUI protocolThreeOneUI) {
        this.mIQ = protocolThreeOneUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d.a(this.mIQ.ssid, 4, this.mIQ.getIntent());
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.D(this.mIQ.getIntent()), Integer.valueOf(m.E(this.mIQ.getIntent())), Integer.valueOf(4)});
    }
}
