package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.w;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI zgi = null;

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        accountDeletedAlphaAlertUI.finish();
        d.br(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.mController.xIM, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.mController.xIM.startActivity(intent);
    }

    public static AccountDeletedAlphaAlertUI cxu() {
        return zgi;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zgi = this;
        com.tencent.mm.sdk.b.a.xef.m(new w());
        ar.hold();
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(getIntent().getStringExtra("errmsg"));
        if (eA != null) {
            eA.a(this, new 1(this), null);
        } else {
            h.a(this, getString(R.l.eut), null, false, new 2(this));
        }
    }

    public void onDestroy() {
        if (equals(zgi)) {
            zgi = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
