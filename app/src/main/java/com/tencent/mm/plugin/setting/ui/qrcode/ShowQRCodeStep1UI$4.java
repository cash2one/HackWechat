package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;
import java.io.FileOutputStream;

class ShowQRCodeStep1UI$4 implements c {
    final /* synthetic */ ShowQRCodeStep1UI qgN;

    ShowQRCodeStep1UI$4(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.qgN = showQRCodeStep1UI;
    }

    public final void jl(int i) {
        FileOutputStream fileOutputStream;
        Throwable e;
        switch (i) {
            case 0:
                this.qgN.bqs();
                return;
            case 1:
                Context context = this.qgN;
                byte[] bArr = context.qgM;
                if (bArr != null && bArr.length > 0) {
                    String str = k.ccF() + "mmqrcode" + System.currentTimeMillis() + ".png";
                    try {
                        fileOutputStream = new FileOutputStream(str);
                        try {
                            fileOutputStream.write(bArr);
                            Toast.makeText(context, context.getString(R.l.dXO, new Object[]{str}), 1).show();
                            k.b(str, context);
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                x.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (Exception e4) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th) {
                                e = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                        x.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        e = th2;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                }
                return;
            default:
                return;
        }
    }
}
