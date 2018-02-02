package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.d;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.launching.precondition.h;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;

@a(7)
public final class AppBrandLaunchProxyUI extends MMBaseActivity implements l {
    private r jwL;
    private h jwM;
    private MMActivity.a jwN = null;

    public static boolean v(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() == null || !intent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject, LaunchParamsOptional launchParamsOptional) {
        a(context, str, null, str2, i, i2, appBrandStatObject, null, launchParamsOptional);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        if (bh.ov(str) && bh.ov(str2)) {
            return false;
        }
        return g.jzg.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        h fVar;
        j.a(getWindow());
        j.a(getWindow(), true);
        if (getIntent().getBooleanExtra("extra_from_mm", true)) {
            fVar = new f(this);
        } else {
            fVar = new d(this);
        }
        this.jwM = fVar;
        if (this.jwM != null) {
            x.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", new Object[]{this.jwM.getClass().getSimpleName()});
            this.jwM.w(getIntent());
            if (!isFinishing()) {
                getString(q.j.dGO);
                this.jwL = com.tencent.mm.ui.base.h.a(this, getString(q.j.ctB), true, new 1(this));
                if (this.jwL != null && this.jwL.getWindow() != null) {
                    LayoutParams attributes = this.jwL.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.jwL.getWindow().setAttributes(attributes);
                    return;
                }
                return;
            }
            return;
        }
        finish();
    }

    protected final void onResume() {
        super.onResume();
        if (this.jwM != null) {
            this.jwM.onResume();
        } else {
            super.finish();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.jwM != null) {
            this.jwM.onPause();
        } else {
            super.finish();
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.jwL != null) {
            this.jwL.dismiss();
            this.jwL = null;
        }
    }

    public final void a(MMActivity.a aVar, Intent intent, int i) {
        this.jwN = aVar;
        startActivityForResult(intent, i);
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jwN != null) {
            this.jwN.b(i, i2, intent);
        }
        this.jwN = null;
    }

    public final boolean ahM() {
        return !isFinishing();
    }
}
