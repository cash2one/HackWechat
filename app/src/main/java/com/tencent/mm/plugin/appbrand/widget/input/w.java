package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan.Standard;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.bx.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
public abstract class w extends EditText implements d, z {
    InputConnection jYM;
    private Method jYN;
    boolean jYO = false;
    private final b jYP;
    private final Map<com.tencent.mm.plugin.appbrand.widget.input.z.a, Object> jYQ = new android.support.v4.e.a();
    private final Map<OnFocusChangeListener, Object> jYR = new android.support.v4.e.a();
    private final Map<z.b, Object> jYS = new android.support.v4.e.a();
    private final a jYT = new a();
    private final PasswordTransformationMethod jYU = new k();
    final x jYV = new x(this);
    private boolean jYW;
    private int jYX = 0;
    private boolean jYY = false;
    private final int[] jYZ = new int[2];
    volatile int mInputId = -1;

    private final class a implements TextWatcher {
        final /* synthetic */ w jZa;
        final Map<TextWatcher, Object> jZb;

        private a(w wVar) {
            this.jZa = wVar;
            this.jZb = new android.support.v4.e.a();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.a(this.jZa) && !this.jZb.isEmpty()) {
                for (TextWatcher beforeTextChanged : (TextWatcher[]) this.jZb.keySet().toArray(new TextWatcher[this.jZb.size()])) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.a(this.jZa) && !this.jZb.isEmpty()) {
                for (TextWatcher onTextChanged : (TextWatcher[]) this.jZb.keySet().toArray(new TextWatcher[this.jZb.size()])) {
                    onTextChanged.onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void afterTextChanged(Editable editable) {
            if (e.amz()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                String a = w.a(editable, pBool, pInt);
                int i = pInt.value;
                if (pBool.value && !bh.ov(a)) {
                    this.jZa.post(new 1(this, w.a(this.jZa), a, Selection.getSelectionEnd(editable), i));
                    return;
                }
            }
            if (!w.a(this.jZa)) {
                this.jZa.jYX = 0;
                if (!this.jZb.isEmpty()) {
                    for (TextWatcher afterTextChanged : (TextWatcher[]) this.jZb.keySet().toArray(new TextWatcher[this.jZb.size()])) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            }
        }
    }

    protected abstract void amM();

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i = 0;
        while (i < length) {
            String str;
            int codePointAt = obj.codePointAt(i);
            c Dk = com.tencent.mm.bx.b.cgX().Dk(codePointAt);
            if (Dk == null || Dk.xkL == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), Character.toChars(Dk.xkL) + (Dk.xkM != 0 ? Character.toChars(Dk.xkM) : ""));
                pBool.value = true;
                pInt.value++;
            }
            i++;
            obj = str;
        }
        return obj;
    }

    static /* synthetic */ boolean a(w wVar) {
        return wVar.jYX > 0;
    }

    public final int getInputId() {
        return this.mInputId;
    }

    public final void mc(int i) {
        this.mInputId = i;
    }

    public String toString() {
        return String.format(Locale.US, "[%s|%s]", new Object[]{getClass().getSimpleName(), Integer.valueOf(this.mInputId)});
    }

    public final View getView() {
        return this;
    }

    public boolean amL() {
        return true;
    }

    public final b ana() {
        return this.jYP;
    }

