package com.tencent.mm.plugin.music.model.b;

import android.database.Cursor;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static final Long leU = Long.valueOf(604800000);
    private static final Long oKT = Long.valueOf(2592000000L);
    private static final Long oKU = Long.valueOf(86400000);
    public static final Long oKV = Long.valueOf(43200000);
    private static final Long oKW = Long.valueOf(240000);
    static final Long oKX = oKU;
    private static final Long oKY = Long.valueOf(60000);
    private List<String> oKS = new ArrayList(10);

    static /* synthetic */ void a(a aVar) {
        x.i("MicroMsg.CleanMusicController", "clean music piece file");
        ar.Hg();
        String FC = c.FC();
        FC = FC.endsWith("/") ? FC + "music" : FC + File.separator + "music";
        File file = new File(FC);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                x.i("MicroMsg.CleanMusicController", "none files exist");
                return;
            }
            for (String str : list) {
                if (aVar.Gh(str)) {
                    x.i("MicroMsg.CleanMusicController", "file is the block file, don't delete");
                } else {
                    File file2 = new File(FC + File.separator + str);
                    if (!file2.exists()) {
                        x.i("MicroMsg.CleanMusicController", "file not exist");
                    } else if (file2.isDirectory()) {
                        x.i("MicroMsg.CleanMusicController", "file is directory, don't delete");
                    } else if (System.currentTimeMillis() - file2.lastModified() > oKT.longValue()) {
                        x.e("MicroMsg.CleanMusicController", "Clean 7 days file in music file name=%s, path:%s", new Object[]{file2.getName(), file2.getAbsolutePath()});
                        file2.delete();
                        if (str.startsWith("piece")) {
                            x.e("MicroMsg.CleanMusicController", "file is piece prefix, delete the piece info in db");
                            com.tencent.mm.plugin.music.model.h.c bdD = h.bdD();
                            int delete = bdD.gJP.delete("PieceMusicInfo", "musicId=?", new String[]{str});
                            x.i("MicroMsg.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[]{Integer.valueOf(delete), str});
                            bdD.oMR.remove(str);
                        }
                    } else {
                        x.i("MicroMsg.CleanMusicController", "not delete the file, file is in valid time for 7 day");
                    }
                }
            }
            return;
        }
        x.i("MicroMsg.CleanMusicController", "musicFolder is not exist or not Directory");
    }

    static /* synthetic */ void bei() {
        x.i("MicroMsg.CleanMusicController", "scanMusicFile");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.music.model.h.a bdA = h.bdA();
        String format = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ? limit 10", new Object[]{"Music"});
        long currentTimeMillis2 = System.currentTimeMillis() - 604800000;
        List<com.tencent.mm.av.a> arrayList = new ArrayList();
        Cursor rawQuery = bdA.gJP.rawQuery(format, new String[]{String.valueOf(currentTimeMillis2), "6"});
        while (rawQuery.moveToNext()) {
            com.tencent.mm.av.a aVar = new com.tencent.mm.av.a();
            aVar.b(rawQuery);
            arrayList.add(aVar);
        }
        rawQuery.close();
        for (com.tencent.mm.av.a aVar2 : arrayList) {
            String b = g.b(aVar2, true);
            String b2 = g.b(aVar2, false);
            String c = g.c(aVar2, false);
            String c2 = g.c(aVar2, true);
            FileOp.deleteFile(b);
            FileOp.deleteFile(b2);
            FileOp.deleteFile(c);
            FileOp.deleteFile(c2);
            com.tencent.mm.plugin.music.model.h.a bdA2 = h.bdA();
            b2 = aVar2.field_musicId;
            bdA2.oMR.remove(b2);
            bdA2.oMS.remove(b2);
            bdA2 = h.bdA();
            b2 = aVar2.field_musicId;
            int delete = bdA2.gJP.delete("Music", "musicId=?", new String[]{b2});
            x.i("MicroMsg.CleanMusicController", "delete music %d %s", new Object[]{Integer.valueOf(delete), aVar2.field_musicId});
        }
        x.i("MicroMsg.CleanMusicController", "scanMusic UseTime=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ArrayList arrayList2 = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.g.CTRL_INDEX);
        iDKey.SetKey(i.CTRL_BYTE);
        iDKey.SetValue((long) ((int) r0));
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.g.CTRL_INDEX);
        iDKey2.SetKey(255);
        iDKey2.SetValue(1);
        arrayList2.add(iDKey);
        arrayList2.add(iDKey2);
        com.tencent.mm.plugin.report.service.g.pQN.a(arrayList2, false);
    }

    public a(List<String> list) {
        if (!list.isEmpty()) {
            this.oKS.addAll(list);
        }
    }

    private boolean Gh(String str) {
        for (String contains : this.oKS) {
            if (str.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
