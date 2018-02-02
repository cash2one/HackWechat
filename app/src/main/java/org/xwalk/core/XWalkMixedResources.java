package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

class XWalkMixedResources extends Resources {
    private Resources mLibraryResource;

    private boolean isCalledInLibrary() {
        for (StackTraceElement className : Thread.currentThread().getStackTrace()) {
            String className2 = className.getClassName();
            if (className2.startsWith("org.chromium") || className2.startsWith("org.xwalk.core.internal")) {
                return true;
            }
            if (className2.startsWith("org.xwalk.core") && !className2.endsWith("XWalkMixedResources")) {
                return false;
            }
        }
        return false;
    }

    XWalkMixedResources(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mLibraryResource = resources2;
    }

    public CharSequence getText(int i) {
        boolean isCalledInLibrary = isCalledInLibrary();
        if (!isCalledInLibrary) {
            return super.getText(i);
        }
        try {
            return this.mLibraryResource.getText(i);
        } catch (NotFoundException e) {
            if (isCalledInLibrary) {
                return super.getText(i);
            }
            return this.mLibraryResource.getText(i);
        }
    }

    public XmlResourceParser getLayout(int i) {
        boolean isCalledInLibrary = isCalledInLibrary();
        if (!isCalledInLibrary) {
            return super.getLayout(i);
        }
        try {
            return this.mLibraryResource.getLayout(i);
        } catch (NotFoundException e) {
            if (isCalledInLibrary) {
                return super.getLayout(i);
            }
            return this.mLibraryResource.getLayout(i);
        }
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                this.mLibraryResource.getValue(i, typedValue, z);
                return;
            } catch (NotFoundException e) {
                if (isCalledInLibrary) {
                    super.getValue(i, typedValue, z);
                    return;
                } else {
                    this.mLibraryResource.getValue(i, typedValue, z);
                    return;
                }
            }
        }
        super.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                this.mLibraryResource.getValueForDensity(i, i2, typedValue, z);
                return;
            } catch (NotFoundException e) {
                if (isCalledInLibrary) {
                    super.getValueForDensity(i, i2, typedValue, z);
                    return;
                } else {
                    this.mLibraryResource.getValueForDensity(i, i2, typedValue, z);
                    return;
                }
            }
        }
        super.getValueForDensity(i, i2, typedValue, z);
    }

    public int getIdentifier(String str, String str2, String str3) {
        int identifier;
        if (isCalledInLibrary()) {
            identifier = this.mLibraryResource.getIdentifier(str, str2, str3);
            if (identifier != 0) {
                return identifier;
            }
            return super.getIdentifier(str, str2, str3);
        }
        identifier = super.getIdentifier(str, str2, str3);
        return identifier == 0 ? this.mLibraryResource.getIdentifier(str, str2, str3) : identifier;
    }

    public Drawable getDrawable(int i) {
        boolean isCalledInLibrary = isCalledInLibrary();
        if (!isCalledInLibrary) {
            return super.getDrawable(i);
        }
        try {
            return this.mLibraryResource.getDrawable(i);
        } catch (NotFoundException e) {
            if (isCalledInLibrary) {
                return super.getDrawable(i);
            }
            return this.mLibraryResource.getDrawable(i);
        }
    }
}
