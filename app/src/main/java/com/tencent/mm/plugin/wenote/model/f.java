package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static String ah(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static float bv(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static String s(Context context, int i) {
        b fvVar = new fv();
        fvVar.fvq.type = 21;
        fvVar.fvq.context = context;
        fvVar.fvq.fvy = i;
        a.xef.m(fvVar);
        return fvVar.fvr.path;
    }

    public static String QI(String str) {
        return g.s((str + 18 + System.currentTimeMillis()).getBytes());
    }

    public static String i(uq uqVar) {
        b fvVar = new fv();
        fvVar.fvq.type = 27;
        fvVar.fvq.fvs = uqVar;
        a.xef.m(fvVar);
        return fvVar.fvr.fvC;
    }

    public static String o(uq uqVar) {
        b fvVar = new fv();
        fvVar.fvq.type = 27;
        fvVar.fvq.fvs = uqVar;
        a.xef.m(fvVar);
        return fvVar.fvr.path;
    }

    public static com.tencent.mm.plugin.fav.a.f ea(long j) {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavItemInfoStorage().db(j);
    }

    public static void s(long j, String str) {
        if (j > 0) {
            b fvVar = new fv();
            fvVar.fvq.type = 34;
            fvVar.fvq.fqk = j;
            a.xef.m(fvVar);
            if (fvVar.fvq.fqr != null && fvVar.fvq.fqr.weU != null && fvVar.fvq.fqr.weU.size() > 1 && ((uq) fvVar.fvq.fqr.weU.get(0)).wdL == null) {
                x.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavItemHtmlIdStorage");
                if (!bh.ov(str) && e.bO(str)) {
                    try {
                        CharSequence QZ = c.QZ(str);
                        ve veVar = fvVar.fvq.fqr;
                        ArrayList arrayList = new ArrayList();
                        if (!bh.ov(QZ) && QZ.length() != 0) {
                            int indexOf;
                            Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(QZ);
                            String str2 = "WeNote_";
                            while (matcher.find()) {
                                String group = matcher.group();
                                int indexOf2 = group.indexOf(str2);
                                if (indexOf2 != -1) {
                                    int indexOf3 = group.indexOf("\"", indexOf2 + 1);
                                    if (indexOf3 != -1) {
                                        indexOf = group.indexOf(" ", indexOf2 + 1);
                                        if (indexOf != -1) {
                                            if (indexOf3 >= indexOf) {
                                                indexOf3 = indexOf;
                                            }
                                            arrayList.add(group.substring(indexOf2, indexOf3));
                                        }
                                    }
                                }
                            }
                            LinkedList linkedList = new LinkedList();
                            Iterator it = veVar.weU.iterator();
                            indexOf = 0;
                            int i = 0;
                            while (it.hasNext()) {
                                uq uqVar = (uq) it.next();
                                int i2;
                                if (i == 0) {
                                    uqVar.TN("WeNoteHtmlFile");
                                    i2 = i + 1;
                                    linkedList.add(uqVar);
                                    i = i2;
                                } else {
                                    if (uqVar.bjS == 1) {
                                        uqVar.TN("-1");
                                    } else {
                                        i2 = indexOf + 1;
                                        uqVar.TN((String) arrayList.get(indexOf));
                                        indexOf = i2;
                                    }
                                    linkedList.add(uqVar);
                                }
                            }
                            b fvVar2 = new fv();
                            fvVar2.fvq.type = 33;
                            fvVar2.fvq.fqr = veVar;
                            fvVar2.fvq.fqr.weU = linkedList;
                            fvVar2.fvq.fqk = j;
                            a.xef.m(fvVar2);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[]{e.getMessage()});
                    }
                }
            }
        }
    }

    public static void Z(ArrayList<String> arrayList) {
        int i = 0;
        if (c.bVN().tQn == null) {
            x.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            return;
        }
        ve veVar = c.bVN().tQn.tQz;
        List arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (veVar == null) {
            x.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            return;
        }
        Iterator it = veVar.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (!(bh.ov(uqVar.wdL) || uqVar.wdL.contains("WeNoteHtmlFile") || uqVar.wdL.contains("-1"))) {
                arrayList2.add(uqVar.wdL);
                hashMap.put(uqVar.wdL, uqVar);
            }
        }
        if (arrayList.size() == arrayList2.size() && arrayList2.containsAll(arrayList) && arrayList.containsAll(arrayList2)) {
            int i2;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (!((String) arrayList2.get(i3)).trim().equals(((String) arrayList.get(i3)).trim())) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                LinkedList linkedList = new LinkedList();
                while (i < arrayList.size()) {
                    linkedList.add(hashMap.get(arrayList.get(i)));
                    i++;
                }
                veVar.av(linkedList);
                bVP();
                hashMap.clear();
                return;
            }
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() != 0) {
            List<uq> arrayList3 = new ArrayList();
            Iterator it2 = veVar.weU.iterator();
            while (it2.hasNext()) {
                uqVar = (uq) it2.next();
                if (arrayList2.contains(uqVar.wdL)) {
                    arrayList3.add(uqVar);
                }
            }
            for (uq uqVar2 : arrayList3) {
                veVar.weU.remove(uqVar2);
            }
            bVP();
        }
    }

    private static void bVP() {
        b fvVar = new fv();
        fvVar.fvq.type = 30;
        if (c.bVN().tQn != null) {
            fvVar.fvq.fqr = c.bVN().tQn.tQz;
            a.xef.m(fvVar);
            c.bVN().tQn.QG(fvVar.fvr.path);
        }
    }
}
