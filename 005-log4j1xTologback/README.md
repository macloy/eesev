# eesev 005-log4j1xTologback
We migrate form log4j1x To Logback

We eliminate the binder slf4j-log4j12-${latest.stable.version}.jar and the log4j dependency.



Now we integrate the two logback dependencies: core and classic.
classic already has integrate a binding for slf4j.
...

<dependency>  
  <groupId>ch.qos.logback</groupId>  
  <artifactId>logback-core</artifactId>  
            <version>${logback.version}</version>
        </dependency>

        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>${logback.version}</version>
        </dependency>
...

If no custom configuration is defined, Logback provides a simple, automatic configuration on its own. 
By default, this ensures that log statements are printed to the console at DEBUG level.


We must write a configfile to /resoures/logback.xml

By the way:
...
<dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>${logback.version}</version>
        </dependency>
...
should be necessary cause maven will load his dependencies: core and slf4j-api