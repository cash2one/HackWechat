package com.tencent.mm.pluginsdk.i.a.d;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class r extends i<q> {
    private static final String[] gJN = new String[]{i.a(q.gJc, "ResDownloaderRecordTable")};
    private static final String vib = (w.gZK + g.s(String.format("mm%d", new Object[]{Integer.valueOf(Integer.MIN_VALUE)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, d> vic;
    private final h hhp;
    private final HashMap<String, Object> vid = new HashMap();

    public final /* synthetic */ boolean b(c cVar) {
        return g((q) cVar);
    }

    static {
        HashMap hashMap = new HashMap();
        vic = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return r.gJN;
            }
        });
        Iterator it = p.bZD().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private r(h hVar) {
        super(hVar, q.gJc, "ResDownloaderRecordTable", null);
        this.hhp = hVar;
        Iterator it = p.bZD().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static r bZE() {
        try {
            new File(vib).mkdirs();
            h hVar = new h();
            if (hVar.a(vib + "ResDown.db", vib + "EnResDown.db", -2147483648L, q.yE(), vic)) {
                return new r(hVar);
            }
            x.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[]{e});
            return null;
        }
    }

    public final boolean iF(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            return false;
        }
        c qVar = new q();
        qVar.field_urlKey_hashcode = str.hashCode();
        return super.a(qVar, new String[]{"urlKey_hashcode"});
    }

    public final boolean f(q qVar) {
        if (bh.ov(qVar.field_urlKey)) {
            return false;
        }
        qVar.field_urlKey_hashcode = qVar.field_urlKey.hashCode();
        return super.c(qVar, new String[]{"urlKey_hashcode"});
    }

    public final boolean g(q qVar) {
        if (bh.ov(qVar.field_urlKey)) {
            return false;
        }
        qVar.field_urlKey_hashcode = qVar.field_urlKey.hashCode();
        return super.b(qVar);
    }

    public final q RW(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            return null;
        }
        c qVar = new q();
        qVar.field_urlKey_hashcode = str.hashCode();
        if (super.b(qVar, new String[]{"urlKey_hashcode"})) {
            return qVar;
        }
        return null;
    }
}
