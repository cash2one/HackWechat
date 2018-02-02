package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Point;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.e;
import com.tencent.mm.plugin.sns.f.g;
import com.tencent.mm.plugin.sns.k;
import com.tencent.mm.plugin.sns.lucky.a.f;
import com.tencent.mm.plugin.sns.m;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ar;
import com.tencent.mm.z.an;
import com.tencent.mm.z.ap;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class ae implements j, ap {
    private static String qVU = "";
    protected static HashMap<Integer, d> qVV = new HashMap();
    public static boolean qVo = true;
    private static int qVp = 0;
    private static int qVq = 0;
    private static int qVv;
    private static int qVw;
    private static int qWd = 103;
    private static Point qWe = new Point();
    private h gQj;
    private byte[] gSF = new byte[0];
    private af handler = new af(Looper.getMainLooper());
    private String hlT;
    private boolean mpo = false;
    private c oKc = new 32(this);
    private com.tencent.mm.plugin.sns.storage.d qVA;
    private x qVB;
    private g qVC;
    private l qVD;
    private com.tencent.mm.plugin.sns.storage.j qVE;
    private t qVF;
    private ac qVG;
    private a qVH;
    private b qVI;
    private av qVJ;
    private aj qVK;
    private com.tencent.mm.plugin.sns.f.c qVL;
    private g qVM;
    private p qVN;
    private i qVO;
    private an qVP = new an();
    private boolean qVQ = true;
    private v qVR = new v();
    private boolean qVS = false;
    private byte[] qVT = new byte[0];
    private com.tencent.mm.plugin.sns.d qVW;
    private com.tencent.mm.plugin.sns.e.a qVX;
    private aq qVY;
    private f qVZ = new f();
    private af[] qVr = new af[3];
    private af[] qVs = new af[1];
    private af qVt = null;
    private af qVu = null;
    private r qVx;
    private n qVy;
    private com.tencent.mm.plugin.sns.storage.f qVz;
    private c qWA = new c<cj>(this) {
        final /* synthetic */ ae qWL;

        {
            this.qWL = r2;
            this.xen = cj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ae.bvK();
            return false;
        }
    };
    private c qWB = new 24(this);
    private c qWC = new 25(this);
    private c qWD = new 26(this);
    private c qWE = new 27(this);
    private c qWF = new 28(this);
    private c qWG = new c<bi>(this) {
        final /* synthetic */ ae qWL;

        {
            this.qWL = r2;
            this.xen = bi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            l bvz = ae.bvz();
            System.currentTimeMillis();
            boolean fx = bvz.gJP.fx("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", new Object[]{"update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(fx)});
            return false;
        }
    };
    private c qWH = new 30(this);
    private boolean qWI = false;
    private c qWJ = new 33(this);
    private c qWK = new 35(this);
    private com.tencent.mm.plugin.sns.lucky.a.j qWa = new com.tencent.mm.plugin.sns.lucky.a.j();
    private com.tencent.mm.plugin.sns.lucky.a.d qWb = new com.tencent.mm.plugin.sns.lucky.a.d();
    private com.tencent.mm.plugin.sns.lucky.a.l qWc = new com.tencent.mm.plugin.sns.lucky.a.l();
    private com.tencent.mm.plugin.sns.n qWf;
    private k qWg;
    private e qWh;
    private com.tencent.mm.plugin.sns.p qWi;
    private com.tencent.mm.plugin.sns.h qWj;
    private com.tencent.mm.plugin.sns.g qWk;
    private m qWl;
    private com.tencent.mm.plugin.sns.j qWm;
    private com.tencent.mm.plugin.sns.b qWn;
    private com.tencent.mm.plugin.sns.c qWo;
    private com.tencent.mm.plugin.sns.f qWp;
    private c qWq = new c<lu>(this) {
        final /* synthetic */ ae qWL;

        {
            this.qWL = r2;
            this.xen = lu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            int i = com.tencent.mm.k.g.zY().getInt("SnsHEVCSwitch", 0);
            int i2 = com.tencent.mm.k.g.zY().getInt("SnsWXPCSwitch", 0);
            boolean z2 = i == 1;
            if (i2 != 1) {
                z = false;
            }
            Editor edit = am.bh(ac.getContext(), "sp_sns_dynswitch_stg").edit();
            edit.putBoolean("sw_use_vcodec_img", z2);
            edit.putBoolean("sw_use_wxpc_img", z);
            edit.commit();
            return false;
        }
    };
    private c qWr = new 13(this);
    private c qWs = new 14(this);
    private c qWt = new 15(this);
    private c qWu = new 16(this);
    private c qWv = new 17(this);
    private c qWw = new 18(this);
    private c qWx = new 19(this);
    private c qWy = new 20(this);
    private c qWz = new 21(this);

    static /* synthetic */ void bvK() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        n bvv = bvv();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = bvv.gJP.a("select count(*) from SnsInfo", null, 2);
        int i = a.moveToFirst() ? a.getInt(0) : 0;
        a.close();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsInfoStorage", "sns table count %d passed %d", new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        r bvk = bvk();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor a2 = bvk.hhp.a("select count(*) from SnsMedia", null, 2);
        int i2 = a2.moveToFirst() ? a2.getInt(0) : 0;
        a2.close();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.snsMediaStorage", "media table count %d passed %d", new Object[]{Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        l bvz = bvz();
        currentTimeMillis2 = System.currentTimeMillis();
        a = bvz.gJP.a("select count(*) from snsExtInfo3", null, 2);
        int i3 = a.moveToFirst() ? a.getInt(0) : 0;
        a.close();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", new Object[]{Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        stringBuffer.append(" snscount " + i);
        stringBuffer.append(" mediacount " + i2);
        stringBuffer.append(" extcount " + i3);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
    }

    static /* synthetic */ void c(ae aeVar) {
        if (!aeVar.qWI) {
            bvd().qVu.post(new 31(aeVar));
        }
    }

    static /* synthetic */ String d(ae aeVar) {
        if (aeVar.qWI) {
            return "";
        }
        aeVar.qWI = true;
        File[] listFiles = new File(getAccSnsPath()).listFiles();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "snscheckfile start");
        long j = 0;
        for (File listFiles2 : listFiles) {
            File[] listFiles3 = listFiles2.listFiles();
            if (listFiles3 != null) {
                for (int i = 0; i < listFiles3.length; i++) {
                    String[] list = listFiles3[i].list();
                    if (list != null) {
                        File[] listFiles4 = listFiles3[i].listFiles();
                        if (listFiles4 != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            long j2 = j;
                            for (File file : listFiles4) {
                                j2 += file.length();
                                String str = file.getAbsolutePath() + " " + file.length() + " " + file.lastModified() + " " + ((String) DateFormat.format("yyyy-M-d kk:mm", file.lastModified()));
                                stringBuffer.append(str + "\r\n");
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", str);
                            }
                            int length = list.length;
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "filepath %s %d", new Object[]{listFiles3[i].getAbsolutePath(), Integer.valueOf(length)});
                            j = j2;
                        }
                    }
                }
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "snscheckfile end " + j);
        aeVar.qWI = false;
        return "";
    }

    static {
        qVV.put(Integer.valueOf("CanvasInfo".hashCode()), new 12());
        qVV.put(Integer.valueOf("UxCanvasInfo".hashCode()), new 23());
        qVV.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new 34());
        qVV.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new 36());
        qVV.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new 37());
        qVV.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new 38());
        qVV.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new 39());
        qVV.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new 40());
        qVV.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return t.gJN;
            }
        });
        qVV.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new 3());
    }

    public static String FC() {
        com.tencent.mm.kernel.g.Dh().Ct();
        com.tencent.mm.kernel.g.Dk();
        return com.tencent.mm.kernel.g.Dj().gQi;
    }

    public static String bvb() {
        com.tencent.mm.kernel.g.Dk();
        return (String) com.tencent.mm.kernel.g.Dj().CU().get(2, null);
    }

    public static int bvc() {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dh();
        return com.tencent.mm.kernel.a.Cg();
    }

    public static h EV() {
        return bvd().gQj;
    }

    private static ae bvd() {
        ae aeVar = (ae) com.tencent.mm.z.p.s(ae.class);
        if (!aeVar.qVS) {
            synchronized (aeVar.qVT) {
                if (!aeVar.qVS) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "onAccInit because bug!");
                    aeVar.bq(true);
                }
            }
        }
        if (aeVar.mpo) {
            synchronized (aeVar.gSF) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + aeVar.hashCode());
                if (aeVar.mpo) {
                    aeVar.qVQ = false;
                    v vVar = aeVar.qVR;
                    HashMap hashMap = qVV;
                    if (vVar.rpv) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "pass hasTrim");
                    } else {
                        com.tencent.mm.kernel.g.Dk();
                        if (com.tencent.mm.kernel.g.Dh().Cy()) {
                            int i = bh.getInt(com.tencent.mm.k.g.zY().getValue("AndroidCleanSnsDb"), 0);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "pass dynamic? " + i);
                            if (i <= 0) {
                                com.tencent.mm.kernel.g.Dk();
                                String str = com.tencent.mm.kernel.g.Dj().cachePath;
                                if (FileOp.bO(str + "SnsMicroMsg2.db.ini")) {
                                    v.LJ(str);
                                    FileOp.deleteFile(str + "SnsMicroMsg2.db.ini");
                                }
                                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(ac.cfs(), 0);
                                if (bh.by(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                                } else {
                                    sharedPreferences.edit().putLong("check_trim_time", bh.Wo()).commit();
                                    vVar.rpv = true;
                                    long currentTimeMillis = System.currentTimeMillis();
                                    int AV = com.tencent.mm.o.a.AV();
                                    if (AV == 1 || AV == 2) {
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                    } else {
                                        if (FileOp.bO(str + "sns_mark.ini")) {
                                            if (bh.bz(FileOp.mf(str + "sns_mark.ini")) < 2592000000L) {
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                                v.LJ(str);
                                            } else {
                                                FileOp.deleteFile(str + "sns_mark.ini");
                                            }
                                        }
                                        long me = FileOp.me(str + "SnsMicroMsg.db");
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "trim sns " + me);
                                        if (me < 52428800) {
                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                        } else {
                                            FileOp.mi(str + "sns_mark.ini");
                                            String str2 = str + "SnsMicroMsg2.db";
                                            h hVar = new h();
                                            if (hVar.b(str2, null, true, false)) {
                                                h hVar2 = new h();
                                                if (hVar2.b(str + "SnsMicroMsg.db", hashMap, true, true)) {
                                                    long currentTimeMillis2;
                                                    long currentTimeMillis3 = System.currentTimeMillis();
                                                    if (v.a(hVar2, hVar)) {
                                                        currentTimeMillis2 = System.currentTimeMillis();
                                                        str2 = "snsExtInfo3";
                                                        v.a(hVar2, hVar, str2);
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + hVar.fx("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        str2 = "SnsComment";
                                                        v.a(hVar2, hVar, str2);
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + hVar.fx("", "insert into " + str2 + " select * from old." + str2) + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        str2 = "SnsInfo";
                                                        v.a(hVar2, hVar, str2);
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + hVar.fx("", "insert into " + str2 + " select * from old." + str2 + " where  (sourceType & 2 != 0 ) " + n.roZ + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis2));
                                                        boolean fx = hVar.fx("", "update snsExtinfo3 set md5 = '', faults = '';");
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), Boolean.valueOf(fx)});
                                                        hVar.fx("", "DETACH DATABASE old");
                                                        AV = 1;
                                                    } else {
                                                        AV = -1;
                                                    }
                                                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis3;
                                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:" + AV, new Object[]{Long.valueOf(currentTimeMillis2)});
                                                    hVar2.ES();
                                                    hVar.ES();
                                                    if (AV >= 0) {
                                                        com.tencent.mm.kernel.g.Dk();
                                                        String str3 = com.tencent.mm.kernel.g.Dj().cachePath;
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db");
                                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "rename file " + FileOp.g(str3, "SnsMicroMsg2.db", "SnsMicroMsg.db"));
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db-shm");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db-wal");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg.db.ini");
                                                        FileOp.x("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg2.db.ini");
                                                        FileOp.deleteFile(str3 + "SnsMicroMsg2.db");
                                                        FileOp.deleteFile(str3 + "sns_mark.ini");
                                                    }
                                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", new Object[]{Integer.valueOf(AV), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis4 - currentTimeMillis2)});
                                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                                } else {
                                                    throw new com.tencent.mm.z.b((byte) 0);
                                                }
                                            }
                                            throw new com.tencent.mm.z.b((byte) 0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (aeVar.gQj == null) {
                        aeVar.gQj = new h();
                        com.tencent.mm.kernel.g.Dk();
                        if (!aeVar.gQj.b(com.tencent.mm.kernel.g.Dj().cachePath + "SnsMicroMsg.db", qVV, true, true)) {
                            throw new SQLiteException("sns db init failed");
                        }
                    }
                    aeVar.mpo = false;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "resetdb done");
                }
            }
        }
        return aeVar;
    }

    public static boolean bve() {
        bvd();
        return !com.tencent.mm.kernel.g.Dh().Cy();
    }

    public ae() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        bvH();
        if (this.qVt == null) {
            com.tencent.mm.sdk.f.e.d(new Runnable(this) {
                final /* synthetic */ ae qWL;

                {
                    this.qWL = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.qWL.qVt = new af();
                    Looper.loop();
                }
            }, "SnsCore_fileTask_handler", 1).start();
        }
        if (this.qVu == null) {
            com.tencent.mm.sdk.f.e.d(new 7(this), "SnsCore_task_handler", 10).start();
        }
        ag.h(new 1(this), 3000);
    }

    public static af bvf() {
        com.tencent.mm.kernel.g.Dk();
        return com.tencent.mm.kernel.g.Dm().cfF();
    }

    public static af bvg() {
        if (qVp >= com.tencent.mm.storage.v.xmG || qVp >= 3) {
            qVp = 0;
        }
        af[] afVarArr = bvd().qVr;
        int i = qVp;
        qVp = i + 1;
        return afVarArr[i];
    }

    public static af aNR() {
        if (qVq > 0) {
            qVq = 0;
        }
        af[] afVarArr = bvd().qVs;
        int i = qVq;
        qVq = i + 1;
        return afVarArr[i];
    }

    protected static af bvh() {
        return bvd().qVt;
    }

    public static af bvi() {
        return bvd().qVu;
    }

    public static af aNT() {
        return bvd().handler;
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static ar bvj() {
        com.tencent.mm.kernel.g.Dk();
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY();
    }

    public static r bvk() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVx == null) {
            bvd().qVx = new r(bvd().gQj);
        }
        return bvd().qVx;
    }

    public static a bvl() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVH == null) {
            bvd().qVH = new a();
            com.tencent.mm.plugin.sns.b.n.qQD = bvd().qVH;
        }
        return bvd().qVH;
    }

    public static com.tencent.mm.plugin.sns.f.c bvm() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVL == null) {
            bvd().qVL = new com.tencent.mm.plugin.sns.f.c();
        }
        return bvd().qVL;
    }

    public static g bvn() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVM == null) {
            bvd().qVM = new g();
        }
        return bvd().qVM;
    }

    public static p bvo() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVN == null) {
            bvd().qVN = new p(bvd().gQj);
        }
        return bvd().qVN;
    }

    public static i bvp() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVO == null) {
            bvd().qVO = new i();
        }
        return bvd().qVO;
    }

    public static b bvq() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVI == null) {
            bvd().qVI = new b();
        }
        return bvd().qVI;
    }

    public static av bvr() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVJ == null) {
            bvd().qVJ = new av();
            com.tencent.mm.plugin.sns.b.n.qQx = bvd().qVJ;
        }
        return bvd().qVJ;
    }

    public static g bvs() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVC == null) {
            bvd().qVC = new g();
            com.tencent.mm.plugin.sns.b.n.qQy = bvd().qVC;
        }
        return bvd().qVC;
    }

    public static aq bvt() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVY == null) {
            bvd().qVY = new aq();
        }
        return bvd().qVY;
    }

    public static ac bvu() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVG == null) {
            ae bvd = bvd();
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.Dk();
            bvd.qVG = new ac(stringBuilder.append(com.tencent.mm.kernel.g.Dj().cachePath).append("snsAsyncQueue.data").toString());
        }
        return bvd().qVG;
    }

    public static n bvv() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVy == null) {
            bvd().qVy = new n(bvd().gQj);
            com.tencent.mm.plugin.sns.b.n.qQE = bvd().qVy;
        }
        return bvd().qVy;
    }

    public static com.tencent.mm.plugin.sns.storage.d bvw() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVA == null) {
            bvd().qVA = new com.tencent.mm.plugin.sns.storage.d(bvd().gQj);
        }
        return bvd().qVA;
    }

    public static x bvx() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVB == null) {
            bvd().qVB = new x(bvd().gQj);
        }
        return bvd().qVB;
    }

    public static com.tencent.mm.plugin.sns.storage.f bvy() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVz == null) {
            bvd().qVz = new com.tencent.mm.plugin.sns.storage.f(bvd().gQj);
        }
        return bvd().qVz;
    }

    public static l bvz() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVD == null) {
            bvd().qVD = new l(bvd().gQj, new ag());
            com.tencent.mm.plugin.sns.b.n.qQz = bvd().qVD;
        }
        return bvd().qVD;
    }

    public static com.tencent.mm.plugin.sns.storage.j bvA() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVE == null) {
            bvd().qVE = new com.tencent.mm.plugin.sns.storage.j(bvd().gQj);
            com.tencent.mm.plugin.sns.b.n.qQA = bvd().qVE;
        }
        return bvd().qVE;
    }

    public static t bvB() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVF == null) {
            bvd().qVF = new t(bvd().gQj);
            com.tencent.mm.plugin.sns.b.n.qQB = bvd().qVF;
        }
        return bvd().qVF;
    }

    public static aj bvC() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bvd().qVK == null) {
            bvd().qVK = new aj();
        }
        return bvd().qVK;
    }

    public static int bvD() {
        int i;
        if (aZP().y < aZP().x) {
            i = aZP().y;
        } else {
            i = aZP().x - com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), qWd);
        }
        i /= 3;
        qVv = i;
        if (i > 10) {
            return qVv;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
        return 150;
    }

    public static int bvE() {
        if (qVw <= 0) {
            if (aZP().x <= 720) {
                qVw = 200;
            } else {
                qVw = 100;
            }
            qVw = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), qVw);
        }
        return qVw;
    }

    private static Point aZP() {
        WindowManager windowManager = (WindowManager) ac.getContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        qWe.x = displayMetrics.widthPixels;
        qWe.y = displayMetrics.heightPixels;
        return qWe;
    }

    public static boolean bvF() {
        SharedPreferences bh = am.bh(ac.getContext(), "sp_sns_dynswitch_stg");
        if (bh.contains("st_sw_use_vcodec_img")) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", new Object[]{Boolean.valueOf(bh.getBoolean("st_sw_use_vcodec_img", false))});
            return bh.getBoolean("st_sw_use_vcodec_img", false);
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", new Object[]{Boolean.valueOf(bh.getBoolean("sw_use_vcodec_img", false))});
        return bh.getBoolean("sw_use_vcodec_img", false);
    }

    public static boolean bvG() {
        SharedPreferences bh = am.bh(ac.getContext(), "sp_sns_dynswitch_stg");
        if (bh.contains("st_sw_use_wxpc_img")) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", new Object[]{Boolean.valueOf(bh.getBoolean("st_sw_use_wxpc_img", false))});
            return bh.getBoolean("st_sw_use_wxpc_img", false);
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", new Object[]{Boolean.valueOf(bh.getBoolean("sw_use_wxpc_img", false))});
        return bh.getBoolean("sw_use_wxpc_img", false);
    }

    private void bvH() {
        int i;
        for (i = 0; i < 3; i++) {
            if (this.qVr[i] == null) {
                com.tencent.mm.sdk.f.e.d(new 4(this, i), "SnsCore_CDNDownload_handler", 1).start();
            }
        }
        for (i = 0; i <= 0; i++) {
            if (this.qVs[0] == null) {
                com.tencent.mm.sdk.f.e.d(new 5(this), "SnsCore_thumbDecode_handler", 1).start();
            }
        }
    }

    public final void onAccountRelease() {
        com.tencent.mm.ae.e bvp = bvp();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(1802, bvp);
        an anVar = this.qVP;
        com.tencent.mm.sdk.b.a.xef.c(anVar.qXr);
        com.tencent.mm.sdk.b.a.xef.c(anVar.qXs);
        com.tencent.mm.sdk.b.a.xef.c(anVar.qXt);
        com.tencent.mm.sdk.b.a.xef.c(this.qWG);
        com.tencent.mm.sdk.b.a.xef.c(this.qWH);
        com.tencent.mm.sdk.b.a.xef.c(this.qWF);
        com.tencent.mm.sdk.b.a.xef.c(this.qWE);
        com.tencent.mm.sdk.b.a.xef.c(this.qWu);
        com.tencent.mm.sdk.b.a.xef.c(this.qWs);
        com.tencent.mm.sdk.b.a.xef.c(this.qWt);
        com.tencent.mm.sdk.b.a.xef.c(this.qWv);
        com.tencent.mm.sdk.b.a.xef.c(this.qWw);
        com.tencent.mm.sdk.b.a.xef.c(this.qWx);
        com.tencent.mm.sdk.b.a.xef.c(this.qWi);
        com.tencent.mm.sdk.b.a.xef.c(this.qWj);
        com.tencent.mm.sdk.b.a.xef.c(this.qWz);
        com.tencent.mm.sdk.b.a.xef.c(this.qWA);
        com.tencent.mm.sdk.b.a.xef.c(this.qWf);
        com.tencent.mm.sdk.b.a.xef.c(this.qWg);
        com.tencent.mm.sdk.b.a.xef.c(this.qWh);
        com.tencent.mm.sdk.b.a.xef.c(this.qWk);
        com.tencent.mm.sdk.b.a.xef.c(this.qWl);
        com.tencent.mm.sdk.b.a.xef.c(this.qWm);
        com.tencent.mm.sdk.b.a.xef.c(this.qWn);
        com.tencent.mm.sdk.b.a.xef.c(this.qWo);
        com.tencent.mm.sdk.b.a.xef.c(this.qWp);
        com.tencent.mm.sdk.b.a.xef.c(this.qWy);
        com.tencent.mm.sdk.b.a.xef.c(this.qVW);
        com.tencent.mm.sdk.b.a.xef.c(this.qWB);
        com.tencent.mm.sdk.b.a.xef.c(this.qWC);
        com.tencent.mm.sdk.b.a.xef.c(this.oKc);
        com.tencent.mm.sdk.b.a.xef.c(this.qWJ);
        com.tencent.mm.sdk.b.a.xef.c(this.qWD);
        com.tencent.mm.sdk.b.a.xef.c(this.qWq);
        com.tencent.mm.sdk.b.a.xef.c(this.qWr);
        com.tencent.mm.sdk.b.a.xef.c(this.qWK);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("NewYearSNSCtrl2016", this.qVZ, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("NewYearSNSTips2016", this.qWa, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("NewYearSNSAmountLevelCtrl2016", this.qWb, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("SnsAd", this.qWc, true);
        bvp = bvr();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(207, bvp);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, bvp);
        ae aeVar = (ae) com.tencent.mm.z.p.s(ae.class);
        if (aeVar != null) {
            int i;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SnsCore", "SnsCore close db");
            if (aeVar.gQj != null) {
                aeVar.gQj.ES();
                aeVar.gQj = null;
            }
            for (i = 0; i < 3; i++) {
                if (aeVar.qVr[i] != null) {
                    aeVar.qVr[i].getLooper().quit();
                }
            }
            for (i = 0; i <= 0; i++) {
                if (aeVar.qVs[0] != null) {
                    aeVar.qVs[0].getLooper().quit();
                }
            }
            if (aeVar.qVt != null) {
                aeVar.qVt.getLooper().quit();
            }
            if (aeVar.qVu != null) {
                aeVar.qVu.getLooper().quit();
            }
        }
        if (this.hlT != null) {
            FileOp.lY(this.hlT);
            this.hlT = null;
        }
        Object obj = this.qVX;
        bvq().b(obj);
        com.tencent.mm.sdk.b.a.xef.c(obj.qRk);
        ao.WK();
        com.tencent.mm.memory.g.gZX.Es();
        com.tencent.mm.memory.c.gZQ.Es();
        o.han.Es();
        aq bvt = bvt();
        bvt.qXC = null;
        bvt.hUJ = null;
        bvt.qXE.clear();
        bvt.qXD.clear();
        synchronized (bvt.qXF) {
            bvt.qXF.clear();
        }
        com.tencent.mm.sdk.b.a.xef.c(bvt.qXG);
        com.tencent.mm.sdk.b.a.xef.c(bvt.qXs);
        com.tencent.mm.sdk.b.a.xef.c(bvt.qXt);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.qVS);
        if (!this.qVS) {
            this.qVS = true;
            this.mpo = true;
            FileOp.mh(FC() + "sfs");
            this.hlT = getAccSnsPath();
            String str = this.hlT;
            String[] strArr = new String[]{"sight_*", "sns_tmp*", "sightad_*", "sns_tmpsad_*"};
            Builder builder = new Builder();
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.Dk();
            FileOp.a(str, strArr, builder.setDBDirectory(stringBuilder.append(com.tencent.mm.kernel.g.Dj().cachePath).append("sfs").toString()).setStoragePath(com.tencent.mm.plugin.n.c.Fy()).setName("sns"));
            bvI();
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", this.qVZ, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", this.qWa, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", this.qWb, true);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("SnsAd", this.qWc, true);
            com.tencent.mm.plugin.sns.b.n.qQx = bvr();
            com.tencent.mm.plugin.sns.b.n.qQy = bvs();
            com.tencent.mm.plugin.sns.b.n.qQz = bvz();
            com.tencent.mm.plugin.sns.b.n.qQA = bvA();
            com.tencent.mm.plugin.sns.b.n.qQB = bvB();
            com.tencent.mm.plugin.sns.b.n.qQD = bvl();
            com.tencent.mm.plugin.sns.b.n.qQC = this;
            com.tencent.mm.plugin.sns.b.n.qQE = bvv();
            com.tencent.mm.sdk.b.a.xef.b(this.qWG);
            com.tencent.mm.sdk.b.a.xef.b(this.qWH);
            com.tencent.mm.sdk.b.a.xef.b(this.qWu);
            com.tencent.mm.sdk.b.a.xef.b(this.qWs);
            com.tencent.mm.sdk.b.a.xef.b(this.qWt);
            com.tencent.mm.sdk.b.a.xef.b(this.qWv);
            com.tencent.mm.sdk.b.a.xef.b(this.qWw);
            com.tencent.mm.sdk.b.a.xef.b(this.qWx);
            com.tencent.mm.sdk.b.a.xef.b(this.qWy);
            com.tencent.mm.sdk.b.a.xef.b(this.qWz);
            com.tencent.mm.sdk.b.a.xef.b(this.qWA);
            com.tencent.mm.sdk.b.a.xef.b(this.qWB);
            com.tencent.mm.sdk.b.a.xef.b(this.qWC);
            com.tencent.mm.sdk.b.a.xef.b(this.qWK);
            this.qWf = new com.tencent.mm.plugin.sns.n();
            this.qWg = new k();
            this.qWh = new e();
            this.qWi = new com.tencent.mm.plugin.sns.p();
            this.qWj = new com.tencent.mm.plugin.sns.h();
            this.qWk = new com.tencent.mm.plugin.sns.g();
            this.qWl = new m();
            this.qWm = new com.tencent.mm.plugin.sns.j();
            this.qWn = new com.tencent.mm.plugin.sns.b();
            this.qWo = new com.tencent.mm.plugin.sns.c();
            this.qWp = new com.tencent.mm.plugin.sns.f();
            com.tencent.mm.sdk.b.a.xef.b(this.qWF);
            com.tencent.mm.sdk.b.a.xef.b(this.qWE);
            com.tencent.mm.sdk.b.a.xef.b(this.qWi);
            com.tencent.mm.sdk.b.a.xef.b(this.qWf);
            com.tencent.mm.sdk.b.a.xef.b(this.qWg);
            com.tencent.mm.sdk.b.a.xef.b(this.qWh);
            com.tencent.mm.sdk.b.a.xef.b(this.qWj);
            com.tencent.mm.sdk.b.a.xef.b(this.qWk);
            com.tencent.mm.sdk.b.a.xef.b(this.qWl);
            com.tencent.mm.sdk.b.a.xef.b(this.qWm);
            com.tencent.mm.sdk.b.a.xef.b(this.qWn);
            com.tencent.mm.sdk.b.a.xef.b(this.qWo);
            com.tencent.mm.sdk.b.a.xef.b(this.qWp);
            com.tencent.mm.sdk.b.a.xef.b(this.oKc);
            this.qVW = new com.tencent.mm.plugin.sns.d();
            com.tencent.mm.sdk.b.a.xef.b(this.qVW);
            com.tencent.mm.sdk.b.a.xef.b(this.qWJ);
            com.tencent.mm.sdk.b.a.xef.b(this.qWq);
            com.tencent.mm.sdk.b.a.xef.b(this.qWr);
            com.tencent.mm.sdk.b.a.xef.b(this.qWD);
            com.tencent.mm.ae.e bvp = bvp();
            i.qPx = com.tencent.mm.k.g.zY().getInt("MMUxAdLog2GSendSize", 20480);
            i.qPy = com.tencent.mm.k.g.zY().getInt("MMUxAdLog3GSendSize", 30720);
            i.qPz = com.tencent.mm.k.g.zY().getInt("MMUxAdLogWifiSendSize", 51200);
            i.qPA = com.tencent.mm.k.g.zY().getInt("MMUxAdLogMinRandTime", 60);
            i.qPB = com.tencent.mm.k.g.zY().getInt("MMUxAdLogMaxRandTime", 1800);
            i.qPC = com.tencent.mm.k.g.zY().getInt("MMUxAdLogMaxExceptionTime", 43200);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsLogMgr", "init " + i.qPx + ";" + i.qPy + ";" + i.qPz + ";" + i.qPA + ";" + i.qPB + ";" + i.qPC);
            if (i.qPB - i.qPA < 0) {
                i.qPB = i.qPA;
            }
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(1802, bvp);
            bvp = bvr();
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(207, bvp);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX, bvp);
            an anVar = this.qVP;
            com.tencent.mm.sdk.b.a.xef.b(anVar.qXr);
            com.tencent.mm.sdk.b.a.xef.b(anVar.qXs);
            com.tencent.mm.sdk.b.a.xef.b(anVar.qXt);
            this.qVX = new com.tencent.mm.plugin.sns.e.a();
            ao.init();
            com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.hOR;
            com.tencent.mm.modelsns.c.Sy();
            if (com.tencent.mm.memory.l.EB()) {
                com.tencent.mm.memory.c cVar2 = com.tencent.mm.memory.c.gZQ;
                com.tencent.mm.memory.c cVar3 = com.tencent.mm.memory.c.gZQ;
                cVar3.getClass();
                cVar2.a(new 8(this, cVar3));
            }
            o oVar = o.han;
            o oVar2 = o.han;
            oVar2.getClass();
            oVar.a(new 9(this, oVar2));
            com.tencent.mm.memory.g gVar = com.tencent.mm.memory.g.gZX;
            com.tencent.mm.memory.g gVar2 = com.tencent.mm.memory.g.gZX;
            gVar2.getClass();
            gVar.a(new 10(this, gVar2));
            bvt();
        }
    }

    private static void bvI() {
        FileOp.mh(((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath());
        FileOp.mh(((com.tencent.mm.plugin.sns.b.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath());
    }

    public final void br(boolean z) {
        FileOp.mh(FC() + "sfs");
        if (this.hlT != null) {
            FileOp.lY(this.hlT);
            this.hlT = getAccSnsPath();
            String str = this.hlT;
            String[] strArr = new String[]{"sight_*", "sns_tmp*", "sightad_*", "sns_tmpsad_*"};
            Builder builder = new Builder();
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.kernel.g.Dk();
            FileOp.a(str, strArr, builder.setDBDirectory(stringBuilder.append(com.tencent.mm.kernel.g.Dj().cachePath).append("sfs").toString()).setStoragePath(com.tencent.mm.plugin.n.c.Fy()).setName("sns"));
        }
        bvI();
    }

    public final void a(an anVar) {
        t.a(anVar);
    }

    public final void b(an anVar) {
        t.b(anVar);
    }

    public static String bvJ() {
        if (bh.ov(qVU)) {
            Iterator it = aw.cgb().iterator();
            while (it.hasNext()) {
                aw.a aVar = (aw.a) it.next();
                if (com.tencent.mm.compatible.util.e.bnD.equals(aVar.xhO)) {
                    qVU = aVar.xhP;
                    break;
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SnsCore", "get filesys " + qVU);
        }
        return bh.az(qVU, "");
    }
}
