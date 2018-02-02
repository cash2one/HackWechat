package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;
import java.io.IOException;

public final class b {

    static class a implements Runnable {
        private File lOM;
        private String url;

        a(String str, File file) {
            this.url = str;
            this.lOM = file;
        }

        public final void run() {
            byte[] VM = bh.VM(this.url);
            if (VM != null) {
                FileOp.j(this.lOM.getAbsolutePath(), VM);
            }
        }

        public final String toString() {
            return super.toString() + "|DownloadRunnable";
        }
    }

    public static String yW(String str) {
        if (bh.ov(str) || "#".equals(str)) {
            return "";
        }
        File file = new File(d.aEx(), ab.UZ(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            x.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", new Object[]{e.toString()});
        }
        ar.Dm().F(new a(str, file));
        return "";
    }
}
