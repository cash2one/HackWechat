package com.tencent.mm.plugin.facedetect.model;

import android.hardware.Camera.Size;
import java.util.Comparator;

class l$a implements Comparator<Size> {
    private l$a() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Size size = (Size) obj;
        Size size2 = (Size) obj2;
        int i = size.height * size.width;
        int i2 = size2.height * size2.width;
        if (i2 < i) {
            return -1;
        }
        return i2 > i ? 1 : 0;
    }
}
