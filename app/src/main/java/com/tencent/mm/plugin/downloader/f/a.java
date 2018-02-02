package com.tencent.mm.plugin.downloader.f;

import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements com.tencent.xweb.b.a {
    private static a lsW = null;
    private com.tencent.mm.modelcdntran.i.a lrw = new 1(this);
    private Map<String, a> lsX = new ConcurrentHashMap();

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        x.i("FileDownloaderXWEBProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), null, Boolean.valueOf(aVar.lsX.containsKey(str))});
        if (aVar.lsX.containsKey(str)) {
            b bVar = ((a) aVar.lsX.get(str)).lsZ;
            if (bVar == null) {
                x.e("FileDownloaderXWEBProxy", "error proxy_callback null");
            } else if (i == 3) {
                bVar.u(str, ((a) aVar.lsX.get(str)).lta, z);
            } else {
                bVar.t(str, i2, z);
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, long j, long j2) {
        x.d("FileDownloaderXWEBProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(aVar.lsX.containsKey(str))});
        if (aVar.lsX.containsKey(str)) {
            b bVar = ((a) aVar.lsX.get(str)).lsZ;
            if (bVar == null) {
                x.e("FileDownloaderXWEBProxy", "error proxy_callback null");
            } else {
                bVar.w(str, j, j2);
            }
        }
    }

    public static synchronized a aAk() {
        a aVar;
        synchronized (a.class) {
            if (lsW == null) {
                lsW = new a();
            }
            com.tencent.mm.plugin.downloader.c.a.azT();
            aVar = lsW;
        }
        return aVar;
    }

    public final int a(String str, String str2, b bVar) {
        x.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", new Object[]{str, str2});
        i iVar = new i();
        iVar.field_mediaId = str;
        iVar.field_fullpath = str2;
        iVar.htu = str;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.hrY;
        iVar.htt = this.lrw;
        iVar.htv = 60;
        iVar.htw = 600;
        iVar.hty = false;
        a aVar = new a(this, (byte) 0);
        aVar.lsZ = bVar;
        aVar.lta = str2;
        this.lsX.put(str, aVar);
        int d = com.tencent.mm.plugin.downloader.c.a.azT().d(iVar);
        x.i("FileDownloaderXWEBProxy", "addDownloadTask: " + d);
        return d;
    }
}
