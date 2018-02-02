package com.tencent.mm.modelfriend;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class p extends i<o> implements a {
    public static final String[] gJN = new String[]{i.a(o.gJc, "GoogleFriend")};
    public e gJP;
    public m hwl = new 1(this);

    public final /* synthetic */ boolean b(c cVar) {
        return a((o) cVar);
    }

    public p(e eVar) {
        super(eVar, o.gJc, "GoogleFriend", null);
        this.gJP = eVar;
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    private boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (((int) this.gJP.insert("GoogleFriend", "googleitemid", oVar.vI())) > 0) {
            return true;
        }
        return false;
    }

    public final boolean f(ArrayList<o> arrayList) {
        int i = 0;
        if (arrayList.size() <= 0) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            return false;
        }
        long dz;
        h hVar;
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", new Object[]{Long.valueOf(dz)});
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        while (i < arrayList.size()) {
            a((o) arrayList.get(i));
            i++;
        }
        if (hVar != null) {
            hVar.fS(dz);
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.hwl.b(2, this.hwl, "");
        return true;
    }

    public final Cursor kZ(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        return this.gJP.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder, null);
    }

    public final boolean b(o oVar) {
        Cursor a = this.gJP.a("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bh.ot(oVar.field_googleitemid) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (!moveToFirst) {
            return a(oVar);
        }
        int update = this.gJP.update("GoogleFriend", oVar.vI(), new StringBuilder("googleitemid=?").toString(), new String[]{oVar.field_googleitemid});
        if (update > 0) {
            doNotify();
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean M(String str, int i) {
        return this.gJP.fx("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid='" + str + "'");
    }

    public final boolean N(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.gJP.fx("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status='0" + "' WHERE username='" + str + "'");
    }

    public final void clear() {
        this.gJP.fx("GoogleFriend", " delete from GoogleFriend");
        this.hwl.b(5, this.hwl, "");
    }
}
