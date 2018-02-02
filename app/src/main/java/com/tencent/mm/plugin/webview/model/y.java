package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class y {
    private static String[] tsj;
    private static boolean tsk = false;

    public static final class c {

        static class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ d tsn;

            public AnonymousClass2(d dVar) {
                this.tsn = dVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.tsn.goBack();
            }
        }

        public static boolean a(String str, String str2, int i, d dVar, d dVar2, b bVar, int i2) {
            if (dVar == null) {
                x.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
                return false;
            }
            x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[]{Integer.valueOf(i)});
            dVar2.c(new 1(dVar2, bVar));
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putString("biz_username", str2);
            bundle.putInt("scene", i);
            bundle.putInt("webview_binder_id", i2);
            try {
                bVar.Ai(1254);
                dVar.r(1254, bundle);
                return true;
            } catch (RemoteException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", new Object[]{e.getLocalizedMessage()});
                return false;
            }
        }

        static void a(d dVar, String str, int i, ArrayList<String> arrayList, b bVar, boolean z, int i2) {
            if (dVar == null) {
                x.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("oauth_url", str);
            bundle.putInt("opt", i);
            bundle.putStringArrayList("scopes", arrayList);
            bundle.putInt("webview_binder_id", i2);
            if (z) {
                try {
                    bVar.Ai(1373);
                } catch (RemoteException e) {
                    x.w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", new Object[]{e.getLocalizedMessage()});
                    return;
                }
            }
            dVar.r(1373, bundle);
        }

        public static boolean a(String str, d dVar) {
            if (y.tsj == null && !y.tsk) {
                try {
                    Bundle e = dVar.e(94, new Bundle());
                    String str2 = null;
                    if (e != null) {
                        str2 = e.getString("oauth_host_paths");
                    }
                    if (bh.ov(str2)) {
                        str2 = "open.weixin.qq.com/connect/oauth2/authorize";
                    }
                    y.tsj = str2.split(";");
                    y.tsk = true;
                } catch (RemoteException e2) {
                    x.w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", new Object[]{e2.getLocalizedMessage()});
                    return false;
                }
            }
            if (y.tsj == null || y.tsj.length == 0) {
                x.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
                return false;
            }
            Uri parse = Uri.parse(str);
            String str3 = parse.getAuthority() + parse.getPath();
            if (bh.ov(str3)) {
                x.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
                return false;
            }
            x.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[]{str3});
            for (String equalsIgnoreCase : y.tsj) {
                if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean a(d dVar) {
            boolean z = false;
            try {
                Bundle e = dVar.e(93, new Bundle());
                if (e == null) {
                    x.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
                } else {
                    z = e.getBoolean("is_oauth_native");
                }
            } catch (RemoteException e2) {
                x.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", new Object[]{e2.getLocalizedMessage()});
            }
            return z;
        }
    }

    private static ArrayList<byte[]> aq(LinkedList<ats> linkedList) {
        ArrayList<byte[]> arrayList = new ArrayList();
        if (linkedList == null || linkedList.isEmpty()) {
            return arrayList;
        }
        int i = 0;
        while (i < linkedList.size()) {
            try {
                arrayList.add(((ats) linkedList.get(i)).toByteArray());
                i++;
            } catch (IOException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[]{Integer.valueOf(i), e.getLocalizedMessage()});
                arrayList.clear();
                return arrayList;
            }
        }
        return arrayList;
    }

    private static LinkedList<bec> V(ArrayList<byte[]> arrayList) {
        LinkedList<bec> linkedList = new LinkedList();
        if (arrayList == null || arrayList.isEmpty()) {
            return linkedList;
        }
        int i = 0;
        while (i < arrayList.size()) {
            try {
                ats com_tencent_mm_protocal_c_ats = new ats();
                com_tencent_mm_protocal_c_ats.aF((byte[]) arrayList.get(i));
                bec com_tencent_mm_protocal_c_bec = new bec();
                com_tencent_mm_protocal_c_bec.wJQ = com_tencent_mm_protocal_c_ats.wBO;
                com_tencent_mm_protocal_c_bec.nfe = com_tencent_mm_protocal_c_ats.desc;
                com_tencent_mm_protocal_c_bec.vOl = com_tencent_mm_protocal_c_ats.scope;
                com_tencent_mm_protocal_c_bec.jgw = com_tencent_mm_protocal_c_ats.jgw;
                linkedList.add(com_tencent_mm_protocal_c_bec);
                i++;
            } catch (IOException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[]{Integer.valueOf(i), e.getLocalizedMessage()});
                linkedList.clear();
                return linkedList;
            }
        }
        return linkedList;
    }
}
