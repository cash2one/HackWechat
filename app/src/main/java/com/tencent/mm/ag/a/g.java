package com.tencent.mm.ag.a;

import android.database.Cursor;
import com.tencent.mm.g.b.v;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends i<v> {
    public static final String[] gJN = new String[]{i.a(f.gJc, "BizChatMyUserInfo")};
    private e gJP;
    private final k<a, b> hod = new 1(this);

    public g(e eVar) {
        super(eVar, f.gJc, "BizChatMyUserInfo", null);
        this.gJP = eVar;
        eVar.fx("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    }

    public final f kv(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            return null;
        }
        f fVar = new f();
        fVar.field_brandUserName = str;
        super.b(fVar, new String[0]);
        return fVar;
    }

    public final boolean kw(String str) {
        boolean z = false;
        if (bh.ov(str)) {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
        } else {
            c fVar = new f();
            fVar.field_brandUserName = str;
            z = super.a(fVar, new String[]{"brandUserName"});
            if (z) {
                b bVar = new b();
                bVar.frn = fVar.field_brandUserName;
                bVar.hrc = g$a$a.hqZ;
                bVar.hrd = fVar;
                this.hod.ca(bVar);
                this.hod.doNotify();
            }
        }
        return z;
    }

    public final boolean a(f fVar) {
        x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.b(fVar);
        if (b) {
            b bVar = new b();
            bVar.frn = fVar.field_brandUserName;
            bVar.hrc = g$a$a.hqY;
            bVar.hrd = fVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
        } else {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        return b;
    }

    public final boolean b(f fVar) {
        x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(fVar);
        if (a) {
            b bVar = new b();
            bVar.frn = fVar.field_brandUserName;
            bVar.hrc = g$a$a.hra;
            bVar.hrd = fVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
            return a;
        }
        x.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        return a;
    }

    public final int getCount() {
        int i = 0;
        x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor a = this.gJP.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }
}
