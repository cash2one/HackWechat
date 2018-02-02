package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ag {
    public static int a(Context context, at atVar) {
        if (atVar == null) {
            return 0;
        }
        if (atVar.ktN != 6) {
            return atVar.rYW;
        }
        if (atVar.vFK == null) {
            return 0;
        }
        if (a.ift.m(context, atVar.vFI.ngo)) {
            return atVar.vFK.vHE;
        }
        return atVar.vFK.vHF;
    }

    public static void a(Context context, ay ayVar, at atVar) {
        if (!(atVar == null || atVar.vFI == null)) {
            boolean z;
            String str = atVar.vFI.ngo;
            if (bh.ov(str)) {
                z = false;
            } else {
                f aZ = g.aZ(str, true);
                if (aZ == null || bh.ov(aZ.field_appId)) {
                    z = false;
                } else {
                    z = (aZ.field_appInfoFlag & 32) > 0;
                    x.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[]{aZ.field_appId, Boolean.valueOf(z)});
                }
            }
            if (z) {
                ayVar.rKy = false;
                String str2 = "";
                if (atVar.vFM == null || atVar.vFN == null) {
                    str = atVar == null ? "" : atVar.ktN == 6 ? atVar.vFL == null ? "" : a.ift.m(context, atVar.vFI.ngo) ? atVar.vFL.vHR : atVar.vFL.vHS : atVar.vFJ;
                    try {
                        if (!bh.ov(str)) {
                            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                            if (identifier > 0) {
                                str = context.getString(identifier);
                            }
                        }
                    } catch (Exception e) {
                    }
                    str = str2;
                } else {
                    cv cvVar;
                    if (a.ift.m(context, atVar.vFI.ngo)) {
                        cvVar = atVar.vFM;
                    } else {
                        cvVar = atVar.vFN;
                    }
                    str2 = w.cfi();
                    if (str2.equals("zh_CN")) {
                        str = cvVar.vHP;
                    } else if (str2.equals("zh_TW") || str2.equals("zh_HK")) {
                        str = cvVar.vHQ;
                    } else {
                        str = cvVar.vHO;
                    }
                }
                switch (atVar.ktN) {
                    case 4:
                        ayVar.rKz = str;
                        ayVar.rKy = true;
                        break;
                    case 5:
                        if (atVar.rYW == 1) {
                            ayVar.rKz = str;
                            ayVar.rKy = true;
                            break;
                        }
                        break;
                    case 6:
                        ayVar.rKz = str;
                        ayVar.rKy = true;
                        break;
                    default:
                        ayVar.rKy = false;
                        break;
                }
                if (bh.ov(str)) {
                    x.e("MicroMsg.OpenActionContent", "text can not load ?");
                    ayVar.rKy = false;
                    return;
                }
                return;
            }
        }
        ayVar.rKy = false;
    }
}
