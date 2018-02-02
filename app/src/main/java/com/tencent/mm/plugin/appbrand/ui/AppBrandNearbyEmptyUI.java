package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.a.h.b;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.smtt.sdk.WebView;

public final class AppBrandNearbyEmptyUI extends DrawStatusBarActivity {
    protected final int getLayoutId() {
        return h.ixb;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        a.d(this.mController.contentView, getStatusBarColor(), true);
        this.mController.contentView.setBackgroundColor(-1052684);
        if (!(getSupportActionBar() == null || getSupportActionBar().getCustomView() == null)) {
            getSupportActionBar().getCustomView().setBackgroundColor(-1052684);
        }
        setMMTitle(j.dDY);
        nR(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new 1(this), f.itj);
        k.a(this);
        TextView textView = (TextView) findViewById(g.ivD);
        TextView textView2 = (TextView) findViewById(g.ivB);
        com.tencent.mm.plugin.appbrand.report.a.h hVar;
        switch (getIntent().getIntExtra("extra_enter_reason", 0)) {
            case 0:
                hVar = new com.tencent.mm.plugin.appbrand.report.a.h();
                hVar.jIl = b.jIy;
                hVar.jIp = com.tencent.mm.plugin.appbrand.report.a.h.a.jIr;
                hVar.wW();
                break;
            case 1:
                textView.setText(j.iAi);
                textView2.setText(j.iAh);
                hVar = new com.tencent.mm.plugin.appbrand.report.a.h();
                hVar.jIl = b.jIy;
                hVar.jIp = com.tencent.mm.plugin.appbrand.report.a.h.a.jIs;
                hVar.wW();
                break;
            default:
                finish();
                return;
        }
        setResult(-1);
    }

    public final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -1052684;
        }
        if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jKJ;
        }
        return super.getStatusBarColor();
    }
}
