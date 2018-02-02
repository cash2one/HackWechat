package com.tencent.mm.plugin.s;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ i opY;

    i$1(i iVar) {
        this.opY = iVar;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                x.i("MicroMsg.VideoPlayer", "%s call prepared ", this.opY.asP());
                if (this.opY.opW != null) {
                    this.opY.opW.hX();
                    break;
                }
                break;
            case 2:
                x.i("MicroMsg.VideoPlayer", "%s call completion ", this.opY.asP());
                if (this.opY.opW != null) {
                    this.opY.opW.vh();
                    break;
                }
                break;
            case 3:
                x.i("MicroMsg.VideoPlayer", "%s call seek completion ", this.opY.asP());
                if (this.opY.opW != null) {
                    this.opY.opW.aZA();
                    break;
                }
                break;
            case 4:
                x.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", this.opY.asP(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(((Integer) message.obj).intValue()));
                if (this.opY.opW != null) {
                    this.opY.opW.O(message.arg1, message.arg2, ((Integer) message.obj).intValue());
                    break;
                }
                break;
            case 5:
                x.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", this.opY.asP(), Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
                if (this.opY.opW != null) {
                    this.opY.opW.onError(message.arg1, message.arg2);
                    break;
                }
                break;
            case 6:
                try {
                    i iVar = this.opY;
                    x.i("MicroMsg.VideoPlayer", "%s clear now.", iVar.asP());
                    iVar.opS.quit();
                    iVar.opT.quit();
                    if (iVar.opU != null) {
                        iVar.opU.quit();
                    }
                    iVar.opR.removeMessages(1);
                    iVar.opR.removeMessages(2);
                    iVar.opR.removeMessages(3);
                    iVar.opR.removeMessages(4);
                    iVar.opR.removeMessages(5);
                    iVar.opS = null;
                    iVar.opT = null;
                    iVar.opR = null;
                    iVar.opQ = null;
                    iVar.opW = null;
                    iVar.opV = null;
                    break;
                } catch (Exception e) {
                    break;
                }
            default:
                x.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", this.opY.asP(), Integer.valueOf(message.what));
                break;
        }
        return false;
    }
}
