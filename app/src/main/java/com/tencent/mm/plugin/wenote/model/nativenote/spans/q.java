package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public enum q {
    NONE("", "", "", "", false),
    NOTEUL("<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true),
    NOTEOL("<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true),
    NOTETODO("", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    
    public String tVW;
    public String tVX;
    public boolean tVY;
    public String tVZ;
    public String tWa;
    public boolean tWb;
    public boolean tWc;

    public static q a(ParagraphStyle paragraphStyle) {
        if (paragraphStyle instanceof d) {
            return NOTEUL;
        }
        if (paragraphStyle instanceof m) {
            return NOTEOL;
        }
        return paragraphStyle instanceof k ? NOTETODO : null;
    }

    private q(String str, String str2, String str3, String str4, boolean z) {
        this.tWc = false;
        this.tVW = str;
        this.tVX = str2;
        this.tVZ = str3;
        this.tWa = str4;
        this.tVY = false;
        this.tWb = z;
    }

    public final boolean bXA() {
        return this == NOTEUL;
    }

    public final boolean bXB() {
        return this == NOTEOL;
    }

    public final boolean bXC() {
        return this == NOTETODO;
    }
}
