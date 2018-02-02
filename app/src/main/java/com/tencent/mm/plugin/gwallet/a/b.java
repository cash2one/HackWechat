package com.tencent.mm.plugin.gwallet.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    public Context mContext;
    public com.a.a.a.a nzP;
    private ServiceConnection nzQ;
    boolean nzR = false;
    public boolean nzS = false;
    public int nzT;
    public b nzU;
    public String nzV;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ af kCy;
        final /* synthetic */ b nzX;
        final /* synthetic */ List nzY;
        final /* synthetic */ b nzZ;

        public AnonymousClass2(b bVar, List list, b bVar2, af afVar) {
            this.nzX = bVar;
            this.nzY = list;
            this.nzZ = bVar2;
            this.kCy = afVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            int i = 0;
            for (String str : this.nzY) {
                try {
                    b bVar = this.nzX;
                    bVar.Cs("consume");
                    if (str != null) {
                    }
                    b.Ct("Can't consume " + str + ". No token.");
                    int d = bVar.nzP.d(3, bVar.mContext.getPackageName(), str);
                    if (d == 0) {
                        x.d("MicroMsg.IabHelper", "Successfully consumed token: " + str);
                    } else {
                        x.d("MicroMsg.IabHelper", "Error consuming consuming token " + str);
                        throw new a(d, "Error consuming token " + str);
                    }
                } catch (Exception e) {
                    throw new a("Remote exception while consuming. token: " + str, e);
                } catch (a e2) {
                    i = e2.nzO.aSn();
                }
            }
            if (this.nzZ != null) {
                this.kCy.post(new 1(this, new c(i, "")));
            }
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ af kCy;
        final /* synthetic */ String nAc;
        final /* synthetic */ b nAd;
        final /* synthetic */ b nzX;

        public AnonymousClass3(b bVar, String str, af afVar, b bVar2) {
            this.nzX = bVar;
            this.nAc = str;
            this.kCy = afVar;
            this.nAd = bVar2;
        }

        public final void run() {
            c cVar = new c(0, "Inventory refresh successful.");
            Intent intent = new Intent();
            try {
                int a = b.a(this.nzX, intent, this.nAc);
                if (a != 0) {
                    cVar = new c(a, "Error refreshing inventory (querying owned items).");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                cVar = new c(-1001, "Remote exception while refreshing inventory.");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                cVar = new c(-1002, "Error parsing JSON response while refreshing inventory.");
            }
            intent.putExtra("RESPONSE_CODE", cVar.aSn());
            this.kCy.post(new 1(this, cVar, intent));
        }
    }

    public interface a {
        void a(c cVar);
    }

    public interface c {
        void a(c cVar, Intent intent);
    }

    static /* synthetic */ int a(b bVar, Intent intent, String str) {
        x.d("MicroMsg.IabHelper", "Querying owned items, item type: " + str);
        x.d("MicroMsg.IabHelper", "Package name: " + bVar.mContext.getPackageName());
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        do {
            x.d("MicroMsg.IabHelper", "Calling getPurchases with continuation token: " + str2);
            Bundle b = bVar.nzP.b(3, bVar.mContext.getPackageName(), str, str2);
            int C = C(b);
            x.d("MicroMsg.IabHelper", "Owned items response: " + String.valueOf(C));
            if (C != 0) {
                x.d("MicroMsg.IabHelper", "getPurchases() failed: " + C);
                return C;
            } else if (b.containsKey("INAPP_PURCHASE_ITEM_LIST") && b.containsKey("INAPP_PURCHASE_DATA_LIST") && b.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                arrayList.addAll(b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST"));
                arrayList2.addAll(b.getStringArrayList("INAPP_PURCHASE_DATA_LIST"));
                arrayList3.addAll(b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST"));
                str2 = b.getString("INAPP_CONTINUATION_TOKEN");
                x.d("MicroMsg.IabHelper", "Continuation token: " + str2);
            } else {
                Ct("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
        } while (!TextUtils.isEmpty(str2));
        intent.putStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST", arrayList);
        intent.putStringArrayListExtra("INAPP_PURCHASE_DATA_LIST", arrayList2);
        intent.putStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        return 0;
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final void a(a aVar) {
        if (this.nzR) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        x.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
        this.nzQ = new 1(this, aVar);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (this.mContext == null || this.mContext.getPackageManager() == null || this.mContext.getPackageManager().queryIntentServices(intent, 0) == null || this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            aVar.a(new c(-2001, "Google play not installed!"));
        } else {
            this.mContext.bindService(intent, this.nzQ, 1);
        }
    }

    public final void dispose() {
        x.d("MicroMsg.IabHelper", "Disposing.");
        this.nzR = false;
        if (this.nzQ != null) {
            x.d("MicroMsg.IabHelper", "Unbinding from service.");
            try {
                if (this.mContext != null) {
                    this.mContext.unbindService(this.nzQ);
                }
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.IabHelper", e.toString());
            }
            this.nzQ = null;
            this.nzP = null;
        }
    }

    public final void Cs(String str) {
        if (!this.nzR) {
            x.e("MicroMsg.IabHelper", "Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    public final boolean a(ArrayList<String> arrayList, c cVar) {
        Cs("query details");
        Intent intent = new Intent();
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.IabHelper", "query list is empty!");
            c cVar2 = new c(5, "no query list or is empty");
            intent.putExtra("RESPONSE_CODE", 5);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            return true;
        }
        try {
            x.d("MicroMsg.IabHelper", "query detail list with the size is " + arrayList.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            bundle = this.nzP.a(3, this.mContext.getPackageName(), "inapp", bundle);
            int C = C(bundle);
            x.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(C));
            if (C != 0) {
                x.d("MicroMsg.IabHelper", "cannot query details");
                cVar2 = new c(C, "cannot query details");
                intent.putExtra("RESPONSE_CODE", C);
                cVar.a(cVar2, intent);
                return true;
            }
            c cVar3 = new c(C, "query list ok!");
            x.d("MicroMsg.IabHelper", "result code : " + C);
            intent.putExtra("RESPONSE_CODE", C);
            intent.putExtra("RESPONSE_QUERY_DETAIL_INFO", bundle.getStringArrayList("DETAILS_LIST"));
            cVar.a(cVar3, intent);
            Iterator it = bundle.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                x.d("MicroMsg.IabHelper", (String) it.next());
            }
            return true;
        } catch (Throwable e) {
            Ct("RemoteException while launching query details ");
            x.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
            cVar2 = new c(-1001, "Remote exception while starting purchase flow");
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            return false;
        }
    }

    public static String rf(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= DownloadResult.CODE_UNDEFINED) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                return String.valueOf(i) + ":Unknown IAB Helper Error";
            }
            return split2[i2];
        } else if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        } else {
            return split[i];
        }
    }

    public static int C(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            x.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            Ct("Unexpected type for bundle response code.");
            Ct(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    public static void Ct(String str) {
        x.e("MicroMsg.IabHelper", "In-app billing error: " + str);
    }
}
