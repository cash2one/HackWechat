package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class e$a {
    public String desc;
    public String fvC;
    public String mpH;
    public String title;

    private static boolean zW(String str) {
        return new File(str).exists();
    }

    public static e$a a(Context context, f fVar) {
        int i;
        String str;
        String i2;
        if (fVar.field_type == 18) {
            e$a com_tencent_mm_plugin_favorite_a_e_a = new e$a();
            SparseIntArray sparseIntArray = new SparseIntArray();
            if (fVar.field_type == 18) {
                com_tencent_mm_plugin_favorite_a_e_a.title = fVar.field_favProto.title;
            }
            List<String> linkedList = new LinkedList();
            i = 0;
            int i3 = 0;
            for (uq uqVar : fVar.field_favProto.weU) {
                if (fVar.field_type != 18 || bh.ov(uqVar.wcY) || !uqVar.wcY.equals(".htm")) {
                    sparseIntArray.put(uqVar.bjS, sparseIntArray.get(uqVar.bjS) + 1);
                    switch (uqVar.bjS) {
                        case 1:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            str = uqVar.desc;
                            if (!bh.ov(str)) {
                                linkedList.add(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + "\n");
                                break;
                            }
                            break;
                        case 2:
                            linkedList.size();
                            if (i != 0) {
                                break;
                            }
                            i2 = j.i(uqVar);
                            if (!zW(i2)) {
                                com_tencent_mm_plugin_favorite_a_e_a.fvC = j.h(uqVar);
                                i = 1;
                                break;
                            }
                            com_tencent_mm_plugin_favorite_a_e_a.fvC = i2;
                            i = 1;
                            break;
                        case 3:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            int dh = (int) j.dh((long) uqVar.duration);
                            linkedList.add(context.getString(R.l.dGY) + context.getString(R.l.ejo, new Object[]{Integer.valueOf(dh)}) + "\n");
                            break;
                        case 4:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            linkedList.add(context.getString(R.l.dGX) + "\n");
                            break;
                        case 6:
                            if (linkedList.size() < 4) {
                                ux uxVar = uqVar.wdD.wdZ;
                                StringBuilder append = new StringBuilder().append(context.getString(R.l.dFz));
                                str = (bh.ov(uxVar.fDu) || uxVar.fDu.equals(context.getString(R.l.eth))) ? uxVar.label : uxVar.fDu;
                                linkedList.add(append.append(str).append("\n").toString());
                            }
                            if (i3 != 0) {
                                break;
                            }
                            i3 = 1;
                            break;
                            break;
                        case 8:
                            if (linkedList.size() < 4) {
                                linkedList.add(context.getString(R.l.dFj) + uqVar.title + "\n");
                            }
                            if (i3 != 0) {
                                break;
                            }
                            i3 = 1;
                            break;
                        case 17:
                            if (linkedList.size() >= 4) {
                                break;
                            }
                            linkedList.add(context.getString(R.l.dGs) + "\n");
                            break;
                        default:
                            break;
                    }
                }
            }
            com_tencent_mm_plugin_favorite_a_e_a.desc = "";
            i2 = "";
            for (String str2 : linkedList) {
                i2 = i2 + str2;
            }
            str2 = i2.trim();
            if (linkedList.size() >= 4) {
                str2 = str2 + "...";
            }
            com_tencent_mm_plugin_favorite_a_e_a.desc = str2;
            com_tencent_mm_plugin_favorite_a_e_a.title = ac.getContext().getString(R.l.egW);
            return com_tencent_mm_plugin_favorite_a_e_a;
        }
        e$a com_tencent_mm_plugin_favorite_a_e_a2 = new e$a();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        if (fVar.field_type == 14) {
            com_tencent_mm_plugin_favorite_a_e_a2.title = fVar.field_favProto.title;
        }
        List<String> linkedList2 = new LinkedList();
        i = 0;
        for (uq uqVar2 : fVar.field_favProto.weU) {
            sparseIntArray2.put(uqVar2.bjS, sparseIntArray2.get(uqVar2.bjS) + 1);
            switch (uqVar2.bjS) {
                case 1:
                    if (linkedList2.size() >= 4) {
                        break;
                    }
                    linkedList2.add(uqVar2.wdF + ":" + uqVar2.desc + "\n");
                    break;
                case 2:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGj) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    str2 = j.i(uqVar2);
                    if (zW(str2)) {
                        com_tencent_mm_plugin_favorite_a_e_a2.fvC = str2;
                        dh = 1;
                    } else {
                        dh = i;
                    }
                    i = dh;
                    break;
                case 3:
                    if (linkedList2.size() >= 4) {
                        break;
                    }
                    int bv = (int) j.bv((long) uqVar2.duration);
                    linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGY) + context.getString(R.l.ejo, new Object[]{Integer.valueOf(bv)}) + "\n");
                    break;
                case 4:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGX) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    str2 = j.i(uqVar2);
                    if (zW(str2)) {
                        com_tencent_mm_plugin_favorite_a_e_a2.fvC = str2;
                        dh = 1;
                    } else {
                        dh = i;
                    }
                    i = dh;
                    break;
                case 5:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGU) + uqVar2.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    i2 = j.i(uqVar2);
                    if (zW(i2)) {
                        com_tencent_mm_plugin_favorite_a_e_a2.fvC = i2;
                    } else {
                        vt vtVar = uqVar2.wdD.web;
                        i2 = vtVar == null ? "" : vtVar.thumbUrl;
                        if (bh.ov(i2)) {
                            i2 = bh.az(uqVar2.fqf, "");
                        }
                        a(com_tencent_mm_plugin_favorite_a_e_a2, i2);
                    }
                    i = 1;
                    break;
                case 6:
                    if (linkedList2.size() < 4) {
                        ux uxVar2 = uqVar2.wdD.wdZ;
                        append = new StringBuilder().append(uqVar2.wdF).append(":").append(context.getString(R.l.dFz));
                        str2 = (bh.ov(uxVar2.fDu) || uxVar2.fDu.equals(context.getString(R.l.eth))) ? uxVar2.label : uxVar2.fDu;
                        linkedList2.add(append.append(str2).append("\n").toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dFJ) + uqVar2.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(com_tencent_mm_plugin_favorite_a_e_a2, uqVar2.fqf);
                    i = 1;
                    break;
                case 8:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dFj) + uqVar2.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGl) + uqVar2.wdD.wed.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    vd vdVar = uqVar2.wdD.wed;
                    if (vdVar != null) {
                        a(com_tencent_mm_plugin_favorite_a_e_a2, vdVar.thumbUrl);
                    }
                    i = 1;
                    break;
                case 14:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dDN) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    vn vnVar = uqVar2.wdD.wef;
                    if (vnVar != null) {
                        a(com_tencent_mm_plugin_favorite_a_e_a2, vnVar.thumbUrl);
                    }
                    i = 1;
                    break;
                case 15:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGH) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    str2 = j.i(uqVar2);
                    if (zW(str2)) {
                        com_tencent_mm_plugin_favorite_a_e_a2.fvC = str2;
                        dh = 1;
                    } else {
                        dh = i;
                    }
                    i = dh;
                    break;
                case 16:
                    if (linkedList2.size() < 4) {
                        linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dFn) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    ar.Hg();
                    com_tencent_mm_plugin_favorite_a_e_a2.mpH = c.Fa().EK(uqVar2.desc).rYX;
                    i = 1;
                    break;
                case 17:
                    if (linkedList2.size() >= 4) {
                        break;
                    }
                    linkedList2.add(uqVar2.wdF + ":" + context.getString(R.l.dGs) + "\n");
                    break;
                default:
                    break;
            }
        }
        com_tencent_mm_plugin_favorite_a_e_a2.desc = "";
        i2 = "";
        for (String str22 : linkedList2) {
            i2 = i2 + str22;
        }
        str22 = i2.trim();
        if (linkedList2.size() >= 4) {
            str22 = str22 + "...";
        }
        com_tencent_mm_plugin_favorite_a_e_a2.desc = str22;
        return com_tencent_mm_plugin_favorite_a_e_a2;
    }

    private static void a(e$a com_tencent_mm_plugin_favorite_a_e_a, String str) {
        String str2 = j.aIE() + g.s(bh.az(str, "").getBytes());
        if (zW(str2)) {
            com_tencent_mm_plugin_favorite_a_e_a.fvC = str2;
        }
    }
}
