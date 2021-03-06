package StoryRunners;

import static mobileUtlity.MobileContext.*;
import com.epam.reportportal.jbehave.ReportPortalFormat;
import mobileUtlity.MyConfig;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class RunMobileStories extends JUnitStories {


    public RunMobileStories() {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
    }


    @Override
    public Configuration configuration() {

        LoadFromClasspath resourceLoader = new LoadFromClasspath(this.getClass().getClassLoader());
        return new MostUsefulConfiguration()
                .useStoryLoader(resourceLoader)
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.STATS, Format.HTML
                                , ReportPortalFormat.INSTANCE
                        )
                        .withCrossReference(new CrossReference()))
                .useStepMonitor(new SilentStepMonitor());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(),  annotationConfigApplicationContext);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/MobileStory/*.story", "");

    }
}
