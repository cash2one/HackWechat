package com.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.rtmp.TXLiveConstants;

class a$a extends Handler {
    final /* synthetic */ a bgf;
    private final int bgg = 2001;
    private final int bgh = 2002;
    private final int bgi = 2003;
    private final int bgj = TXLiveConstants.PLAY_EVT_PLAY_BEGIN;
    private final int bgk = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
    private final int bgl = TXLiveConstants.PLAY_EVT_PLAY_END;

    public a$a(a aVar, Looper looper) {
        this.bgf = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        new StringBuilder("what = ").append(message.what);
        switch (message.what) {
            case 1:
                if (this.bgf.bgc == null) {
                    return;
                }
                return;
            case 2:
                if (this.bgf.bgc == null) {
                    return;
                }
                return;
            case 3:
                if (this.bgf.bgc == null) {
                    return;
                }
                return;
            case 6:
                if (this.bgf.bgc != null) {
                    this.bgf.bgc.aH(0, message.arg1);
                }
                removeMessages(8);
                return;
            case 7:
                if (this.bgf.bgc != null) {
                    switch (message.arg1) {
                        case 2001:
                            i = 2002;
                            break;
                        case 2002:
                            i = 2003;
                            break;
                        case 2003:
                        case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                            i = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
                            break;
                        case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                            i = TXLiveConstants.PLAY_EVT_PLAY_END;
                            break;
                        default:
                            i = 2020;
                            break;
                    }
                    this.bgf.bgc.aH(i, -1);
                }
                removeMessages(8);
                return;
            case 8:
                if (this.bgf.bgc != null) {
                    this.bgf.bgc.aH(2001, -1);
                }
                removeMessages(8);
                this.bgf.abort();
                return;
            default:
                return;
        }
    }
}
