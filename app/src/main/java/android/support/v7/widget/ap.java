package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public final class ap {
    public final TypedArray Zu;
    private final Context mContext;

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ap a(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new ap(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    private ap(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.Zu = typedArray;
    }

    public final Drawable getDrawable(int i) {
        if (this.Zu.hasValue(i)) {
            int resourceId = this.Zu.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.ey().a(this.mContext, resourceId, false);
            }
        }
        return this.Zu.getDrawable(i);
    }

    public final Drawable bN(int i) {
        if (this.Zu.hasValue(i)) {
            int resourceId = this.Zu.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.ey().a(this.mContext, resourceId, true);
            }
        }
        return null;
    }

    public final CharSequence getText(int i) {
        return this.Zu.getText(i);
    }

    public final boolean getBoolean(int i, boolean z) {
        return this.Zu.getBoolean(i, z);
    }

    public final int getInt(int i, int i2) {
        return this.Zu.getInt(i, i2);
    }

    public final int bO(int i) {
        return this.Zu.getColor(i, -1);
    }

    public final int getDimensionPixelOffset(int i, int i2) {
        return this.Zu.getDimensionPixelOffset(i, i2);
    }

    public final int getDimensionPixelSize(int i, int i2) {
        return this.Zu.getDimensionPixelSize(i, i2);
    }

    public final int getLayoutDimension(int i, int i2) {
        return this.Zu.getLayoutDimension(i, i2);
    }

    public final int getResourceId(int i, int i2) {
        return this.Zu.getResourceId(i, i2);
    }

    public final boolean hasValue(int i) {
        return this.Zu.hasValue(i);
    }
}
