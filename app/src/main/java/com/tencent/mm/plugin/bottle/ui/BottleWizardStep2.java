package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.bi;

public class BottleWizardStep2 extends MMPreference {
    private c kCr;

    public final int XB() {
        return R.o.fbk;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eMj);
        this.kCr = new c(this, this.yjd);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dFQ), new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep2 kCs;

            {
                this.kCs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                c.arM();
                bi HQ = bi.HQ();
                if (bh.a(Integer.valueOf(HQ.fWf), 0) <= 0) {
                    h.b(this.kCs.mController.xIM, this.kCs.getString(R.l.dMR), this.kCs.getString(R.l.dGO), true);
                } else if (bh.ov(HQ.getProvince())) {
                    h.b(this.kCs.mController.xIM, this.kCs.getString(R.l.dMQ), this.kCs.getString(R.l.dGO), true);
                } else {
                    Intent intent = new Intent().setClass(this.kCs, BottleBeachUI.class);
                    intent.addFlags(67108864);
                    this.kCs.startActivity(intent);
                    this.kCs.finish();
                }
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent().setClass(this, BottleWizardStep1.class);
        intent.addFlags(67108864);
        startActivity(intent);
        aWs();
        finish();
    }

    public void onResume() {
        super.onResume();
        this.kCr.update();
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str.equals("settings_district")) {
            return this.kCr.arO();
        }
        if (str.equals("settings_signature")) {
            return this.kCr.arN();
        }
        return false;
    }
}
