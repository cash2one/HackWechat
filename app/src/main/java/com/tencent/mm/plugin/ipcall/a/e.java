package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    private static e nCw = null;
    c ikK = new 1(this);
    public ArrayList<f> nCx = null;

    private e() {
    }

    public static e aTq() {
        if (nCw == null) {
            nCw = new e();
        }
        return nCw;
    }

    public final boolean az(byte[] bArr) {
        try {
            try {
                Map y = bi.y(new String(bArr), "feedbackconfig");
                if (y != null) {
                    String str = ".feedbackconfig.resourceslist.resources";
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
                        String str3 = (String) y.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i2 = i + 1;
                            f fVar = new f();
                            fVar.nGL = str3;
                            fVar.nGM = new ArrayList();
                            String str4 = str2 + ".string";
                            int i3 = 0;
                            while (true) {
                                com.tencent.mm.plugin.ipcall.a.g.e eVar = new com.tencent.mm.plugin.ipcall.a.g.e();
                                String str5 = str4 + (i3 == 0 ? "" : Integer.valueOf(i3));
                                str3 = (String) y.get(str5);
                                if (str3 == null) {
                                    break;
                                }
                                str5 = (String) y.get(str5 + ".$id");
                                if (str5 == null) {
                                    break;
                                }
                                i3++;
                                eVar.nGJ = str5;
                                eVar.nGK = str3;
                                fVar.nGM.add(eVar);
                            }
                            x.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", new Object[]{fVar.nGL, Integer.valueOf(fVar.nGM.size())});
                            arrayList.add(fVar);
                            i = i2;
                        } else {
                            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", new Object[]{Integer.valueOf(arrayList.size())});
                            this.nCx = arrayList;
                            return true;
                        }
                    }
                }
                x.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                return false;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e, "", new Object[0]);
                x.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", new Object[]{e.getMessage()});
                return false;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
            x.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", new Object[]{e2.getMessage()});
            return false;
        }
    }
}
