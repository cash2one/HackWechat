package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.e.b.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static com.tencent.mm.e.b.b jzm = null;
    private static String jzn = null;
    private static a jzo = null;
    private static ak jzp = null;

    private static void TG() {
        if (jzp != null) {
            jzp.TG();
        }
        jzp = null;
    }

    public static boolean a(String str, a aVar, int i) {
        x.i("MicroMsg.AppBrand.AudioRecorder", JsApiStartRecordVoice.NAME);
        kS(1);
        if (bh.ov(str)) {
            x.e("MicroMsg.AppBrand.AudioRecorder", "startRecord, path is null or nil");
            return false;
        }
        com.tencent.mm.e.b.b bVar = new com.tencent.mm.e.b.b(a.gBY);
        jzm = bVar;
        if (bVar.fkc == a.gBX) {
            if (bVar.fka != null) {
                bVar.fka.reset();
            }
        } else if (bVar.fkd != c.fkm) {
            bVar.release();
            bVar.vn();
        }
        jzm.vl();
        jzm.vm();
        jzm.vk();
        jzm.setOutputFile(str);
        jzm.a(new 2());
        try {
            jzm.prepare();
            jzm.start();
            jzo = aVar;
            jzn = str;
            long j = (long) i;
            TG();
            ak akVar = new ak(new 1(), false);
            jzp = akVar;
            akVar.J(j, j);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrand.AudioRecorder", "record prepare, exp = %s", new Object[]{bh.i(e)});
            return false;
        }
    }

    public static void kS(int i) {
        x.i("MicroMsg.AppBrand.AudioRecorder", "stopRecord what:%d", new Object[]{Integer.valueOf(i)});
        if (!bh.ov(jzn)) {
            if (jzm == null) {
                x.i("MicroMsg.AppBrand.AudioRecorder", "sRecorder is null,err");
                return;
            }
            jzm.vo();
            jzm.release();
            jzm = null;
            TG();
            jzn = null;
            if (jzo != null) {
                jzo.kq(i);
            }
            jzo = null;
        }
    }
}
