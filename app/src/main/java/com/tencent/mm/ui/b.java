package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;

public final class b {
    public TextView iiq;
    private View tEo;
    public ImageView xDA;
    private View xDB;
    private ImageView xDv;
    public TextView xDw;
    public ImageView xDx;
    public ImageView xDy;
    private ImageView xDz;

    public b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.iiq = (TextView) view.findViewById(g.cSi);
        this.xDw = (TextView) view.findViewById(g.cPB);
        this.xDx = (ImageView) view.findViewById(g.gVV);
        this.xDy = (ImageView) view.findViewById(g.gVX);
        this.xDz = (ImageView) view.findViewById(g.gWd);
        this.tEo = view.findViewById(g.gVl);
        this.xDv = (ImageView) view.findViewById(g.bLi);
        this.xDA = (ImageView) view.findViewById(g.gWf);
        this.xDB = view;
    }

    public final void setTitle(CharSequence charSequence) {
        this.iiq.setText(charSequence);
        if (a.ey(this.iiq.getContext())) {
            this.iiq.setTextSize(0, ((float) a.ab(this.iiq.getContext(), e.bum)) * a.ew(this.iiq.getContext()));
        }
    }

    public final void lL(boolean z) {
        this.xDz.setVisibility(z ? 0 : 8);
    }

    public final void p(OnClickListener onClickListener) {
        this.tEo.setOnClickListener(onClickListener);
    }
}
