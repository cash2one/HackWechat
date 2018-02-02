package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Bundle;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.model.h.3;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {

    private static class b {
        String rqL;
        List<String> tNl;
        String version;

        private b() {
        }
    }

    static /* synthetic */ boolean a(File file, Map map) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            File[] listFiles2 = file2.listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                List arrayList = new ArrayList();
                for (File file3 : listFiles2) {
                    b bVar = new b();
                    bVar.version = file3.getName();
                    String str = file3.getAbsolutePath() + File.separator + "package";
                    if (e.bO(str)) {
                        bVar.rqL = str;
                    }
                    File file4 = new File(file3.getAbsolutePath() + File.separator + "preload_files");
                    if (file4.isDirectory()) {
                        File[] listFiles3 = file4.listFiles();
                        if (listFiles3 == null || listFiles3.length == 0) {
                            arrayList.add(bVar);
                        } else {
                            List arrayList2 = new ArrayList();
                            for (File name : listFiles3) {
                                arrayList2.add(name.getName());
                            }
                            bVar.tNl = arrayList2;
                            arrayList.add(bVar);
                        }
                    } else {
                        arrayList.add(bVar);
                    }
                }
                map.put(file2.getName(), arrayList);
            }
        }
        return true;
    }

    public static synchronized f Qd(String str) {
        f fVar;
        synchronized (g.class) {
            String Qq = d.Qq(str);
            String Qr = d.Qr(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (bh.ov(Qq) || bh.ov(Qr)) {
                x.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[]{Qq, Qr});
                fVar = null;
            } else {
                fVar = com.tencent.mm.plugin.webview.wepkg.utils.b.tNV.Qn(Qq);
                if (fVar == null || fVar.tMS == null || !Qr.equalsIgnoreCase(fVar.tMS.fMh)) {
                    WepkgVersion Qj = h.Qj(Qq);
                    if (Qj == null) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[]{Qq, "", ""});
                        a.b("EnterWeb", str, Qq, null, 0, 0, a.Bi(14));
                        fVar = null;
                    } else if (!Qr.equalsIgnoreCase(Qj.fMh)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[]{Qq, Qj.version, Qr, Qj.fMh});
                        a.b("EnterWeb", str, Qq, null, 0, 0, a.Bi(13));
                        fVar = null;
                    } else if (bh.ov(Qj.version)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[]{Qq});
                        a.b("EnterWeb", str, Qq, null, 0, 0, a.Bi(15));
                        fVar = null;
                    } else if (!Qj.tNI || (!Qj.tNJ && Qj.tNK)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[]{Qj.tNm, Qj.version, Boolean.valueOf(Qj.tNI), Boolean.valueOf(Qj.tNJ), Boolean.valueOf(Qj.tNK)});
                        a.b("EnterWeb", str, Qq, Qj.version, 0, 0, a.Bi(16));
                        fVar = null;
                    } else {
                        e eVar;
                        String str2 = Qj.version;
                        String str3 = Qj.iEa;
                        Qr = Qj.fqR;
                        int i = Qj.tNG;
                        if (bh.ov(Qq) || bh.ov(str3) || bh.ov(Qr)) {
                            x.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
                            eVar = null;
                        } else {
                            File file = new File(str3);
                            if (!file.exists()) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[]{str3});
                                Qh(Qq);
                                a.b("PkgModified", null, Qq, str2, 1, 0, null);
                                eVar = null;
                            } else if (file.length() != ((long) i)) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[]{Integer.valueOf(i), Long.valueOf(file.length())});
                                file.delete();
                                Qh(Qq);
                                a.b("PkgModified", null, Qq, str2, 2, 0, null);
                                eVar = null;
                            } else {
                                if (file.length() <= 5242880) {
                                    if (!Qr.equalsIgnoreCase(com.tencent.mm.a.g.i(file))) {
                                        x.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[]{Qr, com.tencent.mm.a.g.i(file)});
                                        file.delete();
                                        Qh(Qq);
                                        a.b("PkgModified", null, Qq, str2, 3, 0, null);
                                        eVar = null;
                                    }
                                } else {
                                    x.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[]{Long.valueOf(file.length()), Long.valueOf(5242880)});
                                }
                                e eVar2 = new e(file);
                                if (!eVar2.iFn || eVar2.tMP == null) {
                                    Qe(Qq);
                                    eVar = null;
                                } else {
                                    eVar = eVar2;
                                }
                            }
                        }
                        if (eVar != null || bh.ov(Qj.iEa)) {
                            Map aT = aT(Qq, Qj.tNK);
                            if (aT == null) {
                                a.b("EnterWeb", str, Qq, Qj.version, 0, 0, a.Bi(18));
                                fVar = null;
                            } else {
                                fVar = new f(Qj, eVar, aT);
                                com.tencent.mm.plugin.webview.wepkg.utils.b.tNV.tNX.put(Qq, fVar);
                                x.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            }
                        } else {
                            a.b("EnterWeb", str, Qq, Qj.version, 0, 0, a.Bi(17));
                            fVar = null;
                        }
                    }
                } else {
                    x.i("MicroMsg.Wepkg.WepkgManager", "memory has pkgid:%s record, version:%s", new Object[]{fVar.tMS.tNm, fVar.tMS.version});
                }
            }
        }
        return fVar;
    }

    public static void Qe(String str) {
        x.i("MicroMsg.Wepkg.WepkgManager", "clear all wepkg info, pkgid:%s", new Object[]{str});
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 2001;
        wepkgCrossProcessTask.tMS.tNm = str;
        if (ac.cfw()) {
            d.Dm().F(new h$2(wepkgCrossProcessTask, null));
            return;
        }
        wepkgCrossProcessTask.jcI = new 3(null, wepkgCrossProcessTask);
        wepkgCrossProcessTask.afi();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void Qf(String str) {
        c 1 = new 1(str);
        Bundle bundle = new Bundle(1);
        bundle.putInt("call_cmd_type", 1);
        bundle.putString("call_pkg_id", str);
        WepkgProcessPreloadService.a(1, bundle);
    }

    private static Map<String, WepkgPreloadFile> aT(String str, boolean z) {
        if (bh.ov(str)) {
            return null;
        }
        Map<String, WepkgPreloadFile> hashMap = new HashMap();
        List<WepkgPreloadFile> Ql = h.Ql(str);
        if (bh.cA(Ql)) {
            return hashMap;
        }
        Object obj = null;
        for (WepkgPreloadFile wepkgPreloadFile : Ql) {
            if (wepkgPreloadFile != null) {
                if (bh.ov(wepkgPreloadFile.filePath)) {
                    x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[]{Boolean.valueOf(z)});
                    if (z) {
                        eW(wepkgPreloadFile.tNm, wepkgPreloadFile.tMX);
                        obj = 1;
                    } else {
                        h.a(str, wepkgPreloadFile.tMX, "", null);
                    }
                } else {
                    File file = new File(wepkgPreloadFile.filePath);
                    if (!file.exists()) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[]{wepkgPreloadFile.filePath, Boolean.valueOf(z)});
                        if (z) {
                            eW(wepkgPreloadFile.tNm, wepkgPreloadFile.tMX);
                            obj = 1;
                        } else {
                            h.a(str, wepkgPreloadFile.tMX, "", null);
                        }
                    } else if (file.length() != ((long) wepkgPreloadFile.size)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[]{Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(file.length()), Boolean.valueOf(z)});
                        if (z) {
                            eW(wepkgPreloadFile.tNm, wepkgPreloadFile.tMX);
                            file.delete();
                            obj = 1;
                        } else {
                            h.a(str, wepkgPreloadFile.tMX, "", null);
                        }
                    } else {
                        hashMap.put(wepkgPreloadFile.tMX, wepkgPreloadFile);
                    }
                }
            }
        }
        return obj != null ? null : hashMap;
    }

    public static boolean Qg(String str) {
        try {
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName() + "_temp");
            if (file.renameTo(file2)) {
                e.g(file2);
                return true;
            }
        } catch (Exception e) {
            x.i("MicroMsg.Wepkg.WepkgManager", "safeDeleteDir err:" + e.getMessage());
        }
        return false;
    }

    public static void a(a aVar) {
        String str = com.tencent.mm.plugin.webview.wepkg.utils.b.OBJECT_ROOT_DIR_PATH;
        File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            aVar.G(null);
        }
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 1001;
        wepkgCrossProcessTask.jcI = new 3(wepkgCrossProcessTask, str, file, aVar);
        wepkgCrossProcessTask.afi();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    private static void Qh(String str) {
        if (!bh.ov(str)) {
            h.a(str, "", false, new 4());
        }
    }

    private static void eW(String str, String str2) {
        if (!bh.ov(str) && !bh.ov(str2)) {
            h.a(str, str2, "", new 6(str, new 5()));
        }
    }
}
