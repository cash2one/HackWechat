package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import b.c.b.e;
import b.i;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a {
    private static final String TAG = TAG;
    public static final a pxO = new a((byte) 0);
    private final Context mContext;
    private int pxM = 3;
    final RadarSpecialGridView pxN;

    public abstract View A(View view, int i);

    public abstract int getCount();

    public a(RadarSpecialGridView radarSpecialGridView, Context context) {
        e.i(radarSpecialGridView, "mGridView");
        e.i(context, "mContext");
        this.pxN = radarSpecialGridView;
        this.mContext = context;
    }

    public final void blx() {
        if (this.pxM == 0) {
            x.e(TAG, "column is 0, pls check!");
            return;
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            TableRow tableRow;
            int i2 = i / this.pxM;
            int childCount = this.pxN.blM().getChildCount();
            if (childCount > i2) {
                View childAt = this.pxN.blM().getChildAt((childCount - 1) - i2);
                if (childAt == null) {
                    throw new i("null cannot be cast to non-null type android.widget.TableRow");
                }
                tableRow = (TableRow) childAt;
            } else {
                TableRow tableRow2 = new TableRow(this.mContext);
                tableRow2.setLayoutParams(new LayoutParams(-1, -2));
                this.pxN.blM().addView(tableRow2, 0);
                tableRow = tableRow2;
            }
            int i3 = i % this.pxM;
            int childCount2 = tableRow.getChildCount();
            int i4 = childCount2 <= i3 ? 1 : 0;
            View view = null;
            i3 = (childCount2 - 1) - i3;
            if (i4 == 0) {
                view = tableRow.getChildAt(i3);
            }
            View A = A(view, i);
            if (i4 != 0) {
                tableRow.addView(A, 0);
            } else if (A != view) {
                tableRow.removeViewAt(i3);
                tableRow.addView(A, i3);
            }
            A.setOnClickListener(new b(this, i));
        }
        x.v(TAG, "mTable rows count : " + this.pxN.blM().getChildCount());
    }
}
