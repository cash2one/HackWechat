package org.xwalk.core;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class XWalkApplication extends Application {
    private static final String TAG = "XWalkLib";
    private static XWalkApplication gApp = null;
    private Resources mRes = null;

    public void onCreate() {
        super.onCreate();
        gApp = this;
    }

    public Resources getResources() {
        return this.mRes == null ? super.getResources() : this.mRes;
    }

    void addResource(Resources resources) {
        if (this.mRes == null) {
            this.mRes = new XWalkMixedResources(super.getResources(), resources);
        }
    }

    void addResource(String str) {
        if (this.mRes == null) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
                Resources resources = super.getResources();
                this.mRes = new XWalkMixedResources(super.getResources(), new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration()));
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    static XWalkApplication getApplication() {
        return gApp;
    }
}
