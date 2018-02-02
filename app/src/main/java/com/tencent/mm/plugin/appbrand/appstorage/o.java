package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class o extends g {
    private final z iES;

    public o(z zVar) {
        this.iES = zVar;
    }

    public final boolean bE(String str) {
        return true;
    }

    public final j pP(String str) {
        Closeable pI = this.iES.pI(str);
        if (pI == null) {
            return j.iIz;
        }
        bh.d(pI);
        return j.iIt;
    }

    public final j b(String str, h<List<h>> hVar) {
        if (pP(str) == j.iIt) {
            return j.iIB;
        }
        String py = a.py(str);
        z zVar = this.iES;
        List<z.a> linkedList = new LinkedList();
        for (z.a add : zVar.iFr.values()) {
            linkedList.add(add);
        }
        String quote = Pattern.quote(py);
        for (z.a add2 : linkedList) {
            if (add2.fileName.startsWith(py)) {
                String replaceFirst = add2.fileName.replaceFirst(quote, "");
                if (replaceFirst.split("/").length <= 1) {
                    Object linkedList2;
                    h hVar2 = new h();
                    hVar2.fileName = replaceFirst;
                    if (hVar.jRK == null) {
                        linkedList2 = new LinkedList();
                    } else {
                        List list = (List) hVar.jRK;
                    }
                    hVar.jRK = linkedList2;
                    ((List) hVar.jRK).add(hVar2);
                }
            }
        }
        return hVar.jRK == null ? j.iIz : j.iIt;
    }

    public final j pU(String str) {
        return b(str, new h());
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        Closeable pI = this.iES.pI(str);
        if (pI == null) {
            return j.iIz;
        }
        j jVar;
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pI.available());
            if (pI instanceof com.tencent.mm.plugin.appbrand.k.a) {
                allocateDirect.put(((com.tencent.mm.plugin.appbrand.k.a) pI).jGP);
            } else {
                allocateDirect.put(ByteBuffer.wrap(c.k(pI)));
            }
            allocateDirect.rewind();
            hVar.jRK = allocateDirect;
            jVar = j.iIt;
            return jVar;
        } catch (Exception e) {
            jVar = e;
            x.printErrStackTrace("MicroMsg.WxaPkgFileSystem", jVar, "readFile", new Object[0]);
            return j.iIu;
        } finally {
            bh.d(pI);
        }
    }

    public final j a(String str, FileStructStat fileStructStat) {
        Closeable pI = this.iES.pI(str);
        if (pI == null) {
            return j.iIz;
        }
        z zVar = this.iES;
        FileStructStat fileStructStat2 = zVar.iFs;
        if (fileStructStat2 == null) {
            fileStructStat2 = new FileStructStat();
            FileStat.stat(zVar.iFl.getAbsolutePath(), fileStructStat2);
            zVar.iFs = fileStructStat2;
        }
        fileStructStat2.fillAnother(fileStructStat);
        try {
            fileStructStat.st_size = (long) pI.available();
            bh.d(pI);
        } catch (Exception e) {
            x.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[]{str});
        }
        return j.iIt;
    }

    public final void initialize() {
        this.iES.ZX();
    }

    public final void release() {
        this.iES.close();
    }
}
