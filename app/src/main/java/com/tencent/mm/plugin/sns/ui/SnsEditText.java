package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private Context context;
    private boolean nQW = false;
    private int rBA = 0;
    private int rBB = 10;
    private ClipboardManager rBx = null;
    int rBy = 0;
    private int rBz = 0;
    private float y;

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rBx = (ClipboardManager) this.context.getSystemService("clipboard");
        addTextChangedListener(new 1(this));
    }

    public final int bAS() {
        return this.rBy;
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.rBB)) {
                this.nQW = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.nQW = false;
        } else if (this.nQW) {
            this.nQW = false;
            return true;
        }
        this.y = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }
}
