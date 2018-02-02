package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.d.a;
import com.tencent.mm.ui.contact.a.d.b;

public class a$a extends b {
    final /* synthetic */ a oHT;

    public a$a(a aVar) {
        this.oHT = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.dow, viewGroup, false);
        a aVar = (a) a.a(this.oHT);
        aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
        aVar.iiq = (TextView) inflate.findViewById(R.h.cSu);
        aVar.iir = (TextView) inflate.findViewById(R.h.caS);
        aVar.contentView = inflate.findViewById(R.h.cKR);
        aVar.iis = (CheckBox) inflate.findViewById(R.h.cKI);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        a aVar3 = (a) aVar;
        d dVar = (d) aVar2;
        if (dVar.username == null || dVar.username.length() <= 0) {
            aVar3.iip.setImageResource(R.g.bBB);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.iip, dVar.username);
        }
        e.a(dVar.iil, aVar3.iiq);
        if (this.oHT.ySW) {
            if (z) {
                aVar3.iis.setChecked(true);
                aVar3.iis.setEnabled(false);
            } else {
                aVar3.iis.setChecked(z2);
                aVar3.iis.setEnabled(true);
            }
            aVar3.iis.setVisibility(0);
            return;
        }
        aVar3.iis.setVisibility(8);
    }
}
