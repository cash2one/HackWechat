package com.tencent.mm.ui;

import android.view.animation.AnimationUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.tools.TestTimeForChatting$a;

class z$7 implements a {
    long start = 0;
    final /* synthetic */ z xLL;

    z$7(z zVar) {
        this.xLL = zVar;
    }

    public final void cnz() {
        if (this.xLL.mChattingInAnim == null) {
            this.xLL.mChattingInAnim = AnimationUtils.loadAnimation(this.xLL.qwI, MMFragmentActivity.a.xKg);
            this.xLL.mChattingInAnim.setAnimationListener(new 1(this));
        }
        if (this.xLL.mNeedChattingAnim) {
            this.xLL.xLA.zno = new TestTimeForChatting$a(this) {
                final /* synthetic */ z$7 xLR;

                {
                    this.xLR = r1;
                }

                public final void cnA() {
                    x.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
                    this.xLR.start = System.currentTimeMillis();
                    if (this.xLR.xLL.xLx.getSwipeBackLayout() != null) {
                        this.xLR.xLL.xLx.getSwipeBackLayout().startAnimation(this.xLR.xLL.mChattingInAnim);
                    } else {
                        this.xLR.xLL.xLx.getView().startAnimation(this.xLR.xLL.mChattingInAnim);
                    }
                    this.xLR.xLL.xLA.zno = null;
                }
            };
            this.xLL.mNeedChattingAnim = false;
        } else {
            z.a(this.xLL);
            z.b(this.xLL);
        }
        this.xLL.xLF.ygF = null;
        x.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
    }
}
