package com.tencent.mm.plugin.facedetect.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.facedetect.a;
import com.tencent.mm.plugin.facedetect.a$b;
import com.tencent.mm.plugin.facedetect.a$i;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.q;

public class SettingsFacePrintManagerUI extends MMPreference implements e {
    private f ilB;
    private ProgressDialog iln = null;
    private View lCk;
    private FaceHeaderPreference mkN;
    private boolean mkO = false;

    static /* synthetic */ void a(SettingsFacePrintManagerUI settingsFacePrintManagerUI) {
        g.pQN.h(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(settingsFacePrintManagerUI, FaceDetectUI.class);
        intent.putExtra("k_need_signature", true);
        intent.putExtra("k_user_name", q.FV());
        intent.putExtra("k_purpose", 1);
        settingsFacePrintManagerUI.startActivityForResult(intent, 1);
        settingsFacePrintManagerUI.mkO = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(h.mec);
        com.tencent.mm.kernel.g.CG().a(938, this);
        this.lCk = findViewById(a.e.cwn);
        initView();
        this.lCk.setBackgroundResource(a$b.white);
        n.o(this);
    }

    public void onResume() {
        super.onResume();
        if (this.mkO) {
            this.mkO = false;
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
            }
            Context context = this.mController.xIM;
            getString(h.dGO);
            this.iln = com.tencent.mm.ui.base.h.a(context, getString(h.dHc), true, new 1(this));
            x.d("MicroMsg.FaceSettingsManagerUI", "hy: resume after create face, get switch status");
            com.tencent.mm.kernel.g.CG().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.kernel.g.CG().b(938, this);
        if (this.iln != null) {
            this.iln.dismiss();
        }
    }

    public final void initView() {
        int o = bh.o(com.tencent.mm.kernel.g.Dj().CU().get(40, Integer.valueOf(0)), 0);
        x.i("MicroMsg.FaceSettingsManagerUI", "plugSwitch " + o + " " + (o & 4194304));
        this.ilB = this.yjd;
        this.mkN = (FaceHeaderPreference) this.ilB.YN("settings_faceprint_header");
        ((CheckBoxPreference) this.ilB.YN("settings_faceprint_title")).mv(true);
        this.ilB.notifyDataSetChanged();
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
        Context context = this.mController.xIM;
        getString(h.dGO);
        this.iln = com.tencent.mm.ui.base.h.a(context, getString(h.dHc), true, new 2(this));
        com.tencent.mm.kernel.g.CG().a(new com.tencent.mm.plugin.facedetect.b.q(3), 0);
        this.ilB.bk("settings_faceprint_create", true);
        this.ilB.bk("settings_faceeprint_reset", true);
        this.ilB.bk("settings_faceprint_unlock", true);
        setBackBtn(new 3(this));
    }

    public final int XB() {
        return a$i.meF;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        Intent intent = new Intent();
        if (str.equals("settings_faceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.YN("settings_faceprint_title");
            x.d("MicroMsg.FaceSettingsManagerUI", "hy: checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.iln != null && this.iln.isShowing()) {
                this.iln.dismiss();
            }
            Context context = this.mController.xIM;
            getString(h.dGO);
            this.iln = com.tencent.mm.ui.base.h.a(context, getString(h.dHc), true, new 4(this));
            if (checkBoxPreference.isChecked()) {
                com.tencent.mm.kernel.g.CG().a(new com.tencent.mm.plugin.facedetect.b.q(1), 0);
            } else {
                com.tencent.mm.kernel.g.CG().a(new com.tencent.mm.plugin.facedetect.b.q(2), 0);
            }
            return true;
        } else if (str.equals("settings_faceprint_unlock")) {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", q.FV());
            intent.putExtra("k_purpose", 2);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_faceeprint_reset")) {
            return false;
        } else {
            intent.setClass(this, FaceDetectUI.class);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_user_name", q.FV());
            intent.putExtra("k_purpose", 1);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.FaceSettingsManagerUI", "hy: onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 938) {
                com.tencent.mm.plugin.facedetect.b.q qVar = (com.tencent.mm.plugin.facedetect.b.q) kVar;
                if (qVar.mfu) {
                    int i3;
                    x.d("MicroMsg.FaceSettingsManagerUI", "faceprint exist");
                    this.ilB.bk("settings_faceprint_unlock", false);
                    this.ilB.notifyDataSetChanged();
                    int FY = q.FY();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_faceprint_title");
                    x.d("MicroMsg.FaceSettingsManagerUI", "opScene.isOpenSwitch:%b", new Object[]{Boolean.valueOf(qVar.mfv)});
                    if (qVar.mfv) {
                        x.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint open");
                        checkBoxPreference.mv(true);
                        this.ilB.bk("settings_faceeprint_reset", false);
                        this.ilB.bk("settings_faceprint_unlock", false);
                        i3 = 4194304 | FY;
                        this.mkN.cv(getString(h.meq), "");
                    } else {
                        x.d("MicroMsg.FaceSettingsManagerUI", "hy: faceprint close");
                        checkBoxPreference.mv(false);
                        this.ilB.bk("settings_faceeprint_reset", true);
                        this.ilB.bk("settings_faceprint_unlock", true);
                        i3 = -4194305 & FY;
                        this.mkN.cv(getString(h.mep), "");
                    }
                    x.i("MicroMsg.FaceSettingsManagerUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    aq.hfP.S("last_login_use_voice", String.valueOf(i3));
                    com.tencent.mm.kernel.g.Dj().CU().set(40, Integer.valueOf(i3));
                    this.ilB.bk("settings_faceprint_create", true);
                    this.ilB.bk("settings_faceprint_title", false);
                    this.mkN.f(null);
                    this.ilB.notifyDataSetChanged();
                } else {
                    x.d("MicroMsg.FaceSettingsManagerUI", "faceprint not exist");
                    g.pQN.h(11390, new Object[]{Integer.valueOf(2)});
                    this.ilB.bk("settings_faceprint_create", true);
                    this.ilB.bk("settings_faceprint_title", true);
                    this.ilB.bk("settings_faceprint_unlock", true);
                    this.ilB.bk("settings_faceeprint_reset", true);
                    this.mkN.setTitle(getString(h.meo));
                    this.mkN.f(new 5(this));
                    this.ilB.notifyDataSetChanged();
                }
            }
            if (this.iln != null) {
                this.iln.dismiss();
                return;
            }
            return;
        }
        this.ilB.bk("settings_faceprint_create", true);
        this.ilB.bk("settings_faceprint_unlock", true);
        this.ilB.bk("settings_faceeprint_reset", true);
        ((CheckBoxPreference) this.ilB.YN("settings_faceprint_title")).mv(false);
        this.mkN.setTitle(getString(h.mep));
        this.ilB.notifyDataSetChanged();
        if (this.iln != null) {
            this.iln.dismiss();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (intent != null && intent.getIntExtra("err_code", 10) == 0) {
                this.mkO = true;
            }
            x.i("MicroMsg.FaceSettingsManagerUI", "hy: is reg ok: %b", new Object[]{Boolean.valueOf(this.mkO)});
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length > 1) {
            x.d("MicroMsg.FaceSettingsManagerUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults0[%d] grantResults1[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Long.valueOf(Thread.currentThread().getId())});
            switch (i) {
                case 23:
                    if (iArr[0] != 0 || iArr[1] != 0) {
                        x.w("MicroMsg.FaceSettingsManagerUI", "hy: permission not granted");
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
