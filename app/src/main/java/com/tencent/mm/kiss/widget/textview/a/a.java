package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class a {
    public Typeface boj = null;
    public Alignment gTC = Alignment.ALIGN_NORMAL;
    public TruncateAt gTD = null;
    public TextDirectionHeuristic gTF = null;
    public float gTG = 0.0f;
    public float gTH = 1.0f;
    public boolean gTI = false;
    public TextPaint gTN = null;
    public int gUf = -1;
    public int gUg = -1;
    public float gUh = -1.0f;
    public int gravity = 51;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public int textColor = -1;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(String.format("maxLines: %d ", new Object[]{Integer.valueOf(this.maxLines)}));
        stringBuilder.append(String.format("maxLength: %d ", new Object[]{Integer.valueOf(this.maxLength)}));
        stringBuilder.append(String.format("textPaint: %s ", new Object[]{this.gTN}));
        stringBuilder.append(String.format("alignment: %s ", new Object[]{this.gTC}));
        stringBuilder.append(String.format("ellipsize: %s ", new Object[]{this.gTD}));
        stringBuilder.append(String.format("gravity: %s ", new Object[]{Integer.valueOf(this.gravity)}));
        stringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[]{Integer.valueOf(this.gUf)}));
        stringBuilder.append(String.format("textDirection: %s ", new Object[]{this.gTF}));
        stringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[]{Float.valueOf(this.gTG), Float.valueOf(this.gTH)}));
        stringBuilder.append(String.format("includedPad: %b ", new Object[]{Boolean.valueOf(this.gTI)}));
        stringBuilder.append(String.format("typeface: %s ", new Object[]{this.boj}));
        stringBuilder.append(String.format("fontStyle: %d ", new Object[]{Integer.valueOf(this.gUg)}));
        stringBuilder.append(String.format("textSize: %s ", new Object[]{Float.valueOf(this.gUh)}));
        stringBuilder.append(String.format("textColor: %d", new Object[]{Integer.valueOf(this.textColor)}));
        stringBuilder.append(String.format("linkColor: %d", new Object[]{Integer.valueOf(this.linkColor)}));
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int i = ((this.maxLines * 31) + 0) + (this.maxLength * 31);
        if (this.gTN != null) {
            i += this.gTN.hashCode() * 31;
        }
        i += this.gTC.hashCode() * 31;
        if (this.gTD != null) {
            i += this.gTD.hashCode() * 31;
        }
        i = (i + (this.gravity * 31)) + (this.gUf * 31);
        if (this.gTF != null) {
            i += this.gTF.hashCode() * 31;
        }
        i = ((this.gTI ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i) + (this.gTG * 31.0f)))) + (this.gTH * 31.0f)));
        if (this.boj != null) {
            i += this.boj.hashCode() * 31;
        }
        return (((int) (((float) (i + (this.gUg * 31))) + (this.gUh * 31.0f))) + (this.textColor * 31)) + (this.linkColor * 31);
    }
}
