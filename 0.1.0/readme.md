# Hydra Cluster release 0.1.0


## Test HA behavior on one machine:
First install pyhon Flask

Run CMD:

	java -cp .\hydra.jar hydra.cluster.test.ContainerTest
	
curl http://localhost:5000/health to get the app output

curl http://localhost:5000/crash to crash the app, and the app will restart by hydra.


