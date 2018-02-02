package com.tencent.mm.ad;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;

public final class g extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    h hhp;

    public g(h hVar) {
        this.hhp = hVar;
    }

    public final int a(String str, f fVar) {
        return this.hhp.update("hdheadimginfo", fVar.vI(), "username=?", new String[]{str});
    }

    public final f jk(String str) {
        f fVar = null;
        Cursor a = this.hhp.a("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bh.ot(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                fVar = new f();
                fVar.username = a.getString(0);
                fVar.hlm = a.getInt(1);
                fVar.hln = a.getInt(2);
                fVar.hlo = a.getString(3);
                fVar.hlp = a.getInt(4);
                fVar.hlq = a.getInt(5);
                fVar.hlr = a.getInt(6);
                fVar.hls = a.getString(7);
                fVar.hlt = a.getString(8);
                fVar.hlu = a.getInt(9);
                fVar.hlv = a.getInt(10);
            }
            a.close();
        }
        return fVar;
    }
}
