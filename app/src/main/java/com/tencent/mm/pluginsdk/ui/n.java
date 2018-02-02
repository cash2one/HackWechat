package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.bx.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;

public final class n {
    private Context mContext;
    private StringBuilder vlP;
    private SpannableStringBuilder vlQ = new SpannableStringBuilder();
    private SpannableString vlR;
    private SpannableStringBuilder vlS = new SpannableStringBuilder();
    private CharacterStyle vlT = new ForegroundColorSpan(-5066062);
    private int vlU;
    private int vlV;
    public int vlW = 3;

    public n(Context context) {
        this.mContext = context;
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        if (mMEditText != null) {
            if (this.vlP == null) {
                throw new IllegalStateException("You should saveHistory before setText");
            }
            int length = this.vlU + str.length();
            this.vlQ.clear();
            this.vlS.clear();
            if (z) {
                CharSequence charSequence;
                this.vlR = g.chg().a(this.mContext, this.vlP.subSequence(0, this.vlU), mMEditText.getTextSize());
                SpannableStringBuilder append = this.vlQ.append(this.vlR);
                SpannableStringBuilder spannableStringBuilder = this.vlS;
                if (spannableStringBuilder == null || str == null || str.length() == 0) {
                    charSequence = spannableStringBuilder;
                } else {
                    int length2;
                    int i;
                    if (str.length() < this.vlW) {
                        length2 = str.length();
                        i = 0;
                    } else {
                        length2 = str.length();
                        i = length2 - this.vlW;
                    }
                    spannableStringBuilder.append(str).setSpan(this.vlT, i, length2, 33);
                    Object obj = spannableStringBuilder;
                }
                append.append(charSequence).append(this.vlP.subSequence(this.vlV, this.vlP.length()));
            } else {
                this.vlR = g.chg().a(this.mContext, str, mMEditText.getTextSize());
                this.vlQ.append(this.vlR);
            }
            x.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", Integer.valueOf(this.vlU), Integer.valueOf(this.vlV), Integer.valueOf(length), Integer.valueOf(this.vlQ.length()), str, this.vlQ);
            mMEditText.setText(this.vlQ);
            if (length > this.vlQ.length()) {
                return;
            }
            if (length == 0) {
                mMEditText.setSelection(this.vlQ.length());
            } else {
                mMEditText.setSelection(length);
            }
        }
    }

    public final void a(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.vlW = 0;
            this.vlR = g.chg().a(this.mContext, mMEditText.getText().toString(), mMEditText.getTextSize());
            x.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", this.vlR);
            mMEditText.setText(this.vlR);
            mMEditText.setSelection(this.vlR.length());
        }
    }

    public final void b(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.vlU = mMEditText.getSelectionStart();
            this.vlV = mMEditText.getSelectionEnd();
            this.vlP = new StringBuilder(mMEditText.getText());
            x.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", Integer.valueOf(this.vlU), Integer.valueOf(this.vlV), this.vlP);
            if (mMEditText.getText().toString().equalsIgnoreCase("")) {
                this.vlQ.clear();
            }
        }
    }
}
