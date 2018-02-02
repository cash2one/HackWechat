package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectArriveTimeUI extends MMPreference {
    private f ilB;
    private List<EnterTimeParcel> pJC;
    private List<Preference> pJD;
    private int pJE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.uaF)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a$f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.black));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.uaF));
        }
        BankRemitBaseUI.H(this);
        this.mController.contentView.setFitsSystemWindows(true);
        setMMTitle(i.uHQ);
        this.pJC = getIntent().getParcelableArrayListExtra("key_arrive_time_parcel_list");
        this.pJE = getIntent().getIntExtra("key_select_arrive_time", -1);
        initView();
        findViewById(16908298).setBackgroundColor(getResources().getColor(c.uaF));
        setBackBtn(new 1(this), h.dvO);
    }

    protected final void initView() {
        this.ilB = this.yjd;
        if (this.pJC != null && this.pJC.size() > 0) {
            this.pJD = new ArrayList();
            for (int i = 0; i < this.pJC.size(); i++) {
                EnterTimeParcel enterTimeParcel = (EnterTimeParcel) this.pJC.get(i);
                x.d("MicroMsg.BankRemitSelectArriveTimeUI", "enter scene: %d", Integer.valueOf(enterTimeParcel.pHx));
                Preference preference = new Preference(this);
                preference.setLayoutResource(g.uBf);
                preference.yjI = false;
                preference.setKey(enterTimeParcel.pHx);
                preference.setTitle(enterTimeParcel.pHy);
                if (enterTimeParcel.pHx == this.pJE) {
                    preference.setWidgetLayoutResource(g.dnZ);
                } else {
                    preference.setWidgetLayoutResource(g.doa);
                }
                if (enterTimeParcel.pHA == 0) {
                    if (!bh.ov(enterTimeParcel.pHz)) {
                        preference.setSummary(enterTimeParcel.pHz);
                    }
                    preference.setEnabled(false);
                }
                preference.getExtras().putParcelable("arrive_time", enterTimeParcel);
                this.ilB.a(preference);
                this.pJD.add(preference);
            }
        }
    }

    public final int XB() {
        return g.uBg;
    }

    public final boolean a(f fVar, Preference preference) {
        for (Preference preference2 : this.pJD) {
            if (preference2 == preference) {
                preference2.setWidgetLayoutResource(g.dnZ);
            } else {
                preference2.setWidgetLayoutResource(g.doa);
            }
        }
        this.ilB.notifyDataSetChanged();
        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) preference.getExtras().getParcelable("arrive_time");
        if (enterTimeParcel == null) {
            x.i("MicroMsg.BankRemitSelectArriveTimeUI", "is header");
        } else {
            Intent intent = new Intent();
            intent.putExtra("key_enter_time_scene", enterTimeParcel.pHx);
            setResult(-1, intent);
            finish();
        }
        return false;
    }
}
