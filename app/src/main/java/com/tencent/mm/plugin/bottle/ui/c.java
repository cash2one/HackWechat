package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.r;

public final class c {
    private MMActivity fmM;
    private f ilB;

    public c(MMActivity mMActivity, f fVar) {
        this.fmM = mMActivity;
        this.ilB = fVar;
        ChoicePreference choicePreference = (ChoicePreference) this.ilB.YN("settings_sex");
        choicePreference.yia = new 1(this);
        choicePreference.setTitle(Html.fromHtml(this.fmM.getString(R.l.eMT) + "<font color='red'>*</font>"));
        ((KeyValuePreference) this.ilB.YN("settings_district")).setTitle(Html.fromHtml(this.fmM.getString(R.l.eLi) + "<font color='red'>*</font>"));
    }

    public static void arM() {
        bi HQ = bi.HQ();
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new a(1, bi.a(HQ)));
        com.tencent.mm.plugin.bottle.a.ift.um();
    }

    public final void update() {
        ar.Hg();
        ChoicePreference choicePreference = (ChoicePreference) this.ilB.YN("settings_sex");
        switch (bh.a((Integer) com.tencent.mm.z.c.CU().get(12290, null), 0)) {
            case 1:
                choicePreference.setValue("male");
                break;
            case 2:
                choicePreference.setValue("female");
                break;
            default:
                choicePreference.setValue("unknown");
                break;
        }
        bi HQ = bi.HQ();
        String province = HQ.getProvince();
        this.ilB.YN("settings_district").setSummary(r.gw(province) + " " + HQ.getCity());
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.ilB.YN("settings_signature");
        keyValuePreference.yiT = false;
        ar.Hg();
        CharSequence ou = bh.ou((String) com.tencent.mm.z.c.CU().get(12291, null));
        Context context = this.fmM;
        if (ou.length() <= 0) {
            ou = this.fmM.getString(R.l.eMZ);
        }
        keyValuePreference.setSummary(i.a(context, ou));
        this.ilB.notifyDataSetChanged();
    }

    public final boolean arN() {
        Intent intent = new Intent();
        intent.putExtra("persist_signature", false);
        com.tencent.mm.plugin.bottle.a.ifs.c(intent, this.fmM);
        return true;
    }

    public final boolean arO() {
        com.tencent.mm.plugin.bottle.a.ifs.b(new Intent(), this.fmM);
        return true;
    }
}
