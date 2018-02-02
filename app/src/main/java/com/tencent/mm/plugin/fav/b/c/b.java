package com.tencent.mm.plugin.fav.b.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.d;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends i<d> implements k {
    private e gJP;

    public b(e eVar) {
        super(eVar, d.gJc, "FavConfigInfo", null);
        this.gJP = eVar;
    }

    public final void av(byte[] bArr) {
        c aIk = aIk();
        if (8216 == aIk.field_configId) {
            aIk.field_value = bh.by(bArr);
            boolean c = c(aIk, new String[0]);
            x.i("MicroMsg.FavConfigStorage", "update sync key: %s, result %B", new Object[]{aIk.field_value, Boolean.valueOf(c)});
            return;
        }
        aIk.field_configId = 8216;
        aIk.field_value = bh.by(bArr);
        c = b(aIk);
        x.i("MicroMsg.FavConfigStorage", "insert sync key: %s, result %B", new Object[]{aIk.field_value, Boolean.valueOf(c)});
    }

    private d aIk() {
        d dVar = new d();
        x.d("MicroMsg.FavConfigStorage", "get fav config sql %s", new Object[]{new StringBuilder("select * from FavConfigInfo where configId = 8216").toString()});
        Cursor a = this.gJP.a(r1, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                dVar.b(a);
            }
            a.close();
        }
        return dVar;
    }

    public final byte[] aHW() {
        d aIk = aIk();
        if (8216 != aIk.field_configId) {
            x.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            g.Dk();
            if (((Boolean) g.Dj().CU().get(8224, Boolean.valueOf(false))).booleanValue()) {
                x.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                g.Dk();
                x.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[]{bh.ou((String) g.Dj().CU().get(8216, ""))});
                byte[] VD = bh.VD(r0);
                av(VD);
                x.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                g.Dk();
                g.Dj().CU().set(8224, Boolean.valueOf(true));
                return VD;
            }
        }
        x.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[]{Integer.valueOf(aIk.field_configId), aIk.field_value});
        return bh.VD(aIk.field_value);
    }
}
