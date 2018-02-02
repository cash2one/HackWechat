package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.File;

public final class g {
    af jKT = new af(Looper.getMainLooper(), this.tvf);
    MMWebView tvc;
    public String tvd;
    c tve;
    private com.tencent.mm.sdk.platformtools.af.a tvf = new com.tencent.mm.sdk.platformtools.af.a(this) {
        final /* synthetic */ g tvg;

        {
            this.tvg = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Bitmap bitmap = this.tvg.tvc.getBitmap();
                    if (bitmap != null) {
                        e.post(new b(this.tvg, bitmap), "ViewCaptureHelper_SaveBitmap");
                        this.tvg.tvc = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.tvg.tve != null) {
                        this.tvg.tve.sT(this.tvg.tvd);
                        break;
                    }
                    break;
            }
            return false;
        }
    };

    private final class a implements Runnable {
        final /* synthetic */ g tvg;

        private a(g gVar) {
            this.tvg = gVar;
        }

        public final void run() {
            if (this.tvg.tvd != null) {
                int length = new File(this.tvg.tvd).getParentFile().listFiles(new 1(this)).length;
                for (int i = 0; i < length; i++) {
                    x.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[]{Boolean.valueOf(r2[i].delete())});
                }
                this.tvg.tvd = null;
            }
        }
    }

    public final void a(MMWebView mMWebView, c cVar) {
        this.tvc = mMWebView;
        this.tve = cVar;
        this.jKT.sendEmptyMessage(1);
    }

    public final void bRG() {
        e.post(new a(), "ViewCaptureHelper_DeleteBitmap");
    }
}
