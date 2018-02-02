package com.tencent.mm.plugin.nearlife.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class NearLifeCreatePoiUI$8 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$8(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(11138, new Object[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "0", NearLifeCreatePoiUI.b(this.oRe)});
        this.oRe.setResult(0, new Intent());
        this.oRe.finish();
    }
}
