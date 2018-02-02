package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.neattextview.textview.view.NeatTextView.c;
import java.util.Iterator;
import java.util.LinkedList;

public class b implements OnDoubleTapListener, OnGestureListener, c {
    private GestureDetector jtw;
    public View mView;
    private com.tencent.neattextview.textview.layout.b zKZ;
    private a zLE;
    public com.tencent.neattextview.textview.b.c zLF;

    public b(Context context, a aVar) {
        this.zLE = aVar;
        this.jtw = new GestureDetector(context, this);
        this.jtw.setOnDoubleTapListener(this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zLE.cCz() == null) {
            return false;
        }
        this.zKZ = this.zLE.cCz();
        this.mView = view;
        boolean onTouchEvent = this.jtw.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            return onTouchEvent;
        }
        cancel(2);
        return onTouchEvent;
    }

    public boolean onDown(MotionEvent motionEvent) {
        com.tencent.neattextview.textview.layout.b bVar = this.zKZ;
        if (bVar.zKN == null) {
            bVar.zKN = new LinkedList();
            Iterator it = bVar.zKB.iterator();
            while (it.hasNext()) {
                com.tencent.neattextview.textview.b.b bVar2 = (com.tencent.neattextview.textview.b.b) it.next();
                if (bVar2.getClass() == com.tencent.neattextview.textview.b.c.class) {
                    bVar.zKN.add((com.tencent.neattextview.textview.b.c) bVar2);
                }
            }
        }
        for (com.tencent.neattextview.textview.b.c cVar : bVar.zKN) {
            if (cVar.L(motionEvent.getX() - this.zLE.cCB(), motionEvent.getY() - this.zLE.cyL())) {
                this.zLF = cVar;
                cVar.ozA = true;
                this.mView.postInvalidate();
                return true;
            }
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.zLF != null) {
            com.tencent.neattextview.textview.b.b bVar = this.zLF;
            View view = this.mView;
            if (bVar.zKr != null) {
                ((ClickableSpan) bVar.zKr).onClick(view);
            }
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        cancel(1);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        cancel(2);
        return false;
    }

    public void cancel(int i) {
        if (this.zLF != null) {
            this.zLF.ozA = false;
            this.mView.invalidate();
            this.zLF = null;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.zLE.cCA() == null) {
            return false;
        }
        this.zLE.cCA().dF(this.mView);
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
