package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.q;

public final class f {
    private static int yqE = 1;
    private static int yqF = 2;
    private static int yqG = 3;

    public static a e(a aVar) {
        String FS = q.FS();
        if (aVar.hcQ == 2 || aVar.hcQ == 3) {
            String[] split;
            if (!bh.cA(aVar.hcU)) {
                for (String split2 : aVar.hcU) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(FS)) {
                        return new a(bh.getInt(split[1], -1), bh.getInt(split[2], -1), bh.getInt(split[3], -1));
                    }
                }
            }
            if (!bh.cA(aVar.hcW)) {
                for (String split22 : aVar.hcW) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(FS)) {
                        return new a(bh.getInt(split[2], -1), bh.getLong(split[1], -1));
                    }
                }
            }
        }
        return new a();
    }

    public static int a(a aVar, boolean z) {
        a e = e(aVar);
        switch (aVar.hcQ) {
            case 2:
            case 3:
                if (z || e.vDh == 1) {
                    if (e.yqH > 0 && e.yqI >= 0 && e.yqJ >= 0) {
                        switch (e.yqH) {
                            case 1:
                            case 2:
                                return R.k.dxd;
                            case 3:
                                return R.k.dxb;
                            case 4:
                                return R.k.dxc;
                            default:
                                break;
                        }
                    }
                } else if (e.vDh == 2) {
                    if (e.yqH > 0 && e.yqK >= 0) {
                        switch (e.yqH) {
                            case 1:
                                return R.k.dxd;
                            case 2:
                            case 3:
                                return R.k.dxb;
                            case 4:
                                return R.k.dxc;
                            default:
                                break;
                        }
                    }
                } else {
                    return R.k.dxb;
                }
                break;
        }
        return R.k.dxb;
    }

    public static String b(a aVar, boolean z) {
        try {
            String FS = q.FS();
            if (aVar.hcQ > 0) {
                int i;
                Object obj;
                int i2;
                Object obj2;
                Object obj3 = null;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                long j = -1;
                String str = aVar.hcP;
                b tcVar = new tc();
                tcVar.fLx.fLz = str;
                com.tencent.mm.sdk.b.a.xef.m(tcVar);
                if (aVar.hcQ == 2 || aVar.hcQ == 3) {
                    String[] split;
                    if (!bh.cA(aVar.hcU)) {
                        for (String str2 : aVar.hcU) {
                            split = str2.split(",");
                            if (split.length == 4 && split[0].equals(FS)) {
                                i3 = bh.getInt(split[1], -1);
                                i4 = bh.getInt(split[2], -1);
                                i5 = bh.getInt(split[3], -1);
                                obj3 = 1;
                                break;
                            }
                        }
                    }
                    if (!bh.cA(aVar.hcW)) {
                        for (String str22 : aVar.hcW) {
                            split = str22.split(",");
                            if (split.length == 3 && split[0].equals(FS)) {
                                j = bh.getLong(split[1], -1);
                                i = bh.getInt(split[2], -1);
                                obj = 1;
                                i2 = i5;
                                i5 = i4;
                                i4 = i3;
                                obj2 = obj3;
                                break;
                            }
                        }
                    }
                }
                i = -1;
                obj = null;
                i2 = i5;
                i5 = i4;
                i4 = i3;
                obj2 = obj3;
                if (tcVar.fLy.status == yqG) {
                    return ac.getContext().getString(R.l.dCa);
                }
                if (tcVar.fLy.status == yqF) {
                    return ac.getContext().getString(R.l.dBT);
                }
                switch (aVar.hcQ) {
                    case 1:
                        return z ? aVar.hcC : aVar.hcD;
                    case 2:
                    case 3:
                        if (FS.equals(aVar.hcZ) || z || r7 != null) {
                            if (i4 > 0 && i5 >= 0 && i2 >= 0) {
                                switch (i4) {
                                    case 1:
                                        return ac.getContext().getString(R.l.dCb);
                                    case 2:
                                        return ac.getContext().getString(R.l.dBZ, new Object[]{Integer.valueOf(i5 - i2)});
                                    case 3:
                                        return ac.getContext().getString(R.l.dBY);
                                    case 4:
                                        return ac.getContext().getString(R.l.dCa);
                                    default:
                                        break;
                                }
                            }
                        } else if (obj != null) {
                            if (i > 0 && j >= 0) {
                                switch (i) {
                                    case 1:
                                        return ac.getContext().getString(R.l.dBV, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 2:
                                        return ac.getContext().getString(R.l.dBU, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 3:
                                        return ac.getContext().getString(R.l.dBX, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 4:
                                        return ac.getContext().getString(R.l.dBW);
                                    default:
                                        break;
                                }
                            }
                        } else {
                            return ac.getContext().getString(R.l.dBW);
                        }
                        break;
                }
                if (z) {
                    return aVar.hcC;
                }
                return aVar.hcD;
            } else if (z) {
                return aVar.hcC;
            } else {
                return aVar.hcD;
            }
        } catch (Exception e) {
            x.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", new Object[]{e.getMessage()});
        }
    }

    public static String a(int i, int i2, boolean z, a aVar) {
        Context context = ac.getContext();
        if (i == 5) {
            return context.getString(R.l.etM);
        }
        return i == 4 ? z ? context.getString(R.l.etL) : context.getString(R.l.etN) : i == 3 ? i2 == 2 ? z ? aVar.hcC : context.getString(R.l.etN) : z ? aVar.hcC : aVar.hcD : z ? aVar.hcC : aVar.hcD;
    }

    public static int q(int i, int i2, boolean z) {
        if (i != 5) {
            return i == 4 ? z ? R.g.bAj : R.g.bAh : i == 3 ? i2 == 2 ? z ? R.g.bAi : R.g.bAh : z ? R.g.bAi : R.g.bAg : z ? R.g.bAi : R.g.bAg;
        } else {
            if (z) {
                return R.g.bAj;
            }
            return R.g.bAh;
        }
    }

    public static int r(int i, int i2, boolean z) {
        if (i == 5) {
            return R.g.bDz;
        }
        if (i == 4) {
            return R.g.bDz;
        }
        if (i != 3) {
            return -1;
        }
        if (i2 == 2) {
            if (z) {
                return -1;
            }
            return R.g.bDz;
        } else if (z) {
            return -1;
        } else {
            return R.g.bDz;
        }
    }

    public static int c(a aVar, boolean z) {
        if (aVar != null) {
            String str = aVar.hcP;
            b tcVar = new tc();
            tcVar.fLx.fLz = str;
            com.tencent.mm.sdk.b.a.xef.m(tcVar);
            if (tcVar.fLy.status == yqG || tcVar.fLy.status == yqF) {
                return z ? R.g.byw : R.g.byu;
            } else {
                a e = e(aVar);
                switch (aVar.hcQ) {
                    case 2:
                    case 3:
                        if (z || e.vDh == 1) {
                            if (e.yqH > 0 && e.yqI >= 0 && e.yqJ >= 0) {
                                switch (e.yqH) {
                                    case 1:
                                    case 2:
                                        return z ? R.g.byv : R.g.byt;
                                    case 3:
                                    case 4:
                                        return z ? R.g.byw : R.g.byu;
                                    default:
                                        break;
                                }
                            }
                        } else if (e.vDh == 2) {
                            if (e.yqH > 0 && e.yqK >= 0) {
                                switch (e.yqH) {
                                    case 1:
                                        return z ? R.g.byv : R.g.byt;
                                    case 2:
                                    case 3:
                                    case 4:
                                        return z ? R.g.byw : R.g.byu;
                                    default:
                                        break;
                                }
                            }
                        } else {
                            return z ? R.g.byv : R.g.byt;
                        }
                        break;
                }
                if (z) {
                    return R.g.byv;
                }
                return R.g.byt;
            }
        } else if (z) {
            return R.g.byv;
        } else {
            return R.g.byt;
        }
    }

    public static int d(a aVar, boolean z) {
        if (aVar == null) {
            return -12479656;
        }
        String str = aVar.hcP;
        b tcVar = new tc();
        tcVar.fLx.fLz = str;
        com.tencent.mm.sdk.b.a.xef.m(tcVar);
        if (tcVar.fLy.status == yqG || tcVar.fLy.status == yqF) {
            return -8868722;
        }
        a e = e(aVar);
        switch (aVar.hcQ) {
            case 2:
            case 3:
                if (z || e.vDh == 1) {
                    if (e.yqH <= 0 || e.yqI < 0 || e.yqJ < 0) {
                        return -12479656;
                    }
                    switch (e.yqH) {
                        case 1:
                        case 2:
                            return -12479656;
                        case 3:
                        case 4:
                            return -8868722;
                        default:
                            return -12479656;
                    }
                } else if (e.vDh != 2 || e.yqH <= 0 || e.yqK < 0) {
                    return -12479656;
                } else {
                    switch (e.yqH) {
                        case 1:
                            return -12479656;
                        case 2:
                        case 3:
                        case 4:
                            return -8868722;
                        default:
                            return -12479656;
                    }
                }
            default:
                return -12479656;
        }
    }
}
