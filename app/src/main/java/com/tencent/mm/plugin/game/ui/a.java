package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.dt;

public final class a extends b<dt> {
    public a(Context context) {
        super(context);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        dt dtVar = (dt) getItem(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.daH, null);
            a aVar2 = new a();
            aVar2.nkH = (ImageView) view.findViewById(R.h.cml);
            aVar2.nkJ = (TextView) view.findViewById(R.h.bIl);
            aVar2.nkI = (TextView) view.findViewById(R.h.cmV);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Bitmap Cd = Cd(dtVar.nfn);
        if (Cd == null) {
            aVar.nkH.setImageResource(R.g.byX);
        } else {
            aVar.nkH.setImageBitmap(Cd);
        }
        aVar.nkI.setText(g.l(this.mContext, dtVar.nfn));
        if (g.RA(dtVar.nfn)) {
            aVar.nkJ.setText(R.l.emZ);
        } else {
            aVar.nkJ.setText(R.l.ena);
        }
        return view;
    }
}
