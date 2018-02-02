package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class SettingsAboutTimelineUI extends MMPreference {
    private String gze = "";
    private f ilB;
    private boolean qix = false;
    private boolean qiy = false;

    public final int XB() {
        return R.o.fcd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        bla com_tencent_mm_protocal_c_bla = new bla();
        if (n.qQz != null) {
            com_tencent_mm_protocal_c_bla = n.qQz.Jz(this.gze);
        }
        if (com_tencent_mm_protocal_c_bla == null) {
            x.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i = com_tencent_mm_protocal_c_bla.wOs;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.qiy = (i & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (this.qiy) {
                    checkBoxPreference.tSw = false;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                } else {
                    checkBoxPreference.tSw = true;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                }
            }
        }
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str.equals("timline_outside_permiss")) {
            Intent intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            d.b(this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            d.b(this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            this.qiy = !this.qiy;
            if (n.qQz != null) {
                n.qQz.aC(this.gze, this.qiy);
            }
            this.qix = true;
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.qix && n.qQz != null) {
            a aD = n.qQz.aD(this.gze, this.qiy);
            if (aD != null) {
                x.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + aD.toString());
                ar.Hg();
                c.EX().b(new e.a(51, aD));
            }
        }
    }

    protected final void initView() {
        this.ilB = this.yjd;
        setMMTitle(R.l.eMm);
        setBackBtn(new 1(this));
        this.gze = q.FS();
    }
}
