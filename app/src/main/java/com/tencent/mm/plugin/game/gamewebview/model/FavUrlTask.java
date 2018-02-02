package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;

public class FavUrlTask extends GWMainProcessTask {
    public static final Creator<FavUrlTask> CREATOR = new 1();
    public int actionType;
    public boolean fnI;
    public boolean mXH;
    public boolean mXI;
    public Bundle msB;
    public int ret;
    public int type;

    public final void Yr() {
        b qnVar;
        switch (this.actionType) {
            case 1:
                if (this.msB != null) {
                    boolean a;
                    long j = this.msB.getLong("msg_id", Long.MIN_VALUE);
                    String string = this.msB.getString("sns_local_id");
                    int i = this.msB.getInt("news_svr_id", 0);
                    String string2 = this.msB.getString("news_svr_tweetid");
                    b cfVar = new cf();
                    if (Long.MIN_VALUE != j) {
                        cfVar.fqp.fqt = this.msB.getInt("message_index", 0);
                        a = f.a(cfVar, j);
                    } else if (!bh.ov(string)) {
                        qnVar = new qn();
                        qnVar.fIc.fIf = string;
                        qnVar.fIc.fIg = cfVar;
                        qnVar.fIc.url = this.msB.getString("rawUrl");
                        a.xef.m(qnVar);
                        a = qnVar.fId.fpW;
                    } else if (i != 0) {
                        qnVar = new mh();
                        qnVar.fEe.opType = 3;
                        qnVar.fEe.fEg = cfVar;
                        qnVar.fEe.fEh = i;
                        qnVar.fEe.fEi = string2;
                        a.xef.m(qnVar);
                        a = qnVar.fEf.fpW;
                    } else {
                        this.mXH = true;
                        return;
                    }
                    if (a) {
                        String ou = bh.ou(this.msB.getString("prePublishId"));
                        String hz = u.hz(ou);
                        u.b t = u.GK().t(hz, true);
                        t.o("sendAppMsgScene", Integer.valueOf(2));
                        t.o("preChatName", this.msB.getString("preChatName"));
                        t.o("preMsgIndex", Integer.valueOf(this.msB.getInt("preMsgIndex")));
                        t.o("prePublishId", ou);
                        t.o("preUsername", this.msB.getString("preUsername"));
                        t.o("getA8KeyScene", this.msB.getString("getA8KeyScene"));
                        t.o("referUrl", this.msB.getString("referUrl"));
                        Bundle bundle = this.msB.getBundle("jsapiargs");
                        if (bundle != null) {
                            t.o("adExtStr", bundle.getString("key_snsad_statextstr"));
                        }
                        cfVar.fqp.fqu = hz;
                        a.xef.m(cfVar);
                    } else {
                        if (cfVar.fqp.fqv == 0) {
                            cfVar.fqp.fqv = R.l.efp;
                        }
                        a.xef.m(cfVar);
                    }
                    this.ret = cfVar.fqq.ret;
                    return;
                }
                return;
            case 2:
                qnVar = new fv();
                qnVar.fvq.type = 35;
                a.xef.m(qnVar);
                return;
            case 3:
                this.mXI = d.OQ("favorite");
                return;
            case 4:
                qnVar = new ca();
                qnVar.fqi.fqk = this.msB.getLong("fav_local_id", -1);
                a.xef.m(qnVar);
                x.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[]{Long.valueOf(qnVar.fqi.fqk), Boolean.valueOf(qnVar.fqj.fpW)});
                this.fnI = qnVar.fqj.fpW;
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.actionType = parcel.readInt();
        this.msB = parcel.readBundle();
        this.mXH = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.fnI = z;
        this.ret = parcel.readInt();
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.mXI = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.actionType);
        parcel.writeBundle(this.msB);
        parcel.writeByte((byte) (this.mXH ? 1 : 0));
        if (this.fnI) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.ret);
        parcel.writeInt(this.type);
        if (!this.mXI) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    private FavUrlTask(Parcel parcel) {
        f(parcel);
    }
}
