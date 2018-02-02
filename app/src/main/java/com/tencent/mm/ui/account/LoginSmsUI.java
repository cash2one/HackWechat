package com.tencent.mm.ui.account;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";

    static /* synthetic */ void a(LoginSmsUI loginSmsUI, String str) {
        if (!bh.ov(str)) {
            k sVar = new s(str, 16, "", 0, "");
            ar.CG().a(sVar, 0);
            loginSmsUI.getString(R.l.dGO);
            loginSmsUI.iln = h.a(loginSmsUI, loginSmsUI.getString(R.l.dHc), true, new 4(loginSmsUI, sVar));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xOO) {
            this.jge = 3;
            if (!bh.VR(this.xOI).booleanValue() && bh.VR(this.xOC).booleanValue()) {
                this.xOq.setText(Id(this.xOC));
            }
            this.jNX.setVisibility(0);
            this.jNX.cpa();
            this.jNX.yaE = new 1(this);
            this.jNX.addTextChangedListener(new 2(this));
            if (this.jNX.getText().toString().length() > 0) {
                this.xOr.setEnabled(true);
            } else {
                this.xOr.setEnabled(false);
            }
            this.xOr.setVisibility(0);
            this.xOr.setOnClickListener(new 3(this));
        }
    }

    protected final void afF() {
        super.afF();
        if (isFinishing() || getWindow() == null) {
            x.e(TAG, "LoginHistoryUI is finishing");
        } else if (!bh.ov(this.xOC)) {
            this.xOA.hNv = this.xOC;
            aWs();
            cnN();
            k sVar = new s(this.xOC, 17, this.jNX.getText().toString().trim(), 0, "");
            ar.CG().a(sVar, 0);
            getString(R.l.dGO);
            this.iln = h.a(this, getString(R.l.etF), true, new 5(this, sVar));
        }
    }

    public void onResume() {
        super.onResume();
        ar.CG().a(c.CTRL_INDEX, this);
    }

    protected void onStop() {
        super.onStop();
        ar.CG().b(c.CTRL_INDEX, this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.jNX.reset();
    }
}
