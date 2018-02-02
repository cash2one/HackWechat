package org.xwalk.core.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkExternalExtensionManager;
import org.xwalk.core.XWalkNativeExtensionLoader;
import org.xwalk.core.XWalkView;

public class XWalkExternalExtensionManagerImpl extends XWalkExternalExtensionManager implements XWalkExtensionContextClient {
    private static final String TAG = "XWalkExternalExtensionManagerImpl";
    private final Context mContext;
    private final HashMap<String, XWalkExternalExtensionBridge> mExtensions = new HashMap();
    private boolean mLoadExternalExtensions;
    private final XWalkNativeExtensionLoader mNativeExtensionLoader;
    private final XWalkView mXWalkView;

    public XWalkExternalExtensionManagerImpl(XWalkView xWalkView) {
        super(xWalkView);
        this.mXWalkView = xWalkView;
        if (getBridge() == null) {
            Log.e(TAG, "Cannot load external extensions due to old version of runtime library");
            this.mContext = null;
            this.mLoadExternalExtensions = false;
            this.mNativeExtensionLoader = null;
            return;
        }
        this.mContext = getViewContext();
        this.mLoadExternalExtensions = true;
        this.mNativeExtensionLoader = new XWalkNativeExtensionLoader();
        loadNativeExtensions();
    }

    public void registerExtension(XWalkExternalExtension xWalkExternalExtension) {
        if (this.mExtensions.get(xWalkExternalExtension.getExtensionName()) != null) {
            Log.e(TAG, xWalkExternalExtension.getExtensionName() + "is already registered!");
            return;
        }
        this.mExtensions.put(xWalkExternalExtension.getExtensionName(), XWalkExternalExtensionBridgeFactory.createInstance(xWalkExternalExtension));
    }

    public void unregisterExtension(String str) {
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(str);
        if (xWalkExternalExtensionBridge != null) {
            this.mExtensions.remove(str);
            xWalkExternalExtensionBridge.onDestroy();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Activity getActivity() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        return null;
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        throw new ActivityNotFoundException("This method is no longer supported");
    }

    public void loadExtension(String str) {
        if (this.mLoadExternalExtensions) {
            int length = str.length();
            if (str.charAt(length - 1) == File.separatorChar) {
                str = str.substring(0, length - 1);
            }
            String str2 = str + File.separator + str.substring(str.lastIndexOf(File.separatorChar) + 1) + ".json";
            try {
                try {
                    String str3;
                    JSONObject jSONObject = new JSONObject(getFileContent(this.mContext, str2, false));
                    String string = jSONObject.getString("name");
                    String string2 = jSONObject.getString("class");
                    String optString = jSONObject.optString("jsapi");
                    if (optString == null || optString.length() == 0) {
                        str3 = optString;
                    } else {
                        str3 = str + File.separator + optString;
                    }
                    optString = null;
                    if (!(str3 == null || str3.length() == 0)) {
                        try {
                            optString = getFileContent(this.mContext, str3, false);
                        } catch (IOException e) {
                            Log.w(TAG, "Failed to read the file " + str3);
                            return;
                        }
                    }
                    if (string != null && string2 != null) {
                        Log.i(TAG, "createExternalExtension: name: " + string + " className: " + string2);
                        createExternalExtension(string, string2, optString, this);
                    }
                } catch (JSONException e2) {
                    Log.w(TAG, "Failed to parse json file: " + str2);
                }
            } catch (IOException e3) {
                Log.w(TAG, "Failed to read json file: " + str2);
            }
        }
    }

    public void postMessage(XWalkExternalExtension xWalkExternalExtension, int i, String str) {
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.postMessage(i, str);
        }
    }

    public void postBinaryMessage(XWalkExternalExtension xWalkExternalExtension, int i, byte[] bArr) {
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.postBinaryMessage(i, bArr);
        }
    }

    public void broadcastMessage(XWalkExternalExtension xWalkExternalExtension, String str) {
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = (XWalkExternalExtensionBridge) this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.broadcastMessage(str);
        }
    }

    public void onStart() {
        for (XWalkExternalExtensionBridge onStart : this.mExtensions.values()) {
            onStart.onStart();
        }
    }

    public void onResume() {
        for (XWalkExternalExtensionBridge onResume : this.mExtensions.values()) {
            onResume.onResume();
        }
    }

    public void onPause() {
        for (XWalkExternalExtensionBridge onPause : this.mExtensions.values()) {
            onPause.onPause();
        }
    }

    public void onStop() {
        for (XWalkExternalExtensionBridge onStop : this.mExtensions.values()) {
            onStop.onStop();
        }
    }

    public void onDestroy() {
        for (XWalkExternalExtensionBridge onDestroy : this.mExtensions.values()) {
            onDestroy.onDestroy();
        }
        this.mExtensions.clear();
    }

    public void onNewIntent(Intent intent) {
        for (XWalkExternalExtensionBridge onNewIntent : this.mExtensions.values()) {
            onNewIntent.onNewIntent(intent);
        }
    }

    public void setAllowExternalExtensions(boolean z) {
        this.mLoadExternalExtensions = z;
    }

    private String getFileContent(Context context, String str, boolean z) {
        String str2;
        InputStream inputStream = null;
        if (z) {
            try {
                Resources resources = context.getResources();
                str2 = new File(str).getName().split("\\.")[0];
                int identifier = resources.getIdentifier(str2, "raw", context.getPackageName());
                if (identifier > 0) {
                    inputStream = resources.openRawResource(identifier);
                }
            } catch (NotFoundException e) {
                Log.w(TAG, "Inputstream failed to open for R.raw." + str2 + ", try to find it in assets");
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        if (inputStream == null) {
            inputStream = context.getAssets().open(str);
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        str2 = new String(bArr);
        if (inputStream != null) {
            inputStream.close();
        }
        return str2;
    }

    private void createExternalExtension(String str, String str2, String str3, XWalkExtensionContextClient xWalkExtensionContextClient) {
        try {
            xWalkExtensionContextClient.getContext().getClassLoader().loadClass(str2).getConstructor(new Class[]{String.class, String.class, XWalkExtensionContextClient.class}).newInstance(new Object[]{str, str3, this});
        } catch (Exception e) {
            handleException(e);
        } catch (Exception e2) {
            handleException(e2);
        } catch (Exception e22) {
            handleException(e22);
        } catch (Exception e222) {
            handleException(e222);
        } catch (Exception e2222) {
            handleException(e2222);
        }
    }

    private void loadNativeExtensions() {
        String str = null;
        try {
            str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).nativeLibraryDir;
        } catch (NameNotFoundException e) {
        }
        if (str != null && new File(str).isDirectory()) {
            this.mNativeExtensionLoader.registerNativeExtensionsInPath(str);
        }
    }

    private static void handleException(Exception exception) {
        Log.e(TAG, "Error in calling methods of external extensions. " + exception.toString());
    }
}
