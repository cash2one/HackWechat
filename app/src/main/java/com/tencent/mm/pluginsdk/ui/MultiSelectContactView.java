package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.a;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiSelectContactView extends LinearLayout {
    private LayoutInflater nny;
    private int padding;
    private View rno;
    public b vkA;
    public c vkB;
    private List<View> vkC;
    boolean vkD;
    private HorizontalScrollView vks;
    private LinearLayout vkt;
    private View vku;
    public MMEditText vkv;
    private List<String> vkw;
    private Animation vkx;
    private int vky;
    public a vkz;

    static /* synthetic */ void d(MultiSelectContactView multiSelectContactView) {
        if (multiSelectContactView.vkt.getChildCount() != 0) {
            View childAt = multiSelectContactView.vkt.getChildAt(multiSelectContactView.vkt.getChildCount() - 1);
            if (multiSelectContactView.vkD) {
                multiSelectContactView.a(childAt, true, false);
                multiSelectContactView.vkD = false;
            } else {
                multiSelectContactView.vkD = true;
                multiSelectContactView.cak();
                childAt.findViewById(e.mask).setVisibility(0);
            }
            multiSelectContactView.vkv.requestFocus();
        }
    }

    public MultiSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vky = 0;
        this.padding = 0;
        this.vkD = false;
        this.padding = getResources().getDimensionPixelSize(c.buo);
        this.nny = LayoutInflater.from(context);
        this.nny.inflate(f.qfw, this, true);
        this.vks = (HorizontalScrollView) findViewById(e.qfq);
        this.vkv = (MMEditText) findViewById(e.cyt);
        this.vkt = (LinearLayout) findViewById(e.qfp);
        this.vku = findViewById(e.qfr);
        this.vkw = new LinkedList();
        this.vkx = AnimationUtils.loadAnimation(context, a.bpZ);
        com.tencent.mm.ui.tools.a.c.d(this.vkv).GN(100).a(null);
        this.rno = findViewById(e.cIu);
        this.vkv.addTextChangedListener(new 1(this));
        this.vkv.setOnKeyListener(new 2(this));
        this.vkC = new ArrayList();
        this.vkv.clearFocus();
        this.vkv.setOnFocusChangeListener(new 3(this));
        setBackgroundColor(-201326593);
        setOnClickListener(new 4(this));
    }

    public void clearFocus() {
        this.vkv.clearFocus();
        caj();
    }

    public final void Sg(String str) {
        if (!bh.ov(str)) {
            if (this.vkw.contains(str)) {
                x.i("MicroMsg.MultiSeclectContactView", "fixed user cant change");
                return;
            }
            caj();
            View Si = Si(str);
            if (Si != null) {
                a(Si, false, false);
            } else {
                ba(str, true);
            }
        }
    }

    public final void Sh(String str) {
        View Si = Si(str);
        if (Si != null) {
            a(Si, false, false);
        }
    }

    private void caj() {
        if (this.vkt.getChildCount() != 0 && this.vkD) {
            View childAt = this.vkt.getChildAt(this.vkt.getChildCount() - 1);
            this.vkD = false;
            childAt.findViewById(e.mask).setVisibility(8);
        }
    }

    public final void ba(String str, boolean z) {
        BR(this.vkt.getChildCount() + 1);
        View inflate = this.nny.inflate(f.qfx, null, true);
        ImageView imageView = (ImageView) inflate.findViewById(e.bLC);
        b.a(imageView, str);
        imageView.setContentDescription(((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gu(str));
        inflate.setTag(str);
        inflate.setOnClickListener(new 5(this));
        if (z) {
            inflate.startAnimation(this.vkx);
        }
        this.vkt.addView(inflate);
        cal();
        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(c.buz);
        layoutParams.width = getResources().getDimensionPixelSize(c.buz);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(c.buo);
        inflate.setLayoutParams(layoutParams);
        cak();
    }

    private void a(View view, boolean z, boolean z2) {
        if (z && this.vkz != null) {
            this.vkz.oE(view.getTag().toString());
        }
        if (z2) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.bqa);
            loadAnimation.setAnimationListener(new 6(this, view));
            view.startAnimation(loadAnimation);
            return;
        }
        this.vkt.removeView(view);
        cal();
        BR(this.vkt.getChildCount());
    }

    private void cak() {
        this.vkt.post(new 7(this));
    }

    private void BR(int i) {
        if (this.vky <= 0) {
            this.vky += getResources().getDimensionPixelSize(c.bvw);
            int b = BackwardSupportUtil.b.b(getContext(), 40.0f);
            int measureText = (int) this.vkv.getPaint().measureText(getContext().getString(h.dGz));
            this.vky = Math.max(b, measureText) + this.vky;
        }
        if (this.vky > 0) {
            measureText = this.rno.getWidth();
            x.v("MicroMsg.MultiSeclectContactView", "parentWidth:%d, avatarWidth:%d, minInputAreaWidth:%d", new Object[]{Integer.valueOf(measureText), Integer.valueOf(i * (getResources().getDimensionPixelSize(c.buz) + getResources().getDimensionPixelSize(c.buo))), Integer.valueOf(this.vky)});
            LayoutParams layoutParams = (LayoutParams) this.vks.getLayoutParams();
            if (measureText - (i * (getResources().getDimensionPixelSize(c.buz) + getResources().getDimensionPixelSize(c.buo))) > this.vky) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = measureText - this.vky;
            }
        }
    }

    private void cal() {
        if (this.vkt.getChildCount() == 0) {
            this.vku.setVisibility(0);
        } else {
            this.vku.setVisibility(8);
        }
    }

    public final String bUS() {
        return this.vkv.getText().toString();
    }

    private View Si(String str) {
        int childCount = this.vkt.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.vkt.getChildAt(i);
            if (str.equals(childAt.getTag())) {
                return childAt;
            }
        }
        return null;
    }
}
