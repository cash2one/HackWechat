package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.f.a;
import com.tencent.mm.wallet_core.f.b;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView extends TextView {
    private static final String TAG = ("MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString());
    public String mPrefix;
    private Object xgo;
    private Object zJq;
    private int zJr;

    public WalletTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WalletTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xgo = "";
        this.zJq = "";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.vam, i, 0);
        this.zJr = obtainStyledAttributes.getInteger(k.van, 4);
        this.mPrefix = obtainStyledAttributes.getString(k.vao);
        obtainStyledAttributes.recycle();
        cCi();
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        Object obj;
        this.xgo = charSequence;
        String charSequence2 = charSequence.toString();
        if (charSequence2 == null || charSequence2.length() == 0) {
            obj = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(6);
            for (int i = 0; i < 5; i++) {
                stringBuilder.append((char) ((int) ((186209115388253L >> ((4 - i) * 8)) & 255)));
            }
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            obj = charSequence2.replaceAll(stringBuilder2, stringBuilder.toString());
        }
        this.zJq = obj;
        if (!bh.ov(this.mPrefix)) {
            charSequence = this.mPrefix + charSequence;
        }
        if (!(this.zJr == 4 || bh.M(charSequence) || !Pattern.compile(".*?[a-zA-Z]+.*?").matcher(charSequence).matches())) {
            x.i(TAG, "force use std font");
            this.zJr = 4;
            cCi();
        }
        super.setText(charSequence, bufferType);
    }

    private void cCi() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), e.HC(this.zJr)));
    }

    @Deprecated
    public CharSequence getText() {
        boolean z = false;
        a cBK = a.cBK();
        if (!d.oSu.bA(this)) {
            z = true;
        } else if (!cBK.zIa.containsKey(this)) {
            cBK.zIa.put(this, Boolean.valueOf(true));
            com.tencent.mm.plugin.report.d.pPH.a(715, 0, 1, false);
            if ((b.cBN() || h.zj()) && b.cBL()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<st><Manufacturer>").append(Build.MANUFACTURER).append("</Manufacturer><Model>").append(Build.MODEL).append("</Model><VersionRelease>").append(VERSION.RELEASE).append("</VersionRelease><VersionIncremental>").append(VERSION.INCREMENTAL).append("</VersionIncremental><Display>").append(Build.DISPLAY).append("</Display></st>");
                com.tencent.mm.plugin.secinforeport.a.d.qfi.IY(stringBuilder.toString());
            }
        }
        if (z) {
            return (CharSequence) this.xgo;
        }
        if (!b.cBN() && !h.zj()) {
            return (CharSequence) this.xgo;
        }
        return (CharSequence) (b.cBM() ? this.zJq : this.xgo);
    }

    public int getSelectionStart() {
        return Selection.getSelectionStart((CharSequence) this.xgo);
    }

    public int getSelectionEnd() {
        return Selection.getSelectionEnd((CharSequence) this.xgo);
    }
}
