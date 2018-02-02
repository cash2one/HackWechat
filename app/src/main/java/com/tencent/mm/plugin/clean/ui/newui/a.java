package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> kmb = new HashSet();
    CleanChattingUI lhG;

    public final /* synthetic */ Object getItem(int i) {
        return oo(i);
    }

    public a(CleanChattingUI cleanChattingUI) {
        this.lhG = cleanChattingUI;
    }

    public final int getCount() {
        ArrayList ayk = d.ayk();
        if (ayk != null) {
            return ayk.size();
        }
        return 0;
    }

    private static b oo(int i) {
        return (b) d.ayk().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.lhG.getLayoutInflater().inflate(R.i.dew, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.iip = (ImageView) view.findViewById(R.h.bLL);
            aVar2.iiq = (TextView) view.findViewById(R.h.cSu);
            aVar2.iir = (TextView) view.findViewById(R.h.caS);
            aVar2.iis = (CheckBox) view.findViewById(R.h.cKI);
            aVar2.kme = (RelativeLayout) view.findViewById(R.h.cKJ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kme.setOnClickListener(new 1(this, i));
        b oo = oo(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.iip, oo.username);
        aVar.iiq.setText(bh.bx(oo.fwg));
        if (s.eV(oo.username)) {
            aVar.iir.setText(i.b(this.lhG, r.L(oo.username, oo.username), aVar.iir.getTextSize()));
        } else {
            aVar.iir.setText(i.b(this.lhG, r.gu(oo.username), aVar.iir.getTextSize()));
        }
        if (this.kmb.contains(Integer.valueOf(i))) {
            aVar.iis.setChecked(true);
        } else {
            aVar.iis.setChecked(false);
        }
        return view;
    }

    public final void ayy() {
        this.kmb.clear();
        this.lhG.a(this.kmb);
    }
}
