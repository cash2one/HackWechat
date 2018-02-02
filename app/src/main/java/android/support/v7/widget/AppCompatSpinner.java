package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements x {
    private static final boolean PP;
    private static final boolean PQ;
    private static final int[] PR = new int[]{16843505};
    private android.support.v7.widget.ListPopupWindow.b Kz;
    private Context Mn;
    private SpinnerAdapter PS;
    private boolean PT;
    private b PU;
    private int PV;
    private h Pc;
    private f Pd;
    private final Rect ey;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter PY;
        private ListAdapter PZ;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.PY = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.PZ = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && AppCompatSpinner.PP && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            return this.PY == null ? 0 : this.PY.getCount();
        }

        public final Object getItem(int i) {
            return this.PY == null ? null : this.PY.getItem(i);
        }

        public final long getItemId(int i) {
            return this.PY == null ? -1 : this.PY.getItemId(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.PY == null ? null : this.PY.getDropDownView(i, view, viewGroup);
        }

        public final boolean hasStableIds() {
            return this.PY != null && this.PY.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.PY != null) {
                this.PY.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.PY != null) {
                this.PY.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.PZ;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.PZ;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    private class b extends ListPopupWindow {
        private ListAdapter FP;
        final /* synthetic */ AppCompatSpinner PX;
        CharSequence Qa;
        private final Rect Qb = new Rect();

        static /* synthetic */ boolean a(b bVar, View view) {
            return z.ak(view) && view.getGlobalVisibleRect(bVar.Qb);
        }

        public b(final AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            this.PX = appCompatSpinner;
            super(context, attributeSet, i);
            this.SW = appCompatSpinner;
            setModal(true);
            this.SV = 0;
            this.SY = new OnItemClickListener(this) {
                final /* synthetic */ b Qd;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.Qd.PX.setSelection(i);
                    if (this.Qd.PX.getOnItemClickListener() != null) {
                        this.Qd.PX.performItemClick(view, i, this.Qd.FP.getItemId(i));
                    }
                    this.Qd.dismiss();
                }
            };
        }

        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.FP = listAdapter;
        }

        final void ez() {
            int i;
            int i2;
            Drawable background = this.SK.getBackground();
            if (background != null) {
                background.getPadding(this.PX.ey);
                i = at.bv(this.PX) ? this.PX.ey.right : -this.PX.ey.left;
            } else {
                Rect b = this.PX.ey;
                this.PX.ey.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.PX.getPaddingLeft();
            int paddingRight = this.PX.getPaddingRight();
            int width = this.PX.getWidth();
            if (this.PX.PV == -2) {
                int a = this.PX.a((SpinnerAdapter) this.FP, this.SK.getBackground());
                i2 = (this.PX.getContext().getResources().getDisplayMetrics().widthPixels - this.PX.ey.left) - this.PX.ey.right;
                if (a <= i2) {
                    i2 = a;
                }
                setContentWidth(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.PX.PV == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(this.PX.PV);
            }
            if (at.bv(this.PX)) {
                i2 = ((width - paddingRight) - this.PV) + i;
            } else {
                i2 = i + paddingLeft;
            }
            this.SN = i2;
        }

        public final void show() {
            boolean isShowing = this.SK.isShowing();
            ez();
            fe();
            super.show();
            this.SL.setChoiceMode(1);
            int selectedItemPosition = this.PX.getSelectedItemPosition();
            a aVar = this.SL;
            if (this.SK.isShowing() && aVar != null) {
                aVar.Th = false;
                aVar.setSelection(selectedItemPosition);
                if (VERSION.SDK_INT >= 11 && aVar.getChoiceMode() != 0) {
                    aVar.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing) {
                ViewTreeObserver viewTreeObserver = this.PX.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener(this) {
                        final /* synthetic */ b Qd;

                        {
                            this.Qd = r1;
                        }

                        public final void onGlobalLayout() {
                            if (b.a(this.Qd, this.Qd.PX)) {
                                this.Qd.ez();
                                super.show();
                                return;
                            }
                            this.Qd.dismiss();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    setOnDismissListener(new OnDismissListener(this) {
                        final /* synthetic */ b Qd;

                        public final void onDismiss() {
                            ViewTreeObserver viewTreeObserver = this.Qd.PX.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        PP = z;
        if (VERSION.SDK_INT >= 16) {
            z = true;
        } else {
            z = false;
        }
        PQ = z;
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, attributeSet, i, -1);
    }

    private AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        Context dVar;
        AppCompatSpinner appCompatSpinner;
        TypedArray obtainStyledAttributes;
        final b bVar;
        ap a;
        CharSequence[] textArray;
        SpinnerAdapter arrayAdapter;
        Throwable th;
        TypedArray typedArray = null;
        super(context, attributeSet, i);
        this.ey = new Rect();
        ap a2 = ap.a(context, attributeSet, k.Spinner, i);
        this.Pc = h.ey();
        this.Pd = new f(this, this.Pc);
        int resourceId = a2.getResourceId(k.Spinner_popupTheme, 0);
        if (resourceId != 0) {
            dVar = new d(context, resourceId);
            appCompatSpinner = this;
        } else if (PP) {
            dVar = null;
            appCompatSpinner = this;
        } else {
            dVar = context;
            appCompatSpinner = this;
        }
        appCompatSpinner.Mn = dVar;
        if (this.Mn != null) {
            if (VERSION.SDK_INT >= 11) {
                try {
                    obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PR, i, 0);
                    try {
                        if (obtainStyledAttributes.hasValue(0)) {
                            i2 = obtainStyledAttributes.getInt(0, 0);
                        }
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                    } catch (Exception e) {
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            bVar = new b(this, this.Mn, attributeSet, i);
                            a = ap.a(this.Mn, attributeSet, k.Spinner, i);
                            this.PV = a.getLayoutDimension(k.Spinner_android_dropDownWidth, -2);
                            bVar.setBackgroundDrawable(a.getDrawable(k.Spinner_android_popupBackground));
                            bVar.Qa = a2.Zu.getString(k.Spinner_android_prompt);
                            a.Zu.recycle();
                            this.PU = bVar;
                            this.Kz = new android.support.v7.widget.ListPopupWindow.b(this, this) {
                                final /* synthetic */ AppCompatSpinner PX;

                                public final ListPopupWindow dp() {
                                    return bVar;
                                }

                                public final boolean dq() {
                                    if (!this.PX.PU.SK.isShowing()) {
                                        this.PX.PU.show();
                                    }
                                    return true;
                                }
                            };
                        }
                        textArray = a2.Zu.getTextArray(k.Spinner_android_entries);
                        if (textArray != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                            arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.Zu.recycle();
                        this.PT = true;
                        if (this.PS != null) {
                            setAdapter(this.PS);
                            this.PS = null;
                        }
                        this.Pd.b(attributeSet, i);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        typedArray = obtainStyledAttributes;
                        th = th3;
                        if (typedArray != null) {
                            typedArray.recycle();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    obtainStyledAttributes = null;
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    if (i2 == 1) {
                        bVar = new b(this, this.Mn, attributeSet, i);
                        a = ap.a(this.Mn, attributeSet, k.Spinner, i);
                        this.PV = a.getLayoutDimension(k.Spinner_android_dropDownWidth, -2);
                        bVar.setBackgroundDrawable(a.getDrawable(k.Spinner_android_popupBackground));
                        bVar.Qa = a2.Zu.getString(k.Spinner_android_prompt);
                        a.Zu.recycle();
                        this.PU = bVar;
                        this.Kz = /* anonymous class already generated */;
                    }
                    textArray = a2.Zu.getTextArray(k.Spinner_android_entries);
                    if (textArray != null) {
                        arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
                        arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
                        setAdapter(arrayAdapter);
                    }
                    a2.Zu.recycle();
                    this.PT = true;
                    if (this.PS != null) {
                        setAdapter(this.PS);
                        this.PS = null;
                    }
                    this.Pd.b(attributeSet, i);
                } catch (Throwable th4) {
                    th = th4;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            i2 = 1;
            if (i2 == 1) {
                bVar = new b(this, this.Mn, attributeSet, i);
                a = ap.a(this.Mn, attributeSet, k.Spinner, i);
                this.PV = a.getLayoutDimension(k.Spinner_android_dropDownWidth, -2);
                bVar.setBackgroundDrawable(a.getDrawable(k.Spinner_android_popupBackground));
                bVar.Qa = a2.Zu.getString(k.Spinner_android_prompt);
                a.Zu.recycle();
                this.PU = bVar;
                this.Kz = /* anonymous class already generated */;
            }
        }
        textArray = a2.Zu.getTextArray(k.Spinner_android_entries);
        if (textArray != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(h.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.Zu.recycle();
        this.PT = true;
        if (this.PS != null) {
            setAdapter(this.PS);
            this.PS = null;
        }
        this.Pd.b(attributeSet, i);
    }

    public Context getPopupContext() {
        if (this.PU != null) {
            return this.Mn;
        }
        if (PP) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.PU != null) {
            this.PU.setBackgroundDrawable(drawable);
        } else if (PQ) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v4.content.a.b(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.PU != null) {
            return this.PU.SK.getBackground();
        }
        if (PQ) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.PU != null) {
            this.PU.setVerticalOffset(i);
        } else if (PQ) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.PU != null) {
            ListPopupWindow listPopupWindow = this.PU;
            if (listPopupWindow.SQ) {
                return listPopupWindow.SO;
            }
            return 0;
        } else if (PQ) {
            return super.getDropDownVerticalOffset();
        } else {
            return 0;
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.PU != null) {
            this.PU.SN = i;
        } else if (PQ) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.PU != null) {
            return this.PU.SN;
        }
        if (PQ) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.PU != null) {
            this.PV = i;
        } else if (PQ) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.PU != null) {
            return this.PV;
        }
        if (PQ) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.PT) {
            super.setAdapter(spinnerAdapter);
            if (this.PU != null) {
                this.PU.setAdapter(new a(spinnerAdapter, (this.Mn == null ? getContext() : this.Mn).getTheme()));
                return;
            }
            return;
        }
        this.PS = spinnerAdapter;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.PU != null && this.PU.SK.isShowing()) {
            this.PU.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Kz == null || !this.Kz.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.PU != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.PU == null) {
            return super.performClick();
        }
        if (!this.PU.SK.isShowing()) {
            this.PU.show();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.PU != null) {
            this.PU.Qa = charSequence;
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.PU != null ? this.PU.Qa : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Pd != null) {
            this.Pd.aR(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Pd != null) {
            this.Pd.f(null);
        }
    }

    public final void d(ColorStateList colorStateList) {
        if (this.Pd != null) {
            this.Pd.d(colorStateList);
        }
    }

    public final ColorStateList bM() {
        return this.Pd != null ? this.Pd.bM() : null;
    }

    public final void a(Mode mode) {
        if (this.Pd != null) {
            this.Pd.a(mode);
        }
    }

    public final Mode bN() {
        return this.Pd != null ? this.Pd.bN() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Pd != null) {
            this.Pd.ev();
        }
    }

    private int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.ey);
        return (this.ey.left + this.ey.right) + i;
    }
}
