package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.bv.a;
import com.tencent.smtt.sdk.WebView;

public class c extends YANumberPicker implements e<String> {
    private String[] kdi;
    private int kdk;

    public final /* synthetic */ Object anJ() {
        return (this.kdi == null || this.kdi.length <= 0) ? "" : this.kdi[getValue()];
    }

    public c(Context context) {
        super(context);
        setDividerHeight(a.fromDPToPix(context, 2));
        int parseColor = Color.parseColor("#1AAD19");
        if (this.kdK != parseColor) {
            this.kdK = parseColor;
            this.keq.setColor(this.kdK);
            postInvalidate();
        }
        parseColor = a.fromDPToPix(context, 8);
        if (this.kdI != parseColor) {
            this.kdI = parseColor;
            postInvalidate();
        }
        parseColor = Color.parseColor("#A5A5A5");
        if (this.kdy != parseColor) {
            this.kdy = parseColor;
            postInvalidate();
        }
        if (this.kdz != WebView.NIGHT_MODE_COLOR) {
            this.kdz = WebView.NIGHT_MODE_COLOR;
            postInvalidate();
        }
    }

    public final void j(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            setEnabled(false);
            setVisibility(4);
            return;
        }
        setEnabled(true);
        setVisibility(0);
        this.kdi = strArr;
        int i = this.kdS;
        int length = strArr.length - 1;
        if ((length - i) + 1 > (this.kdT - i) + 1) {
            setDisplayedValues(strArr);
            setMaxValue(length);
            return;
        }
        setMaxValue(length);
        setDisplayedValues(strArr);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.kdk > 0) {
            i = MeasureSpec.makeMeasureSpec(this.kdk, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void anH() {
        anV();
    }

    public final void b(d dVar) {
    }

    public final void anI() {
    }
}
