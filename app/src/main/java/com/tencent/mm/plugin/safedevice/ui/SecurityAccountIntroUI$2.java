package com.tencent.mm.plugin.safedevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;

class SecurityAccountIntroUI$2 implements OnClickListener {
    final /* synthetic */ SecurityAccountIntroUI pRR;

    SecurityAccountIntroUI$2(SecurityAccountIntroUI securityAccountIntroUI) {
        this.pRR = securityAccountIntroUI;
    }

    public final void onClick(View view) {
        String d = w.d(this.pRR.getSharedPreferences(ac.cfs(), 0));
        Intent intent = new Intent();
        if (bh.ov(SecurityAccountIntroUI.d(this.pRR))) {
            intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
        } else {
            intent.putExtra("rawUrl", SecurityAccountIntroUI.d(this.pRR));
        }
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("title", this.pRR.getString(R.l.eGU));
        intent.putExtra("show_bottom", false);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        a.ifs.j(intent, this.pRR);
    }
}
