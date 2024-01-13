import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({EdgeTests.class,FirefoxTests.class})
@Suite.SuiteClasses(CountDown.class)
public class Compatibility_Test {

}
