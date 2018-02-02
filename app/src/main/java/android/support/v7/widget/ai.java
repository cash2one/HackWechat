package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.d;
import android.support.v7.a.a.k;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public final class ai extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator WH = new DecelerateInterpolator();
    private int Mq;
    Runnable WA;
    private LinearLayoutCompat WB;
    private Spinner WC;
    boolean WD;
    int WE;
    int WF;
    private int WG;

    private class a extends BaseAdapter {
        final /* synthetic */ ai WJ;

        private a(ai aiVar) {
            this.WJ = aiVar;
        }

        public final int getCount() {
            return this.WJ.WB.getChildCount();
        }

        public final Object getItem(int i) {
            return ((b) this.WJ.WB.getChildAt(i)).WL;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ai.a(this.WJ, (android.support.v7.app.ActionBar.a) getItem(i));
            }
            b bVar = (b) view;
            bVar.WL = (android.support.v7.app.ActionBar.a) getItem(i);
            bVar.update();
            return view;
        }
    }

    private class b extends LinearLayoutCompat implements OnLongClickListener {
        final /* synthetic */ ai WJ;
        private final int[] WK = new int[]{16842964};
        android.support.v7.app.ActionBar.a WL;
        private View kK;
        private TextView kO;
        private ImageView kP;

        public b(ai aiVar, Context context, android.support.v7.app.ActionBar.a aVar, boolean z) {
            this.WJ = aiVar;
            super(context, null, android.support.v7.a.a.a.actionBarTabStyle);
            this.WL = aVar;
            ap a = ap.a(context, null, this.WK, android.support.v7.a.a.a.actionBarTabStyle);
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            a.Zu.recycle();
            setGravity(8388627);
            update();
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
            }
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.WJ.WE > 0 && getMeasuredWidth() > this.WJ.WE) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.WJ.WE, 1073741824), i2);
            }
        }

        public final void update() {
            android.support.v7.app.ActionBar.a aVar = this.WL;
            View customView = aVar.getCustomView();
            if (customView != null) {
                b parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.kK = customView;
                if (this.kO != null) {
                    this.kO.setVisibility(8);
                }
                if (this.kP != null) {
                    this.kP.setVisibility(8);
                    this.kP.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.kK != null) {
                removeView(this.kK);
                this.kK = null;
            }
            Drawable icon = aVar.getIcon();
            CharSequence text = aVar.getText();
            if (icon != null) {
                if (this.kP == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.kP = imageView;
                }
                this.kP.setImageDrawable(icon);
                this.kP.setVisibility(0);
            } else if (this.kP != null) {
                this.kP.setVisibility(8);
                this.kP.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.kO == null) {
                    imageView = new AppCompatTextView(getContext(), null, android.support.v7.a.a.a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView);
                    this.kO = imageView;
                }
                this.kO.setText(text);
                this.kO.setVisibility(0);
            } else if (this.kO != null) {
                this.kO.setVisibility(8);
                this.kO.setText(null);
            }
            if (this.kP != null) {
                this.kP.setContentDescription(aVar.getContentDescription());
            }
            if (z || TextUtils.isEmpty(aVar.getContentDescription())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public final boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.WL.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    static /* synthetic */ b a(ai aiVar, android.support.v7.app.ActionBar.a aVar) {
        b bVar = new b(aiVar, aiVar.getContext(), aVar, true);
        bVar.setBackgroundDrawable(null);
        bVar.setLayoutParams(new AbsListView.LayoutParams(-1, aiVar.Mq));
        return bVar;
    }

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.WB.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.WE = -1;
        } else {
            if (childCount > 2) {
                this.WE = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.WE = MeasureSpec.getSize(i) / 2;
            }
            this.WE = Math.min(this.WE, this.WF);
        }
        mode = MeasureSpec.makeMeasureSpec(this.Mq, 1073741824);
        if (z || !this.WD) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.WB.measure(0, mode);
            if (this.WB.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                gt();
            } else if (!gs()) {
                if (this.WC == null) {
                    Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, android.support.v7.a.a.a.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.WC = appCompatSpinner;
                }
                removeView(this.WB);
                addView(this.WC, new LayoutParams(-2, -1));
                if (this.WC.getAdapter() == null) {
                    this.WC.setAdapter(new a());
                }
                if (this.WA != null) {
                    removeCallbacks(this.WA);
                    this.WA = null;
                }
                this.WC.setSelection(this.WG);
            }
        } else {
            gt();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            bw(this.WG);
        }
    }

    private boolean gs() {
        return this.WC != null && this.WC.getParent() == this;
    }

    private boolean gt() {
        if (gs()) {
            removeView(this.WC);
            addView(this.WB, new LayoutParams(-2, -1));
            bw(this.WC.getSelectedItemPosition());
        }
        return false;
    }

    private void bw(int i) {
        this.WG = i;
        int childCount = this.WB.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.WB.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.WB.getChildAt(i);
                if (this.WA != null) {
                    removeCallbacks(this.WA);
                }
                this.WA = new Runnable(this) {
                    final /* synthetic */ ai WJ;

                    public final void run() {
                        this.WJ.smoothScrollTo(childAt2.getLeft() - ((this.WJ.getWidth() - childAt2.getWidth()) / 2), 0);
                        this.WJ.WA = null;
                    }
                };
                post(this.WA);
            }
        }
        if (this.WC != null && i >= 0) {
            this.WC.setSelection(i);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.view.a p = android.support.v7.view.a.p(getContext());
        TypedArray obtainStyledAttributes = p.mContext.obtainStyledAttributes(null, k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(k.ActionBar_height, 0);
        Resources resources = p.mContext.getResources();
        if (!p.df()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        this.Mq = layoutDimension;
        requestLayout();
        this.WF = p.mContext.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.WA != null) {
            post(this.WA);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.WA != null) {
            removeCallbacks(this.WA);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
