package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class d {
    private static final Object mLock = new Object();
    private static d tM;
    private final Handler mHandler;
    private final Context tI;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> tJ = new HashMap();
    private final HashMap<String, ArrayList<b>> tK = new HashMap();
    private final ArrayList<a> tL = new ArrayList();

    private static class a {
        final Intent intent;
        final ArrayList<b> tO;

        a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.tO = arrayList;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(d dVar) {
        while (true) {
            synchronized (dVar.tJ) {
                int size = dVar.tL.size();
                if (size <= 0) {
                    return;
                }
                a[] aVarArr = new a[size];
                dVar.tL.toArray(aVarArr);
                dVar.tL.clear();
            }
        }
    }

    public static d m(Context context) {
        d dVar;
        synchronized (mLock) {
            if (tM == null) {
                tM = new d(context.getApplicationContext());
            }
            dVar = tM;
        }
        return dVar;
    }

    private d(Context context) {
        this.tI = context;
        this.mHandler = new Handler(this, context.getMainLooper()) {
            final /* synthetic */ d tN;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        d.a(this.tN);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.tJ) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.tJ.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.tJ.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                arrayList = (ArrayList) this.tK.get(action);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.tK.put(action, arrayList);
                }
                arrayList.add(bVar);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.tJ) {
            ArrayList arrayList = (ArrayList) this.tJ.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.tK.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            int i4;
                            if (((b) arrayList2.get(i3)).tP == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i4 = i3 - 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4 + 1;
                        }
                        if (arrayList2.size() <= 0) {
                            this.tK.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Intent intent) {
        synchronized (this.tJ) {
            Object obj;
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.tI.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set categories = intent.getCategories();
            if ((intent.getFlags() & 8) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                new StringBuilder("Resolving type ").append(resolveTypeIfNeeded).append(" scheme ").append(scheme).append(" of intent ").append(intent);
            }
            ArrayList arrayList = (ArrayList) this.tK.get(intent.getAction());
            if (arrayList != null) {
                if (obj != null) {
                    new StringBuilder("Action list: ").append(arrayList);
                }
                ArrayList arrayList2 = null;
                int i = 0;
                while (i < arrayList.size()) {
                    ArrayList arrayList3;
                    b bVar = (b) arrayList.get(i);
                    if (obj != null) {
                        new StringBuilder("Matching against filter ").append(bVar.filter);
                    }
                    if (bVar.tQ) {
                        if (obj != null) {
                            arrayList3 = arrayList2;
                        }
                        arrayList3 = arrayList2;
                    } else {
                        int match = bVar.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (obj != null) {
                                new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(match));
                            }
                            if (arrayList2 == null) {
                                arrayList3 = new ArrayList();
                            } else {
                                arrayList3 = arrayList2;
                            }
                            arrayList3.add(bVar);
                            bVar.tQ = true;
                        } else {
                            if (obj != null) {
                                String str;
                                switch (match) {
                                    case -4:
                                        str = "category";
                                        arrayList3 = arrayList2;
                                        break;
                                    case -3:
                                        str = "action";
                                        arrayList3 = arrayList2;
                                        break;
                                    case -2:
                                        str = SlookAirButtonFrequentContactAdapter.DATA;
                                        arrayList3 = arrayList2;
                                        break;
                                    case -1:
                                        str = DownloadSettingTable$Columns.TYPE;
                                        arrayList3 = arrayList2;
                                        break;
                                    default:
                                        str = "unknown reason";
                                        arrayList3 = arrayList2;
                                        break;
                                }
                            }
                            arrayList3 = arrayList2;
                        }
                    }
                    i++;
                    arrayList2 = arrayList3;
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((b) arrayList2.get(i2)).tQ = false;
                    }
                    this.tL.add(new a(intent, arrayList2));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
        }
    }
}
