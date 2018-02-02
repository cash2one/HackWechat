package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.l;
import com.tencent.mm.ae.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;

public final class ao {
    private static e gJT = null;
    private static boolean hOj = false;
    private static int hOk = 3;
    private static long hOl = 0;

    public static void run() {
        if (hOj) {
            x.i("MicroMsg.PostTaskUploadHDHeadImg", "is uploading hdHeadImg now!");
            return;
        }
        if (hOl == 0 || bh.bA(hOl) > 180000) {
            hOl = bh.Wq();
            hOk = 3;
        }
        if (hOk <= 0) {
            x.i("MicroMsg.PostTaskUploadHDHeadImg", "frequency limit");
            return;
        }
        hOk--;
        String str = com.tencent.mm.compatible.util.e.gHB + "temp.avatar.hd";
        if (new File(str).exists()) {
            if (gJT == null) {
                gJT = new 1(str);
            }
            ar.CG().a(157, gJT);
            ar.CG().a(new l(1, str), 0);
            hOj = true;
            return;
        }
        x.d("MicroMsg.PostTaskUploadHDHeadImg", "has uploaded HDHeadImg and delete it");
    }
}
