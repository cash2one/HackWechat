package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.r;
import com.tencent.mm.z.ae;
import java.util.HashMap;

public final class b implements a, c, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.b.b {
    private r kYP;

    public final /* bridge */ /* synthetic */ ae Fh() {
        return this.kYP;
    }

    public final ae c(h hVar) {
        return new r(hVar);
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new d(this) {
            final /* synthetic */ b kYQ;

            {
                this.kYQ = r1;
            }

            public final String[] wg() {
                return r.gJN;
            }
        });
        return hashMap;
    }

    public final void onAccountInitialized(e.c cVar) {
        this.kYP = new r(g.Dj().gQj);
    }

    public final void onAccountRelease() {
    }
}
