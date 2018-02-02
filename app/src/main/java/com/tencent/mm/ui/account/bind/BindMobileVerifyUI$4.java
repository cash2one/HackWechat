package com.tencent.mm.ui.account.bind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class BindMobileVerifyUI$4 implements OnClickListener {
    final /* synthetic */ BindMobileVerifyUI xTG;

    BindMobileVerifyUI$4(BindMobileVerifyUI bindMobileVerifyUI) {
        this.xTG = bindMobileVerifyUI;
    }

    public final void onClick(View view) {
        this.xTG.aWs();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("bindmcontact_mobile", BindMobileVerifyUI.b(this.xTG));
        bundle.putInt("voice_verify_type", 4);
        intent.putExtras(bundle);
        a.ifs.f(this.xTG, intent);
    }
}
