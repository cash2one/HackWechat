package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ExdeviceSettingUI extends MMPreference implements e {
    int fDt = -1;
    private CheckBoxPreference lXA;
    private boolean lXB;
    private final String lXt = "notify_rank";
    private final String lXu = "notify_like";
    private final String lXv = "join_rank";
    boolean lXw;
    private ProgressDialog lXx;
    private CheckBoxPreference lXy;
    private CheckBoxPreference lXz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.pY(38);
        ar.CG().a(1044, this);
        this.lXy = (CheckBoxPreference) this.yjd.YN("notify_rank");
        this.lXz = (CheckBoxPreference) this.yjd.YN("notify_like");
        this.lXA = (CheckBoxPreference) this.yjd.YN("join_rank");
        ar.Hg();
        Integer num = (Integer) c.CU().get(397310, Integer.valueOf(0));
        x.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[]{num});
        if (num == null || num.intValue() == 0) {
            this.lXw = false;
            this.lXy.tSw = true;
            this.lXz.tSw = true;
            this.lXA.tSw = true;
            this.yjd.notifyDataSetChanged();
            this.lXx = r.show(this, "", "", true, false);
        } else {
            this.lXw = true;
            this.fDt = num.intValue();
            aFs();
        }
        ar.CG().a(new n(2, 0), 0);
        setMMTitle(R.l.eDA);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceSettingUI lXC;

            {
                this.lXC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXC.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(1044, this);
        if (this.lXx != null && this.lXx.isShowing()) {
            this.lXx.dismiss();
        }
        if (this.lXw) {
            if (this.lXy.isChecked()) {
                this.fDt |= 1;
            } else {
                this.fDt &= -2;
            }
            if (this.lXz.isChecked()) {
                this.fDt |= 2;
            } else {
                this.fDt &= -3;
            }
            if (this.lXA.isChecked()) {
                this.fDt |= 8;
            } else {
                this.fDt &= -9;
            }
            ar.Hg();
            c.CU().set(397310, Integer.valueOf(this.fDt));
            x.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[]{Integer.valueOf(this.fDt)});
            ar.CG().a(new n(1, this.fDt), 0);
        }
    }

    public final int XB() {
        return R.o.fbI;
    }

    private void aFs() {
        boolean z;
        boolean z2 = true;
        this.lXy.tSw = (this.fDt & 1) == 1;
        CheckBoxPreference checkBoxPreference = this.lXz;
        if ((this.fDt & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.tSw = z;
        CheckBoxPreference checkBoxPreference2 = this.lXA;
        if ((this.fDt & 8) != 8) {
            z2 = false;
        }
        checkBoxPreference2.tSw = z2;
        this.yjd.notifyDataSetChanged();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            n nVar = (n) kVar;
            if (nVar.opType != 2) {
                x.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[]{Integer.valueOf(nVar.opType)});
                return;
            }
            if (this.lXx != null && this.lXx.isShowing()) {
                runOnUiThread(new 2(this));
            }
            this.lXw = true;
            if (this.fDt == nVar.lPB) {
                x.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[]{Integer.valueOf(this.fDt)});
                return;
            }
            this.fDt = nVar.lPB;
            x.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[]{Integer.valueOf(this.fDt)});
            ar.Hg();
            c.CU().set(397310, Integer.valueOf(this.fDt));
            if (!this.lXB) {
                aFs();
                return;
            }
            return;
        }
        if (this.lXx != null && this.lXx.isShowing()) {
            runOnUiThread(new 3(this));
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[]{preference.ibD});
        if (preference.ibD.equals("black_contact_list")) {
            com.tencent.mm.bm.d.y(this, "sport", ".ui.SportBlackListUI");
        } else {
            this.lXB = true;
        }
        return false;
    }
}
