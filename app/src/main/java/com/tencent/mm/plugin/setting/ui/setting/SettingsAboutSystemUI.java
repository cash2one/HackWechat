package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.h.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SettingsAboutSystemUI extends MMPreference {
    private f ilB;
    private boolean isDeleteCancel = false;
    private ProgressDialog qib = null;
    private boolean qij = false;
    private int qik = -1;
    private int qil = -1;
    private boolean qim = false;

    public final int XB() {
        return R.o.fcu;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qij = false;
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eKP);
        this.ilB = this.yjd;
        setBackBtn(new 1(this));
        this.ilB.bk("settings_swipeback_mode", !d.fM(19));
        if (!com.tencent.mm.bm.d.OQ("backup")) {
            this.ilB.bk("settings_bak_chat", true);
        }
        bqy();
        this.ilB.bk("settings_traffic_statistic", com.tencent.mm.bm.d.ccW());
        if (r.ien) {
            this.ilB.bk("settings_take_photo", true);
        }
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            ar.Hg();
            checkBoxPreference.tSw = ((Boolean) c.CU().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.yjI = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_enter_button_send");
        if (checkBoxPreference != null) {
            ar.Hg();
            checkBoxPreference.tSw = ((Boolean) c.CU().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.yjI = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.tSw = a.zc();
            checkBoxPreference.yjI = false;
        }
        Preference YN = this.ilB.YN("settings_language");
        if (YN != null) {
            YN.setSummary(w.g(this.mController.xIM, R.c.bqS, R.l.dFv));
        }
        bqy();
        bqB();
        bqB();
        bqA();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.ilB.bk("settings_nfc_switch", true);
            return;
        }
        this.ilB.bk("settings_nfc_switch", false);
        ar.Hg();
        checkBoxPreference.setSummary(bh.ou((String) c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, null)));
        if (this.qij) {
            x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                ha(true);
                hM(true);
                return;
            }
        }
        ar.Hg();
        int intValue = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            ar.Hg();
            if (((Integer) c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
                hM(true);
            } else {
                hM(false);
            }
        } else if (intValue == 1) {
            hM(true);
        } else {
            hM(false);
        }
        this.ilB.notifyDataSetChanged();
    }

    protected void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.qim) {
            boolean z2;
            String str = "MicroMsg.SettingsAboutSystemUI";
            String str2 = "kvstat, autodownload sight change: %d, %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.qil);
            if (this.qik == this.qil) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            g gVar = g.pQN;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.qil);
            if (this.qik != this.qil) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            gVar.h(11437, objArr2);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.ibD;
        if (str.equals("settings_landscape_mode")) {
            if (this.gZO.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
                return true;
            }
            setRequestedOrientation(1);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (this.gZO.getBoolean("settings_voicerecorder_mode", q.gFV.gCO != 1)) {
                return true;
            }
            h.a(this.mController.xIM, R.l.eNT, R.l.dGO, new 8(this), new 9(this));
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                x.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
                return true;
            }
            ar.Hg();
            r2 = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            ar.Hg();
            int intValue = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
            if ((r2 == 2 || (r2 == 0 && intValue != 1)) && !defaultAdapter.isEnabled() && this.gZO.getBoolean("settings_nfc_switch", false)) {
                hM(false);
                h.a(this.mController.xIM, getString(R.l.exR), "", getString(R.l.exS), getString(R.l.dEn), new 6(this), new 7(this));
                return true;
            }
            ha(this.gZO.getBoolean("settings_nfc_switch", false));
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            ar.Hg();
            r1 = ((Boolean) c.CU().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(r1);
            objArr[1] = Boolean.valueOf(!r1);
            x.d(str2, str3, objArr);
            ar.Hg();
            t CU = c.CU();
            if (!r1) {
                z = true;
            }
            CU.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            x.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
            ar.Hg();
            c.CU().set(66832, Boolean.valueOf(r0));
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            r9 = new i.a(this.mController.xIM);
            r9.ED(R.l.dEn);
            r9.Ez(R.l.eNf);
            View inflate = View.inflate(this.mController.xIM, R.i.dno, null);
            r1 = (LinearLayout) inflate.findViewById(R.h.cPW);
            r2 = bh.getInt(com.tencent.mm.k.g.zY().getValue("SIGHTAutoLoadNetwork"), 1);
            ar.Hg();
            int a = bh.a((Integer) c.CU().get(327686, null), r2);
            r5 = new 2(this, r1, a);
            a(r1, R.l.eNd, 1, 1 == a, r5);
            a(r1, R.l.eNg, 2, 2 == a, r5);
            a(r1, R.l.eNe, 3, 3 == a, r5);
            r9.dk(inflate);
            r0 = r9.akx();
            r1.setTag(r0);
            r0.show();
            addDialog(r0);
            this.qim = true;
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            r9 = new i.a(this.mController.xIM);
            r9.ED(R.l.dEn);
            r9.Ez(R.l.eNa);
            View inflate2 = View.inflate(this.mController.xIM, R.i.dno, null);
            r1 = (LinearLayout) inflate2.findViewById(R.h.cPW);
            r5 = new 10(this, r1);
            ar.Hg();
            boolean z2 = (((Integer) c.CU().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            a(r1, R.l.eNc, 0, z2, r5);
            a(r1, R.l.eNb, 1, !z2, r5);
            r9.dk(inflate2);
            r0 = r9.akx();
            r1.setTag(r0);
            r0.show();
            addDialog(r0);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.mController.xIM, SettingsLanguageUI.class));
            return true;
        } else if (str.equals("settings_text_size")) {
            return bqz();
        } else {
            Intent intent;
            if (str.equals("settings_chatting_bg")) {
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.xIM.startActivity(intent);
                return true;
            } else if (str.equals("settings_manage_findmoreui")) {
                intent = new Intent();
                intent.setClass(this, SettingsManageFindMoreUI.class);
                startActivity(intent);
                return true;
            } else if (str.equals("settings_plugins")) {
                ar.Hg();
                c.CU().set(-2046825377, Boolean.valueOf(false));
                intent = new Intent();
                intent.setClass(this, SettingsPluginsUI.class);
                startActivity(intent);
                com.tencent.mm.s.c.Bq().aS(262158, 266266);
                return true;
            } else if (str.equals("settings_reset")) {
                h.a(this.mController.xIM, getResources().getString(R.l.eMP), "", getString(R.l.dEo), getString(R.l.dEn), new 5(this), null);
                return true;
            } else if (str.equals("settings_emoji_manager")) {
                intent = new Intent();
                intent.putExtra("10931", 2);
                com.tencent.mm.bm.d.b(this.mController.xIM, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            } else if (str.equals("settngs_clean")) {
                ar.Hg();
                if (c.isSDCardAvailable()) {
                    com.tencent.mm.bm.d.b(this.mController.xIM, "clean", ".ui.CleanUI", new Intent());
                    return true;
                }
                u.fI(this.mController.xIM);
                return true;
            } else if (str.equals("settings_traffic_statistic")) {
                startActivity(new Intent(this, SettingsNetStatUI.class));
                return true;
            } else if (str.equals("settings_text_size")) {
                return bqz();
            } else {
                if (str.equals("settings_swipeback_mode")) {
                    CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                    r1 = a.zc();
                    h.a(this.mController.xIM, getString(!r1 ? R.l.eNi : R.l.eNh), null, new 3(this), new 4(this, checkBoxPreference2, r1));
                    return true;
                }
                if (str.equals("settings_take_photo")) {
                    startActivity(new Intent(this, SettingsAboutCamera.class));
                }
                return false;
            }
        }
    }

    private void bqy() {
        int i;
        int i2 = 0;
        IconPreference iconPreference = (IconPreference) this.ilB.YN("settings_plugins");
        ar.Hg();
        if (bh.a((Boolean) c.CU().get(-2046825377, null), false)) {
            iconPreference.EX(0);
            iconPreference.dh(getString(R.l.dFP), R.g.bEf);
        } else {
            iconPreference.EX(8);
            iconPreference.dh("", -1);
        }
        if (com.tencent.mm.s.c.Bq().aR(262158, 266266)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.EZ(i);
        if (!com.tencent.mm.plugin.x.a.bfo().ig(b.hId)) {
            i2 = 8;
        }
        iconPreference.EZ(i2);
        this.ilB.notifyDataSetChanged();
    }

    private boolean bqz() {
        startActivity(new Intent(this, SettingsFontUI.class));
        return true;
    }

    private void ha(boolean z) {
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(ac.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            ar.Hg();
            c.CU().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(1));
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(ac.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        ar.Hg();
        c.CU().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(2));
    }

    private void hM(boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_nfc_switch");
        ac.getContext().getSharedPreferences(ac.cfs(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.tSw = z;
        this.ilB.notifyDataSetChanged();
    }

    private void bqA() {
        boolean z = true;
        boolean z2 = bh.VI(com.tencent.mm.k.g.zY().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((com.tencent.mm.sdk.platformtools.f.fdU & 1) != 0) {
            x.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.ilB.bk("settings_silence_update_mode", true);
            return;
        }
        this.ilB.bk("settings_silence_update_mode", false);
        ar.Hg();
        if ((((Integer) c.CU().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.ilB.YN("settings_silence_update_mode").setSummary(getString(z ? R.l.eNc : R.l.eNb));
        this.ilB.notifyDataSetChanged();
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.mController.xIM, R.i.dpW, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dAr, 0, 0, 0);
        }
    }

    private void bqB() {
        int i = bh.getInt(com.tencent.mm.k.g.zY().getValue("SIGHTAutoLoadNetwork"), 1);
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(327686, null), i);
        x.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", Integer.valueOf(i), Integer.valueOf(a));
        if (this.qik == -1) {
            this.qik = a;
        }
        this.qil = a;
        if (3 == a) {
            a = R.l.eNe;
        } else if (2 == a) {
            a = R.l.eNg;
        } else {
            a = R.l.eNd;
        }
        Preference YN = this.ilB.YN("settings_sns_sight_auto_download");
        if (!(YN == null || a == 0)) {
            YN.setSummary(getString(a));
        }
        this.ilB.notifyDataSetChanged();
    }
}
