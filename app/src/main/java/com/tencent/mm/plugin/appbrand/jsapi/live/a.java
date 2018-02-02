package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class a {
    private static final String hjR;
    private static ConcurrentMap<String, Boolean> jkJ = new ConcurrentHashMap();
    private static Map<String, List<a>> jkK = new HashMap();

    static /* synthetic */ void bi(String str, String str2) {
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "doCallback url:%s localPath:%s", new Object[]{str, str2});
        List list = (List) jkK.get(str);
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "doCallback callbacks nil");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            ((a) list.get(i)).sq(str2);
        }
        jkK.remove(str);
    }

    static /* synthetic */ void y(String str, String str2, String str3) {
        Throwable e;
        File file = new File(str3);
        if (file.exists()) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download already exists: %s", new Object[]{str});
            if (bh(str2, str3)) {
                bg(str, str3);
                return;
            } else {
                x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download already exists, but md5 not valid. deleted:%b", new Object[]{Boolean.valueOf(file.delete())});
            }
        }
        if (jkJ.containsKey(str)) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download ing: %s", new Object[]{str});
            return;
        }
        jkJ.put(str, Boolean.valueOf(true));
        Closeable fileOutputStream;
        Closeable bufferedInputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 16384);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    bh.d(fileOutputStream);
                    bh.d(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        file.delete();
                        x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", new Object[]{str});
                        bh.d(fileOutputStream);
                        bh.d(bufferedInputStream);
                        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
                        jkJ.remove(str);
                        if (bh(str2, str3)) {
                            x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                            bg(str, null);
                        }
                        bg(str, str3);
                        return;
                    } catch (Throwable th) {
                        e = th;
                        bh.d(fileOutputStream);
                        bh.d(bufferedInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                file.delete();
                x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", new Object[]{str});
                bh.d(fileOutputStream);
                bh.d(bufferedInputStream);
                x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
                jkJ.remove(str);
                if (bh(str2, str3)) {
                    x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                    bg(str, null);
                }
                bg(str, str3);
                return;
            } catch (Throwable th2) {
                e = th2;
                bufferedInputStream = null;
                bh.d(fileOutputStream);
                bh.d(bufferedInputStream);
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            bufferedInputStream = null;
            file.delete();
            x.printErrStackTrace("MicroMsg.AppBrandLiveFileDownloadHelper", e, "download image url %s ", new Object[]{str});
            bh.d(fileOutputStream);
            bh.d(bufferedInputStream);
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
            jkJ.remove(str);
            if (bh(str2, str3)) {
                x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
                bg(str, null);
            }
            bg(str, str3);
            return;
        } catch (Throwable th3) {
            e = th3;
            fileOutputStream = null;
            bufferedInputStream = null;
            bh.d(fileOutputStream);
            bh.d(bufferedInputStream);
            throw e;
        }
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "download done");
        jkJ.remove(str);
        if (bh(str2, str3)) {
            bg(str, str3);
            return;
        }
        x.w("MicroMsg.AppBrandLiveFileDownloadHelper", "download md5 not valid");
        bg(str, null);
    }

    static {
        String str = e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        hjR = str;
        i.Qu(str);
    }

    public static void a(String str, String str2, a aVar) {
        if (!bh.ov(str)) {
            String str3 = null;
            if (!bh.ov(str)) {
                str3 = g.s(str.getBytes());
            }
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "downloadToLocal url:%s localPath:%s", new Object[]{str, String.format("%s%s", new Object[]{hjR, str3})});
            ag.y(new 1(str, aVar));
            com.tencent.mm.sdk.f.e.post(new 2(str, str2, str3), "AppBrandSimpleImageLoaderDownloadThread");
        }
    }

    private static void bg(String str, String str2) {
        ag.y(new 3(str, str2));
    }

    private static boolean bh(String str, String str2) {
        if (bh.ov(str)) {
            x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "isMd5Valid target nil, no check");
            return true;
        }
        x.i("MicroMsg.AppBrandLiveFileDownloadHelper", "isMd5Valid file:%s target:%s", new Object[]{g.bV(str2), str});
        return str.equals(g.bV(str2));
    }
}
