package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class h {
    private static Toast xYN;

    public static void a(Context context, Dialog dialog) {
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
    }

    public static Toast br(Context context, String str) {
        return bu(context, str);
    }

    public static Toast bs(Context context, String str) {
        return bu(context, str);
    }

    public static void bt(Context context, String str) {
        if (xYN == null) {
            xYN = Toast.makeText(context, str, 0);
        } else {
            xYN.setText(str);
        }
        xYN.show();
    }

    public static Toast bu(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        return makeText;
    }

    public static i B(Context context, String str, String str2) {
        return b(context, str, str2, true);
    }

    public static i b(Context context, String str, String str2, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.mi(z);
        aVar.EC(k.dFU).a(new 1());
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i h(Context context, int i, int i2) {
        return b(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", true);
    }

    public static i a(Context context, int i, int i2, OnClickListener onClickListener) {
        return a(context, i, i2, true, onClickListener);
    }

    public static i a(Context context, int i, int i2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        if (i2 > 0) {
            aVar.Ez(i2);
        }
        aVar.EA(i);
        aVar.EC(k.dFU).a(onClickListener);
        aVar.mi(z);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, OnClickListener onClickListener) {
        return a(context, str, str2, true, onClickListener);
    }

    public static i a(Context context, String str, String str2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.EC(k.dFU).a(onClickListener);
        aVar.mi(z);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        return a(context, str, str2, str3, true, onClickListener);
    }

    public static i a(Context context, String str, String str2, String str3, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.YI(str3).a(onClickListener);
        aVar.mi(z);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.EC(k.dFU).a(onClickListener);
        aVar.ED(k.dEn).b(onClickListener2);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.EC(k.dFU).a(onClickListener);
        aVar.ED(k.dEn).b(onClickListener2);
        aVar.mi(z);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
    }

    public static i a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.YI(str3).a(onClickListener);
        aVar.YJ(str4).b(onClickListener2);
        aVar.mi(z);
        i akx = aVar.akx();
        if (i > 0) {
            akx.Ex(context.getResources().getColor(i));
        }
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", onClickListener, onClickListener2);
    }

    public static i b(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", false, onClickListener, onClickListener2);
    }

    public static i a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2);
    }

    public static i a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, OnClickListener onClickListener2, int i5) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), false, onClickListener, onClickListener2, i5);
    }

    public static i a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        if (i2 != 0) {
            aVar.Ez(i2);
        }
        aVar.EA(i);
        aVar.EC(i3).a(onClickListener);
        aVar.ED(i4).b(onClickListener2);
        aVar.d(new 10(onClickListener2));
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.YI(str3).a(onClickListener);
        aVar.YJ(str4).b(onClickListener2);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.YI(str3).a(onClickListener);
        aVar.YJ(str4).b(onClickListener2);
        i akx = aVar.akx();
        akx.Ex(context.getResources().getColor(i));
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.YI(str3).a(onClickListener);
        aVar.YJ(str4).b(onClickListener2);
        aVar.mi(z);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i, int i2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.YI(str3).a(onClickListener);
        aVar.YJ(str4).b(onClickListener2);
        aVar.mi(z);
        i akx = aVar.akx();
        if (i > 0) {
            akx.Ex(context.getResources().getColor(i));
        }
        if (i2 > 0) {
            akx.Ey(context.getResources().getColor(i2));
        }
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str);
        aVar.dk(view);
        aVar.EC(k.dFU).a(onClickListener);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
    }

    public static i a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
    }

    public static i a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str);
        aVar.dk(view);
        aVar.YI(str2).a(onClickListener);
        aVar.YJ(str3).b(onClickListener2);
        aVar.mi(z);
        i akx = aVar.akx();
        if (i > 0) {
            akx.Ex(context.getResources().getColor(i));
        }
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str);
        aVar.dk(view);
        aVar.YI(str2).a(onClickListener);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, View view, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str);
        aVar.YG(null);
        aVar.dk(view);
        aVar.EC(k.dFU).a(onClickListener);
        aVar.ED(k.dEn).b(onClickListener2);
        aVar.d(new 11(onClickListener2));
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, String str3, int i, b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.mi(false);
        aVar.mj(true);
        aVar.ED(k.dEn).b(null);
        aVar.YF(str);
        View inflate = View.inflate(context, com.tencent.mm.w.a.h.gXq, null);
        MMEditText mMEditText = (MMEditText) inflate.findViewById(g.cdj);
        if (!bh.ov(str2)) {
            mMEditText.aak(str2);
        }
        TextView textView = (TextView) inflate.findViewById(g.cSe);
        if (bh.ov(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.EC(k.dFU).a(false, new 12(bVar, mMEditText, context));
        if (i > 0) {
            c.d(mMEditText).GN(i).a(null);
        }
        aVar.dk(inflate);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        if (!(context instanceof MMActivity)) {
            return akx;
        }
        inflate.post(new 13(context));
        return akx;
    }

    public static i a(Context context, String str, List<String> list, int i, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (list.isEmpty()) {
            x.w("MicroMsg.MMAlert", "show switch alert fail");
            return null;
        }
        a aVar2 = new a(context);
        aVar2.mi(false);
        aVar2.ED(k.dEn);
        aVar2.YF(str);
        View inflate = View.inflate(context, com.tencent.mm.w.a.h.dno, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.cPW);
        for (int size = list.size() - 1; size >= 0; size--) {
            TextView textView = (TextView) View.inflate(context, com.tencent.mm.w.a.h.dpW, null);
            textView.setText((CharSequence) list.get(size));
            if (size == i) {
                textView.setCompoundDrawablesWithIntrinsicBounds(j.dAr, 0, 0, 0);
            }
            if (size == list.size() - 1) {
                context.getResources().getDimensionPixelSize(e.bvJ);
                textView.setBackgroundResource(f.bGA);
            }
            textView.setTag(Integer.valueOf(size));
            linearLayout.addView(textView, 0);
            textView.setOnClickListener(new 14(linearLayout, aVar));
        }
        aVar2.dk(inflate);
        Dialog akx = aVar2.akx();
        linearLayout.setTag(akx);
        akx.show();
        a(context, akx);
        return akx;
    }

    public static i a(Context context, String str, String str2, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.YF(str2);
        aVar.YG(str);
        aVar.EC(k.dFU).a(onClickListener);
        aVar.d(onCancelListener);
        i akx = aVar.akx();
        akx.show();
        a(context, akx);
        return akx;
    }

    public static r a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        return a(context, 0, str, z, onCancelListener);
    }

    public static r a(Context context, String str, OnCancelListener onCancelListener) {
        return a(context, 2, str, true, onCancelListener);
    }

    private static r a(Context context, int i, String str, boolean z, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        ac.a(true, null);
        r b = r.b(context, str, z, i, new 15(new WeakReference(onCancelListener)));
        a(context, b);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, d dVar) {
        return b(context, str, list, list2, str2, true, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, d dVar) {
        return b(context, str, list, list2, str2, z, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, d dVar) {
        return b(context, str, list, list2, null, true, dVar);
    }

    @Deprecated
    private static Dialog b(Context context, final String str, List<String> list, final List<Integer> list2, final String str2, boolean z, d dVar) {
        if ((list == null || list.size() == 0) && bh.ov(str2)) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        if (z) {
            l lVar = new l(context);
            lVar.rKC = new 2(str, list, list2, str2);
            lVar.rKD = new 3(dVar);
            lVar.e(null);
            Dialog bBX = lVar.bBX();
            a(context, bBX);
            return bBX;
        }
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(context, com.tencent.mm.ui.widget.g.ztp, false);
        gVar.rKC = new p.c() {
            public final void a(n nVar) {
                if (!bh.ov(str)) {
                    nVar.setHeaderTitle(str);
                }
                for (int i = 0; i < list.size(); i++) {
                    nVar.f(((Integer) list2.get(i)).intValue(), (CharSequence) list.get(i));
                }
                if (!bh.ov(str2)) {
                    nVar.f(-1, str2);
                }
            }
        };
        gVar.rKD = new 5(dVar);
        gVar.bUk();
        return null;
    }

    public static Dialog a(Context context, String str, String[] strArr, c cVar) {
        return a(context, str, strArr, null, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar) {
        return a(context, str, strArr, str2, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, boolean z, c cVar) {
        return a(context, str, strArr, str2, z, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar, OnCancelListener onCancelListener) {
        return a(context, str, strArr, str2, true, cVar, onCancelListener);
    }

    @Deprecated
    public static Dialog a(Context context, final String str, String[] strArr, String str2, boolean z, c cVar, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if ((strArr == null || strArr.length == 0) && bh.ov(str2)) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            Collections.addAll(arrayList, strArr);
        }
        if (!bh.ov(str2)) {
            arrayList.add(str2);
        }
        if (z) {
            l lVar = new l(context);
            lVar.rKC = new p.c() {
                public final void a(n nVar) {
                    nVar.setHeaderTitle(str);
                    for (int i = 0; i < arrayList.size(); i++) {
                        nVar.f(i, (CharSequence) arrayList.get(i));
                    }
                }
            };
            lVar.rKD = new 7(cVar);
            lVar.e(onCancelListener);
            Dialog bBX = lVar.bBX();
            a(context, bBX);
            return bBX;
        }
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(context, com.tencent.mm.ui.widget.g.ztp, false);
        gVar.rKC = new 8(str, arrayList);
        gVar.rKD = new 9(cVar);
        gVar.bUk();
        return null;
    }
}