    public void r(float f, float f2) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.input.z.a aVar) {
        this.jYQ.put(aVar, this);
    }

    public final void a(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.jYR.put(onFocusChangeListener, this);
        }
    }

    public final void b(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.jYR.remove(onFocusChangeListener);
        }
    }

    public final void a(z.b bVar) {
        this.jYS.put(bVar, this);
    }

    public w(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        md(3);
        setSingleLine(true);
        try {
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(f.ith));
        } catch (Throwable e) {
            x.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[]{bh.i(e)});
        }
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.jYT);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new 1(this));
        try {
            this.jYN = TextView.class.getDeclaredMethod("nullLayouts", new Class[0]);
        } catch (Exception e2) {
        }
        if (amL()) {
            this.jYP = new b(this);
        } else {
            this.jYP = null;
        }
        this.jYW = true;
    }

    public boolean ams() {
        return false;
    }

    private void md(int i) {
        setGravity(((getGravity() & -8388612) & -8388614) | i);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Alignment alignment;
            hint = af.s(hint);
            switch (gravity & 7) {
                case 1:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                case 5:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
            }
            hint.setSpan(new Standard(alignment), 0, getHint().length(), 18);
            super.setHint(hint);
            if (VERSION.SDK_INT >= 17) {
                switch (2.azD[alignment.ordinal()]) {
                    case 1:
                        gravity = 4;
                        break;
                    case 2:
                        gravity = 6;
                        break;
                    default:
                        gravity = 5;
                        break;
                }
                super.setTextAlignment(gravity);
            }
        }
    }

    Editable c(Editable editable) {
        return this.jYV.c(editable);
    }

    public final int me(int i) {
        x.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[]{Integer.valueOf(i), Integer.valueOf(getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())))), getLayout()});
        return getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())));
    }

    public final int anb() {
        return me(getLineCount()) + getPaddingBottom();
    }

    public final void anc() {
        md(3);
    }

    public final void and() {
        md(5);
    }

    public final void ane() {
        md(1);
    }

    public void setSelection(int i) {
        if (getEditableText() != null) {
            super.setSelection(Math.min(i, getEditableText().length()));
        }
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.jYM = super.onCreateInputConnection(editorInfo);
        return this.jYM;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setMinHeight(int i) {
        if (getMinHeight() != i) {
            super.setMinHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        if (getMaxHeight() != i) {
            super.setMaxHeight(i);
        }
    }

    protected final void onMeasure(int i, int i2) {
        x.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i, i2);
        if (!this.jYS.isEmpty()) {
            for (Object obj : this.jYS.keySet().toArray()) {
                z.b bVar = (z.b) obj;
                getMeasuredWidth();
                getMeasuredHeight();
                bVar.amN();
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z, i, i2, i3, i4);
    }

    final void anf() {
        this.jYX++;
    }

    final void ang() {
        this.jYX = Math.max(0, this.jYX - 1);
    }

    public final void r(CharSequence charSequence) {
        anf();
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, BufferType.EDITABLE);
        } else {
            clearComposingText();
            if (TextUtils.isEmpty(charSequence)) {
                editableText.clear();
            } else {
                editableText.replace(0, editableText.length(), charSequence);
            }
        }
        ang();
    }

    public final void r(p pVar) {
        if (this.jYP != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = this.jYP.kad;
            cVar.kao = pVar;
            i l = i.l(pVar);
            i$a com_tencent_mm_plugin_appbrand_widget_input_i_a = cVar.kan;
            if (com_tencent_mm_plugin_appbrand_widget_input_i_a != null && !l.jXn.containsKey(com_tencent_mm_plugin_appbrand_widget_input_i_a)) {
                l.jXn.put(com_tencent_mm_plugin_appbrand_widget_input_i_a, l);
            }
        }
    }

    public final void s(p pVar) {
        if (this.jYP != null) {
            i.l(pVar).a(this.jYP.kad.kan);
        }
    }

    public final void dy(boolean z) {
        this.jYY = z;
    }

    public boolean amO() {
        return this.jYY;
    }

    public void dv(boolean z) {
        anf();
        this.jYO = z;
        setTransformationMethod(z ? this.jYU : null);
        ang();
    }

    public void setInputType(int i) {
        if (getInputType() != i) {
            super.setInputType(i);
        }
    }

    public void setSingleLine(boolean z) {
    }

    public final void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.jYT;
        if (textWatcher != null) {
            aVar.jZb.put(textWatcher, aVar);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.jYT;
        if (textWatcher != null) {
            aVar.jZb.remove(textWatcher);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.jYQ.isEmpty()) {
            for (com.tencent.mm.plugin.appbrand.widget.input.z.a anh : (com.tencent.mm.plugin.appbrand.widget.input.z.a[]) this.jYQ.keySet().toArray(new com.tencent.mm.plugin.appbrand.widget.input.z.a[this.jYQ.size()])) {
                anh.anh();
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            clearComposingText();
        }
        if (z) {
            amM();
        }
        if (!this.jYR.isEmpty()) {
            for (OnFocusChangeListener onFocusChange : (OnFocusChangeListener[]) this.jYR.keySet().toArray(new OnFocusChangeListener[this.jYR.size()])) {
                onFocusChange.onFocusChange(this, z);
            }
        }
    }

    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        super.clearFocus();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (130 == i && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(262144);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        return super.requestFocus(i, rect);
    }

    @Deprecated
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void destroy() {
        this.jYQ.clear();
        this.jYS.clear();
        this.jYR.clear();
        this.jYT.jZb.clear();
        if (this.jYP != null) {
            b bVar = this.jYP;
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = bVar.kad;
            i.l(cVar.kao).a(cVar.kan);
            bVar.kag = null;
            bVar.kab.dismiss();
        }
        setOnFocusChangeListener(null);
    }
}
