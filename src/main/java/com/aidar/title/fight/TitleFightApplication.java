package com.aidar.title.fight;

import com.aidar.title.fight.resources.TitleFightResource;
import com.aidar.title.fight.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TitleFightApplication extends Application<TitleFightConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TitleFightApplication().run(args);
    }

    @Override
    public String getName() {
        return "TitleFight";
    }

    @Override
    public void initialize(final Bootstrap<TitleFightConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TitleFightConfiguration configuration,
                    final Environment environment) {
        final TitleFightResource resource = new TitleFightResource(configuration.getTemplate(), configuration.getDefaultName());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
