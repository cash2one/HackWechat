package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.xwalk.a.e;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater$XWalkBackgroundUpdateListener;

public class l implements XWalkInitListener, XWalkUpdater$XWalkBackgroundUpdateListener {
    static l Atr;
    XWalkInitializer Ats;
    XWalkUpdater Att;
    protected Context mContext;

    public static void iP(Context context) {
        if (Atr == null) {
            Atr = new l(context);
        }
        Atr.cJa();
    }

    public static boolean isBusy() {
        if (Atr == null) {
            return false;
        }
        return e.cJi();
    }

    public l(Context context) {
        this.mContext = context;
        this.Ats = new XWalkInitializer(this, context);
        this.Att = new XWalkUpdater(this, context);
    }

    public final boolean cJa() {
        new e(this.Att).execute(new String[0]);
        return false;
    }

    public void onXWalkInitStarted() {
    }

    public void onXWalkInitCancelled() {
    }

    public void onXWalkInitFailed() {
    }

    public void onXWalkInitCompleted() {
    }

    public void onXWalkUpdateStarted() {
        e.cJj();
    }

    public void onXWalkUpdateProgress(int i) {
    }

    public void onXWalkUpdateCancelled() {
        e.cJk();
    }

    public void onXWalkUpdateFailed(int i) {
        e.Ji(i);
    }

    public void onXWalkUpdateCompleted() {
        e.cJl();
    }
}
