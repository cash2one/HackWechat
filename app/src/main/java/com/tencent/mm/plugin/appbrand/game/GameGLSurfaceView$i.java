package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.c$f;
import java.io.Writer;

class GameGLSurfaceView$i extends Writer {
    private StringBuilder mBuilder = new StringBuilder();

    GameGLSurfaceView$i() {
    }

    public final void close() {
        bE();
    }

    public final void flush() {
        bE();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                bE();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void bE() {
        if (this.mBuilder.length() > 0) {
            c$f.v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }
}
