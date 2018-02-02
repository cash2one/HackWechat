package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class y {
    public static final int VERSION;
    public static final String[] iFc;
    static final a iFd;
    private static Boolean iFe = null;

    static {
        int i = -1;
        try {
            if (ac.cfw()) {
                String ZU = ZU();
                if (!bh.ov(ZU) && e.bO(ZU)) {
                    i = new JSONObject(e.bT(ZU)).optInt("version");
                }
            }
        } catch (Exception e) {
        }
        if (i > 0) {
            VERSION = i;
            iFc = a.iLW;
            iFd = a.iFi;
        } else {
            VERSION = 89;
            iFc = a.iLW;
            iFd = a.iFi;
        }
    }

    public static void ZT() {
        b.deleteFile(ZU());
    }

    static String ZU() {
        return new File(aa.ZZ() + "/MockLibInfo.json").getAbsolutePath();
    }

    public static boolean ZV() {
        if (iFe == null) {
            ac.cft();
            iFe = Boolean.valueOf(false);
        }
        return iFe.booleanValue();
    }

    public static InputStream openRead(String str) {
        String py = a.py(str);
        switch (1.iFf[iFd.ordinal()]) {
            case 1:
                return pG("wxa_library/local" + py);
            case 2:
                return pG("wxa_library/develop" + py);
            default:
                return pG("wxa_library" + py);
        }
    }

    private static InputStream pG(String str) {
        try {
            return ac.getContext().getAssets().open(str);
        } catch (Exception e) {
            x.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[]{str, e});
            return null;
        }
    }

    public static WxaPkgWrappingInfo ZW() {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.iGL = VERSION;
        wxaPkgWrappingInfo.iGN = true;
        return wxaPkgWrappingInfo;
    }
}
