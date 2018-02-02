package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

final class at extends d {
    at() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        String optString = jSONObject.optString("targetDirectory", "wxfile://usr");
        if (!optString.startsWith("wxfile://usr")) {
            return new a("fail invalid targetDirectory", new Object[0]);
        }
        switch (1.jjG[jVar.irP.iqz.pU(optString).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new a(String.format("fail permission denied, open \"%s\"", new Object[]{optString}), new Object[0]);
            default:
                h hVar = new h();
                com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.irP.iqz.a(str, hVar);
                switch (1.jjG[a.ordinal()]) {
                    case 1:
                        return new a("fail permission denied, open \"%s\"", new Object[]{str});
                    case 4:
                        return new a("fail no such file \"%s\"", new Object[]{str});
                    case 5:
                        Closeable zipInputStream;
                        a aVar;
                        Throwable e;
                        try {
                            zipInputStream = new ZipInputStream(new com.tencent.mm.plugin.appbrand.k.a((ByteBuffer) hVar.jRK));
                            try {
                                com.tencent.mm.plugin.appbrand.appstorage.j d = jVar.irP.iqz.d(optString, zipInputStream);
                                switch (1.jjG[d.ordinal()]) {
                                    case 1:
                                        aVar = new a("fail permission denied, open \"%s\"", new Object[]{str});
                                        bh.d(zipInputStream);
                                        return aVar;
                                    case 5:
                                        aVar = new a("ok", new Object[0]);
                                        bh.d(zipInputStream);
                                        return aVar;
                                    case 6:
                                        aVar = new a("fail no such file or directory, open \"%s\"", new Object[]{str});
                                        bh.d(zipInputStream);
                                        return aVar;
                                    case 7:
                                        aVar = new a("fail illegal operation on a directory, open \"%s\"", new Object[]{str});
                                        bh.d(zipInputStream);
                                        return aVar;
                                    default:
                                        aVar = new a("fail " + d.name(), new Object[0]);
                                        bh.d(zipInputStream);
                                        return aVar;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            e = e2;
                        } catch (Exception e3) {
                            e = e3;
                            zipInputStream = null;
                        } catch (Throwable th) {
                            e = th;
                            zipInputStream = null;
                            bh.d(zipInputStream);
                            throw e;
                        }
                        try {
                            x.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e, "write zip stream", new Object[0]);
                            aVar = new a("fail read zip data", new Object[0]);
                            bh.d(zipInputStream);
                            return aVar;
                        } catch (Throwable th2) {
                            e = th2;
                            bh.d(zipInputStream);
                            throw e;
                        }
                    default:
                        return new a("fail " + a.name(), new Object[0]);
                }
        }
    }

    protected final String o(JSONObject jSONObject) {
        return jSONObject.optString("zipFilePath");
    }
}
