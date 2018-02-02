package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.plugin.game.gamewebview.ui.d.34;
import com.tencent.mm.sdk.platformtools.x;

class d$34$1 implements OnClickListener {
    final /* synthetic */ Callback mZL;
    final /* synthetic */ String mZM;
    final /* synthetic */ 34 mZN;

    d$34$1(34 34, Callback callback, String str) {
        this.mZN = 34;
        this.mZL = callback;
        this.mZM = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.GameWebPageView", "onGeolocationPermissionsShowPrompt ok, origin = %s");
        this.mZL.invoke(this.mZM, true, true);
    }
}
