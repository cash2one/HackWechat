package com.tencent.mm.plugin.sight.encode.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class b {

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fgO;
        final /* synthetic */ String jnw;
        final /* synthetic */ a qwp;
        final /* synthetic */ int qwq;
        final /* synthetic */ b qwr;

        public AnonymousClass3(b bVar, String str, a aVar, String str2, int i) {
            this.qwr = bVar;
            this.fgO = str;
            this.qwp = aVar;
            this.jnw = str2;
            this.qwq = i;
        }

        public final void run() {
            x.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", new Object[]{this.fgO});
            String ns = s.ns(this.fgO);
            if (-1 == t.a(ns, 1, this.fgO, null, 62)) {
                x.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", new Object[]{ns});
                b.a(this.qwp, -1);
                return;
            }
            String Jp = d.Jp(this.jnw);
            if (!e.bO(Jp)) {
                x.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.R(this.jnw, 320, 240), 60, CompressFormat.JPEG, Jp, true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            o.TU();
            e.x(Jp, s.nu(ns));
            o.TU();
            x.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[]{this.fgO, Long.valueOf(e.x(this.jnw, s.nt(ns)))});
            if (e.x(this.jnw, s.nt(ns)) <= 0) {
                x.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", new Object[]{this.jnw, r0});
                b.a(this.qwp, -1);
                t.ny(ns);
                return;
            }
            t.j(ns, this.qwq, 62);
            t.nA(ns);
            a aVar = this.qwp;
            if (aVar != null) {
                ag.y(new 2(aVar, -1));
            }
            com.tencent.mm.loader.stub.b.deleteFile(this.jnw);
            com.tencent.mm.loader.stub.b.deleteFile(Jp);
        }
    }

    public interface a {
        void onError(int i);
    }

    public static void a(final a aVar, final int i) {
        if (aVar != null) {
            ag.y(new Runnable() {
                public final void run() {
                    aVar.onError(i);
                }
            });
        }
    }
}
