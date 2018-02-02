package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.mm.e.b.i;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class m$a implements a {
    m$a() {
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        int i = -1;
        switch (str.hashCode()) {
            case -1560895490:
                if (str.equals("//voicetrymore")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                if (strArr.length > 1 && strArr[1] != null) {
                    boolean z;
                    if (bh.getInt(strArr[1], 1) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    i.flW = z;
                    x.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", new Object[]{Integer.valueOf(r3)});
                    return true;
                }
        }
        return false;
    }
}
