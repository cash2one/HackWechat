package com.tencent.mm.ay;

import com.tencent.mm.by.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;

public final class j extends com.tencent.mm.sdk.e.j implements e {
    public static final String[] gJN = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    h hhp;

    public j(h hVar) {
        this.hhp = hVar;
    }

    public final boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        if (this.hhp.delete("oplog2", "id= ? AND inserTime= ?", new String[]{bVar.id, bVar.hyu}) < 0) {
            return false;
        }
        return true;
    }
}
