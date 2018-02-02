package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Method;

enum af$b {
    ;

    static void c(EditText editText) {
        if (editText != null) {
            af.cd(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 2);
        }
    }

    static void setNoSystemInputOnEditText(EditText editText) {
        if (editText != null) {
            if (VERSION.SDK_INT >= 21) {
                editText.setShowSoftInputOnFocus(false);
                return;
            }
            Class cls = EditText.class;
            try {
                Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                method.setAccessible(true);
                method.invoke(editText, new Object[]{Boolean.valueOf(false)});
                method.setAccessible(false);
            } catch (NoSuchMethodException e) {
                x.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                try {
                    Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                    method2.setAccessible(true);
                    method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
                    method2.setAccessible(false);
                } catch (Throwable e2) {
                    x.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", bh.i(e2));
                    if (editText.getContext() != null && (editText.getContext() instanceof MMActivity)) {
                        ((MMActivity) editText.getContext()).df(editText);
                    }
                }
            } catch (Throwable e22) {
                x.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", bh.i(e22));
            }
        }
    }

    static int a(EditText editText, float f, float f2) {
        if (editText == null) {
            return -1;
        }
        int paddingTop = editText.getPaddingTop();
        Layout layout = editText.getLayout();
        if (layout == null) {
            return -1;
        }
        Editable editableText = editText.getEditableText();
        if (editableText == null) {
            return -1;
        }
        TextPaint paint = editText.getPaint();
        if (paint == null) {
            return -1;
        }
        Rect rect = new Rect();
        int i = paddingTop;
        paddingTop = 0;
        while (paddingTop < layout.getLineCount()) {
            layout.getLineBounds(paddingTop, rect);
            int height = rect.height() + i;
            if (((float) height) >= f2) {
                int i2;
                int lineStart = layout.getLineStart(paddingTop);
                int lineEnd = layout.getLineEnd(paddingTop);
                RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) editableText.getSpans(lineStart, lineEnd, RelativeSizeSpan.class);
                float f3 = 1.0f;
                if (relativeSizeSpanArr != null) {
                    int length = relativeSizeSpanArr.length;
                    i2 = 0;
                    while (i2 < length) {
                        float sizeChange = relativeSizeSpanArr[i2].getSizeChange();
                        i2++;
                        f3 = sizeChange;
                    }
                }
                float f4 = f3;
                String charSequence = editableText.subSequence(lineStart, lineEnd).toString();
                float[] fArr = new float[charSequence.length()];
                paint.getTextWidths(charSequence, fArr);
                f3 = 0.0f;
                i2 = 0;
                while (i2 < charSequence.length()) {
                    f3 += fArr[i2] * f4;
                    if (f3 >= f || i2 == charSequence.length() - 1) {
                        return lineStart + i2;
                    }
                    i2++;
                }
                continue;
            }
            paddingTop++;
            i = height;
        }
        return -1;
    }
}
