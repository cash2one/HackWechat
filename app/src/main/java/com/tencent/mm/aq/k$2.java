package com.tencent.mm.aq;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import java.io.ByteArrayOutputStream;

class k$2 implements i$a {
    final /* synthetic */ k hBB;

    k$2(k kVar) {
        this.hBB = kVar;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        if (i == -21006) {
            x.i(this.hBB.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.hBB.hBn});
            return 0;
        } else if (i != 0) {
            i.hU((int) this.hBB.hBk);
            i.hT((int) this.hBB.hBk);
            r1 = g.pQN;
            r3 = new Object[16];
            r3[0] = Integer.valueOf(i);
            r3[1] = Integer.valueOf(2);
            r3[2] = Long.valueOf(this.hBB.startTime);
            r3[3] = Long.valueOf(bh.Wp());
            r3[4] = Integer.valueOf(d.bi(ac.getContext()));
            r3[5] = Integer.valueOf(this.hBB.hBo);
            r3[6] = Integer.valueOf(this.hBB.hlp);
            r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
            r3[8] = "";
            r3[9] = "";
            r3[10] = "";
            r3[11] = "";
            r3[12] = "";
            r3[13] = "";
            r3[14] = "";
            r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
            r1.h(10421, r3);
            r1 = g.pQN;
            r3 = new Object[16];
            r3[0] = Integer.valueOf(i);
            r3[1] = Integer.valueOf(2);
            r3[2] = Long.valueOf(this.hBB.startTime);
            r3[3] = Long.valueOf(bh.Wp());
            r3[4] = Integer.valueOf(d.bi(ac.getContext()));
            r3[5] = Integer.valueOf(this.hBB.hBo);
            r3[6] = Integer.valueOf(this.hBB.hlp);
            r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
            r3[8] = "";
            r3[9] = "";
            r3[10] = "";
            r3[11] = "";
            r3[12] = "";
            r3[13] = "";
            r3[14] = "";
            r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
            r1.h(13937, r3);
            this.hBB.gJT.a(3, i, "", this.hBB);
            return 0;
        } else {
            e b = o.Pw().b(Long.valueOf(this.hBB.gLP));
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        i.hT((int) this.hBB.hBk);
                        x.e(this.hBB.TAG, "cdntra sceneResult.retCode :%d", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                        this.hBB.gJT.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hBB);
                    } else {
                        x.i(this.hBB.TAG, "cdntra getimg ok. need convert:%b", new Object[]{Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline)});
                        if (b.hzT == 1) {
                            g.pQN.a(198, 26, (long) b.hlp, false);
                            g.pQN.a(198, 27, 1, false);
                            g.pQN.a(198, s.eV(this.hBB.fnB != null ? this.hBB.fnB.field_talker : "") ? 29 : 28, 1, false);
                        } else {
                            long j;
                            g.pQN.a(198, 21, (long) b.hlp, false);
                            g.pQN.a(198, 22, 1, false);
                            r1 = g.pQN;
                            if (s.eV(this.hBB.fnB != null ? this.hBB.fnB.field_talker : "")) {
                                j = 24;
                            } else {
                                j = 23;
                            }
                            r1.a(198, j, 1, false);
                        }
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline) {
                            x.i(this.hBB.TAG, "cdntra need convert2baseline. file:%s", new Object[]{this.hBB.hBq});
                            boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(this.hBB.hBq, 60);
                            x.i(this.hBB.TAG, "convert result:%b", new Object[]{Boolean.valueOf(Convert2Baseline)});
                        }
                        if (this.hBB.hBw) {
                            k.a(this.hBB, b, b.offset, b.offset, 0);
                        } else {
                            k.a(this.hBB, b, this.hBB.hlp, b.offset, this.hBB.hlp - b.offset);
                        }
                    }
                    r1 = g.pQN;
                    r3 = new Object[16];
                    r3[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    r3[1] = Integer.valueOf(2);
                    r3[2] = Long.valueOf(this.hBB.startTime);
                    r3[3] = Long.valueOf(bh.Wp());
                    r3[4] = Integer.valueOf(d.bi(ac.getContext()));
                    r3[5] = Integer.valueOf(this.hBB.hBo);
                    r3[6] = Integer.valueOf(this.hBB.hlp);
                    r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                    r3[8] = "";
                    r3[9] = "";
                    r3[10] = "";
                    r3[11] = "";
                    r3[12] = "";
                    r3[13] = "";
                    r3[14] = "";
                    r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                    r1.h(10421, r3);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        r1 = g.pQN;
                        r3 = new Object[16];
                        r3[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                        r3[1] = Integer.valueOf(2);
                        r3[2] = Long.valueOf(this.hBB.startTime);
                        r3[3] = Long.valueOf(bh.Wp());
                        r3[4] = Integer.valueOf(d.bi(ac.getContext()));
                        r3[5] = Integer.valueOf(this.hBB.hBo);
                        r3[6] = Integer.valueOf(this.hBB.hlp);
                        r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                        r3[8] = "";
                        r3[9] = "";
                        r3[10] = "";
                        r3[11] = "";
                        r3[12] = "";
                        r3[13] = "";
                        r3[14] = "";
                        r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                        r1.h(13937, r3);
                    }
                }
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == this.hBB.hlp) {
                x.d(this.hBB.TAG, "cdntra ignore progress 100%");
                return 0;
            } else {
                this.hBB.hBw = true;
                if (!this.hBB.hBs) {
                    this.hBB.hBs = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify;
                }
                x.i(this.hBB.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", new Object[]{this.hBB.hBn, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Boolean.valueOf(this.hBB.hBs)});
                k.a(this.hBB, b, this.hBB.hlp, b.offset, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength - b.offset);
                return 0;
            }
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
