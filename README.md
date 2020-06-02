# stockohcl
Program to calculate stockohcl

Import pom file as project at your local and it will downloads maven plugins and dependencies.
This project works with JDK 8+

1. Create jar file e.g. stockohcl-1.0.jar through maven install command
2. run command: stockohcl-1.0.jar with VM arruments -DstockSymbol=XETHZUSD -DbarIntervalInSec=15
3. If running from Intellij Run App.main() with VM argument -DstockSymbol=XETHZUSD -DbarIntervalInSec=15
4. It reads input from trades.json added at resources folder
5. It produces OHCL output at log file logs/app.log

