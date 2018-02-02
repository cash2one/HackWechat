package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import com.tencent.mm.R;
import com.tencent.mm.plugin.nearby.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;

public class NearbyPersonalInfoUI extends MMPreference {
    private int fWf = -1;
    private f ilB;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.exv);
        this.ilB = this.yjd;
        ((KeyValuePreference) this.ilB.YN("settings_signature")).yiT = false;
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dFQ), new 2(this));
        ((ChoicePreference) this.ilB.YN("settings_sex")).yia = new 3(this);
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.ilB.YN("settings_sex");
        choicePreference.setTitle(Html.fromHtml(getString(R.l.eMT) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                return;
            case 2:
                choicePreference.setValue("female");
                return;
            default:
                choicePreference.setValue("unknown");
                return;
        }
    }

    public void onResume() {
        bi HQ = bi.HQ();
        String province = HQ.getProvince();
        String city = HQ.getCity();
        Preference YN = this.ilB.YN("settings_district");
        YN.setSummary(r.gw(province) + " " + city);
        YN.setTitle(Html.fromHtml(getString(R.l.eLi) + "<font color='red'>*</font>"));
        Preference YN2 = this.ilB.YN("settings_signature");
        ar.Hg();
        CharSequence ou = bh.ou((String) c.CU().get(12291, null));
        if (ou.length() <= 0) {
            ou = getString(R.l.eMZ);
        }
        YN2.setSummary(i.a((Context) this, ou));
        super.onResume();
    }

    public final int XB() {
        return R.o.exv;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if ("settings_district".equals(str)) {
            a.ifs.b(null, this);
            return true;
        } else if (!"settings_signature".equals(str)) {
            return false;
        } else {
            a.ifs.c(null, this);
            overridePendingTransition(R.a.bqo, R.a.bqn);
            return true;
        }
    }
}
