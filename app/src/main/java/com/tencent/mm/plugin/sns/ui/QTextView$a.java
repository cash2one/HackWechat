package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import java.util.ArrayList;
import java.util.HashMap;

class QTextView$a {
    private static HashMap<String, Integer> rwq = new HashMap();
    private String aAM = "";
    private int rwk = 0;
    boolean rwl = false;
    ArrayList<int[]> rwm = new ArrayList();
    float rwn;
    float rwo;
    float rwp;

    public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
        String str4 = str + str2 + str3 + i + i2;
        if (str4.equals(this.aAM)) {
            return this.rwk;
        }
        this.aAM = str4;
        this.rwm.clear();
        this.rwl = false;
        this.rwn = 0.0f;
        this.rwo = 0.0f;
        this.rwp = 0.0f;
        if (i2 == -1) {
            this.rwm.add(new int[]{null, str.length()});
            this.rwk = (int) (textPaint.measureText(str) + 0.5f);
            return this.rwk;
        }
        if (str2 != null) {
            this.rwo = textPaint.measureText(str2);
        }
        if (str3 != null) {
            this.rwp = textPaint.measureText(str3);
        }
        int i3 = -1;
        float f = 0.0f;
        Object obj = 1;
        int i4 = 0;
        while (i4 < str.length()) {
            if (i3 == -1) {
                i3 = i4;
            }
            if (this.rwm.size() == i) {
                this.rwl = true;
                break;
            }
            int i5;
            Object obj2;
            float measureText = textPaint.measureText(str.charAt(i4));
            Object obj3 = null;
            if (str.charAt(i4) == '\n') {
                this.rwm.add(new int[]{i3, i4 - 1});
                i5 = i4;
                obj2 = 1;
            } else {
                if (f + measureText >= ((float) i2)) {
                    obj3 = 1;
                    if (str.charAt(i4) == ' ' || r2 == null) {
                        i4--;
                        this.rwm.add(new int[]{i3, i4});
                        i5 = i4;
                        i4 = 1;
                    } else {
                        while (str.charAt(i4) != ' ') {
                            i4--;
                            if (i4 == 0) {
                                break;
                            }
                        }
                        this.rwm.add(new int[]{i3, i4});
                    }
                }
                Object obj4 = obj3;
                i5 = i4;
                obj2 = obj4;
            }
            if (obj2 != null) {
                i3 = -1;
                f = 0.0f;
                if (this.rwm.size() == i - 1) {
                    i2 = (int) (((float) i2) - (this.rwo + this.rwp));
                    obj = null;
                }
            } else {
                f += measureText;
                if (i5 == str.length() - 1) {
                    this.rwm.add(new int[]{i3, i5});
                }
            }
            i4 = i5 + 1;
        }
        if (this.rwl) {
            int[] iArr = (int[]) this.rwm.get(this.rwm.size() - 1);
            this.rwn = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
        }
        if (this.rwm.size() == 0) {
            this.rwk = 0;
            return this.rwk;
        } else if (this.rwm.size() == 1) {
            this.rwk = (int) (textPaint.measureText(str) + 0.5f);
            return this.rwk;
        } else {
            this.rwk = i2;
            return this.rwk;
        }
    }
}
