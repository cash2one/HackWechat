package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.x;

public class ChatFooter$e implements TextWatcher {
    final /* synthetic */ ChatFooter vra;
    TextWatcher vri;
    private boolean vrj = false;
    private boolean vrk = f.fN(11);

    public ChatFooter$e(ChatFooter chatFooter, TextWatcher textWatcher) {
        this.vra = chatFooter;
        this.vri = textWatcher;
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = true;
        if (ChatFooter.h(this.vra) && this.vrj && editable.length() > 0) {
            this.vrj = false;
            ChatFooter.a(this.vra).setText(editable.subSequence(0, editable.length() - 1));
            if (ChatFooter.a(this.vra).length() > 0) {
                ChatFooter.i(this.vra).performClick();
            }
            x.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
            return;
        }
        this.vri.afterTextChanged(editable);
        if (ChatFooter.p(this.vra) != null) {
            if (ChatFooter.a(this.vra).getLineCount() > 1) {
                ChatFooter.p(this.vra).setVisibility(0);
                ChatFooter.p(this.vra).setText(editable.length() + "/140");
            } else {
                ChatFooter.p(this.vra).setVisibility(8);
            }
        }
        if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
            z = false;
        }
        ChatFooter.b(this.vra, z);
        if (ChatFooter.n(this.vra) != null) {
            ChatFooter.n(this.vra).aE(z);
        }
        x.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.vri.beforeTextChanged(charSequence, i, i2, i3);
        x.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (ChatFooter.h(this.vra) && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == '\n') {
            this.vrj = true;
        } else {
            this.vri.onTextChanged(charSequence, i, i2, i3);
        }
    }
}
