package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class LauncherUI$4 implements Runnable {
    long fpS = 2000;
    final /* synthetic */ LauncherUI xHf;

    LauncherUI$4(LauncherUI launcherUI) {
        this.xHf = launcherUI;
    }

    @TargetApi(17)
    public final void run() {
        x.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[]{Long.valueOf(Thread.currentThread().getId())});
        ag.K(this);
        if (ar.Hi()) {
            Object[] objArr = new Object[1];
            g.Dh();
            objArr[0] = Integer.valueOf(a.Cg());
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", objArr);
        } else if (d.SQ() || b.foreground) {
            this.fpS += 2000;
            if (this.fpS > 10000) {
                this.fpS = 2000;
            }
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[]{Boolean.valueOf(d.SQ()), Boolean.valueOf(b.foreground), Long.valueOf(this.fpS)});
            ag.h(this, this.fpS);
        } else {
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
            if (HardCoderJNI.checkEnv) {
                HardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
            }
            x.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
        }
    }
}
