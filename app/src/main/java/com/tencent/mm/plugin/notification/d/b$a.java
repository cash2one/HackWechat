package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class b$a {
    public b oUm = new b();
    public int oUn;
    public ArrayList<Long> oUo = new ArrayList();
    public ArrayList<Long> oUp = new ArrayList();

    public b$a(b bVar, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        this.oUm = bVar;
        this.oUn = i;
        this.oUo = arrayList;
        this.oUp = arrayList2;
    }

    public final String bgG() {
        x.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.oUm.oUk.size(); i++) {
                jSONArray.put(this.oUm.get(i));
            }
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
            jSONObject.put("msg_list", jSONArray);
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", new Object[]{Integer.valueOf(this.oUn)});
            jSONObject.put("current_send_index", this.oUn);
            jSONArray = new JSONArray();
            Iterator it = this.oUo.iterator();
            while (it.hasNext()) {
                jSONArray.put((Long) it.next());
            }
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
            jSONObject.put("success_msg_list", jSONArray);
            jSONArray = new JSONArray();
            it = this.oUp.iterator();
            while (it.hasNext()) {
                jSONArray.put((Long) it.next());
            }
            x.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
            jSONObject.put("fail_msg_list", jSONArray);
            return jSONObject.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            return null;
        }
    }

    public final void GM(String str) {
        x.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
            JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
            JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
            x.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", new Object[]{Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index"))});
            this.oUm.clear();
            this.oUp.clear();
            this.oUo.clear();
            for (i = 0; i < jSONArray.length(); i++) {
                this.oUm.dV(jSONArray.getLong(i));
            }
            for (i = 0; i < jSONArray2.length(); i++) {
                this.oUp.add(Long.valueOf(jSONArray2.getLong(i)));
            }
            for (i = 0; i < jSONArray3.length(); i++) {
                this.oUo.add(Long.valueOf(jSONArray3.getLong(i)));
            }
            this.oUn = r5;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            x.d("MicroMsg.FailMsgFileCache", "createFromFileContent error:%s", new Object[]{e.getMessage()});
        }
    }
}
