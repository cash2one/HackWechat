package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.x;

class b$7 implements Runnable {
    final /* synthetic */ b rnf;

    b$7(b bVar) {
        this.rnf = bVar;
    }

    public final void run() {
        if (b.a(this.rnf) != null) {
            if ((b.d(this.rnf).rnO || !TextUtils.isEmpty(b.d(this.rnf).rnN)) && !b.k(this.rnf)) {
                b.l(this.rnf);
                b.a(this.rnf).rns.setVisibility(0);
                b.a(this.rnf).rnp.setScaleType(ScaleType.CENTER_CROP);
                b.a(this.rnf).rns.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ b$7 rnn;

                    {
                        this.rnn = r1;
                    }

                    public final boolean onPreDraw() {
                        if (b.a(this.rnn.rnf).rns.getHeight() > 0) {
                            b.a(this.rnn.rnf).rns.getViewTreeObserver().removeOnPreDrawListener(this);
                            b.b(this.rnn.rnf, b.a(this.rnn.rnf).rns.getHeight());
                            if (b.m(this.rnn.rnf) < b.f(this.rnn.rnf)) {
                                b.b(this.rnn.rnf, b.f(this.rnn.rnf));
                            }
                            LayoutParams layoutParams = (LayoutParams) b.a(this.rnn.rnf).rnp.getLayoutParams();
                            layoutParams.height = b.m(this.rnn.rnf);
                            b.a(this.rnn.rnf).rnp.setLayoutParams(layoutParams);
                            x.v("ContentFragment", "set bgIV height " + b.a(this.rnn.rnf).rns.getHeight() + ", count " + b.a(this.rnn.rnf).rns.getChildCount());
                            for (int i = 0; i < b.a(this.rnn.rnf).rns.getChildCount(); i++) {
                                Object tag = b.a(this.rnn.rnf).rns.getChildAt(i).getTag();
                                if (tag instanceof i) {
                                    ((i) tag).bwG();
                                }
                            }
                            b.a(this.rnn.rnf).rns.removeAllViews();
                            b.a(this.rnn.rnf).rns.setVisibility(8);
                        }
                        return true;
                    }
                });
                a n = b.n(this.rnf);
                ViewGroup viewGroup = b.a(this.rnf).rns;
                for (int i = 0; i < n.rmN.rnP.size(); i++) {
                    i a = am.a(viewGroup.getContext(), (s) n.rmN.rnP.get(i), viewGroup, n.bgColor);
                    if (a != null) {
                        if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                            ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                        }
                        a.getView().setTag(a);
                        viewGroup.addView(a.getView());
                    }
                }
            }
        }
    }
}
