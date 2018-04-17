package sample;

import java.io.File;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String... args) throws GlassFishException {
    if(log.isInfoEnabled()) log.info("starting payara server");
    GlassFishRuntime runtime = GlassFishRuntime.bootstrap();

    GlassFishProperties properties = new GlassFishProperties();
    properties.setPort("http-listener", 18080);

    GlassFish glassfish = runtime.newGlassFish(properties);
    glassfish.start();

    String warPath = "/Users/hideki/tmp/workspace/SessionReplicationSample.git";
    File warFile   = new File(warPath.concat("/build/libs/sample001.war"));
    if(warFile.exists()) glassfish.getDeployer().deploy(warFile);
  }
}
