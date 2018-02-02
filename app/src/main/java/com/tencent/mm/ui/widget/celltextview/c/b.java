package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.RectF;
import android.text.style.ClickableSpan;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public int Ww;
    public int jjf;
    public int wq;
    public ClickableSpan zxg;
    public LinkedList<RectF> zxh;

    public final boolean fo(int i, int i2) {
        Iterator it = this.zxh.iterator();
        while (it.hasNext()) {
            if (((RectF) it.next()).contains((float) i, (float) i2)) {
                return true;
            }
        }
        return false;
    }
}
