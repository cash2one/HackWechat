package com.tencent.mm.plugin.music.model.b;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mm.plugin.music.model.b.a.1;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.h.b;
import com.tencent.mm.plugin.music.model.h.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class e {
    private static z<String, String> oLj = new z(20);
    private static z<String, Boolean> oLk = new z(20);
    private static z<String, Integer> oLl = new z(20);
    private static z<String, Integer> oLm = new z(20);
    private static z<String, Long> oLn = new z(20);
    private static z<String, String> oLo = new z(20);

    public static void Gl(String str) {
        b bVar;
        c bdD = h.bdD();
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
            bVar = null;
        } else {
            int i;
            String FQ = g.FQ(str);
            b Gy = bdD.Gy(FQ);
            if (Gy == null) {
                bVar = new b();
                i = 0;
            } else {
                bVar = Gy;
                i = 1;
            }
            bVar.field_musicId = FQ;
            bVar.field_musicUrl = str;
            bVar.field_fileName = g.FL(str);
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[]{FQ, bVar.field_fileName});
            if (i != 0) {
                x.i("MicroMsg.PieceMusicInfoStorage", "update PieceMusicInfo");
                bdD.c(bVar, new String[0]);
            } else {
                x.i("MicroMsg.PieceMusicInfoStorage", "insert PieceMusicInfo");
                bdD.b(bVar);
            }
            bdD.oMR.put(FQ, bVar);
        }
        if (bVar != null) {
            CharSequence charSequence = bVar.field_musicId;
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence))) {
                oLj.put(str, charSequence);
            }
            List arrayList = new ArrayList(1);
            arrayList.add(bVar.field_musicId);
            a aVar = new a(arrayList);
            ar.Hg();
            long longValue = ((Long) com.tencent.mm.z.c.CU().get(a.xut, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue <= a.oKX.longValue()) {
                x.e("MicroMsg.CleanMusicController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
                return;
            }
            x.i("MicroMsg.CleanMusicController", "start clean music file");
            ar.Hg();
            com.tencent.mm.z.c.CU().a(a.xut, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new 1(aVar), "CleanMusicController");
        }
    }

    public static String Gm(String str) {
        if (oLj.bt(str)) {
            return (String) oLj.get(str);
        }
        return "";
    }

    public static void at(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            oLk.put(str, Boolean.valueOf(z));
        }
    }

    public static boolean Gn(String str) {
        if (oLk.bt(str)) {
            return ((Boolean) oLk.get(str)).booleanValue();
        }
        return false;
    }

    public static void i(String str, Map<String, String> map) {
        if (map != null && Gn(str)) {
            map.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
            map.put("referer", "stream12.qqmusic.qq.com");
        }
    }

    public static void dx(String str, String str2) {
        x.i("MicroMsg.PieceCacheHelper", "setMusicMIMEType mimeType:%s", new Object[]{str2});
        Object Gm = Gm(str);
        if (TextUtils.isEmpty(Gm)) {
            x.e("MicroMsg.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            return;
        }
        b Gy = h.bdD().Gy(Gm);
        if (Gy == null) {
            x.e("MicroMsg.PieceCacheHelper", "setMusicMIMEType pMusic is null!'");
        } else if (TextUtils.isEmpty(Gy.field_pieceFileMIMEType)) {
            x.e("MicroMsg.PieceCacheHelper", "updatePieceFileMIMEType()'");
            c bdD = h.bdD();
            ContentValues contentValues = new ContentValues();
            contentValues.put("pieceFileMIMEType", str2);
            int update = bdD.gJP.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{Gm});
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", new Object[]{Integer.valueOf(update), Gm});
            b bVar = (b) bdD.oMR.get(Gm);
            if (bVar != null) {
                bVar.field_pieceFileMIMEType = str2;
            }
        } else {
            x.i("MicroMsg.PieceCacheHelper", "don't need update the piece fle mime type");
        }
    }

    public static String Go(String str) {
        Object Gm = Gm(str);
        if (TextUtils.isEmpty(Gm)) {
            x.e("MicroMsg.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            return null;
        }
        b Gy = h.bdD().Gy(Gm);
        if (Gy == null) {
            x.e("MicroMsg.PieceCacheHelper", "getMusicMIMEType pMusic is null!'");
            return null;
        }
        x.i("MicroMsg.PieceCacheHelper", "music field_pieceFileMIMEType:%s", new Object[]{Gy.field_pieceFileMIMEType});
        if (!TextUtils.isEmpty(Gy.field_pieceFileMIMEType)) {
            return Gy.field_pieceFileMIMEType;
        }
        x.e("MicroMsg.PieceCacheHelper", "field_pieceFileMIMEType is null!'");
        return null;
    }

    public static String Gp(String str) {
        if (oLo.bt(str)) {
            return (String) oLo.get(str);
        }
        return null;
    }

    public static void dy(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oLo.put(str, str2);
        }
    }

    public static long Gq(String str) {
        if (oLn.bt(str)) {
            return ((Long) oLn.get(str)).longValue();
        }
        return -1;
    }

    public static void T(String str, long j) {
        if (j > 0) {
            oLn.put(str, Long.valueOf(j));
        }
    }

    public static long Gr(String str) {
        File file = new File(g.FL(str));
        return file.exists() ? file.length() : -1;
    }

    public static void deleteFile(String str) {
        Logger.i("MicroMsg.PieceFileCache", "deleteFileByUrl");
        f.deleteFile(g.FL(str));
    }

    public static void bJ(String str, int i) {
        if (str != null) {
            oLl.put(str, Integer.valueOf(i));
        }
    }

    public static int Gs(String str) {
        if (str == null || !oLl.bt(str)) {
            return 0;
        }
        return ((Integer) oLl.get(str)).intValue();
    }

    public static void bK(String str, int i) {
        if (str != null) {
            oLm.put(str, Integer.valueOf(i));
        }
    }

    public static int Gt(String str) {
        if (str == null || !oLm.bt(str)) {
            return 0;
        }
        return ((Integer) oLm.get(str)).intValue();
    }

    public static boolean h(com.tencent.mm.av.a aVar) {
        boolean isWifi = an.isWifi(ac.getContext());
        boolean z = isWifi ? aVar.field_wifiEndFlag == 1 : aVar.field_endFlag == 1;
        if (z && new File(g.b(aVar, isWifi)).exists()) {
            return true;
        }
        return false;
    }

    public static boolean i(com.tencent.mm.av.a aVar) {
        boolean z;
        if (aVar == null || TextUtils.isEmpty(aVar.hHQ)) {
            z = false;
        } else {
            b Gy = h.bdD().Gy(g.FQ(aVar.hHQ));
            z = Gy != null && Gy.field_fileCacheComplete == 1;
        }
        if (z) {
            String str = aVar.hHQ;
            Logger.i("MicroMsg.PieceFileCache", "existFileByUrl");
            str = g.FL(str);
            Logger.i("MicroMsg.PieceFileCache", "existFile, fileName:" + str);
            x.i("MicroMsg.PieceFileCache", "the piece File exist:%b", new Object[]{Boolean.valueOf(new File(str).exists())});
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }
}
