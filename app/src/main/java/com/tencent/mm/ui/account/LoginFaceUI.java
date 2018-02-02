package com.tencent.mm.ui.account;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class LoginFaceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xOO) {
            this.jge = 4;
            this.xOM.setVisibility(0);
            this.xOu.setVisibility(0);
            findViewById(R.h.cfM).setEnabled(false);
            ((TextView) findViewById(R.h.cfN)).setTextColor(getResources().getColorStateList(R.e.bul));
            ((TextView) findViewById(R.h.cfN)).setBackgroundResource(getResources().getColor(R.e.transparent));
            this.xOu.setOnClickListener(new 1(this));
        }
    }

    protected final void afF() {
        int i = -1;
        super.afF();
        cnN();
        k vVar = new v(this.xOI, this.sgP, "", 0);
        String str = "MicroMsg.LoginFaceUI";
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
        this.iln = h.a((Context) this, getString(R.l.etF), true, new 2(this, vVar));
        ar.CG().a(vVar, 0);
    }
}
