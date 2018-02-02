package android.support.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public final class b extends e implements Animatable {
    private Context mContext;
    private a ma;
    private ArgbEvaluator mb;
    private final Callback mc;

    private static class a extends ConstantState {
        int me;
        f mf;
        ArrayList<Animator> mg;
        android.support.v4.e.a<Animator, String> mh;

        public a(a aVar, Callback callback, Resources resources) {
        }

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public final int getChangingConfigurations() {
            return this.me;
        }
    }

    private static class b extends ConstantState {
        private final ConstantState mi;

        public b(ConstantState constantState) {
            this.mi = constantState;
        }

        public final Drawable newDrawable() {
            Drawable bVar = new b();
            bVar.mn = this.mi.newDrawable();
            bVar.mn.setCallback(bVar.mc);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable bVar = new b();
            bVar.mn = this.mi.newDrawable(resources);
            bVar.mn.setCallback(bVar.mc);
            return bVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable bVar = new b();
            bVar.mn = this.mi.newDrawable(resources, theme);
            bVar.mn.setCallback(bVar.mc);
            return bVar;
        }

        public final boolean canApplyTheme() {
            return this.mi.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.mi.getChangingConfigurations();
        }
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private b() {
        this(null, (byte) 0);
    }

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        this.mb = null;
        this.mc = new Callback(this) {
            final /* synthetic */ b md;

            {
                this.md = r1;
            }

            public final void invalidateDrawable(Drawable drawable) {
                this.md.invalidateSelf();
            }

            public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                this.md.scheduleSelf(runnable, j);
            }

            public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                this.md.unscheduleSelf(runnable);
            }
        };
        this.mContext = context;
        this.ma = new a(null, this.mc, null);
    }

    public final Drawable mutate() {
        if (this.mn != null) {
            this.mn.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    public final ConstantState getConstantState() {
        if (this.mn != null) {
            return new b(this.mn.getConstantState());
        }
        return null;
    }

    public final int getChangingConfigurations() {
        if (this.mn != null) {
            return this.mn.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.ma.me;
    }

    public final void draw(Canvas canvas) {
        if (this.mn != null) {
            this.mn.draw(canvas);
            return;
        }
        this.ma.mf.draw(canvas);
        if (isStarted()) {
            invalidateSelf();
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.mn != null) {
            this.mn.setBounds(rect);
        } else {
            this.ma.mf.setBounds(rect);
        }
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.mn != null) {
            return this.mn.setState(iArr);
        }
        return this.ma.mf.setState(iArr);
    }

    protected final boolean onLevelChange(int i) {
        if (this.mn != null) {
            return this.mn.setLevel(i);
        }
        return this.ma.mf.setLevel(i);
    }

    public final int getAlpha() {
        if (this.mn != null) {
            return android.support.v4.b.a.a.e(this.mn);
        }
        return this.ma.mf.getAlpha();
    }

    public final void setAlpha(int i) {
        if (this.mn != null) {
            this.mn.setAlpha(i);
        } else {
            this.ma.mf.setAlpha(i);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.mn != null) {
            this.mn.setColorFilter(colorFilter);
        } else {
            this.ma.mf.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, i);
        } else {
            this.ma.mf.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, colorStateList);
        } else {
            this.ma.mf.setTintList(colorStateList);
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, mode);
        } else {
            this.ma.mf.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.mn != null) {
            return this.mn.setVisible(z, z2);
        }
        this.ma.mf.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final boolean isStateful() {
        if (this.mn != null) {
            return this.mn.isStateful();
        }
        return this.ma.mf.isStateful();
    }

    public final int getOpacity() {
        if (this.mn != null) {
            return this.mn.getOpacity();
        }
        return this.ma.mf.getOpacity();
    }

    public final int getIntrinsicWidth() {
        if (this.mn != null) {
            return this.mn.getIntrinsicWidth();
        }
        return this.ma.mf.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        if (this.mn != null) {
            return this.mn.getIntrinsicHeight();
        }
        return this.ma.mf.getIntrinsicHeight();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray obtainAttributes;
                if ("animated-vector".equals(name)) {
                    int[] iArr = a.lY;
                    obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f a = f.a(resources, resourceId, theme);
                        a.mt = false;
                        a.setCallback(this.mc);
                        if (this.ma.mf != null) {
                            this.ma.mf.setCallback(null);
                        }
                        this.ma.mf = a;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.lZ);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.mContext != null) {
                            Animator loadAnimator = AnimatorInflater.loadAnimator(this.mContext, resourceId2);
                            loadAnimator.setTarget(this.ma.mf.mp.nn.nm.get(string));
                            if (VERSION.SDK_INT < 21) {
                                b(loadAnimator);
                            }
                            if (this.ma.mg == null) {
                                this.ma.mg = new ArrayList();
                                this.ma.mh = new android.support.v4.e.a();
                            }
                            this.ma.mg.add(loadAnimator);
                            this.ma.mh.put(loadAnimator, string);
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public final void applyTheme(Theme theme) {
        if (this.mn != null) {
            android.support.v4.b.a.a.a(this.mn, theme);
        }
    }

    public final boolean canApplyTheme() {
        if (this.mn != null) {
            return android.support.v4.b.a.a.f(this.mn);
        }
        return false;
    }

    private void b(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    b((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.mb == null) {
                    this.mb = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.mb);
            }
        }
    }

    public final boolean isRunning() {
        if (this.mn != null) {
            return ((AnimatedVectorDrawable) this.mn).isRunning();
        }
        ArrayList arrayList = this.ma.mg;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean isStarted() {
        ArrayList arrayList = this.ma.mg;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void start() {
        if (this.mn != null) {
            ((AnimatedVectorDrawable) this.mn).start();
        } else if (!isStarted()) {
            ArrayList arrayList = this.ma.mg;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.mn != null) {
            ((AnimatedVectorDrawable) this.mn).stop();
            return;
        }
        ArrayList arrayList = this.ma.mg;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
