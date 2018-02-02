package com.tencent.mm.z;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a.g;
import java.util.ArrayList;
import java.util.List;

public class az {
    private static az hgt;
    public b hgs;

    public static az Hs() {
        synchronized (az.class) {
            if (hgt == null) {
                hgt = new az();
            }
        }
        return hgt;
    }

    private az() {
    }

    public final boolean a(ay ayVar) {
        boolean z = true;
        if (ayVar.type == 10000) {
            ar.Hg();
            SharedPreferences fL = c.fL("banner");
            if (fL != null) {
                fL.edit().clear().commit();
            }
            if (this.hgs == null) {
                return true;
            }
            this.hgs.Hv();
            return true;
        } else if (ayVar.type == 57005) {
            return false;
        } else {
            ar.Hg();
            SharedPreferences fL2 = c.fL("banner");
            if (fL2 == null) {
                return false;
            }
            Editor edit = fL2.edit();
            ay Ht = Ht();
            if (hN("HistoryInfo").contains(Integer.valueOf(ayVar.type))) {
                z = false;
            }
            if (Ht != null && Ht.showType == 2) {
                List hN = hN("HistoryInfo");
                if (!hN.contains(Integer.valueOf(Ht.type))) {
                    hN.add(Integer.valueOf(Ht.type));
                }
                b("HistoryInfo", hN);
            }
            if (z) {
                edit.putInt("CurrentType", ayVar.type).putInt("CurrentShowType", ayVar.showType).putString("CurrentData", ayVar.data).commit();
            }
            if (this.hgs == null) {
                return z;
            }
            this.hgs.Hv();
            return z;
        }
    }

    public static ay Ht() {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL == null) {
            return null;
        }
        int i = fL.getInt("CurrentType", -1);
        int i2 = fL.getInt("CurrentShowType", -1);
        String string = fL.getString("CurrentData", "");
        if (i == -1) {
            return null;
        }
        switch (i) {
            case 1:
                int Hu = Hu();
                if (Hu == a.hgw || Hu == a.hgx || g.Ij().Ih()) {
                    if (g.Ij().Ih()) {
                        x.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                        return null;
                    }
                    x.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                    return null;
                }
            case 2:
                if (Hu() == a.hgw || g.Ij().Ih()) {
                    if (g.Ij().Ih()) {
                        x.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                        return null;
                    }
                    x.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                    return null;
                }
            case 3:
                x.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                return null;
            case 11:
            case 10000:
            case 57005:
                return null;
        }
        return new ay(i, i2, string);
    }

    public final void aX(int i, int i2) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL != null) {
            Editor edit = fL.edit();
            switch (i2) {
                case 1:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                case 2:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    List hN = hN("HistoryInfo");
                    if (!hN.contains(Integer.valueOf(i))) {
                        hN.add(Integer.valueOf(i));
                    }
                    b("HistoryInfo", hN);
                    break;
                case 3:
                    if (i == 3) {
                        edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                        break;
                    }
                    break;
            }
            if (this.hgs != null) {
                this.hgs.Hv();
            }
        }
    }

    private static boolean b(String str, List<Integer> list) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL == null) {
            return false;
        }
        Editor edit = fL.edit();
        edit.putInt(str + "ArraySize", list.size());
        for (int i = 0; i < list.size(); i++) {
            edit.putInt(str + i, ((Integer) list.get(i)).intValue());
        }
        return edit.commit();
    }

    private static List<Integer> hN(String str) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL == null) {
            return null;
        }
        int i = fL.getInt(str + "ArraySize", 0);
        List<Integer> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(fL.getInt(str + i2, 0)));
        }
        return arrayList;
    }

    public static int Hu() {
        try {
            ar.Hg();
            String str = (String) c.CU().get(4097, "");
            ar.Hg();
            String str2 = (String) c.CU().get(6, "");
            boolean Gv = q.Gv();
            x.d("MicorMsg.MainFrameBannerStorage", "isUpload " + Gv + " stat " + q.FW());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && r1 == null) {
                return a.hgu;
            }
            if (str != null && r1 == null) {
                return a.hgv;
            }
            if (Gv) {
                return a.hgw;
            }
            return a.hgx;
        } catch (Exception e) {
            return a.hgu;
        }
    }
}
