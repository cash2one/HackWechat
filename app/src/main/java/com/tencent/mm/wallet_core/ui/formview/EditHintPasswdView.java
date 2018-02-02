package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView extends RelativeLayout implements OnFocusChangeListener {
    private static final int zJx = a$e.ucC;
    private OnFocusChangeListener imO;
    private int ssW;
    private int zJA;
    public int zJB;
    public a zJC;
    public TenpaySecureEditText zJy;
    private int zJz;

    public interface a {
        void hx(boolean z);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        super(context, attributeSet);
        this.zJy = null;
        this.zJz = 6;
        this.ssW = 1;
        this.zJA = zJx;
        this.zJB = 1;
        this.zJC = null;
        this.imO = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.uZD, i, 0);
        this.ssW = obtainStyledAttributes.getInteger(k.uZE, 1);
        this.zJA = obtainStyledAttributes.getResourceId(k.uZF, zJx);
        this.zJB = obtainStyledAttributes.getInteger(k.uZG, 1);
        obtainStyledAttributes.recycle();
        this.zJy = (TenpaySecureEditText) v.fv(context).inflate(g.uBZ, this, true).findViewById(f.uyz);
        b.a(this.zJy, this.ssW);
        switch (this.ssW) {
            case 1:
                i2 = 6;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 8:
                i2 = 4;
                break;
            default:
                x.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                i2 = 6;
                break;
        }
        this.zJz = i2;
        if (this.zJy != null) {
            this.zJy.setBackgroundResource(this.zJA);
            this.zJy.setImeOptions(6);
            this.zJy.setInputType(FileUtils.S_IWUSR);
            this.zJy.addTextChangedListener(new 1(this));
            this.zJy.setOnFocusChangeListener(this);
            super.setEnabled(true);
            super.setClickable(true);
            return;
        }
        x.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final String cCk() {
        if (this.zJy != null) {
            return ab.UZ(this.zJy.getText().toString());
        }
        x.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        return "";
    }

    private boolean XO() {
        if (this.zJy == null || this.zJy.getInputLength() != this.zJz) {
            return false;
        }
        return true;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.imO = onFocusChangeListener;
    }

    public final OnFocusChangeListener getOnFocusChangeListener() {
        return this.imO;
    }

    public final String getText() {
        if (this.zJy != null) {
            return com.tencent.mm.wallet_core.ui.formview.c.a.a(this.zJB, this.zJy);
        }
        x.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        return "";
    }

    public final void bmK() {
        if (this.zJy != null) {
            this.zJy.ClearInput();
        }
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(b.b(getContext(), 960.0f), i), getDefaultSize(b.b(getContext(), 720.0f), i2));
        int measuredWidth = getMeasuredWidth();
        int i3 = this.zJz == 0 ? measuredWidth / 6 : measuredWidth / this.zJz;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        setMeasuredDimension(getDefaultSize(measuredWidth, makeMeasureSpec), getDefaultSize(i3, makeMeasureSpec2));
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.imO != null) {
            this.imO.onFocusChange(this, z);
        }
        if (this.zJC != null) {
            this.zJC.hx(XO());
        }
    }
}
