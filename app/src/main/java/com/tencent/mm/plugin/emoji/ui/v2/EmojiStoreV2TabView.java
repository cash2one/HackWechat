package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView extends RelativeLayout {
    private int lHW;
    private int lHX = 0;
    private Bitmap lHY;
    private LinearLayout lHZ;
    private ImageView lIa;
    private MMTabView lIb;
    private MMTabView lIc;
    a lId;
    protected OnClickListener lIe = new 1(this);
    private Matrix mMatrix = new Matrix();

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EmojiStoreV2TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.lHW = (i3 - i) / 2;
        int i5 = this.lHW;
        if (this.lHY == null || this.lHY.getWidth() != i5) {
            String str = "MicroMsg.emoji.EmojiStoreV2TabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.lHY == null ? -1 : this.lHY.getWidth());
            objArr[1] = Integer.valueOf(i5);
            x.w(str, str2, objArr);
            this.lHY = Bitmap.createBitmap(i5, a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.lHY).drawColor(getResources().getColor(R.e.bui));
            h(this.lHX, 0.0f);
            this.lIa.setImageBitmap(this.lHY);
        }
        oV(this.lHX);
    }

    private void init() {
        this.lHZ = new LinearLayout(getContext());
        this.lHZ.setBackgroundResource(R.e.white);
        this.lHZ.setId(R.h.cdT);
        this.lHZ.setOrientation(0);
        addView(this.lHZ, new LayoutParams(-1, -2));
        this.lIa = new ImageView(getContext());
        this.lIa.setImageMatrix(this.mMatrix);
        this.lIa.setScaleType(ScaleType.MATRIX);
        this.lIa.setId(R.h.cdU);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.h.cdT);
        addView(this.lIa, layoutParams);
        this.lIb = oU(0);
        this.lIb.setText(R.l.eaz);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byg));
        layoutParams.weight = 1.0f;
        this.lHZ.addView(this.lIb, layoutParams);
        this.lIc = oU(1);
        this.lIc.setText(R.l.eaD);
        layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.byg));
        layoutParams.weight = 1.0f;
        this.lHZ.addView(this.lIc, layoutParams);
    }

    private MMTabView oU(int i) {
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.lIe);
        return mMTabView;
    }

    public final void h(int i, float f) {
        this.mMatrix.setTranslate(((float) this.lHW) * (((float) i) + f), 0.0f);
        this.lIa.setImageMatrix(this.mMatrix);
    }

    public final void oV(int i) {
        this.lHX = i;
        this.lIb.setTextColor(this.lHX == 0 ? getResources().getColorStateList(R.e.bui) : getResources().getColorStateList(R.e.bsX));
        this.lIc.setTextColor(this.lHX == 1 ? getResources().getColorStateList(R.e.bui) : getResources().getColorStateList(R.e.bsX));
    }

    public final void eF(boolean z) {
        if (this.lIc != null) {
            this.lIc.lX(z);
        }
    }
}
