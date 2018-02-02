package com.tencent.mm.plugin.appbrand.media;

import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d {
    public String frn;
    public String fvL;
    public int fvM;
    private HashMap<String, c> hxK;
    public String jzA;
    public String jzB;

    private d() {
        this.hxK = new HashMap();
    }

    public final boolean br(String str, String str2) {
        if (str2.equalsIgnoreCase("play")) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[]{str, this.jzA});
            return true;
        }
        if (str.equalsIgnoreCase(this.jzA)) {
            asv Qs = b.Qs();
            if (Qs != null && Qs.vVZ.equals(this.jzB)) {
                return true;
            }
        }
        return false;
    }

    public final void a(c cVar, String str) {
        if (this.hxK.get(str) != null) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[]{str});
            return;
        }
        a.xef.b(cVar);
        this.hxK.put(str, cVar);
    }

    public final void sg(String str) {
        if (this.hxK.get(str) == null) {
            x.i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[]{str});
            return;
        }
        a.xef.c((c) this.hxK.remove(str));
        this.hxK.remove(str);
    }

    public final boolean tj(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            return false;
        } else if (!str.equalsIgnoreCase(this.jzA)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            return false;
        } else if (TextUtils.isEmpty(this.jzB)) {
            x.e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            return false;
        } else {
            asv Qs = b.Qs();
            if (Qs == null) {
                x.e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                return false;
            } else if (!this.jzB.equalsIgnoreCase(Qs.vVZ)) {
                x.e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                return false;
            } else if (b.Qq()) {
                return true;
            } else {
                x.i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                return false;
            }
        }
    }
}
