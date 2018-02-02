package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ay.n;
import com.tencent.mm.g.a.pf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.pluginsdk.q.k;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONObject;

public class SettingsManageFindMoreUI extends MMPreference {
    private HashMap<Integer, Integer> kCm = new HashMap();
    private long llS;
    private int qjL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.llS = q.FX();
        this.qjL = q.Gd();
        x.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", Long.valueOf(this.llS), Integer.valueOf(this.qjL));
        initView();
    }

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int XB() {
        return R.o.fcn;
    }

    public final boolean a(f fVar, Preference preference) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
        String str = preference.ibD;
        x.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", str);
        if (str.equals("settings_sns_switch")) {
            s(checkBoxPreference.isChecked(), WXMediaMessage.THUMB_LENGTH_LIMIT);
            SharedPreferences sharedPreferences = getSharedPreferences(ac.cfs(), 0);
            str = sharedPreferences.getString(q.FS() + "_sns_entrance_disappear", "");
            if (!bh.ov(str) && str.startsWith("on")) {
                if (checkBoxPreference.isChecked() && str.equals("on_close")) {
                    str = "on";
                }
                if (!checkBoxPreference.isChecked() && r1.equals("on")) {
                    str = "on_close";
                }
                sharedPreferences.edit().putString(q.FS() + "_sns_entrance_disappear", str).commit();
            }
        } else if (str.equals("settings_scan_switch")) {
            b(checkBoxPreference.isChecked(), 1048576, 49);
        } else if (str.equals("settings_search_switch")) {
            b(checkBoxPreference.isChecked(), 2097152, 50);
        } else if (str.equals("settings_shopping_switch")) {
            b(checkBoxPreference.isChecked(), 4194304, 51);
        } else if (str.equals("settings_game_switch")) {
            b(checkBoxPreference.isChecked(), 8388608, 52);
        } else if (str.equals("settings_miniprogram_switch")) {
            b(checkBoxPreference.isChecked(), 16777216, 53);
        } else if (str.equals("settings_wechatout_switch")) {
            b(checkBoxPreference.isChecked(), 33554432, 54);
        } else if (str.equals("settings_shake_switch")) {
            s(checkBoxPreference.isChecked(), 256);
        } else if (str.equals("settings_nearby_switch")) {
            s(checkBoxPreference.isChecked(), WXMediaMessage.TITLE_LENGTH_LIMIT);
        } else if (str.equals("settings_bottle_switch")) {
            s(checkBoxPreference.isChecked(), 64);
        } else if (str.equals("settings_look_switch")) {
            ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).aV("labs_browse", checkBoxPreference.isChecked());
        }
        return true;
    }

    protected final void initView() {
        boolean z;
        String value;
        setMMTitle(R.l.eLJ);
        setBackBtn(new 1(this));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_sns_switch");
        checkBoxPreference.yjI = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", Boolean.valueOf(vV(WXMediaMessage.THUMB_LENGTH_LIMIT)));
        if (vV(WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            checkBoxPreference.tSw = true;
        } else {
            checkBoxPreference.tSw = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_scan_switch");
        checkBoxPreference.yjI = false;
        if (vU(1048576)) {
            checkBoxPreference.tSw = false;
        } else {
            checkBoxPreference.tSw = true;
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_shake_switch");
        checkBoxPreference.yjI = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", Boolean.valueOf(vV(256)));
        if (vV(256)) {
            checkBoxPreference.tSw = true;
        } else {
            checkBoxPreference.tSw = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_look_switch");
        checkBoxPreference.yjI = false;
        JSONObject NT = com.tencent.mm.plugin.aj.a.h.NT("discoverRecommendEntry");
        boolean QC = ((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QC("labs_browse");
        if (QC) {
            if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QA("labs_browse")) {
                z = true;
            }
            z = false;
        } else {
            if (NT.optInt("entrySwitch") == 1) {
                z = true;
            }
            z = false;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", Boolean.valueOf(QC), Boolean.valueOf(z));
        if (z) {
            checkBoxPreference.tSw = true;
        } else if (QC) {
            this.yjd.bk("settings_look_switch", false);
            checkBoxPreference.tSw = false;
        } else {
            this.yjd.bk("settings_look_switch", true);
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_search_switch");
        checkBoxPreference.yjI = false;
        if (vU(2097152)) {
            checkBoxPreference.tSw = false;
        } else {
            checkBoxPreference.tSw = true;
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_nearby_switch");
        checkBoxPreference.yjI = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", Boolean.valueOf(vV(WXMediaMessage.TITLE_LENGTH_LIMIT)));
        if (vV(WXMediaMessage.TITLE_LENGTH_LIMIT)) {
            checkBoxPreference.tSw = true;
        } else {
            checkBoxPreference.tSw = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_bottle_switch");
        checkBoxPreference.yjI = false;
        x.i("MicroMsg.SettingsManageFindMoreUI", "openFloatBottle %s", Boolean.valueOf(vV(64)));
        if (vV(64)) {
            checkBoxPreference.tSw = true;
        } else {
            checkBoxPreference.tSw = false;
        }
        if (w.cff()) {
            value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigName");
        } else if (w.cfg()) {
            value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigIconUrl");
        String str = null;
        k kVar = z.vcD;
        if (kVar != null) {
            str = kVar.bDX();
        }
        if (bh.G(value, value2, str)) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", Boolean.valueOf(z));
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_shopping_switch");
        checkBoxPreference.yjI = false;
        if (z) {
            this.yjd.bk("settings_shopping_switch", false);
        } else {
            this.yjd.bk("settings_shopping_switch", true);
        }
        if (vU(4194304)) {
            checkBoxPreference.tSw = false;
        } else {
            checkBoxPreference.tSw = true;
        }
        j jVar = com.tencent.mm.pluginsdk.q.a.vcu;
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_game_switch");
        checkBoxPreference.yjI = false;
        if (jVar == null || !jVar.aRk()) {
            this.yjd.bk("settings_game_switch", true);
        } else if (vU(8388608)) {
            checkBoxPreference.tSw = false;
        } else {
            checkBoxPreference.tSw = true;
        }
        b pfVar = new pf();
        pfVar.fGZ.fHb = true;
        com.tencent.mm.sdk.b.a.xef.m(pfVar);
        x.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", Boolean.valueOf(pfVar.fHa.fHc));
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_miniprogram_switch");
        checkBoxPreference.yjI = false;
        if (!pfVar.fHa.fHc) {
            this.yjd.bk("settings_miniprogram_switch", true);
        } else if (vU(16777216)) {
            checkBoxPreference.tSw = false;
        } else {
            checkBoxPreference.tSw = true;
        }
        checkBoxPreference = (CheckBoxPreference) this.yjd.YN("settings_wechatout_switch");
        x.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", Boolean.valueOf(d.aTd()));
        if (d.aTd()) {
            checkBoxPreference.yjI = false;
            if (vU(33554432)) {
                checkBoxPreference.tSw = false;
            } else {
                checkBoxPreference.tSw = true;
            }
        } else {
            this.yjd.bk("settings_wechatout_switch", true);
        }
        this.yjd.notifyDataSetChanged();
    }

    private void b(boolean z, int i, int i2) {
        x.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.llS &= (long) (i ^ -1);
        } else {
            this.llS |= (long) i;
        }
        this.kCm.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    public void finish() {
        super.finish();
        x.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.llS + ",pluginFlag:" + this.qjL);
        ar.Hg();
        c.CU().set(147457, Long.valueOf(this.llS));
        ar.Hg();
        c.CU().set(34, Integer.valueOf(this.qjL));
        for (Entry entry : this.kCm.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = intValue;
            wlVar.wgM = intValue2;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
            x.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + intValue + " " + intValue2);
        }
        this.kCm.clear();
        ar.Hg();
        c.EX().b(new n("", "", "", "", "", "", "", "", this.qjL, "", ""));
    }

    private boolean vU(int i) {
        return (this.llS & ((long) i)) != 0;
    }

    private boolean vV(int i) {
        return (this.qjL & i) == 0;
    }

    private void s(boolean z, int i) {
        x.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            this.qjL &= i ^ -1;
        } else {
            this.qjL |= i;
        }
    }
}
