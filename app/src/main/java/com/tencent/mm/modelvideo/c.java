package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.a.e;
import com.tencent.mm.k.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;

public final class c {
    public static final int hTn = b.zH();
    Context context = null;
    int duration = 0;
    String fileName = null;
    String fvC = null;
    public a hTo = null;
    String hTp = null;
    final AsyncTask<String, Integer, String> hTq = new AsyncTask<String, Integer, String>(this) {
        final /* synthetic */ c hTr;
        int ret = 0;

        {
            this.hTr = r2;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return TA();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (this.hTr.hTo != null) {
                this.hTr.hTo.b(this.ret, this.hTr.fileName, this.hTr.hTp, this.hTr.duration);
            }
        }

        private String TA() {
            com.tencent.mm.compatible.i.a.a j;
            Throwable e;
            this.ret = 0;
            boolean is2G = an.is2G(ac.getContext());
            try {
                j = com.tencent.mm.compatible.i.a.j(this.hTr.context, this.hTr.intent);
            } catch (Throwable e2) {
                x.e("MicroMsg.ImportVideo", "exception:%s", bh.i(e2));
                j = null;
            }
            if (j == null) {
                x.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                g.pQN.a(106, 244, 1, false);
                this.ret = -50005;
                return null;
            }
            this.hTr.hTp = j.filename;
            int bN = e.bN(this.hTr.hTp);
            x.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", Boolean.valueOf(is2G), Integer.valueOf(bN), Integer.valueOf(j.duration), this.hTr.hTp);
            if (bN <= 0) {
                g.pQN.a(106, 244, 1, false);
                this.ret = -50001;
                return null;
            }
            if (bN > (is2G ? 10485760 : c.hTn)) {
                g.pQN.a(106, 245, 1, false);
                this.ret = -50002;
                return null;
            }
            k.q(this.hTr.hTp, this.hTr.videoPath, false);
            this.hTr.duration = j.duration / 1000;
            Object obj = 1;
            if (j.bitmap != null) {
                try {
                    d.a(j.bitmap, 60, CompressFormat.JPEG, this.hTr.fvC, true);
                    try {
                        g.pQN.a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e2 = e3;
                        obj = null;
                        x.e("MicroMsg.ImportVideo", "exception:%s", bh.i(e2));
                        if (obj != null) {
                            try {
                                g.pQN.a(106, 232, 1, false);
                                d.a(d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.hTr.fvC, true);
                            } catch (Throwable e22) {
                                x.e("MicroMsg.ImportVideo", "exception:%s", bh.i(e22));
                            }
                        }
                        if (!e.bO(this.hTr.videoPath)) {
                            this.ret = -50003;
                        }
                        if (!e.bO(this.hTr.fvC)) {
                            this.ret = -50004;
                        }
                        return null;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    x.e("MicroMsg.ImportVideo", "exception:%s", bh.i(e22));
                    if (obj != null) {
                        g.pQN.a(106, 232, 1, false);
                        d.a(d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.hTr.fvC, true);
                    }
                    if (e.bO(this.hTr.videoPath)) {
                        this.ret = -50003;
                    }
                    if (e.bO(this.hTr.fvC)) {
                        this.ret = -50004;
                    }
                    return null;
                }
            }
            if (obj != null) {
                g.pQN.a(106, 232, 1, false);
                d.a(d.ag(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.hTr.fvC, true);
            }
            if (e.bO(this.hTr.videoPath)) {
                this.ret = -50003;
            }
            if (e.bO(this.hTr.fvC)) {
                this.ret = -50004;
            }
            return null;
        }
    };
    Intent intent = null;
    String videoPath = null;

    public interface a {
        void b(int i, String str, String str2, int i2);
    }

    public final void a(Context context, Intent intent, a aVar) {
        this.context = context;
        this.intent = intent;
        this.fileName = s.ns((String) com.tencent.mm.kernel.g.Dj().CU().get(2, (Object) ""));
        o.TU();
        this.fvC = s.nu(this.fileName);
        o.TU();
        this.videoPath = s.nt(this.fileName);
        this.hTo = aVar;
        this.hTq.execute(new String[0]);
    }
}
