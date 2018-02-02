package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.a.e;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.wenote.a.a;
import com.tencent.mm.plugin.wenote.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c implements ap {
    private static HashMap<Integer, d> gwY = new HashMap();
    private com.tencent.mm.sdk.b.c bannerOnInitListener = new 1(this);
    private b tQk = new b();
    private com.tencent.mm.plugin.wenote.a.c tQl = new com.tencent.mm.plugin.wenote.a.c();
    private a tQm = new a();
    public d tQn = null;

    public static c bVN() {
        ar.Ha();
        c cVar = (c) bp.hY("plugin.wenote");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        ar.Ha().a("plugin.wenote", cVar2);
        return cVar2;
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        InputStream open;
        x.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        com.tencent.mm.sdk.b.a.xef.b(this.tQk);
        ((com.tencent.mm.plugin.record.a.a) g.k(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.tQl);
        ((r) g.k(r.class)).getFavCdnStorage().a(this.tQl);
        com.tencent.mm.sdk.b.a.xef.b(this.tQm);
        com.tencent.mm.sdk.b.a.xef.b(this.bannerOnInitListener);
        File file = new File(i.FA());
        if (!(file.exists() && file.isDirectory())) {
            x.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
        File file2 = new File(com.tencent.mm.bi.a.Vg());
        x.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[]{file2.getAbsolutePath()});
        if (com.tencent.mm.protocal.d.vAC || com.tencent.mm.protocal.d.vAD) {
            x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            e.g(file2);
        } else {
            com.tencent.mm.bi.a.hZr = com.tencent.mm.bi.a.Nj();
            if (z) {
                x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(com.tencent.mm.bi.a.Nk()), Integer.valueOf(com.tencent.mm.bi.a.hZr)});
                if (com.tencent.mm.bi.a.hZr < com.tencent.mm.bi.a.Nk()) {
                    e.g(file2);
                }
            } else if (com.tencent.mm.bi.a.hZr == 1) {
                x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                e.g(file2);
            } else {
                x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[]{Integer.valueOf(com.tencent.mm.bi.a.hZr)});
            }
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            open = ac.getContext().getAssets().open("WNNote.zip");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
            return;
        }
        File file3 = new File(file2, "WNNote.zip");
        if (file3.exists()) {
            x.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            e.c(open);
            return;
        }
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                d(open, fileOutputStream);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
            }
        }
        e.c(open);
        e.a(fileOutputStream);
        int ft = bh.ft(file3.getAbsolutePath(), file3.getParent());
        if (ft < 0) {
            x.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + ft + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
        }
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        com.tencent.mm.sdk.b.a.xef.c(this.tQk);
        ((com.tencent.mm.plugin.record.a.a) g.k(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.tQl);
        ((r) g.k(r.class)).getFavCdnStorage().b(this.tQl);
        com.tencent.mm.sdk.b.a.xef.c(this.tQm);
        com.tencent.mm.sdk.b.a.xef.c(this.bannerOnInitListener);
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
