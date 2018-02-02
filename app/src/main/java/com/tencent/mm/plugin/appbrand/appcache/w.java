package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public enum w {
    ;

    public enum a {
        public static final int iEV = 0;
        public static final int iEW = 0;
        public static final int iEX = 0;
        private static final /* synthetic */ int[] iEY = null;

        static {
            iEV = 1;
            iEW = 2;
            iEX = 3;
            iEY = new int[]{iEV, iEW, iEX};
        }
    }

    public static void cq(boolean z) {
        e.post(new 1(z), "WxaCommLibVersionChecker");
    }

    private static void a(int i, car com_tencent_mm_protocal_c_car, int i2) {
        if (f.Zo() != null) {
            PInt pInt = new PInt();
            f.Zo().a(com_tencent_mm_protocal_c_car, pInt);
            boolean z = f.Zo().ai("@LibraryAppId", 0) == com_tencent_mm_protocal_c_car.version ? ad.l(true, true).first == ad$a.APP_BROKEN : false;
            x.i("MicroMsg.WxaCommLibVersionChecker", "onResp, requestUsingLibVersion %d, needDownload = %b, version = %d, forceUpdate = %d, md5 = %s, url = %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(com_tencent_mm_protocal_c_car.version), Integer.valueOf(com_tencent_mm_protocal_c_car.wFT), com_tencent_mm_protocal_c_car.fqR, com_tencent_mm_protocal_c_car.url});
            if (z) {
                if (i <= 0 || bh.ov(com_tencent_mm_protocal_c_car.fyG)) {
                    j.iEs.A(-1, null);
                } else {
                    j.iEs.A(i, com_tencent_mm_protocal_c_car.fyG);
                }
                j.iEs.cn(true);
                c qVar = new q();
                qVar.field_key = "@LibraryAppId";
                qVar.field_version = com_tencent_mm_protocal_c_car.version;
                if (!f.Zu().b(qVar, new String[]{"key", "version"})) {
                    qVar.field_updateTime = bh.Wo();
                    qVar.field_scene = (i2 - 1) + 1;
                    f.Zu().b(qVar);
                }
            }
            if (com_tencent_mm_protocal_c_car.wFT > 0 && pInt.value > 0) {
                int i3 = com_tencent_mm_protocal_c_car.version;
                d.lv(2);
                return;
            }
            return;
        }
        x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, null storage");
    }

    public static void a(int i, ayv com_tencent_mm_protocal_c_ayv) {
        if (com_tencent_mm_protocal_c_ayv != null) {
            car com_tencent_mm_protocal_c_car = new car();
            com_tencent_mm_protocal_c_car.url = com_tencent_mm_protocal_c_ayv.url;
            com_tencent_mm_protocal_c_car.fqR = com_tencent_mm_protocal_c_ayv.fqR;
            com_tencent_mm_protocal_c_car.version = com_tencent_mm_protocal_c_ayv.version;
            com_tencent_mm_protocal_c_car.wFT = com_tencent_mm_protocal_c_ayv.wFT;
            com_tencent_mm_protocal_c_car.wZZ = com_tencent_mm_protocal_c_ayv.wFS ? 1 : 0;
            com_tencent_mm_protocal_c_car.fyG = com_tencent_mm_protocal_c_ayv.fyG;
            a(i, com_tencent_mm_protocal_c_car, a.iEX);
        }
    }

    public static void a(car com_tencent_mm_protocal_c_car) {
        a(-1, com_tencent_mm_protocal_c_car, a.iEW);
    }
}
