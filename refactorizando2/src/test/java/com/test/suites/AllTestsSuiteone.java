package com.test.suites;

import com.lab14.CourseTest;
import com.lab14.OnSiteCourseTest;
import com.lab14.OnlineCourseTest;
import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({
        CourseTest.class,
        OnlineCourseTest.class,
        OnSiteCourseTest.class
})
@IncludeTags("smoke")
public class AllTestsSuiteone {
}
