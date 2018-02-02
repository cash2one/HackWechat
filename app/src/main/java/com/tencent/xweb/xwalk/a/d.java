package com.tencent.xweb.xwalk.a;

import android.content.Context;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer$XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class d implements XWalkInitializer$XWalkInitListener, XWalkBackgroundUpdateListener {
    public static boolean AtN = true;
    private static boolean AtO = false;
    private static d AtP;
    XWalkInitializer Ats;
    XWalkUpdater Att;
    Context mContext;

    private d(Context context) {
        this.mContext = context;
        this.Ats = new XWalkInitializer(this, context);
        this.Att = new XWalkUpdater((XWalkBackgroundUpdateListener) this, context);
    }

    public final void onXWalkInitStarted() {
    }

    public final void onXWalkInitCancelled() {
    }

    public final void onXWalkInitFailed() {
    }

    public final void onXWalkInitCompleted() {
    }

    public final void onXWalkUpdateStarted() {
        e.cJj();
    }

    public final void onXWalkUpdateProgress(int i) {
    }

    public final void onXWalkUpdateCancelled() {
        e.cJk();
    }

    public final void onXWalkUpdateFailed(int i) {
        e.Ji(i);
    }

    public final void onXWalkUpdateCompleted() {
        e.cJl();
    }

    public static boolean isXWalkReady() {
        if (!AtO || AtP == null) {
            return false;
        }
        return AtP.Ats.isXWalkReady();
    }

    public static boolean iT(Context context) {
        if (AtO) {
            return AtO;
        }
        AtO = true;
        AtP = new d(context);
        XWalkEnvironment.init(context);
        if (!XWalkEnvironment.isDownloadMode()) {
            return false;
        }
        d dVar = AtP;
        if (!AtN) {
            new e(dVar.Att).execute(new String[0]);
        }
        if (!dVar.Ats.tryInitSync()) {
            return false;
        }
        XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
        return true;
    }
}
