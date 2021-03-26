package com.example.design;


import com.example.design.launcher.presenter.AppListPresenter;
import com.example.design.launcher.view.IAppListView;

import org.junit.Test;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest implements IAppListView {
    private AppListPresenter presenter;

    @Test
    public void addition_isCorrect() {
        A a = new A();
//        presenter = new AppListPresenter(this, InstrumentationRegistry.getInstrumentation().targetContext);

//        a.aa.a = "88";
        changePackageInfo(a);
    }

    public void changePackageInfo(A owner) {
        B a = owner.aa;
        a.b = "99";
//        Log.d("ExampleUnitTest", owner.aa.b);

    }

    @Override
    public void updateAppListView(List<String> data) {

    }


    public class A {
        public A() {
            aa = new B();
        }

        public B aa;
    }

    public class B {
        public String b;

    }
}
