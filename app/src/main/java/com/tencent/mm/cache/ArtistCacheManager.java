package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager gBn;
    public static HashMap<String, a> gBo = new HashMap();
    private static HashSet<com.tencent.mm.d.a> gBp = new HashSet();
    public String gBq;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] gBs = new int[com.tencent.mm.d.a.values().length];

        static {
            try {
                gBs[com.tencent.mm.d.a.fhS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gBs[com.tencent.mm.d.a.fhU.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                gBs[com.tencent.mm.d.a.fhT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                gBs[com.tencent.mm.d.a.fhV.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    class a {
        final /* synthetic */ ArtistCacheManager gBr;
        public HashMap<com.tencent.mm.d.a, d> gBt = new HashMap();

        public a(ArtistCacheManager artistCacheManager) {
            this.gBr = artistCacheManager;
        }

        public final void clearAll() {
            for (Entry value : this.gBt.entrySet()) {
                ((d) value.getValue()).onDestroy();
            }
        }
    }

    public static ArtistCacheManager xu() {
        if (gBn == null) {
            gBn = new ArtistCacheManager();
        }
        return gBn;
    }

    public final <T extends d> T a(com.tencent.mm.d.a aVar) {
        d dVar = null;
        if (gBo.containsKey(this.gBq)) {
            a aVar2 = (a) gBo.get(this.gBq);
            if (!aVar2.gBt.containsKey(aVar)) {
                switch (AnonymousClass3.gBs[aVar.ordinal()]) {
                    case 1:
                        dVar = new b();
                        break;
                    case 2:
                        dVar = new c();
                        break;
                    case 3:
                        dVar = new g();
                        break;
                    case 4:
                        dVar = new a();
                        break;
                }
                if (dVar != null) {
                    dVar.onCreate();
                }
                if (!(dVar == null || aVar2.gBt.containsKey(aVar))) {
                    aVar2.gBt.put(aVar, dVar);
                }
            }
            return (d) aVar2.gBt.get(aVar);
        }
        x.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[]{this.gBq});
        return null;
    }

    @Deprecated
    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear")) {
            x.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
            for (Entry value : gBo.entrySet()) {
                ((a) value.getValue()).clearAll();
            }
            gBp.clear();
            gBn = null;
            e.cgR();
            e.post(new 2(this), "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
    }
}
