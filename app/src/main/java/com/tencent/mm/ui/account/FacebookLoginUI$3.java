package com.tencent.mm.ui.account;

import android.content.Intent;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FacebookLoginUI$3 implements Runnable {
    final /* synthetic */ FacebookLoginUI xOf;

    FacebookLoginUI$3(FacebookLoginUI facebookLoginUI) {
        this.xOf = facebookLoginUI;
    }

    public final void run() {
        ar.Hg();
        Intent at;
        if ((bh.a((Integer) c.CU().get(65833, null), 0) > 0 ? 1 : 0) != 0) {
            at = a.ifs.at(this.xOf);
            at.addFlags(67108864);
            Intent intent = new Intent(this.xOf.mController.xIM, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 1);
            MMWizardActivity.b(this.xOf, intent, at);
        } else {
            at = a.ifs.at(this.xOf);
            at.addFlags(67108864);
            this.xOf.startActivity(at);
            b.oI(ar.CB() + "," + this.xOf.getClass().getName() + ",L14," + ar.fH("L14") + ",4");
        }
        this.xOf.finish();
    }
}
