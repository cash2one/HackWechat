package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v7.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup {
    private final ImageView OA;
    private final int OB;
    d OC;
    private final DataSetObserver OD;
    private final OnGlobalLayoutListener OE;
    private ListPopupWindow OF;
    private OnDismissListener OG;
    boolean OH;
    int OI;
    private int OJ;
    private final a Ot;
    private final b Ou;
    private final LinearLayoutCompat Ov;
    private final Drawable Ow;
    private final FrameLayout Ox;
    private final ImageView Oy;
    private final FrameLayout Oz;
    boolean hq;

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.Ot.getCount() > 0) {
            activityChooserView.Ox.setEnabled(true);
        } else {
            activityChooserView.Ox.setEnabled(false);
        }
        int ef = activityChooserView.Ot.OL.ef();
        int historySize = activityChooserView.Ot.OL.getHistorySize();
        if (ef == 1 || (ef > 1 && historySize > 0)) {
            activityChooserView.Oz.setVisibility(0);
            ResolveInfo eg = activityChooserView.Ot.OL.eg();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.OA.setImageDrawable(eg.loadIcon(packageManager));
            if (activityChooserView.OJ != 0) {
                CharSequence loadLabel = eg.loadLabel(packageManager);
                activityChooserView.Oz.setContentDescription(activityChooserView.getContext().getString(activityChooserView.OJ, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.Oz.setVisibility(8);
        }
        if (activityChooserView.Oz.getVisibility() == 0) {
            activityChooserView.Ov.setBackgroundDrawable(activityChooserView.Ow);
        } else {
            activityChooserView.Ov.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OD = new 1(this);
        this.OE = new 2(this);
        this.OI = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActivityChooserView, i, 0);
        this.OI = obtainStyledAttributes.getInt(k.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(k.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.abc_activity_chooser_view, this, true);
        this.Ou = new b(this, (byte) 0);
        this.Ov = (LinearLayoutCompat) findViewById(f.activity_chooser_view_content);
        this.Ow = this.Ov.getBackground();
        this.Oz = (FrameLayout) findViewById(f.default_activity_button);
        this.Oz.setOnClickListener(this.Ou);
        this.Oz.setOnLongClickListener(this.Ou);
        this.OA = (ImageView) this.Oz.findViewById(f.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.expand_activities_button);
        frameLayout.setOnClickListener(this.Ou);
        frameLayout.setOnTouchListener(new 3(this, frameLayout));
        this.Ox = frameLayout;
        this.Oy = (ImageView) frameLayout.findViewById(f.image);
        this.Oy.setImageDrawable(drawable);
        this.Ot = new a(this, (byte) 0);
        this.Ot.registerDataSetObserver(new 4(this));
        Resources resources = context.getResources();
        this.OB = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    }

    final void aL(int i) {
        if (this.Ot.OL == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.OE);
        boolean z = this.Oz.getVisibility() == 0;
        int ef = this.Ot.OL.ef();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || ef <= r3 + i) {
            this.Ot.K(false);
            this.Ot.aM(i);
        } else {
            this.Ot.K(true);
            this.Ot.aM(i - 1);
        }
        ListPopupWindow ep = ep();
        if (!ep.SK.isShowing()) {
            if (this.OH || !z) {
                this.Ot.d(true, z);
            } else {
                this.Ot.d(false, false);
            }
            ep.setContentWidth(Math.min(this.Ot.eq(), this.OB));
            ep.show();
            if (this.OC != null) {
                this.OC.o(true);
            }
            ep.SL.setContentDescription(getContext().getString(i.abc_activitychooserview_choose_application));
        }
    }

    public final boolean en() {
        if (ep().SK.isShowing()) {
            ep().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.OE);
            }
        }
        return true;
    }

    public final boolean eo() {
        return ep().SK.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.Ot.OL;
        if (dVar != null) {
            dVar.registerObserver(this.OD);
        }
        this.hq = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.Ot.OL;
        if (dVar != null) {
            dVar.unregisterObserver(this.OD);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.OE);
        }
        if (eo()) {
            en();
        }
        this.hq = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.Ov;
        if (this.Oz.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Ov.layout(0, 0, i3 - i, i4 - i2);
        if (!eo()) {
            en();
        }
    }

    private ListPopupWindow ep() {
        if (this.OF == null) {
            this.OF = new ListPopupWindow(getContext());
            this.OF.setAdapter(this.Ot);
            this.OF.SW = this;
            this.OF.setModal(true);
            this.OF.SY = this.Ou;
            this.OF.setOnDismissListener(this.Ou);
        }
        return this.OF;
    }
}
