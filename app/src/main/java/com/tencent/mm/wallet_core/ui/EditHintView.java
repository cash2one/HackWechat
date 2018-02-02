package com.tencent.mm.wallet_core.ui;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.z.q;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;

@Deprecated
public class EditHintView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private int gravity;
    private OnFocusChangeListener imO;
    private TextView imP;
    private ImageView imR;
    private String imS;
    private String imT;
    private int imU;
    private int imV;
    public boolean imW;
    private boolean imY;
    private int imZ;
    private int imeOptions;
    private int ina;
    private OnClickListener inc;
    private int inputType;
    private int mode;
    private boolean pCs;
    public boolean yiT;
    private b zID;
    private TextView zIE;
    TenpaySecureEditText zIF;
    private int zIG;
    private int zIH;
    private int zII;
    private boolean zIJ;
    private String zIK;
    private DatePickerDialog zIL;
    private int zIM;
    private int zIN;
    private i zIO;
    private a zIP;

    static /* synthetic */ void o(EditHintView editHintView) {
        int cBE;
        int cBF;
        switch (editHintView.imU) {
            case 3:
                editHintView.getContext();
                cBE = u.cBE();
                editHintView.getContext();
                cBF = u.cBF();
                break;
            case 4:
                editHintView.getContext();
                cBE = u.cBG();
                cBF = a.i.uIU;
                break;
            case 9:
                cBE = g.uFF;
                cBF = a.i.uQA;
                break;
            case 10:
                cBE = g.uFk;
                cBF = a.i.uQv;
                break;
            default:
                cBF = -1;
                cBE = -1;
                break;
        }
        if (cBE != -1) {
            if (editHintView.zIO == null) {
                editHintView.zIO = b.a(editHintView.getContext(), cBE, editHintView.getResources().getString(cBF), editHintView.getResources().getString(a.i.uRP), new 8(editHintView));
            }
            editHintView.zIO.show();
        }
    }

    public EditHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.imS = "";
        this.imT = "";
        this.inputType = 1;
        this.pCs = true;
        this.ina = -1;
        this.imZ = 1;
        this.gravity = 19;
        this.zIG = -1;
        this.imU = -1;
        this.imY = false;
        this.zIH = 1;
        this.zII = -1;
        this.background = -1;
        this.imV = -1;
        this.imW = true;
        this.yiT = true;
        this.zIJ = true;
        this.zIK = null;
        this.mode = 0;
        this.zIL = null;
        this.zIM = 0;
        this.zIN = 0;
        this.inc = new 7(this);
        this.zIO = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.uYD, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(k.uYK, 0);
        if (resourceId != 0) {
            this.imS = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(k.uYL, 0);
        if (resourceId != 0) {
            this.imT = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(k.uYI, 1);
        this.imW = obtainStyledAttributes.getBoolean(k.uYP, true);
        this.gravity = obtainStyledAttributes.getInt(k.uYE, 19);
        this.pCs = obtainStyledAttributes.getBoolean(k.uYG, true);
        this.ina = obtainStyledAttributes.getInteger(k.uYQ, -1);
        this.imU = obtainStyledAttributes.getInteger(k.uYM, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(k.uYJ, 5);
        this.zII = obtainStyledAttributes.getColor(k.uYN, c.black);
        this.background = obtainStyledAttributes.getResourceId(k.uYF, -1);
        this.imV = obtainStyledAttributes.getResourceId(k.uYO, e.ucD);
        this.imZ = obtainStyledAttributes.getInteger(k.uYR, 1);
        this.yiT = obtainStyledAttributes.getBoolean(k.uYH, true);
        obtainStyledAttributes.recycle();
        View inflate = v.fv(context).inflate(g.uBQ, this, true);
        this.zIF = (TenpaySecureEditText) inflate.findViewById(f.coA);
        this.imP = (TextView) inflate.findViewById(f.cRV);
        this.zIE = (TextView) inflate.findViewById(f.utE);
        this.imR = (ImageView) inflate.findViewById(f.cpN);
        this.zIF.setImeOptions(this.imeOptions);
        switch (this.imU) {
            case 0:
                break;
            case 1:
                this.ina = 25;
                this.zIF.setIsBankcardFormat(true);
                this.inputType = 2;
                break;
            case 2:
            case 9:
                this.ina = 30;
                this.inputType = 3;
                break;
            case 3:
                this.imW = false;
                this.zIF.setIsValidThru(true);
                setOnClickListener(new 6(this));
                break;
            case 4:
                this.ina = 4;
                this.inputType = 2;
                break;
            case 5:
                this.ina = 18;
                this.inputType = 4;
                break;
            case 6:
                this.ina = 6;
                this.imP.setVisibility(8);
                this.inputType = 2;
                break;
            case 7:
            case 17:
                this.ina = 6;
                this.imP.setVisibility(8);
                this.zIF.setIsPasswordFormat(true);
                this.zIF.setImeOptions(6);
                this.inputType = FileUtils.S_IWUSR;
                break;
            case 8:
                this.inputType = 32;
                break;
            case 10:
                if (!this.imW && this.pCs) {
                    break;
                }
            case 12:
                this.ina = 12;
                this.zIF.setIsMoneyAmountFormat(true);
                break;
            case 13:
            case 16:
                this.zIF.setIsSecurityAnswerFormat(true);
                break;
            case 14:
                this.ina = 3;
                this.imP.setVisibility(8);
                this.zIF.setIsCvvPaymentFormat(true);
                this.zIF.setImeOptions(6);
                this.inputType = FileUtils.S_IWUSR;
                break;
            case 15:
                this.ina = 4;
                this.imP.setVisibility(8);
                this.zIF.setIsCvv4PaymentFormat(true);
                this.zIF.setImeOptions(6);
                this.inputType = FileUtils.S_IWUSR;
                break;
            default:
                this.inputType = 1;
                break;
        }
        cBU();
        this.zIF.setSingleLine(this.yiT);
        if (!this.yiT) {
            this.zIF.setMaxLines(1073741823);
        }
        this.imR.setOnClickListener(this.inc);
        this.zIF.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ EditHintView zIQ;

            {
                this.zIQ = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.zIQ.mode == 4 && this.zIQ.XO()) {
                    this.zIQ.mode = 0;
                    this.zIQ.zIF.ClearInput();
                }
            }

            public final void afterTextChanged(Editable editable) {
                boolean XO = this.zIQ.XO();
                if (!(XO == this.zIQ.imY || this.zIQ.zID == null)) {
                    x.d("MicroMsg.EditHintView", "View:" + this.zIQ.imT + ", editType:" + this.zIQ.imU + " inputValid change to " + XO);
                    this.zIQ.imY = XO;
                }
                this.zIQ.cBU();
            }
        });
        this.zIF.setOnFocusChangeListener(this);
        if (!bh.ov(this.imS)) {
            this.zIF.setHint(this.imS);
        }
        if (!bh.ov(this.imT)) {
            this.imP.setText(this.imT);
        }
        this.zIF.setGravity(this.gravity);
        if (this.inputType == 2) {
            this.zIF.setKeyListener(new 2(this));
        } else if (this.inputType == 4) {
            this.zIF.setKeyListener(new 3(this));
        } else if (this.inputType == FileUtils.S_IWUSR) {
            this.zIF.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.zIF.setKeyListener(new 4(this));
            this.zIF.setRawInputType(18);
        } else if (this.inputType == 3) {
            this.zIF.setKeyListener(new 5(this));
        } else {
            this.zIF.setInputType(this.inputType);
        }
        if (this.ina != -1) {
            this.zIF.setFilters(new InputFilter[]{new LengthFilter(this.ina)});
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.pCs) {
            this.zIF.setEnabled(false);
            this.zIF.setTextColor(getResources().getColor(this.zII));
            this.zIF.setFocusable(false);
            this.zIF.setClickable(false);
            this.zIF.setBackgroundResource(e.bHb);
            setBackgroundResource(e.bDp);
        }
        if (this.imW) {
            this.imY = false;
            this.zIF.setBackgroundResource(this.imV);
            setBackgroundResource(e.bHb);
        } else {
            this.imY = true;
            this.zIF.setEnabled(false);
            this.zIF.setTextColor(getResources().getColor(c.bte));
            this.zIF.setFocusable(false);
            this.zIF.setClickable(false);
            this.zIF.setBackgroundResource(e.bHb);
            setBackgroundResource(e.bBx);
        }
        if (this.background > 0) {
            setBackgroundResource(this.background);
        }
        if (!(this.imP == null || this.zIG == -1)) {
            LayoutParams layoutParams = this.imP.getLayoutParams();
            layoutParams.width = this.zIG;
            this.imP.setLayoutParams(layoutParams);
        }
        if (q.Gf()) {
            int i2;
            TenpaySecureEditText tenpaySecureEditText = this.zIF;
            switch (this.imU) {
                case 1:
                    i2 = 50;
                    break;
                case 4:
                case 14:
                case 15:
                    i2 = 30;
                    break;
                case 6:
                    i2 = 60;
                    break;
                case 7:
                    i2 = 20;
                    break;
                case 13:
                    i2 = 40;
                    break;
                case 16:
                    i2 = -20;
                    break;
                case 17:
                    i2 = -10;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            tenpaySecureEditText.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i2));
        }
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onMeasure(int i, int i2) {
        if (this.imU == 7 || this.imU == 17 || this.imU == 14 || this.imU == 15) {
            int i3;
            setMeasuredDimension(getDefaultSize(b.b(getContext(), 960.0f), i), getDefaultSize(b.b(getContext(), 720.0f), i2));
            int measuredWidth = getMeasuredWidth();
            if (this.imU == 7 || this.imU == 17) {
                i3 = measuredWidth / 6;
            } else if (this.imU == 14) {
                i3 = measuredWidth / 3;
            } else {
                i3 = measuredWidth / 4;
            }
            i = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            setMeasuredDimension(getDefaultSize(measuredWidth, i), getDefaultSize(i3, i2));
        }
        super.onMeasure(i, i2);
    }

    public final String getText() {
        TenpaySecureEditText tenpaySecureEditText;
        switch (this.imU) {
            case 0:
            case 8:
            case 10:
                return bh.az(this.zIF.getText().toString(), "");
            case 1:
            case 13:
            case 16:
                tenpaySecureEditText = this.zIF;
                com.tencent.mm.wallet_core.b.cBf();
                return tenpaySecureEditText.getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.cBg());
            case 2:
            case 9:
                return bh.az(this.zIF.getText().toString(), "");
            case 3:
                return bh.az(this.zIK, "").replace("/", "");
            case 4:
            case 14:
            case 15:
                return this.zIF.get3DesEncrptData();
            case 5:
                return this.zIF.get3DesEncrptData();
            case 6:
                return this.zIF.get3DesVerifyCode();
            case 7:
                tenpaySecureEditText = this.zIF;
                com.tencent.mm.wallet_core.b.cBf();
                return tenpaySecureEditText.getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.cBg());
            default:
                return bh.az(this.zIF.getText().toString(), "");
        }
    }

    public final boolean XO() {
        if (!this.imW && !this.pCs) {
            return true;
        }
        switch (this.imU) {
            case 1:
                return this.zIF.isBankcardNum();
            case 4:
                if (this.zIF.getInputLength() <= 0) {
                    return false;
                }
                return true;
            case 5:
                return this.zIF.isAreaIDCardNum(this.zIH);
            case 7:
            case 17:
                if (this.zIF.getInputLength() != 6) {
                    return false;
                }
                return true;
            case 8:
                return bh.Vt(this.zIF.getText().toString());
            case 9:
                return this.zIF.isPhoneNum();
            case 12:
                return this.zIF.isMoneyAmount();
            case 14:
                if (this.zIF.getInputLength() != 3) {
                    return false;
                }
                return true;
            case 15:
                if (this.zIF.getInputLength() != 4) {
                    return false;
                }
                return true;
            default:
                if (this.zIF.getInputLength() < this.imZ) {
                    return false;
                }
                return true;
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.imW = z;
        this.imR.setEnabled(true);
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.pCs = z;
        if (z) {
            this.zIF.setEnabled(true);
            if (this.imW) {
                this.zIF.setTextColor(getResources().getColor(this.zII));
            } else {
                this.zIF.setTextColor(getResources().getColor(c.bte));
            }
            this.zIF.setFocusable(true);
            this.zIF.setClickable(true);
            return;
        }
        this.zIF.setEnabled(false);
        if (this.imW) {
            this.zIF.setTextColor(getResources().getColor(this.zII));
        } else {
            this.zIF.setTextColor(getResources().getColor(c.btc));
        }
        this.zIF.setFocusable(false);
        this.zIF.setClickable(false);
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

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.imO = onFocusChangeListener;
    }

    private void cBU() {
        if (this.imU != 7 && this.imU != 14 && this.imU != 15) {
            if (!this.imW || bh.ov(getText())) {
                switch (this.imU) {
                    case 1:
                        if (this.zIJ) {
                            this.imR.setVisibility(0);
                            this.imR.setImageResource(h.uGK);
                            return;
                        }
                        this.imR.setVisibility(8);
                        return;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                        this.imR.setVisibility(0);
                        this.imR.setImageResource(e.udu);
                        return;
                    default:
                        this.imR.setVisibility(8);
                        return;
                }
            }
            this.imR.setVisibility(0);
            this.imR.setImageResource(e.bDo);
        }
    }

    public void onFocusChange(View view, boolean z) {
        if (this.imO != null) {
            this.imO.onFocusChange(this, z);
        }
        x.d("MicroMsg.EditHintView", "View:" + this.imT + ", editType:" + this.imU + " onFocusChange to " + z);
        if (this.imY) {
            this.imP.setEnabled(true);
        } else {
            this.imP.setEnabled(false);
        }
    }
}
