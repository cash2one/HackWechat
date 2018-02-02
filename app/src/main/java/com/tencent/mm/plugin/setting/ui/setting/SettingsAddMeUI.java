package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.bh;
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
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsAddMeUI extends MMPreference {
    private f ilB;
    private HashMap<Integer, Integer> kCm = new HashMap();
    private long llS;
    private int qiR;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int XB() {
        return R.o.fce;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        this.qiR = q.FY();
        this.status = q.FW();
        this.llS = q.FX();
        initView();
    }

    public void onPause() {
        super.onPause();
        x.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qiR + ",status:" + this.status + ",extstatus:" + this.llS);
        ar.Hg();
        c.CU().set(7, Integer.valueOf(this.status));
        ar.Hg();
        c.CU().set(40, Integer.valueOf(this.qiR));
        ar.Hg();
        c.CU().set(147457, Long.valueOf(this.llS));
        for (Entry entry : this.kCm.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bq.a wlVar = new wl();
            wlVar.wgL = intValue;
            wlVar.wgM = intValue2;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
            x.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.kCm.clear();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.ibD;
        x.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.YN("settings_find_me_by_QQ")).isChecked();
            a(z2, 8, 2);
            a(z2, 16, 3);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            if (!((CheckBoxPreference) fVar.YN("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            x.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.qiR |= WXMediaMessage.TITLE_LENGTH_LIMIT;
            } else {
                this.qiR &= -513;
            }
            this.kCm.put(Integer.valueOf(25), Integer.valueOf(z ? 1 : 2));
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.YN("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            a(z, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.YN("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            a(z, SQLiteGlobal.journalSizeLimit, 30);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.YN("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            b(z, 1, 38);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.YN("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            b(z, 2, 39);
            return true;
        } else if (!str.equals("settings_add_me_by_namecard")) {
            return false;
        } else {
            if (!((CheckBoxPreference) fVar.YN("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            b(z, 4, 40);
            return true;
        }
    }

    private void a(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.kCm.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    private void b(boolean z, int i, int i2) {
        x.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.llS |= (long) i;
        } else {
            this.llS &= (long) (i ^ -1);
        }
        this.kCm.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    protected final void initView() {
        boolean z;
        setMMTitle(R.l.eKT);
        setBackBtn(new 1(this));
        x.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qiR + ",status:" + this.status + ",extstatus:" + this.llS);
        ar.Hg();
        Integer num = (Integer) c.CU().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_find_me_by_QQ");
        checkBoxPreference.yjI = false;
        if (num == null || num.intValue() == 0) {
            this.ilB.c(checkBoxPreference);
        } else {
            boolean z2 = (uR(8) && uR(16)) ? false : true;
            checkBoxPreference.tSw = z2;
        }
        ar.Hg();
        String str = (String) c.CU().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_find_me_by_mobile");
        checkBoxPreference.yjI = false;
        if (str == null || str.length() <= 0) {
            this.ilB.c(checkBoxPreference);
        } else {
            if (uR(WXMediaMessage.TITLE_LENGTH_LIMIT)) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.tSw = z2;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_find_me_by_weixin");
        checkBoxPreference2.yjI = false;
        if ((this.qiR & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            checkBoxPreference2.tSw = false;
        } else {
            checkBoxPreference2.tSw = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_find_me_by_google");
        if (uR(SQLiteGlobal.journalSizeLimit)) {
            z = false;
        } else {
            z = true;
        }
        checkBoxPreference2.tSw = z;
        checkBoxPreference2.yjI = false;
        ar.Hg();
        String str2 = (String) c.CU().get(208903, null);
        if (!bh.PT() || TextUtils.isEmpty(str2)) {
            this.ilB.c(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_add_me_by_chatroom");
        checkBoxPreference2.yjI = false;
        if ((this.llS & 1) != 0) {
            checkBoxPreference2.tSw = false;
        } else {
            checkBoxPreference2.tSw = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_add_me_by_qrcode");
        checkBoxPreference2.yjI = false;
        if ((this.llS & 2) != 0) {
            checkBoxPreference2.tSw = false;
        } else {
            checkBoxPreference2.tSw = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ilB.YN("settings_add_me_by_namecard");
        checkBoxPreference2.yjI = false;
        if ((this.llS & 4) != 0) {
            checkBoxPreference2.tSw = false;
        } else {
            checkBoxPreference2.tSw = true;
        }
        this.ilB.notifyDataSetChanged();
    }

    private boolean uR(int i) {
        return (this.status & i) != 0;
    }
}
