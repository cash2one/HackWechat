package com.tencent.mm.be;

import com.tencent.mm.e.b.g$a;
import com.tencent.mm.e.c.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    public BlockingQueue<g$a> hPa = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public String mFileName = null;

    public final boolean JB() {
        x.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        d dVar = new d();
        String SC = b.SC();
        try {
            x.i("MicroMsg.SpeexEncoderWorker", "path " + SC);
            File file = new File(SC);
            if (!file.exists()) {
                file.mkdir();
            }
            dVar.cL(SC + this.mFileName + ".temp");
            while (this.hPa.size() > 0) {
                g$a com_tencent_mm_e_b_g_a = (g$a) this.hPa.poll();
                if (com_tencent_mm_e_b_g_a.buf != null && com_tencent_mm_e_b_g_a.flp > 0) {
                    dVar.a(com_tencent_mm_e_b_g_a, 0, false);
                }
            }
            dVar.vE();
            try {
                new File(SC + this.mFileName + ".temp").renameTo(new File(SC + this.mFileName + ".spx"));
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexEncoderWorker", "exception:%s", new Object[]{bh.i(e)});
            }
            e.SL().start();
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", new Object[]{e2});
        }
        return true;
    }

    public final boolean JC() {
        return false;
    }
}
