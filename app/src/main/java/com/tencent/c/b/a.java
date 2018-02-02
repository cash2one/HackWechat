package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.c.c.b.d;
import com.tencent.c.d.a.b;
import com.tencent.c.d.a.c;
import com.tencent.c.d.a.e;
import com.tencent.c.d.a.f;
import com.tencent.c.d.a.g;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public Context mContext = null;
    public b zRW;

    public a(Context context) {
        this.mContext = context;
        this.zRW = new b(context);
    }

    public static d cDp() {
        d dVar = new d();
        try {
            int i;
            dVar.zTn = Build.FINGERPRINT;
            dVar.zTo = com.tencent.c.f.d.cDK();
            dVar.hqd = Build.BRAND;
            dVar.model = Build.MODEL;
            dVar.zTp = VERSION.SDK_INT;
            dVar.zTq = Build.CPU_ABI;
            dVar.platform = com.tencent.c.f.d.aaV("ro.board.platform");
            if (f.cDt()) {
                i = 2;
            } else {
                Object obj;
                Object<com.tencent.c.d.b.d.a> cDu = com.tencent.c.d.b.d.cDu();
                if ((cDu.isEmpty() ? 1 : null) == null) {
                    List<b> arrayList = new ArrayList(3);
                    arrayList.add(new g());
                    arrayList.add(new com.tencent.c.d.a.d());
                    if (com.tencent.c.d.b.f.cDv()) {
                        arrayList.add(new c());
                    }
                    for (com.tencent.c.d.b.d.a aVar : cDu) {
                        if (aVar != null) {
                            for (b a : arrayList) {
                                a.a(aVar);
                            }
                        }
                    }
                    for (b cDr : arrayList) {
                        if (cDr.cDr()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    i = 2;
                } else if (e.cDs()) {
                    i = 1;
                } else {
                    if (!com.tencent.c.d.a.a.aaQ("/system/bin/debuggerd")) {
                        obj = 1;
                    } else if (!com.tencent.c.d.a.a.aaQ("/system/bin/debuggerd64")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.aaQ("/system/bin/ddexe")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.aaR("/system/etc/install-recovery.sh")) {
                        i = 1;
                    } else if (com.tencent.c.d.a.a.aaR("/system/bin/install-recovery.sh")) {
                        h.aaW("BootScriptChecker : everything seems ok");
                        obj = null;
                    } else {
                        i = 1;
                    }
                    i = obj != null ? 1 : 0;
                }
            }
            dVar.cIu = i;
        } catch (Exception e) {
        }
        return dVar;
    }

    public static com.tencent.c.c.b.b a(Context context, com.tencent.c.a.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        com.tencent.c.c.b.b bVar = new com.tencent.c.c.b.b();
        bVar.zSF = i;
        bVar.zSG = null;
        bVar.zSH = aVar.ffw;
        String str = aVar.zRR;
        if (str == null) {
            bArr = null;
        } else {
            int length = str.length() / 2;
            bArr = new byte[length];
            char[] toCharArray = str.toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3])) << 4));
            }
        }
        bVar.zSI = bArr;
        List<byte[]> bD = com.tencent.c.f.a.bD(context, aVar.ffw);
        if (bD.size() > 1) {
            bVar.zSX = new ArrayList();
            for (byte[] bArr2 : bD) {
                bVar.zSX.add(bArr2);
            }
        }
        bVar.zSJ = aVar.fileSize;
        bVar.zSK = aVar.zRQ;
        bVar.zSL = aVar.versionCode;
        bVar.zSM = aVar.versionName;
        bVar.zSN = 0;
        if (aVar.hts == 1) {
            bVar.zSN |= 1;
        }
        bVar.zSN |= 2;
        if (!(aVar.zRS.startsWith("/data") || aVar.zRS.startsWith("/system"))) {
            bVar.zSN |= 4;
        }
        bVar.zSO = com.tencent.c.f.a.aaU(aVar.zRS);
        bVar.zSP = 0;
        bVar.zSQ = 0;
        bVar.zSR = 0;
        bVar.zSS = null;
        bVar.zST = 0;
        bVar.zSU = false;
        bVar.zSV = 0;
        bVar.zSW = 0;
        return bVar;
    }
}
