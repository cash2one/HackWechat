package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ay.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f ilB;
    private int state;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        bqS();
    }

    public final int XB() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str.equals("settings_plugings_disturb_on")) {
            vX(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            vX(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            vX(2);
        }
        return false;
    }

    private void bqS() {
        this.ilB.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle(R.l.eMo);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(R.i.dnt);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(R.i.dnZ);
        } else {
            preference.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eMp);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(R.i.dnt);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(R.i.dnZ);
        } else {
            preference.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eMn);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(R.i.dnt);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(R.i.dnZ);
        } else {
            preference.setWidgetLayoutResource(R.i.doa);
        }
        this.ilB.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eMq);
        preference.setLayoutResource(R.i.dnW);
        this.ilB.a(preference);
        this.ilB.notifyDataSetChanged();
    }

    private void vX(int i) {
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            ar.Hg();
            c.CU().set(8200, Boolean.valueOf(true));
            if (this.state == 1) {
                ar.Hg();
                c.CU().set(8201, Integer.valueOf(22));
                ar.Hg();
                c.CU().set(8208, Integer.valueOf(8));
                ar.Hg();
                c.EX().b(new l(true, 22, 8));
            } else {
                ar.Hg();
                c.CU().set(8201, Integer.valueOf(0));
                ar.Hg();
                c.CU().set(8208, Integer.valueOf(0));
                ar.Hg();
                c.EX().b(new l(true, 0, 0));
            }
        } else {
            ar.Hg();
            c.CU().set(8200, Boolean.valueOf(false));
            ar.Hg();
            c.EX().b(new l());
        }
        bqS();
    }

    protected final void initView() {
        Boolean valueOf = Boolean.valueOf(q.Go());
        int Gw = q.Gw();
        int Gx = q.Gx();
        if (valueOf.booleanValue()) {
            this.state = Gw == Gx ? 0 : 1;
        } else {
            this.state = 2;
        }
        x.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + Gw + " ed " + Gx + "  state " + this.state);
        this.state = this.state;
        this.ilB = this.yjd;
        setMMTitle(R.l.eMr);
        setBackBtn(new 1(this));
    }
}
