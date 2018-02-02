package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EllipsizingTextView extends TextView {
    private int maxLines = -1;
    private final List<Object> nxQ = new ArrayList();
    private boolean nxR;
    private boolean nxS;
    private boolean nxT;
    private String nxU;
    private float nxV = 1.0f;
    private float nxW = 0.0f;

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.nxS = true;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setLineSpacing(float f, float f2) {
        this.nxW = f;
        this.nxV = f2;
        super.setLineSpacing(f, f2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.nxT) {
            this.nxU = charSequence.toString();
            this.nxS = true;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.nxS) {
            CharSequence charSequence;
            boolean z;
            Iterator it;
            super.setEllipsize(null);
            int maxLines = getMaxLines();
            String str = this.nxU;
            if (maxLines != -1) {
                Layout Co = Co(str);
                if (Co.getLineCount() > maxLines) {
                    str = this.nxU.substring(0, Co.getLineEnd(maxLines - 1)).trim();
                    if (!(str.getBytes().length != str.length())) {
                        while (Co(str + "...").getLineCount() > maxLines) {
                            int lastIndexOf = str.lastIndexOf(32);
                            if (lastIndexOf == -1) {
                                break;
                            }
                            str = str.substring(0, lastIndexOf);
                        }
                    } else if (str.length() >= 2) {
                        str = str.substring(0, (str.length() - 1) - 1);
                    }
                    charSequence = str + "...";
                    z = true;
                    if (!charSequence.equals(getText())) {
                        this.nxT = true;
                        try {
                            setText(charSequence);
                        } finally {
                            this.nxT = false;
                        }
                    }
                    this.nxS = false;
                    if (z != this.nxR) {
                        this.nxR = z;
                        it = this.nxQ.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            }
            Object obj = str;
            z = false;
            if (charSequence.equals(getText())) {
                this.nxT = true;
                setText(charSequence);
            }
            this.nxS = false;
            if (z != this.nxR) {
                this.nxR = z;
                it = this.nxQ.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        super.onDraw(canvas);
    }

    private Layout Co(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, this.nxV, this.nxW, false);
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}
