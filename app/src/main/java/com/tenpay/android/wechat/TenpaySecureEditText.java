package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.EditText;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;
import com.tenpay.ndk.Encrypt;
import java.util.regex.Pattern;

public final class TenpaySecureEditText extends EditText {
    public static final int AREA_ID_CARD_TYPE_HUIXIANG = 5;
    public static final int AREA_ID_CARD_TYPE_SHENFEN = 1;
    public static final int AREA_ID_CARD_TYPE_TAIBAO = 9;
    private static int BANK_CARD_LENGTH_LIMIT = 14;
    private static int CARD_TAIL_SPACE = 15;
    private static int CVV_4_PAYMENT_LENGTH = 4;
    private static int CVV_PAYMENT_LENGTH = 3;
    private static int PASSWD_BLACK_DOT_SIZE = 7;
    private static int PASSWD_LEFT_PADDING = -1500000;
    private static int PASSWD_LENGTH = 6;
    private static int VALID_THRU_LEN = 4;
    private static String mTimeStamp;
    private String mCardTailNum;
    private Drawable mClearBtnImg;
    private float mDensity;
    EditState mEditState;
    private char[] mFilterChar;
    private Paint mIDCardPaint;
    private ISecureEncrypt mIEncrypt;
    private boolean mIsCardTailNumCanDisplay;
    private boolean mIsSelfSet;
    private Paint mPaintBackground;
    private OnPasswdInputListener mPasswdListener;
    private Paint mTitlePaint;

    public enum EditState {
        DEFAULT,
        PASSWORD,
        BANKCARD,
        BANKCARD_WITH_TAILNUM,
        VALID_THRU,
        MONEY_AMOUNT,
        CVV_PAYMENT,
        CVV_4_PAYMENT,
        SECURITY_ANSWER,
        IDCARD_TAIL
    }

