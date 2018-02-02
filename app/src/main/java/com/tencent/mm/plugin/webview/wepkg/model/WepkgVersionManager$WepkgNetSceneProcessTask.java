package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi;
import com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.webview.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.nx;
import com.tencent.mm.protocal.c.ny;
import com.tencent.mm.protocal.c.of;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;

public final class WepkgVersionManager$WepkgNetSceneProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgVersionManager$WepkgNetSceneProcessTask> CREATOR = new 2();
    private List<WepkgCheckReq> tNO;
    private int tNP;

    private static class WepkgCheckReq implements Parcelable {
        public static final Creator<WepkgCheckReq> CREATOR = new 1();
        private int scene;
        private String tNm;
        private String version;

        private WepkgCheckReq() {
        }

        private WepkgCheckReq(Parcel parcel) {
            this.tNm = parcel.readString();
            this.version = parcel.readString();
            this.scene = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.tNm);
            parcel.writeString(this.version);
            parcel.writeInt(this.scene);
        }
    }

    public WepkgVersionManager$WepkgNetSceneProcessTask() {
        this.tNO = new ArrayList();
    }

    private WepkgVersionManager$WepkgNetSceneProcessTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        if (!bh.cA(this.tNO)) {
            a aVar = new a();
            aVar.hmi = 1313;
            aVar.hml = 0;
            aVar.hmm = 0;
            aVar.uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
            com.tencent.mm.bq.a nxVar = new nx();
            for (WepkgCheckReq wepkgCheckReq : this.tNO) {
                of ofVar = new of();
                ofVar.vXf = wepkgCheckReq.tNm;
                ofVar.ktA = wepkgCheckReq.version;
                ofVar.rYW = wepkgCheckReq.scene;
                nxVar.vWI.add(ofVar);
            }
            aVar.hmj = nxVar;
            aVar.hmk = new ny();
            b JZ = aVar.JZ();
            WepkgRunCgi.a 1 = new 1(this);
            if (ac.cfw()) {
                u.a(JZ, new 1(1));
                return;
            }
            WepkgMainProcessTask remoteCgiTask = new RemoteCgiTask();
            d.bj(remoteCgiTask);
            remoteCgiTask.tOf = JZ;
            remoteCgiTask.tOg = 1;
            remoteCgiTask.tOd = 1;
            WepkgMainProcessService.a(remoteCgiTask);
        }
    }

    public final void Ys() {
    }

    public final void j(Parcel parcel) {
        if (this.tNO == null) {
            this.tNO = new ArrayList();
        }
        parcel.readList(this.tNO, WepkgCheckReq.class.getClassLoader());
        this.tNP = parcel.readInt();
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeList(this.tNO);
        parcel.writeInt(this.tNP);
    }
}
