package com.tencent.tinker.lib.b;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements b {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final int abB(String str) {
        int cU = cU(str, SharePatchFileUtil.ah(new File(str)));
        if (cU == 0) {
            TinkerPatchService.bT(this.context, str);
        } else {
            com.tencent.tinker.lib.e.a.ip(this.context).AiB.c(new File(str), cU);
        }
        return cU;
    }

    public int cU(String str, String str2) {
        com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(this.context);
        if (!ShareTinkerInternals.IW(ip.tinkerFlags) || !ShareTinkerInternals.iE(this.context)) {
            return -1;
        }
        if (!SharePatchFileUtil.ae(new File(str))) {
            return -2;
        }
        if (ip.AiF) {
            return -4;
        }
        if (b.ir(this.context)) {
            return -3;
        }
        if (ShareTinkerInternals.cHh()) {
            return -5;
        }
        ip = com.tencent.tinker.lib.e.a.ip(this.context);
        if (ip.AiH) {
            d dVar = ip.AiG;
            if (!(dVar == null || dVar.AiO || !str2.equals(dVar.AiL))) {
                return -6;
            }
        }
        if (c.iu(this.context).abD(str2)) {
            return 0;
        }
        return -7;
    }
}
