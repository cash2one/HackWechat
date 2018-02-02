package com.google.android.gms.common.images;

import com.google.android.gms.common.images.ImageManager.a;
import com.google.android.gms.common.internal.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class a$b extends a {
    private WeakReference<a> aMV;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a$b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a$b com_google_android_gms_common_images_a_b = (a$b) obj;
        a aVar = (a) this.aMV.get();
        a aVar2 = (a) com_google_android_gms_common_images_a_b.aMV.get();
        return aVar2 != null && aVar != null && v.b(aVar2, aVar) && v.b(com_google_android_gms_common_images_a_b.aMS, this.aMS);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.aMS});
    }

    protected final void oD() {
        this.aMV.get();
    }
}
