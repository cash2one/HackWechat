package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;

public class AsyncNormalTextView extends CollapsibleTextView {
    public String content;
    private Context context;
    public av qZU;
    private c rrb;
    public int rrc = 0;
    public ay rrd;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void c(c cVar) {
        this.rrb = cVar;
        byX();
    }

    public final void byX() {
        if (!bh.ov(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.rrc == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.rrc, new SpannableStringBuilder(i.b(this.context, this.content, this.rrW.getTextSize())), BufferType.NORMAL, this.qZU.rsb, this.rrd.rsD, this.rrd.rJJ, this.qZU, this.content, this.rrd.rrf);
            } else if (this.content.length() < 400 || this.rrd.rrf) {
                CharSequence charSequence = null;
                if (this.rrd != null) {
                    charSequence = this.rrd.rJH;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(i.b(this.context, this.content, this.rrW.getTextSize()));
                }
                if (this.rrd != null) {
                    a(this.rrc, charSequence, BufferType.SPANNABLE, this.qZU.rsb, this.rrd.rsD, this.rrd.rJJ, this.qZU, this.content, this.rrd.rrf);
                }
            } else {
                a(this.rrc, this.content, BufferType.NORMAL, this.qZU.rsb, this.rrd.rsD, this.rrd.rJJ, this.qZU, this.content, this.rrd.rrf);
            }
            as asVar = new as(this.rrd.rJJ, this.rrd.rsD, false, false, 1);
            this.rrW.setTag(asVar);
            if (this.rrX != null) {
                this.rrX.setTag(asVar);
            }
            this.rrY.setTag(this.rrb);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
    }

    public final void setContentWidth(int i) {
        if (this.rrX != null) {
            this.rrW.rRM = i;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -2);
            this.rrX.setLayoutParams(layoutParams);
            this.rrW.setLayoutParams(layoutParams);
            this.rrY.setLayoutParams(layoutParams);
        }
    }
}