    public TenpaySecureEditText(Context context) {
        this(context, null);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEditState = EditState.DEFAULT;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEditState = EditState.DEFAULT;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mDensity = getResources().getDisplayMetrics().density;
        if (attributeSet != null) {
            int[] resourceDeclareStyleableIntArray = TenpayUtil.getResourceDeclareStyleableIntArray(context, "TenpaySecureEditText");
            if (resourceDeclareStyleableIntArray != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, resourceDeclareStyleableIntArray);
                if (obtainStyledAttributes != null) {
                    setIsPasswordFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isPassword"), false));
                    setIsBankcardFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isBankcard"), false));
                    setIsValidThru(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isValidThru"), false));
                    setBankcardTailNum(obtainStyledAttributes.getString(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_bankcardTailNum")));
                    int resourceId = obtainStyledAttributes.getResourceId(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_rightClearDrawable"), 0);
                    if (resourceId != 0) {
                        setClearBtnDrawableId(resourceId);
                    }
                    obtainStyledAttributes.recycle();
                }
            }
        }
        addTextChangedListener(new 1(this));
        if (VERSION.SDK_INT >= 14) {
            setAccessibilityDelegate(new TenpayAccessibilityDelegate());
        }
    }

    public final void setClearBtnDrawableId(int i) {
        try {
            this.mClearBtnImg = getResources().getDrawable(i);
        } catch (Exception e) {
            this.mClearBtnImg = null;
        }
        if (this.mClearBtnImg != null) {
            this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
            setOnFocusChangeListener(new 2(this));
            setOnTouchListener(new 3(this));
            return;
        }
        setOnFocusChangeListener(new 4(this));
        setOnTouchListener(new 5(this));
    }

    public final EditState getEditState() {
        return this.mEditState;
    }

    public final void setIsPasswordFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(WebView.NIGHT_MODE_COLOR);
            this.mEditState = EditState.PASSWORD;
            return;
        }
        this.mPaintBackground = null;
        if (EditState.PASSWORD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsSecurityAnswerFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.SECURITY_ANSWER;
        } else {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsIdCardTailFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mEditState = EditState.IDCARD_TAIL;
            this.mIDCardPaint = new Paint();
            this.mIDCardPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mIDCardPaint.setTextAlign(Align.CENTER);
            this.mIDCardPaint.setAntiAlias(true);
            this.mIDCardPaint.setTextSize(getTextSize());
            this.mIDCardPaint.setColor(WebView.NIGHT_MODE_COLOR);
            return;
        }
        this.mEditState = EditState.DEFAULT;
    }

    public final void setIsCvvPaymentFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(WebView.NIGHT_MODE_COLOR);
            this.mEditState = EditState.CVV_PAYMENT;
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsCvv4PaymentFormat(boolean z) {
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(WebView.NIGHT_MODE_COLOR);
            this.mEditState = EditState.CVV_4_PAYMENT;
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_4_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsValidThru(boolean z) {
        if (z) {
            this.mEditState = EditState.VALID_THRU;
        } else if (EditState.VALID_THRU == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setValidThru(String str) {
        if (str != null && str.length() == VALID_THRU_LEN) {
            setText(str);
            this.mEditState = EditState.VALID_THRU;
        }
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setBankcardTailNum(String str) {
        this.mCardTailNum = str;
        if (str != null && str.length() > 0) {
            this.mEditState = EditState.BANKCARD_WITH_TAILNUM;
            this.mTitlePaint = new Paint();
            this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mTitlePaint.setAntiAlias(true);
            this.mTitlePaint.setTextSize(getTextSize());
            this.mTitlePaint.setColor(WebView.NIGHT_MODE_COLOR);
        }
    }

    public final void setIsMoneyAmountFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.MONEY_AMOUNT;
        } else if (EditState.MONEY_AMOUNT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setFilterChar(char[] cArr) {
        this.mFilterChar = cArr;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.mEditState == EditState.IDCARD_TAIL) {
            drawIdCardTail(canvas);
        } else if (this.mEditState == EditState.PASSWORD || this.mEditState == EditState.CVV_PAYMENT || this.mEditState == EditState.CVV_4_PAYMENT) {
            drawPasswdDot(canvas);
            drawCvvPaymentDot(canvas);
            drawCvv4PaymentDot(canvas);
        } else {
            super.onDraw(canvas);
            drawCardTailNum(canvas);
        }
    }

    private void drawIdCardTail(Canvas canvas) {
        if (EditState.IDCARD_TAIL == this.mEditState && this.mIDCardPaint != null) {
            int width = getWidth() / 4;
            String obj = getText().toString();
            int length = obj.length();
            this.mIDCardPaint.setTextSize(getTextSize());
            for (int i = 0; i < length; i++) {
                canvas.drawText(obj.substring(i, i + 1), (float) ((width / 2) + (i * width)), (float) getBaseline(), this.mIDCardPaint);
            }
        }
    }

    private void drawPasswdDot(Canvas canvas) {
        if (EditState.PASSWORD == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / PASSWD_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
    }

    private void drawCvvPaymentDot(Canvas canvas) {
        if (EditState.CVV_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / CVV_PAYMENT_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
    }

    private void drawCvv4PaymentDot(Canvas canvas) {
        if (EditState.CVV_4_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / CVV_4_PAYMENT_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
    }

    private void drawCardTailNum(Canvas canvas) {
        if (EditState.BANKCARD_WITH_TAILNUM == this.mEditState && this.mIsCardTailNumCanDisplay) {
            int baseline = getBaseline();
            if (baseline == -1) {
                baseline = 44;
            }
            canvas.drawText(this.mCardTailNum, (((float) CARD_TAIL_SPACE) * this.mDensity) + getPaint().measureText(getText().toString()), (float) baseline, this.mTitlePaint);
        }
    }

    public final boolean onTextContextMenuItem(int i) {
        if ((getInputType() & FileUtils.S_IWUSR) > 0 || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState || this.mEditState == EditState.IDCARD_TAIL) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    protected final void onCreateContextMenu(ContextMenu contextMenu) {
        if ((getInputType() & FileUtils.S_IWUSR) <= 0 && EditState.PASSWORD != this.mEditState && EditState.CVV_PAYMENT != this.mEditState && EditState.CVV_4_PAYMENT != this.mEditState) {
            super.onCreateContextMenu(contextMenu);
        }
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        String obj;
        if (this.mEditState == EditState.SECURITY_ANSWER) {
            obj = getText().toString();
        } else {
            obj = getText().toString().trim();
        }
        if (obj == null || obj.length() == 0) {
            return null;
        }
        switch (6.$SwitchMap$com$tenpay$android$wechat$TenpaySecureEditText$EditState[this.mEditState.ordinal()]) {
            case 1:
                return obj.replaceAll(" ", "");
            case 2:
                obj = obj.replaceAll(" ", "");
                if (this.mCardTailNum == null || this.mCardTailNum.length() <= 0) {
                    return obj;
                }
                return obj + this.mCardTailNum;
            case 3:
                obj = obj.replaceAll("/", "");
                if (obj == null || obj.length() != VALID_THRU_LEN) {
                    return obj;
                }
                return obj.substring(2) + obj.substring(0, 2);
            case 4:
                return obj;
            default:
                return obj.replaceAll(" ", "").replaceAll("x", "X");
        }
    }

    public final void setSecureEncrypt(ISecureEncrypt iSecureEncrypt) {
        this.mIEncrypt = iSecureEncrypt;
    }

    public final String getEncryptDataWithHash(boolean z) {
        return getEncryptDataWithHash(z, false);
    }

    public final String getEncryptDataWithHash(boolean z, boolean z2) {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (this.mIEncrypt == null) {
            if (z) {
                inputText = TenpayUtil.md5HexDigest(inputText);
            }
            Encrypt encrypt = new Encrypt();
            if (mTimeStamp != null) {
                encrypt.setTimeStamp(mTimeStamp);
            }
            if (z2) {
                return encrypt.encryptPasswdWithRSA2048(inputText);
            }
            return encrypt.encryptPasswd(inputText);
        } else if (z2) {
            return this.mIEncrypt.encryptPasswdWithRSA2048(z, inputText, mTimeStamp);
        } else {
            return this.mIEncrypt.encryptPasswd(z, inputText, mTimeStamp);
        }
    }

    public final String get3DesEncrptData() {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (this.mIEncrypt != null) {
            return this.mIEncrypt.desedeEncode(inputText, mTimeStamp);
        }
        return new Encrypt().desedeEncode(inputText);
    }

    public final void set3DesEncrptData(String str) {
        if (str != null && str.length() != 0) {
            Encrypt encrypt = new Encrypt();
            setText(encrypt.desedeDecode(str, encrypt.getRandomKey()));
        }
    }

    public final String get3DesVerifyCode() {
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            return null;
        }
        if (this.mIEncrypt != null) {
            return this.mIEncrypt.desedeVerifyCode(inputText, mTimeStamp);
        }
        return new Encrypt().desedeVerifyCode(inputText);
    }

    public final boolean isPhoneNum() {
        if (getText().toString().trim().length() == 11 || getText().toString().contains("**")) {
            return true;
        }
        return false;
    }

    public final boolean isBankcardNum() {
        return getInputLength() >= BANK_CARD_LENGTH_LIMIT || getText().toString().contains("**");
    }

    public final boolean isMoneyAmount() {
        return isMatchPattern("^\\d+(\\.\\d{0,2})?$");
    }

    public final boolean isUserIdNum() {
        String trim = getText().toString().trim();
        if (getInputLength() == 15) {
            return isMatchPattern("^\\d{15}$");
        }
        return TenpayUtil.invalidateID(trim);
    }

    public final boolean isValidThru() {
        return isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
    }

    public final boolean isAreaIDCardNum(int i) {
        String trim = getText().toString().trim();
        if (trim == null || trim.length() == 0) {
            return false;
        }
        trim.replaceAll(" ", "");
        switch (i) {
            case 1:
                return isUserIdNum();
            default:
                return true;
        }
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
            } catch (Exception e) {
            }
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
            } catch (Exception e) {
            }
        }
        return z;
    }

    public final void ClearInput() {
        setText("");
    }

    public final int getInputLength() {
        String inputText = getInputText();
        if (inputText == null) {
            return 0;
        }
        return inputText.length();
    }

    protected final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int length;
        int i5 = 0;
        super.onTextChanged(charSequence, i, i2, i3);
        if (!(this.mFilterChar == null || TextUtils.isEmpty(charSequence))) {
            for (i4 = i; i4 < i + i3; i4++) {
                for (char c : this.mFilterChar) {
                    if (c == charSequence.charAt(i4)) {
                        String charSequence2 = charSequence.toString();
                        setText(charSequence2.substring(0, i4) + charSequence2.substring(i4 + 1));
                        setSelection(i4);
                        return;
                    }
                }
            }
        }
        String obj = getText().toString();
        boolean z = obj != null && obj.length() > 0;
        this.mIsCardTailNumCanDisplay = z;
        if (!(!isFocused() || this.mClearBtnImg == null || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState)) {
            if (getText().toString().equals("")) {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            } else {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
            }
        }
        if (this.mEditState != null) {
            try {
                int length2;
                switch (6.$SwitchMap$com$tenpay$android$wechat$TenpaySecureEditText$EditState[this.mEditState.ordinal()]) {
                    case 1:
                    case 2:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            return;
                        }
                        int i6 = i + i3;
                        if (obj.length() > 0) {
                            if (i6 <= obj.length()) {
                                charSequence2 = obj.substring(0, i6);
                                length2 = charSequence2.length() - charSequence2.replaceAll(" ", "").length();
                            } else {
                                length2 = 0;
                            }
                            charSequence2 = obj.replaceAll(" ", "");
                            StringBuffer stringBuffer = new StringBuffer();
                            i4 = charSequence2.length();
                            while (i5 + 4 < i4) {
                                stringBuffer.append(charSequence2.substring(i5, i5 + 4));
                                stringBuffer.append(" ");
                                i5 += 4;
                            }
                            stringBuffer.append(charSequence2.substring(i5));
                            String stringBuffer2 = stringBuffer.toString();
                            if (i6 <= stringBuffer2.length()) {
                                charSequence2 = stringBuffer2.substring(0, i6);
                                length = charSequence2.length() - charSequence2.replaceAll(" ", "").length();
                            } else {
                                length = stringBuffer2.length() - stringBuffer2.replaceAll(" ", "").length();
                            }
                            length = (length + i6) - length2;
                            this.mIsSelfSet = true;
                            setText(stringBuffer2);
                            setSelection(length);
                            return;
                        }
                        return;
                    case 3:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            return;
                        }
                        i5 = obj.length();
                        if (i5 != 0 && i5 != 1) {
                            CharSequence replace = obj.replace("/", "");
                            if (!(i5 == 2 && obj.contains("/"))) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(replace.substring(0, 2));
                                stringBuilder.append("/");
                                if (replace.length() > 2) {
                                    stringBuilder.append(replace.substring(2));
                                }
                                replace = stringBuilder.toString();
                            }
                            length2 = getSelectionStart();
                            this.mIsSelfSet = true;
                            setText(replace);
                            if (i5 != 2) {
                                setSelection(length2);
                                return;
                            } else if (obj.contains("/")) {
                                setSelection(1);
                                return;
                            } else if (length2 == 2) {
                                setSelection(i3 > i2 ? 3 : 2);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 5:
                        if (obj.length() == PASSWD_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            return;
                        }
                        return;
                    case 6:
                        if (obj.length() == CVV_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            return;
                        }
                        return;
                    case 7:
                        if (obj.length() == CVV_4_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    public final void setOnPasswdInputListener(OnPasswdInputListener onPasswdInputListener) {
        this.mPasswdListener = onPasswdInputListener;
    }
}
