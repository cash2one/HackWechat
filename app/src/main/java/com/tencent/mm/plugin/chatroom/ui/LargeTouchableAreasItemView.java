package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int laV = Color.argb(0, 0, 0, 0);
    private final Paint fC = new Paint();
    private boolean gNI;
    private final ArrayList<b> laW = new ArrayList();
    private c laX;
    a laY;
    private int laZ;
    private int lba = -1;
    private int lbb = -1;
    private ImageButton lbc;

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.laX = new c(this);
        this.fC.setStyle(Style.FILL);
        this.laZ = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.i.des, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lbc = (ImageButton) findViewById(R.h.bPg);
        this.lbc.setOnClickListener(new 1(this));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != this.lba || i6 != this.lbb) {
            this.lba = i5;
            this.lbb = i6;
            c cVar = this.laX;
            if (cVar.leS != null) {
                cVar.leS.clear();
            }
            cVar.leT = null;
            Rect rect = new Rect((i5 - this.lbc.getWidth()) - this.laZ, 0, i5, i6);
            i5 = laV;
            View view = this.lbc;
            c cVar2 = this.laX;
            TouchDelegate touchDelegate = new TouchDelegate(rect, view);
            if (cVar2.leS == null) {
                cVar2.leS = new ArrayList();
            }
            cVar2.leS.add(touchDelegate);
            this.laW.add(new b(rect, i5));
            setTouchDelegate(this.laX);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Iterator it = this.laW.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.fC.setColor(bVar.color);
            canvas.drawRect(bVar.rect, this.fC);
        }
        super.dispatchDraw(canvas);
    }

    public final void ej(boolean z) {
        if (this.gNI != z) {
            this.gNI = z;
            this.lbc.setImageResource(this.gNI ? R.k.dxO : R.k.dxP);
        }
    }
}
