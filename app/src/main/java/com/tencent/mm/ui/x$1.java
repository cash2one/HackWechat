package com.tencent.mm.ui;

import com.tencent.mm.bc.k;
import com.tencent.mm.bf.l;
import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.q.d;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import org.json.JSONObject;

class x$1 implements Runnable {
    final /* synthetic */ x xKV;

    x$1(x xVar) {
        this.xKV = xVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        if (!g.Dh().Cy()) {
            x.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "Account not Ready!!!");
        } else if (this.xKV.xKP == null) {
            x.w("MicroMsg.LauncherUI.MainTabUnreadMgr", "set tag job, but tab view is null");
        } else {
            int i;
            boolean z;
            k Re;
            JSONObject NT;
            boolean z2;
            if (ar.Hj()) {
                int FW = q.FW();
                if ((q.Gd() & 64) == 0 && (FW & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                    FW = com.tencent.mm.z.k.FO() + 0;
                } else {
                    FW = 0;
                }
                if ((q.Gd() & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 || a.bXU()) {
                    i = 0;
                } else {
                    i = l.Ty().Tq() + 0;
                }
                if ((q.Gd() & 256) == 0) {
                    com.tencent.mm.bf.k Tz = l.Tz();
                    if (Tz != null) {
                        i += Tz.Tq();
                    }
                    i += com.tencent.mm.pluginsdk.q.a.bXY().brv();
                }
                FW += i;
                if ((q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0 && n.qQA != null) {
                    FW += n.qQA.Tq();
                }
                i = FW;
            } else {
                x.w("MicroMsg.UnreadCountHelper", "getFindTabUnreadCount, but mmcore not ready");
                i = 0;
            }
            this.xKV.xKP.lM(false);
            this.xKV.xKP.DJ(i);
            if (i <= 0 && a.bXU() && l.Ty().Tq() > 0) {
                this.xKV.xKP.lM(true);
            }
            if (i <= 0 && (q.Gd() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                ar.Hg();
                if (t.d((Boolean) c.CU().get(68384, null))) {
                    ar.Hg();
                    if (t.ov((String) c.CU().get(68377, null))) {
                        ar.Hg();
                        if (((Boolean) c.CU().get(589825, Boolean.valueOf(false))).booleanValue()) {
                            this.xKV.xKP.lM(true);
                            return;
                        }
                    }
                    this.xKV.xKP.lM(true);
                    return;
                }
            }
            if (i <= 0) {
                z = (q.FX() & 4194304) != 0;
                String value = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigName");
                String value2 = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigIconUrl");
                String value3 = com.tencent.mm.k.g.zY().getValue("JDEntranceConfigJumpUrl");
                x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd tryshow configName " + value + " iconUrl " + value2 + " jumpUrl " + value3);
                if (!(z || t.ov(value) || t.ov(value2) || t.ov(value3))) {
                    com.tencent.mm.pluginsdk.q.k kVar = z.vcD;
                    if (kVar != null) {
                        boolean bDQ = kVar.bDQ();
                        x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jdshowFriend " + bDQ);
                        if (bDQ) {
                            d bDY = kVar.bDY();
                            if (!bDY.agj() || bDY.bDH()) {
                                x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "jd time is not start or jd time isExpire");
                            } else {
                                this.xKV.xKP.lM(true);
                                return;
                            }
                        }
                    }
                }
            }
            z = (q.FX() & 33554432) != 0;
            if (!com.tencent.mm.plugin.ipcall.d.aTd()) {
                ar.Hg();
                c.CU().a(w.a.xpr, Boolean.valueOf(false));
            } else if (!(z || this.xKV.xKP.clL() || i > 0)) {
                ar.Hg();
                if (((Integer) c.CU().get(w.a.xps, Integer.valueOf(0))).intValue() >= com.tencent.mm.k.g.zY().getInt("WCOEntranceRedDot", 0)) {
                    ar.Hg();
                }
                this.xKV.xKP.lM(true);
            }
            if ((q.FX() & 2097152) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Re = k.Re();
                if (Re.hLd != null && Re.hLd.isValid() && Re.hLd.hLj == 1) {
                    NT = h.NT("discoverSearchEntry");
                    if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QC("labs1de6f3")) {
                        if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QA("labs1de6f3")) {
                            z = true;
                        }
                        z = false;
                    } else {
                        if (NT.optInt("entrySwitch") == 1) {
                            z = true;
                        }
                        z = false;
                    }
                    x.i("SearchRedPointMgr", "search show %b", new Object[]{Boolean.valueOf(z)});
                    if (z) {
                        z = true;
                        if (z) {
                            this.xKV.xKP.lM(true);
                        }
                    }
                }
                z = false;
                if (z) {
                    this.xKV.xKP.lM(true);
                }
            }
            Re = k.Re();
            if (Re.hLe != null && Re.hLe.isValid() && Re.hLe.hLj == 1) {
                NT = h.NT("discoverRecommendEntry");
                if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QC("labs_browse")) {
                    if (((com.tencent.mm.plugin.welab.a.a.a) g.h(com.tencent.mm.plugin.welab.a.a.a.class)).QA("labs_browse")) {
                        z = true;
                    }
                    z = false;
                } else {
                    if (NT.optInt("entrySwitch") == 1) {
                        z = true;
                    }
                    z = false;
                }
                x.i("SearchRedPointMgr", "recommend show %b", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    z = true;
                    if (z) {
                        this.xKV.xKP.lM(true);
                    }
                    ar.Hg();
                    if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (bh.getInt(com.tencent.mm.k.g.zY().getValue("VoiceprintEntry"), 0) != 1) {
                        ar.Hg();
                        z = ((Boolean) c.CU().get(w.a.xnF, Boolean.valueOf(true))).booleanValue();
                    } else {
                        z = false;
                    }
                    if (z && r2) {
                        x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
                        this.xKV.xKP.lN(true);
                    }
                    this.xKV.xKQ = false;
                }
            }
            z = false;
            if (z) {
                this.xKV.xKP.lM(true);
            }
            ar.Hg();
            if ((c.CU().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (bh.getInt(com.tencent.mm.k.g.zY().getValue("VoiceprintEntry"), 0) != 1) {
                z = false;
            } else {
                ar.Hg();
                z = ((Boolean) c.CU().get(w.a.xnF, Boolean.valueOf(true))).booleanValue();
            }
            x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "show voiceprint dot");
            this.xKV.xKP.lN(true);
            this.xKV.xKQ = false;
        }
    }

    public final String toString() {
        return super.toString() + "|setTagRunnable";
    }
}
