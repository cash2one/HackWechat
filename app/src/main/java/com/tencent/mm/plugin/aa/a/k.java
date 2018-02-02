package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.aa.a.a.f;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import java.util.List;
import java.util.Map;

public final class k implements e {
    public static String igD = "title";
    public static String igE = "totalPayAmount";
    public static String igF = "totalUserNumber";
    public static String igG = "perAmount";
    public static String igH = "chatRoomName";
    public static String igI = "launchScene";
    public static String igJ = "payerlist";
    public static String igK = "timestamp";
    private static int igL = 131100026;
    private b hmc;
    private boolean igM = false;
    private Map<String, Object> igN;
    private int mode = 0;

    public final boolean d(int i, Map<String, Object> map) {
        this.hmc = g.czQ();
        if (this.igM) {
            x.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.hmc.cl(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.hmc.cl(Boolean.valueOf(false));
            return false;
        } else {
            x.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[]{map.keySet()});
            this.igM = true;
            this.igN = map;
            this.mode = i;
            String str;
            long longValue;
            int intValue;
            String str2;
            long longValue2;
            int i2;
            if (i == a.ifH) {
                if (this.igN.containsKey(igD) && this.igN.containsKey(igG) && this.igN.containsKey(igF) && this.igN.containsKey(igI) && this.igN.containsKey(igH) && this.igN.containsKey(igK)) {
                    try {
                        str = (String) this.igN.get(igD);
                        longValue = ((Long) this.igN.get(igG)).longValue();
                        int intValue2 = ((Integer) this.igN.get(igF)).intValue();
                        intValue = ((Integer) this.igN.get(igI)).intValue();
                        str2 = (String) this.igN.get(igH);
                        longValue2 = ((Long) this.igN.get(igK)).longValue();
                        x.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Di().gPJ.a(new f(longValue, str, intValue2, intValue, longValue2, str2), 0);
                        if (intValue2 > 0 && intValue2 <= 10) {
                            i2 = 13;
                        } else if (intValue2 > 10 && intValue2 <= 20) {
                            i2 = 14;
                        } else if (intValue2 <= 20 || intValue2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.a(407, (long) i2, 1, false);
                        this.hmc.czP();
                        return true;
                    } catch (Exception e) {
                        x.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[]{e.getMessage()});
                        this.hmc.cl(Boolean.valueOf(false));
                        this.igM = false;
                        return false;
                    }
                }
                this.hmc.cl(Boolean.valueOf(false));
                this.igM = false;
                return false;
            } else if (i != a.ifI) {
                return false;
            } else {
                if (this.igN.containsKey(igD) && this.igN.containsKey(igG) && this.igN.containsKey(igJ) && this.igN.containsKey(igI) && this.igN.containsKey(igH) && this.igN.containsKey(igK)) {
                    try {
                        str = (String) this.igN.get(igD);
                        longValue = ((Long) this.igN.get(igG)).longValue();
                        List list = (List) this.igN.get(igJ);
                        intValue = ((Integer) this.igN.get(igI)).intValue();
                        str2 = (String) this.igN.get(igH);
                        longValue2 = ((Long) this.igN.get(igK)).longValue();
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Di().gPJ.a(new f(longValue, str, list, intValue, longValue2, str2), 0);
                        i2 = list.size();
                        if (i2 > 0 && i2 <= 10) {
                            i2 = 13;
                        } else if (i2 > 10 && i2 <= 20) {
                            i2 = 14;
                        } else if (i2 <= 20 || i2 > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.a(407, (long) i2, 1, false);
                        this.hmc.czP();
                        return true;
                    } catch (Exception e2) {
                        x.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[]{e2.getMessage()});
                        this.hmc.cl(Boolean.valueOf(false));
                        this.igM = false;
                        return false;
                    }
                }
                this.hmc.cl(Boolean.valueOf(false));
                this.igM = false;
                return false;
            }
        }
    }

