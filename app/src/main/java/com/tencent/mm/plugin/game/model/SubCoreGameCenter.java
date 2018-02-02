package com.tencent.mm.plugin.game.model;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.game.model.w.1;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs.a;
import java.util.HashMap;
import java.util.Map;

public final class SubCoreGameCenter implements ap {
    private static String neJ = "";
    @SuppressLint({"UseSparseArrays"})
    static HashMap<Integer, d> neK;
    private c bannerOnInitListener = new 15(this);
    private c kYX = new c<rb>(this) {
        final /* synthetic */ SubCoreGameCenter nfd;

        {
            this.nfd = r2;
            this.xen = rb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rb rbVar = (rb) bVar;
            if (rbVar.fIQ.fIR.equals(gr.class.getName())) {
                if (rbVar.fIQ.fut == 1) {
                    this.nfd.neT.aaZ();
                } else {
                    this.nfd.neT.unregister();
                }
            }
            return false;
        }
    };
    private a lNW = new a(this) {
        final /* synthetic */ SubCoreGameCenter nfd;

        {
            this.nfd = r1;
        }

        public final void a(com.tencent.mm.ae.d.a aVar) {
            com.tencent.mm.sdk.e.c cVar;
            w aRe = SubCoreGameCenter.aRe();
            String a = n.a(aVar.hmq.vGZ);
            x.i("MicroMsg.GameMessageService", "Received a message: %d", new Object[]{Long.valueOf(r1.vHe)});
            x.i("MicroMsg.GameMessageService", "Message content: %s" + a);
            new Thread(new 1(aRe, a)).start();
            if (bh.ov(a)) {
                x.e("MicroMsg.GameMessageParser", "msg content is null");
                cVar = null;
            } else {
                Map y = bi.y(a, "sysmsg");
                if (y == null || y.size() == 0) {
                    x.e("MicroMsg.GameMessageParser", "Parse failed");
                    cVar = null;
                } else if ("gamecenter".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
                    com.tencent.mm.sdk.e.c tVar = new t();
                    tVar.field_showInMsgList = true;
                    tVar.field_msgId = System.currentTimeMillis();
                    tVar.field_rawXML = a;
                    tVar.field_msgType = bh.getInt((String) y.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                    long j;
                    if (tVar.field_msgType == 100) {
                        aa.aQy();
                        tVar.field_gameMsgId = bh.az((String) y.get(".sysmsg.gamecenter.msg_id"), "");
                        tVar.field_appId = (String) y.get(".sysmsg.gamecenter.appid");
                        tVar.field_createTime = bh.getLong((String) y.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        j = bh.getLong((String) y.get(".sysmsg.gamecenter.time_info.expire_time"), 0);
                        if (j == 0) {
                            tVar.field_expireTime = Long.MAX_VALUE;
                        } else {
                            tVar.field_expireTime = j + bh.getLong((String) y.get(".sysmsg.gamecenter.time_info.create_time"), System.currentTimeMillis() / 1000);
                        }
                        tVar.field_isHidden = bh.getInt((String) y.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        tVar.field_mergerId = bh.az((String) y.get(".sysmsg.gamecenter.merge_id"), "");
                        tVar.field_weight = bh.az((String) y.get(".sysmsg.gamecenter.weight"), "");
                        tVar.field_receiveTime = System.currentTimeMillis() / 1000;
                        aa.d(y, tVar);
                        tVar.ncy = bh.getLong((String) y.get(".sysmsg.gamecenter.filter_flag"), 0);
                        tVar.ncz = bh.getInt((String) y.get(".sysmsg.gamecenter.msg_center.not_in_msg_center"), 0);
                        tVar.nck = bh.getInt((String) y.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0) > 0;
                        tVar.ncl.ncY = bh.az((String) y.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
                        if (bh.ov((String) y.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url")) && bh.ov((String) y.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"))) {
                            tVar.ncm = false;
                        } else {
                            tVar.ncm = true;
                        }
                        aa.e(y, tVar);
                        tVar.ncQ.ndl = bh.az((String) y.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
                        tVar.ncQ.kOC = bh.getInt((String) y.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
                        if (!bh.ov(tVar.ncQ.ndl)) {
                            tVar.field_isHidden = true;
                        }
                        tVar.ncQ.ndm = bh.getLong((String) y.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
                    } else {
                        tVar.field_gameMsgId = bh.az((String) y.get(".sysmsg.gamecenter.msg_id"), "");
                        tVar.field_msgType = bh.getInt((String) y.get(".sysmsg.gamecenter.$newmsgtype"), 0);
                        if (tVar.field_msgType == 0) {
                            tVar.field_msgType = bh.getInt((String) y.get(".sysmsg.gamecenter.$msgtype"), 0);
                        }
                        tVar.field_appId = (String) y.get(".sysmsg.gamecenter.appinfo.appid");
                        tVar.field_showInMsgList = !bh.ov(v.y(y));
                        tVar.field_createTime = bh.getLong((String) y.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        j = bh.getLong((String) y.get(".sysmsg.game_control_info.expiredtime"), 0);
                        if (j == 0) {
                            tVar.field_expireTime = Long.MAX_VALUE;
                        } else {
                            tVar.field_expireTime = j + bh.getLong((String) y.get(".sysmsg.game_control_info.createtime"), System.currentTimeMillis() / 1000);
                        }
                        tVar.field_isHidden = bh.getInt((String) y.get(".sysmsg.gamecenter.wifi_flag"), 0) > 0;
                        tVar.field_mergerId = bh.az((String) y.get(".sysmsg.gamecenter.merge_id"), "");
                        if (tVar.field_msgType == 10) {
                            tVar.field_weight = "6";
                        } else {
                            tVar.field_weight = "2";
                        }
                        tVar.field_receiveTime = System.currentTimeMillis() / 1000;
                        tVar.ncy = bh.getLong((String) y.get(".sysmsg.game_control_info.filter_flag"), 0);
                        tVar.ncx = v.z(y);
                        tVar.ncz = bh.getInt((String) y.get(".sysmsg.game_control_info.not_in_msg_center"), 0);
                        tVar.ncm = bh.getInt((String) y.get(".sysmsg.gamecenter.message_bubble_info.show_message_bubble"), 0) > 0;
                        tVar.ncT = bh.az((String) y.get(".sysmsg.gamecenter.noticeid"), "");
                        tVar.ncl.nda = bh.getInt((String) y.get(".sysmsg.gamecenter.badge_display_type"), 0);
                        tVar.nck = tVar.ncl.nda > 0;
                        if ((tVar.ncx & 4) == 0) {
                            tVar.nck = false;
                        }
                        v.b(y, tVar);
                    }
                    if (tVar.ncz == 1) {
                        tVar.field_showInMsgList = false;
                    }
                    cVar = tVar;
                } else {
                    x.e("MicroMsg.GameMessageParser", "Type not matched");
                    cVar = null;
                }
            }
            if (cVar != null) {
                int i;
                x.i("MicroMsg.GameMessageService", "type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(cVar.field_msgType), cVar.field_appId, Long.valueOf(cVar.field_msgId)});
                if (cVar == null) {
                    x.e("MicroMsg.GameMessageService", "msg is null");
                    i = -1;
                } else {
                    Object obj;
                    long j2;
                    t aQn;
                    String str = cVar.field_gameMsgId;
                    if (!bh.ov(str)) {
                        int i2 = 0;
                        Cursor rawQuery = SubCoreGameCenter.aRd().rawQuery("select count(*) from GameRawMessage where gameMsgId = \"" + str + "\"", new String[0]);
                        if (rawQuery != null) {
                            if (rawQuery.moveToFirst()) {
                                i2 = rawQuery.getInt(0);
                            }
                            rawQuery.close();
                            if (i2 > 0) {
                                obj = 1;
                                if (obj == null) {
                                    x.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{cVar.field_gameMsgId});
                                    i = 2;
                                } else {
                                    if ((cVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                                        x.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{cVar.field_gameMsgId});
                                        i = 1;
                                    } else {
                                        j2 = cVar.ncy;
                                        a = cVar.field_appId;
                                        if (j2 != 1) {
                                            if (bh.ov(a) || !g.m(ac.getContext(), a)) {
                                            }
                                            i = 0;
                                        } else {
                                            if (j2 == 2 && (bh.ov(a) || g.m(ac.getContext(), a))) {
                                            }
                                            i = 0;
                                        }
                                        if (i == 0) {
                                            x.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[]{cVar.field_gameMsgId, Integer.valueOf(i)});
                                        } else {
                                            if (cVar.field_msgType != 20) {
                                                aQn = w.aQn();
                                                if (aQn == null) {
                                                    aQn = w.aQp();
                                                }
                                                if (aQn == null) {
                                                    aQn = w.aQr();
                                                }
                                                if (aQn != null) {
                                                    w.a(cVar, aQn);
                                                    if ((cVar.field_weight.compareTo(aQn.field_weight) < 0 ? 1 : null) == null) {
                                                        obj = null;
                                                        if (obj != null) {
                                                            if (cVar.nck) {
                                                                ar.Hg();
                                                                com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(0));
                                                            } else {
                                                                ar.Hg();
                                                                com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(cVar.field_msgId));
                                                            }
                                                            if (bh.ov(cVar.ncA.url)) {
                                                                ar.Hg();
                                                                com.tencent.mm.z.c.CU().a(w.a.xpP, Long.valueOf(cVar.field_msgId));
                                                            } else {
                                                                w.aQq();
                                                            }
                                                            if (cVar.ncm) {
                                                                w.aQs();
                                                            } else {
                                                                ar.Hg();
                                                                com.tencent.mm.z.c.CU().a(w.a.xpM, Long.valueOf(cVar.field_msgId));
                                                            }
                                                        }
                                                        if (cVar.field_msgType == 4) {
                                                            ar.Hg();
                                                            com.tencent.mm.z.c.CU().a(w.a.xpO, Long.valueOf(cVar.field_msgId));
                                                        }
                                                        if (!(cVar == null || bh.ov(cVar.ncl.ncY))) {
                                                            com.tencent.mm.plugin.game.d.c.Cn(cVar.ncl.ncY);
                                                        }
                                                    }
                                                }
                                                obj = 1;
                                                if (obj != null) {
                                                    if (cVar.nck) {
                                                        ar.Hg();
                                                        com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(0));
                                                    } else {
                                                        ar.Hg();
                                                        com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(cVar.field_msgId));
                                                    }
                                                    if (bh.ov(cVar.ncA.url)) {
                                                        w.aQq();
                                                    } else {
                                                        ar.Hg();
                                                        com.tencent.mm.z.c.CU().a(w.a.xpP, Long.valueOf(cVar.field_msgId));
                                                    }
                                                    if (cVar.ncm) {
                                                        w.aQs();
                                                    } else {
                                                        ar.Hg();
                                                        com.tencent.mm.z.c.CU().a(w.a.xpM, Long.valueOf(cVar.field_msgId));
                                                    }
                                                }
                                                if (cVar.field_msgType == 4) {
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.CU().a(w.a.xpO, Long.valueOf(cVar.field_msgId));
                                                }
                                                com.tencent.mm.plugin.game.d.c.Cn(cVar.ncl.ncY);
                                            }
                                            i = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        if (cVar.field_expireTime > System.currentTimeMillis() / 1000) {
                        }
                        if ((cVar.field_expireTime > System.currentTimeMillis() / 1000 ? null : 1) != null) {
                            j2 = cVar.ncy;
                            a = cVar.field_appId;
                            i = j2 != 1 ? 4 : 3;
                            if (i == 0) {
                                if (cVar.field_msgType != 20) {
                                    aQn = w.aQn();
                                    if (aQn == null) {
                                        aQn = w.aQp();
                                    }
                                    if (aQn == null) {
                                        aQn = w.aQr();
                                    }
                                    if (aQn != null) {
                                        w.a(cVar, aQn);
                                        if (cVar.field_weight.compareTo(aQn.field_weight) < 0) {
                                        }
                                        if ((cVar.field_weight.compareTo(aQn.field_weight) < 0 ? 1 : null) == null) {
                                            obj = null;
                                            if (obj != null) {
                                                if (cVar.nck) {
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(0));
                                                }
                                                if (bh.ov(cVar.ncA.url)) {
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.CU().a(w.a.xpP, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    w.aQq();
                                                }
                                                if (cVar.ncm) {
                                                    ar.Hg();
                                                    com.tencent.mm.z.c.CU().a(w.a.xpM, Long.valueOf(cVar.field_msgId));
                                                } else {
                                                    w.aQs();
                                                }
                                            }
                                            if (cVar.field_msgType == 4) {
                                                ar.Hg();
                                                com.tencent.mm.z.c.CU().a(w.a.xpO, Long.valueOf(cVar.field_msgId));
                                            }
                                            com.tencent.mm.plugin.game.d.c.Cn(cVar.ncl.ncY);
                                        }
                                    }
                                    obj = 1;
                                    if (obj != null) {
                                        if (cVar.nck) {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(0));
                                        } else {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.xpL, Long.valueOf(cVar.field_msgId));
                                        }
                                        if (bh.ov(cVar.ncA.url)) {
                                            w.aQq();
                                        } else {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.xpP, Long.valueOf(cVar.field_msgId));
                                        }
                                        if (cVar.ncm) {
                                            w.aQs();
                                        } else {
                                            ar.Hg();
                                            com.tencent.mm.z.c.CU().a(w.a.xpM, Long.valueOf(cVar.field_msgId));
                                        }
                                    }
                                    if (cVar.field_msgType == 4) {
                                        ar.Hg();
                                        com.tencent.mm.z.c.CU().a(w.a.xpO, Long.valueOf(cVar.field_msgId));
                                    }
                                    com.tencent.mm.plugin.game.d.c.Cn(cVar.ncl.ncY);
                                }
                                i = 0;
                            } else {
                                x.e("MicroMsg.GameMessageService", "checkFilter failed,%s, status: %d", new Object[]{cVar.field_gameMsgId, Integer.valueOf(i)});
                            }
                        } else {
                            x.e("MicroMsg.GameMessageService", "msg is expired Time, %s", new Object[]{cVar.field_gameMsgId});
                            i = 1;
                        }
                    } else {
                        x.e("MicroMsg.GameMessageService", "duplicated msg:%s", new Object[]{cVar.field_gameMsgId});
                        i = 2;
                    }
                }
                if (i == 0) {
                    if (cVar.field_msgType == 20) {
                        com.tencent.mm.sdk.e.c BW = SubCoreGameCenter.aRd().BW(cVar.field_appId);
                        if (BW != null) {
                            SubCoreGameCenter.aRd().a(BW, new String[0]);
                            x.i("MicroMsg.GameMessageService", "duplicated appId, type = %d, appId = %s, msgId = %s", new Object[]{Integer.valueOf(BW.field_msgType), BW.field_appId, Long.valueOf(BW.field_msgId)});
                        }
                    }
                    w.g(cVar);
                    x.i("MicroMsg.GameMessageService", "Insert raw message: %b", new Object[]{Boolean.valueOf(SubCoreGameCenter.aRd().b(cVar))});
                    if (SubCoreGameCenter.aRd().b(cVar) && cVar.field_msgType == 20) {
                        e.a(cVar);
                    }
                }
                int i3 = cVar.field_msgType;
                if (cVar.field_msgType == 100) {
                    i3 = cVar.ncS;
                }
                ap.a(ac.getContext(), 0, 0, 0, 18, i, cVar.field_appId, 0, i3, cVar.field_gameMsgId, cVar.ncT, ap.cL("resource", String.valueOf(cVar.ncl.nda)));
            }
        }
    };
    private x neD;
    private w neE;
    private c neF;
    private ao neG;
    private z neH;
    private ac neI;
    private c neL = new 23(this);
    private c neM = new 24(this);
    private c neN = new 25(this);
    private c neO = new 26(this);
    private c neP = new 2(this);
    private c neQ = new 3(this);
    private c neR = new 4(this);
    private c neS = new 5(this);
    com.tencent.mm.pluginsdk.d.d neT = new 6(this);
    private c neU = new 8(this);
    private c neV = new 9(this);
    private c neW = new 10(this);
    private c neX = new 11(this);
    private c neY = new 13(this);
    private c neZ = new 14(this);
    private c nfa = new 16(this);
    private c nfb = new 17(this);
    private c nfc = new 18(this);

    public SubCoreGameCenter() {
        q.a.vcu = new 1(this);
    }

    static {
        HashMap hashMap = new HashMap();
        neK = hashMap;
        hashMap.put(Integer.valueOf("GAME_CENTER_MSG_INFO_TABLE".hashCode()), new 12());
        neK.put(Integer.valueOf("GAME_CENTER_JSON_CACHE_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return r.gJN;
            }
        });
        neK.put(Integer.valueOf("GAME_CENTER_PB_CACHE_TABLE".hashCode()), new 21());
    }

    public static String aRb() {
        return neJ;
    }

    private static SubCoreGameCenter aRc() {
        ar.Ha();
        SubCoreGameCenter subCoreGameCenter = (SubCoreGameCenter) bp.hY("plugin.game");
        if (subCoreGameCenter != null) {
            return subCoreGameCenter;
        }
        Object subCoreGameCenter2 = new SubCoreGameCenter();
        ar.Ha().a("plugin.game", subCoreGameCenter2);
        return subCoreGameCenter2;
    }

    public static x aRd() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aRc().neD == null) {
            SubCoreGameCenter aRc = aRc();
            ar.Hg();
            aRc.neD = new x(com.tencent.mm.z.c.EV());
        }
        return aRc().neD;
    }

    public static w aRe() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aRc().neE == null) {
            aRc().neE = new w();
        }
        return aRc().neE;
    }

    public static ao aRf() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aRc().neG == null) {
            aRc().neG = new ao();
        }
        return aRc().neG;
    }

    public static z aRg() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aRc().neH == null) {
            aRc().neH = new z();
        }
        return aRc().neH;
    }

    public static ac aRh() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aRc().neI == null) {
            SubCoreGameCenter aRc = aRc();
            ar.Hg();
            aRc.neI = new ac(com.tencent.mm.z.c.EV());
        }
        return aRc().neI;
    }

    public static com.tencent.mm.pluginsdk.model.app.d aRi() {
        return an.aRi();
    }

    public static c aRj() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aRc().neF == null) {
            aRc().neF = new c();
        }
        return aRc().neF;
    }

    public final HashMap<Integer, d> Bn() {
        return neK;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ar.getSysCmdMsgExtension().a("gamecenter", this.lNW, true);
        com.tencent.mm.sdk.b.a.xef.b(this.neL);
        com.tencent.mm.sdk.b.a.xef.b(this.neM);
        com.tencent.mm.sdk.b.a.xef.b(this.kYX);
        com.tencent.mm.sdk.b.a.xef.b(this.neN);
        com.tencent.mm.sdk.b.a.xef.b(this.neO);
        com.tencent.mm.sdk.b.a.xef.b(this.neP);
        com.tencent.mm.sdk.b.a.xef.b(this.neQ);
        com.tencent.mm.sdk.b.a.xef.b(this.neR);
        com.tencent.mm.sdk.b.a.xef.b(this.neU);
        com.tencent.mm.sdk.b.a.xef.b(this.neV);
        com.tencent.mm.sdk.b.a.xef.b(this.neS);
        com.tencent.mm.sdk.b.a.xef.b(this.neW);
        com.tencent.mm.sdk.b.a.xef.b(this.neX);
        com.tencent.mm.sdk.b.a.xef.b(this.neY);
        com.tencent.mm.sdk.b.a.xef.b(this.neZ);
        com.tencent.mm.sdk.b.a.xef.b(this.bannerOnInitListener);
        com.tencent.mm.sdk.b.a.xef.b(this.nfa);
        com.tencent.mm.sdk.b.a.xef.b(this.nfb);
        com.tencent.mm.sdk.b.a.xef.b(this.nfc);
        n.aPU();
        e.aPU();
        i.aQb().XH();
        ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon().a(-86016, new 19(this));
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        ar.getSysCmdMsgExtension().b("gamecenter", this.lNW, true);
        com.tencent.mm.sdk.b.a.xef.c(this.neL);
        com.tencent.mm.sdk.b.a.xef.c(this.neM);
        com.tencent.mm.sdk.b.a.xef.c(this.kYX);
        com.tencent.mm.sdk.b.a.xef.c(this.neN);
        com.tencent.mm.sdk.b.a.xef.c(this.neO);
        com.tencent.mm.sdk.b.a.xef.c(this.neP);
        com.tencent.mm.sdk.b.a.xef.c(this.neQ);
        com.tencent.mm.sdk.b.a.xef.c(this.neR);
        com.tencent.mm.sdk.b.a.xef.c(this.neU);
        com.tencent.mm.sdk.b.a.xef.c(this.neV);
        com.tencent.mm.sdk.b.a.xef.c(this.neS);
        com.tencent.mm.sdk.b.a.xef.c(this.neW);
        com.tencent.mm.sdk.b.a.xef.c(this.neX);
        com.tencent.mm.sdk.b.a.xef.c(this.neY);
        com.tencent.mm.sdk.b.a.xef.c(this.neZ);
        com.tencent.mm.sdk.b.a.xef.c(this.bannerOnInitListener);
        com.tencent.mm.sdk.b.a.xef.c(this.nfa);
        com.tencent.mm.sdk.b.a.xef.c(this.nfb);
        com.tencent.mm.sdk.b.a.xef.c(this.nfc);
        com.tencent.mm.plugin.game.d.c.alJ();
        if (this.neG != null) {
            e eVar = this.neG;
            if (eVar.nea != null) {
                eVar.nea.clear();
            }
            ar.CG().b(427, eVar);
        }
        if (this.neH != null) {
            ar.CG().b(1223, this.neH);
        }
        ((m) com.tencent.mm.kernel.g.k(m.class)).unregisterIndexStorage(16);
        ((m) com.tencent.mm.kernel.g.k(m.class)).unregisterNativeLogic(5);
        h.qh(80);
        h.qh(4144);
        n.aPV();
        e.aPV();
    }
}
