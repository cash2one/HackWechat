package com.tencent.mm.plugin.appbrand.ui;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public final class AppBrandStarListUI extends DrawStatusBarActivity {
    private Dialog jLV = null;

    static /* synthetic */ void a(AppBrandStarListUI appBrandStarListUI) {
        Fragment N = appBrandStarListUI.getSupportFragmentManager().N(16908290);
        if (N == null || !(N instanceof c)) {
            appBrandStarListUI.getSupportFragmentManager().aS().b(16908290, c.bB(appBrandStarListUI.getString(j.iBt), appBrandStarListUI.getString(j.iBr))).commit();
            if (appBrandStarListUI.jLV != null) {
                appBrandStarListUI.jLV.dismiss();
            }
            appBrandStarListUI.jLV = null;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -1052684;
        }
        if (VERSION.SDK_INT >= 21) {
            return AppBrandLauncherUI.jKJ;
        }
        return super.getStatusBarColor();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onBackPressed() {
        Fragment N = getSupportFragmentManager().N(16908290);
        if (N != null && (N instanceof a)) {
            boolean z;
            a aVar = (a) N;
            if (aVar.jMc) {
                aVar.jMc = false;
                aVar.a(AppBrandStarListUI$a$c.SWITCH_TO_NORMAL);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
        super.onBackPressed();
    }
}
