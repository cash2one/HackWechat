package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.ba.b;
import com.tencent.mm.z.p;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c implements ap {
    public static synchronized c MR() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) p.s(c.class);
        }
        return cVar;
    }

    public static boolean l(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            return false;
        } else if (!auVar.cje()) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            return false;
        } else if (m(auVar)) {
            return MS();
        } else {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            return false;
        }
    }

    public static boolean MS() {
        String value = ((a) g.h(a.class)).zY().getValue("C2CImgNotAutoDownloadTimeRange");
        x.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + value);
        if (b.kK(value)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            return false;
        }
        int i = bh.getInt(((a) g.h(a.class)).zY().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
            return false;
        }
        Context context = ac.getContext();
        if (i == 2 && an.isWifi(context)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else if (i == 1 && an.isWifi(context)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else {
            long j = (long) bh.getInt(((a) g.h(a.class)).zY().getValue("ChatImgAutoDownloadMax"), 0);
            long a = bh.a((Long) g.Dj().CU().get(w.a.xnX, null), 0);
            long VJ = bh.VJ((String) DateFormat.format("M", System.currentTimeMillis()));
            long a2 = bh.a((Long) g.Dj().CU().get(w.a.xnY, null), 0);
            x.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + VJ + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (VJ != a2) {
                x.i("MicroMsg.SubCoreAutoDownload", "update month %d ", new Object[]{Long.valueOf(VJ)});
                g.Dj().CU().a(w.a.xnX, Long.valueOf(0));
                g.Dj().CU().a(w.a.xnY, Long.valueOf(VJ));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                x.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                return false;
            } else if (i == 1 && (an.isWifi(context) || an.is3G(context) || an.is4G(context))) {
                x.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                return true;
            } else {
                x.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                return false;
            }
        }
    }

    public static boolean MT() {
        String value = ((a) g.h(a.class)).zY().getValue("SnsImgPreLoadingAroundTimeLimit");
        x.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + value);
        if (b.kK(value)) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            return false;
        }
        x.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        return true;
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        pInt.value = 0;
        int i = bh.getInt(((a) g.h(a.class)).zY().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            return false;
        }
        boolean isWifi = an.isWifi(ac.getContext());
        if (i == 2 && !isWifi) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            return false;
        } else if (an.is2G(ac.getContext())) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            return false;
        } else {
            String value = ((a) g.h(a.class)).zY().getValue("SnsSightNoAutoDownload");
            if (!bh.ov(value)) {
                try {
                    x.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + value);
                    long j = bh.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.MQ()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = bh.getLong(split[0], 0);
                    if (j <= bh.getLong(split[1], 0) && j >= j2) {
                        x.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        return false;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", new Object[]{value, e.getMessage()});
                }
            }
            String value2 = ((a) g.h(a.class)).zY().getValue("SnsSightNotAutoDownloadTimeRange");
            x.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + value2);
            if (b.kK(value2)) {
                int i2;
                x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            x.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        pInt.value = 0;
        int i = bh.getInt(((a) g.h(a.class)).zY().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            x.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            return false;
        }
        boolean isWifi = an.isWifi(ac.getContext());
        if (i == 2 && !isWifi) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            return false;
        } else if (an.is2G(ac.getContext())) {
            x.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            return false;
        } else {
            String value = ((a) g.h(a.class)).zY().getValue("SnsAdSightNotAutoDownloadTimeRange");
            x.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + value);
            if (b.kK(value)) {
                int i2;
                x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            x.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            return true;
        }
    }

    public static boolean m(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            return false;
        }
        b hT = ba.hT(auVar.gjF);
        if (hT == null) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            return true;
        }
        String str = hT.hgO;
        if (bh.ov(str)) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            return true;
        } else if (b.kK(str)) {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + str);
            return false;
        } else {
            x.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + str);
            return true;
        }
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
