package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.smtt.sdk.WebView;

public class FtsBrowseHistorySettingsUI extends MMPreference {
    private f ilB;
    private b jKr = null;
    private d tDG = new com.tencent.mm.plugin.webview.ui.tools.fts.a.b();

    public final int XB() {
        return R.o.fbM;
    }

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.jKr = new b(this);
            this.jKr.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.jKr);
            getSwipeBackLayout().Iv = this.jKr;
        }
        a.d(this.mController.contentView, getResources().getColor(R.e.btP), true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackGroundColorResource(R.e.btP);
        initView();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("settings_record");
        ar.Hg();
        Object obj = c.CU().get(91, Boolean.valueOf(false));
        if (obj == null || !((Boolean) obj).booleanValue()) {
            checkBoxPreference.tSw = false;
        } else {
            checkBoxPreference.tSw = true;
        }
        cmV();
        nR(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.btP));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.btP)));
        }
    }

    protected final void initView() {
        setMMTitle(R.l.eko);
        this.ilB = this.yjd;
        setBackBtn(new 1(this));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.FtsBrowseHistorySettingsUI", str + " item has been clicked!");
        if ("settings_record".equals(str)) {
            if (((CheckBoxPreference) preference).isChecked()) {
                ar.Hg();
                c.CU().set(91, Boolean.valueOf(true));
            } else {
                ar.Hg();
                c.CU().set(91, Boolean.valueOf(false));
            }
        } else if ("settings_clear".equals(str)) {
            setResult(1);
            this.tDG.bUc();
            g.pQN.h(14963, new Object[]{Integer.valueOf(4)});
        }
        return true;
    }
}
