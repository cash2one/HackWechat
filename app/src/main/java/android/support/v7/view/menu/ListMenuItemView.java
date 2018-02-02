package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.menu.m.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements a {
    private LayoutInflater DF;
    private TextView FN;
    private RadioButton KQ;
    private CheckBox KR;
    private TextView KS;
    private Drawable KT;
    private Context KU;
    boolean KV;
    private int KW;
    boolean KX;
    private h eb;
    private int ei;
    private ImageView kP;
    private Context mContext;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.MenuView, i, 0);
        this.KT = obtainStyledAttributes.getDrawable(k.MenuView_android_itemBackground);
        this.ei = obtainStyledAttributes.getResourceId(k.MenuView_android_itemTextAppearance, -1);
        this.KV = obtainStyledAttributes.getBoolean(k.MenuView_preserveIconSpacing, false);
        this.KU = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.KT);
        this.FN = (TextView) findViewById(f.title);
        if (this.ei != -1) {
            this.FN.setTextAppearance(this.KU, this.ei);
        }
        this.KS = (TextView) findViewById(f.shortcut);
    }

    public final void a(h hVar) {
        int i;
        boolean z;
        this.eb = hVar;
        this.KW = 0;
        setVisibility(hVar.isVisible() ? 0 : 8);
        CharSequence a = hVar.a((a) this);
        if (a != null) {
            this.FN.setText(a);
            if (this.FN.getVisibility() != 0) {
                this.FN.setVisibility(0);
            }
        } else if (this.FN.getVisibility() != 8) {
            this.FN.setVisibility(8);
        }
        boolean isCheckable = hVar.isCheckable();
        if (!(!isCheckable && this.KQ == null && this.KR == null)) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.eb.dH()) {
                if (this.KQ == null) {
                    this.KQ = (RadioButton) dr().inflate(h.abc_list_menu_item_radio, this, false);
                    addView(this.KQ);
                }
                compoundButton = this.KQ;
                compoundButton2 = this.KR;
            } else {
                if (this.KR == null) {
                    this.KR = (CheckBox) dr().inflate(h.abc_list_menu_item_checkbox, this, false);
                    addView(this.KR);
                }
                compoundButton = this.KR;
                compoundButton2 = this.KQ;
            }
            if (isCheckable) {
                compoundButton.setChecked(this.eb.isChecked());
                int i2 = isCheckable ? 0 : 8;
                if (compoundButton.getVisibility() != i2) {
                    compoundButton.setVisibility(i2);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility() == 8)) {
                    compoundButton2.setVisibility(8);
                }
            } else {
                if (this.KR != null) {
                    this.KR.setVisibility(8);
                }
                if (this.KQ != null) {
                    this.KQ.setVisibility(8);
                }
            }
        }
        boolean dG = hVar.dG();
        hVar.dF();
        if (dG && this.eb.dG()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            TextView textView = this.KS;
            char dF = this.eb.dF();
            if (dF == '\u0000') {
                a = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(h.LL);
                switch (dF) {
                    case '\b':
                        stringBuilder.append(h.LN);
                        break;
                    case '\n':
                        stringBuilder.append(h.LM);
                        break;
                    case ' ':
                        stringBuilder.append(h.LO);
                        break;
                    default:
                        stringBuilder.append(dF);
                        break;
                }
                a = stringBuilder.toString();
            }
            textView.setText(a);
        }
        if (this.KS.getVisibility() != i) {
            this.KS.setVisibility(i);
        }
        Drawable icon = hVar.getIcon();
        if (this.eb.eg.Lu || this.KX) {
            z = true;
        } else {
            z = false;
        }
        if ((z || this.KV) && !(this.kP == null && icon == null && !this.KV)) {
            if (this.kP == null) {
                this.kP = (ImageView) dr().inflate(h.abc_list_menu_item_icon, this, false);
                addView(this.kP, 0);
            }
            if (icon != null || this.KV) {
                this.kP.setImageDrawable(z ? icon : null);
                if (this.kP.getVisibility() != 0) {
                    this.kP.setVisibility(0);
                }
            } else {
                this.kP.setVisibility(8);
            }
        }
        setEnabled(hVar.isEnabled());
    }

    public final h B() {
        return this.eb;
    }

    protected void onMeasure(int i, int i2) {
        if (this.kP != null && this.KV) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kP.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public final boolean C() {
        return false;
    }

    private LayoutInflater dr() {
        if (this.DF == null) {
            this.DF = LayoutInflater.from(this.mContext);
        }
        return this.DF;
    }
}
