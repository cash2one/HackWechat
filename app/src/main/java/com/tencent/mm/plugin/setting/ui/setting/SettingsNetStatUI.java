package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI extends MMPreference {
    private f ilB;
    private long period;

    public final int XB() {
        return R.o.fcp;
    }

    protected final boolean XA() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        super.onResume();
        bqP();
    }

    protected final void initView() {
        setMMTitle(R.l.eNw);
        m Tg = q.Tg();
        int cgs = (int) (bh.cgs() / 86400000);
        if (Tg.iz(cgs) == null) {
            k kVar = new k();
            kVar.hRC = cgs;
            kVar.id = -1;
            Tg.b(kVar);
        }
        this.ilB = this.yjd;
        this.period = q.Tg().SX();
        Preference YN = this.ilB.YN("settings_netstat_info");
        String format = new SimpleDateFormat(getString(R.l.eiK), Locale.US).format(new Date(this.period));
        YN.setTitle(getString(R.l.eNv, new Object[]{format}));
        x.i("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        x.d("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.eNx), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNetStatUI qkl;

            {
                this.qkl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(this.qkl.mController.xIM, R.l.eNy, R.l.eNz, new 3(this.qkl), new 4(this.qkl));
                return true;
            }
        });
    }

    private void bqP() {
        k iA = q.Tg().iA((int) (this.period / 86400000));
        if (iA == null) {
            iA = new k();
        }
        this.period = q.Tg().SX();
        Preference YN = this.ilB.YN("settings_netstat_info");
        String charSequence = DateFormat.format(getString(R.l.eiK, new Object[]{""}), this.period).toString();
        YN.setTitle(getString(R.l.eNv, new Object[]{charSequence}));
        YN = this.ilB.YN("settings_netstat_mobile");
        x.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[]{Integer.valueOf(iA.hRX), Integer.valueOf(iA.hRL)});
        YN.setSummary(j(this, ((long) iA.hRX) + ((long) iA.hRL)));
        YN = this.ilB.YN("settings_netstat_wifi");
        x.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[]{Integer.valueOf(iA.hRY), Integer.valueOf(iA.hRM)});
        YN.setSummary(j(this, ((long) iA.hRY) + ((long) iA.hRM)));
        ((NetStatPreference) this.ilB.YN("settings_netstat_mobile_detail")).qhd = false;
        ((NetStatPreference) this.ilB.YN("settings_netstat_wifi_detail")).qhd = true;
        this.ilB.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private static String j(Context context, long j) {
        return context.getString(R.l.eNu, new Object[]{bh.bx(j)});
    }
}
