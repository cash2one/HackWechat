package com.tencent.mm.compatible.util;

import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e extends a {
    public static String gHA = (bnF + "xlog");
    public static String gHB = (bnF + "avatar/");
    public static String gHC = (bnF + "exdevice/");
    public static String gHD = (bnF + "newyear/");
    public static String gHE = (bnF + "expose/");
    public static String gHF = (bnF + "f2flucky/");
    public static String gHG = (bnF + "WebviewCache/");
    public static String gHH = (bnF + "pattern_recognition/");
    public static String gHI = (bnF + "sniffer/");
    public static final String gHr = h.getExternalStorageDirectory().getParent();
    public static String gHs = (bnF + "Download/");
    public static String gHt;
    public static String gHu;
    public static String gHv = (bnF + "vusericon/");
    public static String gHw = (bnF + "Game/");
    public static String gHx = (bnF + "CDNTemp/");
    public static String gHy = (bnF + "Download/VoiceRemind");
    public static String gHz = (bnF + "watchdog/");

    public static void eK(String str) {
        x.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + bnD);
        if (bh.ov(str)) {
            int i;
            ArrayList cgb = aw.cgb();
            int size = cgb.size();
            for (i = 0; i < size; i++) {
                x.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + cgb.get(i));
            }
            if (size > 1) {
                Collections.sort(cgb, new Comparator<aw.a>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        aw.a aVar = (aw.a) obj;
                        aw.a aVar2 = (aw.a) obj2;
                        long j = (aVar.xhS * aVar.xhT) - (aVar2.xhS * aVar2.xhT);
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
            }
            if (!(size <= 0 || cgb.get(0) == null || bh.ov(((aw.a) cgb.get(0)).xhO))) {
                bnD = ((aw.a) cgb.get(0)).xhO;
                for (i = 0; i < size; i++) {
                    x.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + cgb.get(i));
                }
            }
        } else {
            bnD = str;
        }
        bnF = bnD + bnE;
        gHs = bnF + "Download/";
        gHv = bnF + "vusericon/";
        gHw = bnF + "Game/";
        gHx = bnF + "CDNTemp/";
        gHz = bnF + "watchdog/";
        gHA = bnF + "xlog";
        gZM = bnF + "crash/";
        gHB = bnF + "avatar/";
        gHt = bnF + "Cache/";
        String str2 = bnF + "WeChat/";
        String str3 = bnF + "WeiXin/";
        if (com.tencent.mm.a.e.bO(str2) || !(com.tencent.mm.a.e.bO(str3) || w.cfi().equals("zh_CN"))) {
            str3 = str2;
        }
        gHu = str3;
        x.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + bnD);
    }
}
