package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mm.R;

public final class g {
    public View mParentView;
    public PopupWindow tTh;
    public a tTi;

    public g(Context context, View view) {
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.i.duk, null);
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.tTh = new PopupWindow(inflate, -2, -2, false);
        this.tTh.setClippingEnabled(false);
        inflate.findViewById(R.h.cZy).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g tTj;

            {
                this.tTj = r1;
            }

            public final void onClick(View view) {
                this.tTj.tTh.dismiss();
                this.tTj.mParentView.setVisibility(8);
                if (this.tTj.tTi != null) {
                    this.tTj.tTi.bWF();
                }
            }
        });
        inflate.findViewById(R.h.cZv).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g tTj;

            {
                this.tTj = r1;
            }

            public final void onClick(View view) {
                this.tTj.tTh.dismiss();
                this.tTj.mParentView.setVisibility(8);
                if (this.tTj.tTi != null) {
                    this.tTj.tTi.bWG();
                }
            }
        });
        inflate.findViewById(R.h.cZx).setOnClickListener(new 3(this));
        inflate.findViewById(R.h.cZE).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g tTj;

            {
                this.tTj = r1;
            }

            public final void onClick(View view) {
                this.tTj.tTh.dismiss();
                this.tTj.mParentView.setVisibility(8);
                if (this.tTj.tTi != null) {
                    this.tTj.tTi.bWI();
                }
            }
        });
    }
}
