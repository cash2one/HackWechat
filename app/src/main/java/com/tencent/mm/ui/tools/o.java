package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements Runnable {
    public int mMode;
    public ListView pch;
    public long zmg = System.currentTimeMillis();
    public int zmh;
    public int zmi;
    public int zmj;
    private final int zmk;
    public int zml;

    public o(ListView listView) {
        this.pch = listView;
        this.zmk = ViewConfiguration.get(this.pch.getContext()).getScaledFadingEdgeLength();
        x.d("ScrollerRunnable", "mExtraScroll: %d", new Object[]{Integer.valueOf(this.zmk)});
    }

    public final void run() {
        if (System.currentTimeMillis() - this.zmg <= 10000) {
            int height = this.pch.getHeight();
            int firstVisiblePosition = this.pch.getFirstVisiblePosition();
            int childCount;
            switch (this.mMode) {
                case 1:
                    childCount = this.pch.getChildCount() - 1;
                    firstVisiblePosition += childCount;
                    if (childCount >= 0) {
                        if (firstVisiblePosition == this.zmi) {
                            if (this.zml > 20) {
                                this.pch.setSelection(this.zmh);
                                x.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                            } else {
                                this.pch.post(this);
                                this.zml++;
                                x.d("ScrollerRunnable", "dz:try scroll lastpos = %d", new Object[]{Integer.valueOf(firstVisiblePosition)});
                                return;
                            }
                        }
                        this.zml = 0;
                        View childAt = this.pch.getChildAt(childCount);
                        int height2 = childAt.getHeight();
                        childCount = height - childAt.getTop();
                        if (firstVisiblePosition < this.pch.getCount() - 1) {
                            height = this.zmk;
                        } else {
                            height = this.pch.getPaddingBottom();
                        }
                        this.pch.smoothScrollBy(height + (height2 - childCount), this.zmj);
                        this.zmi = firstVisiblePosition;
                        if (firstVisiblePosition < this.zmh) {
                            this.pch.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (firstVisiblePosition == this.zmi) {
                        if (this.zml > 20) {
                            this.pch.setSelection(this.zmh);
                            x.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                        } else {
                            this.pch.post(this);
                            this.zml++;
                            x.d("ScrollerRunnable", "dz:try scroll firstPos = %d", new Object[]{Integer.valueOf(firstVisiblePosition)});
                            return;
                        }
                    }
                    this.zml = 0;
                    View childAt2 = this.pch.getChildAt(0);
                    if (childAt2 != null) {
                        childCount = childAt2.getTop();
                        if (firstVisiblePosition > 0) {
                            height = this.zmk;
                        } else {
                            height = this.pch.getPaddingTop();
                        }
                        this.pch.smoothScrollBy(childCount - height, this.zmj);
                        this.zmi = firstVisiblePosition;
                        if (firstVisiblePosition > this.zmh) {
                            this.pch.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
