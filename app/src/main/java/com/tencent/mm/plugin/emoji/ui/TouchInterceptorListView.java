package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.x;

public class TouchInterceptorListView extends ListView {
    private Rect ey = new Rect();
    private final int iN;
    private GestureDetector jtw;
    private int lEA = 0;
    private ImageView lEh;
    private WindowManager lEi;
    private LayoutParams lEj;
    private int lEk;
    private int lEl;
    private int lEm;
    private int lEn;
    private int lEo;
    private int lEp;
    private a lEq;
    private b lEr;
    private c lEs;
    private int lEt;
    private int lEu;
    private int lEv = -1;
    private Bitmap lEw;
    private int lEx;
    private int lEy;
    private Drawable lEz;
    private int ltQ;
    private int mHeight;

    public TouchInterceptorListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.ltQ = resources.getDimensionPixelSize(R.f.bxb) + 1;
        this.lEy = this.ltQ / 2;
        this.lEx = this.ltQ * 2;
        this.lEA = resources.getDimensionPixelOffset(R.f.bxe);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.lEs != null && this.jtw == null && this.lEv == 0) {
            this.jtw = new GestureDetector(getContext(), new 1(this));
        }
        if (!(this.lEq == null && this.lEr == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition - getFirstVisiblePosition());
                        this.lEm = x - viewGroup.getLeft();
                        this.lEn = y - viewGroup.getTop();
                        this.lEo = ((int) motionEvent.getRawX()) - x;
                        this.lEp = ((int) motionEvent.getRawY()) - y;
                        if (x >= this.lEA) {
                            aDk();
                            break;
                        }
                        viewGroup.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
                        aDk();
                        this.lEj = new LayoutParams();
                        this.lEj.gravity = 49;
                        this.lEj.x = (x - this.lEm) + this.lEo;
                        this.lEj.y = (y - this.lEn) + this.lEp;
                        this.lEj.height = -2;
                        this.lEj.width = -2;
                        this.lEj.flags = 920;
                        this.lEj.format = -3;
                        this.lEj.windowAnimations = 0;
                        Context context = getContext();
                        View imageView = new ImageView(context);
                        imageView.setBackgroundColor(context.getResources().getColor(R.e.white));
                        imageView.setBackgroundResource(R.g.bBX);
                        imageView.setPadding(0, 0, 0, 0);
                        imageView.setImageBitmap(createBitmap);
                        this.lEw = createBitmap;
                        this.lEi = (WindowManager) context.getSystemService("window");
                        this.lEi.addView(imageView, this.lEj);
                        this.lEh = imageView;
                        this.lEk = pointToPosition;
                        this.lEl = this.lEk;
                        this.mHeight = getHeight();
                        int i = this.iN;
                        this.lEt = Math.min(y - i, this.mHeight / 3);
                        this.lEu = Math.max(i + y, (this.mHeight * 2) / 3);
                        return false;
                    }
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private int cr(int i, int i2) {
        int cr;
        if (i2 < 0) {
            cr = cr(i, this.ltQ + i2);
            if (cr > 0) {
                return cr - 1;
            }
        }
        Rect rect = this.ey;
        for (cr = getChildCount() - 1; cr >= 0; cr--) {
            getChildAt(cr).getHitRect(rect);
            if (rect.contains(i, i2)) {
                return cr + getFirstVisiblePosition();
            }
        }
        return -1;
    }

    private void ez(boolean z) {
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                try {
                    layoutChildren();
                    childAt = getChildAt(i);
                } catch (IllegalStateException e) {
                }
                if (childAt == null) {
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = this.ltQ;
            childAt.setLayoutParams(layoutParams);
            childAt.setVisibility(0);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 4;
        int i2 = 0;
        if (this.jtw != null) {
            this.jtw.onTouchEvent(motionEvent);
        }
        if ((this.lEq == null && this.lEr == null) || this.lEh == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int width;
                int width2;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.lEv == 1) {
                    float f = 1.0f;
                    width = this.lEh.getWidth();
                    if (x > width / 2) {
                        f = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.lEj.alpha = f;
                }
                if (this.lEv == 0 || this.lEv == 2) {
                    this.lEj.x = (x - this.lEm) + this.lEo;
                } else {
                    this.lEj.x = 0;
                }
                this.lEj.y = (y - this.lEn) + this.lEp;
                this.lEi.updateViewLayout(this.lEh, this.lEj);
                if (this.lEz != null) {
                    width2 = this.lEh.getWidth();
                    if (y > (getHeight() * 3) / 4) {
                        this.lEz.setLevel(2);
                    } else if (width2 <= 0 || x <= width2 / 4) {
                        this.lEz.setLevel(0);
                    } else {
                        this.lEz.setLevel(1);
                    }
                }
                x = (y - this.lEn) - this.lEy;
                width2 = cr(0, x);
                if (width2 >= 0) {
                    if (width2 <= this.lEl) {
                        width2++;
                    }
                } else if (x < 0) {
                    width2 = 0;
                }
                if (width2 < 0) {
                    return true;
                }
                if (action == 0 || width2 != this.lEk) {
                    this.lEk = width2;
                    x.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[]{Integer.valueOf(this.lEk), Integer.valueOf(this.lEl)});
                    x.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[]{Integer.valueOf(getFirstVisiblePosition())});
                    x.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[]{Integer.valueOf(getHeaderViewsCount())});
                    width = this.lEk - getFirstVisiblePosition();
                    int headerViewsCount = getHeaderViewsCount();
                    View childAt = getChildAt(this.lEl - getFirstVisiblePosition());
                    x = 0;
                    while (true) {
                        View childAt2 = getChildAt(x);
                        if (childAt2 != null) {
                            width2 = this.ltQ;
                            if (this.lEk >= headerViewsCount || x != headerViewsCount) {
                                if (childAt2.equals(childAt)) {
                                    if (this.lEk == this.lEl || getPositionForView(childAt2) == getCount()) {
                                        width2 = this.ltQ;
                                        x.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
                                        action = width2;
                                        width2 = 4;
                                    } else {
                                        x.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
                                        width2 = 0;
                                        action = 1;
                                    }
                                } else if (x != width) {
                                    x.d("MicroMsg.emoji.TouchInterceptorListView", "4");
                                    action = width2;
                                    width2 = 0;
                                } else if (this.lEk < headerViewsCount || this.lEk >= getCount()) {
                                    x.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
                                    action = width2;
                                    width2 = 0;
                                } else {
                                    width2 = this.lEx;
                                    x.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
                                    action = width2;
                                    width2 = 0;
                                }
                            } else if (childAt2.equals(childAt)) {
                                x.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
                                action = width2;
                                width2 = 4;
                            } else {
                                width2 = this.lEx;
                                x.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
                                action = width2;
                                width2 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                            layoutParams.height = action;
                            childAt2.setLayoutParams(layoutParams);
                            childAt2.setVisibility(width2);
                            x++;
                        }
                    }
                }
                if (y >= this.mHeight / 3) {
                    this.lEt = this.mHeight / 3;
                }
                if (y <= (this.mHeight * 2) / 3) {
                    this.lEu = (this.mHeight * 2) / 3;
                }
                if (y > this.lEu) {
                    if (getLastVisiblePosition() < getCount() - 1) {
                        if (y > (this.mHeight + this.lEu) / 2) {
                            i = 16;
                        }
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                } else if (y < this.lEt) {
                    width2 = y < this.lEt / 2 ? -16 : -4;
                    if (getFirstVisiblePosition() != 0 || getChildAt(0).getTop() < getPaddingTop()) {
                        i2 = width2;
                    }
                }
                if (i2 == 0 || f.fN(8)) {
                    return true;
                }
                smoothScrollBy(i2, 30);
                return true;
            case 1:
            case 3:
                Rect rect = this.ey;
                this.lEh.getDrawingRect(rect);
                aDk();
                if (this.lEv != 1 || motionEvent.getX() <= ((float) ((rect.right * 3) / 4))) {
                    if (this.lEr != null && this.lEk >= 0) {
                        getCount();
                    }
                    ez(false);
                    return true;
                }
                ez(true);
                return true;
            default:
                return true;
        }
    }

    private void aDk() {
        if (this.lEh != null) {
            this.lEh.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.lEh);
            this.lEh.setImageDrawable(null);
            this.lEh = null;
        }
        if (this.lEw != null) {
            x.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[]{this.lEw});
            this.lEw.recycle();
            this.lEw = null;
        }
        if (this.lEz != null) {
            this.lEz.setLevel(0);
        }
    }
}
