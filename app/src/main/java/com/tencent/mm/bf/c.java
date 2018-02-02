package com.tencent.mm.bf;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<b> implements a {
    public static final String[] gJN = new String[]{i.a(b.gJc, "fmessage_conversation")};
    private static final String[] hSV = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    private final int fgr = 1;
    public e gJP;
    private Runnable hSW = new 1(this);
    protected Context mContext = null;

    public c(e eVar) {
        super(eVar, b.gJc, "fmessage_conversation", hSV);
        this.gJP = eVar;
        this.mContext = ac.getContext();
    }

    public final Cursor Tj() {
        return this.gJP.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    }

    public final int getCount() {
        int i = 0;
        Cursor a = this.gJP.a("select count(*) from fmessage_conversation", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        x.d("MicroMsg.FMessageConversationStorage", "getCount = " + i);
        return i;
    }

    public final boolean T(String str, int i) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c mT = mT(str);
        if (mT == null) {
            x.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = " + str);
            return false;
        } else if (i == mT.field_state) {
            x.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            return true;
        } else {
            mT.field_state = i;
            mT.field_lastModifiedTime = System.currentTimeMillis();
            if (!super.c(mT, new String[0])) {
                return false;
            }
            Wc(str);
            return true;
        }
    }

    public final boolean Tk() {
        if (this.gJP.fx("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            x.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            return true;
        }
        x.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        return false;
    }

    public final int Tl() {
        int i = 0;
        Cursor a = this.gJP.a(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        x.d("MicroMsg.FMessageConversationStorage", "getNewCount = " + i);
        return i;
    }

    public final List<String> Tm() {
        Cursor a = this.gJP.a(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(a.getColumnIndex("contentNickname")));
        }
        a.close();
        return arrayList;
    }

    public final boolean mS(String str) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c mT = mT(str);
        if (mT == null || !str.equals(mT.field_talker)) {
            x.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = " + str);
            return false;
        }
        mT.field_isNew = 0;
        return super.c(mT, new String[0]);
    }

    public final b mT(String str) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            return null;
        }
        b bVar = new b();
        bVar.field_talker = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        x.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = " + str);
        return null;
    }

    public final b mU(String str) {
        b bVar = null;
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
        } else {
            Cursor a = this.gJP.a("select * from fmessage_conversation  where encryptTalker=" + h.fe(str), null, 2);
            if (a.moveToFirst()) {
                bVar = new b();
                bVar.b(a);
            }
            a.close();
        }
        return bVar;
    }

    public final void a(String str, l lVar) {
        int i = 0;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            return;
        }
        long j;
        try {
            j = bh.getLong(str, 0);
        } catch (Exception e) {
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        } else if (g.Dh().Cy()) {
            com.tencent.mm.sdk.e.c fVar = new f();
            if (l.Tw().b(j, fVar)) {
                x.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = " + j);
                com.tencent.mm.sdk.e.c mT = l.Tx().mT(fVar.field_talker);
                if (mT == null) {
                    x.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + fVar.field_talker);
                    if (bh.ov(fVar.field_talker)) {
                        x.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                        return;
                    }
                    com.tencent.mm.sdk.e.c bVar = new b();
                    if (fVar.field_type == 0) {
                        au.a Xr = au.a.Xr(fVar.field_msgContent);
                        bVar.field_displayName = Xr.getDisplayName();
                        if (Xr.scene == 4 && Xr.cjG() != null) {
                            bVar.field_displayName = Xr.cjG();
                        }
                        bVar.field_addScene = Xr.scene;
                        bVar.field_isNew = 1;
                        bVar.field_contentFromUsername = Xr.rYX;
                        bVar.field_contentNickname = Xr.fpL;
                        bVar.field_contentPhoneNumMD5 = Xr.xzj;
                        bVar.field_contentFullPhoneNumMD5 = Xr.xzk;
                        x.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                    } else if (fVar.To()) {
                        d Xu = d.Xu(fVar.field_msgContent);
                        bVar.field_displayName = Xu.getDisplayName();
                        bVar.field_addScene = Xu.scene;
                        bVar.field_isNew = 1;
                        bVar.field_contentFromUsername = Xu.rYX;
                        bVar.field_contentNickname = Xu.fpL;
                        bVar.field_contentVerifyContent = Xu.content;
                        x.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                    }
                    bVar.field_lastModifiedTime = System.currentTimeMillis();
                    bVar.field_state = 0;
                    bVar.field_talker = fVar.field_talker;
                    bVar.field_encryptTalker = fVar.field_encryptTalker;
                    bVar.field_fmsgSysRowId = j;
                    bVar.field_fmsgIsSend = fVar.field_isSend;
                    bVar.field_fmsgType = fVar.field_type;
                    bVar.field_fmsgContent = fVar.field_msgContent;
                    if (fVar.To()) {
                        i = fVar.field_type;
                    }
                    bVar.field_recvFmsgType = i;
                    x.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + bVar.field_fmsgContent);
                    l.Tx().b(bVar);
                } else {
                    x.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + fVar.field_talker);
                    if (fVar.To()) {
                        mT.field_isNew = 1;
                    }
                    mT.field_lastModifiedTime = System.currentTimeMillis();
                    mT.field_encryptTalker = fVar.field_encryptTalker;
                    mT.field_fmsgSysRowId = j;
                    mT.field_fmsgIsSend = fVar.field_isSend;
                    mT.field_fmsgType = fVar.field_type;
                    mT.field_fmsgContent = fVar.field_msgContent;
                    if (fVar.To()) {
                        mT.field_recvFmsgType = fVar.field_type;
                        x.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + mT.field_recvFmsgType);
                    }
                    if (fVar.field_type == 0) {
                        au.a Xr2 = au.a.Xr(fVar.field_msgContent);
                        mT.field_contentFromUsername = Xr2.rYX;
                        mT.field_contentNickname = Xr2.fpL;
                        mT.field_contentPhoneNumMD5 = Xr2.xzj;
                        mT.field_contentFullPhoneNumMD5 = Xr2.xzk;
                        x.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + mT.field_contentFromUsername + "new friend Nickname: " + mT.field_contentNickname);
                    } else if (fVar.To()) {
                        if ((fVar.field_isSend >= 2 ? 1 : 0) == 0) {
                            d Xu2 = d.Xu(fVar.field_msgContent);
                            mT.field_contentVerifyContent = Xu2.content;
                            mT.field_contentFromUsername = Xu2.rYX;
                            mT.field_contentNickname = Xu2.fpL;
                            x.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + mT.field_contentVerifyContent + " receive, new friend Username: " + mT.field_contentFromUsername + " new friend Nickname: " + mT.field_contentNickname);
                            String str2 = mT.field_contentFromUsername;
                            String str3 = mT.field_contentNickname;
                            b kkVar = new kk();
                            kkVar.fBI.userName = str2;
                            kkVar.fBI.bgo = str3;
                            kkVar.fBI.type = 1;
                            com.tencent.mm.sdk.b.a.xef.m(kkVar);
                        }
                    }
                    l.Tx().c(mT, new String[0]);
                    if (Tl() == 0) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(340225, Long.valueOf(System.currentTimeMillis()));
                    }
                }
                Tn();
                return;
            }
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = " + j);
        } else {
            x.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        }
    }

    public final void Tn() {
        ag.K(this.hSW);
        ag.h(this.hSW, 500);
    }

    public final boolean d(long j, String str) {
        String str2;
        x.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", new Object[]{Long.valueOf(j), str});
        if (!bh.ov(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + bh.ot(str) + "'";
        } else if (j <= 0) {
            return false;
        } else {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j + "'";
        }
        if (!this.gJP.fx("fmessage_conversation", str2)) {
            return false;
        }
        x.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", new Object[]{Long.valueOf(j), str});
        Wc(str);
        return true;
    }
}
