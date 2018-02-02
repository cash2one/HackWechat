package com.tencent.mm.bc;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e {
    public static String hKF = "";

    public static void n(int i, long j) {
        x.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        switch (i) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i + 1);
                iDKey.SetValue((long) ((int) j));
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i + 2);
                iDKey2.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g.pQN.a(arrayList, false);
                return;
            default:
                return;
        }
    }

    public static void b(String str, boolean z, int i, int i2) {
        a(str, z, i, i2, new f());
    }

    public static void a(String str, boolean z, int i, int i2, f fVar) {
        int i3;
        String format;
        switch (i2) {
            case -15:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i3 = 2;
                break;
            case 0:
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (z) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(3), Integer.valueOf(i3), Integer.valueOf(fVar.hKG), Integer.valueOf(fVar.hKJ), Integer.valueOf(fVar.hKQ), Integer.valueOf(fVar.hKN), Integer.valueOf(fVar.hKO)});
        } else if (i > 0) {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(2), Integer.valueOf(i3), Integer.valueOf(fVar.hKG), Integer.valueOf(fVar.hKJ), Integer.valueOf(fVar.hKQ), Integer.valueOf(fVar.hKN), Integer.valueOf(fVar.hKO)});
        } else {
            format = String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{str, Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(fVar.hKG), Integer.valueOf(fVar.hKJ), Integer.valueOf(fVar.hKQ), Integer.valueOf(fVar.hKN), Integer.valueOf(fVar.hKO)});
        }
        x.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", new Object[]{Integer.valueOf(11062), format});
        g.pQN.k(11062, format);
    }

    public static void a(b bVar, f fVar) {
        int i;
        int i2;
        String str;
        int i3 = bVar.mPy;
        int i4 = bVar.mPz;
        String str2 = bVar.mPA;
        long j = bVar.mPB;
        int e = e(bVar.mPD, bVar.mPE, bVar.aNz());
        if (bVar.mPx == -8) {
            i = 2;
            i2 = 1;
        } else {
            switch (bVar.kTK) {
                case 1:
                    i = 3;
                    i2 = 1;
                    break;
                case 2:
                    i = 4;
                    i2 = 1;
                    break;
                case 3:
                    i = 10;
                    i2 = 1;
                    break;
                case 4:
                    i = 5;
                    i2 = 1;
                    break;
                case 5:
                    i = 16;
                    i2 = 1;
                    break;
                case 6:
                    i = 11;
                    i2 = 1;
                    break;
                case 7:
                    i = 12;
                    i2 = 1;
                    break;
                case 8:
                    i = 13;
                    i2 = 1;
                    break;
                case 9:
                    i = 14;
                    i2 = 1;
                    break;
                case 10:
                    if (!bVar.mPC) {
                        i = 9;
                        i2 = 1;
                        break;
                    }
                    i = 8;
                    i2 = 1;
                    break;
                case 12:
                    i2 = 2;
                    if (bVar.mPx == -5) {
                        i = 16;
                        break;
                    } else if (bVar.mPx == -3) {
                        i = 4;
                        break;
                    } else if (bVar.mPx == -4) {
                        i = 3;
                        break;
                    } else if (bVar.mPx == -1) {
                        i = 12;
                        break;
                    } else if (bVar.mPx == -2) {
                        i = 11;
                        break;
                    } else {
                        return;
                    }
                case 13:
                    i = 17;
                    i2 = 1;
                    break;
                case 14:
                    i = 15;
                    i2 = 1;
                    break;
                case 16:
                    d dVar = new d();
                    str = bVar.mMb.mLA;
                    if (str != null) {
                        str = str.replaceAll(",", " ");
                    }
                    dVar.q("20KeyWordId", str + ",");
                    dVar.q("21ViewType", "1,");
                    dVar.q("22OpType", "2,");
                    dVar.q("23ResultCount", ",");
                    dVar.q("24ClickPos", bVar.mPz + ",");
                    dVar.q("25ClickAppUserName", bVar.info + ",");
                    x.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[]{dVar.Sz()});
                    g.pQN.h(13963, new Object[]{dVar});
                    i2 = 1;
                    i = 19;
                    break;
                case 17:
                    i = 20;
                    i2 = 1;
                    break;
                case 20:
                    i = 21;
                    i2 = 1;
                    break;
                default:
                    return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - fVar.hKz;
        if (currentTimeMillis < 0 || fVar.hKz == 0) {
            currentTimeMillis = 0;
        }
        x.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", new Object[]{Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(bVar.mOz), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), bh.az(str2, ""), Long.valueOf(j), Integer.valueOf(e), Integer.valueOf(0), Integer.valueOf(bVar.ads()), Integer.valueOf(im(bVar.aNy())), bVar.adr(), Long.valueOf(currentTimeMillis), Integer.valueOf(fVar.hKH), Integer.valueOf(fVar.hKI), Integer.valueOf(fVar.hKJ), Integer.valueOf(fVar.hKK), Integer.valueOf(fVar.hKL), Integer.valueOf(fVar.hKM), Integer.valueOf(fVar.hKN), Integer.valueOf(fVar.hKP), Integer.valueOf(fVar.hKQ), hKF, bVar.mMb.mLA, Integer.valueOf(fVar.hKO)})});
        g.pQN.k(10991, str);
    }

    private static int e(int i, int i2, boolean z) {
        if (z) {
            return 15;
        }
        if (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            switch (i2) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case 18:
                    return 9;
                default:
                    return 0;
            }
        } else if (i == 131075) {
            switch (i2) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case 29:
                case 30:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i == 65536) {
            return 17;
        } else {
            return 0;
        }
    }

    private static int im(int i) {
        switch (i) {
            case 29:
                return 1;
            case 30:
                return 2;
            case 31:
                return 3;
            case 32:
                return 4;
            case 34:
                return 5;
            case 35:
            case 36:
                return 6;
            case 37:
                return 16;
            default:
                return 0;
        }
    }

    public static void a(b bVar, a aVar) {
        int i;
        String str;
        int i2 = bVar.mPy;
        String str2 = bVar.mPA;
        long j = bVar.mPB;
        int e = e(bVar.mPD, bVar.mPE, bVar.aNz());
        switch (bVar.kTK) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 4;
                break;
            case 3:
                i = 10;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 16;
                break;
            case 6:
                i = 11;
                break;
            case 7:
                i = 12;
                break;
            case 8:
                i = 13;
                break;
            case 9:
                i = 14;
                break;
            case 13:
                i = 17;
                break;
            case 14:
                i = 15;
                break;
            case 16:
                d dVar = new d();
                str = bVar.mMb.mLA;
                if (str != null) {
                    str = str.replaceAll(",", " ");
                }
                dVar.q("20KeyWordId", str + ",");
                dVar.q("21ViewType", "2,");
                dVar.q("22OpType", "2,");
                dVar.q("23ResultCount", ",");
                dVar.q("24ClickPos", bVar.mPz + ",");
                dVar.q("25ClickAppUserName", bVar.info + ",");
                x.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", new Object[]{dVar.Sz()});
                g.pQN.h(13963, new Object[]{dVar});
                i = 19;
                break;
            case 17:
                i = 20;
                break;
            case 20:
                i = 21;
                break;
            default:
                return;
        }
        long currentTimeMillis = System.currentTimeMillis() - aVar.hKz;
        if (currentTimeMillis < 0 || aVar.hKz == 0) {
            currentTimeMillis = 0;
        }
        x.d("MicroMsg.FTS.FTSReportLogic", "report detail page click: %s", new Object[]{String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(bVar.mOz), Integer.valueOf(i), Integer.valueOf(i2), bh.az(str2, ""), Long.valueOf(j), Integer.valueOf(e), Integer.valueOf(bVar.ads()), Integer.valueOf(im(bVar.aNy())), bVar.adr(), Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.hKA)})});
        g.pQN.k(11310, str);
    }

    public static final void in(int i) {
        x.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[]{Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), hKF, ""})});
        g.pQN.k(10991, r0);
    }

    public static final void bR(boolean z) {
        int i;
        int i2 = 1;
        String str = "MicroMsg.FTS.FTSReportLogic";
        String str2 = "reportFTSCreateChatroom: %d %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(13970);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        x.v(str, str2, objArr);
        g gVar = g.pQN;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i2 = 0;
        }
        objArr2[0] = Integer.valueOf(i2);
        gVar.h(13970, objArr2);
    }

    public static final void a(b bVar, int i, boolean z) {
        if (bVar.mPD == 65536) {
            int i2;
            switch (bVar.pageType) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = bVar.pageType;
                    break;
                case 5:
                    if (i == 1) {
                        i2 = 6;
                        break;
                    } else if (i == 2) {
                        i2 = 5;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            String str = "%s,%s,%s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.aNA());
            objArr[1] = Integer.valueOf(i2);
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[2] = Integer.valueOf(i2);
            x.v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", new Object[]{Integer.valueOf(14756), String.format(str, objArr)});
            g.pQN.k(14756, r0);
        }
    }
}
