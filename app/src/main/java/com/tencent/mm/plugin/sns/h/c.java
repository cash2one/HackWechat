package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> rds = new ConcurrentHashMap();
    private static volatile long rdt = 0;

    private static void bwq() {
        synchronized (rds) {
            if (bh.bA(rdt) <= 120000) {
                return;
            }
            rdt = bh.Wq();
            rds.clear();
        }
    }

    private static String KT(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    public static void a(String str, String str2, int i, int i2, int i3, long j) {
        try {
            b bVar = new b((byte) 0);
            bVar.rdu = KT(str);
            bVar.mMimeType = str2;
            bVar.mWidth = i;
            bVar.mHeight = i2;
            bVar.rdw = i3;
            bVar.rdx = j;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append(bVar.rdu).append(',').append(bVar.mMimeType).append(',').append(bVar.mWidth).append(',').append(bVar.mHeight).append(',').append(bVar.rdw).append(',').append(bVar.rdx);
            String stringBuilder2 = stringBuilder.toString();
            x.i("MicroMsg.SnsImgStats", "report up: " + stringBuilder2);
            g.pQN.k(13512, stringBuilder2);
        } catch (Exception e) {
        }
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        try {
            a aVar = new a((byte) 0);
            aVar.rdu = KT(str2);
            aVar.rdv = i;
            aVar.mMimeType = str3;
            aVar.mWidth = i2;
            aVar.mHeight = i3;
            aVar.rdw = i4;
            aVar.rdx = j;
            aVar.rdy = j2;
            rds.put(str, aVar);
        } catch (Exception e) {
        }
    }

    public static void aa(String str, long j) {
        try {
            a aVar = (a) rds.remove(str);
            if (aVar != null) {
                aVar.rdz = j;
                StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                stringBuilder.append(aVar.rdu).append(',').append(aVar.rdv).append(',').append(aVar.mMimeType).append(',').append(aVar.mWidth).append(',').append(aVar.mHeight).append(',').append(aVar.rdw).append(',').append(aVar.rdx).append(',').append(aVar.rdy).append(',').append(aVar.rdz);
                String stringBuilder2 = stringBuilder.toString();
                x.i("MicroMsg.SnsImgStats", "report dl: " + stringBuilder2);
                g.pQN.k(13513, stringBuilder2);
                bwq();
            }
        } catch (Exception e) {
        } finally {
            bwq();
        }
    }
}
