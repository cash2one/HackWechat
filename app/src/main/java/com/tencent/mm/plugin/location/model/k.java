package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class k implements e {
    List<a> gxL = new ArrayList();
    int h = 300;
    as hxL = new as(1, "location_worker");
    LinkedList<b> nRf = new LinkedList();
    b nRg = null;
    int w = 300;

    public final void a(a aVar) {
        this.gxL.remove(aVar);
        x.i("MicroMsg.StaticMapServer", "removeCallback " + this.gxL.size());
        if (this.gxL.size() == 0) {
            x.i("MicroMsg.StaticMapServer", "clean task");
            this.nRf.clear();
            this.nRg = null;
            stop();
        }
    }

    public k() {
        start();
    }

    public final void start() {
        ar.CG().a(648, this);
    }

    public final void stop() {
        x.i("MicroMsg.StaticMapServer", "stop static map server");
        ar.CG().b(648, this);
    }

    final void OO() {
        if (this.nRg == null && this.nRf.size() > 0) {
            int intValue;
            this.nRg = (b) this.nRf.removeFirst();
            try {
                intValue = Integer.valueOf(bh.az(g.zY().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            x.i("MicroMsg.StaticMapServer", "run local %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue == 0) {
                ar.CG().a(new g(this.nRg.hxF, this.nRg.hxG, this.nRg.fzv + 1, this.w, this.h, b(this.nRg), w.cfi()), 0);
                return;
            }
            int i = this.w;
            for (intValue = this.h; i * intValue > 270000; intValue = (int) (((double) intValue) / 1.2d)) {
                i = (int) (((double) i) / 1.2d);
            }
            if (bh.PT()) {
                this.hxL.c(new a(this, true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nRg.hxF), Float.valueOf(this.nRg.hxG), Integer.valueOf(this.nRg.fzv), w.cfi()}), b(this.nRg)));
                return;
            }
            this.hxL.c(new a(this, false, String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.nRg.hxG), Float.valueOf(this.nRg.hxF), Integer.valueOf(this.nRg.fzv)}), b(this.nRg)));
        }
    }

    public static String b(b bVar) {
        String s = com.tencent.mm.a.g.s((bVar.toString()).getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(c.Fj()).append(s.charAt(0)).append(s.charAt(1)).append("/").append(s.charAt(3)).append(s.charAt(4)).append("/").toString();
        if (!com.tencent.mm.a.e.bO(stringBuilder2)) {
            new File(stringBuilder2).mkdirs();
        }
        return stringBuilder2 + "static_map_" + s;
    }

    private void gl(boolean z) {
        x.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.nRg != null) {
                for (a aVar : this.gxL) {
                    if (aVar != null) {
                        aVar.a(b(this.nRg), this.nRg);
                    }
                }
            }
        } else if (this.nRg != null) {
            for (a aVar2 : this.gxL) {
                if (aVar2 != null) {
                    aVar2.a(this.nRg);
                }
            }
        }
        this.nRg = null;
        OO();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar.getType() != 648) {
            return;
        }
        if (i == 0 && i2 == 0 && this.nRg != null) {
            gl(true);
        } else {
            gl(false);
        }
    }
}
