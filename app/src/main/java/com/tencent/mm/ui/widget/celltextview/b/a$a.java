package com.tencent.mm.ui.widget.celltextview.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.mm.ui.widget.celltextview.b.a.b;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.List;

public interface a$a extends b<b> {
    void Hb(int i);

    void Hc(int i);

    void Hd(int i);

    void He(int i);

    void a(com.tencent.mm.ui.widget.celltextview.c.b bVar);

    void a(ArrayList<d> arrayList, CharSequence charSequence);

    List<com.tencent.mm.ui.widget.celltextview.c.b> czj();

    String czk();

    int getMaxLines();

    int getMeasuredHeight();

    int getMeasuredWidth();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    Paint getPaint();

    String getText();

    float getTextSize();

    void onDraw(Canvas canvas);

    void onMeasure(int i, int i2);

    void requestLayout();

    void setBackgroundDrawable(Drawable drawable);

    void setMaxHeight(int i);

    void setMaxWidth(int i);

    void setMinHeight(int i);

    void setMinWidth(int i);

    void setPadding(int i, int i2, int i3, int i4);

    void setTextColor(int i);

    void setTextSize(float f);
}
