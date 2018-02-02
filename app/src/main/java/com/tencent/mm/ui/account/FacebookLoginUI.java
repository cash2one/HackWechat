package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.b.2;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;

public class FacebookLoginUI extends MMPreference implements e {
    private String fIG = "";
    private OnCancelListener jWm;
    private String pRQ;
    private c xNR = new 1(this);
    private ProgressDialog xNw;
    private com.tencent.mm.ui.f.a.c xOa;
    private String xOb = "";
    private v xOc;
    private b xOd;
    boolean xOe = true;

    static /* synthetic */ void mb(boolean z) {
        int i = z ? 19 : 20;
        ar.He().set(i, Integer.valueOf(bh.a((Integer) ar.He().get(i), 0) + 1));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.app_name);
        a.ift.up();
        this.pRQ = b.Xn();
        initView();
        ar.CG().a(701, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(701, this);
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
        b.b(true, ar.CB() + "," + getClass().getName() + ",L100_200_FB," + ar.fH("L100_200_FB") + ",1");
        b.oG("L100_200_FB");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
        b.b(false, ar.CB() + "," + getClass().getName() + ",L100_200_FB," + ar.fH("L100_200_FB") + ",2");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.oH(this.pRQ);
        finish();
    }

    private void cnM() {
        try {
            if (this.xOa != null) {
                this.xOa.fY(this);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "", new Object[0]);
        }
        b.oI(ar.CB() + "," + getClass().getName() + ",L14," + ar.fH("L14") + ",1");
        this.xOa = new com.tencent.mm.ui.f.a.c("290293790992170");
        this.xOa.a(this, FacebookAuthUI.xNO, new a(this, (byte) 0));
        g.pQN.a(582, 5, 1, false);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[]{Integer.valueOf(kVar.hashCode()), Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.xNw != null) {
            this.xNw.dismiss();
            this.xNw = null;
        }
        if (bh.bF(this) && (kVar instanceof v)) {
            boolean z;
            this.fIG = ((v) kVar).RY();
            if (kVar.getType() == 701 && i == 4 && (i2 == -16 || i2 == -17)) {
                ar.CG().a(new bd(new 2(this)), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                ar.unhold();
                m.or("");
                d.bq(this);
                m.a(this, new 3(this), false, 2);
            } else if (i2 == -106) {
                m.b(this, str, 0);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.xOd == null) {
                    this.xOd = new 4(this);
                }
                SecurityImage.b bVar = this.xOd;
                byte[] Oo = ((v) kVar).Oo();
                bVar.xNp = kVar;
                if (bVar.xKa == null) {
                    bVar.xKa = SecurityImage.a.a(this, R.l.eEi, 0, Oo, "", "", new b$1(bVar, this), null, new 2(bVar), bVar);
                } else {
                    bVar.xKa.a(0, Oo, "", "");
                }
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            h.h(this.mController.xIM, R.l.eeu, R.l.dGO);
                            z = true;
                            break;
                        case -75:
                            m.bE(this.mController.xIM);
                            z = true;
                            break;
                        case -72:
                            h.h(this.mController.xIM, R.l.eEb, R.l.dGO);
                            z = true;
                            break;
                        case -30:
                            if (com.tencent.mm.protocal.d.vAC) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.fIG);
                                intent.putExtra("showShare", false);
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("needRedirect", false);
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
                                a.ifs.j(intent, this);
                            }
                            z = true;
                            break;
                        case -9:
                            h.h(this, R.l.etv, R.l.etw);
                            z = true;
                            break;
                        case -7:
                            h.h(this.mController.xIM, R.l.eet, R.l.dGO);
                            z = true;
                            break;
                        case -1:
                            if (ar.CG().Km() == 5) {
                                h.h(this, R.l.exG, R.l.exF);
                                z = true;
                                break;
                            }
                        case -4:
                        case -3:
                            h.h(this, R.l.ecj, R.l.etw);
                            z = true;
                            break;
                    }
                }
                z = a.ift.a(this.mController.xIM, i, i2, str);
                if (!z) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
                        if (eA != null && eA.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }

    protected final void initView() {
        this.xOa = new com.tencent.mm.ui.f.a.c("290293790992170");
        this.jWm = new 5(this);
        cnM();
        setBackBtn(new 6(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bh.ov(stringExtra));
            if (!bh.ov(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            x.i(str2, str3, objArr2);
            if (intExtra == -217) {
                cnM();
                return;
            }
        }
        this.xOa.e(i, i2, intent);
    }

    public final int XB() {
        return R.o.fbK;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str == null) {
            x.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (!str.equals("facebook_auth_bind_btn")) {
            return false;
        } else {
            cnM();
            return true;
        }
    }
}
