# eesev 004-log4j1x
Integrate log4j-1.x


If we integrate only
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
  <version>${slf4j.version}</version>
</dependency>

we get
SCHWERWIEGEND:   SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SCHWERWIEGEND:   SLF4J: Defaulting to no-operation (NOP) logger implementation
SCHWERWIEGEND:   SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.


If we than integrate
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>${slf4j.version}</version>
</dependency>


We get log messages
All Log messages under slf4j-simple go to System.err


Now to use another Framework we must integrate the correkt binding jar from slf4j
For log4j we use the binder slf4j-log4j12-${latest.stable.version}.jar
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>${slf4j.version}</version>
</dependency>

And of course log4j
<dependency>
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>${log4j.version}</version>
</dependency>

We deaktivate slf4j-simple in the dependencies

Check the file log4j.properties.
It must be under /main/java/resources.



