package com.tencent.mm.bf;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.ad.b;
import com.tencent.mm.g.b.ca;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class i extends com.tencent.mm.sdk.e.i<h> {
    public static final String[] gJN = new String[]{com.tencent.mm.sdk.e.i.a(h.gJc, "LBSVerifyMessage")};
    public e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return a((h) cVar);
    }

    public i(e eVar) {
        super(eVar, h.gJc, "LBSVerifyMessage", ca.fMK);
        this.gJP = eVar;
    }

    public final int Tq() {
        Cursor a = this.gJP.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            return i;
        }
        a.close();
        return 0;
    }

    public final int getCount() {
        int i = 0;
        Cursor a = this.gJP.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final h Tr() {
        Cursor a = this.gJP.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            h hVar = new h();
            hVar.b(a);
            a.close();
            return hVar;
        }
        a.close();
        return null;
    }

    public final void Ts() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        if (this.gJP.update(getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            doNotify();
        }
    }

    public final void mY(String str) {
        int delete = this.gJP.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void mZ(String str) {
        int delete = this.gJP.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + delete);
    }

    public final void Tt() {
        this.gJP.delete(getTableName(), null, null);
    }

    public final void a(bw bwVar, d dVar) {
        x.d("MicroMsg.LBSVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + bwVar.ktm + ", id = " + bwVar.vHe);
        h hVar = new h();
        hVar.field_content = n.a(bwVar.vGZ);
        hVar.field_createtime = bh.Wo();
        hVar.field_imgpath = "";
        hVar.field_sayhicontent = dVar.content;
        hVar.field_sayhiuser = dVar.rYX;
        hVar.field_scene = dVar.scene;
        hVar.field_status = bwVar.ktm > 3 ? bwVar.ktm : 3;
        hVar.field_svrid = bwVar.vHe;
        hVar.field_talker = n.a(bwVar.vGX);
        hVar.field_type = bwVar.ngq;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = dVar.xzu;
        hVar.field_ticket = dVar.mOi;
        hVar.field_flag = 1;
        a(hVar);
        b.I(hVar.field_sayhiencryptuser, 3);
    }

    public final boolean a(h hVar) {
        if (hVar == null) {
            x.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            return false;
        } else if (!super.b(hVar)) {
            return false;
        } else {
            Wc(hVar.xjy);
            return true;
        }
    }

    public final h[] na(String str) {
        x.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor a = this.gJP.a("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bh.ot(str) + "' or sayhiencryptuser = '" + bh.ot(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            h hVar = new h();
            hVar.b(a);
            arrayList.add(hVar);
        }
        a.close();
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public final h nb(String str) {
        h hVar = null;
        x.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor a = this.gJP.a("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bh.ot(str) + "' or sayhiencryptuser = '" + bh.ot(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            hVar = new h();
            hVar.b(a);
        } else {
            x.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        a.close();
        return hVar;
    }

    public final h nc(String str) {
        h[] V = V(str, 1);
        if (V != null) {
            return V[0];
        }
        return null;
    }

    public final h[] V(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            return null;
        }
        Cursor a = this.gJP.a("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bh.ot(str) + "' or sayhiencryptuser = '" + bh.ot(str) + "') order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            h hVar = new h();
            hVar.b(a);
            arrayList.add(hVar);
        }
        a.close();
        return (h[]) arrayList.toArray(new h[arrayList.size()]);
    }

    public static long nd(String str) {
        h hVar = null;
        long j = 0;
        if (str != null) {
            i Ty = l.Ty();
            Cursor a = Ty.gJP.a("SELECT * FROM " + Ty.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    hVar = new h();
                    hVar.b(a);
                    a.close();
                } else {
                    a.close();
                }
            }
            if (hVar != null) {
                j = hVar.field_createtime + 1;
            }
        }
        long Wo = bh.Wo();
        return j > Wo ? j : Wo;
    }
}
