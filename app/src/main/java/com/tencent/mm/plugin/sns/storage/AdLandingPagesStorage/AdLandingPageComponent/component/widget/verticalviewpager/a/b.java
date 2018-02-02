package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class b extends Fragment {
    private static int rmR;
    private int bgColor;
    private boolean hHG;
    private boolean iid;
    private int kDP;
    private int kDQ;
    private LinearLayoutManager riF;
    private final Map<String, Bitmap> rjX = new WeakHashMap();
    private int rkh = 1000;
    private int rki = 700;
    private c rmN;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b rmS;
    private z rmT;
    private boolean rmU;
    private boolean rmV;
    public boolean rmW;
    private int rmX;
    public int rmY;
    private ag rmZ;
    private a rna;
    private b rnb;
    private a rnc;
    private boolean rnd;
    private int rne;

    static /* synthetic */ void a(b bVar, b bVar2) {
        if (!bVar2.rnr) {
            return;
        }
        if (bVar2.rnq.getVisibility() != 0) {
            x.d("ContentFragment", "nextBtn not visible");
            return;
        }
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -10.0f);
        translateAnimation.setDuration((long) bVar.rki);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.8f, 0.3f);
        translateAnimation.setDuration((long) bVar.rki);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new 6(bVar, bVar2));
        bVar2.rnq.startAnimation(animationSet);
    }

    static /* synthetic */ void a(b bVar, String str, ImageView imageView) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (Float.compare(bVar.rmT.width, 0.0f) > 0) {
            layoutParams.width = (int) bVar.rmT.width;
        } else {
            layoutParams.width = -1;
        }
        if (Float.compare(bVar.rmT.height, 0.0f) > 0) {
            layoutParams.height = (int) bVar.rmT.height;
        } else {
            layoutParams.height = -2;
        }
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = (int) bVar.rmT.rgN;
        }
        imageView.setImageBitmap(decodeFile);
    }

    static /* synthetic */ void a(b bVar, String str, String str2, String str3) {
        if (bVar.rmZ == null) {
            bVar.rmZ = new ag();
        }
        bVar.rmZ.F(new 3(bVar, str, str2, str3));
    }

    public static Fragment a(c cVar, DummyViewPager dummyViewPager, z zVar, boolean z, a aVar, boolean z2, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pageInfo", cVar);
        bundle.putSerializable("viewpager", dummyViewPager);
        bundle.putSerializable("lifecycle", aVar);
        bundle.putSerializable("pageDownIconInfo", zVar);
        bundle.putBoolean("isLastPage", z);
        bundle.putBoolean("needEnterAnimation", z2);
        bundle.putBoolean("needDirectionAnimation", z3);
        Fragment bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rmR = a.fromDPToPix(getContext(), 60);
        int[] dv = ac.dv(getContext());
        this.kDP = dv[0];
        this.kDQ = dv[1];
        if (this.rmN == null) {
            this.rmN = (c) getArguments().getSerializable("pageInfo");
        }
        this.rna = (a) getArguments().getSerializable("lifecycle");
        this.rmT = (z) getArguments().getSerializable("pageDownIconInfo");
        this.iid = getArguments().getBoolean("isLastPage");
        this.rmU = getArguments().getBoolean("needEnterAnimation");
        this.rmV = getArguments().getBoolean("needDirectionAnimation");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.qGp, viewGroup, false);
        this.rnb = new b((byte) 0);
        this.rnb.rno = inflate;
        this.rnb.rnp = (ImageView) inflate.findViewById(f.qDD);
        this.rnb.iVC = (LinearLayout) inflate.findViewById(f.qDY);
        this.rnb.rnq = (ImageView) inflate.findViewById(f.qEY);
        this.rnb.jNw = (RecyclerView) inflate.findViewById(f.bYP);
        this.rnb.rns = (LinearLayout) inflate.findViewById(f.qCe);
        RecyclerView recyclerView = this.rnb.jNw;
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a((DummyViewPager) getArguments().getSerializable("viewpager")));
        getActivity();
        this.riF = new LinearLayoutManager();
        recyclerView.a(this.riF);
        this.rnc = new a(this.rmN, this.bgColor, getActivity(), this.riF);
        recyclerView.a(this.rnc);
        this.rmS = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b(recyclerView, this);
        recyclerView.a(new 1(this));
        inflate.setTag(this.rnb);
        aJC();
        if (this.rna != null) {
            this.rna.o(this);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        x.i("ContentFragment", this + " onResume " + getUserVisibleHint());
        this.hHG = true;
        if (this.rmS != null && getUserVisibleHint()) {
            this.rmS.bwX();
        }
    }

    public final void onPause() {
        super.onPause();
        new StringBuilder().append(this).append(" onPause ").append(getUserVisibleHint());
        this.hHG = false;
        if (this.rmS != null && getUserVisibleHint()) {
            this.rmS.bxz();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.rmS != null) {
            this.rmS.rmw.onDestroy();
        }
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (this.rmS != null) {
                this.rmS.bwX();
            }
        } else if (this.rmS != null) {
            this.rmS.bxz();
        }
    }

    public final void bxD() {
        if (this.rmS != null) {
            this.rmS.bxy();
        }
    }

    public final void a(c cVar) {
        if (this.rmN != cVar) {
            this.rmN = cVar;
            aJC();
        }
    }

    private void aJC() {
        if (this.rnb != null) {
            bxE();
            if (this.rmN.rnN == null || this.rmN.rnN.length() <= 0) {
                bxE();
            } else {
                String str = this.rmN.rnN;
                x.i("ContentFragment", "bg need blur %b, url %s", new Object[]{Boolean.valueOf(this.rmN.rnO), str});
                if (this.rjX.containsKey(str)) {
                    x.i("ContentFragment", "bg has cache bitmap");
                    J((Bitmap) this.rjX.get(str));
                } else {
                    d.a("adId", str, false, 1000000001, 0, new 2(this, str));
                }
            }
            if (this.rnc != null) {
                if (this.rmN.rnN == null || this.rmN.rnN.length() <= 0) {
                    this.rnc.bgColor = this.bgColor;
                } else {
                    this.rnc.bgColor = 0;
                }
                RecyclerView$a recyclerView$a = this.rnc;
                c cVar = this.rmN;
                if (recyclerView$a.rmN != cVar) {
                    recyclerView$a.rmN = cVar;
                    recyclerView$a.UR.notifyChanged();
                }
            }
        }
    }

    private void bxE() {
        if (this.rmN.iMN != null && this.rmN.iMN.length() > 0) {
            x.i("ContentFragment", "setting bg color %s", new Object[]{this.rmN.iMN});
            try {
                this.bgColor = Color.parseColor(this.rmN.iMN);
            } catch (Exception e) {
                x.e("ContentFragment", "the color is error : " + this.rmN.iMN);
            }
            this.rnb.rno.setBackgroundColor(this.bgColor);
            this.rnb.rnp.setBackgroundColor(this.bgColor);
            this.rnb.iVC.setBackgroundColor(this.bgColor);
            bxF();
        }
    }

    private void J(Bitmap bitmap) {
        if (bitmap != null) {
            this.rnb.rno.setBackgroundColor(0);
            this.rnb.rnp.setBackgroundColor(0);
            this.rnb.iVC.setBackgroundColor(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rnb.rnp.getLayoutParams();
            layoutParams.height = layoutParams.height >= this.kDQ ? layoutParams.height : this.kDQ;
            this.rnb.rnp.setLayoutParams(layoutParams);
            this.rnb.rnp.setImageBitmap(bitmap);
        } else {
            bxE();
        }
        bxF();
    }

    private void bxF() {
        if (this.bgColor == 0 && this.rmN.iMN != null && this.rmN.iMN.length() > 0) {
            x.i("ContentFragment", "setDirectionColor bg color %s", new Object[]{this.rmN.iMN});
            try {
                this.bgColor = Color.parseColor(this.rmN.iMN);
            } catch (Exception e) {
                x.e("ContentFragment", "the color is error : " + this.rmN.iMN);
            }
        }
        if (this.bgColor - WebView.NIGHT_MODE_COLOR <= -1 - this.bgColor) {
            this.rnb.rnq.setImageDrawable(a.b(getActivity(), e.qzu));
        } else {
            this.rnb.rnq.setImageDrawable(a.b(getActivity(), e.qzt));
        }
    }

    public final RecyclerView bxG() {
        if (this.rnb != null) {
            return this.rnb.jNw;
        }
        return null;
    }

    public final Collection<i> bxH() {
        if (this.rnc == null) {
            return Collections.EMPTY_LIST;
        }
        a aVar = this.rnc;
        return aVar.rmO == null ? Collections.EMPTY_LIST : aVar.rmO.values();
    }

    public final void bxI() {
        if (this.rnb.rnq.getVisibility() == 0) {
            this.rnb.rnq.clearAnimation();
            this.rnb.rnq.setVisibility(4);
        }
    }

    public final void bxJ() {
        if (bxK()) {
            this.rnb.rnq.clearAnimation();
            this.rnb.rnq.setVisibility(0);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration((long) this.rkh);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setStartOffset((long) this.rkh);
            alphaAnimation.setAnimationListener(new 4(this));
            if (this.rmT == null || this.rmT.equals(this.rnb.rnq.getTag())) {
                this.rnb.rnq.startAnimation(alphaAnimation);
                return;
            }
            this.rnb.rnq.setTag(this.rmT);
            this.rnb.rnq.setVisibility(8);
            d.a(this.rmT.iconUrl, 1000000001, new 5(this, alphaAnimation));
        }
    }

    public final boolean bxK() {
        if (!this.rmV || this.rmX != 0 || this.rmY != 0) {
            return false;
        }
        int eZ = this.riF.eZ();
        int fa = this.riF.fa();
        if (eZ == fa && eZ == -1) {
            return false;
        }
        boolean z;
        for (int i = fa; i >= eZ; i--) {
            a aVar = this.rnc;
            i iVar = (i) aVar.rmO.get(((s) aVar.rmN.rnP.get(i)).rgK);
            if (iVar instanceof y) {
                fa = ((y) iVar).bxw();
                if (fa >= 0 && fa < rmR) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && this.iid) {
            z = this.riF.fa() != this.rnc.getItemCount() + -1;
        }
        return z;
    }
}
