package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class aq {
    static boolean fKs;
    private TelephonyManager xhg;
    private PhoneStateListener xhh;
    List<a> xhi = new LinkedList();

    public interface a {
        void fi(int i);
    }

    public final void a(a aVar) {
        this.xhi.add(aVar);
    }

    public final void cfS() {
        this.xhi.clear();
    }

    public static boolean vd() {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", Boolean.valueOf(fKs));
        return fKs;
    }

    public final void eV(Context context) {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
        if (this.xhg == null) {
            this.xhg = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.xhh == null) {
            this.xhh = new PhoneStateListener(this) {
                final /* synthetic */ aq xhj;

                {
                    this.xhj = r1;
                }

                public final void onCallStateChanged(int i, String str) {
                    x.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i), str);
                    if (this.xhj.xhi.size() > 0) {
                        for (a fi : (a[]) this.xhj.xhi.toArray(new a[this.xhj.xhi.size()])) {
                            fi.fi(i);
                        }
                    }
                    super.onCallStateChanged(i, str);
                    switch (i) {
                        case 0:
                            aq.fKs = false;
                            return;
                        case 1:
                        case 2:
                            aq.fKs = true;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.xhg.listen(this.xhh, 32);
    }

    public final void end() {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
        if (this.xhg != null) {
            this.xhg.listen(this.xhh, 0);
            this.xhh = null;
        }
    }
}
