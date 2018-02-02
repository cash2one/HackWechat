package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;

public class SettingsPersonalMoreUI extends MMPreference implements b {
    private int fWf = -1;
    private f ilB;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XB() {
        return R.o.fcr;
    }

    protected final void initView() {
        setMMTitle(R.l.eMk);
        this.ilB = this.yjd;
        ((DialogPreference) this.ilB.YN("settings_sex")).yia = new 1(this);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPersonalMoreUI qkp;

            {
                this.qkp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qkp.aWs();
                this.qkp.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        boolean z;
        boolean z2 = true;
        super.onResume();
        ar.Hg();
        DialogPreference dialogPreference = (DialogPreference) this.ilB.YN("settings_sex");
        switch (bh.a((Integer) c.CU().get(12290, null), 0)) {
            case 1:
                dialogPreference.setValue("male");
                break;
            case 2:
                dialogPreference.setValue("female");
                break;
            default:
                dialogPreference.setValue("unknown");
                break;
        }
        bi HQ = bi.HQ();
        this.ilB.YN("settings_district").setSummary(r.gw(bh.ou(HQ.getProvince())) + " " + bh.ou(HQ.getCity()));
        bqR();
        if ((q.Gd() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        String value = g.zY().getValue("LinkedinPluginClose");
        int i = (bh.ov(value) || Integer.valueOf(value).intValue() == 0) ? true : 0;
        if (!z || i == 0) {
            this.ilB.bk("settings_linkedin", true);
            return;
        }
        Preference YN = this.ilB.YN("settings_linkedin");
        ar.Hg();
        if (bh.ov((String) c.CU().get(286721, null))) {
            z2 = false;
        }
        if (!z2) {
            YN.setSummary(getString(R.l.eLC));
        } else if ((q.FW() & 4194304) == 0) {
            YN.setSummary(getString(R.l.eLD));
        } else {
            YN.setSummary(getString(R.l.eLE));
        }
    }

    public void onPause() {
        super.onPause();
        bi HQ = bi.HQ();
        if (this.fWf != -1) {
            HQ.fWf = this.fWf;
        }
        ar.Hg();
        c.EX().b(new a(1, bi.a(HQ)));
    }

    private void bqR() {
        Preference YN = this.ilB.YN("settings_signature");
        ar.Hg();
        CharSequence ou = bh.ou((String) c.CU().get(12291, null));
        if (ou.length() <= 0) {
            ou = getString(R.l.eMZ);
        }
        YN.setSummary(i.a(this, ou));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str.equals("settings_district")) {
            com.tencent.mm.plugin.setting.a.ifs.b(new Intent(), this.mController.xIM);
            return true;
        } else if (str.equals("settings_signature")) {
            startActivity(new Intent(this, EditSignatureUI.class));
            return true;
        } else if (!str.equals("settings_linkedin")) {
            return false;
        } else {
            Intent intent = new Intent();
            intent.putExtra("oversea_entry", true);
            d.b(this, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", intent);
            return true;
        }
    }

    public final void a(int i, m mVar, Object obj) {
        int o = bh.o(obj, 0);
        x.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(o), mVar});
        ar.Hg();
        if (mVar != c.CU() || o <= 0) {
            x.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(o), mVar});
        } else if (12291 == o) {
            bqR();
        }
    }
}
