package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.cbp;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.protocal.c.fy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask extends MainProcessTask {
    public static final Creator<ReportSubmitFormTask> CREATOR = new 2();
    public String appId;
    public String fCp;
    public int fIm;
    public int fno;
    public String jhm;
    public int type;

    static /* synthetic */ void a(ReportSubmitFormTask reportSubmitFormTask, LinkedList linkedList) {
        linkedList.addAll(afP());
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cbp com_tencent_mm_protocal_c_cbp = (cbp) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(DownloadSettingTable$Columns.TYPE, com_tencent_mm_protocal_c_cbp.type);
                jSONObject.put("appid", com_tencent_mm_protocal_c_cbp.fFm);
                jSONObject.put("formid", com_tencent_mm_protocal_c_cbp.xaG);
                jSONObject.put("pageid", com_tencent_mm_protocal_c_cbp.xaH);
                jSONObject.put("appstate", com_tencent_mm_protocal_c_cbp.xaI);
                jSONObject.put("appversion", com_tencent_mm_protocal_c_cbp.xaJ);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                x.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
            }
        }
        g.Dj().CU().a(a.xsB, jSONArray.toString());
    }

    public ReportSubmitFormTask(String str) {
        this.appId = str;
        this.fno = com.tencent.mm.plugin.appbrand.a.oS(str).iOI.iGK;
        this.fIm = com.tencent.mm.plugin.appbrand.a.oS(str).iOI.iGL;
    }

    public final void Yr() {
        b.a aVar = new b.a();
        aVar.hmj = new fx();
        aVar.hmk = new fy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        aVar.hmi = 1129;
        b JZ = aVar.JZ();
        final fx fxVar = (fx) JZ.hmg.hmo;
        fxVar.vLq = new LinkedList();
        cbp com_tencent_mm_protocal_c_cbp = new cbp();
        com_tencent_mm_protocal_c_cbp.type = this.type;
        com_tencent_mm_protocal_c_cbp.fFm = this.appId;
        com_tencent_mm_protocal_c_cbp.xaG = this.jhm;
        com_tencent_mm_protocal_c_cbp.xaH = this.fCp;
        com_tencent_mm_protocal_c_cbp.xaI = this.fno;
        com_tencent_mm_protocal_c_cbp.xaJ = this.fIm;
        fxVar.vLq.add(com_tencent_mm_protocal_c_cbp);
        synchronized (getClass()) {
            fxVar.vLq.addAll(afP());
        }
        u.a(JZ, new u.a(this) {
            final /* synthetic */ ReportSubmitFormTask jho;

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (!(i == 0 && i2 == 0)) {
                    synchronized (this.jho.getClass()) {
                        ReportSubmitFormTask.a(this.jho, fxVar.vLq);
                    }
                    x.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                }
                return 0;
            }
        });
    }

    private static LinkedList<cbp> afP() {
        LinkedList<cbp> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray((String) g.Dj().CU().get(a.xsB, null));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                cbp com_tencent_mm_protocal_c_cbp = new cbp();
                com_tencent_mm_protocal_c_cbp.type = jSONObject.getInt(DownloadSettingTable$Columns.TYPE);
                com_tencent_mm_protocal_c_cbp.fFm = jSONObject.getString("appid");
                com_tencent_mm_protocal_c_cbp.xaG = jSONObject.getString("formid");
                com_tencent_mm_protocal_c_cbp.xaH = jSONObject.getString("pageid");
                com_tencent_mm_protocal_c_cbp.xaI = jSONObject.getInt("appstate");
                com_tencent_mm_protocal_c_cbp.xaJ = jSONObject.getInt("appversion");
                linkedList.add(com_tencent_mm_protocal_c_cbp);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
        }
        g.Dj().CU().a(a.xsB, "");
        return linkedList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.jhm);
        parcel.writeString(this.fCp);
        parcel.writeInt(this.fno);
        parcel.writeInt(this.fIm);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.jhm = parcel.readString();
        this.fCp = parcel.readString();
        this.fno = parcel.readInt();
        this.fIm = parcel.readInt();
    }
}
