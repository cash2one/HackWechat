package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.y;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import junit.framework.Assert;

public class SettingsMoreSafeUI extends MMPreference implements e, b {
    private f ilB;
    private ProgressDialog iln;
    private SparseIntArray qiF = new SparseIntArray();
    private String qkh = null;
    private String qki;

    public SettingsMoreSafeUI() {
        this.qiF.put(0, R.l.eLf);
        this.qiF.put(-82, R.l.eKA);
        this.qiF.put(-83, R.l.eKx);
        this.qiF.put(-84, R.l.eKy);
        this.qiF.put(-85, R.l.eKt);
        this.qiF.put(-86, R.l.eKB);
    }

    public final int XB() {
        return R.o.fco;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.CG().a(256, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(256, this);
    }

    protected final void initView() {
        setMMTitle(R.l.eLW);
        this.ilB = this.yjd;
        ar.Hg();
        if (((Integer) c.CU().get(9, Integer.valueOf(0))).intValue() != 0) {
            x.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
        } else if (bh.getInt(g.zY().getValue("BindQQSwitch"), 1) != 1) {
            this.ilB.bk("settings_uin", true);
            x.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
        }
        this.qkh = g.zY().getValue("CloseAcctUrl");
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        bqO();
        bqL();
        bqN();
        String value = g.zY().getValue("ShowExportUserDataEntry");
        if (bh.ov(value)) {
            this.qki = "";
            this.ilB.bk("settings_dump_personal_data", true);
        } else {
            this.qki = value;
        }
        bqM();
        this.ilB.c(this.ilB.YN("settings_about_domainmail"));
        if (bh.ov(this.qkh)) {
            this.ilB.c(this.ilB.YN("settings_delete_account"));
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.ibD;
        x.i("MicroMsg.SettingsMoreSafeUI", str + " item has been clicked!");
        if (bh.ov(str)) {
            return false;
        }
        if (str.equals("settings_facebook")) {
            G(FacebookAuthUI.class);
            return false;
        } else if (str.equals("settings_email_addr")) {
            ar.Hg();
            Integer num = (Integer) c.CU().get(7, null);
            if (!(num == null || (num.intValue() & 2) == 0)) {
                z = true;
            }
            ar.Hg();
            str = (String) c.CU().get(5, null);
            if (z || !bh.ov(str)) {
                startActivity(new Intent(this.mController.xIM, SettingsModifyEmailAddrUI.class));
            } else {
                if (this.iln != null) {
                    x.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
                    this.iln.dismiss();
                    this.iln = null;
                }
                h.a(this.mController.xIM, getString(R.l.dsd), bh.az(d.bx(this.mController.xIM), ""), getString(R.l.eLP), 50, new h.b(this) {
                    final /* synthetic */ SettingsMoreSafeUI qkj;

                    {
                        this.qkj = r1;
                    }

                    public final boolean v(CharSequence charSequence) {
                        if (bh.Vt(charSequence.toString())) {
                            a.ift.um();
                            k aVar = new com.tencent.mm.ab.a(com.tencent.mm.ab.a.hjv, charSequence.toString());
                            ar.CG().a(aVar, 0);
                            SettingsMoreSafeUI settingsMoreSafeUI = this.qkj;
                            Context context = this.qkj.mController.xIM;
                            this.qkj.getString(R.l.dGO);
                            settingsMoreSafeUI.iln = h.a(context, this.qkj.getString(R.l.eKZ), true, new 1(this, aVar));
                            return true;
                        }
                        h.bu(this.qkj.mController.xIM, this.qkj.getString(R.l.eSJ));
                        return false;
                    }
                });
            }
            return true;
        } else if (str.equals("settings_bind_qq")) {
            a.ifs.h(new Intent(), (Context) this);
            return true;
        } else if (str.equals("settings_phone_security")) {
            Intent intent = new Intent();
            int i = com.tencent.mm.s.c.Bq().a(w.a.xxB) ? 1 : 0;
            com.tencent.mm.s.c.Bq().b(w.a.xxB, false);
            ((IconPreference) preference).EZ(8);
            ar.Hg();
            int intValue = ((Integer) c.CU().get(w.a.xxD, Integer.valueOf(0))).intValue();
            com.tencent.mm.plugin.report.service.g.pQN.h(10939, new Object[]{Integer.valueOf(intValue)});
            if (bh.bi(this, "com.tencent.server.back.BackEngine")) {
                str = getString(R.l.eBo, new Object[]{Integer.valueOf(intValue), Integer.valueOf(1), Integer.valueOf(i)});
            } else {
                str = getString(R.l.eBo, new Object[]{Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(i)});
            }
            intent.putExtra("rawUrl", str);
            intent.putExtra("show_bottom", false);
            intent.putExtra("showShare", false);
            com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
            return false;
        } else if (str.equals("settings_delete_account")) {
            r0 = new Intent();
            if (bh.ov(this.qkh)) {
                return false;
            }
            r0.putExtra("rawUrl", this.qkh + "&lang=" + com.tencent.mm.sdk.platformtools.w.eL(this.mController.xIM));
            r0.putExtra("showShare", true);
            r0.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
            com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", r0, 2);
            return false;
        } else if (!str.equals("settings_dump_personal_data")) {
            return false;
        } else {
            r0 = new Intent();
            if (bh.ov(this.qki)) {
                return false;
            }
            r0.putExtra("rawUrl", this.qki);
            r0.putExtra("showShare", false);
            r0.putExtra("needRedirect", false);
            r0.putExtra("neverGetA8Key", true);
            r0.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
            com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", r0);
            return false;
        }
    }

    private void bqL() {
        Preference YN = this.ilB.YN("settings_email_addr");
        Assert.assertNotNull(YN);
        ar.Hg();
        String str = (String) c.CU().get(5, null);
        ar.Hg();
        Integer num = (Integer) c.CU().get(7, null);
        if (num != null && (num.intValue() & 2) != 0) {
            YN.setSummary(R.l.eLl);
        } else if (str != null) {
            YN.setSummary(R.l.eLk);
        } else {
            YN.setSummary(R.l.eKs);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        bqO();
        bqL();
        bqN();
        bqM();
    }

    private void bqM() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ilB.YN("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
        } else if (bh.cgC()) {
            this.ilB.bk("settings_phone_security", true);
        } else if (com.tencent.mm.s.c.Bq().a(w.a.xxB)) {
            iconSwitchKeyValuePreference.EZ(0);
        } else {
            iconSwitchKeyValuePreference.EZ(8);
        }
    }

    private void bqN() {
        Preference YN = this.ilB.YN("settings_facebook");
        if (YN == null) {
            x.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
        } else if (!q.Gr()) {
            this.ilB.c(YN);
        } else if (q.Gt()) {
            ar.Hg();
            YN.setSummary((String) c.CU().get(65826, null));
        } else {
            YN.setSummary(getString(R.l.eKY));
        }
    }

    private void bqO() {
        Preference YN = this.ilB.YN("settings_bind_qq");
        if (YN == null) {
            x.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
            return;
        }
        ar.Hg();
        int intValue = ((Integer) c.CU().get(9, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            x.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
            if (bh.getInt(g.zY().getValue("BindQQSwitch"), 1) != 1) {
                this.ilB.bk("settings_uin", true);
                return;
            } else {
                YN.setSummary(R.l.eKY);
                return;
            }
        }
        YN.setSummary(new o(intValue));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() != 256) {
            return;
        }
        if ((i == 0 && i2 == 0) || !a.ift.a(this, i, i2, str)) {
            int i3 = this.qiF.get(i2);
            String string = getString(R.l.eLe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i3 != 0) {
                try {
                    string = getString(i3);
                } catch (Throwable e) {
                    x.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", new Object[]{Integer.valueOf(i3), e.getMessage()});
                    x.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", e, "", new Object[0]);
                }
            }
            h.bu(this.mController.xIM, string);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            switch (i2) {
                case -1:
                    if (!(ar.CG() == null || ar.CG().hmV == null)) {
                        ar.CG().hmV.bF(false);
                    }
                    a.ift.us();
                    ar.Hg();
                    c.CU().b(this);
                    com.tencent.mm.sdk.b.b izVar = new iz();
                    izVar.fzC.status = 0;
                    izVar.fzC.aAk = 3;
                    com.tencent.mm.sdk.b.a.xef.m(izVar);
                    izVar = new y();
                    izVar.fnQ.fnR = true;
                    com.tencent.mm.sdk.b.a.xef.m(izVar);
                    ae.Vd("show_whatsnew");
                    com.tencent.mm.kernel.k.e(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    a.ifs.s(intent2, this.mController.xIM);
                    d.B(this, null);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }
}
