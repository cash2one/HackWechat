package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class SettingsHideUsernameUI extends MMPreference {
    private f ilB;
    private boolean jAF;
    private long llS;
    private int qiR;
    private CheckBoxPreference qjt;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = q.FT();
        if (bh.ov(this.username)) {
            this.username = q.FS();
        }
        this.ilB = this.yjd;
        this.llS = q.FX();
        this.qiR = q.FY();
        initView();
        setBackBtn(new 1(this));
    }

    protected final void initView() {
        boolean z = true;
        setMMTitle(R.l.eNP);
        this.ilB.YN("settings_my_username").setSummary(this.username);
        boolean z2 = (this.llS & 16384) != 0;
        this.jAF = z2;
        x.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[]{Boolean.valueOf(z2)});
        this.qjt = (CheckBoxPreference) this.ilB.YN("settings_show_username");
        this.qjt.yjI = false;
        CheckBoxPreference checkBoxPreference = this.qjt;
        if (z2) {
            z = false;
        }
        checkBoxPreference.tSw = z;
        if (bh.ov(q.FU())) {
            this.qjt.setEnabled(false);
        }
        this.ilB.notifyDataSetChanged();
    }

    public final int XB() {
        return R.o.fcg;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (!preference.ibD.equals("settings_show_username")) {
            return false;
        }
        if (!((CheckBoxPreference) preference).isChecked()) {
            z = true;
        }
        this.jAF = z;
        bqH();
        return true;
    }

    private void bqH() {
        if (this.jAF) {
            this.qjt.setSummary(getString(R.l.eMW));
        } else if (this.qjt.isEnabled()) {
            this.qjt.setSummary(getString(R.l.eMU));
        } else {
            this.qjt.setSummary(getString(R.l.eMV));
        }
    }

    protected void onResume() {
        super.onResume();
        bqH();
    }

    protected void onPause() {
        boolean z = false;
        int i = 1;
        super.onPause();
        x.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[]{Boolean.valueOf(this.jAF)});
        if ((this.llS & 16384) != 0) {
            z = true;
        }
        if (z != this.jAF) {
            if (this.jAF) {
                this.llS |= 16384;
                this.qiR |= WXMediaMessage.TITLE_LENGTH_LIMIT;
            } else {
                this.llS &= -16385;
                this.qiR &= -513;
            }
            g.Dk();
            g.Dj().CU().set(147457, Long.valueOf(this.llS));
            g.Dk();
            g.Dj().CU().set(40, Integer.valueOf(this.qiR));
            a wlVar = new wl();
            wlVar.wgL = 46;
            if (this.jAF) {
                i = 2;
            }
            wlVar.wgM = i;
            ar.Hg();
            c.EX().b(new e.a(23, wlVar));
        }
    }
}
