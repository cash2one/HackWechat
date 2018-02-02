package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import java.io.Writer;

class e$l extends Writer {
    private StringBuilder a = new StringBuilder();

    e$l() {
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.a.append(c);
            }
        }
    }

    private void a() {
        if (this.a.length() > 0) {
            TXCLog.v("TXCGLSurfaceViewBase", this.a.toString());
            this.a.delete(0, this.a.length());
        }
    }
}
