package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.pluginsdk.q$a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;

public class CommonLogicTask extends GWMainProcessTask {
    public static final Creator<CommonLogicTask> CREATOR = new 1();
    public Runnable mVP;
    public Bundle msB = new Bundle();
    public int type;

    public final void Ys() {
        if (this.mVP != null) {
            this.mVP.run();
        }
    }

    public final void Yr() {
        int i = 0;
        boolean z = true;
        int ok;
        Bundle bundle;
        String str;
        b cfVar;
        switch (this.type) {
            case 1:
                if (this.msB != null) {
                    z = this.msB.getBoolean("permission_allow", false);
                    String string = this.msB.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    if (!bh.ov(string)) {
                        q$a.vcy.a(ac.getContext(), string, z);
                        break;
                    } else {
                        x.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                        return;
                    }
                }
                break;
            case 2:
                if (this.msB != null) {
                    int[] intArray = this.msB.getIntArray("getConfigStgKey");
                    if (intArray != null && intArray.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        int length = intArray.length;
                        while (i < length) {
                            int i2 = intArray[i];
                            ar.Hg();
                            arrayList.add(bh.ou((String) c.CU().get(i2, null)));
                            i++;
                        }
                        this.msB.putStringArrayList("getConfigStgValue", arrayList);
                        break;
                    }
                    return;
                }
                break;
            case 3:
                if (this.msB != null) {
                    Parcelable Oo = f.bRB().Oo(this.msB.getString("localId"));
                    if (Oo != null) {
                        this.msB.putParcelable("item", Oo);
                        break;
                    }
                }
                break;
            case 4:
                ok = ok("WebViewDownLoadFileSwitch");
                if (this.msB == null) {
                    this.msB = new Bundle();
                }
                bundle = this.msB;
                str = "allowDownloadFile";
                if (ok != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 5:
                ok = ok("EnableWebviewScanQRCode");
                bundle = this.msB;
                str = "allow_webview_scan";
                if (ok != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 6:
                this.msB.putBoolean("has_set_uin", ar.Hj());
                break;
            case 7:
                cfVar = new cf();
                com.tencent.mm.pluginsdk.model.f.a(cfVar, 1, this.msB.getString("image_path", ""));
                a.xef.m(cfVar);
                this.msB.putInt("fav_simple_img_result", cfVar.fqq.ret);
                break;
            case 8:
                this.msB.putString("file_path", ai.Os(this.msB.getString("localId")));
                break;
            case 9:
                String string2 = this.msB.getString("game_hv_menu_appid");
                cfVar = new gn();
                cfVar.fwD.pK = 3;
                cfVar.fwD.fwF = string2;
                a.xef.m(cfVar);
                this.msB.putString("game_hv_menu_pbcache", cfVar.fwE.result);
                break;
            case 10:
                dw aQd = i.aQb().aQd();
                if (aQd != null) {
                    Parcelable gameSettingParams = new GameSettingParams();
                    gameSettingParams.fxA = aQd.hbM;
                    gameSettingParams.fxB = aQd.neh;
                    this.msB.putParcelable("game_setting_params", gameSettingParams);
                    break;
                }
                break;
            case 11:
                com.tencent.mm.plugin.webview.ui.tools.game.c.Y(this.msB);
                break;
        }
        afp();
    }

    private static int ok(String str) {
        int i = 1;
        try {
            i = bh.getInt(g.zY().getValue(str), 1);
        } catch (Exception e) {
            x.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.msB);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.msB = parcel.readBundle(getClass().getClassLoader());
    }

    CommonLogicTask(Parcel parcel) {
        f(parcel);
    }
}
