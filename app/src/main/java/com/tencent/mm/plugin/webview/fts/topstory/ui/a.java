package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends OrientationEventListener {
    public static final a toe = new a(ac.getContext());
    private int orI = -1;
    private int orJ = -1;
    private long orK = 0;
    private long orL = 0;
    private int orientation = -1;
    a tod;

    public interface a {
        void sL(int i);
    }

    private a(Context context) {
        super(context);
    }

    public final void onOrientationChanged(int i) {
        if (bh.bA(this.orL) < 2000) {
            x.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            return;
        }
        x.d("MicroMsg.DeviceOrientationListener", "onOrientationChanged: %s", new Object[]{Integer.valueOf(i)});
        if (Math.abs(this.orI - i) >= 60 && bh.bA(this.orK) >= 1000) {
            this.orI = i;
            this.orK = bh.Wq();
            if (i <= 60 || i >= 300) {
                if (i <= 30 || i >= 330) {
                    this.orientation = 0;
                }
            } else if (i < 30 || i > 150) {
                if (i < 120 || i > 240) {
                    if (i >= i.CTRL_INDEX && i <= 330 && i >= 240 && i <= 300) {
                        this.orientation = 270;
                    }
                } else if (i >= 150 && i <= i.CTRL_INDEX) {
                    this.orientation = 180;
                }
            } else if (i >= 60 && i <= 120) {
                this.orientation = 90;
            }
            if (this.tod != null) {
                this.tod.sL(this.orientation);
            }
        }
    }

    public final void enable() {
        super.enable();
        this.orL = bh.Wq();
    }
}
