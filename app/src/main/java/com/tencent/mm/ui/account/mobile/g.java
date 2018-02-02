package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.z.ar;

public final class g implements e, b {
    private String lcJ = null;
    private MobileVerifyUI xUE;
    private String xUI = "";
    private int xUJ = 2;

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.xUE = mobileVerifyUI;
        this.lcJ = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.xUI = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.xUJ = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean Ej(int i) {
        com.tencent.mm.sdk.b.b hoVar;
        String str;
        String str2;
        k tVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (3.xUH[i - 1]) {
            case 1:
                hoVar = new ho();
                hoVar.fxR.context = this.xUE;
                a.xef.m(hoVar);
                str = hoVar.fxS.fxT;
                hoVar = new hp();
                a.xef.m(hoVar);
                str2 = hoVar.fxU.fxV;
                ar.CG().a(132, this);
                tVar = new t(this.xUE.fAf, 2, this.xUE.xTy.getText().toString().trim(), "", str, str2);
                ar.CG().a(tVar, 0);
                mobileVerifyUI = this.xUE;
                context = this.xUE;
                this.xUE.getString(R.l.dGO);
                mobileVerifyUI.iln = h.a(context, this.xUE.getString(R.l.dLx), true, new 2(this, tVar));
                break;
            case 2:
                ar.CG().a(132, this);
                ar.CG().a(new t(this.xUE.fAf, 1, "", 0, ""), 0);
                break;
            case 3:
                hoVar = new ho();
                hoVar.fxR.context = this.xUE;
                a.xef.m(hoVar);
                str = hoVar.fxS.fxT;
                hoVar = new hp();
                a.xef.m(hoVar);
                str2 = hoVar.fxU.fxV;
                ar.CG().a(132, this);
                tVar = new t(this.xUE.fAf, 2, this.xUE.xTy.getText().toString().trim(), "", str, str2);
                ar.CG().a(tVar, 0);
                mobileVerifyUI = this.xUE;
                context = this.xUE;
                this.xUE.getString(R.l.dGO);
                mobileVerifyUI.iln = h.a(context, this.xUE.getString(R.l.dLx), true, new 1(this, tVar));
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xUE.iln != null) {
            this.xUE.iln.dismiss();
            this.xUE.iln = null;
        }
        if (kVar.getType() == 132) {
            ar.CG().b(132, this);
            if (((t) kVar).IS() == 2 && i == 0 && i2 == 0) {
                ar.unhold();
                if (com.tencent.mm.pluginsdk.a.dY(this.xUE).size() != 0) {
                    i3 = 1;
                }
                Intent at;
                if (this.xUI == null || !this.xUI.contains("1") || r0 == 0) {
                    at = com.tencent.mm.plugin.c.a.ifs.at(this.xUE);
                    at.addFlags(67108864);
                    this.xUE.startActivity(at);
                    this.xUE.xVf = 4;
                    this.xUE.finish();
                    return;
                }
                com.tencent.mm.plugin.c.b.oH("R300_300_QQ");
                at = new Intent(this.xUE, FindMContactAddUI.class);
                at.addFlags(67108864);
                at.putExtra("regsetinfo_ticket", this.lcJ);
                at.putExtra("regsetinfo_NextStep", this.xUI);
                at.putExtra("regsetinfo_NextStyle", this.xUJ);
                at.putExtra("login_type", 1);
                Intent at2 = com.tencent.mm.plugin.c.a.ifs.at(this.xUE);
                at2.addFlags(67108864);
                MMWizardActivity.b(this.xUE, at, at2);
                this.xUE.finish();
            }
        } else if (!this.xUE.o(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.xUE, this.xUE.getString(R.l.dLz, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
