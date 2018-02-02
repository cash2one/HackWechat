package com.tencent.mm.z;

import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.x;

class d$b implements a {
    final /* synthetic */ d heO;

    private d$b(d dVar) {
        this.heO = dVar;
    }

    public final void es(int i) {
        switch (i) {
            case -3:
                x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                if (this.heO.heM == null) {
                    return;
                }
                return;
            case -2:
                x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                if (this.heO.heM == null) {
                    return;
                }
                return;
            case -1:
                x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                if (this.heO.heM == null) {
                    return;
                }
                return;
            case 1:
                x.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                if (this.heO.heM == null) {
                    return;
                }
                return;
            default:
                x.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                return;
        }
    }
}
