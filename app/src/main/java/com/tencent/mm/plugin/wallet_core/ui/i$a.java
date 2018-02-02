package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.a;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.plugin.wallet_core.ui.i.c;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

class i$a extends BaseAdapter {
    final /* synthetic */ i sTF;
    int sTG = -1;
    List<q> sTH = new LinkedList();
    h sTI = null;
    m<String> sTJ = new 1(this);

    public i$a(i iVar) {
        this.sTF = iVar;
    }

    public final int getCount() {
        return this.sTH.size();
    }

    public final Object getItem(int i) {
        return this.sTH.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        e eVar;
        if (view == null) {
            view = i.c(this.sTF).inflate(g.uEQ, viewGroup, false);
            c cVar2 = new c();
            cVar2.sTL = view.findViewById(a$f.uyG);
            cVar2.jJn = (TextView) view.findViewById(a$f.uyF);
            cVar2.kQo = (TextView) view.findViewById(a$f.uyE);
            cVar2.lkn = (TextView) view.findViewById(a$f.uyD);
            cVar2.sTN = (CheckBox) view.findViewById(a$f.uyC);
            cVar2.sTM = (ImageView) view.findViewById(a$f.uyB);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        q qVar = (q) getItem(i);
        if (i != this.sTG || this.sTG <= 0) {
            cVar.sTL.setVisibility(8);
            cVar.sTM.setVisibility(0);
        } else {
            cVar.sTL.setVisibility(0);
            cVar.sTM.setVisibility(8);
        }
        if (bh.ov(qVar.sEd)) {
            cVar.jJn.setVisibility(8);
        } else {
            cVar.jJn.setText(qVar.sEd);
            cVar.jJn.setVisibility(0);
        }
        String str = qVar.sDk;
        if (!(this.sTI == null || this.sTI.sDG == null)) {
            List list = this.sTI.sDG;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (str.equals(((e) list.get(i2)).sDk)) {
                    eVar = (e) list.get(i2);
                    break;
                }
            }
        }
        eVar = null;
        String str2 = qVar.sDl;
        String str3 = qVar.sDm;
        if (eVar != null) {
            CharSequence charSequence = eVar.sDl;
            CharSequence charSequence2 = eVar.sDm;
        } else {
            Object obj = str3;
            Object obj2 = str2;
        }
        if (bh.ov(charSequence)) {
            cVar.kQo.setVisibility(8);
        } else {
            cVar.kQo.setText(charSequence);
            cVar.kQo.setVisibility(0);
        }
        if (bh.ov(charSequence2)) {
            cVar.lkn.setVisibility(8);
        } else {
            cVar.lkn.setText(charSequence2);
            cVar.lkn.setVisibility(0);
        }
        int i3 = ((b) this.sTJ.sNi.get(i)).sNq;
        if (i3 == a.sNl) {
            cVar.sTN.setChecked(false);
            cVar.sTN.setEnabled(false);
        } else {
            cVar.sTN.setEnabled(true);
            if (i3 == a.sNm) {
                cVar.sTN.setChecked(true);
            } else {
                cVar.sTN.setChecked(false);
            }
        }
        return view;
    }
}
