package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class AddrEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    a imM;
    b imN;
    private OnFocusChangeListener imO;
    private TextView imP;
    EditText imQ;
    private ImageView imR;
    private String imS;
    private String imT;
    private int imU;
    private int imV;
    public boolean imW;
    private int imX;
    private boolean imY;
    private int imZ;
    private int imeOptions;
    private int ina;
    private boolean inb;
    private OnClickListener inc;
    private String ind;
    private int inputType;

    public interface a {
        void onClick();
    }

    public interface b {
        void XL();
    }

    public AddrEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.imS = "";
        this.imT = "";
        this.inputType = 1;
        this.gravity = 19;
        this.imU = -1;
        this.background = -1;
        this.imV = -1;
        this.imW = true;
        this.imY = false;
        this.imZ = 1;
        this.ina = 30;
        this.inb = true;
        this.inc = new 4(this);
        this.ind = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZf, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.eZk, 0);
        if (resourceId != 0) {
            this.imS = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.eZl, 0);
        if (resourceId != 0) {
            this.imT = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.eZi, 1);
        this.imU = obtainStyledAttributes.getInteger(R.n.eZm, 0);
        this.imW = obtainStyledAttributes.getBoolean(R.n.eZo, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.eZg, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.eZj, 5);
        this.background = obtainStyledAttributes.getResourceId(R.n.eZh, R.g.bHb);
        this.imX = obtainStyledAttributes.getResourceId(R.n.eZp, -1);
        this.imV = obtainStyledAttributes.getResourceId(R.n.eZn, R.g.bHb);
        this.inb = obtainStyledAttributes.getBoolean(R.n.eZq, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.cZZ, this, true);
        this.imQ = (EditText) inflate.findViewById(R.h.coA);
        this.imQ.setTextSize(0, (float) com.tencent.mm.bv.a.aa(context, R.f.bvK));
        this.imP = (TextView) inflate.findViewById(R.h.cRV);
        this.imR = (ImageView) inflate.findViewById(R.h.cpN);
        this.imR.setOnClickListener(this.inc);
        this.imQ.setImeOptions(this.imeOptions);
        this.imQ.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.imQ.setKeyListener(new 1(this));
        } else if (this.inputType == 3) {
            this.imQ.setKeyListener(new 2(this));
        } else {
            this.imQ.setInputType(this.inputType);
        }
        cj(this.imQ.isFocused());
        this.imQ.addTextChangedListener(new 3(this));
        this.imQ.setOnFocusChangeListener(this);
        if (!bh.ov(this.imS)) {
            this.imQ.setHint(this.imS);
        }
        if (!bh.ov(this.imT)) {
            this.imP.setText(this.imT);
        }
        Rect rect = new Rect();
        b(this.imQ, rect);
        if (this.imW) {
            this.imY = false;
            this.imQ.setBackgroundResource(this.imV);
            setBackgroundResource(this.background);
        } else {
            this.imQ.setEnabled(false);
            this.imQ.setTextColor(getResources().getColor(R.e.brk));
            this.imQ.setFocusable(false);
            this.imQ.setClickable(false);
            this.imQ.setBackgroundResource(R.g.bHb);
            setBackgroundResource(R.g.bBx);
            setPadding(com.tencent.mm.bv.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        c(this.imQ, rect);
        this.imQ.setGravity(this.gravity);
        if (this.imX != -1) {
            this.imR.setImageResource(this.imX);
        }
        if (!this.inb) {
            this.imQ.setSingleLine(false);
        }
    }

    public AddrEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final String getText() {
        return this.imQ.getText().toString();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.imW = z;
        this.imR.setEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.imW) {
            boolean z;
            if (this.imR.getVisibility() == 0) {
                Rect rect = new Rect();
                this.imR.getHitRect(rect);
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
                z = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final boolean XO() {
        String obj = this.imQ.getText().toString();
        switch (this.imU) {
            case 1:
                if (obj.length() >= this.imZ && obj.length() <= this.ina) {
                    if (obj == null) {
                        obj = null;
                    } else {
                        obj = obj.replaceAll("\\D", "");
                        if (obj.startsWith("86")) {
                            obj = obj.substring(2);
                        }
                    }
                    if (PhoneNumberUtils.isGlobalPhoneNumber(obj)) {
                        return true;
                    }
                }
                return false;
            default:
                if (obj.length() >= this.imZ) {
                    return true;
                }
                return false;
        }
    }

    private void cj(boolean z) {
        if (!this.imW || bh.ov(getText())) {
            switch (this.imU) {
                case 0:
                case 1:
                    this.imR.setVisibility(8);
                    return;
                case 2:
                    this.imR.setVisibility(0);
                    this.imR.setImageResource(R.k.dBF);
                    this.imR.setContentDescription(getContext().getString(R.l.dCO));
                    return;
                case 3:
                    this.imR.setVisibility(0);
                    this.imR.setImageResource(R.k.dBG);
                    this.imR.setContentDescription(getContext().getString(R.l.dCY));
                    return;
                default:
                    this.imR.setVisibility(8);
                    return;
            }
        }
        this.imR.setImageResource(R.g.bDo);
        this.imR.setContentDescription(getContext().getString(R.l.bWg));
        switch (this.imU) {
            case 0:
            case 1:
                if (z) {
                    this.imR.setVisibility(0);
                    return;
                } else {
                    this.imR.setVisibility(8);
                    return;
                }
            case 2:
                this.imR.setVisibility(0);
                this.imR.setImageResource(R.k.dBF);
                this.imR.setContentDescription(getContext().getString(R.l.dCO));
                return;
            case 3:
                this.imR.setVisibility(0);
                this.imR.setImageResource(R.k.dBG);
                this.imR.setContentDescription(getContext().getString(R.l.dCY));
                return;
            default:
                this.imR.setVisibility(8);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.imO = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.imO != null) {
            this.imO.onFocusChange(this, z);
        }
        x.d("MicroMsg.AddrEditView", "View:" + this.imT + ", editType:" + this.imU + " onFocusChange to " + z);
        if (this.imN != null) {
            this.imN.XL();
        }
        if (this.imY) {
            this.imP.setEnabled(true);
        } else {
            this.imP.setEnabled(false);
        }
        if (view == this.imQ) {
            Rect rect = new Rect();
            b((View) this, rect);
            if (z) {
                setBackgroundResource(R.g.bDf);
            } else {
                setBackgroundResource(R.g.bDg);
            }
            c(this, rect);
        }
        cj(z);
    }

    public final void oO(String str) {
        this.imQ.setText(str);
        this.imQ.setSelection(this.imQ.getText().length());
        this.ind = str;
    }

    public final boolean XP() {
        if (getText().equals(bh.ou(this.ind))) {
            return false;
        }
        return true;
    }

    private static void b(View view, Rect rect) {
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
    }

    private static void c(View view, Rect rect) {
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
