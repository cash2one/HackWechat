package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import com.tencent.c.c.a.a;
import com.tencent.c.c.a.c;
import com.tencent.c.f.d;
import com.tencent.c.f.d$a;
import com.tencent.c.f.l;

public final class b {
    private String mChannelId = null;
    private Context mContext = null;
    private String mVersionName = null;
    private int zRX = -1;
    private int zRY = -1;
    private String zRZ = null;
    private c zSa = null;
    private a zSb = null;

    public b(Context context) {
        this.mContext = context;
        com.tencent.c.a.a bE = com.tencent.c.f.a.bE(context, context.getPackageName());
        this.mVersionName = bE.versionName;
        this.zRY = bE.versionCode;
        this.zRX = 82;
        this.mChannelId = "105901";
        this.zRZ = "7AD75E27CD5842F6";
    }

    public final byte[] a(com.tencent.c.c.b.a aVar) {
        byte[] bArr = null;
        try {
            l lVar = new l();
            lVar.cDM();
            lVar.aaZ("viruscheck");
            lVar.aba("RiskCheck");
            lVar.aaY("UTF-8");
            String str = "phonetype";
            if (this.zSb == null) {
                this.zSb = new a();
                this.zSb.zSc = 2;
                this.zSb.zSd = 201;
            }
            lVar.put(str, this.zSb);
            lVar.put("userinfo", cDq());
            lVar.put("req", aVar);
            byte[] q = com.tencent.c.f.b.q(lVar.tq());
            if (q == null) {
                throw new RuntimeException("compress data fail");
            }
            bArr = com.tencent.c.f.c.j(q, com.tencent.c.f.c.cDI());
            return bArr;
        } catch (Exception e) {
        }
    }

    private c cDq() {
        int i = 2;
        if (this.zSa == null) {
            this.zSa = new c();
            this.zSa.zSl = this.zRX;
            this.zSa.zSq = this.zRY;
            this.zSa.zSi = this.mChannelId;
            this.zSa.zSh = this.zRZ;
            try {
                int i2;
                int i3;
                int i4;
                String[] split = this.mVersionName.trim().split("[\\.]");
                if (split == null || split.length < 3) {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i4 = Integer.parseInt(split[0]);
                    i3 = Integer.parseInt(split[1]);
                    i2 = Integer.parseInt(split[2]);
                }
                this.zSa.zSm = new com.tencent.c.c.a.b();
                this.zSa.zSm.zSe = i4;
                this.zSa.zSm.zSf = i3;
                this.zSa.zSm.zSg = i2;
            } catch (Exception e) {
            }
            this.zSa.zSn = 0;
            this.zSa.zSp = d.cDJ();
            this.zSa.imei = aaP(d.gs(this.mContext));
            this.zSa.imsi = aaP(d.gt(this.mContext));
            this.zSa.zSj = aaP(Build.MODEL);
            this.zSa.reb = aaP(d.gu(this.mContext));
            this.zSa.zSw = aaP(d.nN(true));
            this.zSa.zSx = aaP(d.nN(false));
            this.zSa.guid = null;
            this.zSa.zSo = 0;
        }
        c cVar = this.zSa;
        if (d.gv(this.mContext) != d$a.zUJ) {
            i = 1;
        }
        cVar.zSk = i;
        return this.zSa;
    }

    private static String aaP(String str) {
        return str == null ? "" : str;
    }
}
