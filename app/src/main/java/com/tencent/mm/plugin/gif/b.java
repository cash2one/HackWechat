package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class b {
    private static b nyy;
    f<String, WeakReference<a>> nyA = new f(10, new 1(this));
    public f<String, WeakReference<d>> nyz = new f(10);

    public static synchronized b aSk() {
        b bVar;
        synchronized (b.class) {
            if (nyy == null) {
                synchronized (b.class) {
                    if (nyy == null) {
                        nyy = new b();
                    }
                }
            }
            bVar = nyy;
        }
        return bVar;
    }

    public final a Cp(String str) {
        if (this.nyA.get(str) != null) {
            return (a) ((WeakReference) this.nyA.get(str)).get();
        }
        return null;
    }

    public final a cP(String str, String str2) {
        a aVar = null;
        if (this.nyA.get(str) != null) {
            aVar = (a) ((WeakReference) this.nyA.get(str)).get();
        }
        if (aVar == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (p.US(str2)) {
                aVar = new f(str2);
            } else {
                aVar = new c(str2);
            }
            x.d("MicroMsg.GIF.MMAnimateDrawableCacheMgr", "new MMAnimateDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.nyA.put(str, new WeakReference(aVar));
        }
        return aVar;
    }

    public final a o(String str, byte[] bArr) {
        a aVar = null;
        if (bArr != null) {
            if (this.nyA.get(str) != null) {
                aVar = (a) ((WeakReference) this.nyA.get(str)).get();
            }
            if (aVar == null) {
                if (p.bq(bArr) && ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aBf()) {
                    aVar = new f(bArr);
                } else {
                    aVar = new c(bArr);
                }
                this.nyA.put(str, new WeakReference(aVar));
            }
            if (!aVar.isRunning()) {
                aVar.reset();
            }
        }
        return aVar;
    }
}
