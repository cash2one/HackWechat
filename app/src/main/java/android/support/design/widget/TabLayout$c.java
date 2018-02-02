package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.f;
import android.support.design.widget.TabLayout.b;
import android.support.v4.view.z;
import android.support.v4.widget.r;
import android.support.v7.app.ActionBar.a;
import android.support.v7.widget.h;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class TabLayout$c extends LinearLayout implements OnLongClickListener {
    private View kK;
    private b kN;
    private TextView kO;
    private ImageView kP;
    private TextView kQ;
    private ImageView kR;
    private int kS = 2;
    final /* synthetic */ TabLayout kv;

    static /* synthetic */ void a(TabLayout$c tabLayout$c, b bVar) {
        if (bVar != tabLayout$c.kN) {
            tabLayout$c.kN = bVar;
            tabLayout$c.update();
        }
    }

    public TabLayout$c(TabLayout tabLayout, Context context) {
        this.kv = tabLayout;
        super(context);
        if (TabLayout.a(tabLayout) != 0) {
            setBackgroundDrawable(h.ey().a(context, TabLayout.a(tabLayout), false));
        }
        z.c(this, TabLayout.b(tabLayout), TabLayout.c(tabLayout), TabLayout.d(tabLayout), TabLayout.e(tabLayout));
        setGravity(17);
        setOrientation(1);
        setClickable(true);
    }

    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (this.kN == null) {
            return performClick;
        }
        this.kN.select();
        return true;
    }

    public final void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
            if (this.kO != null) {
                this.kO.setSelected(z);
            }
            if (this.kP != null) {
                this.kP.setSelected(z);
            }
        }
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(a.class.getName());
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(a.class.getName());
    }

    public final void onMeasure(int i, int i2) {
        int i3 = 1;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int f = TabLayout.f(this.kv);
        if (f > 0 && (mode == 0 || size > f)) {
            i = MeasureSpec.makeMeasureSpec(TabLayout.g(this.kv), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.kO != null) {
            getResources();
            float h = TabLayout.h(this.kv);
            size = this.kS;
            if (this.kP != null && this.kP.getVisibility() == 0) {
                size = 1;
            } else if (this.kO != null && this.kO.getLineCount() > 1) {
                h = TabLayout.i(this.kv);
            }
            float textSize = this.kO.getTextSize();
            int lineCount = this.kO.getLineCount();
            int c = r.c(this.kO);
            if (h != textSize || (c >= 0 && size != c)) {
                if (TabLayout.j(this.kv) == 1 && h > textSize && lineCount == 1) {
                    Layout layout = this.kO.getLayout();
                    if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    this.kO.setTextSize(0, h);
                    this.kO.setMaxLines(size);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    final void update() {
        b bVar = this.kN;
        View view = bVar != null ? bVar.kK : null;
        if (view != null) {
            TabLayout$c parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(view);
                }
                addView(view);
            }
            this.kK = view;
            if (this.kO != null) {
                this.kO.setVisibility(8);
            }
            if (this.kP != null) {
                this.kP.setVisibility(8);
                this.kP.setImageDrawable(null);
            }
            this.kQ = (TextView) view.findViewById(16908308);
            if (this.kQ != null) {
                this.kS = r.c(this.kQ);
            }
            this.kR = (ImageView) view.findViewById(16908294);
        } else {
            if (this.kK != null) {
                removeView(this.kK);
                this.kK = null;
            }
            this.kQ = null;
            this.kR = null;
        }
        if (this.kK == null) {
            if (this.kP == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(f.bu, this, false);
                addView(imageView, 0);
                this.kP = imageView;
            }
            if (this.kO == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(f.bv, this, false);
                addView(textView);
                this.kO = textView;
                this.kS = r.c(this.kO);
            }
            this.kO.setTextAppearance(getContext(), TabLayout.k(this.kv));
            if (TabLayout.l(this.kv) != null) {
                this.kO.setTextColor(TabLayout.l(this.kv));
            }
            a(this.kO, this.kP);
        } else if (this.kQ != null || this.kR != null) {
            a(this.kQ, this.kR);
        }
    }

    private void a(TextView textView, ImageView imageView) {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z;
        Drawable drawable = this.kN != null ? this.kN.jY : null;
        if (this.kN != null) {
            charSequence = this.kN.mText;
        } else {
            charSequence = null;
        }
        if (this.kN != null) {
            charSequence2 = this.kN.kJ;
        } else {
            charSequence2 = null;
        }
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(charSequence2);
        }
        if (TextUtils.isEmpty(charSequence)) {
            z = false;
        } else {
            z = true;
        }
        if (textView != null) {
            if (z) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText(null);
            }
            textView.setContentDescription(charSequence2);
        }
        if (imageView != null) {
            int a;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
            if (z && imageView.getVisibility() == 0) {
                a = TabLayout.a(this.kv, 8);
            } else {
                a = 0;
            }
            if (a != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = a;
                imageView.requestLayout();
            }
        }
        if (z || TextUtils.isEmpty(charSequence2)) {
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
        Toast makeText = Toast.makeText(context, this.kN.kJ, 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }
}
