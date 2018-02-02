package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import com.tencent.mm.compatible.d.d.a;

final class e implements a {
    e() {
    }

    public static d$a$a ym() {
        d$a$a com_tencent_mm_compatible_d_d_a_a = new d$a$a();
        try {
            com_tencent_mm_compatible_d_d_a_a.gEB = Camera.open();
            com_tencent_mm_compatible_d_d_a_a.fFy = 0;
            if (com_tencent_mm_compatible_d_d_a_a.gEB == null) {
                return null;
            }
            return com_tencent_mm_compatible_d_d_a_a;
        } catch (Exception e) {
            return null;
        }
    }
}
