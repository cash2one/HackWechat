package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.t.a$a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.u;

public final class j {
    static int mfU;
    public static boolean osU = true;
    private static boolean osV = false;
    private static boolean osW = false;
    public static o osX;
    static double osY;

    public static boolean d(Point point) {
        if (osV) {
            String str;
            Context context = ac.getContext();
            Resources resources = ac.getResources();
            int i = a$a.oEj;
            Object[] objArr = new Object[1];
            if (osX == null) {
                str = "";
            } else {
                str = Integer.valueOf(osX.otg);
            }
            objArr[0] = str;
            u.makeText(context, resources.getString(i, objArr), 1).show();
            return false;
        }
        x.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[]{Integer.valueOf(q.gGb.gGj), Integer.valueOf(q.gGb.gGq), Boolean.valueOf(osW)});
        if (osW) {
            return false;
        }
        if (q.gGb.gGj != -1) {
            return true;
        }
        if (osX != null && 1 == osX.gGj) {
            return true;
        }
        if (point == null) {
            return false;
        }
        if (d.sI(point.x) && d.sI(point.y)) {
            return true;
        }
        if (osX != null) {
            x.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[]{point.toString()});
            osX.gGj = 1;
        }
        return false;
    }

    public static void a(Parameters parameters, boolean z) {
        if (osV) {
            String str;
            Context context = ac.getContext();
            Resources resources = ac.getResources();
            int i = a$a.oEj;
            Object[] objArr = new Object[1];
            if (osX == null) {
                str = "";
            } else {
                str = Integer.valueOf(osX.otg);
            }
            objArr[0] = str;
            u.makeText(context, resources.getString(i, objArr), 1).show();
            return;
        }
        x.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[]{Integer.valueOf(q.gGb.gGq), Boolean.valueOf(osW)});
        if (!osW) {
            boolean z2;
            o oVar;
            Point aZP = d.aZP();
            int i2 = bh.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
            x.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(bh.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(bh.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19))});
            if (q.gGb.gGp == -1 || (q.gGb.gGp & 1) != 0) {
                if (q.gGb.gGp != -1 && (q.gGb.gGp & 1) != 0) {
                    osX.bam().oti = true;
                    z2 = true;
                    if (q.gGb.gGk != -1) {
                        osX.oth = false;
                    } else {
                        if (q.gGb.gGk == 1) {
                        }
                        osX.oth = q.gGb.gGk == 1;
                    }
                    if (q.gGb.gGp == -1) {
                    }
                    oVar = osX;
                    oVar.otl = g.b(parameters, d.aZP(), 720, z);
                    if (oVar.otl != null) {
                    }
                    z2 = false;
                    if (z2) {
                        osX.bak().oti = true;
                    }
                    osX.otg = -1;
                    x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{osX.toString()});
                } else if (com.tencent.mm.compatible.util.d.fM(r3) && mfU >= WXMediaMessage.TITLE_LENGTH_LIMIT && osY >= 1725.0d && Math.min(aZP.x, aZP.y) >= 1080) {
                    oVar = osX;
                    oVar.otl = g.b(parameters, d.aZP(), oVar.oqJ.width * 2, z);
                    if (oVar.otl == null || oVar.otl.osL == null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        osX.bam().oti = true;
                        z2 = true;
                        if (q.gGb.gGk != -1) {
                            osX.oth = q.gGb.gGk == 1;
                        } else {
                            osX.oth = false;
                        }
                        if (q.gGb.gGp == -1 || (q.gGb.gGp & 2) != 0) {
                            if (q.gGb.gGp == -1 && (q.gGb.gGp & 2) != 0) {
                                oVar = osX.bak();
                                oVar.oti = false;
                                oVar.bal();
                            } else if (!z2 && com.tencent.mm.compatible.util.d.fM(r5) && mfU >= WXMediaMessage.TITLE_LENGTH_LIMIT && osY >= 1725.0d && Math.min(aZP.x, aZP.y) >= 720) {
                                oVar = osX;
                                oVar.otl = g.b(parameters, d.aZP(), 720, z);
                                if (oVar.otl != null || oVar.otl.osL == null) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    osX.bak().oti = true;
                                }
                            }
                        }
                        osX.otg = -1;
                        x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{osX.toString()});
                    }
                }
            }
            z2 = false;
            if (q.gGb.gGk != -1) {
                if (q.gGb.gGk == 1) {
                }
                osX.oth = q.gGb.gGk == 1;
            } else {
                osX.oth = false;
            }
            if (q.gGb.gGp == -1) {
            }
            oVar = osX;
            oVar.otl = g.b(parameters, d.aZP(), 720, z);
            if (oVar.otl != null) {
            }
            z2 = false;
            if (z2) {
                osX.bak().oti = true;
            }
            osX.otg = -1;
            x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{osX.toString()});
        }
    }

    public static void b(VideoTransPara videoTransPara) {
        int i;
        int i2;
        boolean z = true;
        osV = false;
        osW = false;
        mfU = ((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass();
        osY = (double) d.dc(ac.getContext());
        String cjW = be.cjW();
        x.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[]{Integer.valueOf(bh.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19))});
        if (CaptureMMProxy.getInstance() != null) {
            q.eI(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        x.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[]{Integer.valueOf(mfU), Double.valueOf(osY), cjW, q.gGb});
        if (CaptureMMProxy.getInstance() != null) {
            i = CaptureMMProxy.getInstance().getInt(a.xsK, -1);
            i2 = CaptureMMProxy.getInstance().getInt(a.xsN, 1);
        } else {
            i2 = 1;
            i = -1;
        }
        o a = o.a(i, videoTransPara);
        osX = a;
        if (a != null) {
            if (i2 == 1) {
                osX.otj = true;
            } else {
                osX.otj = false;
            }
            osV = true;
            Context context = ac.getContext();
            Resources resources = ac.getResources();
            int i3 = a$a.oEj;
            Object[] objArr = new Object[1];
            if (osX == null) {
                cjW = "";
            } else {
                cjW = Integer.valueOf(osX.otg);
            }
            objArr[0] = cjW;
            u.makeText(context, resources.getString(i3, objArr), 1).show();
            return;
        }
        i = q.gGb.gGq;
        x.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[]{Integer.valueOf(i)});
        if (i != -1) {
            osX = o.a(i, videoTransPara);
        }
        if (osX != null) {
            if (i2 == 1) {
                osX.otj = true;
            } else {
                osX.otj = false;
            }
            osW = true;
            return;
        }
        osX = o.a(1, videoTransPara);
        if (i2 == 1) {
            osX.otj = true;
        } else {
            osX.otj = false;
        }
        if (q.gGb.gGj != -1) {
            osX.gGj = q.gGb.gGj;
        } else if (com.tencent.mm.compatible.util.d.fM(i3)) {
            osX.gGj = 2;
        } else {
            osX.gGj = 1;
        }
        if (q.gGb.gGm != -1) {
            boolean z2;
            if (q.gGb.gGm == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            osU = z2;
        }
        if (q.gGb.gGk != -1) {
            o oVar = osX;
            if (q.gGb.gGk != 1) {
                z = false;
            }
            oVar.oth = z;
            return;
        }
        osX.oth = false;
    }

    public static void a(b bVar) {
        if (bVar.osL == null) {
            x.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[]{bVar.toString()});
            bVar.osL = bVar.osO;
            bVar.osM = bVar.osP;
            bVar.osN = bVar.osQ;
            if (Math.min(bVar.osM.y, bVar.osM.x) >= osX.oqJ.width + 16) {
                osX.bal();
                osX.oti = false;
                osX.oth = false;
                x.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[]{bVar.toString()});
            }
        }
    }

    public static void bae() {
        x.i("MicroMsg.MMSightRecorderConfig", "initSimple");
        o oVar = new o();
        osX = oVar;
        oVar.oth = false;
        osX.oti = false;
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            osX.gGj = 2;
        } else {
            osX.gGj = 1;
        }
    }
}
