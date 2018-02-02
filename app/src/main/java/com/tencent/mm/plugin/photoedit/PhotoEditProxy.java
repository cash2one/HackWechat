package com.tencent.mm.plugin.photoedit;

import com.tencent.mm.R;
import com.tencent.mm.aq.l;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class PhotoEditProxy extends a {
    public PhotoEditProxy(d dVar) {
        super(dVar);
    }

    public int doFav(String str) {
        return ((Integer) REMOTE_CALL("doFavInMM", new Object[]{str})).intValue();
    }

    public void sendImage(String str, String str2, String str3, String str4) {
        REMOTE_CALL("sendImageInMM", new Object[]{str, str2, str3, str4});
    }

    public boolean isAutoSave() {
        return ((Boolean) REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
    }

    public String getSelfUsername() {
        return (String) REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
    }

    public String getFullPath(String str) {
        return (String) REMOTE_CALL("getFullPathInMM", new Object[]{str});
    }

    @f
    public void sendImageInMM(String str, String str2, String str3, String str4) {
        ar.CG().a(new l(4, str3, str4, str2, 0, null, 0, "", "", true, R.g.bAH), 0);
        com.tencent.mm.plugin.messenger.a.f.aZh().dj(str, str4);
    }

    @f
    public String getSelfUsernameInMM() {
        return q.FS();
    }

    @f
    public boolean isAutoSavePhotoInMM() {
        ar.Hg();
        return c.CU().getBoolean(w.a.xtw, true);
    }

    @f
    public int doFavInMM(String str) {
        b cfVar = new cf();
        com.tencent.mm.pluginsdk.model.f.a(cfVar, 2, str);
        cfVar.fqp.fqw = 44;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
        x.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", new Object[]{str});
        return cfVar.fqq.ret;
    }

    @f
    public String getFullPathInMM(String str) {
        return o.Pw().getFullPath(str);
    }
}
