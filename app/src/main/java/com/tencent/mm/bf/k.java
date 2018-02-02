package com.tencent.mm.bf;

import android.database.Cursor;
import com.tencent.mm.ad.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import java.util.ArrayList;

public final class k extends i<j> {
    public static final String[] fMK = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] gJN = new String[]{i.a(j.gJc, "shakeverifymessage")};
    public e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(e eVar) {
        super(eVar, j.gJc, "shakeverifymessage", fMK);
        this.gJP = eVar;
    }

    public final int Tq() {
        Cursor a = this.gJP.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        a.close();
        return 0;
    }

    public final int getCount() {
        Cursor a = this.gJP.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                return i;
            }
            return 0;
        }
        a.close();
        return 0;
    }

    public final j Tu() {
        Cursor a = this.gJP.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            j jVar = new j();
            jVar.b(a);
            a.close();
            return jVar;
        }
        a.close();
        return null;
    }

    public final void mY(String str) {
        int delete = this.gJP.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void Tt() {
        this.gJP.delete(getTableName(), null, null);
    }

    public final void a(bw bwVar, d dVar) {
        x.d("MicroMsg.ShakeVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + bwVar.ktm + ", id = " + bwVar.vHe);
        j jVar = new j();
        jVar.field_content = n.a(bwVar.vGZ);
        jVar.field_createtime = bh.Wo();
        jVar.field_imgpath = "";
        jVar.field_sayhicontent = dVar.content;
        jVar.field_sayhiuser = dVar.rYX;
        jVar.field_scene = dVar.scene;
        jVar.field_status = bwVar.ktm > 3 ? bwVar.ktm : 3;
        jVar.field_svrid = bwVar.vHe;
        jVar.field_talker = n.a(bwVar.vGX);
        jVar.field_type = bwVar.ngq;
        jVar.field_isSend = 0;
        a(jVar);
        b.I(jVar.field_sayhiuser, 3);
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b(jVar)) {
            return false;
        } else {
            Wc(jVar.xjy);
            return true;
        }
    }

    public final j ne(String str) {
        j[] W = W(str, 1);
        if (W != null) {
            return W[0];
        }
        return null;
    }

    public final j[] W(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gJP.a("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bh.ot(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            j jVar = new j();
            jVar.b(a);
            arrayList.add(jVar);
        }
        a.close();
        if (arrayList.size() != 0) {
            return (j[]) arrayList.toArray(new j[arrayList.size()]);
        }
        return null;
    }

    public final j[] nf(String str) {
        x.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor a = this.gJP.a("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bh.ot(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            j jVar = new j();
            jVar.b(a);
            arrayList.add(jVar);
        }
        a.close();
        if (arrayList.size() == 0) {
            return null;
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    public static long nd(String str) {
        long j = 0;
        if (str != null) {
            j Tu = l.Tz().Tu();
            if (Tu != null) {
                j = Tu.field_createtime + 1;
            }
        }
        long Wo = bh.Wo();
        return j > Wo ? j : Wo;
    }
}
