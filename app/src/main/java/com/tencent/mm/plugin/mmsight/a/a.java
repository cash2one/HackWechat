package com.tencent.mm.plugin.mmsight.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class a {

    public static class b {
        public int gBx;
        public boolean hnr;
        public int owZ;
        public int oxa;
        public int oxb;
        public int oxc;
        public boolean oxd;
        public int oxe;
        public int oxf;
        public int scene;
        public int textColor;

        public b(int i) {
            if (i == 1) {
                this.scene = 2;
            } else if (i == 2) {
                this.scene = 4;
            } else if (i == WXMediaMessage.TITLE_LENGTH_LIMIT) {
                this.scene = 3;
            } else if (i == 4) {
                this.scene = 8;
            }
        }

        public final String toString() {
            return "VideoEditDetailData{scene=" + this.scene + ", isCancel=" + this.hnr + ", rawDuration=" + this.owZ + ", cropDuration=" + this.oxa + ", emojiItemCount=" + this.oxb + ", textItemCount=" + this.oxc + ", isCrop=" + this.oxd + ", undoCount=" + this.gBx + ", doodleCount=" + this.oxe + ", penColors=" + this.oxf + ", textColor=" + this.textColor + '}';
        }
    }

    public static void a(a aVar) {
        x.i("MicroMsg.VideoEditReporter", "[report-VideoEditCountData] %s", new Object[]{aVar.toString()});
        g.pQN.h(14529, new Object[]{Integer.valueOf(aVar.scene), Integer.valueOf(aVar.cOY)});
    }
}
