// IBinderPool.aidl
package com.zone.androidtest;

// Declare any non-default types here with import statements
import com.zone.androidtest.Window;

interface IBinderPool {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    IBinder queryBinder(int binderCode);

    void updateWindow(in Window inWin, out Window outWin);

    oneway void getValue();
}
