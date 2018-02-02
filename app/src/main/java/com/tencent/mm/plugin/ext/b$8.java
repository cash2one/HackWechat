package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import java.util.Iterator;

class b$8 extends af {
    final /* synthetic */ b lZF;

    b$8(b bVar, Looper looper) {
        this.lZF = bVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            if (b.b(this.lZF).size() > 0) {
                Iterator it = b.b(this.lZF).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!"*".equals(str)) {
                        f aZ = g.aZ(str, false);
                        if (aZ == null) {
                            x.w("MicroMsg.SubCoreExt", "appInfo is null");
                        } else if (bh.ov(aZ.field_appId)) {
                            x.w("MicroMsg.SubCoreExt", "appId is null");
                        } else {
                            x.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", new Object[]{str, Integer.valueOf(aZ.field_appInfoFlag), aZ.field_appId});
                            ba XC = b.aFB().XC(aZ.field_appId);
                            if (XC == null) {
                                x.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", new Object[]{aZ.field_appId});
                            } else {
                                if (g.i(aZ)) {
                                    if (XC.field_status != 1) {
                                        XC.field_status = 1;
                                    }
                                } else if (XC.field_status != 0) {
                                    XC.field_status = 0;
                                }
                                bb aFB = b.aFB();
                                if (bh.ov(aZ.field_appId) || XC == null || bh.ov(XC.field_appId)) {
                                    x.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                } else {
                                    int update;
                                    ContentValues vI = XC.vI();
                                    if (vI.size() > 0) {
                                        update = aFB.gJP.update("OpenMsgListener", vI, "appId=?", new String[]{bh.ot(r3)});
                                    } else {
                                        update = 0;
                                    }
                                    x.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", new Object[]{XC.field_appId, Integer.valueOf(update)});
                                }
                            }
                        }
                    }
                }
                b.b(this.lZF).clear();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", new Object[]{e.getMessage()});
        }
    }
}
