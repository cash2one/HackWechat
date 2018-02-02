package com.tencent.mm.modelstat;

import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class n {
    static {
        bg.reset();
    }

    public static void A(int i, int i2, int i3) {
        if (ab.bC(ac.getContext())) {
            x.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
            B(i, i2, 0);
            return;
        }
        x.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
        C(i, i2, 0);
    }

    public static void B(int i, int i2, int i3) {
        k kVar = new k();
        kVar.hRM = i;
        kVar.hRY = i2;
        kVar.fDt = 8390656;
        c(kVar);
        a(kVar, i3);
        q.Tg().a(kVar);
    }

    public static void C(int i, int i2, int i3) {
        k kVar = new k();
        kVar.hRL = i;
        kVar.hRX = i2;
        kVar.fDt = 4195328;
        c(kVar);
        a(kVar, i3);
        q.Tg().a(kVar);
    }

    private static void c(k kVar) {
        bg.update();
        kVar.hRN = (int) bg.cgk();
        kVar.hRZ = (int) bg.cgj();
        kVar.hRO = (int) bg.cgi();
        kVar.hSa = (int) bg.cgh();
        kVar.hSb = (int) bg.cgo();
        kVar.hSd = (int) bg.cgn();
        kVar.hSc = (int) bg.cgm();
        kVar.hSe = (int) bg.cgl();
        kVar.fDt = (((((((kVar.fDt | 8192) | 33554432) | Downloads.RECV_BUFFER_SIZE) | 16777216) | 134217728) | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) | 67108864) | SQLiteDatabase.CREATE_IF_NECESSARY;
    }

    private static void a(k kVar, int i) {
        switch (i) {
            case 109:
            case 123:
                kVar.hRG = kVar.hRL + kVar.hRM;
                kVar.fDt |= 32;
                return;
            case 110:
                kVar.hRS = kVar.hRX + kVar.hRY;
                kVar.fDt |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                return;
            case 127:
                kVar.hRU = kVar.hRX + kVar.hRY;
                kVar.fDt |= SQLiteGlobal.journalSizeLimit;
                return;
            case FileUtils.S_IWUSR /*128*/:
                kVar.hRI = kVar.hRL + kVar.hRM;
                kVar.fDt |= FileUtils.S_IWUSR;
                return;
            case 138:
            case v.CTRL_INDEX /*139*/:
                kVar.hRE = kVar.hRL + kVar.hRM;
                kVar.fDt |= 8;
                return;
            case f.CTRL_INDEX /*149*/:
                kVar.hRW = kVar.hRX + kVar.hRY;
                kVar.fDt |= 2097152;
                return;
            case 150:
                kVar.hRK = kVar.hRL + kVar.hRM;
                kVar.fDt |= WXMediaMessage.TITLE_LENGTH_LIMIT;
                return;
            case 522:
                kVar.hRQ = kVar.hRX + kVar.hRY;
                kVar.fDt |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                return;
            default:
                return;
        }
    }
}
