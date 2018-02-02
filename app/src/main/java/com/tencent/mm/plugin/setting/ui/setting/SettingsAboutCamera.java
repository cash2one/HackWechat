package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SettingsAboutCamera extends MMPreference {
    private f ilB;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XB() {
        return R.o.fcl;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.ibD;
        if (str.equals("settings_auto_mul_terminal_sync")) {
            ar.Hg();
            boolean booleanValue = ((Boolean) c.CU().get(a.xtu, Boolean.valueOf(true))).booleanValue();
            ar.Hg();
            c.CU().a(a.xtu, Boolean.valueOf(!booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_photo")) {
            ar.Hg();
            booleanValue = ((Boolean) c.CU().get(a.xtw, Boolean.valueOf(true))).booleanValue();
            ar.Hg();
            t CU = c.CU();
            a aVar = a.xtw;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            CU.a(aVar, Boolean.valueOf(booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            ar.Hg();
            booleanValue = ((Boolean) c.CU().get(a.xtx, Boolean.valueOf(true))).booleanValue();
            ar.Hg();
            t CU2 = c.CU();
            a aVar2 = a.xtx;
            if (booleanValue) {
                z = false;
            }
            CU2.a(aVar2, Boolean.valueOf(z));
        }
        return false;
    }

    protected final void initView() {
        this.ilB = this.yjd;
        setMMTitle(R.l.eMl);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutCamera qhT;

            {
                this.qhT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qhT.aWs();
                this.qhT.finish();
                return true;
            }
        });
        ar.Hg();
        boolean booleanValue = ((Boolean) c.CU().get(a.xtu, Boolean.valueOf(true))).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_auto_mul_terminal_sync");
        checkBoxPreference.yjI = false;
        checkBoxPreference.tSw = booleanValue;
        ar.Hg();
        booleanValue = ((Boolean) c.CU().get(a.xtw, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_take_photo_auto_save_photo");
        checkBoxPreference.yjI = false;
        checkBoxPreference.tSw = booleanValue;
        ar.Hg();
        checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_take_photo_auto_save_video");
        checkBoxPreference.tSw = ((Boolean) c.CU().get(a.xtx, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference.yjI = false;
        this.ilB.notifyDataSetChanged();
    }
}
