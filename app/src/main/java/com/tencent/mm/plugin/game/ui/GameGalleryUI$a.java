package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;

class GameGalleryUI$a extends u {
    Context mContext;
    private String[] nqM = new String[0];
    private View[] nqN;

    public GameGalleryUI$a(Context context, String[] strArr) {
        this.mContext = context;
        if (strArr != null) {
            this.nqM = strArr;
        }
        this.nqN = new View[this.nqM.length];
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View view = this.nqN[i];
        if (view == null) {
            View inflate = View.inflate(this.mContext, R.i.dkt, null);
            this.nqN[i] = inflate;
            ImageView imageView = (ImageView) inflate.findViewById(R.h.cme);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.h.cmg);
            progressBar.setVisibility(0);
            a PA = o.PA();
            String str = this.nqM[i];
            c.a aVar = new c.a();
            aVar.hDz = true;
            PA.a(str, imageView, aVar.PK(), new 1(this, progressBar));
            view = inflate;
        }
        viewGroup.addView(view);
        view.setOnClickListener(new 2(this));
        return view;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int getCount() {
        return this.nqM.length;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }
}
