package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    private static int mxU;

    public static class a extends b {
        View mye;
        View myf;
        View myg;
        View myh;
        ImageView myi;
        ImageView myj;
        View myk;
        TextView myl;
        TextView mym;
        TextView myn;
        ImageView myo;
        TextView myp;
        TextView myq;
        TextView myr;
    }

    public i(h hVar) {
        super(hVar);
        mxU = com.tencent.mm.bv.a.aa(hVar.context, R.f.buZ);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhE, null), aVar, fVar);
            aVar.mye = view.findViewById(R.h.cGT);
            aVar.myf = view.findViewById(R.h.bWH);
            aVar.myg = view.findViewById(R.h.cWo);
            aVar.myh = view.findViewById(R.h.cgX);
            aVar.myi = (ImageView) view.findViewById(R.h.cgV);
            aVar.myk = view.findViewById(R.h.cgK);
            aVar.myj = (ImageView) view.findViewById(R.h.cgO);
            aVar.myl = (TextView) view.findViewById(R.h.cgL);
            aVar.mym = (TextView) view.findViewById(R.h.cgY);
            aVar.myn = (TextView) view.findViewById(R.h.cgW);
            aVar.myo = (ImageView) view.findViewById(R.h.cgt);
            aVar.myp = (TextView) view.findViewById(R.h.cgn);
            aVar.myq = (TextView) view.findViewById(R.h.cgm);
            aVar.myr = (TextView) view.findViewById(R.h.cht);
            view.setTag(aVar);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, fVar);
        List list = fVar.field_favProto.weU;
        if (list.size() < 2) {
            x.e("MicroMsg.Fav.FavNoteListItem", "no other item");
        } else {
            uq uqVar;
            Object obj;
            int i = -1;
            int i2 = 0;
            int size = list.size();
            Object obj2 = null;
            int i3 = -1;
            Object obj3 = 1;
            int i4 = 0;
            while (i4 < list.size()) {
                int i5;
                uqVar = (uq) list.get(i4);
                if (i4 != 0) {
                    if (uqVar.bjS == 2 || uqVar.bjS == 4 || uqVar.bjS == 15) {
                        i2++;
                        obj2 = 1;
                        if (i == -1) {
                            i = i4;
                        }
                    }
                    switch (uqVar.bjS) {
                        case 1:
                            if (bh.az(uqVar.desc, "").trim().length() <= 0) {
                                size--;
                                i5 = i;
                                i = i2;
                                break;
                            }
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 10:
                        case 11:
                        case 14:
                        case 16:
                            i3 = i4;
                            i5 = i;
                            i = i2;
                            break;
                        default:
                            obj3 = null;
                            i5 = i;
                            i = i2;
                            break;
                    }
                }
                File file = new File(j.h(uqVar));
                if (file.exists()) {
                    if (uqVar.wdL == null) {
                        com.tencent.mm.sdk.b.b koVar = new ko();
                        koVar.fBM.type = 10;
                        koVar.fBM.field_localId = fVar.field_localId;
                        koVar.fBM.path = file.getAbsolutePath();
                        com.tencent.mm.sdk.b.a.xef.m(koVar);
                    }
                    i5 = i;
                    i = i2;
                } else {
                    h.a(fVar, uqVar);
                    i5 = i;
                    i = i2;
                }
                i4++;
                i2 = i;
                i = i5;
            }
            if (obj3 == null || size != 2) {
                obj = null;
            } else {
                obj = 1;
            }
            CharSequence charSequence;
            String str;
            int i6;
            Object obj4;
            String str2;
            if (obj == null || i3 <= 0) {
                bVar.mye.setVisibility(0);
                bVar.myf.setVisibility(8);
                bVar.myg.setVisibility(8);
                List arrayList = new ArrayList();
                charSequence = null;
                for (int i7 = 1; i7 < list.size(); i7++) {
                    uqVar = (uq) list.get(i7);
                    if (uqVar.bjS == 1) {
                        String[] strArr;
                        str = uqVar.desc;
                        if (bh.ov(str)) {
                            strArr = null;
                        } else {
                            if (str.length() > 1000) {
                                str = str.substring(0, 1000);
                            }
                            strArr = str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replace(" ", " ").split("\n");
                        }
                        if (strArr != null && strArr.length > 0) {
                            CharSequence charSequence2;
                            CharSequence charSequence3;
                            ArrayList arrayList2 = new ArrayList();
                            i6 = 0;
                            while (i6 < strArr.length) {
                                if (bh.ov(strArr[i6].trim())) {
                                    i6++;
                                } else {
                                    arrayList2.add(strArr[i6]);
                                    str = "";
                                    for (i3 = i6 + 1; i3 < strArr.length; i3++) {
                                        str = str + strArr[i3] + " ";
                                    }
                                    str = str.trim();
                                    if (str.length() > 0) {
                                        arrayList2.add(str);
                                    }
                                    if (arrayList2.size() > 0 || !bh.ov(charSequence)) {
                                        charSequence2 = charSequence;
                                        i4 = 0;
                                        charSequence3 = charSequence2;
                                    } else {
                                        str = (String) arrayList2.get(0);
                                        i4 = 1;
                                    }
                                    while (i4 < arrayList2.size()) {
                                        arrayList.add(arrayList2.get(i4));
                                        i4++;
                                    }
                                    obj4 = str;
                                }
                            }
                            i6 = 0;
                            str = "";
                            for (i3 = i6 + 1; i3 < strArr.length; i3++) {
                                str = str + strArr[i3] + " ";
                            }
                            str = str.trim();
                            if (str.length() > 0) {
                                arrayList2.add(str);
                            }
                            if (arrayList2.size() > 0) {
                            }
                            charSequence2 = charSequence;
                            i4 = 0;
                            charSequence3 = charSequence2;
                            while (i4 < arrayList2.size()) {
                                arrayList.add(arrayList2.get(i4));
                                i4++;
                            }
                            obj4 = str;
                        }
                    } else {
                        Context context2 = view.getContext();
                        str2 = "";
                        switch (uqVar.bjS) {
                            case 3:
                                str = com.tencent.mm.am.a.t(context2, R.l.egJ) + " " + com.tencent.mm.am.a.s(context2, uqVar.duration);
                                break;
                            case 5:
                                str = com.tencent.mm.am.a.t(context2, R.l.egH) + " " + uqVar.title;
                                break;
                            case 6:
                                ux uxVar = uqVar.wdD.wdZ;
                                if (!com.tencent.mm.am.a.kO(uxVar.fDu)) {
                                    str = com.tencent.mm.am.a.t(context2, R.l.egE) + " " + uxVar.label;
                                    break;
                                }
                                str = com.tencent.mm.am.a.t(context2, R.l.egE) + " " + uxVar.fDu;
                                break;
                            case 7:
                                str = com.tencent.mm.am.a.t(context2, R.l.egF) + " " + uqVar.title;
                                break;
                            case 8:
                                str = com.tencent.mm.am.a.t(context2, R.l.egC) + " " + uqVar.title;
                                break;
                            case 10:
                                str = com.tencent.mm.am.a.t(context2, R.l.efO) + " " + uqVar.wdD.wed.title;
                                break;
                            case 16:
                                str = com.tencent.mm.am.a.t(context2, R.l.efA);
                                break;
                            default:
                                str = str2;
                                break;
                        }
                        if (!bh.ov(str)) {
                            arrayList.add(str);
                        }
                    }
                }
                if (bh.ov(charSequence)) {
                    bVar.mym.setVisibility(8);
                } else {
                    bVar.mym.setText(com.tencent.mm.pluginsdk.ui.d.i.b(bVar.mym.getContext(), charSequence, bVar.mym.getTextSize()));
                    bVar.mym.setVisibility(0);
                    if (arrayList.size() > 0) {
                        bVar.mym.setMaxLines(1);
                    } else {
                        bVar.mym.setMaxLines(3);
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                i4 = 0;
                while (i4 < arrayList.size() && i4 < 2) {
                    stringBuffer.append((String) arrayList.get(i4));
                    stringBuffer.append("\n");
                    i4++;
                }
                if (stringBuffer.length() != 0) {
                    bVar.myn.setText(com.tencent.mm.pluginsdk.ui.d.i.b(bVar.myn.getContext(), stringBuffer.substring(0, stringBuffer.length() - 1), bVar.myn.getTextSize()));
                    bVar.myn.setVisibility(0);
                } else {
                    bVar.myn.setVisibility(8);
                }
                if (obj2 != null) {
                    bVar.myh.setVisibility(0);
                    uq uqVar2 = (uq) list.get(i);
                    if (((uq) list.get(i)).bjS == 2) {
                        h.a(bVar.myi, R.k.dyy, uqVar2, fVar, true, mxU, mxU);
                        bVar.myj.setVisibility(8);
                    } else {
                        bVar.myj.setVisibility(0);
                        this.mpb.a(bVar.myi, uqVar2, fVar, uqVar2.fqf, R.k.dvA, mxU, mxU);
                    }
                    if (i2 > 1) {
                        bVar.myl.setText(view.getContext().getString(R.l.efB, new Object[]{Integer.valueOf(i2)}));
                        bVar.myl.setVisibility(0);
                        bVar.myk.setVisibility(0);
                    } else {
                        bVar.myl.setVisibility(8);
                        bVar.myk.setVisibility(8);
                    }
                } else {
                    bVar.myh.setVisibility(8);
                }
            } else {
                uqVar = (uq) list.get(i3);
                if (uqVar.bjS == 3) {
                    bVar.mye.setVisibility(8);
                    bVar.myf.setVisibility(8);
                    bVar.myg.setVisibility(0);
                    bVar.myr.setText(com.tencent.mm.am.a.s(this.mpb.context, uqVar.duration));
                } else {
                    CharSequence charSequence4;
                    if (uqVar.bjS == 6) {
                        int i8;
                        i4 = R.k.dvm;
                        ux uxVar2 = uqVar.wdD.wdZ;
                        str = uqVar.wdD.iIj;
                        if (bh.ov(str)) {
                            if (com.tencent.mm.am.a.kO(uxVar2.fDu)) {
                                str = uxVar2.fDu;
                            } else {
                                i8 = i4;
                                charSequence = null;
                                obj3 = uxVar2.label;
                                i6 = i8;
                            }
                        } else if (com.tencent.mm.am.a.kO(uxVar2.fDu)) {
                            i8 = i4;
                            obj4 = uxVar2.fDu;
                            obj3 = str;
                            i6 = i8;
                        }
                        i8 = i4;
                        charSequence = uxVar2.label;
                        charSequence4 = str;
                        i6 = i8;
                    } else {
                        i4 = c.Rr(uqVar.wcY);
                        str2 = uqVar.title;
                        String str3 = uqVar.desc;
                        if (bh.ov(str3)) {
                            obj3 = str2;
                            String ah = j.ah((float) uqVar.wde);
                            i6 = i4;
                            obj4 = ah;
                        } else {
                            i6 = i4;
                            obj4 = str3;
                            obj3 = str2;
                        }
                    }
                    bVar.myg.setVisibility(8);
                    bVar.mye.setVisibility(8);
                    bVar.myf.setVisibility(0);
                    bVar.myo.setImageResource(i6);
                    bVar.myp.setText(charSequence4);
                    if (bh.ov(charSequence)) {
                        bVar.myq.setVisibility(8);
                    } else {
                        bVar.myq.setText(charSequence);
                        bVar.myq.setVisibility(0);
                    }
                }
            }
        }
        return view;
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
