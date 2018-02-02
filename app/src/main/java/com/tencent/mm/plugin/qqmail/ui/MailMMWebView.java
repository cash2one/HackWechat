package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;

public class MailMMWebView extends MMWebViewWithJsApi {
    private float iQK;
    private float iQL;
    boolean ptE;
    View ptF;
    View ptG;
    private boolean ptH;
    private boolean ptI;

    private class a extends FrameLayout {
        final /* synthetic */ MailMMWebView ptJ;

        public a(MailMMWebView mailMMWebView, Context context) {
            this.ptJ = mailMMWebView;
            super(context);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (!this.ptJ.ptH && !this.ptJ.ptI) {
                return false;
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                case 3:
                    this.ptJ.ptH = false;
                    this.ptJ.ptI = false;
                    break;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }

        protected final void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this == this.ptJ.ptF && this.ptJ.getTitleHeight() > 0) {
                this.ptJ.ble();
            } else if (this == this.ptJ.ptG && this.ptJ.bld() > 0) {
                this.ptJ.blf();
            }
        }
    }

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.ptE = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.iQK = x;
                this.iQL = y;
                if (this.ptF == null || ((int) this.iQL) >= blc()) {
                    if (this.ptG != null && this.ptG.getVisibility() == 0 && this.iQL + ((float) bld()) > ((float) getHeight())) {
                        this.ptI = true;
                        break;
                    }
                }
                this.ptH = true;
                break;
                break;
            case 2:
                if (Math.abs(y - this.iQL) > 50.0f && this.ptH) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.iQK, this.iQL + ((float) webScrollY));
                    this.ptF.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.iQK, this.iQL);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        if (this.ptH && this.ptF != null) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            return this.ptF.dispatchTouchEvent(motionEvent);
        } else if (!this.ptI || this.ptG == null) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setLocation(x, (y + ((float) bld())) - ((float) getHeight()));
            return this.ptG.dispatchTouchEvent(motionEvent);
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i2;
        super.onWebViewScrollChanged(i, i2, i3, i4);
        invalidate();
        if (contentHeight - height < bld()) {
            if (Math.abs(contentHeight - height) > 20) {
                blf();
                hr(false);
            } else {
                hr(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            ble();
        }
    }

    public int computeVerticalScrollExtent() {
        int height = getHeight();
        if (isHorizontalScrollBarEnabled() && !overlayHorizontalScrollbar()) {
            height -= getHorizontalScrollbarHeight();
        }
        return height - blc();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(getWebScrollY() - getTitleHeight(), 0);
    }

    private int blc() {
        return Math.max(getTitleHeight() - getWebScrollY(), 0);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.ptF) {
            return super.drawChild(canvas, view, j);
        }
        int webScrollY = getWebScrollY();
        canvas.save();
        canvas.translate(0.0f, (float) (-webScrollY));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public final int getTitleHeight() {
        if (this.ptF != null) {
            return this.ptF.getHeight();
        }
        return 0;
    }

    public final int bld() {
        if (this.ptG != null) {
            return this.ptG.getHeight();
        }
        return 0;
    }

    public final void ble() {
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
    }

    public final void blf() {
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) bld()) / getScale())) + ");", null);
    }

    public final void hr(boolean z) {
        if (this.ptG == null) {
            return;
        }
        if (z) {
            this.ptG.setVisibility(0);
        } else {
            this.ptG.setVisibility(4);
        }
    }
}
