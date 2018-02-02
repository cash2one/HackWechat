package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class e {
    private static e tnQ;
    public static AtomicLong tnR = new AtomicLong(0);
    public static AtomicBoolean tnU = new AtomicBoolean(false);
    private List<String> tnS = Collections.synchronizedList(new ArrayList());
    public String tnT = "";
    private com.tencent.mm.modelvideo.b.a tnV;
    public b tnW = new 2(this);

    private class a implements Runnable {
        final /* synthetic */ e tnX;
        long tnY;

        public a(e eVar, long j) {
            this.tnX = eVar;
            this.tnY = j;
        }

        public final void run() {
            e.tnU.set(true);
            List<FileEntry> F = FileOp.F(e.bPu(), false);
            if (F != null) {
                x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "DeleteUnusedTask.maxDeleteIndex %d", Long.valueOf(this.tnY));
                for (FileEntry fileEntry : F) {
                    try {
                        if (Long.valueOf(new File(fileEntry.name).getName().split("@")[0]).longValue() < this.tnY) {
                            FileOp.deleteFile(fileEntry.name);
                            x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "deleteUnusedRunnable delete file %s", fileEntry.name);
                        }
                    } catch (Exception e) {
                        FileOp.deleteFile(fileEntry.name);
                        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "deleteUnusedRunnable exception delete file %s", fileEntry.name);
                    }
                }
                e.tnU.set(false);
            }
        }
    }

    e() {
        String bPu = bPu();
        if (!FileOp.bO(bPu)) {
            FileOp.mh(bPu);
        }
        bPu = bPu + ".nomedia";
        if (!FileOp.bO(bPu)) {
            FileOp.mh(bPu);
        }
    }

    public static e bPt() {
        if (tnQ == null) {
            tnQ = new e();
        }
        return tnQ;
    }

    private void cancelTask(String str) {
        if (!Of(str)) {
            o.TV().b(Oe(str), null);
        }
    }

    public static void onPause() {
    }

    public static void onResume() {
    }

    public final void NR(String str) {
        if (b.bPo()) {
            String Oe = Oe(str);
            if (this.tnS.contains(Oe)) {
                x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "preload exit %s", str);
                return;
            }
            if (this.tnS.size() > 0) {
                cancelTask((String) this.tnS.remove(0));
                x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "cancel preload url %s", r0);
            }
            this.tnS.add(Oe);
            x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "add preload url %s\n mediaId: %s\n preloadPath: %s", str, Oe, Og(str));
            o.TV().a(t(str, 2, r0), false);
            return;
        }
        x.i("MicroMsg.WebSearch.TopStoryVideoPreloadMgr", "no need to preload video");
    }

    private static String Oe(String str) {
        if (bh.ov(str)) {
            return "";
        }
        return "MMVideo_" + str.hashCode();
    }

    private j t(String str, int i, String str2) {
        j jVar = new j();
        jVar.field_mediaId = Oe(str);
        jVar.url = str;
        jVar.htJ = i;
        jVar.htE = 3;
        jVar.htO = 10;
        jVar.concurrentCount = 2;
        jVar.field_fullpath = str2;
        if (i == 1) {
            jVar.htQ = new b(this, (byte) 0);
        } else {
            jVar.htQ = new 1(this);
        }
        return jVar;
    }

    private boolean Of(String str) {
        return !bh.ov(this.tnT) && str.equals(Oe(this.tnT));
    }

    public static String bPu() {
        return com.tencent.mm.compatible.util.e.bnF + "ftsrecommendVideo/";
    }

    public static String Og(String str) {
        return bPu() + tnR.get() + "@" + Oe(str) + ".mp4";
    }
}
