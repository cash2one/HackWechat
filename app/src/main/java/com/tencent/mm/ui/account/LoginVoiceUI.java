package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class LoginVoiceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xOO) {
            this.jge = 1;
            this.tYh.setVisibility(0);
            this.xOt.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.xOs.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.leftMargin = 0;
            this.xOs.setLayoutParams(layoutParams);
            findViewById(R.h.cWk).setEnabled(false);
            ((TextView) findViewById(R.h.cWp)).setTextColor(getResources().getColorStateList(R.e.bul));
            ((TextView) findViewById(R.h.cWp)).setBackgroundResource(getResources().getColor(R.e.transparent));
            this.xOt.setOnClickListener(new 1(this));
        }
    }

    public final boolean cnR() {
        return false;
    }

    protected final void afF() {
        int i = -1;
        super.afF();
        cnN();
        k vVar = new v(this.xOI, this.sgP, "", 0);
        vVar.mw(this.sgP);
        String str = "MicroMsg.LoginVoiceUI";
        String str2 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.sgP == null ? -1 : this.sgP.length());
        objArr[1] = bh.VT(this.sgP);
        if (this.xOA.xPo != null) {
            i = this.xOA.xPo.length();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bh.VT(this.xOA.xPo);
        x.d(str, str2, objArr);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.etF), true, new 2(this, vVar));
        ar.CG().a(vVar, 0);
    }
}
