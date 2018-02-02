package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.mobile.MobileInputUI.a;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

public final class c implements e, b {
    private SecurityImage xKa = null;
    private a xQO = null;
    private MobileInputUI xTM;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] xTO = new int[a.coz().length];

        static {
            try {
                xTO[a.xUl - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.xTM = mobileInputUI;
        mobileInputUI.xQd.setVisibility(0);
        mobileInputUI.xTX.setVisibility(0);
        mobileInputUI.xTY.requestFocus();
        mobileInputUI.xQo.setText(R.l.dFQ);
        mobileInputUI.xQo.setVisibility(0);
        mobileInputUI.xUc.setVisibility(0);
        mobileInputUI.xUd.setText(R.l.ets);
        mobileInputUI.xUd.setVisibility(0);
        mobileInputUI.xUd.setOnClickListener(new 1(this, mobileInputUI));
    }

    public final void start() {
        ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(true, ar.CB() + "," + getClass().getName() + ",L200_100," + ar.fH("L200_100") + ",1");
        com.tencent.mm.plugin.c.b.oG("L200_100");
    }

    public final void stop() {
        ar.CG().b(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, this);
        com.tencent.mm.plugin.c.b.b(false, ar.CB() + "," + getClass().getName() + ",L200_100," + ar.fH("L200_100") + ",2");
    }

    public final void Ei(int i) {
        switch (AnonymousClass3.xTO[i - 1]) {
            case 1:
                this.xTM.xUe = ao.Vm(this.xTM.countryCode);
                this.xTM.phQ = this.xTM.xTY.getText().toString();
                String Vk = ao.Vk(this.xTM.xUe + this.xTM.phQ);
                MobileInputUI mobileInputUI = this.xTM;
                Context context = this.xTM;
                this.xTM.getString(R.l.dGO);
                mobileInputUI.xPh = h.a(context, this.xTM.getString(R.l.eDx), true, new 2(this));
                ar.CG().a(new s(Vk, 13, "", 0, ""), 0);
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.xTM.xPh != null) {
            this.xTM.xPh.dismiss();
            this.xTM.xPh = null;
        }
        if (kVar.getType() == 701 && this.xQO != null) {
            this.xQO.xPI = this.xTM.xPI;
            this.xQO.a(this.xTM, i, i2, str, kVar);
        } else if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX || ((s) kVar).IS() != 13) {
        } else {
            if (i2 == -41) {
                com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this.xTM, null, null);
                } else {
                    h.h(this.xTM, R.l.eDE, R.l.eDF);
                }
            } else if (i2 == -1) {
                Toast.makeText(this.xTM, this.xTM.getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i2 == -34) {
                h.b(this.xTM, this.xTM.getString(R.l.dKT), "", true);
            } else {
                this.xTM.aWs();
                Intent intent = new Intent(this.xTM, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", -1);
                intent.putExtra("mobile_auth_type", 7);
                intent.putExtra("from_switch_account", this.xTM.xPG);
                intent.putExtra("input_country_code", this.xTM.countryCode);
                intent.putExtra("input_mobile_number", this.xTM.phQ);
                this.xTM.startActivity(intent);
            }
        }
    }
}
