package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.k.g;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class SettingsAccountInfoUI extends MMPreference implements e, b {
    private f ilB;
    private ProgressDialog iln;
    private View qiA;
    private TextView qiB;
    private EditText qiC;
    private i qiD;
    private boolean qiE;
    private SparseIntArray qiF = new SparseIntArray();

    public SettingsAccountInfoUI() {
        this.qiF.put(0, R.l.eLf);
        this.qiF.put(-82, R.l.eKA);
        this.qiF.put(-83, R.l.eKx);
        this.qiF.put(-84, R.l.eKy);
        this.qiF.put(-85, R.l.eKt);
        this.qiF.put(-86, R.l.eKB);
    }

    public final int XB() {
        return R.o.fcj;
    }

    public final boolean XA() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.Hg();
        c.CU().a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.Hg();
        c.CU().b(this);
    }

    protected final void initView() {
        setMMTitle(R.l.eKQ);
        this.ilB = this.yjd;
        this.qiA = View.inflate(this, R.i.drP, null);
        this.qiB = (TextView) this.qiA.findViewById(R.h.cLB);
        this.qiB.setText(getString(R.l.eLx));
        this.qiC = (EditText) this.qiA.findViewById(R.h.cLA);
        this.qiC.setInputType(129);
        if (bh.getInt(g.zY().getValue("VoiceprintEntry"), 0) != 1) {
            this.ilB.bk("settings_voiceprint_title", true);
        } else if (ar.Hj()) {
            IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_voiceprint_title");
            ar.Hg();
            if (((Boolean) c.CU().get(a.xnI, Boolean.valueOf(true))).booleanValue()) {
                ar.Hg();
                if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                    iconPreference.EX(0);
                    x.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                    this.ilB.notifyDataSetChanged();
                }
            }
        } else {
            x.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            return;
        }
        setBackBtn(new 1(this));
    }

    protected void onResume() {
        ar.CG().a(255, this);
        ar.CG().a(384, this);
        ar.CG().a(281, this);
        ar.CG().a(282, this);
        bqC();
        bqE();
        this.qiE = false;
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_more_safe");
        if (com.tencent.mm.s.c.Bq().b(a.xxB, a.xxC)) {
            iconPreference.EZ(0);
        } else {
            iconPreference.EZ(8);
        }
        bqD();
        bqF();
        this.ilB.bk("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.ilB.YN("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.ilB.YN("settings_about_vuserinfo");
        Preference YN = this.ilB.YN("settings_about_vuser_about");
        ar.Hg();
        int e = bh.e((Integer) c.CU().get(66049, null));
        if (e != 0) {
            Bitmap b;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.Fg(R.l.dXg);
            if (ak.a.hfN != null) {
                b = BackwardSupportUtil.b.b(ak.a.hfN.gO(e), 2.0f);
            } else {
                b = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), b);
            ar.Hg();
            selfVuserPreference.text = (String) c.CU().get(66050, null);
        } else {
            this.ilB.c(pluginTextPreference);
            this.ilB.c(selfVuserPreference);
            this.ilB.c(YN);
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(255, this);
        ar.CG().b(384, this);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        q.FS();
        if (bh.ov(str)) {
            return false;
        }
        if (str.equals("settings_username") && bh.ov(q.FT()) && com.tencent.mm.storage.x.WC(q.FS())) {
            G(SettingsAliasUI.class);
        }
        if (str.equals("settings_mobile")) {
            Intent intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.A(this, intent);
            return true;
        }
        if (str.equals("settings_about_vuser_about")) {
            bh.F(this.mController.xIM, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{w.cfi()}));
        } else if (str.equals("settings_independent_password")) {
            if (this.qiE) {
                hN(true);
            } else {
                k xVar = new com.tencent.mm.modelsimple.x(1);
                ar.CG().a(xVar, 0);
                getString(R.l.dGO);
                this.iln = h.a(this, getString(R.l.eLF), true, new 2(this, xVar));
            }
        } else if (str.equals("settings_safe_device")) {
            ar.Hg();
            str = (String) c.CU().get(6, "");
            ar.Hg();
            String str2 = (String) c.CU().get(4097, "");
            if (!bh.ov(str)) {
                d.y(this, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (bh.ov(str2)) {
                d.a(this, "safedevice", ".ui.BindSafeDeviceUI", new Intent());
            } else {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("is_bind_for_safe_device", true);
                MMWizardActivity.A(this, intent);
            }
        } else if (str.equals("settings_security_center")) {
            str = getString(R.l.eXC) + w.cfi();
            Context context = this.mController.xIM;
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("showShare", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("needRedirect", false);
            intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vAM);
            intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vAJ);
            d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
        } else if (str.equals("settings_voiceprint_title")) {
            if (bh.getInt(g.zY().getValue("VoiceprintEntry"), 0) == 1) {
                ar.Hg();
                if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    ar.Hg();
                    c.CU().a(a.xnI, Boolean.valueOf(false));
                    ((IconPreference) this.ilB.YN("settings_voiceprint_title")).EX(8);
                    this.ilB.notifyDataSetChanged();
                    x.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
                }
            }
            d.y(this.mController.xIM, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            com.tencent.mm.sdk.b.b nnVar = new nn();
            nnVar.fFE.context = this;
            com.tencent.mm.sdk.b.a.xef.m(nnVar);
            x.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", new Object[]{Boolean.valueOf(nnVar.fFF.fFD)});
            if (!nnVar.fFF.fFD) {
                u.makeText(this.mController.xIM, getString(R.l.eea), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            G(SettingsTrustFriendUI.class);
        } else if (str.equals("settings_more_safe")) {
            com.tencent.mm.s.c.Bq().c(a.xxB, a.xxC);
            G(SettingsMoreSafeUI.class);
        }
        return false;
    }

    public final void a(int i, m mVar, Object obj) {
        bqC();
        bqE();
        bqD();
        bqF();
    }

    private void bqC() {
        Preference YN = this.ilB.YN("settings_username");
        CharSequence FT = q.FT();
        if (bh.ov(FT)) {
            FT = q.FS();
            if (com.tencent.mm.storage.x.WB(FT)) {
                YN.setSummary(getString(R.l.eMh));
                return;
            } else {
                YN.setSummary(FT);
                return;
            }
        }
        YN.setSummary(FT);
    }

    private void bqD() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ilB.YN("settings_safe_device");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            return;
        }
        ar.Hg();
        if (((Integer) c.CU().get(9, Integer.valueOf(0))).intValue() == 0) {
            x.d("MicroMsg.SettingsAccountInfoUI", "not bind uin");
            this.ilB.bk("settings_safe_device", true);
            return;
        }
        this.ilB.bk("settings_safe_device", false);
        if (q.Ga()) {
            iconSwitchKeyValuePreference.setSummary(R.l.eGB);
            iconSwitchKeyValuePreference.Fe(1);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(R.l.eGC);
        iconSwitchKeyValuePreference.Fe(2);
    }

    private void bqE() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ilB.YN("settings_mobile");
        if (iconSwitchKeyValuePreference == null) {
            x.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            return;
        }
        ar.Hg();
        String str = (String) c.CU().get(6, null);
        x.d("MicroMsg.SettingsAccountInfoUI", "mobile :" + str);
        if (str == null || str.length() <= 0) {
            iconSwitchKeyValuePreference.setSummary(getString(R.l.eKY));
            iconSwitchKeyValuePreference.Fe(0);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(str);
        iconSwitchKeyValuePreference.Fe(1);
    }

    private void bqF() {
        boolean z;
        boolean z2 = true;
        com.tencent.mm.sdk.b.b ayVar = new ay();
        com.tencent.mm.sdk.b.a.xef.m(ayVar);
        if (ayVar.fpd.fpe && ayVar.fpd.fpf && ayVar.fpd.fpg) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[]{Boolean.valueOf(ayVar.fpd.fpe), Boolean.valueOf(ayVar.fpd.fpf), Boolean.valueOf(ayVar.fpd.fpg)});
        f fVar = this.ilB;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        fVar.bk(str, z2);
    }

    private void hN(boolean z) {
        x.d("MicroMsg.SettingsAccountInfoUI", "handlePassword " + z);
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", getString(R.l.eLU));
            d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
        } else if (this.qiD != null) {
            this.qiD.show();
        } else {
            this.qiD = h.a(this, null, this.qiA, new 3(this), new 4(this));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SettingsAccountInfoUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (kVar.getType() == 255) {
            if (((com.tencent.mm.modelsimple.x) kVar).hNM != 1) {
                return;
            }
            if (i == 0 && i2 == 0) {
                hN(true);
            } else if (!com.tencent.mm.plugin.setting.a.ift.a(this, i, i2, str)) {
                hN(false);
            }
        } else if (kVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                ar.Hg();
                c.CU().set(77830, ((al) kVar).NW());
                Intent intent = new Intent();
                intent.putExtra("kintent_hint", getString(R.l.eLU));
                d.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                return;
            }
            this.qiE = true;
            h.a(this, R.l.eMi, R.l.dGO, new 5(this));
        }
    }
}
