package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.o;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public final class a implements l {
    private final List<l> jjq = new LinkedList();
    private final l jjr = new g();

    public static a p(e eVar) {
        return new a(eVar);
    }

    private a(e eVar) {
        l i = ac.i(eVar);
        com.tencent.mm.plugin.appbrand.appstorage.a aVar = new com.tencent.mm.plugin.appbrand.appstorage.a(eVar.mAppId);
        this.jjq.add(new com.tencent.mm.plugin.appbrand.appstorage.e(new String[]{o.getString(eVar.iqx.uin), eVar.mAppId}));
        this.jjq.add(aVar);
        this.jjq.add(i);
        initialize();
    }

    final <T extends l> T x(Class<T> cls) {
        for (l lVar : this.jjq) {
            if (lVar.getClass() == cls) {
                return lVar;
            }
        }
        return null;
    }

    private l sn(String str) {
        if (bh.ov(str)) {
            return this.jjr;
        }
        for (l lVar : this.jjq) {
            if (lVar.bE(str)) {
                return lVar;
            }
        }
        return this.jjr;
    }

    public final j pP(String str) {
        return sn(str).pP(str);
    }

    public final j pU(String str) {
        return sn(str).pU(str);
    }

    public final j pV(String str) {
        return sn(str).pV(str);
    }

    public final j pW(String str) {
        return sn(str).pW(str);
    }

    public final j b(String str, h<List<com.tencent.mm.plugin.appbrand.appstorage.h>> hVar) {
        return sn(str).b(str, hVar);
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        return sn(str).a(str, hVar);
    }

    public final j d(String str, InputStream inputStream) {
        return sn(str).d(str, inputStream);
    }

    public final j pX(String str) {
        return sn(str).pX(str);
    }

    public final j a(String str, FileStructStat fileStructStat) {
        return sn(str).a(str, fileStructStat);
    }

    public final j a(String str, File file, boolean z) {
        return sn(str).a(str, file, z);
    }

    public final File pQ(String str) {
        return sn(str).pQ(str);
    }

    public final boolean bE(String str) {
        return true;
    }

    public final void initialize() {
        for (l initialize : this.jjq) {
            initialize.initialize();
        }
        this.jjr.initialize();
    }

    public final void release() {
        for (l release : this.jjq) {
            release.release();
        }
        this.jjr.release();
    }
}