    public final boolean t(Map<String, Object> map) {
        this.hmc = g.czQ();
        x.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.igM) {
            x.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.hmc.cl(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.hmc.cl(Boolean.valueOf(false));
            return false;
        } else {
            this.igM = true;
            this.igN = map;
            this.mode = a.ifJ;
            if (this.mode != a.ifJ) {
                this.hmc.cl(Boolean.valueOf(false));
                return false;
            }
            if (this.igN.containsKey(igD) && this.igN.containsKey(igE) && this.igN.containsKey(igJ) && this.igN.containsKey(igI) && this.igN.containsKey(igH) && this.igN.containsKey(igK)) {
                try {
                    String str = (String) this.igN.get(igD);
                    long longValue = ((Long) this.igN.get(igE)).longValue();
                    List list = (List) this.igN.get(igJ);
                    int intValue = ((Integer) this.igN.get(igI)).intValue();
                    String str2 = (String) this.igN.get(igH);
                    long longValue2 = ((Long) this.igN.get(igK)).longValue();
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(new com.tencent.mm.plugin.aa.a.a.g(str, longValue, list, intValue, str2, longValue2), 0);
                    int size = list.size();
                    size = (size <= 0 || size > 10) ? (size <= 10 || size > 20) ? (size <= 20 || size > 50) ? 20 : 19 : 18 : 17;
                    com.tencent.mm.plugin.report.service.g.pQN.a(407, (long) size, 1, false);
                    this.hmc.czP();
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
                }
            }
            this.hmc.cl(Boolean.valueOf(false));
            this.igM = false;
            return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), kVar, Integer.valueOf(this.mode)});
        String str2;
        String str3;
        Object[] objArr;
        y yVar;
        if (kVar.getType() == 1624) {
            this.igM = false;
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                com.tencent.mm.protocal.c.g gVar = fVar.igV;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(gVar.liH);
                objArr[1] = gVar.liI;
                objArr[2] = Boolean.valueOf(gVar.vCY == null);
                objArr[3] = gVar.vCW;
                x.i(str2, str3, objArr);
                if (gVar.liH == 0) {
                    if (gVar.vCY != null) {
                        h.r(gVar.vCW, fVar.chatroomName, gVar.vCY);
                        g.a(this.hmc, new Object[]{Boolean.valueOf(true)});
                    } else {
                        h.a(gVar.vCW, false, 0);
                        g.a(this.hmc, new Object[]{Boolean.valueOf(true)});
                    }
                    h.oB(fVar.chatroomName);
                    com.tencent.mm.plugin.report.service.g.pQN.a(407, 0, 1, false);
                    return;
                }
                if (this.hmc != null) {
                    if (gVar.liH > 0) {
                        yVar = gVar.vDe;
                        if (yVar != null && yVar.vDQ > 0) {
                            this.hmc.cl(yVar);
                        } else if (bh.ov(gVar.liI)) {
                            this.hmc.cl(Boolean.valueOf(false));
                        } else {
                            this.hmc.cl(gVar.liI);
                        }
                    } else {
                        this.hmc.cl(Boolean.valueOf(false));
                    }
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 2, 1, false);
                return;
            }
            if (this.hmc != null) {
                this.hmc.cl(Boolean.valueOf(false));
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(407, 1, 1, false);
        } else if (kVar.getType() == 1655) {
            this.igM = false;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.aa.a.a.g gVar2 = (com.tencent.mm.plugin.aa.a.a.g) kVar;
                i iVar = gVar2.igX;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(iVar.liH);
                objArr[1] = iVar.liI;
                objArr[2] = Boolean.valueOf(iVar.vCY == null);
                x.i(str2, str3, objArr);
                x.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[]{iVar.liI, iVar.vCW});
                if (iVar.liH == 0) {
                    if (iVar.vCY != null) {
                        h.r(iVar.vCW, gVar2.chatroomName, iVar.vCY);
                        g.a(this.hmc, new Object[]{Boolean.valueOf(true), iVar.vCW});
                    } else {
                        h.a(iVar.vCW, false, 0);
                        g.a(this.hmc, new Object[]{Boolean.valueOf(true), iVar.vCW});
                    }
                    h.oB(gVar2.chatroomName);
                    com.tencent.mm.plugin.report.service.g.pQN.a(407, 3, 1, false);
                    return;
                }
                if (iVar.liH > 0) {
                    yVar = iVar.vDe;
                    if (yVar != null && yVar.vDQ > 0) {
                        this.hmc.cl(yVar);
                    } else if (bh.ov(iVar.liI)) {
                        this.hmc.cl(Boolean.valueOf(false));
                    } else {
                        this.hmc.cl(iVar.liI);
                    }
                } else {
                    this.hmc.cl(Boolean.valueOf(false));
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 5, 1, false);
                return;
            }
            if (this.hmc != null) {
                this.hmc.cl(Boolean.valueOf(false));
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(407, 4, 1, false);
        }
    }
}
