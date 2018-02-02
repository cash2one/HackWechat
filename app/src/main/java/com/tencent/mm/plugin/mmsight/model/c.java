package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends OrientationEventListener {
    public int orI = -1;
    public int orJ = -1;
    private long orK = 0;
    private long orL = 0;
    public a orM;
    public int orientation = -1;

    public interface a {
        void sL(int i);
    }

    public c(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        if (!j.osU) {
            return;
        }
        if (bh.bA(this.orL) < 2000) {
            x.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
        } else if (Math.abs(this.orI - i) >= 30 || bh.bA(this.orK) >= 300) {
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
            if (this.orM != null) {
                this.orM.sL(this.orientation);
            }
        }
    }

    public final void enable() {
        x.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", new Object[]{Boolean.valueOf(j.osU)});
        if (j.osU) {
            super.enable();
            this.orL = bh.Wq();
        }
    }

    public final int getOrientation() {
        if (j.osU) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean aZW() {
        if (!j.osU) {
            return false;
        }
        x.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", new Object[]{Long.valueOf(bh.bA(this.orL)), Integer.valueOf(this.orientation)});
        if (bh.bA(this.orL) < 2000 || this.orientation < 0) {
            return false;
        }
        if (this.orientation == 90 || this.orientation == 270) {
            return true;
        }
        return false;
    }
}
