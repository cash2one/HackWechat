package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class f {
    public static String r(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static boolean t(Map<String, Object> map, String str) {
        String r = r(map, str);
        if (bh.ov(r)) {
            return false;
        }
        try {
            if ("1".equals(r)) {
                return true;
            }
            if ("0".equals(r)) {
                return false;
            }
            return Boolean.valueOf(r).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public static int c(Map<String, Object> map, String str, int i) {
        String r = r(map, str);
        if (!bh.ov(r)) {
            try {
                i = Integer.valueOf(r).intValue();
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static long a(Map<String, Object> map, String str, long j) {
        String r = r(map, str);
        if (!bh.ov(r)) {
            try {
                j = Long.valueOf(r).longValue();
            } catch (Exception e) {
            }
        }
        return j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final JSONObject a(j jVar, String str, List<String> list) {
        boolean z = false;
        ar.Hg();
        af WO = c.EY().WO(jVar.mLs);
        String gu = r.gu(jVar.mLs);
        boolean z2;
        boolean z3;
        String str2;
        boolean z4;
        String string;
        boolean z5;
        switch (jVar.mLr) {
            case 1:
                z2 = false;
                z3 = false;
                break;
            case 2:
                z2 = false;
                break;
            case 3:
                z2 = true;
                break;
            case 4:
                str2 = WO.fWy;
                z3 = false;
                z4 = false;
                string = ac.getContext().getString(R.l.eIG);
                z5 = true;
                break;
            case 5:
                z2 = false;
                z3 = false;
                break;
            case 6:
                z2 = false;
                break;
            case 7:
                z2 = true;
                break;
            case 11:
                str2 = jVar.mMj;
                z3 = false;
                z4 = false;
                string = ac.getContext().getString(R.l.eIL);
                z5 = true;
                break;
            case 15:
                str2 = WO.vN();
                if (bh.ov(str2)) {
                    str2 = WO.field_username;
                }
                z3 = false;
                z4 = false;
                string = ac.getContext().getString(R.l.eIM);
                z5 = true;
                break;
            case 16:
                String str3 = jVar.content;
                if (!bh.ov(str3)) {
                    for (String str22 : str3.split("​")) {
                        if (str22.startsWith(str)) {
                            z3 = false;
                            z4 = false;
                            string = ac.getContext().getString(R.l.eII);
                            z5 = true;
                            break;
                        }
                    }
                }
                str22 = str3;
                z3 = false;
                z4 = false;
                string = ac.getContext().getString(R.l.eII);
                z5 = true;
            case 17:
                str22 = jVar.content;
                z3 = false;
                z4 = false;
                string = ac.getContext().getString(R.l.eIF);
                z5 = true;
                break;
            case 18:
                str22 = jVar.content;
                z3 = false;
                z4 = false;
                string = ac.getContext().getString(R.l.eIK);
                z5 = true;
                break;
            default:
                z3 = false;
                z4 = false;
                str22 = null;
                string = null;
                z5 = false;
                break;
        }
        return r2;
    }
}
