package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.or;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.cas;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SendAppMessageTask extends MainProcessTask {
    public static final Creator<SendAppMessageTask> CREATOR = new 2();
    String appId;
    String description;
    String fnp;
    String fpL;
    int fvM;
    int hoL;
    String iPL;
    String iUc;
    String iconUrl;
    Runnable jcI;
    String jqV;
    String jqW;
    String jqX;
    boolean jqY;
    int jqZ;
    String jra;
    String jrb;
    String jrc;
    boolean jrd;
    String jre;
    ArrayList<ShareInfo> jrf;
    String path;
    int scene = 1000;
    String title;
    String toUser;
    int type;
    String url;
    String userName;
    int version;
    boolean withShareTicket;

    public final void Yr() {
        Bitmap a;
        x.i("MicroMsg.SendAppMessageTask", "username = %s, thumbIconUrl = %s", new Object[]{this.userName, this.jqW});
        byte[] bArr = new byte[0];
        if (!bh.ov(this.jqW) && (this.jqW.startsWith("http://") || this.jqW.startsWith("https://"))) {
            a = b.Jj().a(this.jqW, null);
        } else if (bh.ov(this.jqX)) {
            a = null;
        } else {
            a = d.UN(this.jqX);
            if (this.jqY) {
                boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.jqX);
                x.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[]{this.jqX, Boolean.valueOf(deleteFile)});
            } else {
                x.v("MicroMsg.SendAppMessageTask", "decode thumb icon bitmap by path(%s)", new Object[]{this.jqX});
            }
        }
        if (a == null || a.isRecycled()) {
            x.e("MicroMsg.SendAppMessageTask", "thumb image is null");
        } else {
            x.i("MicroMsg.SendAppMessageTask", "thumb image is not null ");
            Bitmap createBitmap = Bitmap.createBitmap(a.getWidth(), a.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(-1);
            canvas.drawBitmap(a, 0.0f, 0.0f, null);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            createBitmap.recycle();
        }
        x.i("MicroMsg.SendAppMessageTask", "doSendMessage, appId : %s, title = %s, description = %s ,username = %s ,path = %s, thumbIconUrl = %s", new Object[]{this.appId, this.title, this.description, this.userName, this.path, this.jqW});
        u.GK().t(u.hz("wxapp_" + this.appId + this.path), true).o("prePublishId", "wxapp_" + this.appId + this.path);
        a aVar = new a();
        aVar.title = this.title;
        aVar.description = this.description;
        aVar.type = 33;
        aVar.hdx = this.userName;
        aVar.hdw = this.path;
        aVar.hdy = this.appId;
        aVar.hdE = this.fvM;
        aVar.hdF = this.version;
        aVar.hdA = this.iPL;
        aVar.hdz = this.type;
        aVar.url = this.url;
        aVar.hdG = this.iconUrl;
        aVar.fGF = "wxapp_" + this.appId + this.path;
        aVar.fGz = this.userName;
        aVar.fGA = this.fpL;
        com.tencent.mm.y.d aVar2 = new com.tencent.mm.y.a();
        aVar2.haz = this.jrd;
        aVar2.haA = this.iUc;
        aVar2.haB = this.hoL;
        aVar.a(aVar2);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.appId);
        stringBuilder.append("_");
        g.Dh();
        stringBuilder.append(o.getString(com.tencent.mm.kernel.a.Cg()));
        stringBuilder.append("_");
        stringBuilder.append(bh.Wo());
        stringBuilder.append("_");
        stringBuilder.append(this.jqZ);
        aVar.hdC = stringBuilder.toString();
        if (this.withShareTicket) {
            int i = this.scene;
            com.tencent.mm.ae.b.a aVar3 = new com.tencent.mm.ae.b.a();
            aVar3.hmi = 1118;
            aVar3.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_cas = new cas();
            com_tencent_mm_protocal_c_cas.fFm = this.appId;
            LinkedList linkedList = new LinkedList(bh.F(this.toUser.split(",")));
            com_tencent_mm_protocal_c_cas.xaa = linkedList;
            aVar3.hmj = com_tencent_mm_protocal_c_cas;
            aVar3.hmk = new cat();
            com.tencent.mm.ae.u.a(aVar3.JZ(), new 1(this, linkedList, aVar, bArr, stringBuilder, i));
            return;
        }
        Iterator it = new LinkedList(bh.F(this.toUser.split(","))).iterator();
        while (it.hasNext()) {
            a(aVar, bArr, (String) it.next(), stringBuilder, this.scene);
        }
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    private void a(a aVar, byte[] bArr, String str, StringBuilder stringBuilder, int i) {
        ((com.tencent.mm.plugin.appbrand.compat.a.a) g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(aVar, this.appId, this.title, str, bArr);
        if (!bh.ov(this.jqV)) {
            com.tencent.mm.sdk.b.b orVar = new or();
            orVar.fGI.fGJ = str;
            orVar.fGI.content = this.jqV;
            orVar.fGI.type = s.hp(str);
            orVar.fGI.flags = 0;
            com.tencent.mm.sdk.b.a.xef.m(orVar);
        }
        int i2 = 1;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List hH = ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fh().hH(str);
            i2 = hH != null ? hH.size() : 0;
        }
        String str2 = this.appId;
        String str3 = this.fnp;
        String str4 = this.jra;
        String str5 = this.title;
        String str6 = this.path;
        String str7 = this.jrb;
        String str8 = this.jrc;
        String stringBuilder2 = stringBuilder.toString();
        String str9 = this.jre;
        if (bh.ov(str2)) {
            x.e("MicroMsg.SendAppMessageTask", "appId is Null!");
            return;
        }
        String str10 = "";
        try {
            str10 = p.encode(bh.ou(str6), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.SendAppMessageTask", "encode share page path error!");
        }
        String str11 = "";
        try {
            str11 = p.encode(bh.ou(str7), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            x.e("MicroMsg.SendAppMessageTask", "encode current page path error!");
        }
        String str12 = "";
        try {
            str12 = p.encode(bh.ou(str9), "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            x.e("MicroMsg.SendAppMessageTask", "encode current html url error!");
        }
        x.d("MicroMsg.SendAppMessageTask", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s", new Object[]{Integer.valueOf(14077), str2, Integer.valueOf(i), str3, str4, str7, str8, str5, str6, stringBuilder2, Integer.valueOf(i2), str});
        com.tencent.mm.plugin.report.service.g.pQN.h(14077, new Object[]{str2, Integer.valueOf(i), str3, str4, str11, str8, str5, str10, stringBuilder2, "", Integer.valueOf(i2), str, str12});
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.userName = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.jqV = parcel.readString();
        this.toUser = parcel.readString();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.type = parcel.readInt();
        this.jqW = parcel.readString();
        this.iconUrl = parcel.readString();
        this.jqX = parcel.readString();
        this.jqY = parcel.readInt() == 1;
        this.fvM = parcel.readInt();
        this.iPL = parcel.readString();
        this.version = parcel.readInt();
        this.fpL = parcel.readString();
        this.jqZ = parcel.readInt();
        this.scene = parcel.readInt();
        this.fnp = parcel.readString();
        this.jra = parcel.readString();
        this.jrb = parcel.readString();
        this.jrc = parcel.readString();
        this.withShareTicket = parcel.readByte() == (byte) 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jrd = z;
        this.iUc = parcel.readString();
        this.hoL = parcel.readInt();
        this.jre = parcel.readString();
        this.jrf = parcel.readArrayList(SendAppMessageTask.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeString(this.userName);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.jqV);
        parcel.writeString(this.toUser);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeInt(this.type);
        parcel.writeString(this.jqW);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.jqX);
        parcel.writeInt(this.jqY ? 1 : 0);
        parcel.writeInt(this.fvM);
        parcel.writeString(this.iPL);
        parcel.writeInt(this.version);
        parcel.writeString(this.fpL);
        parcel.writeInt(this.jqZ);
        parcel.writeInt(this.scene);
        parcel.writeString(this.fnp);
        parcel.writeString(this.jra);
        parcel.writeString(this.jrb);
        parcel.writeString(this.jrc);
        parcel.writeByte((byte) (this.withShareTicket ? 1 : 0));
        if (!this.jrd) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.iUc);
        parcel.writeInt(this.hoL);
        parcel.writeString(this.jre);
        parcel.writeList(this.jrf);
    }

    protected SendAppMessageTask(Parcel parcel) {
        f(parcel);
    }
}
