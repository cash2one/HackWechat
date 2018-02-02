package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcelable;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.cd.f;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends com.tencent.mm.ae.a<acn> {
    private static final Map<String, acn> iXM = new ConcurrentHashMap();
    private final b iKk;

    protected final /* synthetic */ void a(int i, int i2, String str, bdf com_tencent_mm_protocal_c_bdf, k kVar) {
        acn com_tencent_mm_protocal_c_acn = (acn) com_tencent_mm_protocal_c_bdf;
        x.i("MicroMsg.AppBrand.CgiGetGameMenu", "onCgiBack, req [appid %s]resp [errType %s, errCode %s, errMsg %s, resp %s]", new Object[]{getAppId(), Integer.valueOf(i), Integer.valueOf(i2), str, com_tencent_mm_protocal_c_acn});
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_acn != null) {
            Parcelable gameMenuParcel = new GameMenuParcel();
            gameMenuParcel.appId = getAppId();
            gameMenuParcel.iXN = com_tencent_mm_protocal_c_acn;
            d.a(gameMenuParcel);
            iXM.put(getAppId(), com_tencent_mm_protocal_c_acn);
        }
    }

    private String getAppId() {
        return ((acm) this.iKk.hmg.hmo).fFm;
    }

    public final synchronized f<com.tencent.mm.ae.a.a<acn>> JV() {
        iXM.remove(getAppId());
        return super.JV();
    }

    public static acn rG(String str) {
        return bh.ov(str) ? null : (acn) iXM.get(str);
    }
}
