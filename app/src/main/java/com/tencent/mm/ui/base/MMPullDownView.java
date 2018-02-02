package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMPullDownView extends FrameLayout implements OnGestureListener {
    private static int ycN = 400;
    private static final int ycQ = Color.parseColor("#00000000");
    public int bgColor;
    public Context context;
    private GestureDetector lVX;
    public View xFj;
    private int xYJ;
    private Scroller yJ;
    private int yai;
    private boolean ycA;
    public c ycB;
    public d ycC;
    public View ycD;
    private int ycE;
    private int ycF;
    private int ycG;
    private boolean ycH;
    public f ycI;
    public boolean ycJ;
    private k ycK;
    public boolean ycL;
    public a ycM;
    private af ycO;
    boolean ycP;
    public boolean ycR;
    private int ycS;
    public int ycT;
    public b ycU;
    public g ycp;
    public e ycq;
    public int ycr;
    private int ycs;
    private boolean yct;
    private boolean ycu;
    private boolean ycv;
    private boolean ycw;
    public boolean ycx;
    private boolean ycy;
    private boolean ycz;

    public MMPullDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yai = 1;
        this.yct = false;
        this.ycu = false;
        this.ycv = false;
        this.ycw = false;
        this.ycx = true;
        this.ycy = false;
        this.ycz = true;
        this.ycA = true;
        this.ycF = 4;
        this.ycG = 4;
        this.ycH = false;
        this.ycJ = true;
        this.ycL = false;
        this.ycO = new af(this) {
            final /* synthetic */ MMPullDownView ycV;

            {
                this.ycV = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (this.ycV.ycE) {
                    case 0:
                        if (this.ycV.ycp != null) {
                            this.ycV.ycx = this.ycV.ycp.azn();
                        }
                        if (this.ycV.ycx && this.ycV.ycD.getVisibility() == 0) {
                            this.ycV.scrollTo(0, this.ycV.ycr);
                            break;
                        }
                    case 1:
                        if (this.ycV.ycq != null) {
                            this.ycV.ycx = this.ycV.ycq.azk();
                        }
                        if (this.ycV.ycx && this.ycV.xFj.getVisibility() == 0) {
                            this.ycV.scrollTo(0, this.ycV.ycr);
                            break;
                        }
                }
                x.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", Integer.valueOf(this.ycV.ycE), Boolean.valueOf(this.ycV.ycx));
            }
        };
        this.ycP = false;
        this.ycR = false;
        this.bgColor = Color.parseColor("#ffffffff");
        this.ycS = Integer.MIN_VALUE;
        this.ycT = this.bgColor;
        this.yJ = new Scroller(context, new AccelerateInterpolator());
        this.xYJ = this.yai;
        this.lVX = new GestureDetector(context, this);
        this.ycK = new k(context);
        this.context = context;
    }

    public void azz() {
        View inflate = inflate(this.context, h.ctD, null);
        View inflate2 = inflate(this.context, h.ctD, null);
        addView(inflate, 0, new LayoutParams(-1, -2));
        addView(inflate2, new LayoutParams(-1, -2));
    }

    public final void mm(boolean z) {
        x.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ycz), bh.cgy());
        this.ycz = z;
    }

    public final void mn(boolean z) {
        x.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ycA), bh.cgy());
        this.ycA = z;
    }

    public final void mo(boolean z) {
        this.ycF = z ? 0 : 4;
        if (this.xFj != null) {
            this.xFj.setVisibility(this.ycF);
        }
        x.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bh.cgy());
    }

    public final void mp(boolean z) {
        this.ycG = z ? 0 : 4;
        if (this.ycD != null) {
            this.ycD.setVisibility(this.ycG);
        }
        x.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bh.cgy());
    }

    public static void e(ViewGroup viewGroup, int i) {
        x.i("MicroMsg.MMPullDownView", "fix android O progress bar bug.");
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            if (viewGroup.getTag() == null) {
                viewGroup.setTag(viewGroup.findViewById(g.bUv));
            }
            View view = (View) viewGroup.getTag();
            if (view != null) {
                view.setVisibility(i);
            }
        }
    }

    private void cpt() {
        e((ViewGroup) this.ycD, 0);
        e((ViewGroup) this.xFj, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (!this.ycH) {
            azz();
            this.ycH = true;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                try {
                    childAt.layout(0, i5, childAt.getMeasuredWidth(), i5 + measuredHeight);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMPullDownView", e, "childCount: %d, i:%d, childHeight:%d", Integer.valueOf(childCount), Integer.valueOf(i6), Integer.valueOf(measuredHeight));
                }
                i5 += measuredHeight;
            }
        }
        this.ycD = getChildAt(0);
        this.xFj = getChildAt(getChildCount() - 1);
        this.ycD.setVisibility(this.ycG);
        this.xFj.setVisibility(this.ycF);
        this.ycr = this.ycD.getHeight();
        this.ycs = this.xFj.getHeight();
        this.ycS = this.ycr;
        if (!this.ycy && this.ycr != 0) {
            this.ycy = true;
            scrollTo(0, this.ycr);
        }
    }

    public void computeScroll() {
        if (this.yJ.computeScrollOffset()) {
            scrollTo(this.yJ.getCurrX(), this.yJ.getCurrY());
            postInvalidate();
        } else if (this.ycw) {
            x.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
            this.ycw = false;
            this.ycO.sendEmptyMessageDelayed(0, (long) ycN);
            cpt();
        }
        this.yJ.isFinished();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ycM != null) {
            this.ycM.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.ycr < 0) {
                    this.yct = true;
                }
                if (getScrollY() > this.ycs) {
                    this.ycu = true;
                }
                cpu();
                break;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        k kVar = this.ycK;
        if (kVar.zkY != null) {
            kVar.zkX.onTouchEvent(motionEvent);
        }
        if (!this.ycx) {
            return z;
        }
        if (this.ycC == null) {
            this.yct = false;
        } else {
            this.yct = this.ycC.azl();
        }
        if (this.ycB == null) {
            this.ycu = false;
        } else {
            this.ycu = this.ycB.azm();
        }
        if (this.ycG == 0) {
            if (this.ycz) {
                this.ycD.setVisibility(4);
            } else {
                this.ycD.setVisibility(0);
            }
        }
        if (this.ycF == 0) {
            if (this.ycA) {
                this.xFj.setVisibility(4);
            } else {
                this.xFj.setVisibility(0);
            }
        }
        if (motionEvent.getAction() == z) {
            cpu();
            return super.dispatchTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 3) {
            cpu();
            return this.ycL ? super.dispatchTouchEvent(motionEvent) : false;
        } else if (this.lVX.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
            this.ycP = z;
            return super.dispatchTouchEvent(motionEvent);
        } else {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMPullDownView", e, "", new Object[0]);
                return z;
            }
        }
    }

    public final void mq(boolean z) {
        x.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ycw), Boolean.valueOf(this.ycx), Boolean.valueOf(this.ycz), Integer.valueOf(getScrollY()), bh.cgy());
        if (z) {
            if (this.ycz) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ycr + (-getScrollY()), 200);
            } else {
                if (this.ycD != null && this.ycD.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ycr + (-getScrollY()), 200);
                }
                if (this.ycD != null && this.ycD.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.ycE = 0;
                this.ycw = true;
                this.ycx = false;
            }
            postInvalidate();
        } else if (!this.ycx) {
            this.ycx = true;
            this.ycw = false;
            if (this.ycD != null && this.ycD.getVisibility() == 0) {
                scrollTo(0, this.ycr);
            }
        }
        cpt();
    }

    public final void mr(boolean z) {
        x.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ycw), Boolean.valueOf(this.ycx), Boolean.valueOf(this.ycA), Integer.valueOf(getScrollY()), bh.cgy());
        if (z) {
            if (this.ycA) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ycs - getScrollY(), 200);
            } else {
                if (this.xFj != null && this.xFj.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ycs - getScrollY(), 200);
                }
                if (this.xFj != null && this.xFj.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ycs + (this.ycs - getScrollY()), 200);
                }
                this.ycE = 1;
                this.ycw = true;
                this.ycx = false;
            }
            postInvalidate();
            return;
        }
        if (!this.ycx) {
            this.ycx = true;
            this.ycw = false;
        }
        if (this.xFj != null && this.xFj.getVisibility() == 0) {
            x.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
            scrollTo(0, this.ycr);
        }
    }

    private void cpu() {
        if (this.ycI != null) {
            this.ycI.bBR();
        }
        if (getScrollY() - this.ycr < 0) {
            if (this.ycz) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ycr + (-getScrollY()), 200);
            } else {
                if (this.ycD.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ycr + (-getScrollY()), 200);
                }
                if (this.ycD.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.ycE = 0;
                this.ycw = true;
                this.ycx = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.ycs) {
            if (this.ycA) {
                this.yJ.startScroll(0, getScrollY(), 0, this.ycs - getScrollY(), 200);
            } else {
                if (this.xFj.getVisibility() == 4) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ycs - getScrollY(), 200);
                }
                if (this.xFj.getVisibility() == 0) {
                    this.yJ.startScroll(0, getScrollY(), 0, this.ycs + (this.ycs - getScrollY()), 200);
                }
                this.ycE = 1;
                this.ycw = true;
                this.ycx = false;
            }
            postInvalidate();
        }
        this.ycv = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.yJ.isFinished()) {
            this.yJ.abortAnimation();
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", Float.valueOf(f), Float.valueOf(f2));
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.ycI != null) {
            this.ycI.ax(f2);
        }
        if (f2 > 0.0f) {
            this.ycv = true;
        } else {
            this.ycv = false;
        }
        int i2;
        if (this.ycu && (this.ycv || getScrollY() - this.ycr > 0)) {
            if (!this.ycJ) {
                if (this.xFj.getVisibility() != 0) {
                    return true;
                }
                if (this.ycv && getScrollY() >= this.ycr * 2) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            x.v("check", "moveUp:" + i + " distanceY:" + f2 + " scrollY:" + getScrollY());
            if (getScrollY() + i < this.ycr && !this.ycv) {
                i = this.ycr - getScrollY();
            } else if (!this.ycJ && getScrollY() + i >= this.ycr * 2) {
                i = (this.ycr * 2) - getScrollY();
            }
            scrollBy(0, i);
            return true;
        } else if (!this.yct || (this.ycv && getScrollY() - this.ycr >= 0)) {
            return false;
        } else {
            if (!this.ycJ) {
                if (this.ycD.getVisibility() != 0) {
                    return true;
                }
                if (!this.ycv && getScrollY() <= 0) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            if (getScrollY() + i > this.ycr) {
                i = this.ycr - getScrollY();
            } else if (!this.ycJ && getScrollY() + i < 0) {
                i = -getScrollY();
            }
            scrollBy(0, i);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ycU != null) {
            this.ycU.aFi();
        }
        if (this.ycR) {
            if (this.ycS == Integer.MIN_VALUE) {
                this.ycS = this.ycr;
                x.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.ycS);
            }
            if (i2 <= this.ycS && this.ycT != ycQ) {
                setBackgroundResource(f.bDJ);
                this.ycT = ycQ;
                x.d("MicroMsg.MMPullDownView", "onScrollChanged full");
            } else if (i2 > this.ycS && this.ycT != this.bgColor) {
                x.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                setBackgroundColor(this.bgColor);
                this.ycT = this.bgColor;
            }
        }
    }
}
