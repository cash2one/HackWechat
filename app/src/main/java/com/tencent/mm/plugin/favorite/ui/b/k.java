package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.b.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.List;

public final class k extends a {
    private final int mxU;
    private HashMap<String, SpannableString> myt = new HashMap();

    public static class a extends b {
        ImageView jCP;
        ImageView myj;
        ImageView myu;
        TextView myv;
        TextView myw;
        TextView myx;
        TextView myy;
        FrameLayout myz;
    }

    public k(h hVar) {
        super(hVar);
        this.mxU = com.tencent.mm.bv.a.aa(hVar.context, R.f.buZ);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View a(View view, ViewGroup viewGroup, f fVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dhA, null), aVar, fVar);
            aVar.jCP = (ImageView) view.findViewById(R.h.cgI);
            aVar.myv = (TextView) view.findViewById(R.h.chp);
            aVar.myw = (TextView) view.findViewById(R.h.cgv);
            aVar.myx = (TextView) view.findViewById(R.h.chq);
            aVar.myy = (TextView) view.findViewById(R.h.cgw);
            aVar.myj = (ImageView) view.findViewById(R.h.cgO);
            aVar.myu = (ImageView) view.findViewById(R.h.cgN);
            aVar.myz = (FrameLayout) view.findViewById(R.h.cgJ);
            bVar = aVar;
        } else {
            bVar = (a) view.getTag();
        }
        a(bVar, fVar);
        List<uq> list = fVar.field_favProto.weU;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        Object obj = null;
        for (uq uqVar : list) {
            int i4;
            boolean z2;
            Object obj2;
            switch (uqVar.bjS) {
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 14:
                case 16:
                case 17:
                    if (obj == null) {
                        int i5 = 1;
                        i4 = i3;
                        z2 = z;
                        break;
                    }
                case 2:
                case 4:
                case 15:
                    if (!z) {
                        obj2 = obj;
                        i2 = i3;
                        i4 = i;
                        z2 = true;
                        break;
                    }
                default:
                    obj2 = obj;
                    i4 = i;
                    z2 = z;
                    break;
            }
            i3++;
            i = i4;
            z = z2;
            obj = obj2;
        }
        x.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (list.size() <= 0) {
            x.w("MicroMsg.FavRecordListItem", "dataList size is null");
        } else {
            a(bVar.myv, bVar.myw, (uq) list.get(i));
            if (z) {
                bVar.myz.setVisibility(0);
                bVar.jCP.setVisibility(0);
                ImageView imageView = bVar.jCP;
                uq uqVar2 = (uq) list.get(i2);
                switch (uqVar2.bjS) {
                    case 2:
                        h hVar = this.mpb;
                        i2 = R.k.dAu;
                        i4 = this.mxU;
                        int i6 = this.mxU;
                        if (imageView != null) {
                            if (com.tencent.mm.compatible.util.f.ze()) {
                                if (!(uqVar2 == null || fVar == null)) {
                                    String str = uqVar2.mvG;
                                    if (str != null) {
                                        String[] strArr = null;
                                        if (uqVar2.mvG != null) {
                                            String[] strArr2 = (String[]) hVar.mrt.get(str);
                                            if (strArr2 == null) {
                                                strArr = new String[]{j.h(uqVar2), j.i(uqVar2)};
                                                hVar.mrt.put(str, strArr);
                                            } else {
                                                strArr = strArr2;
                                            }
                                        }
                                        hVar.mrs.a(imageView, strArr, null, i2, i4, i6);
                                        if (strArr != null && strArr.length > 0) {
                                            ar.Dm().F(new h$2(hVar, strArr[0], fVar, uqVar2));
                                            break;
                                        }
                                    }
                                }
                            }
                            imageView.setImageResource(R.g.bEi);
                            break;
                        }
                        break;
                    case 4:
                    case 15:
                        this.mpb.b(imageView, uqVar2, fVar, R.k.dvA, this.mxU, this.mxU);
                        break;
                }
            }
            bVar.myz.setVisibility(8);
            bVar.jCP.setVisibility(8);
            if (i + 1 < list.size()) {
                bVar.myx.setVisibility(0);
                bVar.myy.setVisibility(0);
                a(bVar.myx, bVar.myy, (uq) list.get(i + 1));
            } else {
                bVar.myx.setVisibility(8);
                bVar.myy.setVisibility(8);
            }
        }
        return view;
    }

    private static void a(TextView textView, TextView textView2, uq uqVar) {
        if (uqVar.wdG) {
            textView.setVisibility(0);
            textView.setText(i.b(textView.getContext(), uqVar.wdF, textView.getTextSize()));
        } else {
            x.d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        }
        x.d("MicroMsg.FavRecordListItem", "field type %d", new Object[]{Integer.valueOf(uqVar.bjS)});
        switch (uqVar.bjS) {
            case 1:
                textView2.setText(i.b(textView2.getContext(), uqVar.desc, textView2.getTextSize()));
                return;
            case 2:
                textView2.setText(t(textView2.getContext(), R.l.egD));
                return;
            case 3:
                textView2.setText(t(textView2.getContext(), R.l.egJ));
                return;
            case 4:
                textView2.setText(t(textView2.getContext(), R.l.egI));
                return;
            case 5:
                textView2.setText(t(textView2.getContext(), R.l.egH) + uqVar.title);
                return;
            case 6:
                ux uxVar = uqVar.wdD.wdZ;
                textView2.setText(t(textView2.getContext(), R.l.egE) + (bh.ov(uxVar.fDu) ? uxVar.label : uxVar.fDu));
                return;
            case 7:
                textView2.setText(t(textView2.getContext(), R.l.egF) + uqVar.title);
                return;
            case 8:
                textView2.setText(t(textView2.getContext(), R.l.egC) + uqVar.title);
                return;
            case 10:
                textView2.setText(t(textView2.getContext(), R.l.efO) + uqVar.wdD.wed.title);
                return;
            case 15:
                textView2.setText(t(textView2.getContext(), R.l.egA));
                return;
            case 16:
                textView2.setText(t(textView2.getContext(), R.l.efA));
                return;
            case 17:
                textView2.setText(t(textView2.getContext(), R.l.egG));
                return;
            default:
                return;
        }
    }

    private static String t(Context context, int i) {
        return "[" + context.getResources().getString(i) + "]";
    }

    public final void a(View view, vg vgVar) {
        e.a(view.getContext(), ((a) view.getTag()).mqC, vgVar);
    }
}
