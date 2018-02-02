package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.smtt.sdk.WebView;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class o$a extends u {
    int backgroundColor;
    int kDP;
    int kDQ;
    Context mContext;
    LayoutInflater mLayoutInflater;
    n rkg;
    private int rkh = 600;
    int rki = 700;
    int rkj = 250;
    HashMap<String, View> rkk = new HashMap();
    HashMap<String, a> rkl = new HashMap();

    static /* synthetic */ void a(o$a com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_o_a, ImageView imageView) {
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
        translateAnimation.setDuration((long) com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_o_a.rki);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.8f, 0.3f);
        translateAnimation.setDuration((long) com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_o_a.rki);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new 1(com_tencent_mm_plugin_sns_storage_AdLandingPagesStorage_AdLandingPageComponent_component_o_a, imageView));
        imageView.startAnimation(animationSet);
    }

    public o$a(Context context, LayoutInflater layoutInflater, n nVar, int i) {
        this.mContext = context;
        this.mLayoutInflater = layoutInflater;
        this.rkg = nVar;
        this.backgroundColor = i;
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        this.kDP = windowManager.getDefaultDisplay().getWidth();
        this.kDQ = windowManager.getDefaultDisplay().getHeight();
    }

    public final int getCount() {
        return this.rkg.rgv.size();
    }

    public final boolean a(View view, Object obj) {
        return view == ((View) obj);
    }

    public final void e(Object obj) {
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(g.qGV, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.qDO);
        linearLayout.setBackgroundColor(this.backgroundColor);
        a aVar = (a) this.rkl.get(String.valueOf(i));
        List list = ((m) this.rkg.rgv.get(i)).rgv;
        if (aVar == null || aVar.rkr.size() == 0) {
            this.rkl.put(String.valueOf(i), a(list, 0, list.size(), linearLayout));
        } else {
            aVar.rkr.addAll(a(list, aVar.rkr.size(), list.size(), linearLayout).rkr);
            Iterator it = aVar.rkr.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                    ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
                }
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                i iVar2 = (i) aVar.rkr.get(i2);
                linearLayout.addView(iVar2.getView());
                iVar2.a((s) list.get(i2));
            }
        }
        ImageView imageView = (ImageView) inflate.findViewById(f.qDQ);
        TextView textView = (TextView) inflate.findViewById(f.qDP);
        if (this.backgroundColor - WebView.NIGHT_MODE_COLOR <= -1 - this.backgroundColor) {
            imageView.setImageDrawable(a.b(this.mContext, e.qzv));
        } else {
            imageView.setImageDrawable(a.b(this.mContext, e.qzw));
        }
        if (this.rkg.rgx == 1) {
            imageView.setVisibility(8);
            textView.setVisibility(8);
        } else {
            if (i == this.rkg.rgv.size() - 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            textView.setText((i + 1) + "/" + this.rkg.rgv.size());
        }
        inflate.setLayoutParams(new LayoutParams(this.kDP, linearLayout.getMeasuredHeight()));
        inflate.setBackgroundColor(this.backgroundColor);
        viewGroup.addView(inflate);
        viewGroup.setBackgroundColor(this.backgroundColor);
        this.rkk.put(String.valueOf(i), inflate);
        return inflate;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int k(Object obj) {
        return -2;
    }

    public final void wX(int i) {
        View view = (View) this.rkk.get(String.valueOf(i));
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(f.qDQ);
            if (imageView != null && imageView.getVisibility() == 0) {
                if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                    imageView.setTag("1");
                    Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                    alphaAnimation.setDuration((long) this.rkh);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    alphaAnimation.setAnimationListener(new 2(this, imageView));
                    imageView.startAnimation(alphaAnimation);
                }
            }
        }
    }

    public final void wY(int i) {
        for (String str : this.rkl.keySet()) {
            a aVar = (a) this.rkl.get(str);
            if (!(aVar == null || aVar.rkr.size() == 0)) {
                int i2;
                i iVar;
                if (str.equals(String.valueOf(i))) {
                    for (i2 = 0; i2 < aVar.rkr.size(); i2++) {
                        iVar = (i) aVar.rkr.get(i2);
                        if (!iVar.rjl) {
                            iVar.bwH();
                        }
                    }
                } else {
                    for (i2 = 0; i2 < aVar.rkr.size(); i2++) {
                        iVar = (i) aVar.rkr.get(i2);
                        if (iVar.rjl) {
                            iVar.bwI();
                        }
                    }
                }
            }
        }
    }

    private a a(List<s> list, int i, int i2, ViewGroup viewGroup) {
        a aVar = new a(this);
        if (list == null) {
            return aVar;
        }
        int max = Math.max(0, i);
        int min = Math.min(list.size(), i2);
        for (int i3 = max; i3 < min; i3++) {
            i a = am.a(this.mContext, (s) list.get(i3), viewGroup, this.backgroundColor);
            aVar.rkr.add(a);
            viewGroup.addView(a.getView());
        }
        return aVar;
    }
}
