# Hydra Cluster release 0.1.0


## Test HA behavior on one host:
First install pyhon Flask

Run CMD:


	java -cp .\hydra.jar hydra.cluster.test.ContainerTest
	
curl http://localhost:5000/health to get the app output

curl http://localhost:5000/crash to crash the app, and the app will restart by hydra.


## Test node failed detect on multiple hosts:

1. First you need to change "seed-nodes" in hydra.config file to enable cluster setup
  cross the hosts. Replace "akka.tcp://ClusterSystem@127.0.0.1:2551" with 
  "akka.tcp://ClusterSystem@YOURSEEDIP:2551"
  And also change "akka.remote.netty.tcp.hostname" value to IP address value instead of "127.0.0.1" 

2. When run CMD:

	java -jar .\Hydra.jar  

  on each host, to start the Hydra cluster.

3. Then change config 'akka.conf' in hydraui as step 1 for modify field "akka.cluster.seed-noods" and  "akka.remote.netty.tcp.hostname"

4. Start hydra ui project by run start file "hydraui" or "hydraui.bat" 

5. Post to url of "yourIpaddress:9000/app" with body in format of JSON

""" {
 "appname": "appTest",
 "startcmd":["python demo/app.py"],
 "prestartcmd":[]
} """

      to start app in the Hydra.











