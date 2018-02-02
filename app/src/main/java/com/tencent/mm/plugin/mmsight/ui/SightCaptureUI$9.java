package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.e.a;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class SightCaptureUI$9 implements Runnable {
    final /* synthetic */ int mll;
    final /* synthetic */ int mlm;
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$9(SightCaptureUI sightCaptureUI, int i, int i2) {
        this.oDb = sightCaptureUI;
        this.mlm = i;
        this.mll = i2;
    }

    public final void run() {
        x.k("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", new Object[]{SightCaptureUI.tb(SightCaptureUI.e(this.oDb))});
        SightCaptureUI.h(this.oDb).a(a.osD);
        SightCaptureUI.A(this.oDb);
        final long Fh = d.Fh("TIME_RECODER_2_PLAY");
        e.post(new Runnable(this) {
            final /* synthetic */ SightCaptureUI$9 oDe;

            public final void run() {
                String filePath = SightCaptureUI.n(this.oDe.oDb).getFilePath();
                aqc J = SightCaptureUI.J(this.oDe.oDb);
                try {
                    if (!bh.ov(filePath) && FileOp.bO(filePath)) {
                        int i;
                        int i2;
                        int i3;
                        int i4;
                        int i5;
                        g.pQN.a(440, 87, 1, false);
                        JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(filePath));
                        int i6 = (int) jSONObject.getDouble("videoFPS");
                        int optInt = jSONObject.optInt("videoBitrate");
                        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s", new Object[]{Integer.valueOf(i6), Integer.valueOf(optInt)});
                        com.tencent.mm.plugin.mmsight.model.a aZT = com.tencent.mm.plugin.mmsight.model.a.aZT();
                        aZT.oru = j.osX.gGj;
                        aZT.videoBitrate = j.osX.videoBitrate;
                        aZT.gGk = j.osX.oth ? 1 : 0;
                        aZT.orv = j.osX.oti ? 1 : 0;
                        aZT.orw = j.osX.orw;
                        aZT.orx = i6;
                        aZT.fileSize = FileOp.me(filePath);
                        com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(filePath);
                        if (Js != null) {
                            aZT.orA = Js.width;
                            aZT.orB = Js.height;
                            aZT.orC = Js.videoBitrate;
                            aZT.ory = Js.mxs;
                        }
                        if (j.osX.gGj == 1) {
                            g.pQN.a(440, 89, 1, false);
                            g.pQN.a(440, 49, (long) i6, false);
                            i = 93;
                            i2 = 73;
                            i3 = 69;
                        } else {
                            g.pQN.a(440, 88, 1, false);
                            g.pQN.a(440, 48, (long) i6, false);
                            i = 90;
                            i2 = 54;
                            i3 = 50;
                        }
                        if (j.osX.orw == 720) {
                            i2 += 6;
                            i4 = i + 1;
                            i5 = i3 + 6;
                        } else if (j.osX.ban()) {
                            i2 += 12;
                            i4 = i + 2;
                            i5 = i3 + 12;
                        } else {
                            i4 = i;
                            i5 = i3;
                        }
                        g.pQN.a(440, (long) i2, (long) i6, false);
                        g.pQN.a(440, (long) i4, 1, false);
                        g.pQN.a(440, 47, (long) i6, false);
                        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[]{filePath, Integer.valueOf(i5)});
                        if (i6 >= 0 && i6 <= 10) {
                            g.pQN.a(440, (long) i5, 1, false);
                        } else if (i6 > 10 && i6 <= 15) {
                            g.pQN.a(440, (long) (i5 + 1), 1, false);
                        } else if (i6 > 15 && i6 <= 20) {
                            g.pQN.a(440, (long) (i5 + 2), 1, false);
                        } else if (i6 > 20 && i6 <= 30) {
                            g.pQN.a(440, (long) (i5 + 3), 1, false);
                        }
                        if (optInt > 0) {
                            if (j.osX.gGj == 2) {
                                g.pQN.a(440, 175, (long) optInt, false);
                                g.pQN.a(440, 176, 1, false);
                                if (J != null) {
                                    if (J.wwR == 1) {
                                        g.pQN.a(440, 184, (long) optInt, false);
                                        g.pQN.a(440, 185, 1, false);
                                    } else if (J.wwR == 2) {
                                        g.pQN.a(440, 194, (long) optInt, false);
                                        g.pQN.a(440, 195, 1, false);
                                    }
                                }
                            } else {
                                g.pQN.a(440, 179, (long) optInt, false);
                                g.pQN.a(440, 180, 1, false);
                                if (J != null) {
                                    if (J.wwR == 1) {
                                        g.pQN.a(440, 189, (long) optInt, false);
                                        g.pQN.a(440, 190, 1, false);
                                    } else if (J.wwR == 2) {
                                        g.pQN.a(440, 199, (long) optInt, false);
                                        g.pQN.a(440, 200, 1, false);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", new Object[]{e.getMessage()});
                }
                k.d(false, Fh);
            }
        }, "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
        x.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", new Object[]{bh.cgy().toString()});
        x.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", new Object[]{SightCaptureUI.n(this.oDb).getFilePath(), Long.valueOf(FileOp.me(SightCaptureUI.n(this.oDb).getFilePath())), Long.valueOf(Fh)});
        SightCaptureUI.z(this.oDb);
        SightCaptureUI.K(this.oDb);
        SightCaptureUI.L(this.oDb);
        ag.h(SightCaptureUI.M(this.oDb), 1000);
        if (SightCaptureUI.a(this.oDb).scene == 1 || SightCaptureUI.a(this.oDb).scene == 2) {
            g.pQN.h(13819, new Object[]{Integer.valueOf(2), Integer.valueOf(SightCaptureUI.a(this.oDb).scene)});
        }
    }
}
