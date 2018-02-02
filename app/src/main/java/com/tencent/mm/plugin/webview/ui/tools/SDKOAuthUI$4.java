package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class SDKOAuthUI$4 implements OnCancelListener {
    final /* synthetic */ SDKOAuthUI txf;

    SDKOAuthUI$4(SDKOAuthUI sDKOAuthUI) {
        this.txf = sDKOAuthUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            dialogInterface.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
        }
    }
}
