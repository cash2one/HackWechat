package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class i$a {
    public static int slE = 1;
    public static int slF = 2;
    public static int slG = 3;
    public static int slH = 4;
    public static int slI = 0;
    public static int slJ = 1;
    public int slB;
    public long slC;
    public int slD;
    public int status;

    public final boolean bGI() {
        return this.slD == slI;
    }

    public final boolean parse(String str) {
        this.slD = slI;
        try {
            Map y = bi.y(str, "voipinvitemsg");
            if (y == null) {
                return false;
            }
            if (y.get(".voipinvitemsg.roomid") != null) {
                this.slB = bh.getInt((String) y.get(".voipinvitemsg.roomid"), 0);
            }
            if (y.get(".voipinvitemsg.key") != null) {
                this.slC = bh.getLong((String) y.get(".voipinvitemsg.key"), 0);
            }
            if (y.get(".voipinvitemsg.status") != null) {
                this.status = bh.getInt((String) y.get(".voipinvitemsg.status"), 0);
            }
            if (y.get(".voipinvitemsg.invitetype") != null) {
                this.slD = bh.getInt((String) y.get(".voipinvitemsg.invitetype"), 0);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
            x.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
