package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends FileObserver {
    private String qhF;
    private a vdV;

    public w(String str, a aVar) {
        super(str);
        x.i("MicroMsg.ScreenshotObserver", "observer  " + str);
        this.vdV = aVar;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.qhF == null || !str.equalsIgnoreCase(this.qhF)) {
                this.qhF = str;
                this.vdV.bAA();
                x.i("MicroMsg.ScreenshotObserver", "Send event to listener. " + str);
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
