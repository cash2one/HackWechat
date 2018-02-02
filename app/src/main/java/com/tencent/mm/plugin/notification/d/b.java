package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class b {
    private static final String oUl = (e.bnF + "FailMsgFileCache");

    public static void init() {
        x.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(oUl).mkdirs();
    }

    public static void a(int i, a aVar) {
        String str = null;
        if (i == 1) {
            str = oUl + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oUl + File.separator + "snsMsg";
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            return;
        }
        x.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", new Object[]{str});
        String bgG = aVar.bgG();
        x.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", new Object[]{bgG});
        if (bh.ov(bgG)) {
            x.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
        } else {
            com.tencent.mm.a.e.b(str, bgG.getBytes(), bgG.length());
        }
    }

    public static a uj(int i) {
        String str;
        if (i == 1) {
            str = oUl + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oUl + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            return null;
        }
        x.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", new Object[]{str});
        try {
            x.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", new Object[]{com.tencent.mm.a.e.bT(str)});
            a aVar = new a();
            aVar.GM(r2);
            return aVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            x.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static void uk(int i) {
        String str = null;
        if (i == 1) {
            str = oUl + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oUl + File.separator + "snsMsg";
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            return;
        }
        x.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", new Object[]{str});
        if (com.tencent.mm.a.e.bO(str)) {
            new File(str).delete();
        }
    }
}
