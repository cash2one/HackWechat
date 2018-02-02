package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.af;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    boolean fqP = false;
    private List<MaskImageView> list = new LinkedList();
    private af rqY = new af();
    private Runnable rqZ = new Runnable(this) {
        final /* synthetic */ MaskLinearLayout rur;

        {
            this.rur = r1;
        }

        public final void run() {
            this.rur.setPressed(false);
            MaskLinearLayout.a(this.rur);
            this.rur.invalidate();
        }
    };

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(e.qzP);
        } else {
            maskLinearLayout.setBackgroundResource(0);
        }
    }

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new 2(this));
    }

    public final void b(MaskImageView maskImageView) {
        this.list.add(maskImageView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
