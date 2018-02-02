package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ay.l;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class SettingsNotificationUI extends MMPreference {
    private f ilB;
    private HashMap<Integer, Integer> kCm = new HashMap();
    private int status;

    static /* synthetic */ void vW(int i) {
        if (i == 1 || i == 0) {
            ar.Hg();
            c.CU().set(8200, Boolean.valueOf(true));
            if (i == 1) {
                ar.Hg();
                c.CU().set(8201, Integer.valueOf(22));
                ar.Hg();
                c.CU().set(8208, Integer.valueOf(8));
                ar.Hg();
                c.EX().b(new l(true, 22, 8));
                return;
            }
            ar.Hg();
            c.CU().set(8201, Integer.valueOf(0));
            ar.Hg();
            c.CU().set(8208, Integer.valueOf(0));
            ar.Hg();
            c.EX().b(new l(true, 0, 0));
            return;
        }
        ar.Hg();
        c.CU().set(8200, Boolean.valueOf(false));
        ar.Hg();
        c.EX().b(new l());
    }

    public final int XB() {
        return R.o.fcq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.status = q.FW();
        initView();
    }

    protected final void initView() {
        setMMTitle(R.l.eMe);
        this.ilB = this.yjd;
        this.ilB.removeAll();
        this.ilB.addPreferencesFromResource(R.o.fcq);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_new_msg_notification");
        if (com.tencent.mm.k.f.zo()) {
            checkBoxPreference.tSw = true;
        }
        hP(checkBoxPreference.isChecked());
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_new_voip_msg_notification");
        if (com.tencent.mm.k.f.zp()) {
            checkBoxPreference2.tSw = true;
        }
        if (checkBoxPreference.isChecked()) {
            checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_sound");
            if (com.tencent.mm.k.f.zr()) {
                checkBoxPreference.tSw = true;
                bqQ();
            } else {
                this.ilB.YO("settings_notification_ringtone");
            }
            checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_shake");
            if (com.tencent.mm.k.f.zt()) {
                checkBoxPreference.tSw = true;
            }
            checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_show_detail");
            if (com.tencent.mm.k.f.zq()) {
                checkBoxPreference.tSw = true;
            }
        } else {
            this.ilB.YO("settings_show_detail");
            this.ilB.YO("settings_sound");
            this.ilB.YO("settings_notification_ringtone");
            this.ilB.YO("settings_shake");
            this.ilB.YO("settings_active_time");
        }
        setBackBtn(new 1(this));
    }

    protected void onPause() {
        super.onPause();
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kCm.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            a wlVar = new wl();
            wlVar.wgL = intValue;
            wlVar.wgM = intValue2;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
            x.d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.kCm.clear();
    }

    public void onResume() {
        super.onResume();
        bqQ();
    }

    private void bqQ() {
        Preference YN = this.ilB.YN("settings_notification_ringtone");
        if (YN != null) {
            YN.setSummary(this.gZO.getString("settings.ringtone.name", getString(R.l.eMf)));
        }
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str.equals("settings_new_msg_notification")) {
            com.tencent.mm.k.f.bj(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                g.pQN.a(500, 0, 1, false);
            } else {
                g.pQN.a(500, 1, 1, false);
            }
            return hP(((CheckBoxPreference) preference).isChecked());
        } else if (str.equals("settings_new_voip_msg_notification")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.k.f.bk(true);
                g.pQN.a(500, 2, 1, false);
            } else {
                h.a(this.mController.xIM, false, this.mController.xIM.getString(R.l.eMc), "", this.mController.xIM.getString(R.l.eMb), this.mController.xIM.getString(R.l.eLH), new 2(this), new 3(this), R.e.brm, 0);
            }
            initView();
            return true;
        } else if (str.equals("settings_voip_notification_sound")) {
            r0 = ((CheckBoxPreference) preference).isChecked();
            ar.Hg();
            c.CU().set(73217, Boolean.valueOf(r0));
            ar.Hg();
            c.CU().set(73218, Boolean.valueOf(r0));
            g.pQN.a(500, r0 ? 8 : 9, 1, false);
            x.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", Boolean.valueOf(r0));
            return true;
        } else if (str.equals("settings_sound")) {
            com.tencent.mm.k.f.bn(((CheckBoxPreference) preference).isChecked());
            initView();
            if (((CheckBoxPreference) preference).isChecked()) {
                g.pQN.a(500, 10, 1, false);
            } else {
                g.pQN.a(500, 11, 1, false);
            }
            return true;
        } else if (str.equals("settings_shake")) {
            com.tencent.mm.k.f.bo(((CheckBoxPreference) preference).isChecked());
            bh.m(this, ((CheckBoxPreference) preference).isChecked());
            return true;
        } else if (str.equals("settings_show_detail")) {
            r0 = ((CheckBoxPreference) preference).isChecked();
            com.tencent.mm.k.f.bl(r0);
            r0 = !r0;
            x.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + r0 + " item value = 2048 functionId = 10");
            if (r0) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.kCm.put(Integer.valueOf(10), Integer.valueOf(r0 ? 1 : 2));
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.mController.xIM, SettingsRingtoneUI.class));
            return true;
        } else if (str.equals("settings_active_time")) {
            startActivity(new Intent(this, SettingsActiveTimeUI.class));
            return true;
        } else {
            if (str.equals("settings_plugings_notify")) {
                List linkedList = new LinkedList();
                linkedList.add(getString(R.l.eMo));
                linkedList.add(getString(R.l.eMp));
                linkedList.add(getString(R.l.eMn));
                Boolean valueOf = Boolean.valueOf(q.Go());
                int Gw = q.Gw();
                int Gx = q.Gx();
                int i = valueOf.booleanValue() ? Gw == Gx ? 0 : 1 : 2;
                x.d("MicroMsg.SettingsNotificationUI", valueOf + "st " + Gw + " ed " + Gx + "  state " + i);
                Context context = this.mController.xIM;
                String string = getString(R.l.eMr);
                getString(R.l.eMq);
                h.a(context, string, linkedList, i, new 4(this, i));
            }
            return false;
        }
    }

    private boolean hP(boolean z) {
        Preference YN = this.ilB.YN("settings_sound");
        Preference YN2 = this.ilB.YN("settings_shake");
        Preference YN3 = this.ilB.YN("settings_show_detail");
        if (YN != null) {
            YN.setEnabled(z);
        }
        if (YN2 != null) {
            YN2.setEnabled(z);
        }
        if (YN3 != null) {
            YN3.setEnabled(z);
        }
        return true;
    }
}
