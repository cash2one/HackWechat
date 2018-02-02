package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ar.b.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.hz$a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.z.ar;

public final class j {
    int fpk = 0;
    ProgressDialog iln;
    private View qiA;
    private TextView qiB;
    EditText qiC;
    i qiD;
    boolean qiE;
    MMFragmentActivity xFE;
    b xFF;
    hz$a xFG = null;
    e xFH;
    boolean xFI = false;
    c xFJ = new 1(this);
    c<bb> xFK = new 2(this);

    static /* synthetic */ void a(j jVar, int i, int i2, int i3, String str) {
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        g.pQN.h(13191, new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(false)});
        Intent intent;
        switch (i2) {
            case 2:
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                d.b(jVar.xFE, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 3:
                if (jVar.qiE) {
                    jVar.hN(true);
                    return;
                }
                jVar.cmu();
                ar.CG().a(255, jVar.xFH);
                k xVar = new com.tencent.mm.modelsimple.x(1);
                ar.CG().a(xVar, 0);
                Context context = jVar.xFE;
                jVar.getString(R.l.dGO);
                jVar.iln = h.a(context, jVar.getString(R.l.eLF), true, new 10(jVar, xVar));
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(jVar.xFE, BindMContactUI.class);
                intent2.putExtra("is_bind_for_change_mobile", true);
                String simCountryIso = ((TelephonyManager) jVar.xFE.getSystemService("phone")).getSimCountryIso();
                if (!t.ov(simCountryIso)) {
                    a h = com.tencent.mm.ar.b.h(jVar.xFE, simCountryIso, jVar.getString(R.l.bZb));
                    if (h != null) {
                        intent2.putExtra("country_name", h.hEx);
                        intent2.putExtra("couttry_code", h.hEw);
                    }
                }
                MMWizardActivity.A(jVar.xFE, intent2);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!com.tencent.mm.p.a.aV(jVar.xFE) && !com.tencent.mm.au.a.Qj()) {
                    d.b(jVar.xFE, "scanner", ".ui.BaseScanUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public j(MMFragmentActivity mMFragmentActivity, b bVar) {
        this.xFE = mMFragmentActivity;
        this.xFF = bVar;
    }

    final boolean a(hz$a com_tencent_mm_g_a_hz_a) {
        if (com_tencent_mm_g_a_hz_a == null || com_tencent_mm_g_a_hz_a.fyv == null || com_tencent_mm_g_a_hz_a.fyv.vCS == null || com_tencent_mm_g_a_hz_a.fyv.vCS.size() == 0) {
            return false;
        }
        int i = com_tencent_mm_g_a_hz_a.fyv.id;
        String str = com_tencent_mm_g_a_hz_a.fyv.title;
        String str2 = com_tencent_mm_g_a_hz_a.fyv.fpb;
        int i2 = com_tencent_mm_g_a_hz_a.type;
        int size = com_tencent_mm_g_a_hz_a.fyv.vCS.size();
        if (i2 == 0) {
            if (size == 1) {
                com.tencent.mm.protocal.b.a.a aVar = (com.tencent.mm.protocal.b.a.a) com_tencent_mm_g_a_hz_a.fyv.vCS.get(0);
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(aVar.id), Integer.valueOf(aVar.actionType), aVar.vCQ, aVar.vCR});
                h.a(this.xFE, str2, str, aVar.vCQ, false, new 7(this, i, aVar));
            } else {
                com.tencent.mm.protocal.b.a.a aVar2 = (com.tencent.mm.protocal.b.a.a) com_tencent_mm_g_a_hz_a.fyv.vCS.get(1);
                com.tencent.mm.protocal.b.a.a aVar3 = (com.tencent.mm.protocal.b.a.a) com_tencent_mm_g_a_hz_a.fyv.vCS.get(0);
                x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[]{str, str2, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.vCQ, aVar2.vCR, Integer.valueOf(aVar3.id), Integer.valueOf(aVar3.actionType), aVar3.vCQ, aVar3.vCR});
                h.a(this.xFE, str2, str, aVar2.vCQ, aVar3.vCQ, false, new 8(this, i, aVar2), new 9(this, i, aVar3));
            }
        } else if (i2 == 1) {
            String str3 = str2;
            String str4 = str;
            boolean z = false;
            h.a(this.xFE, str3, str4, ((com.tencent.mm.protocal.b.a.a) com_tencent_mm_g_a_hz_a.fyv.vCS.get(0)).vCQ, ((com.tencent.mm.protocal.b.a.a) com_tencent_mm_g_a_hz_a.fyv.vCS.get(1)).vCQ, z, com_tencent_mm_g_a_hz_a.fyw, com_tencent_mm_g_a_hz_a.fyx);
        }
        return true;
    }

    final e cmu() {
        if (this.xFH == null) {
            this.xFH = new 11(this);
        }
        return this.xFH;
    }

    final void hN(boolean z) {
        x.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword " + z);
        if (z) {
            cmv();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", getString(R.l.eLU));
        d.b(this.xFE, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
    }

    final void cmv() {
        if (this.qiD != null) {
            this.qiD.show();
            return;
        }
        if (this.qiA == null) {
            this.qiA = View.inflate(this.xFE, R.i.drP, null);
            this.qiB = (TextView) this.qiA.findViewById(R.h.cLB);
            this.qiB.setText(getString(R.l.eLx));
            this.qiC = (EditText) this.qiA.findViewById(R.h.cLA);
            this.qiC.setInputType(129);
        }
        this.qiD = h.a(this.xFE, null, this.qiA, new 12(this), new OnClickListener(this) {
            final /* synthetic */ j xFL;

            {
                this.xFL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.xFL.qiC.setText("");
                this.xFL.qiD.dismiss();
            }
        });
    }

    final String getString(int i) {
        return this.xFE.getString(i);
    }
}
