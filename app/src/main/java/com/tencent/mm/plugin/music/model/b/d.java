package com.tencent.mm.plugin.music.model.b;

import android.text.TextUtils;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;

public final class d {
    private static z<String, String> oLh = new z(20);
    private static z<String, Long> oLi = new z(20);

    public static void f(a aVar) {
        boolean z = true;
        boolean z2 = false;
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, music is null");
            return;
        }
        int i;
        boolean isWifi = an.isWifi(ac.getContext());
        PBool pBool = new PBool();
        String a = g.a(bh.ov(aVar.field_songWifiUrl) ? aVar.field_songWebUrl : aVar.field_songWifiUrl, aVar.field_songWapLinkUrl, isWifi, pBool);
        x.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", new Object[]{a});
        x.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", new Object[]{aVar.field_songWifiUrl});
        String str = "MicroMsg.Music.MusicUrlParser";
        String str2 = "isWifi:%d, isQQMusic:%d";
        Object[] objArr = new Object[2];
        if (isWifi) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(pBool.value ? 1 : 0);
        x.i(str, str2, objArr);
        if (isWifi) {
            z2 = pBool.value;
        }
        if (g.FM(a)) {
            x.i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
        } else {
            z = z2;
        }
        aVar.hHQ = a;
        e.at(a, z);
    }

    public static void dw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oLh.put(str, str2);
            oLi.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static String Gi(String str) {
        String str2 = (TextUtils.isEmpty(str) || !oLh.bt(str)) ? null : (String) oLh.get(str);
        if (str2 == null) {
            return str;
        }
        return str2;
    }

    public static boolean g(a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.hHQ)) {
            return false;
        }
        if (!Gj(aVar.hHQ)) {
            return false;
        }
        if (g.tr(aVar.field_musicType)) {
            if (e.i(aVar)) {
                x.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
                return false;
            }
        } else if (e.h(aVar)) {
            x.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
            return false;
        }
        if (!oLh.bt(aVar.hHQ)) {
            return true;
        }
        long j = 0;
        if (oLi.bt(aVar.hHQ)) {
            j = ((Long) oLi.get(aVar.hHQ)).longValue();
        }
        if (System.currentTimeMillis() - j <= 86400000) {
            return false;
        }
        oLh.remove(aVar.hHQ);
        oLi.remove(aVar.hHQ);
        x.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
        return true;
    }

    public static boolean Gj(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("wxshakemusic")) {
            return true;
        }
        return false;
    }

    public static String Gk(String str) {
        if (!Gj(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("wxshakemusic");
        if (lastIndexOf > 1) {
            return str.substring(0, lastIndexOf - 1);
        }
        return str;
    }
}
