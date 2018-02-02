package com.tencent.mm.plugin.fts;

import android.content.res.AssetManager;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

class PluginFTS$a extends a {
    final /* synthetic */ PluginFTS mJM;

    private PluginFTS$a(PluginFTS pluginFTS) {
        this.mJM = pluginFTS;
    }

    public final boolean execute() {
        InputStream open;
        Throwable e;
        String[] split;
        String[] split2;
        Object obj;
        Object obj2;
        int i;
        long s;
        long currentTimeMillis;
        Throwable th;
        Throwable th2;
        Bg("start");
        AssetManager assets = ac.getContext().getAssets();
        InputStream inputStream = null;
        try {
            open = assets.open("fts_t2s.txt");
            try {
                for (String split3 : new String(b.d(open)).split("\n")) {
                    String[] split4 = split3.split(",");
                    f.icD.put(split4[0], split4[1]);
                }
                e.c(open);
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, e.getMessage(), new Object[0]);
                    e.c(open);
                    Bg("t2s");
                    inputStream = assets.open("fts_py.txt");
                    split = new String(b.d(inputStream)).split("\n");
                    for (String split5 : split) {
                        split2 = split5.split(",");
                        obj = split2[0];
                        obj2 = new String[(split2.length - 1)];
                        for (i = 0; i < obj2.length; i++) {
                            if (i + 1 >= split2.length) {
                                obj2[i] = split2[i + 1];
                            }
                        }
                        if (obj2.length <= 0) {
                            for (String Bi : obj2) {
                                f.mLi.Bi(Bi);
                            }
                            f.mLj.put(obj, obj2);
                        }
                    }
                    e.c(inputStream);
                    Bg("py");
                    com.tencent.mm.plugin.fts.a.e.mKJ.mKK = c.aMP().length() / 1048576;
                    com.tencent.mm.plugin.fts.a.e.mKJ.mKL = PluginFTS.access$200(this.mJM).s(-301, 0);
                    com.tencent.mm.plugin.fts.a.e.mKJ.mKM = PluginFTS.access$200(this.mJM).s(-302, 0);
                    com.tencent.mm.plugin.fts.a.e.mKJ.mKO = PluginFTS.access$200(this.mJM).s(-303, 0);
                    com.tencent.mm.plugin.fts.a.e.mKJ.mKN = PluginFTS.access$200(this.mJM).s(-304, 0);
                    s = ((m) g.k(m.class)).getFTSIndexDB().s(-300, 0);
                    currentTimeMillis = System.currentTimeMillis();
                    if (d.u(s, currentTimeMillis)) {
                        x.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
                    } else {
                        com.tencent.mm.plugin.fts.a.e.aMW();
                        ((m) g.k(m.class)).getFTSIndexDB().t(-300, currentTimeMillis);
                    }
                    Bg("reportData");
                    return true;
                } catch (Throwable e3) {
                    th = e3;
                    inputStream = open;
                    th2 = th;
                    e.c(inputStream);
                    throw th2;
                }
            }
        } catch (Throwable th22) {
            th = th22;
            open = null;
            e3 = th;
            x.printErrStackTrace("MicroMsg.FTS.PluginFTS", e3, e3.getMessage(), new Object[0]);
            e.c(open);
            Bg("t2s");
            inputStream = assets.open("fts_py.txt");
            split = new String(b.d(inputStream)).split("\n");
            while (r2 < split.length) {
                split2 = split5.split(",");
                obj = split2[0];
                obj2 = new String[(split2.length - 1)];
                for (i = 0; i < obj2.length; i++) {
                    if (i + 1 >= split2.length) {
                        obj2[i] = split2[i + 1];
                    }
                }
                if (obj2.length <= 0) {
                    while (i < r4) {
                        f.mLi.Bi(Bi);
                    }
                    f.mLj.put(obj, obj2);
                }
            }
            e.c(inputStream);
            Bg("py");
            com.tencent.mm.plugin.fts.a.e.mKJ.mKK = c.aMP().length() / 1048576;
            com.tencent.mm.plugin.fts.a.e.mKJ.mKL = PluginFTS.access$200(this.mJM).s(-301, 0);
            com.tencent.mm.plugin.fts.a.e.mKJ.mKM = PluginFTS.access$200(this.mJM).s(-302, 0);
            com.tencent.mm.plugin.fts.a.e.mKJ.mKO = PluginFTS.access$200(this.mJM).s(-303, 0);
            com.tencent.mm.plugin.fts.a.e.mKJ.mKN = PluginFTS.access$200(this.mJM).s(-304, 0);
            s = ((m) g.k(m.class)).getFTSIndexDB().s(-300, 0);
            currentTimeMillis = System.currentTimeMillis();
            if (d.u(s, currentTimeMillis)) {
                x.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
            } else {
                com.tencent.mm.plugin.fts.a.e.aMW();
                ((m) g.k(m.class)).getFTSIndexDB().t(-300, currentTimeMillis);
            }
            Bg("reportData");
            return true;
        } catch (Throwable th3) {
            th22 = th3;
            e.c(inputStream);
            throw th22;
        }
        Bg("t2s");
        try {
            inputStream = assets.open("fts_py.txt");
            try {
                split = new String(b.d(inputStream)).split("\n");
                while (r2 < split.length) {
                    split2 = split5.split(",");
                    obj = split2[0];
                    obj2 = new String[(split2.length - 1)];
                    for (i = 0; i < obj2.length; i++) {
                        if (i + 1 >= split2.length) {
                            obj2[i] = split2[i + 1];
                        }
                    }
                    if (obj2.length <= 0) {
                        while (i < r4) {
                            f.mLi.Bi(Bi);
                        }
                        f.mLj.put(obj, obj2);
                    }
                }
                e.c(inputStream);
            } catch (Exception e4) {
                th22 = e4;
            }
        } catch (Throwable e32) {
            th = e32;
            inputStream = open;
            th22 = th;
            try {
                x.printErrStackTrace("MicroMsg.FTS.PluginFTS", th22, th22.getMessage(), new Object[0]);
                e.c(inputStream);
                Bg("py");
                com.tencent.mm.plugin.fts.a.e.mKJ.mKK = c.aMP().length() / 1048576;
                com.tencent.mm.plugin.fts.a.e.mKJ.mKL = PluginFTS.access$200(this.mJM).s(-301, 0);
                com.tencent.mm.plugin.fts.a.e.mKJ.mKM = PluginFTS.access$200(this.mJM).s(-302, 0);
                com.tencent.mm.plugin.fts.a.e.mKJ.mKO = PluginFTS.access$200(this.mJM).s(-303, 0);
                com.tencent.mm.plugin.fts.a.e.mKJ.mKN = PluginFTS.access$200(this.mJM).s(-304, 0);
                s = ((m) g.k(m.class)).getFTSIndexDB().s(-300, 0);
                currentTimeMillis = System.currentTimeMillis();
                if (d.u(s, currentTimeMillis)) {
                    com.tencent.mm.plugin.fts.a.e.aMW();
                    ((m) g.k(m.class)).getFTSIndexDB().t(-300, currentTimeMillis);
                } else {
                    x.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
                }
                Bg("reportData");
                return true;
            } catch (Throwable th4) {
                th22 = th4;
                e.c(inputStream);
                throw th22;
            }
        } catch (Throwable e322) {
            th = e322;
            inputStream = open;
            th22 = th;
            e.c(inputStream);
            throw th22;
        }
        Bg("py");
        com.tencent.mm.plugin.fts.a.e.mKJ.mKK = c.aMP().length() / 1048576;
        com.tencent.mm.plugin.fts.a.e.mKJ.mKL = PluginFTS.access$200(this.mJM).s(-301, 0);
        com.tencent.mm.plugin.fts.a.e.mKJ.mKM = PluginFTS.access$200(this.mJM).s(-302, 0);
        com.tencent.mm.plugin.fts.a.e.mKJ.mKO = PluginFTS.access$200(this.mJM).s(-303, 0);
        com.tencent.mm.plugin.fts.a.e.mKJ.mKN = PluginFTS.access$200(this.mJM).s(-304, 0);
        s = ((m) g.k(m.class)).getFTSIndexDB().s(-300, 0);
        currentTimeMillis = System.currentTimeMillis();
        if (d.u(s, currentTimeMillis)) {
            com.tencent.mm.plugin.fts.a.e.aMW();
            ((m) g.k(m.class)).getFTSIndexDB().t(-300, currentTimeMillis);
        } else {
            x.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
        }
        Bg("reportData");
        return true;
    }

    public final String ado() {
        return String.format("{T2S: %d PY: %d}", new Object[]{Integer.valueOf(f.icD.size()), Integer.valueOf(f.mLj.size())});
    }

    public final String getName() {
        return "InitResourceTask";
    }
}
