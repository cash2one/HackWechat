package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.z;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMFragmentActivity;

public final class f {
    private static int b(AppBrandStatObject appBrandStatObject) {
        return appBrandStatObject == null ? 0 : appBrandStatObject.fIs;
    }

    private static int c(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            return 0;
        }
        return appBrandStatObject.scene;
    }

    public static void a(Activity activity, AppBrandStatObject appBrandStatObject) {
        boolean z = true;
        if (activity != null && activity.getIntent() != null) {
            boolean z2;
            if (c(appBrandStatObject) == 1023) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                activity.overridePendingTransition(a.isp, a.bpQ);
                return;
            }
            if (WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == c(appBrandStatObject) && 6 == b(appBrandStatObject)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                activity.overridePendingTransition(MMFragmentActivity.a.xKi, MMFragmentActivity.a.xKj);
                return;
            }
            Intent intent = activity.getIntent();
            if (intent == null || !intent.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false)) {
                z = false;
            }
            if (z) {
                activity.overridePendingTransition(a.isp, a.bpQ);
            } else if (1086 == c(appBrandStatObject)) {
                if (b(appBrandStatObject) < 0) {
                    activity.overridePendingTransition(a.bpQ, a.bpQ);
                } else {
                    activity.overridePendingTransition(a.isr, a.iss);
                }
            } else if (1090 == c(appBrandStatObject)) {
                activity.overridePendingTransition(a.isq, a.iso);
            } else {
                activity.overridePendingTransition(a.isp, a.iso);
            }
        }
    }

    public static void a(e eVar, e eVar2, Runnable runnable) {
        if (eVar != null) {
            a(eVar, eVar.Yy() ? MMFragmentActivity.a.xKg : a.isp, null);
            if (eVar2 != null) {
                a(eVar2, eVar.Yy() ? MMFragmentActivity.a.xKh : a.bpQ, runnable);
            }
        }
    }

    public static void a(final e eVar, int i, final Runnable runnable) {
        if (z.ai(eVar.iqD)) {
            Animation loadAnimation = AnimationUtils.loadAnimation(eVar.iqt, i);
            loadAnimation.setAnimationListener(new com.tencent.mm.ui.widget.f() {
                public final void onAnimationEnd(Animation animation) {
                    if (runnable != null) {
                        ag.y(runnable);
                    }
                }

                public final void onAnimationStart(Animation animation) {
                    eVar.iqD.setWillNotDraw(false);
                }
            });
            eVar.iqD.startAnimation(loadAnimation);
            return;
        }
        eVar.iqD.setWillNotDraw(true);
        eVar.iqD.post(new 1(eVar, i, runnable));
    }
}
