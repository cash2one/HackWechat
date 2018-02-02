package c.t.m.g;

import android.bluetooth.le.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

class cy$a extends Handler {
    private /* synthetic */ cy a;

    public cy$a(cy cyVar, Looper looper) {
        this.a = cyVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                cy.a(this.a);
                return;
            case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                cy.b(this.a);
                return;
            case 3000:
                cy.a(this.a, (ScanResult) message.obj);
                return;
            default:
                return;
        }
    }
}
