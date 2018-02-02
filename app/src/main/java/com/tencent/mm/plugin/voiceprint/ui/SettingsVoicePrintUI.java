package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class SettingsVoicePrintUI extends MMPreference implements e {
    private f ilB;
    private ProgressDialog iln = null;
    private View lCk;
    private boolean mkO = false;
    private VoiceHeaderPreference shK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eNQ);
        ar.CG().a(615, this);
        this.lCk = findViewById(R.h.cwn);
        initView();
        this.lCk.setBackgroundResource(R.e.white);
        ar.Hg();
        c.CU().a(a.xnF, Boolean.valueOf(false));
        ar.Hg();
        c.CU().a(a.xnG, Boolean.valueOf(false));
        ar.Hg();
        c.CU().a(a.xnH, Boolean.valueOf(false));
        ar.Hg();
        c.CU().a(a.xnI, Boolean.valueOf(false));
        x.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    }

    public void onResume() {
        super.onResume();
        if (this.mkO) {
            this.mkO = false;
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
            }
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.dHc), true, new 1(this));
            x.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            ar.CG().a(new i(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ar.CG().b(615, this);
        if (this.iln != null) {
            this.iln.dismiss();
        }
    }

    public final void initView() {
        ar.Hg();
        int o = bh.o(c.CU().get(40, Integer.valueOf(0)), 0);
        x.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + o + " " + (o & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        this.ilB = this.yjd;
        this.shK = (VoiceHeaderPreference) this.ilB.YN("settings_voiceprint_header");
        ((CheckBoxPreference) this.ilB.YN("settings_voiceprint_title")).mv(true);
        this.ilB.notifyDataSetChanged();
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.iln = h.a(context, getString(R.l.dHc), true, new 2(this));
        ar.CG().a(new i(0), 0);
        this.ilB.bk("settings_voiceprint_unlock", true);
        this.ilB.bk("settings_voiceprint_reset", true);
        this.ilB.bk("settings_voiceprint_create", true);
        setBackBtn(new 3(this));
    }

    public final int XB() {
        return R.o.fcw;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.YN("settings_voiceprint_title");
            x.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
            }
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.iln = h.a(context, getString(R.l.dHc), true, new 4(this));
            if (checkBoxPreference.isChecked()) {
                ar.CG().a(new i(1), 0);
            } else {
                ar.CG().a(new i(2), 0);
            }
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_voiceprint_reset")) {
            return false;
        } else {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 615) {
                i iVar = (i) kVar;
                if (iVar.mStatus == 1) {
                    int i3;
                    x.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.ilB.bk("settings_voiceprint_unlock", false);
                    this.ilB.notifyDataSetChanged();
                    int FY = q.FY();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_voiceprint_title");
                    x.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[]{Integer.valueOf(iVar.sgS)});
                    if (iVar.sgS > 0) {
                        x.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.mv(true);
                        this.ilB.bk("settings_voiceprint_reset", false);
                        this.ilB.bk("settings_voiceprint_unlock", false);
                        i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | FY;
                        this.shK.cv(getString(R.l.eTT), "");
                    } else {
                        x.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.mv(false);
                        this.ilB.bk("settings_voiceprint_reset", true);
                        this.ilB.bk("settings_voiceprint_unlock", true);
                        i3 = -131073 & FY;
                        this.shK.cv(getString(R.l.eTS), "");
                    }
                    x.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    aq.hfP.S("last_login_use_voice", String.valueOf(i3));
                    ar.Hg();
                    c.CU().set(40, Integer.valueOf(i3));
                    this.ilB.bk("settings_voiceprint_create", true);
                    this.ilB.bk("settings_voiceprint_title", false);
                    this.shK.f(null);
                    this.ilB.notifyDataSetChanged();
                } else {
                    x.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    g.pQN.h(11390, new Object[]{Integer.valueOf(2)});
                    this.ilB.bk("settings_voiceprint_unlock", true);
                    this.ilB.bk("settings_voiceprint_reset", true);
                    this.ilB.bk("settings_voiceprint_create", true);
                    this.ilB.bk("settings_voiceprint_title", true);
                    this.shK.cv(getString(R.l.eTV), getString(R.l.eTU));
                    this.shK.f(new 5(this));
                    this.ilB.notifyDataSetChanged();
                }
            }
            if (this.iln != null) {
                this.iln.dismiss();
                return;
            }
            return;
        }
        this.ilB.bk("settings_voiceprint_unlock", true);
        this.ilB.bk("settings_voiceprint_reset", true);
        this.ilB.bk("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.ilB.YN("settings_voiceprint_title")).mv(false);
        this.shK.cv(getString(R.l.eTS), "");
        this.ilB.notifyDataSetChanged();
        if (this.iln != null) {
            this.iln.dismiss();
        }
    }

    private void bFR() {
        g.pQN.h(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.mkO = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.mkO = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoiceSettingsUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    bFR();
                    return;
                } else {
                    h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 6(this), new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}
