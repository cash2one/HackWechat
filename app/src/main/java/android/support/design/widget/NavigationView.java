package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a$b;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.v4.view.z;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] dX = new int[]{16842912};
    private static final int[] iT = new int[]{-16842910};
    private final android.support.design.internal.a iU;
    private final b iV;
    private a iW;
    private int iX;
    private MenuInflater iY;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new 1());
        public Bundle ja;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.ja = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.ja);
        }
    }

    public interface a {
        boolean ah();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        boolean z;
        super(context, attributeSet, i);
        this.iV = new b();
        t.e(context);
        this.iU = new android.support.design.internal.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cP, i, h.bK);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.cQ));
        if (obtainStyledAttributes.hasValue(i.cT)) {
            z.g(this, (float) obtainStyledAttributes.getDimensionPixelSize(i.cT, 0));
        }
        z.a(this, obtainStyledAttributes.getBoolean(i.cR, false));
        this.iX = obtainStyledAttributes.getDimensionPixelSize(i.cS, 0);
        if (obtainStyledAttributes.hasValue(i.cV)) {
            colorStateList = obtainStyledAttributes.getColorStateList(i.cV);
        } else {
            colorStateList = F(16842808);
        }
        if (obtainStyledAttributes.hasValue(i.cY)) {
            resourceId = obtainStyledAttributes.getResourceId(i.cY, 0);
            z = true;
        } else {
            resourceId = 0;
            z = false;
        }
        ColorStateList colorStateList2 = null;
        if (obtainStyledAttributes.hasValue(i.cW)) {
            colorStateList2 = obtainStyledAttributes.getColorStateList(i.cW);
        }
        if (!z && r5 == null) {
            colorStateList2 = F(16842806);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(i.cX);
        this.iU.a(new android.support.v7.view.menu.f.a(this) {
            final /* synthetic */ NavigationView iZ;

            {
                this.iZ = r1;
            }

            public final boolean a(f fVar, MenuItem menuItem) {
                return this.iZ.iW != null && this.iZ.iW.ah();
            }

            public final void b(f fVar) {
            }
        });
        this.iV.mId = 1;
        this.iV.a(context, this.iU);
        this.iV.a(colorStateList);
        if (z) {
            this.iV.o(resourceId);
        }
        this.iV.b(colorStateList2);
        this.iV.a(drawable);
        this.iU.a(this.iV);
        b bVar = this.iV;
        if (bVar.ed == null) {
            bVar.ed = (NavigationMenuView) bVar.mLayoutInflater.inflate(android.support.design.a.f.bA, this, false);
            if (bVar.eh == null) {
                bVar.eh = new b.b(bVar);
            }
            bVar.ee = (LinearLayout) bVar.mLayoutInflater.inflate(android.support.design.a.f.bx, bVar.ed, false);
            bVar.ed.a(bVar.eh);
        }
        addView(bVar.ed);
        if (obtainStyledAttributes.hasValue(i.cU)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(i.cU, 0);
            this.iV.g(true);
            if (this.iY == null) {
                this.iY = new g(getContext());
            }
            this.iY.inflate(resourceId2, this.iU);
            this.iV.g(false);
            this.iV.f(false);
        }
        if (obtainStyledAttributes.hasValue(i.cZ)) {
            resourceId2 = obtainStyledAttributes.getResourceId(i.cZ, 0);
            bVar = this.iV;
            bVar.ee.addView(bVar.mLayoutInflater.inflate(resourceId2, bVar.ee, false));
            bVar.ed.setPadding(0, 0, 0, bVar.ed.getPaddingBottom());
        }
        obtainStyledAttributes.recycle();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.ja = new Bundle();
        this.iU.dispatchSaveInstanceState(savedState.ja);
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            f fVar = this.iU;
            SparseArray sparseParcelableArray = savedState.ja.getSparseParcelableArray("android:menu:presenters");
            if (sparseParcelableArray != null && !fVar.Lx.isEmpty()) {
                Iterator it = fVar.Lx.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar = (l) weakReference.get();
                    if (lVar == null) {
                        fVar.Lx.remove(weakReference);
                    } else {
                        int id = lVar.getId();
                        if (id > 0) {
                            Parcelable parcelable2 = (Parcelable) sparseParcelableArray.get(id);
                            if (parcelable2 != null) {
                                lVar.onRestoreInstanceState(parcelable2);
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.iX), 1073741824);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.iX, 1073741824);
                break;
        }
        super.onMeasure(i, i2);
    }

    protected final void a(Rect rect) {
        b bVar = this.iV;
        int i = rect.top;
        if (bVar.em != i) {
            bVar.em = i;
            if (bVar.ee.getChildCount() == 0) {
                bVar.ed.setPadding(0, bVar.em, 0, bVar.ed.getPaddingBottom());
            }
        }
    }

    private ColorStateList F(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = getResources().getColorStateList(typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(a$b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{iT, dX, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iT, defaultColor), i2, defaultColor});
    }
}
