package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public final class c {
    private Context mContext;
    private int qPd = -1;
    private b qZo;
    private FrameLayout qZp;
    AbsoluteLayout qZq = null;
    protected Animation qZr;
    protected Animation qZs;
    boolean qZt = false;
    private com.tencent.mm.plugin.sns.f.b rqc;
    TextView rqd;
    ListView rqe;
    View rqf;

    static /* synthetic */ void a(c cVar, View view, View view2) {
        boolean z;
        com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
        view2.setVisibility(0);
        cVar.qZt = true;
        cVar.qZr.setAnimationListener(new AnimationListener(cVar) {
            final /* synthetic */ c rqg;

            {
                this.rqg = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.rqg.qZt = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.rqg.qZt = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(cVar.qZr);
        cVar.rqd = (TextView) view2.findViewById(f.qAt);
        cVar.rqd.setOnClickListener(cVar.qZo.rPA);
        cVar.rqd.setOnTouchListener(bh.cgx());
        cVar.rqd.setTag(bVar);
        if (bVar.qQI == null || bVar.qQI.rMm == null) {
            z = false;
        } else {
            a aVar = bVar.qQI.rMn;
            String eL = w.eL(ac.getContext());
            CharSequence charSequence = "zh_CN".equals(eL) ? aVar.reg : ("zh_TW".equals(eL) || "zh_HK".equals(eL)) ? aVar.rei : aVar.reh;
            if (!bh.ov(charSequence)) {
                cVar.rqd.setText(charSequence);
            }
            z = aVar.rej;
        }
        cVar.rqe = (ListView) view2.findViewById(f.qAp);
        cVar.rqe.setAdapter(new d(cVar.mContext, (com.tencent.mm.plugin.sns.data.b) view.getTag()));
        cVar.rqe.setOnItemClickListener(cVar.qZo.rPR);
        if (z) {
            cVar.rqd.setClickable(false);
            cVar.rqd.setTextColor(Color.parseColor("#3a3a3a"));
        } else {
            cVar.rqd.setClickable(true);
            cVar.rqd.setTextColor(Color.parseColor("#576B95"));
        }
        cVar.rqf = view2;
    }

    public c(Context context, b bVar, FrameLayout frameLayout, com.tencent.mm.plugin.sns.f.b bVar2) {
        this.mContext = context;
        this.rqc = bVar2;
        this.qZo = bVar;
        this.qZp = frameLayout;
        this.qZr = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qZr = AnimationUtils.loadAnimation(context, i.a.qyp);
        this.qZs = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.qZs = AnimationUtils.loadAnimation(context, i.a.qyq);
    }

    public final boolean cA(final View view) {
        if (ae.bvn().bwn() && this.rqc != null) {
            int cx = this.rqc.cx(view);
            if (cx == 0 || cx == 1) {
                return true;
            }
            x.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.qZt) {
            return false;
        }
        if (this.qZq != null) {
            if (this.qZq.getTag() instanceof a) {
                View view2 = ((a) this.qZq.getTag()).qOe;
                this.qZt = true;
                view2.startAnimation(this.qZs);
                this.qZs.setAnimationListener(new 3(this, view2));
            } else {
                bwm();
            }
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            String str = bVar.frH;
            this.qZq = new AbsoluteLayout(this.mContext);
            this.qZq.setId(f.daa);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.qZp.addView(this.qZq);
            int b = BackwardSupportUtil.b.b(this.mContext, 150.0f);
            int b2 = BackwardSupportUtil.b.b(this.mContext, 17.0f);
            BackwardSupportUtil.b.b(this.mContext, 40.0f);
            final View inflate = v.fv(this.mContext).inflate(g.qGq, null);
            TextView textView = (TextView) inflate.findViewById(f.qAs);
            String eL = w.eL(ac.getContext());
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qQI.rMm;
            if (bVar2 != null) {
                CharSequence charSequence;
                if ("zh_CN".equals(eL)) {
                    charSequence = bVar2.reM;
                } else if ("zh_TW".equals(eL) || "zh_HK".equals(eL)) {
                    charSequence = bVar2.reO;
                } else {
                    charSequence = bVar2.reN;
                }
                if (!bh.ov(charSequence)) {
                    textView.setText(charSequence);
                }
            }
            Rect rect = new Rect();
            int ea = e.ea(this.mContext);
            int[] bCj = bVar.qQI.bCj();
            x.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + bCj[0] + "  " + bCj[1] + " height: " + ea);
            this.qPd = e.eb(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, bCj[0] - b, ((bCj[1] - this.qPd) - ea) + b2);
            this.qZq.setTag(new a(this, str, inflate));
            this.qZq.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.qZt = true;
            new af().post(new Runnable(this) {
                final /* synthetic */ c rqg;

                public final void run() {
                    c.a(this.rqg, view, inflate);
                }
            });
            return true;
        }
    }

    public final boolean bwm() {
        if (this.rqc != null && ae.bvn().bwn()) {
            this.rqc.bwm();
        }
        if (this.qZq != null) {
            this.qZp.removeView(this.qZq);
            this.qZq = null;
            return true;
        }
        this.qZt = false;
        this.rqe = null;
        this.rqf = null;
        return false;
    }

    public final boolean byS() {
        final int height = this.rqd.getHeight();
        this.rqd.setVisibility(8);
        View view = null;
        int i = 0;
        for (int i2 = 0; i2 < this.rqe.getAdapter().getCount(); i2++) {
            view = this.rqe.getAdapter().getView(i2, view, null);
            view.measure(this.rqf.getWidth(), -2);
            i += view.getMeasuredHeight();
        }
        ((RelativeLayout.LayoutParams) this.rqe.getLayoutParams()).bottomMargin = height - i;
        this.rqe.setVisibility(0);
        Animation anonymousClass4 = new Animation(this) {
            final /* synthetic */ c rqg;

            protected final void applyTransformation(float f, Transformation transformation) {
                ((RelativeLayout.LayoutParams) this.rqg.rqe.getLayoutParams()).bottomMargin = f == 1.0f ? 0 : (int) (((float) (height - i)) * (1.0f - f));
                this.rqg.rqe.requestLayout();
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        anonymousClass4.setDuration(250);
        this.rqe.startAnimation(anonymousClass4);
        return true;
    }
}
