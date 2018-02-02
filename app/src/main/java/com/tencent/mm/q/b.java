package com.tencent.mm.q;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gJk;
    a gJl;
    private com.tencent.mm.sdk.e.m.b gJm = new 1(this);

    private class d extends a {
        final /* synthetic */ b gJn;
        private int gJy = 0;
        private String gJz;

        public d(b bVar, String str) {
            this.gJn = bVar;
            this.gJz = str;
        }

        public final boolean execute() {
            x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[]{this.gJz, Integer.valueOf(this.gJy)});
            if (this.gJy == 0) {
                this.gJn.gJl.b(c.mKk, (long) com.tencent.mm.modelfriend.b.kP(this.gJz));
            }
            return true;
        }

        public final String toString() {
            return "DeleteFriend(\"" + this.gJz + "\", " + this.gJy + ")";
        }
    }

    static /* synthetic */ boolean Ba() {
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(6, null);
        return str != null && str.length() > 0;
    }

    static /* synthetic */ int a(b bVar, a aVar) {
        int i;
        String str;
        String str2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        String ou = bh.ou(aVar.userName);
        int i2 = aVar.status != 0 ? 131073 : 131074;
        if (aVar.fAf == null || aVar.fAf.length() <= 0) {
            i = 0;
        } else {
            bVar.gJl.a(i2, 16, aVar.id, aVar.userName, currentTimeMillis, aVar.fAf);
            i = 1;
        }
        String str3 = aVar.gJo;
        String str4 = aVar.gJp;
        String str5 = aVar.gJq;
        if (str3 != null && str3.length() > 0) {
            String str6 = str3.equalsIgnoreCase(str4) ? null : str4;
            str = (str6 == null || str6.equalsIgnoreCase(str5)) ? null : str5;
            bVar.gJl.a(i2, 12, aVar.id, ou, currentTimeMillis, str3);
            i++;
            if (str6 != null) {
                bVar.gJl.a(i2, 13, aVar.id, ou, currentTimeMillis, str6);
                i++;
            }
            if (str != null) {
                bVar.gJl.a(i2, 14, aVar.id, ou, currentTimeMillis, str);
                i++;
            }
        }
        str3 = aVar.bgo;
        str4 = aVar.gJr;
        str5 = aVar.gJs;
        if (str3 == null || str3.length() <= 0) {
            return i;
        }
        str = str3.equalsIgnoreCase(str4) ? null : str4;
        if (!(str == null || str.equalsIgnoreCase(str5))) {
            str2 = str5;
        }
        bVar.gJl.a(i2, 5, aVar.id, ou, currentTimeMillis, str3);
        i++;
        if (str != null) {
            bVar.gJl.a(i2, 6, aVar.id, ou, currentTimeMillis, str);
            i++;
        }
        if (str2 == null) {
            return i;
        }
        bVar.gJl.a(i2, 7, aVar.id, ou, currentTimeMillis, str2);
        return i + 1;
    }

    static /* synthetic */ boolean a(a aVar) {
        return aVar.type == 0 && aVar.status != 2;
    }

    public final String getName() {
        return "FTS5SearchFriendLogic";
    }

    protected final boolean onCreate() {
        if (((m) g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
            this.gJl = (a) ((m) g.k(m.class)).getFTSIndexStorage(1280);
            this.gJk = ((m) g.k(m.class)).getFTSTaskDaemon();
            this.gJk.a(131172, new b(this, (byte) 0));
            af.OD().a(this.gJm);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        af.OD().b(this.gJm);
        return true;
    }

    public final a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        return this.gJk.a(-65536, new g(this, gVar));
    }
}
