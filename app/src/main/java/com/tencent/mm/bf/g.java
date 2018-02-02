package com.tencent.mm.bf;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class g extends i<f> {
    public static final String[] gJN = new String[]{i.a(f.gJc, "fmessage_msginfo")};
    private static final String[] hSV = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public g(e eVar) {
        super(eVar, f.gJc, "fmessage_msginfo", hSV);
        this.gJP = eVar;
    }

    public final f[] mV(String str) {
        x.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor a = this.gJP.a("select *, rowid from fmessage_msginfo  where talker = '" + bh.ot(str) + "' order by createTime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            f fVar = new f();
            fVar.b(a);
            arrayList.add(fVar);
        }
        a.close();
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    public final f mW(String str) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
        } else {
            Cursor a = this.gJP.a("select * from fmessage_msginfo where talker = '" + bh.ot(str) + "' order by createTime DESC limit 1", null, 2);
            fVar = new f();
            if (a.moveToFirst()) {
                fVar.b(a);
            }
            a.close();
        }
        return fVar;
    }

    public final f mX(String str) {
        f[] U = U(str, 1);
        if (U == null || U.length <= 0) {
            return null;
        }
        return U[0];
    }

    public final f[] U(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gJP.a("select * from fmessage_msginfo where isSend != 1 and talker = '" + bh.ot(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            f fVar = new f();
            fVar.b(a);
            arrayList.add(fVar);
        }
        a.close();
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    public final boolean a(f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            return false;
        } else if (!super.b(fVar)) {
            return false;
        } else {
            Wc(fVar.xjy);
            return true;
        }
    }

    public final ArrayList<f> Tp() {
        x.d("MicroMsg.FMessageMsgInfoStorage", new StringBuilder("getFMsgByType, type = 0").toString());
        ArrayList<f> arrayList = new ArrayList();
        Cursor a = this.gJP.a(new StringBuilder("select *, rowid from fmessage_msginfo where type = 0").toString(), null, 2);
        while (a.moveToNext()) {
            f fVar = new f();
            fVar.b(a);
            arrayList.add(fVar);
        }
        a.close();
        x.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        return arrayList;
    }
}
