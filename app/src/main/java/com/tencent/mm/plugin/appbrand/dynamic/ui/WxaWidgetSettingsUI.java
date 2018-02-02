package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int fvM;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(e.kho);
        this.appId = getIntent().getStringExtra("app_id");
        this.fvM = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.kgS);
        DebuggerInfo rr = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.rr(this.appId);
        boolean z2 = rr != null && rr.iST;
        mMSwitchBtn.nB(z2);
        mMSwitchBtn.zvp = new a(this) {
            final /* synthetic */ WxaWidgetSettingsUI iVk;

            {
                this.iVk = r1;
            }

            public final void cw(boolean z) {
                DebuggerInfo rr = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.rr(this.iVk.appId);
                if (rr == null) {
                    rr = new DebuggerInfo();
                    com.tencent.mm.plugin.appbrand.dynamic.debugger.b.a(this.iVk.appId, rr);
                }
                rr.iST = z;
            }
        };
        mMSwitchBtn = (MMSwitchBtn) findViewById(b.kgG);
        if ((rr != null && rr.iSR) || d$a.hf(this.fvM)) {
            z = true;
        }
        mMSwitchBtn.nB(z);
        mMSwitchBtn.setEnabled(d$a.jv(this.fvM));
        mMSwitchBtn.zvp = new 3(this);
    }

    protected final int getLayoutId() {
        return c.khi;
    }
}
