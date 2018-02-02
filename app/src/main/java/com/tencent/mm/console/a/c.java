package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.g.a.if;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class c implements a {
    static {
        b.a(new c(), new String[]{"//hotpatch"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        int i = -1;
        switch (str.hashCode()) {
            case 3237038:
                if (str.equals("info")) {
                    i = 1;
                    break;
                }
                break;
            case 93029230:
                if (str.equals("apply")) {
                    i = 0;
                    break;
                }
                break;
            case 94627080:
                if (str.equals("check")) {
                    i = 3;
                    break;
                }
                break;
            case 94746189:
                if (str.equals("clear")) {
                    i = 2;
                    break;
                }
                break;
        }
        String str2;
        switch (i) {
            case 0:
                x.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", new Object[]{strArr.length < 3 ? "/data/local/tmp/test.apk" : strArr[2]});
                com.tencent.mm.sdk.b.b ifVar = new if();
                ifVar.fyD.fyI = str2;
                com.tencent.mm.sdk.b.a.xef.m(ifVar);
                return true;
            case 1:
                x.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", new Object[]{getClass().getClassLoader()});
                return true;
            case 2:
                x.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
                com.tencent.mm.sdk.b.b ifVar2 = new if();
                ifVar2.fyD.fpr = 1;
                com.tencent.mm.sdk.b.a.xef.m(ifVar2);
                return true;
            case 3:
                if (strArr.length < 3) {
                    return true;
                }
                str2 = strArr[2];
                if (!str2.startsWith("/")) {
                    str2 = "/data/data/com.tencent.mm/app_dex/" + str2;
                }
                x.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", new Object[]{str2});
                x.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                x.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                x.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", new Object[]{Boolean.valueOf(SharePatchFileUtil.abL(str2))});
                x.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                return true;
            default:
                return true;
        }
    }
}
