package com.tencent.mm.pluginsdk.j.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a {
    public static final String[] viq = new String[]{"LDPI", "HDPI", "MDPI"};
    public String desc;
    public String hid;
    public String hie;
    public String id;
    public int pDf;
    public String platform;
    public String title;
    public String url;
    public String vij;
    public boolean vik;
    public boolean vil;
    public int vim;
    public Rect vin;
    public Rect vio;
    public Map<String, String> vip;

    private a(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.platform = str2;
        this.vij = str3;
        this.vik = z;
        this.vil = z2;
    }

    private boolean bZG() {
        long Wp = bh.Wp();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            if (this.hie != null) {
                j = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hie).getTime();
            }
            if (this.hid != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hid).getTime();
            }
            x.d("MicroMsg.PushMessage", "CHECKTIME : [" + j2 + "," + j + "]");
            if (j <= Wp || j2 > Wp) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public final String toString() {
        return "ad.id=" + this.id + ", platform=" + this.platform + ", device=" + this.vij + (this.vik ? ", closable" : "") + (this.vil ? ", trans-closable" : "");
    }

    public static String Sb(String str) {
        a Sc = Sc(str);
        if (Sc == a.vir) {
            return str;
        }
        if (Sc != a.vis) {
            return null;
        }
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int lastIndexOf = str.lastIndexOf("/");
            str2 = (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) ? null : str.substring(lastIndexOf + 1);
        }
        if (str2 == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.Fi()).append(str2).toString();
    }

    public static a Sc(String str) {
        if (str.indexOf("tips/") == 0) {
            return a.vir;
        }
        if (str.indexOf("weixin://") == 0) {
            return a.vis;
        }
        return a.vit;
    }

    public static ArrayList<a> bb(Context context, String str) {
        if (str == null || str.length() < 0) {
            return null;
        }
        HashSet hashSet;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str2 = displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
        if (str2 == null) {
            hashSet = null;
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(str2);
            str2 = b.eG(context);
            x.d("MicroMsg.PushMessage", "getDisplaySizeType :" + str2);
            if (str2 != null) {
                String[] split = str2.split("_");
                str2 = (split == null || split.length < 2) ? null : split[0];
                hashSet2.add(str2 + "_L");
                hashSet2.add(str2 + "_P");
            }
            hashSet = hashSet2;
        }
        if (hashSet == null || hashSet.size() <= 0) {
            return null;
        }
        Map y = bi.y(str, "tips");
        if (y == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String str3 = ".tips.tip" + (i > 0 ? Integer.valueOf(i) : "");
            if (y.get(str3) == null) {
                break;
            }
            String str4 = (String) y.get(str3 + ".$id");
            x.d("MicroMsg.PushMessage", "parseMessages id:" + str4);
            String str5 = (String) y.get(str3 + ".$platform");
            if (str5.equals("android")) {
                a aVar = new a(str4, str5, (String) y.get(str3 + ".$device"), bh.b(Boolean.valueOf((String) y.get(str3 + ".$enableclose"))), bh.b(Boolean.valueOf((String) y.get(str3 + ".$transparentclose"))));
                int i2 = bh.getInt((String) y.get(str3 + ".title.$x"), 0);
                int i3 = bh.getInt((String) y.get(str3 + ".title.$y"), 0);
                int i4 = bh.getInt((String) y.get(str3 + ".title.$width"), 0);
                int i5 = bh.getInt((String) y.get(str3 + ".title.$font"), 0);
                int VA = bh.VA((String) y.get(str3 + ".title.$color"));
                aVar.title = (String) y.get(str3 + ".title");
                aVar.vim = VA;
                aVar.vin = new Rect(i2, i3, i4 + i2, i5 + i3);
                i2 = bh.getInt((String) y.get(str3 + ".description.$x"), 0);
                i3 = bh.getInt((String) y.get(str3 + ".description.$y"), 0);
                i4 = bh.getInt((String) y.get(str3 + ".description.$width"), 0);
                i5 = bh.getInt((String) y.get(str3 + ".description.$font"), 0);
                VA = bh.VA((String) y.get(str3 + ".description.$color"));
                aVar.desc = (String) y.get(str3 + ".description");
                aVar.pDf = VA;
                aVar.vio = new Rect(i2, i3, i4 + i2, i5 + i3);
                aVar.url = (String) y.get(str3 + ".url");
                aVar.hid = (String) y.get(str3 + ".time.start");
                aVar.hie = (String) y.get(str3 + ".time.end");
                x.d("MicroMsg.PushMessage", "parseMessages id:" + aVar.id + " start:" + aVar.hid + " end:" + aVar.hie);
                Map hashMap = new HashMap();
                i3 = 0;
                while (true) {
                    str5 = str3 + ".images.image" + (i3 > 0 ? Integer.valueOf(i3) : "");
                    str4 = (String) y.get(str5);
                    x.d("MicroMsg.PushMessage", " img res:" + str4);
                    if (str4 == null) {
                        break;
                    }
                    str5 = (String) y.get(str5 + ".$type");
                    if (hashSet.contains(str5)) {
                        hashMap.put(str5, str4);
                    }
                    i3++;
                }
                if (hashMap.size() > 0) {
                    aVar.vip = hashMap;
                }
                x.d("MicroMsg.PushMessage", "msgid :" + aVar.id);
                arrayList.add(aVar);
            }
            i++;
        }
        x.d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static void bZH() {
        ar.Hg();
        c.CU().set(8193, "");
        ar.Hg();
        c.CU().set(8449, Long.valueOf(0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a em(Context context) {
        int i = 1;
        ar.Hg();
        long o = (long) bh.o(c.CU().get(8449, null), 0);
        long Wo = bh.Wo() - o;
        if (o <= 0 || Wo < 86400) {
            ar.Hg();
            String str = (String) c.CU().get(8193, null);
            if (!bh.ov(str)) {
                if (str.contains("id=\"setavatar\"")) {
                    bZH();
                } else {
                    a aVar;
                    if (!bh.ov(str)) {
                        ArrayList bb = bb(context, str);
                        if (bb == null || bb.size() != 1) {
                            aVar = null;
                            if (aVar == null) {
                                return aVar;
                            }
                            bZH();
                        } else {
                            aVar = (a) bb.get(0);
                            if (aVar.vip == null || aVar.vip.size() <= 0) {
                                i = 0;
                            }
                            if (i != 0) {
                            }
                        }
                    }
                    aVar = null;
                    if (aVar == null) {
                        return aVar;
                    }
                    bZH();
                }
            }
        } else {
            bZH();
        }
        return null;
    }
}
