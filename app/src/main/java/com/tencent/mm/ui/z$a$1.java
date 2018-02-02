package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.z.a;

class z$a$1 implements Runnable {
    final /* synthetic */ a xLU;

    z$a$1(a aVar) {
        this.xLU = aVar;
    }

    public final void run() {
        boolean z = true;
        String str = "MicroMsg.LauncherUI.NewChattingTabUI";
        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
        Object[] objArr = new Object[1];
        if (this.xLU.xLL.xLx != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.xLU.xLL.xLx != null) {
            x.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
            this.xLU.xLL.xLx.onActivityResult(this.xLU.fyV & 65535, this.xLU.bjW, this.xLU.fyW);
        }
    }

    public final String toString() {
        return super.toString() + "|PostSelectImageJob_onActivityResult";
    }
}
