package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends l {
    public r(Context context, l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final void d(Button button) {
        l bxl = bxl();
        if (g.m(this.context, bxl.rgh)) {
            button.setOnClickListener(new 1(this, bxl));
        } else {
            super.d(button);
        }
    }

    public final boolean r(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                context = this.context;
            }
            a.post(new 2(this, context, launchIntentForPackage, str2));
            return true;
        } catch (Throwable e) {
            x.e("AdLandingPageOpenAppBtnComp", bh.i(e));
            return false;
        }
    }
}
