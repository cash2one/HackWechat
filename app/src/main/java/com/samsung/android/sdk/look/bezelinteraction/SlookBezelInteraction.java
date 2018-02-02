package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.samsung.android.bezelinteraction.IBezelManager;
import com.samsung.android.bezelinteraction.IBezelManager.Stub;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SlookBezelInteraction {
    public static final String SERVICE_NAME = "BezelInteractionService";
    private static final String TAG = "SlookBezelInteraction";
    private static Context mContext = null;
    private static IBezelManager mService = null;
    private final CopyOnWriteArrayList<BezelListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList();

    public SlookBezelInteraction(Context context) {
        mContext = context;
        getService();
    }

    private synchronized IBezelManager getService() {
        if (mService == null) {
            mService = Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        } else if (!mService.asBinder().isBinderAlive()) {
            mService = Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        }
        return mService;
    }

    public final void registerListener(BezelListener bezelListener) {
        if (bezelListener != null) {
            synchronized (this.mListenerDelegates) {
                IBinder iBinder;
                Iterator it = this.mListenerDelegates.iterator();
                while (it.hasNext()) {
                    iBinder = (BezelListenerDelegate) it.next();
                    if (iBinder.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                iBinder = null;
                if (iBinder == null) {
                    iBinder = new BezelListenerDelegate(bezelListener, null);
                    this.mListenerDelegates.add(iBinder);
                }
                try {
                    IBezelManager service = getService();
                    if (service != null) {
                        service.registerCallback(iBinder, new ComponentName(mContext.getPackageName(), mContext.getClass().getCanonicalName()));
                    }
                } catch (RemoteException e) {
                }
            }
        }
    }

    public final void unregisterListener(BezelListener bezelListener) {
        if (bezelListener != null) {
            synchronized (this.mListenerDelegates) {
                IBinder iBinder;
                Iterator it = this.mListenerDelegates.iterator();
                while (it.hasNext()) {
                    iBinder = (BezelListenerDelegate) it.next();
                    if (iBinder.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                iBinder = null;
                if (iBinder == null) {
                    return;
                }
                try {
                    IBezelManager service = getService();
                    if (service != null && service.unregisterCallback(iBinder)) {
                        this.mListenerDelegates.remove(iBinder);
                        iBinder.mHandler = null;
                        iBinder.mListener = null;
                    }
                } catch (RemoteException e) {
                }
            }
        }
    }

    public final void enableBezelInteraction(boolean z) {
        try {
            IBezelManager service = getService();
            if (service != null) {
                service.enableBezelInteraction(z);
            }
        } catch (RemoteException e) {
        }
    }
}
