package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

class FaceNumberItemView$a extends TimerTask {
    final /* synthetic */ FaceNumberItemView mmX;
    private WeakReference<Runnable> mmY;

    private FaceNumberItemView$a(FaceNumberItemView faceNumberItemView, Runnable runnable) {
        this.mmX = faceNumberItemView;
        this.mmY = null;
        this.mmY = new WeakReference(runnable);
    }

    public final void run() {
        if (this.mmY == null || this.mmY.get() == null) {
            cancel();
        } else {
            ag.y((Runnable) this.mmY.get());
        }
    }
}
