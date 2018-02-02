package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WXRTEditText$2 implements TextWatcher {
    final /* synthetic */ WXRTEditText tTU;

    WXRTEditText$2(WXRTEditText wXRTEditText) {
        this.tTU = wXRTEditText;
    }

    public final synchronized void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Object c = WXRTEditText.c(this.tTU) == null ? "" : WXRTEditText.c(this.tTU);
        if (!(WXRTEditText.d(this.tTU) || charSequence.toString().equals(c))) {
            WXRTEditText.a(this.tTU, this.tTU.getSelectionStart());
            WXRTEditText.b(this.tTU, this.tTU.getSelectionEnd());
            WXRTEditText.a(this.tTU, charSequence.toString());
            this.tTU.tTu = WXRTEditText.c(this.tTU);
            WXRTEditText.a(this.tTU, this.tTU.bWM());
        }
    }

    public final synchronized void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        WXRTEditText.e(this.tTU);
    }

    public final synchronized void afterTextChanged(Editable editable) {
        x.d("noteeditor.WXRTEditText", "afterTextChanged");
        String obj = editable.toString();
        String str = this.tTU.tTu == null ? "" : this.tTU.tTu;
        if (WXRTEditText.f(this.tTU) != 0) {
            this.tTU.tTu = "";
        }
        if (!WXRTEditText.d(this.tTU) && this.tTU.bWN().Ww == this.tTU.bWN().wq && (((!str.endsWith("\n") && (str + "\n").equals(obj)) || (str.endsWith("\n") && !str.endsWith("\n\n") && str.equals(obj))) && ((ParagraphStyle[]) this.tTU.getText().getSpans(str.length(), str.length(), ParagraphStyle.class)).length > 0)) {
            int selectionStart = this.tTU.getSelectionStart();
            WXRTEditText.a(this.tTU, true);
            this.tTU.getText().append("\n");
            WXRTEditText.a(this.tTU, false);
            this.tTU.setSelection(selectionStart);
        }
        if (!(WXRTEditText.g(this.tTU) == null || WXRTEditText.d(this.tTU) || str.equals(obj))) {
            Spannable bWM = this.tTU.bWM();
            this.tTU.tTu = obj;
            c g = WXRTEditText.g(this.tTU);
            WXRTEditText h = WXRTEditText.h(this.tTU);
            Spannable i = WXRTEditText.i(this.tTU);
            this.tTU.getSelectionStart();
            g.a(h, i, bWM, this.tTU.getSelectionEnd());
        }
        WXRTEditText.e(this.tTU);
        WXRTEditText.j(this.tTU);
        WXRTEditText.k(this.tTU);
        WXRTEditText.l(this.tTU);
    }
}
