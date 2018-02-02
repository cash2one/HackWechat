package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.aq.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g;

class g$a extends a {
    public static final int yKd = (((int) com.tencent.mm.bv.a.getDensity(MMApplicationLike.applicationLike.getApplication())) * 64);
    public TextView iiq;
    public TextView iir;
    public MMImageView yIL;
    public int yJw = 0;
    public TextView yKa;
    public View yKb;
    public boolean yKc;

    g$a() {
    }

    public final g$a r(View view, boolean z) {
        super.ds(view);
        this.yKc = z;
        this.ldK = (TextView) this.mUL.findViewById(R.h.bVf);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = this.mUL.findViewById(R.h.bUC);
        this.qhg = (TextView) this.mUL.findViewById(R.h.bVk);
        this.yIL = (MMImageView) this.mUL.findViewById(R.h.bLc);
        this.iiq = (TextView) this.mUL.findViewById(R.h.bLd);
        this.iir = (TextView) this.mUL.findViewById(R.h.bLb);
        this.yKa = (TextView) this.mUL.findViewById(R.h.bKZ);
        this.yKb = this.mUL.findViewById(R.h.bLa);
        this.yJw = b.fP(ac.getContext());
        return this;
    }

    public final void a(final Context context, g.a aVar, String str, boolean z) {
        O(this.yIy, this.yJw);
        com.tencent.mm.aq.a.a PA;
        String B;
        ImageView imageView;
        c.a aVar2;
        switch (aVar.type) {
            case 16:
                this.iiq.setText(aVar.description);
                this.iir.setText(aVar.hck);
                this.yIL.setVisibility(0);
                if (z) {
                    PA = o.PA();
                    B = o.Pw().B(str, true);
                    imageView = this.yIL;
                    aVar2 = new c.a();
                    aVar2.hDF = 1;
                    aVar2 = aVar2.bc(yKd, yKd);
                    aVar2.hDP = R.k.dvD;
                    aVar2.hDY = true;
                    PA.a(B, imageView, aVar2.PK());
                    return;
                }
                this.yIL.setImageResource(R.g.bEh);
                return;
            case 34:
                if (aVar.title == null || aVar.title.length() <= 0) {
                    this.iiq.setVisibility(8);
                } else {
                    this.iiq.setVisibility(0);
                    this.iiq.setText(aVar.title);
                    if (bh.ov(aVar.hct)) {
                        this.iiq.setTextColor(context.getResources().getColor(R.e.black));
                    } else {
                        this.iiq.setTextColor(bh.ba(aVar.hct, context.getResources().getColor(R.e.black)));
                    }
                }
                this.iir.setMaxLines(2);
                this.iir.setVisibility(0);
                this.iir.setText(aVar.description);
                if (bh.ov(aVar.hcu)) {
                    this.iir.setTextColor(context.getResources().getColor(R.e.bsF));
                } else {
                    this.iir.setTextColor(bh.ba(aVar.hcu, context.getResources().getColor(R.e.bsF)));
                }
                if (bh.ov(aVar.hcp)) {
                    this.yKa.setText(R.l.dRv);
                } else {
                    this.yKa.setText(aVar.hcp);
                }
                if (z) {
                    Bitmap a = o.Pw().a(str, com.tencent.mm.bv.a.getDensity(context), false);
                    if (!(a == null || a.isRecycled())) {
                        this.yIL.setImageBitmap(d.a(a, false, (float) (a.getWidth() / 2)));
                    }
                    if (bh.ov(aVar.hcs)) {
                        this.yKb.getViewTreeObserver().addOnPreDrawListener(new 2(this, context, a));
                        return;
                    }
                    PA = o.PA();
                    B = aVar.hcs;
                    imageView = new ImageView(context);
                    aVar2 = new c.a();
                    aVar2.hDA = true;
                    PA.a(B, imageView, aVar2.PK(), new com.tencent.mm.aq.a.c.g(this) {
                        final /* synthetic */ g$a yKe;

                        public final void lC(String str) {
                        }

                        public final Bitmap a(String str, b bVar) {
                            return null;
                        }

                        public final void a(String str, View view, b bVar) {
                            if (bVar.bitmap != null) {
                                this.yKe.yKb.getViewTreeObserver().addOnPreDrawListener(new 1(this, bVar.bitmap));
                            }
                        }
                    });
                    return;
                }
                this.yIL.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.g.bEh));
                return;
            default:
                this.iiq.setText(aVar.description);
                this.iir.setText(aVar.hck);
                this.yIL.setVisibility(0);
                if (z) {
                    PA = o.PA();
                    B = o.Pw().B(str, true);
                    imageView = this.yIL;
                    aVar2 = new c.a();
                    aVar2.hDF = 1;
                    aVar2 = aVar2.bc(yKd, yKd);
                    aVar2.hDP = R.k.dvD;
                    aVar2.hDY = true;
                    PA.a(B, imageView, aVar2.PK());
                    return;
                }
                this.yIL.setImageResource(R.g.bEh);
                return;
        }
    }
}
