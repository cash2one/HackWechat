package com.tencent.mm.plugin.safedevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.ar;

class SecurityAccountVerifyUI$4 implements OnClickListener {
    final /* synthetic */ SecurityAccountVerifyUI pRZ;

    SecurityAccountVerifyUI$4(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.pRZ = securityAccountVerifyUI;
    }

    public final void onClick(View view) {
        b.oI(ar.CB() + "," + getClass().getName() + ",L600_300," + ar.fH("L600_300") + ",1");
        String d = w.d(this.pRZ.getSharedPreferences(ac.cfs(), 0));
        Intent intent = new Intent();
        intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("title", this.pRZ.getString(R.l.eGU));
        intent.putExtra("show_bottom", false);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
        a.ifs.j(intent, this.pRZ);
    }
}
