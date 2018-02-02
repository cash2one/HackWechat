package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.e;

public class AutoHintSizeEditText extends EditText {
    private float yhN;
    private Paint yhO;
    private String yhP = "";
    private int yhQ = Integer.MIN_VALUE;
    private float yhR;

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.yhN = getTextSize();
        this.yhR = this.yhN;
        this.yhO = new Paint(getPaint());
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AutoHintSizeEditText yhS;

            {
                this.yhS = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.yhS.a(editable, this.yhS.getHint(), (this.yhS.getWidth() - this.yhS.getPaddingLeft()) - this.yhS.getPaddingRight());
            }
        });
    }

    private void a(Editable editable, CharSequence charSequence, int i) {
        if (editable == null || bh.ov(editable.toString())) {
            if (charSequence != null && !bh.ov(charSequence.toString())) {
                String charSequence2 = charSequence.toString();
                if (!this.yhP.equals(charSequence2) || this.yhQ != i) {
                    this.yhP = charSequence2;
                    this.yhQ = i;
                    if (getPaint().measureText(charSequence2) > ((float) i)) {
                        int dimensionPixelSize = getResources().getDimensionPixelSize(e.bvW);
                        int fromDPToPix = a.fromDPToPix(getContext(), 1);
                        for (int i2 = ((int) this.yhN) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                            this.yhO.setTextSize((float) i2);
                            if (this.yhO.measureText(charSequence2) < ((float) i)) {
                                x.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[]{Integer.valueOf(i2)});
                                this.yhR = (float) i2;
                                setTextSize(0, (float) i2);
                                return;
                            }
                        }
                    }
                } else if (getTextSize() != this.yhR) {
                    x.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[]{Float.valueOf(this.yhR)});
                    setTextSize(0, this.yhR);
                }
            } else if (getTextSize() != this.yhN) {
                x.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[]{Float.valueOf(this.yhN)});
                setTextSize(0, this.yhN);
            }
        } else if (getTextSize() != this.yhN) {
            x.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[]{Float.valueOf(this.yhN)});
            setTextSize(0, this.yhN);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[]{Boolean.valueOf(z)});
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
    }
}
