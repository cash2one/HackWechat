package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class b implements ActivityLifecycleCallbacks {
    private int kQg = 0;

    public static Application akB() {
        return (Application) ac.getContext().getApplicationContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (this.kQg < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                ar.Dm().F(new 1(this));
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (cardDetailUI.kQv != null) {
                    g gVar = cardDetailUI.kQv.kQT;
                    if (gVar != null && (gVar instanceof m)) {
                        x.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                        cardDetailUI.kQv.kQT.d(c.CARDCODEREFRESHACTION_ENTERFOREGROUND);
                    }
                }
            }
        }
        this.kQg++;
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.kQg--;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
