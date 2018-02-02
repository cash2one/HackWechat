package com.tencent.mm.ag.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.o;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;

public final class b extends i<a> implements com.tencent.mm.sdk.e.m.b {
    public static final String[] gJN = new String[]{i.a(a.gJc, "BizChatConversation")};
    public e gJP;
    final k<a, b> hod = new 1(this);

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public b(e eVar) {
        super(eVar, a.gJc, "BizChatConversation", null);
        this.gJP = eVar;
        eVar.fx("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        eVar.fx("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        eVar.fx("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor a = eVar.a("PRAGMA table_info( BizChatConversation)", null, 2);
        while (a.moveToNext()) {
            int columnIndex = a.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        a.close();
        if (obj == null) {
            eVar.fx("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((h) g.h(h.class)).EY().a(this);
    }

    protected final void finalize() {
        ((h) g.h(h.class)).EY().b(this);
    }

    public final void a(a aVar, Looper looper) {
        this.hod.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hod != null) {
            this.hod.remove(aVar);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        x.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (f.eE(str) && !s.gE(str)) {
                e.A(str, true);
            }
        }
    }

    public final a aS(long j) {
        c aVar = new a();
        aVar.field_bizChatId = j;
        super.b(aVar, new String[0]);
        return aVar;
    }

    public final boolean aT(long j) {
        c aS = aS(j);
        boolean a = super.a(aS, new String[]{"bizChatId"});
        if (a) {
            b bVar = new b();
            bVar.hqF = aS.field_bizChatId;
            bVar.frn = aS.field_brandUserName;
            bVar.hqE = a.hqB;
            bVar.hqG = aS;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return a;
    }

    public final boolean a(a aVar) {
        x.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            x.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b(aVar);
        x.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", new Object[]{Boolean.valueOf(b)});
        if (b) {
            b bVar = new b();
            bVar.hqF = aVar.field_bizChatId;
            bVar.frn = aVar.field_brandUserName;
            bVar.hqE = a.hqA;
            bVar.hqG = aVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return b;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.BizConversationStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(aVar);
        x.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", new Object[]{Boolean.valueOf(a)});
        if (a) {
            e.g(y.Mh().ag(aVar.field_bizChatId));
            b bVar = new b();
            bVar.hqF = aVar.field_bizChatId;
            bVar.frn = aVar.field_brandUserName;
            bVar.hqE = a.hqC;
            bVar.hqG = aVar;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return a;
    }

    public final Cursor kj(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , ").append("lastMsgTime desc");
        x.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", new Object[]{stringBuilder.toString()});
        return this.gJP.rawQuery(stringBuilder.toString(), null);
    }

    public static void a(a aVar, int i, int i2) {
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ((o) g.h(o.class)).Fb().ap(aVar.field_brandUserName, aVar.field_bizChatId);
            x.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aVar.field_msgCount -= i;
            if (aVar.field_msgCount < 0) {
                x.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            aVar.field_msgCount += i2;
        }
        x.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", new Object[]{Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean aU(long j) {
        a aS = aS(j);
        if (!(aS.field_unReadCount == 0 && aS.field_bizChatId == j)) {
            aS.field_unReadCount = 0;
            aS.field_atCount = 0;
            b(aS);
        }
        return true;
    }

    public static long a(a aVar, int i, long j) {
        if (aVar == null) {
            return 0;
        }
        if (j == 0) {
            j = bh.Wp();
        }
        switch (i) {
            case 2:
                return a(aVar, j) | 4611686018427387904L;
            case 3:
                return a(aVar, j) & -4611686018427387905L;
            case 4:
                return a(aVar, j) & 4611686018427387904L;
            default:
                return a(aVar, j);
        }
    }

    private static long a(a aVar, long j) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    public final boolean aV(long j) {
        return c(aS(j));
    }

    public static boolean c(a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (a(aVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean aW(long j) {
        aS(j);
        a aS = aS(j);
        boolean fx = this.gJP.fx("BizChatConversation", "update BizChatConversation set flag = " + a(aS, 2, 0) + " where bizChatId = " + aS.field_bizChatId);
        if (fx) {
            aS = aS(aS.field_bizChatId);
            b bVar = new b();
            bVar.hqF = aS.field_bizChatId;
            bVar.frn = aS.field_brandUserName;
            bVar.hqE = a.hqC;
            bVar.hqG = aS;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return fx;
    }

    public final boolean aX(long j) {
        a aS = aS(j);
        boolean fx = this.gJP.fx("BizChatConversation", "update BizChatConversation set flag = " + a(aS, 3, aS.field_lastMsgTime) + " where bizChatId = " + aS.field_bizChatId);
        if (fx) {
            aS = aS(aS.field_bizChatId);
            b bVar = new b();
            bVar.hqF = aS.field_bizChatId;
            bVar.frn = aS.field_brandUserName;
            bVar.hqE = a.hqC;
            bVar.hqG = aS;
            this.hod.ca(bVar);
            this.hod.doNotify();
        }
        return fx;
    }
}
