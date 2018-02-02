package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService$a;
import com.tencent.mm.plugin.appbrand.media.record.RecordParam;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends AppBrandMainProcessService$a {
    c$1() {
    }

    public final void onDisconnected(String str) {
        super.onDisconnected(str);
        x.e("MicroMsg.Audio.AppBrandAudioService", "The process is be killed by system, processName:%s, and do destroyAllAudioPlayerByProcessName", str);
        x.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayerByProcessName processName:%s", str);
        b sVar = new s();
        sVar.fnD.action = 15;
        sVar.fnD.processName = str;
        a.xef.m(sVar);
        x.i("MicroMsg.AudioRecordHelper", "stopRecordByProcessName processName:%s", str);
        RecordParam recordParam = f.Zs().jzG;
        if (recordParam != null && str != null && str.equalsIgnoreCase(recordParam.processName)) {
            x.i("MicroMsg.AudioRecordHelper", "stop the record by processName");
            f.Zs().vi();
        } else if (recordParam == null || str == null || str.equalsIgnoreCase(recordParam.processName)) {
            x.i("MicroMsg.AudioRecordHelper", "record has been stopped or not start");
        } else {
            x.i("MicroMsg.AudioRecordHelper", "%s processName is diff, don't stop record", recordParam.processName);
        }
    }
}
