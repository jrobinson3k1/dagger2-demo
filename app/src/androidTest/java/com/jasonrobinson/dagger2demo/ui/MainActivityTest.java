package com.jasonrobinson.dagger2demo.ui;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.jasonrobinson.dagger2demo.Clock;
import com.jasonrobinson.dagger2demo.DemoApplication;
import com.jasonrobinson.dagger2demo.R;
import com.jasonrobinson.dagger2demo.dagger.DaggerTestComponent;
import com.jasonrobinson.dagger2demo.dagger.TestComponent;

import org.mockito.Mockito;

import java.util.Calendar;

import javax.inject.Inject;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    @Inject
    Clock mClock;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.setProperty("dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath());

        TestComponent testComponent = DaggerTestComponent.create();
        testComponent.inject(this);

        ((DemoApplication) getInstrumentation().getTargetContext().getApplicationContext()).setComponent(testComponent);
    }

    public void testTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(2008, Calendar.SEPTEMBER, 23);
        Mockito.when(mClock.getNow()).thenReturn(cal);

        TextView textView = (TextView) getActivity().findViewById(R.id.time_TextView);
        assertEquals("September 23, 2008", textView.getText());
    }
}
