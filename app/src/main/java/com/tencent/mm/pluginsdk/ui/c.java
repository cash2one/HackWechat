package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class c extends j implements com.tencent.mm.ad.d.a {
    a vjm;
    int vjn;

    private static class a implements com.tencent.mm.pluginsdk.ui.j.a {
        Bitmap kHs = null;
        private com.tencent.mm.pluginsdk.ui.j.a plt;

        public a(com.tencent.mm.pluginsdk.ui.j.a aVar) {
            this.plt = aVar;
        }

        public final Bitmap b(String str, int i, int i2, int i3) {
            if (this.plt != null) {
                return this.plt.b(str, i, i2, i3);
            }
            return null;
        }

        public final Bitmap cm(String str) {
            if (this.plt != null) {
                return this.plt.cm(str);
            }
            return null;
        }

        public final Bitmap cn(String str) {
            if (this.plt != null) {
                return this.plt.cn(str);
            }
            return null;
        }

        public final Bitmap tJ() {
            if (this.kHs != null && !this.kHs.isRecycled()) {
                return this.kHs;
            }
            if (this.plt != null) {
                return this.plt.tJ();
            }
            return null;
        }

        public final void a(j jVar) {
            if (this.plt != null) {
                this.plt.a(jVar);
            }
        }
    }

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b) {
        super(new a(b.bZV()), str, false);
        this.vjm = (a) this.plt;
    }
}
