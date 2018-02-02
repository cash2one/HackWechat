package com.tencent.mm.plugin.subapp.c;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class j implements e {
    private static int flV = 0;
    Queue<String> flN = new LinkedList();
    Queue<String> flO = new LinkedList();
    Map<String, a> flP = new HashMap();
    private boolean flQ = false;
    private boolean flR = false;
    private boolean flS = false;
    int flT = 0;
    private long flU = 0;
    a flX = new a();
    private ak flY = new ak(ar.Dm().oAt.getLooper(), new 3(this), false);

    static /* synthetic */ void h(j jVar) {
        jVar.flU = System.currentTimeMillis();
        if ((!jVar.flQ && jVar.flO.size() == 0) || (!jVar.flR && jVar.flN.size() == 0)) {
            Cursor a = d.bEb().gJP.a(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            List list = null;
            int i = 0;
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.b(a);
                    list.add(gVar);
                    i++;
                } while (a.moveToNext());
            }
            a.close();
            x.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:" + i);
            if (r1 == null) {
                x.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                x.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + r1.size());
            }
            if (!(r1 == null || r1.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String fJ = bh.fJ(currentTimeMillis);
                for (g gVar2 : r1) {
                    if (jVar.flP.containsKey(gVar2.field_filename)) {
                        x.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        x.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + bh.fJ(gVar2.field_createtime) + " last:" + bh.fJ(gVar2.field_lastmodifytime) + " now:" + bh.fJ(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        Object obj = (gVar2.field_status == 5 || gVar2.field_status == 6) ? 1 : null;
                        if (obj != null) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bh.fJ(gVar2.field_lastmodifytime) + " now:" + fJ);
                                h.ny(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bh.fJ(gVar2.field_lastmodifytime) + " now:" + fJ);
                                h.ny(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                x.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                jVar.flO.offer(gVar2.field_filename);
                                jVar.flP.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.UH()) {
                            x.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bh.fJ(gVar2.field_lastmodifytime) + " now:" + fJ);
                                h.ny(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                x.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + bh.fJ(gVar2.field_lastmodifytime) + " now:" + fJ);
                                h.ny(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                x.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                jVar.flN.offer(gVar2.field_filename);
                                jVar.flP.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                x.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + jVar.flP.size() + " [recv:" + jVar.flO.size() + ",send:" + jVar.flN.size() + "]");
                jVar.flO.size();
                jVar.flN.size();
            }
        }
        if (jVar.flQ || jVar.flO.size() != 0 || jVar.flR || jVar.flN.size() != 0) {
            String str;
            if (!jVar.flQ && jVar.flO.size() > 0) {
                str = (String) jVar.flO.poll();
                x.d("MicroMsg.VoiceRemindService", "Start Recv :" + str);
                if (str != null) {
                    jVar.flP.put(str, new a());
                    jVar.flQ = true;
                    x.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!jVar.flR && jVar.flN.size() > 0) {
                str = (String) jVar.flN.poll();
                x.d("MicroMsg.VoiceRemindService", "Start Send :" + str);
                if (str != null) {
                    jVar.flP.put(str, new a());
                    jVar.flR = true;
                    ar.CG().a(new b(str), 0);
                    return;
                }
                return;
            }
            return;
        }
        jVar.vB();
        x.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
    }

    static /* synthetic */ int vC() {
        int i = flV;
        flV = i + 1;
        return i;
    }

    static /* synthetic */ int vD() {
        int i = flV;
        flV = i - 1;
        return i;
    }

    public j() {
        ar.CG().a(329, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.Dm().F(new 1(this, kVar, i, i2));
    }

    private void vB() {
        this.flP.clear();
        this.flN.clear();
        this.flO.clear();
        this.flR = false;
        this.flQ = false;
        this.flS = false;
        x.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.flX.zi());
    }

    public final void run() {
        ar.Dm().F(new 2(this));
    }
}
