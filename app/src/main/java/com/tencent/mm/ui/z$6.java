package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.l;

class z$6 implements Runnable {
    final /* synthetic */ z xLL;

    z$6(z zVar) {
        this.xLL = zVar;
    }

    public final void run() {
        this.xLL.mChattingClosed = false;
        if (!this.xLL.qwI.isFinishing()) {
            boolean z;
            String str = "MicroMsg.LauncherUI.NewChattingTabUI";
            String str2 = "ashutest::startChatting, ishow:%b";
            Object[] objArr = new Object[1];
            if (this.xLL.xLA == null) {
                z = false;
            } else {
                z = this.xLL.xLA.isShown();
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            Intent putExtra = new Intent().putExtra("Chat_User", this.xLL.xLH);
            if (this.xLL.xLI != null) {
                putExtra.putExtras(this.xLL.xLI);
            }
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            z.a(this.xLL, putExtra, false);
            this.xLL.xLF.ygF = this.xLL.onChattingLayoutChangedListener;
            this.xLL.xLA.setVisibility(0);
            this.xLL.xLA.setTranslationX((this.xLL.qwI.getWindow().getDecorView().getWidth() == 0 ? (float) this.xLL.qwI.getResources().getDisplayMetrics().widthPixels : (float) this.xLL.qwI.getWindow().getDecorView().getWidth()) - 0.1f);
            this.xLL.xLz = t.Wo();
            this.xLL.pY(3);
            if (this.xLL.cny()) {
                l.a(this.xLL.qwI);
            }
        }
    }

    public final String toString() {
        return super.toString() + "|startChattingRunnable";
    }
}
