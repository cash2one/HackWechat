package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public int mode = 1;
    public d nbT;
    public boolean nbU = false;
    public int progress = 0;
    public int status = 0;

    public o(d dVar) {
        this.nbT = dVar;
    }

    public final void cP(Context context) {
        if (this.nbT != null) {
            int i = this.nbT.fQN;
            int i2 = this.nbT.fQN;
            x.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[]{this.nbT.field_appId, Integer.valueOf(i)});
            if (i == 2) {
                i2 = 3;
            }
            if (i2 == 3 && !g.m(context, "wx3909f6add1206543")) {
                i2 = 1;
            }
            if (i2 != 1) {
                FileDownloadTaskInfo xI = f.aAd().xI(this.nbT.field_appId);
                if (xI.status == 1 || xI.status == 2 || xI.status == 3) {
                    i2 = 1;
                }
            }
            this.mode = i2;
            x.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[]{this.nbT.field_appId, Integer.valueOf(i2)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aQj() {
        if (this.nbT != null) {
            switch (this.mode) {
                case 1:
                    FileDownloadTaskInfo xI = f.aAd().xI(this.nbT.field_appId);
                    if (!xI.lsK) {
                        if (xI.fwg != 0) {
                            this.progress = (int) ((((double) xI.fwf) / ((double) xI.fwg)) * 100.0d);
                        } else {
                            this.progress = 0;
                        }
                        x.d("MicroMsg.GameDownloadInfo", "status = " + xI.status);
                        switch (xI.status) {
                            case 0:
                                this.status = 0;
                                break;
                            case 1:
                                this.status = 1;
                                break;
                            case 2:
                                this.status = 2;
                                break;
                            case 3:
                                if (e.bO(xI.path)) {
                                    this.status = 3;
                                    break;
                                }
                                f.aAd().bX(xI.id);
                            case 4:
                                if (this.progress != 0 && !an.isConnected(ac.getContext())) {
                                    this.status = 2;
                                    break;
                                } else {
                                    this.status = 0;
                                    break;
                                }
                                break;
                            default:
                                this.status = 0;
                                break;
                        }
                    }
                    this.status = 0;
                    return;
                    break;
                case 2:
                case 3:
                    if (this.nbT != null) {
                        bj.aQY();
                        x.i("MicroMsg.GameDownloadInfo", "query download status : %d", new Object[]{Integer.valueOf(bj.Ca(this.nbT.fQP))});
                        switch (bj.Ca(this.nbT.fQP)) {
                            case 1:
                            case 2:
                                this.status = 1;
                                break;
                            case 3:
                                this.status = 2;
                                break;
                            case 4:
                                this.status = 3;
                                break;
                            default:
                                this.status = 0;
                                break;
                        }
                    }
                    return;
                default:
                    this.status = 0;
                    break;
            }
            x.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", new Object[]{this.nbT.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status)});
        }
    }

    public final void aQk() {
        this.mode = 1;
        this.nbU = true;
    }
}
