package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mm.plugin.appbrand.jsapi.m.e;

public class WxaScrollView extends FrameLayout implements n, o, e {
    private float fF;
    private float jjd;
    private int jje;
    private int jjf;
    private Paint jjg = new Paint();
    FrameLayout jjm;
    private ScrollView jjn;
    l jjo;

    public WxaScrollView(Context context) {
        super(context);
        init();
    }

    public WxaScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WxaScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jjn = new 1(this, getContext());
        this.jjm = new FrameLayout(getContext());
        super.addView(this.jjn, 0, new LayoutParams(-1, -1));
        this.jjn.addView(this.jjm, 0, new LayoutParams(-1, -2));
        this.jjg.setStyle(Style.STROKE);
        this.jjg.setAntiAlias(true);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        Object obj;
        float f = 0.0f;
        Object obj2 = this.jjd > 0.0f ? 1 : null;
        if (obj2 != null) {
            canvas.save();
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.jjd, this.jjd, Direction.CW);
            canvas.clipPath(path);
        }
        if (this.jjf != 0) {
            canvas.drawColor(this.jjf);
        }
        if (this.fF > 0.0f) {
            float f2 = this.fF / 2.0f;
            canvas.drawRoundRect(new RectF(f2, f2, ((float) getWidth()) - f2, ((float) getHeight()) - f2), this.jjd, this.jjd, this.jjg);
            if (obj2 != null) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            if (this.jjd > 0.0f && this.jjd - this.fF > 0.0f) {
                f = this.jjd - this.fF;
            }
            path2.addRoundRect(new RectF(this.fF, this.fF, ((float) getWidth()) - this.fF, ((float) getHeight()) - this.fF), f, f, Direction.CW);
            canvas.clipPath(path2);
            obj = 1;
        } else {
            obj = obj2;
        }
        int save = canvas.save();
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (obj != null) {
            canvas.restore();
        }
    }

    public final int agi() {
        return this.jjm.getChildCount();
    }

    public void addView(View view, int i) {
        this.jjm.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        this.jjm.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        this.jjm.removeView(view);
    }

    public final void V(float f) {
        this.jjd = f;
    }

    public final void kv(int i) {
        this.jje = i;
        this.jjg.setColor(i);
    }

    public final void W(float f) {
        this.fF = f;
        this.jjg.setStrokeWidth(f);
    }

    public final void kw(int i) {
        this.jjf = i;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.jjd > 0.0f) {
                double pow = Math.pow((double) this.jjd, 2.0d);
                float width = (float) getWidth();
                float height = (float) getHeight();
                if (x < this.jjd) {
                    if (y < this.jjd) {
                        if (Math.pow((double) (this.jjd - y), 2.0d) + Math.pow((double) (this.jjd - x), 2.0d) > pow) {
                            z = false;
                            if (!z) {
                                return false;
                            }
                        }
                    } else if (y > height - this.jjd) {
                        if (Math.pow((double) ((this.jjd + y) - height), 2.0d) + Math.pow((double) (this.jjd - x), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    }
                } else if (x > width - this.jjd) {
                    if (y < this.jjd) {
                        if (Math.pow((double) (this.jjd - y), 2.0d) + Math.pow((double) ((x + this.jjd) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    } else if (y > height - this.jjd) {
                        if (Math.pow((double) ((this.jjd + y) - height), 2.0d) + Math.pow((double) ((x + this.jjd) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    }
                }
            }
            z = true;
            if (z) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
