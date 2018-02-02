package com.tencent.mm.ui.chatting.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnDragListener;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    p fhr;
    public ad yvS;
    public v yvT;
    public u yvY;
    public a ywa;
    public y ywb;

    public k(p pVar) {
        this.fhr = pVar;
    }

    @TargetApi(11)
    public final void ctD() {
        if (VERSION.SDK_INT < 11) {
            x.d("MicroMsg.ChattingUI.DragDropMgr", "sdk not support dragdrop event");
            return;
        }
        if (this.fhr.csx() != null) {
            this.fhr.csx().setOnDragListener(null);
        }
        if (this.fhr.csB() != null) {
            this.fhr.csB().setOnDragListener(null);
            this.fhr.csB().a(null);
        }
    }

    @TargetApi(11)
    public final void ctE() {
        if (!this.yvY.ysa && !this.yvY.yAH) {
            if (VERSION.SDK_INT < 11) {
                x.d("MicroMsg.ChattingUI.DragDropMgr", "sdk not support dragdrop event");
            } else {
                new Runnable(this) {
                    final /* synthetic */ k yzU;

                    {
                        this.yzU = r1;
                    }

                    public final void run() {
                        OnDragListener 1 = new 1(this);
                        if (this.yzU.fhr.csx() != null) {
                            this.yzU.fhr.csx().setOnDragListener(1);
                        }
                        if (this.yzU.fhr.csB() != null) {
                            this.yzU.fhr.csB().setOnDragListener(1);
                            this.yzU.fhr.csB().a(1);
                        }
                    }
                }.run();
            }
        }
    }
}
