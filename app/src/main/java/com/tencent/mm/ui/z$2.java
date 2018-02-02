package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.z.q;

class z$2 implements IdleHandler {
    final /* synthetic */ z xLL;

    z$2(z zVar) {
        this.xLL = zVar;
    }

    @TargetApi(17)
    public final boolean queueIdle() {
        try {
            if (this.xLL.qwI.isFinishing() || (VERSION.SDK_INT >= 17 && this.xLL.qwI.isDestroyed())) {
                this.xLL.xLC = null;
                this.xLL.xLD = null;
                String str = "MicroMsg.LauncherUI.NewChattingTabUI";
                String str2 = "prepare chattingUI but activity finished just ret sdk[%d] isDestroyed[%b]";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(VERSION.SDK_INT);
                objArr[1] = Boolean.valueOf(VERSION.SDK_INT >= 17 ? this.xLL.qwI.isDestroyed() : this.xLL.qwI.isFinishing());
                x.i(str, str2, objArr);
                return false;
            }
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic start");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.xLL.xLA == null) {
                z.a(this.xLL, new Intent().putExtra("Chat_User", q.FS()), true);
                this.xLL.xLx.nWQ = true;
                this.xLL.xLx.csJ();
                this.xLL.xLA.setVisibility(8);
                this.xLL.xLx.isPreLoaded = true;
                this.xLL.xLx.onPause();
                this.xLL.xLx.csH();
                this.xLL.xLx.hHG = false;
                this.xLL.xLy.cmD();
                ac.a(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
            }
            this.xLL.xLC = null;
            this.xLL.xLD = null;
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LauncherUI.NewChattingTabUI", e, "", new Object[0]);
            new Handler().post(new 1(this, e));
        }
    }
}
