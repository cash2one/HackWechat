package com.tencent.mm.plugin.appbrand.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.x;

final class c$c extends g {
    final /* synthetic */ c iHj;

    c$c(c cVar, h hVar) {
        this.iHj = cVar;
        super(hVar);
    }

    public final String getName() {
        return this.iHj.mName + "|BackgroundTemporary";
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 3:
                c.a(this.iHj, this.iHj.iHa);
                return true;
            case 4:
                RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                x.i(this.iHj.TAG, "BackgroundTemporary process TO_SUSPEND_FROM_BACKGROUND, current process importance %d", new Object[]{Integer.valueOf(runningAppProcessInfo.importance)});
                if (runningAppProcessInfo.importance == 100) {
                    c.a(this.iHj, this.iHj.iHe);
                    return true;
                }
                c.a(this.iHj, this.iHj.iHc);
                return true;
            case 10:
                x.i(this.iHj.TAG, "BackgroundTemporary process ON_SYSTEM_SCREEN_OFF");
                c.a(this.iHj, this.iHj.iHe);
                return true;
            default:
                return super.j(message);
        }
    }

    public final void enter() {
        super.enter();
        this.iHj.xiR.sendEmptyMessageDelayed(4, ((long) this.iHj.irP.iqx.iOF) * 1000);
    }

    public final void exit() {
        super.exit();
        this.iHj.xiR.removeMessages(4);
    }
}
