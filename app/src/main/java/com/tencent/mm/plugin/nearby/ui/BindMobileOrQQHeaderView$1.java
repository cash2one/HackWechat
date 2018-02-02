package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.a.f;
import com.tencent.mm.z.a.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class BindMobileOrQQHeaderView$1 implements OnClickListener {
    final /* synthetic */ BindMobileOrQQHeaderView oOk;

    BindMobileOrQQHeaderView$1(BindMobileOrQQHeaderView bindMobileOrQQHeaderView) {
        this.oOk = bindMobileOrQQHeaderView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.oOk.getContext(), BindMContactIntroUI.class);
        intent.putExtra("key_upload_scene", 7);
        MMWizardActivity.A(this.oOk.getContext(), intent);
        if (g.Ij().ie(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            g.Ij().ie(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).result = "1";
            f.ij(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
    }
}
