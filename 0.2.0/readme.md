# Hydra Cluster release 0.2.0


## Test HA behavior on one host:
First install pyhon Flask

Run CMD:


	java -cp .\hydra.jar hydra.cluster.test.WebServerTest
	
curl http://localhost:5000/health to get the app output

curl http://localhost:5000/crash to crash the app, and the app will restart by hydra.


## Test node failed detect on multiple hosts:

1. First you need to change "seed-nodes" in hydra.config file to enable cluster setup
  cross the hosts. Replace "akka.tcp://ClusterSystem@127.0.0.1:2551" with 
  "akka.tcp://ClusterSystem@YOURSEEDIP:2551"
  And also change "akka.remote.netty.tcp.hostname" value to IP address of host value instead of "127.0.0.1" 

2. When run CMD:

		java -jar .\Hydra.jar  

  on each host, to start the Hydra cluster.


3. Post to url of "yourIpaddress:9000/app" with body in format of JSON

	""" {
        "appname": "appTest",
        "startcmd":["python demo/app.py"],
        "prestartcmd":["dir"],
        "healthcheck":"http://localhost:5000/health"
          } """

  to start app in the Hydra.

4. curl http://192.168.1.4:9000/app/appTest to get the host ip [HOSTIPADDRESS] of applicaition is deployed.

5. curl http://HOSTIPADDRESS:5000/health to get the app output

curl http://HOSTIPADDRESS:5000/crash to crash the app, and the app will be deployed on another host.

6. crash the host which the application is running, the application also be deployed on another host.

For more detail see:

[C:\Users\where\Documents\github\HydraRelease\0.2.0](C:\Users\where\Documents\github\HydraRelease\0.2.0)
      











