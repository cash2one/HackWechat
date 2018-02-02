package com.tencent.mm.plugin.ext;

import android.content.SharedPreferences;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public class b$a extends c<ey> {
    public b$a() {
        this.xen = ey.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ey eyVar = (ey) bVar;
        if (!(eyVar instanceof ey)) {
            x.f("MicroMsg.SubCoreExt", "mismatched event");
            return false;
        } else if (eyVar.ftR == null) {
            x.e("MicroMsg.SubCoreExt", "revent.data is null");
            return false;
        } else {
            if (eyVar.ftR.ftm == 9 || eyVar.ftR.ftm == 13) {
                ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(eyVar.ftR.fmW, eyVar.ftR.ftm, eyVar.ftR.context);
                eyVar.ftS.ftn = extControlProviderMsg.query(eyVar.ftR.uri, null, null, eyVar.ftR.selectionArgs, null);
            } else if (eyVar.ftR.ftm == 3) {
                ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(eyVar.ftR.fmW, eyVar.ftR.ftm, eyVar.ftR.context);
                eyVar.ftS.ftn = extControlProviderEntry.query(eyVar.ftR.uri, null, null, eyVar.ftR.selectionArgs, null);
            } else if (eyVar.ftR.ftm == 29) {
                ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(eyVar.ftR.fmW, eyVar.ftR.ftm, eyVar.ftR.context);
                eyVar.ftS.ftn = extControlProviderVoiceControl.query(eyVar.ftR.uri, null, null, eyVar.ftR.selectionArgs, null);
                SharedPreferences cft = ac.cft();
                if (!b.ya()) {
                    cft.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                    b.ID();
                }
            } else {
                ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(eyVar.ftR.fmW, eyVar.ftR.ftm, eyVar.ftR.context);
                eyVar.ftS.ftn = extControlProviderOpenApi.query(eyVar.ftR.uri, null, null, eyVar.ftR.selectionArgs, null);
            }
            return true;
        }
    }
}
