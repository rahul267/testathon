package StoryRunners;


import Steps.ApiTestSteps.GetAllEventsSteps;
import Steps.ApiTestSteps.GetEventPageDetailsSteps;
import Steps.UIAdminSteps;
import Steps.UiSteps.LogInSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class RunWebStories extends JUnitStories {


    @Override
    public Configuration configuration() {
        LoadFromClasspath resourceLoader = new LoadFromClasspath(this.getClass().getClassLoader());
        return new MostUsefulConfiguration()
                .useStoryLoader(resourceLoader)
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.STATS, Format.HTML
                                //, ReportPortalFormat.INSTANCE
                        )
                        .withCrossReference(new CrossReference()))
                .useStepMonitor(new SilentStepMonitor());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new UIAdminSteps() ,   new GetAllEventsSteps(),new GetEventPageDetailsSteps(),new LogInSteps());
    }


    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/UIStories/InstagramSearching.story", "");

    }
}
