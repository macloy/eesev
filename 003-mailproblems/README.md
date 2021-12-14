# eesev 003-mailproblems
For normal debug activate  
properties.put("mail.debug", "true");  or  session.setDebug(true);


For ssl debug read  
https://javaee.github.io/javamail/FAQ#debug  
https://javaee.github.io/javamail/docs/SSLNOTES.txt  

For ssl debug on glassfish/payara  
Add JVM Setting in  
Configuration->server-config->JVM Settings->JVM Options  
-Djava.security.debug=certpath  
-Djavax.net.debug=trustmanager
