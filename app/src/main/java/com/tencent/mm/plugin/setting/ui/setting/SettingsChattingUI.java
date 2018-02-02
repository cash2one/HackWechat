package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.l;
import java.util.List;

public class SettingsChattingUI extends MMPreference {
    private f ilB;
    private boolean isDeleteCancel = false;
    private ProgressDialog qib = null;

    static /* synthetic */ void b(SettingsChattingUI settingsChattingUI) {
        ar.Hg();
        List ciF = c.Fd().ciF();
        if (ciF.size() > 0) {
            List A = l.A(ciF);
            if (A != null) {
                for (int i = 0; i < A.size(); i++) {
                    if (((Boolean) A.get(i)).booleanValue()) {
                        a.ift.cB((String) ciF.get(i));
                    }
                }
            }
        }
        ba.a(new 3(settingsChattingUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (g.Dh().Cy()) {
            initView();
        } else {
            finish();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.eLa);
        this.ilB = this.yjd;
        if (g.Dj().CU().getInt(89, 0) != 2) {
            this.ilB.YO("settings_recovery");
        }
        setBackBtn(new 1(this));
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
        Preference YN = this.ilB.YN("settings_text_size");
        if (YN != null) {
            YN.setSummary(getString(SetTextSizeUI.du(this)));
        }
        this.ilB.notifyDataSetChanged();
    }

    public final int XB() {
        return R.o.fcm;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.ibD;
        boolean z2 = true;
        switch (str.hashCode()) {
            case -1776646462:
                if (str.equals("settings_chatting_bg")) {
                    z2 = true;
                    break;
                }
                break;
            case -1565531065:
                if (str.equals("settings_bak_chat")) {
                    z2 = true;
                    break;
                }
                break;
            case -1550690765:
                if (str.equals("settings_reset")) {
                    z2 = true;
                    break;
                }
                break;
            case -1439483675:
                if (str.equals("settings_voice_play_mode")) {
                    z2 = false;
                    break;
                }
                break;
            case -409015247:
                if (str.equals("settings_recovery")) {
                    z2 = true;
                    break;
                }
                break;
            case 624882802:
                if (str.equals("settings_enter_button_send")) {
                    z2 = true;
                    break;
                }
                break;
            case 1789437336:
                if (str.equals("settings_emoji_manager")) {
                    z2 = true;
                    break;
                }
                break;
        }
        Intent intent;
        switch (z2) {
            case false:
                ar.Hg();
                boolean booleanValue = ((Boolean) c.CU().get(26, Boolean.valueOf(false))).booleanValue();
                String str2 = "MicroMsg.SettingsChattingUI";
                String str3 = "set voice mode from %B to %B";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(booleanValue);
                objArr[1] = Boolean.valueOf(!booleanValue);
                x.d(str2, str3, objArr);
                ar.Hg();
                t CU = c.CU();
                if (!booleanValue) {
                    z = true;
                }
                CU.set(26, Boolean.valueOf(z));
                return true;
            case true:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_enter_button_send");
                if (checkBoxPreference == null) {
                    return true;
                }
                x.d("MicroMsg.SettingsChattingUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
                ar.Hg();
                c.CU().set(66832, Boolean.valueOf(z2));
                return true;
            case true:
                MMWizardActivity.A(this.mController.xIM, new Intent().setClassName(this.mController.xIM, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI"));
                return true;
            case true:
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.mController.xIM.startActivity(intent);
                return true;
            case true:
                intent = new Intent();
                intent.putExtra("10931", 2);
                d.b(this.mController.xIM, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            case true:
                h.a(this.mController.xIM, getResources().getString(R.l.eMP), "", getString(R.l.dEo), getString(R.l.dEn), new 2(this), null);
                return true;
            case true:
                intent = new Intent().setClassName(this.mController.xIM, "com.tencent.mm.plugin.dbbackup.DBRecoveryUI");
                intent.putExtra("scene", 1);
                this.mController.xIM.startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
