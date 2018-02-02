package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends OrientationEventListener {
    private a tuw = a.NONE;
    private int tux = 45;
    private b tuy;

    public enum a {
        NONE,
        PORTRAIT,
        LANDSCAPE,
        REVERSE_PORTRAIT,
        REVERSE_LANDSCAPE
    }

    public e(Context context, b bVar) {
        super(context);
        this.tuy = bVar;
    }

    public final void enable() {
        super.enable();
    }

    public final void disable() {
        super.disable();
        this.tuw = a.NONE;
    }

    public final void onOrientationChanged(int i) {
        if (i != -1) {
            a aVar = this.tuw;
            if ((i >= 360 - this.tux && i < 360) || (i >= 0 && i <= this.tux + 0)) {
                aVar = a.PORTRAIT;
            } else if (i >= 270 - this.tux && i <= this.tux + 270) {
                aVar = a.LANDSCAPE;
            } else if (i >= 180 - this.tux && i <= this.tux + 180) {
                aVar = a.REVERSE_PORTRAIT;
            } else if (i >= 90 - this.tux && i <= this.tux + 90) {
                aVar = a.REVERSE_LANDSCAPE;
            }
            if (aVar != this.tuw) {
                if (!(this.tuy == null || this.tuw == a.NONE)) {
                    this.tuy.a(this.tuw, aVar);
                }
                this.tuw = aVar;
            }
            x.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:" + i);
        }
    }
}
