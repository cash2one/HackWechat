package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class b extends ImageView {
    AnimationListener Bk;
    private int Bl;

    public b(Context context) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) ((20.0f * f) * 2.0f);
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.Bl = (int) (3.5f * f);
        if (cm()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            z.g(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this, this.Bl, i));
            z.a(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.Bl, (float) i3, (float) i2, 503316480);
            int i4 = this.Bl;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(-328966);
        setBackgroundDrawable(shapeDrawable);
    }

    private static boolean cm() {
        return VERSION.SDK_INT >= 21;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!cm()) {
            setMeasuredDimension(getMeasuredWidth() + (this.Bl * 2), getMeasuredHeight() + (this.Bl * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.Bk != null) {
            this.Bk.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.Bk != null) {
            this.Bk.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
