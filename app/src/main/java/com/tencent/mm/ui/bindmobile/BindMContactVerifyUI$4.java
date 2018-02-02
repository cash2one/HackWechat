package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.c.a;

class BindMContactVerifyUI$4 implements OnClickListener {
    final /* synthetic */ BindMContactVerifyUI ylV;

    BindMContactVerifyUI$4(BindMContactVerifyUI bindMContactVerifyUI) {
        this.ylV = bindMContactVerifyUI;
    }

    public final void onClick(View view) {
        this.ylV.aWs();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("bindmcontact_mobile", BindMContactVerifyUI.c(this.ylV));
        bundle.putInt("voice_verify_type", 4);
        intent.putExtras(bundle);
        a.ifs.f(this.ylV, intent);
    }
}
