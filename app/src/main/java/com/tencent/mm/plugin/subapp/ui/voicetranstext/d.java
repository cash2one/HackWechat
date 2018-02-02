package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.bsx;

public final class d {
    public static bsx aH(int i, String str) {
        bsx com_tencent_mm_protocal_c_bsx = new bsx();
        switch (i) {
            case 0:
                com_tencent_mm_protocal_c_bsx.vIG = 8000;
                com_tencent_mm_protocal_c_bsx.vIH = 16;
                com_tencent_mm_protocal_c_bsx.vIE = 5;
                com_tencent_mm_protocal_c_bsx.vIF = 5;
                break;
            case 1:
                com_tencent_mm_protocal_c_bsx.vIG = 16000;
                com_tencent_mm_protocal_c_bsx.vIH = 16;
                com_tencent_mm_protocal_c_bsx.vIE = 4;
                com_tencent_mm_protocal_c_bsx.vIF = 4;
                break;
            case 4:
                com_tencent_mm_protocal_c_bsx.vIG = 16000;
                b nT = q.nT(str);
                if (nT != null) {
                    int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(((h) nT).bp(0, 1).buf);
                    if (SilkGetEncSampleRate >= 8000) {
                        com_tencent_mm_protocal_c_bsx.vIG = SilkGetEncSampleRate;
                    }
                }
                com_tencent_mm_protocal_c_bsx.vIH = 16;
                com_tencent_mm_protocal_c_bsx.vIE = 6;
                com_tencent_mm_protocal_c_bsx.vIF = 6;
                break;
            default:
                com_tencent_mm_protocal_c_bsx.vIG = 0;
                com_tencent_mm_protocal_c_bsx.vIH = 0;
                com_tencent_mm_protocal_c_bsx.vIE = 0;
                com_tencent_mm_protocal_c_bsx.vIF = 0;
                break;
        }
        return com_tencent_mm_protocal_c_bsx;
    }
}
