package com.tencent.mm.ag.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.g.b.u;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends i<u> {
    public static final String[] gJN = new String[]{i.a(c.gJc, "BizChatInfo")};
    public e gJP;
    final k<a, b> hod = new 1(this);
    private AtomicLong hqJ = new AtomicLong(-1);

    public interface a {
        void a(b bVar);
    }

    public d(e eVar) {
        super(eVar, c.gJc, "BizChatInfo", null);
        this.gJP = eVar;
        eVar.fx("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        eVar.fx("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        eVar.fx("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.hqJ) {
            Cursor a = this.gJP.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
            long j = 0;
            if (a.moveToFirst()) {
                j = (long) a.getInt(0);
                if (j > this.hqJ.get()) {
                    this.hqJ.set(j);
                }
            }
            a.close();
            x.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + j);
        }
    }

    public final void a(a aVar, Looper looper) {
        this.hod.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hod != null) {
            this.hod.remove(aVar);
        }
    }

    public final c ag(long j) {
        c cVar = new c();
        cVar.field_bizChatLocalId = j;
        super.b(cVar, new String[0]);
        return cVar;
    }

    public final c kl(String str) {
        c cVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        x.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }

    public final boolean aT(long j) {
        c ag = ag(j);
        boolean a = super.a(ag, new String[]{"bizChatLocalId"});
        if (a) {
            b bVar = new b();
            bVar.hqF = ag.field_bizChatLocalId;
            bVar.frn = ag.field_brandUserName;
            bVar.hqP = a.hqM;
            bVar.hqQ = ag;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return a;
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            return false;
        } else if (bh.ov(cVar.field_bizChatServId)) {
            x.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            return false;
        } else {
            c kl = kl(cVar.field_bizChatServId);
            if (kl != null) {
                cVar.field_bizChatLocalId = kl.field_bizChatLocalId;
                x.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                return true;
            }
            cVar.field_bizChatLocalId = Mv();
            boolean b = super.b(cVar);
            if (!b) {
                return b;
            }
            b bVar = new b();
            bVar.hqF = cVar.field_bizChatLocalId;
            bVar.frn = cVar.field_brandUserName;
            bVar.hqP = a.hqL;
            bVar.hqQ = cVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
            return b;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
        } else if (cVar.field_bizChatLocalId < 0) {
            x.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
        } else {
            c ag = ag(cVar.field_bizChatLocalId);
            if (bh.ov(ag.field_bizChatServId) || ag.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || bh.ov(cVar.field_chatName)) {
                    x.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = com.tencent.mm.platformtools.c.ol(cVar.field_chatName);
                }
                z = super.a(cVar);
                if (z) {
                    e.g(cVar);
                    b bVar = new b();
                    bVar.hqF = cVar.field_bizChatLocalId;
                    bVar.frn = cVar.field_brandUserName;
                    bVar.hqP = a.hqN;
                    bVar.hqQ = cVar;
                    this.hod.ca(bVar);
                    this.hod.doNotify();
                }
            } else {
                x.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
            }
        }
        return z;
    }

    private long Mv() {
        synchronized (this.hqJ) {
            x.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[]{Long.valueOf(this.hqJ.incrementAndGet())});
        }
        return r2;
    }
}
