package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import com.tencent.c.e.a.a.a;
import com.tencent.c.f.b;
import com.tencent.c.f.d;
import com.tencent.c.f.i;
import com.tencent.c.f.l;

public final class c {
    private Context mContext;
    private String mVersionName = null;
    private int zRY = -1;
    private com.tencent.c.c.a.c zSa = null;

    public c(Context context) {
        this.mContext = context;
        a bF = i.bF(context, context.getPackageName());
        this.mVersionName = bF.versionName;
        this.zRY = bF.versionCode;
    }

    public final byte[] c(String str, String str2, com.tencent.c.e.a.b.a aVar) {
        byte[] bArr = null;
        try {
            l lVar = new l();
            lVar.cDM();
            lVar.aaZ(str);
            lVar.aba(str2);
            lVar.aaY("UTF-8");
            lVar.put("userInfo", a(aVar));
            lVar.put("req", aVar);
            byte[] q = b.q(lVar.tq());
            if (q == null) {
                throw new RuntimeException("compress data fail");
            }
            bArr = com.tencent.c.f.c.j(q, com.tencent.c.f.c.cDI());
            return bArr;
        } catch (Exception e) {
        }
    }

    private com.tencent.c.c.a.c a(com.tencent.c.e.a.b.a aVar) {
        if (this.zSa == null) {
            this.zSa = new com.tencent.c.c.a.c();
            this.zSa.zSl = 82;
            this.zSa.zSq = this.zRY;
            this.zSa.zSi = aVar.fCR;
            this.zSa.zSh = aVar.zSh;
            try {
                int i;
                int i2;
                int i3;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(split[0]);
                    i2 = Integer.parseInt(split[1]);
                    i = Integer.parseInt(split[2]);
                }
                this.zSa.zSm = new com.tencent.c.c.a.b();
                this.zSa.zSm.zSe = i3;
                this.zSa.zSm.zSf = i2;
                this.zSa.zSm.zSg = i;
            } catch (Exception e) {
            }
            this.zSa.zSn = 0;
            this.zSa.zSp = d.cDJ();
            this.zSa.imei = aaP(aVar.imei);
            this.zSa.imsi = aaP(aVar.imsi);
            this.zSa.zSj = aaP(Build.MODEL);
            this.zSa.reb = aaP(d.gu(this.mContext));
            this.zSa.zSw = aaP(d.nN(true));
            this.zSa.zSx = aaP(d.nN(false));
            this.zSa.zSo = 0;
        }
        this.zSa.zSk = getNetworkType();
        this.zSa.guid = aaP(d.gw(this.mContext));
        return this.zSa;
    }

    private int getNetworkType() {
        try {
            return d.gv(this.mContext) == d.a.zUJ ? 2 : 1;
        } catch (Throwable th) {
            return 2;
        }
    }

    private static String aaP(String str) {
        return str == null ? "" : str;
    }
}
