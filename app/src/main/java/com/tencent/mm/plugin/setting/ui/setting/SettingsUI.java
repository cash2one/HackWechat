package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.y;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.s.a.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.aq;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bq;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public class SettingsUI extends MMPreference implements b {
    private ak hHu = null;
    private e hPs = null;
    private ak ikI;
    private f ilB;
    private g jLx;
    private View oaS;
    private ProgressDialog qib = null;
    private ak qic;
    private e qid = null;
    private a qlA = new 1(this);
    private Dialog qlB = null;
    private i qlC;
    private CheckBox qlD;
    private e qlE = null;
    private PersonalPreference qly = null;
    private e qlz = null;

    static /* synthetic */ void h(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        ar.Hg();
        objArr[0] = Integer.valueOf(c.Cg());
        x.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.SO().SP();
        n CG = ar.CG();
        e 9 = new 9(settingsUI);
        settingsUI.qid = 9;
        CG.a(255, 9);
        k xVar = new com.tencent.mm.modelsimple.x(2);
        xVar.hNL = 2;
        ar.CG().a(xVar, 0);
        settingsUI.qic = new ak(Looper.getMainLooper(), new 10(settingsUI, xVar), false);
        settingsUI.qic.J(12000, 12000);
        settingsUI.getString(R.l.dGO);
        settingsUI.qib = h.a(settingsUI, settingsUI.getString(R.l.eYH), false, new 11(settingsUI, xVar));
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            String iW = com.tencent.mm.ad.b.iW(q.FS());
            aq.hfP.hM(iW);
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xxN, iW);
        }
    }

    static /* synthetic */ void k(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        ar.Hg();
        objArr[0] = Integer.valueOf(c.Cg());
        x.w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", objArr);
        ar.Hg();
        if (c.ET()) {
            n CG = ar.CG();
            e 6 = new 6(settingsUI);
            settingsUI.qlE = 6;
            CG.a(281, 6);
            k amVar = new am(2);
            ar.CG().a(amVar, 0);
            settingsUI.hHu = new ak(new 7(settingsUI, amVar), false);
            settingsUI.hHu.J(5000, 5000);
            Context context = settingsUI.mController.xIM;
            settingsUI.getString(R.l.dGO);
            settingsUI.qib = h.a(context, settingsUI.getString(R.l.eXm), true, new 8(settingsUI, amVar));
            return;
        }
        settingsUI.bri();
    }

    static /* synthetic */ void v(SettingsUI settingsUI) {
        ar.Hg();
        if (c.ET()) {
            n CG = ar.CG();
            e 14 = new 14(settingsUI);
            settingsUI.hPs = 14;
            CG.a(281, 14);
            k amVar = new am(2);
            ar.CG().a(amVar, 0);
            settingsUI.brh();
            settingsUI.qic = new ak(Looper.getMainLooper(), new 15(settingsUI, amVar), false);
            settingsUI.qic.J(5000, 5000);
            settingsUI.getString(R.l.dGO);
            settingsUI.qib = h.a(settingsUI, settingsUI.getString(R.l.eXm), true, new 16(settingsUI, amVar));
            return;
        }
        settingsUI.brh();
        settingsUI.ikI = new ak(Looper.getMainLooper(), new 17(settingsUI), false);
        settingsUI.ikI.J(3000, 3000);
        settingsUI.getString(R.l.dGO);
        settingsUI.qib = h.a(settingsUI, settingsUI.getString(R.l.eYH), true, new 18(settingsUI));
    }

    public final int XB() {
        return R.o.fch;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ar.Hg();
        c.CU().a(this);
        com.tencent.mm.s.c.Bq().a(this.qlA);
        if (bh.getInt(com.tencent.mm.k.g.zY().getValue("VoiceprintEntry"), 0) == 1) {
            ar.Hg();
            if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                ar.Hg();
                c.CU().a(w.a.xnF, Boolean.valueOf(false));
                x.i("MicroMsg.SettingsUI", "unset more tab dot");
            }
        }
    }

    protected void onDestroy() {
        if (ar.Hj()) {
            ar.Hg();
            c.CU().b(this);
            com.tencent.mm.s.c.Bq().b(this.qlA);
        }
        if (this.hPs != null) {
            ar.CG().b(281, this.hPs);
        }
        if (this.qid != null) {
            ar.CG().b(255, this.qid);
        }
        if (this.qlE != null) {
            ar.CG().b(281, this.qlE);
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.SettingsUI", "settings handle");
        Context applicationContext;
        String b;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ar.Hg();
                    b = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, c.Fi());
                    if (b != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        com.tencent.mm.ad.n.Jz();
                        intent2.putExtra("CropImage_OutputPath", d.x(q.FS(), true));
                        intent2.putExtra("CropImage_ImgPath", b);
                        com.tencent.mm.pluginsdk.n nVar = com.tencent.mm.plugin.setting.a.ifs;
                        ar.Hg();
                        nVar.a(this, intent, intent2, c.Fi(), 4, null);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ar.Hg();
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, c.Fi());
                if (b != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 1);
                    intent3.putExtra("CropImage_OutputPath", b);
                    intent3.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.setting.a.ifs.a(this.mController.xIM, intent3, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        x.e("MicroMsg.SettingsUI", "crop picture failed");
                    } else {
                        new p(this.mController.xIM, b).c(1, null);
                    }
                    super.onActivityResult(i, i2, intent);
                    return;
                }
                return;
            case 5:
                if (i2 == -1) {
                    bqX();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        ar.Dm().J(new 12(this));
    }

    public void onResume() {
        PersonalPreference personalPreference = (PersonalPreference) this.ilB.YN("settings_account");
        if (personalPreference != null) {
            String FS = q.FS();
            personalPreference.hkT = null;
            personalPreference.qhh = -1;
            personalPreference.qhi = FS;
            if (personalPreference.mxV != null) {
                com.tencent.mm.pluginsdk.ui.a.b.a(personalPreference.mxV, personalPreference.qhi);
            }
        }
        com.tencent.mm.sdk.b.b edVar = new ed();
        com.tencent.mm.sdk.b.a.xef.m(edVar);
        if (!edVar.fsN.frp) {
            this.ilB.c(this.ilB.YN("settings_about_device"));
        }
        brb();
        brd();
        bqy();
        brc();
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_welab");
        com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.c.class);
        if (cVar.bVA()) {
            iconPreference.EX(0);
            iconPreference.dh(getString(R.l.dFP), R.g.bEf);
        } else {
            iconPreference.EX(8);
        }
        if (!cVar.bVB()) {
            iconPreference.eW(8, -1);
        } else if (cVar.bVz()) {
            iconPreference.eW(0, R.k.dBK);
        } else {
            iconPreference.eW(0, R.k.dBJ);
        }
        this.ilB.c(this.ilB.YN("settings_hardcoder"));
        x.v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
    }

    private void brb() {
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_account_info");
        if (iconPreference == null) {
            x.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            return;
        }
        iconPreference.Fc(8);
        if (com.tencent.mm.s.c.Bq().a(w.a.xxB, 266257)) {
            iconPreference.EZ(0);
        } else {
            iconPreference.EZ(8);
        }
        if (bh.getInt(com.tencent.mm.k.g.zY().getValue("VoiceprintEntry"), 0) == 1) {
            ar.Hg();
            if (((Boolean) c.CU().get(w.a.xnH, Boolean.valueOf(true))).booleanValue()) {
                ar.Hg();
                if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    iconPreference.dh(getString(R.l.dFP), R.g.bEf);
                    iconPreference.EX(0);
                    x.i("MicroMsg.SettingsUI", "show voiceprint dot");
                }
            } else {
                iconPreference.EX(8);
                iconPreference.dh("", -1);
            }
            this.ilB.notifyDataSetChanged();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.eNt);
        this.ilB = this.yjd;
        setBackBtn(new 23(this));
        this.jLx = new g(this, g.ztp, false);
        this.jLx.rKC = new 24(this);
        this.jLx.ztB = new 25(this);
        this.jLx.rKD = new 26(this);
        27 27 = new 27(this);
        brd();
        bqy();
        brc();
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        x.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            x.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
            return;
        }
        if (4 == o) {
            ar.Hg();
            c.CU().get(2, null);
            ar.Hg();
            c.CU().get(4, null);
        }
        if (6 == o) {
            brd();
        } else if (64 == o) {
            brb();
        }
    }

    private void bqy() {
        int i;
        int i2 = 0;
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_about_micromsg");
        boolean a = bh.a(Boolean.valueOf(com.tencent.mm.s.c.Bq().aQ(262145, 266243)), false);
        boolean aR = com.tencent.mm.s.c.Bq().aR(262157, 266262);
        if (com.tencent.mm.sdk.platformtools.f.xeD) {
            iconPreference.dh("", -1);
            iconPreference.EX(8);
        } else if (a) {
            iconPreference.EX(0);
            iconPreference.dh(getString(R.l.dFP), R.g.bEf);
        } else if (aR) {
            iconPreference.EZ(0);
        } else {
            iconPreference.EZ(8);
            iconPreference.dh("", -1);
            iconPreference.EX(8);
        }
        iconPreference = (IconPreference) this.ilB.YN("settings_about_system");
        if (com.tencent.mm.s.c.Bq().aR(262158, 266265)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.EZ(i);
        if (!com.tencent.mm.plugin.x.a.bfo().ig(com.tencent.mm.aw.b.hId)) {
            i2 = 8;
        }
        iconPreference.EZ(i2);
    }

    private void brc() {
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_about_privacy");
        if (iconPreference != null) {
            ar.Hg();
            int intValue = ((Integer) c.CU().get(w.a.xum, Integer.valueOf(0))).intValue();
            ar.Hg();
            if (intValue > ((Integer) c.CU().get(w.a.xun, Integer.valueOf(0))).intValue()) {
                iconPreference.EZ(0);
            } else {
                iconPreference.EZ(8);
            }
        }
    }

    private void brd() {
        com.tencent.mm.modelfriend.m.a NN = com.tencent.mm.modelfriend.m.NN();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.ilB.YN("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            boolean z = NN == com.tencent.mm.modelfriend.m.a.hwi || NN == com.tencent.mm.modelfriend.m.a.hwj;
            switchKeyValuePreference.fqP = z;
            switchKeyValuePreference.au();
            int i = (NN == com.tencent.mm.modelfriend.m.a.hwi || NN == com.tencent.mm.modelfriend.m.a.hwj) ? R.l.eMv : R.l.eMu;
            switchKeyValuePreference.setSummary(i);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.SettingsUI", str + " item has been clicked!");
        if ("settings_welab".equals(str)) {
            Intent intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add("labs_browse");
            intent.putStringArrayListExtra("key_exclude_apps", arrayList);
            ((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.welab.a.a.c.class)).u(this, intent);
            return true;
        } else if ("settings_account_info".equals(str)) {
            if (bh.getInt(com.tencent.mm.k.g.zY().getValue("VoiceprintEntry"), 0) == 1) {
                ar.Hg();
                if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                    ar.Hg();
                    c.CU().a(w.a.xnH, Boolean.valueOf(false));
                    x.i("MicroMsg.SettingsUI", "unset setting account info dot show");
                }
            }
            com.tencent.mm.s.c.Bq().b(w.a.xxB, 266257);
            G(SettingsAccountInfoUI.class);
            return true;
        } else if ("settings_account".equals(str)) {
            this.mController.xIM.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent2 = new Intent(this, BindMContactIntroUI.class);
            intent2.putExtra("key_upload_scene", 4);
            MMWizardActivity.A(this, intent2);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            ar.Hg();
            int intValue = ((Integer) c.CU().get(w.a.xum, Integer.valueOf(0))).intValue();
            ar.Hg();
            if (intValue > ((Integer) c.CU().get(w.a.xun, Integer.valueOf(0))).intValue()) {
                ar.Hg();
                c.CU().a(w.a.xun, Integer.valueOf(intValue));
            }
            startActivity(new Intent(this, SettingsPrivacyUI.class));
            return true;
        } else if (str.equals("settings_about_system")) {
            com.tencent.mm.s.c.Bq().aS(262158, 266265);
            startActivity(new Intent(this, SettingsAboutSystemUI.class));
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            com.tencent.mm.s.c.Bq().aS(262145, 266243);
            com.tencent.mm.s.c.Bq().aS(262157, 266262);
            this.mController.xIM.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
            new af().postDelayed(new 29(this), 100);
            return true;
        } else if (str.equals("settings_about_device")) {
            com.tencent.mm.bm.d.b(this.mController.xIM, "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            return true;
        } else if (str.equals("settings_logout")) {
            if (com.tencent.mm.ar.b.PT()) {
                x.i("MicroMsg.SettingsUI", "oversea user logout");
                h.a(this.mController.xIM, true, getResources().getString(R.l.eLI), "", getResources().getString(R.l.eLG), getString(R.l.dEn), new OnClickListener(this) {
                    final /* synthetic */ SettingsUI qlF;

                    {
                        this.qlF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsUI.h(this.qlF);
                    }
                }, null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(11545, new Object[]{Integer.valueOf(8)});
            x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            if (bq.hhK.HV().size() > 1) {
                com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(10)});
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(10)});
            }
            this.jLx.bUk();
            return true;
        } else if (str.equals("settings_exit")) {
            return brg();
        } else {
            if (str.equals("settings_logout_option")) {
                return brf();
            }
            if (str.equals("settings_notification_preference")) {
                startActivity(new Intent(this, SettingsNotificationUI.class));
                return true;
            } else if (str.equals("settings_chatting")) {
                G(SettingsChattingUI.class);
                return true;
            } else if (str.equals("settings_active_time")) {
                com.tencent.mm.plugin.report.service.g.pQN.h(11351, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                G(SettingsActiveTimeUI.class);
                return true;
            } else {
                if (str.equals("settings_feedback")) {
                    str = (com.tencent.mm.sdk.platformtools.f.xeD || !com.tencent.mm.sdk.platformtools.w.cfi().equals("zh_CN")) ? com.tencent.mm.sdk.platformtools.w.cfi().equals("zh_HK") ? getString(R.l.eXu) : com.tencent.mm.sdk.platformtools.w.cfi().equals("zh_TW") ? getString(R.l.eXv) : getString(R.l.eXw) : getString(R.l.eXt);
                    x.d("MicroMsg.SettingsUI", "using faq webpage");
                    Intent intent3 = new Intent();
                    intent3.putExtra("showShare", false);
                    intent3.putExtra("rawUrl", str);
                    intent3.putExtra("show_feedback", false);
                    com.tencent.mm.bm.d.b(this.mController.xIM, "webview", ".ui.tools.WebViewUI", intent3);
                } else if (!str.equals("settings_hardcoder") && str.equals("settings_switch_account")) {
                    if (bq.hhK.HV().size() > 1) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(6)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(6)});
                    }
                    if (com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.xxc, true)) {
                        com.tencent.mm.kernel.g.Dj().CU().a(w.a.xxc, Boolean.valueOf(false));
                        h.a(this, getString(R.l.eNj), getString(R.l.eNk), getString(R.l.dFs), false, new 28(this));
                    } else {
                        bre();
                    }
                }
                return false;
            }
        }
    }

    private void bre() {
        Intent intent = new Intent(this, SettingsSwitchAccountUI.class);
        intent.putExtra("key_scene", 0);
        startActivity(intent);
    }

    private void bqX() {
        x.i("MicroMsg.SettingsUI", "oneliang logout mm");
        com.tencent.mm.plugin.setting.a.ift.us();
        ar.Hg();
        c.CU().b(this);
        com.tencent.mm.sdk.b.b izVar = new iz();
        izVar.fzC.status = 0;
        izVar.fzC.aAk = 0;
        com.tencent.mm.sdk.b.a.xef.m(izVar);
        izVar = new y();
        izVar.fnQ.fnR = true;
        com.tencent.mm.sdk.b.a.xef.m(izVar);
        ae.Vd("show_whatsnew");
        com.tencent.mm.kernel.k.e(this, true);
        ac.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        com.tencent.mm.plugin.setting.a.ifs.s(intent, this.mController.xIM);
        com.tencent.mm.modelsimple.d.B(this, null);
        finish();
    }

    private boolean brf() {
        com.tencent.mm.plugin.report.service.g.pQN.h(11545, new Object[]{Integer.valueOf(1)});
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.qlB != null) {
            this.qlB.show();
        } else {
            x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.qlB = h.a(this, getString(R.l.eLI), "", getString(R.l.eLG), getString(R.l.eLH), new 2(this), new 3(this));
        }
        return true;
    }

    private boolean brg() {
        com.tencent.mm.plugin.report.service.g.pQN.h(11545, new Object[]{Integer.valueOf(4)});
        x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.oaS == null) {
            this.oaS = View.inflate(this.mController.xIM, R.i.dsa, null);
            this.qlD = (CheckBox) this.oaS.findViewById(R.h.cMx);
            this.qlD.setChecked(true);
        }
        if (this.qlC == null) {
            this.qlC = h.a(this.mController.xIM, null, this.oaS, getString(R.l.etJ), getString(R.l.dEn), new 4(this), new OnClickListener(this) {
                final /* synthetic */ SettingsUI qlF;

                {
                    this.qlF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(11545, new Object[]{Integer.valueOf(5)});
                    x.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
                }
            });
        } else {
            this.qlC.show();
        }
        return true;
    }

    private void brh() {
        n CG = ar.CG();
        e 19 = new 19(this);
        this.qlz = 19;
        CG.a(282, 19);
        ar.CG().a(new u(), 0);
    }

    private void hQ(boolean z) {
        ae.Vd("welcome_page_show");
        if (z) {
            ar.getNotification().xb();
        } else {
            ar.getNotification().n(-1, null);
        }
        com.tencent.mm.sdk.b.b yVar = new y();
        yVar.fnQ.fnR = false;
        com.tencent.mm.sdk.b.a.xef.m(yVar);
        com.tencent.mm.plugin.setting.a.ift.up();
        ar.getNotification().wY();
        finish();
        if (com.tencent.mm.pluginsdk.q.a.vcr != null) {
            com.tencent.mm.pluginsdk.q.a.vcr.b(this.mController.xIM, z);
        }
    }

    private void bri() {
        n CG = ar.CG();
        e 20 = new 20(this);
        this.qid = 20;
        CG.a(255, 20);
        k xVar = new com.tencent.mm.modelsimple.x(2);
        xVar.hNL = 1;
        ar.CG().a(xVar, 0);
        this.qic = new ak(Looper.getMainLooper(), new 21(this, xVar), false);
        this.qic.J(3000, 3000);
        Context context = this.mController.xIM;
        getString(R.l.dGO);
        this.qib = h.a(context, getString(R.l.eYG), false, new 22(this, xVar));
    }
}
