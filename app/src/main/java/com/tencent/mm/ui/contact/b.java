package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class b extends RelativeLayout {
    private TextView contentView = null;
    private Context context;
    private View lWv = null;
    private View oim = null;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] yQI = new int[a.values().length];

        static {
            try {
                yQI[a.yQJ.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yQI[a.yQK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yQI[a.yQL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public b(Context context, a aVar) {
        super(context);
        this.context = context;
        View.inflate(getContext(), R.i.dab, this);
        this.lWv = findViewById(R.h.bYF);
        this.oim = this.lWv.findViewById(R.h.bJs);
        LayoutParams layoutParams = this.oim.getLayoutParams();
        layoutParams.height = (int) (((float) a.ab(this.context, R.f.buA)) * a.ex(this.context));
        this.oim.setLayoutParams(layoutParams);
        this.contentView = (TextView) this.oim.findViewById(R.h.bJu);
        this.lWv.setOnClickListener(new 1(this, aVar));
        this.oim.setOnTouchListener(new 2(this));
        ImageView imageView = (ImageView) ((MaskLayout) this.oim.findViewById(R.h.bJt)).view;
        switch (AnonymousClass3.yQI[aVar.ordinal()]) {
            case 1:
                this.contentView.setText(R.l.dCN);
                d.a(getContext(), imageView, R.k.dyj);
                return;
            case 2:
                this.contentView.setText(R.l.dCQ);
                d.a(getContext(), imageView, R.k.dyk);
                return;
            case 3:
                this.oim.setBackgroundResource(R.g.bBx);
                this.contentView.setText(R.l.dCP);
                d.a(getContext(), imageView, R.k.dym);
                return;
            default:
                return;
        }
    }

    public final void setVisible(boolean z) {
        this.lWv.setVisibility(z ? 0 : 8);
    }
}
