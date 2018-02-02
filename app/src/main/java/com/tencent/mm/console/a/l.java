package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.u;

public final class l implements a {
    static {
        b.a(new l(), new String[]{"//cleanwx", "//showfile", "//hidefile"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        int i = -1;
        switch (str.hashCode()) {
            case -1470593122:
                if (str.equals("//hidefile")) {
                    i = 2;
                    break;
                }
                break;
            case -35508263:
                if (str.equals("//showfile")) {
                    boolean z = true;
                    break;
                }
                break;
            case 2113467658:
                if (str.equals("//cleanwx")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                com.tencent.mm.sdk.b.a.xef.m(new bl());
                u.makeText(context, "clean wx file index now.", 0).show();
                return true;
            case 1:
                try {
                    g.Dj().CU().a(w.a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(1));
                    u.makeText(context, "show file now.", 0).show();
                    return true;
                } catch (Exception e) {
                    return true;
                }
            case 2:
                try {
                    g.Dj().CU().a(w.a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(0));
                    u.makeText(context, "hide file now.", 0).show();
                    return true;
                } catch (Exception e2) {
                    return true;
                }
            default:
                return false;
        }
    }
}
