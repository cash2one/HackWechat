package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import android.support.v4.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class aj {
    private static volatile aj iGx = null;
    private final Map<String, Map<a, Boolean>> iGy = new a();
    private final aa iGz = new aa();

    private static aj aap() {
        if (((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW() == null) {
            iGx = null;
            return null;
        }
        if (iGx == null) {
            synchronized (aj.class) {
                if (iGx == null) {
                    iGx = new aj();
                }
            }
        }
        return iGx;
    }

    public static void shutdown() {
        synchronized (aj.class) {
            aj ajVar = iGx;
            iGx = null;
        }
        if (ajVar != null) {
            ajVar.iGz.iFw.shutdown();
        }
    }

    public static boolean a(String str, a aVar) {
        return a("@LibraryAppId", 999, str, aVar);
    }

    public static boolean a(String str, int i, a aVar) {
        return b("@LibraryAppId", 0, i, str, aVar);
    }

    static void b(String str, a aVar) {
        if (!bh.ov(str) && aVar != null) {
            aj aap = aap();
            if (aap != null) {
                synchronized (aj.class) {
                    Map map = (Map) aap.iGy.get(str);
                    if (map == null) {
                        map = new HashMap();
                        aap().iGy.put(str, map);
                    }
                    map.put(aVar, Boolean.valueOf(true));
                }
            }
        }
    }

    static Map<a, Boolean> pN(String str) {
        if (!bh.ov(str)) {
            aj aap = aap();
            if (aap != null) {
                Map<a, Boolean> map;
                synchronized (aj.class) {
                    map = (Map) aap.iGy.remove(str);
                }
                return map;
            }
        }
        return null;
    }

    static void aK(String str, String str2) {
        a(str, str2, b.iGI, null);
    }

    static boolean a(ab abVar, a aVar) {
        if (aap() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        } else if (abVar == null) {
            return false;
        } else {
            b(abVar.vgd, aVar);
            int b = aap().iGz.b(abVar);
            if (b == 0 || b == 2) {
                return true;
            }
            a(abVar.vgd, abVar.appId, b.iGI, null);
            return false;
        }
    }

    public static boolean a(String str, int i, int i2, int i3, String str2, a aVar) {
        ab abVar = null;
        if (aap() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        }
        ab abVar2;
        if (!bh.ov(str) && !bh.ov(str2)) {
            switch (i) {
                case 0:
                    abVar2 = new ab(str, i, i2, str2);
                    break;
                case 1:
                case 2:
                case 999:
                    abVar2 = new aa$b(str, str2, i);
                    break;
                case 10000:
                case 10001:
                case 10002:
                case 10100:
                case 10101:
                case 10102:
                    abVar2 = new ak(str2, str, i2, i);
                    break;
                default:
                    abVar2 = null;
                    break;
            }
        }
        abVar2 = null;
        if (abVar2 != null) {
            boolean z = "@LibraryAppId".equals(str) ? false : i == 0;
            abVar2.iFO = z;
            if (i3 > 2097152) {
                abVar2.setReadTimeout(abVar2.getReadTimeout() * 2);
                abVar2.setConnectTimeout(abVar2.getConnectTimeout() * 2);
            }
            abVar = abVar2;
        }
        if (abVar != null) {
            return a(abVar, aVar);
        }
        x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        return false;
    }

    public static boolean b(String str, int i, int i2, String str2, a aVar) {
        return a(str, i, i2, 0, str2, aVar);
    }

    public static boolean a(String str, int i, String str2, a aVar) {
        return b(str, i, 1, str2, aVar);
    }

    static void a(String str, String str2, b bVar, a aVar) {
        Map pN = pN(str);
        if (pN != null) {
            for (a aVar2 : pN.keySet()) {
                if (aVar2 != null) {
                    aVar2.a(str2, bVar, aVar);
                }
            }
            return;
        }
        x.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", new Object[]{str2});
    }

    static void a(String str, String str2, b bVar) {
        if (aap() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
        } else {
            a(str, str2, bVar, null);
        }
    }

    static void a(String str, String str2, String str3, int i, int i2, p.a aVar) {
        boolean hf = d.a.hf(i2);
        if (aap() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
        } else if (bh.ov(str3)) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(str, str2, b.iGD, null);
            aVar.ZD();
        } else if (!new File(str3).exists()) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            a(str, str2, b.iGD, null);
            aVar.ZD();
        } else if (((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            aK(str, str2);
        } else {
            int i3 = !hf ? i : 1;
            ae a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(str2, i3, i2, new String[0]);
            if (a == null) {
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
                a(str, str2, b.iGC, null);
                return;
            }
            boolean z;
            ai YW;
            int i4;
            ContentValues contentValues;
            aVar.ZE();
            File file = new File(str3);
            String str4 = a.field_versionMd5;
            if (!hf) {
                if (!bh.ou(str4).equals(com.tencent.mm.a.g.i(file))) {
                    x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[]{str4, com.tencent.mm.a.g.i(file)});
                    z = false;
                    aVar.co(z);
                    if (z) {
                        b.deleteFile(str3);
                        a(str, str2, b.iGF, null);
                    }
                    YW = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW();
                    if (!bh.ov(str2)) {
                        i4 = d.a.hf(i2) ? 1 : i3;
                        contentValues = new ContentValues(1);
                        contentValues.put("pkgPath", str3);
                        if (YW.iGs.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str2, String.valueOf(i2), String.valueOf(i4)}) > 0) {
                            z = true;
                            x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                            a(str, str2, b.iGB, new a(str2, str3, i, i2));
                            return;
                        }
                    }
                    z = false;
                    x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                    a(str, str2, b.iGB, new a(str2, str3, i, i2));
                    return;
                }
            }
            z zVar = new z(file);
            if (!zVar.iFn) {
                zVar.close();
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
                file.delete();
                z = false;
            } else if (zVar.ZX()) {
                zVar.close();
                z = true;
            } else {
                zVar.close();
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
                file.delete();
                z = false;
            }
            aVar.co(z);
            if (z) {
                YW = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW();
                if (bh.ov(str2)) {
                    if (d.a.hf(i2)) {
                    }
                    contentValues = new ContentValues(1);
                    contentValues.put("pkgPath", str3);
                    if (YW.iGs.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str2, String.valueOf(i2), String.valueOf(i4)}) > 0) {
                        z = true;
                        x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                        a(str, str2, b.iGB, new a(str2, str3, i, i2));
                        return;
                    }
                }
                z = false;
                x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                a(str, str2, b.iGB, new a(str2, str3, i, i2));
                return;
            }
            b.deleteFile(str3);
            a(str, str2, b.iGF, null);
        }
    }
}
