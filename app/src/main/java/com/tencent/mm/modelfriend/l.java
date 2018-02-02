package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class l extends j {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    public h hhp;

    public l(h hVar) {
        this.hhp = hVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(k kVar) {
        boolean z = true;
        Cursor a = this.hhp.a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bh.ot(kVar.getUsername()) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            if (kVar != null) {
                ContentValues vI = kVar.vI();
                int update;
                if (vI.size() > 0) {
                    update = this.hhp.update("friend_ext", vI, "username=?", new String[]{"username"});
                } else {
                    update = 0;
                }
            }
            z = false;
        } else {
            if (kVar != null) {
                kVar.fDt = -1;
            }
            z = false;
        }
        doNotify();
        return z;
    }

    public final boolean H(List<k> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        bf bfVar = new bf("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        bfVar.addSplit("transation begin");
        long dz = this.hhp.dz(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                k kVar = (k) list.get(i);
                if (kVar != null) {
                    a(kVar);
                }
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.FriendExtStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.hhp.fS(dz);
        bfVar.addSplit("transation end");
        bfVar.dumpToLog();
        doNotify();
        return z;
    }
}
