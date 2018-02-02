package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import java.util.Collections;
import java.util.List;

final class d {
    String ayS = null;
    int ayT;
    boolean ayU = false;
    boolean ayV = false;
    int ayW = -1;
    int ayX = -1;
    int ayY = -1;
    int ayZ = -1;
    String azA = "";
    List<String> azB = Collections.emptyList();
    String azC = "";
    int aza = -1;
    float azb;
    Alignment azd = null;
    String azz = "";
    int backgroundColor;

    public final int getStyle() {
        int i = 0;
        if (this.ayY == -1 && this.ayZ == -1) {
            return -1;
        }
        int i2 = this.ayY == 1 ? 1 : 0;
        if (this.ayZ == 1) {
            i = 2;
        }
        return i2 | i;
    }

    static int a(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        return str.equals(str2) ? i + i2 : -1;
    }
}
