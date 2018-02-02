package com.tencent.mm.ui.widget;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public final class b extends k implements OnGestureListener, OnTouchListener {
    private int iN;
    private int jtM;
    private int jtN;
    private int lEv;
    private GestureDetector xj;
    private int zqQ = 0;
    boolean zqR = true;
    boolean zqS = false;
    private boolean zqT = false;
    private GestureDetector zqU;
    private int zqV = -1;
    private int zqW = -1;
    private int zqX = -1;
    private int[] zqY = new int[2];
    private int zqZ;
    private int zra;
    private boolean zrb = false;
    private float zrc = 500.0f;
    private int zrd;
    private int zre;
    private int zrf;
    private boolean zrg;
    private DragSortListView zrh;
    private int zri;
    private OnGestureListener zrj = new 1(this);

    public b(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.zrh = dragSortListView;
        this.xj = new GestureDetector(dragSortListView.getContext(), this);
        this.zqU = new GestureDetector(dragSortListView.getContext(), this.zrj);
        this.zqU.setIsLongpressEnabled(false);
        this.iN = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.zrd = i;
        this.zre = i4;
        this.zrf = i5;
        this.lEv = i3;
        this.zqQ = i2;
    }

    private boolean ak(int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z = false;
        if (!this.zqR || this.zqT) {
            i4 = 0;
        } else {
            i4 = 12;
        }
        if (this.zqS && this.zqT) {
            i5 = (i4 | 1) | 2;
        } else {
            i5 = i4;
        }
        DragSortListView dragSortListView = this.zrh;
        int headerViewsCount = i - this.zrh.getHeaderViewsCount();
        if (dragSortListView.zrX && dragSortListView.zrY != null) {
            View GV = dragSortListView.zrY.GV(headerViewsCount);
            if (GV != null) {
                z = dragSortListView.a(headerViewsCount, GV, i5, i2, i3);
            }
        }
        this.zrb = z;
        return this.zrb;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zrh.zrD && !this.zrh.zso) {
            this.xj.onTouchEvent(motionEvent);
            if (this.zqS && this.zrb && this.lEv == 1) {
                this.zqU.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.jtM = (int) motionEvent.getX();
                    this.jtN = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.zqS && this.zqT) {
                        int i;
                        if (this.zri >= 0) {
                            i = this.zri;
                        } else {
                            i = -this.zri;
                        }
                        if (i > this.zrh.getWidth() / 2) {
                            this.zrh.aF(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            this.zqT = false;
            this.zrb = false;
        }
        return false;
    }

    public final void g(Point point) {
        if (this.zqS && this.zqT) {
            this.zri = point.x;
        }
    }

    private int k(MotionEvent motionEvent, int i) {
        int pointToPosition = this.zrh.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.zrh.getHeaderViewsCount();
        int footerViewsCount = this.zrh.getFooterViewsCount();
        int count = this.zrh.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.zrh.getChildAt(pointToPosition - this.zrh.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.zqY);
                if (count > this.zqY[0] && rawY > this.zqY[1] && count < this.zqY[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.zqY[1]) {
                        this.zqZ = childAt.getLeft();
                        this.zra = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i = -1;
        if (this.zqS && this.lEv == 0) {
            this.zqX = k(motionEvent, this.zre);
        }
        this.zqV = k(motionEvent, this.zrd);
        if (this.zqV != -1 && this.zqQ == 0) {
            ak(this.zqV, ((int) motionEvent.getX()) - this.zqZ, ((int) motionEvent.getY()) - this.zra);
        }
        this.zqT = false;
        this.zrg = true;
        this.zri = 0;
        if (this.lEv == 1) {
            i = k(motionEvent, this.zrf);
        }
        this.zqW = i;
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.zqZ;
        int i2 = y2 - this.zra;
        if (!(!this.zrg || this.zrb || (this.zqV == -1 && this.zqW == -1))) {
            if (this.zqV != -1) {
                if (this.zqQ == 1 && Math.abs(y2 - y) > this.iN && this.zqR) {
                    ak(this.zqV, i, i2);
                } else if (this.zqQ != 0 && Math.abs(x2 - x) > this.iN && this.zqS) {
                    this.zqT = true;
                    ak(this.zqW, i, i2);
                }
            } else if (this.zqW != -1) {
                if (Math.abs(x2 - x) > this.iN && this.zqS) {
                    this.zqT = true;
                    ak(this.zqW, i, i2);
                } else if (Math.abs(y2 - y) > this.iN) {
                    this.zrg = false;
                }
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.zqV != -1 && this.zqQ == 2) {
            this.zrh.performHapticFeedback(0);
            ak(this.zqV, this.jtM - this.zqZ, this.jtN - this.zra);
        }
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.zqS && this.lEv == 0 && this.zqX != -1) {
            DragSortListView dragSortListView = this.zrh;
            int headerViewsCount = this.zqX - this.zrh.getHeaderViewsCount();
            dragSortListView.zsm = false;
            dragSortListView.k(headerViewsCount, 0.0f);
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
