package Config;

import org.jbehave.core.annotations.AfterScenario;

public class LifeCircle {

    @AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE)
    public void afterFailedScenario() {
        System.out.println("Failed This is to capture Failed Scenario");
    }

    @AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
    public void afterPaasedScenario() {
        System.out.println("Passed This is to capture Passed Scenario");
    }

    @AfterScenario(uponOutcome=AfterScenario.Outcome.ANY)
    public void afterAnyScenario() {
        System.out.println("Any This is to capture Any Scenario");
    }
}
