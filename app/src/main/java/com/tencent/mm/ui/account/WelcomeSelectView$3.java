package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bh;

class WelcomeSelectView$3 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ WelcomeSelectView xST;

    WelcomeSelectView$3(WelcomeSelectView welcomeSelectView, Context context) {
        this.xST = welcomeSelectView;
        this.val$context = context;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (d.vAC) {
            String string = this.val$context.getString(R.l.dXK, new Object[]{"0x" + Integer.toHexString(d.vAz), w.cfi()});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
            a.ifs.j(intent, this.val$context);
            return;
        }
        String str;
        if (bh.HO().HP() <= 0) {
            z = false;
        }
        Intent intent2;
        if (z) {
            intent2 = new Intent(this.val$context, RegByMobileRegAIOUI.class);
            intent2.putExtra("login_type", 0);
            this.val$context.startActivity(intent2);
            str = "RE200_100";
        } else {
            intent2 = new Intent(this.val$context, MobileInputUI.class);
            intent2.putExtra("mobile_input_purpose", 2);
            this.val$context.startActivity(intent2);
            str = "R200_100";
        }
        bh.HO();
        b.jd(20);
        b.oH(str);
        b.b(false, ar.CB() + "," + getClass().getName() + ",R100_100_new," + ar.fH("R100_100_new") + ",2");
        b.oG("R100_100_new");
    }
}
