package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

public class PagerTabStrip extends PagerTitleStrip {
    private final Rect ey = new Rect();
    private int iN;
    private int xD = this.yg;
    private int xE;
    private int xF;
    private int xG;
    private int xH;
    private int xI;
    private final Paint xJ = new Paint();
    private int xK = 255;
    private boolean xL = false;
    private boolean xM = false;
    private int xN;
    private boolean xO;
    private float xP;
    private float xQ;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xJ.setColor(this.xD);
        float f = context.getResources().getDisplayMetrics().density;
        this.xE = (int) ((3.0f * f) + 0.5f);
        this.xF = (int) ((6.0f * f) + 0.5f);
        this.xG = (int) (64.0f * f);
        this.xI = (int) ((16.0f * f) + 0.5f);
        this.xN = (int) ((1.0f * f) + 0.5f);
        this.xH = (int) ((f * 32.0f) + 0.5f);
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        ad(this.xY);
        setWillNotDraw(false);
        this.xT.setFocusable(true);
        this.xT.setOnClickListener(new 1(this));
        this.xV.setFocusable(true);
        this.xV.setOnClickListener(new 2(this));
        if (getBackground() == null) {
            this.xL = true;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.xF) {
            i4 = this.xF;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public final void ad(int i) {
        if (i < this.xG) {
            i = this.xG;
        }
        super.ad(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.xM) {
            this.xL = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.xM) {
            this.xL = (WebView.NIGHT_MODE_COLOR & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.xM) {
            this.xL = i == 0;
        }
    }

    final int getMinHeight() {
        return Math.max(super.getMinHeight(), this.xH);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.xO) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.xP = x;
                this.xQ = y;
                this.xO = false;
                break;
            case 1:
                if (x >= ((float) (this.xU.getLeft() - this.xI))) {
                    if (x > ((float) (this.xU.getRight() + this.xI))) {
                        this.xS.ah(this.xS.yF + 1);
                        break;
                    }
                }
                this.xS.ah(this.xS.yF - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.xP) > ((float) this.iN) || Math.abs(y - this.xQ) > ((float) this.iN)) {
                    this.xO = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.xU.getLeft() - this.xI;
        int right = this.xU.getRight() + this.xI;
        int i = height - this.xE;
        this.xJ.setColor((this.xK << 24) | (this.xD & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.xJ);
        if (this.xL) {
            this.xJ.setColor(WebView.NIGHT_MODE_COLOR | (this.xD & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.xN), (float) (getWidth() - getPaddingRight()), (float) height, this.xJ);
        }
    }

    final void a(int i, float f, boolean z) {
        Rect rect = this.ey;
        int height = getHeight();
        int i2 = height - this.xE;
        rect.set(this.xU.getLeft() - this.xI, i2, this.xU.getRight() + this.xI, height);
        super.a(i, f, z);
        this.xK = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.xU.getLeft() - this.xI, i2, this.xU.getRight() + this.xI, height);
        invalidate(rect);
    }
}
