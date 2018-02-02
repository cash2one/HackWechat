package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.h.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b$e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel;
import com.tencent.mm.plugin.appbrand.wxawidget.console.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;

public class WidgetConsoleUI extends MMActivity implements a {
    String appId;
    int fvM;
    int iGL;
    ConsolePanel iUX;
    String id;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(b$e.khj);
        this.iUX = (ConsolePanel) findViewById(b.kgz);
        if (!adl()) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!adl()) {
            finish();
        }
    }

    private boolean adl() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.appId = intent.getStringExtra("app_id");
        this.fvM = intent.getIntExtra("pkg_type", 0);
        this.iGL = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{stringExtra}));
        if (bh.ov(stringExtra)) {
            return false;
        }
        if (stringExtra.equals(this.id)) {
            return true;
        }
        ((e) g.h(e.class)).IX().b(this.id, this);
        ((e) g.h(e.class)).IX().a(stringExtra, this);
        this.id = stringExtra;
        d.a(this.iUX);
        return true;
    }

    public final void hg(int i) {
        String str;
        switch (i) {
            case 1:
                str = "(START)";
                break;
            case 2:
                str = "(RESUME)";
                break;
            case 3:
                str = "(PAUSE)";
                break;
            case 4:
                str = "(STOP)";
                break;
            default:
                str = "";
                break;
        }
        com.tencent.mm.bz.a.Z(new 2(this, str));
    }

    protected void onDestroy() {
        super.onDestroy();
        ((e) g.h(e.class)).IX().b(this.id, this);
        d.b(this.iUX);
    }

    public void finish() {
        if (!isFinishing() && !this.xIq) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return c.khf;
    }
}
