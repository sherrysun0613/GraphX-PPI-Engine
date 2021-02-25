# GraphX-PPI-Engine

GraphX-PPI-engine is a high performance probability engine based on distributed graph processing system to infer probability programs.

The frontend of engine uses ANTLR 4 simple compilation tool to construct control flow graph of probabilistic programs. 

The backend of engine applied distributed probabilistic flow graph inference algorithm based on Pregel model. And a probabilistic program inference engine PPI of Scala language is built on distributed graph computing platform, GraphX, to achieve large-scale parallel processing of complex probabilistic flow graphs.

The installation steps for GraphX-PPI-engine are described in detail as following.

## Contents

/Bench:  various discrete probability programs (.dp).

/PPIFront: PPI frontend tool. The frontend tool takes .dp program as input to generate the control flow diagram files of probability programs.

/Backend: Backend tool for PPI. This backend tool takes control flow graph file as input and infer probability distribution by applying distributed probability flow graph algorithm on GraphX platform.

## Dependencies

The engine is building on Ubuntu 16.04.

Besides, you need to install the following dependencies for succesfully running scala jar on distributred graph system:

> ANTLR4
>
> Java jdk >= 1.8.0
>
> Hadoop version 2.7.7
>
> Spark version 2.4.5
>
> ( or Scala version >=2.11.12)

## Building on Ubuntu

ANTLR 4 is an lightweight compling contruction tool, which is responsible for  generating the needed graph files for backend computing.

### Install Java jdk

```shell
$ sudo apt-get update
$ sudo apt-get install openjdk-8-jdk
$ java -version
```

Make sure your jdk version >= 1.8.0

### Install ANTLR4 

It is recommended to install it according to official documentation. You can refered to the  *The Definitive ANTLR 4 Reference* Book, Page 19 to 24.

What's more, make sure you have a good knowledge of ANLTR grammer. This helps to redesign grammer to your own need.

### Install Hadoop

Create hadoop user and upgrade apt.

```shell
$ sudo useradd -m hadoop -s /bin/bash
$ sudo adduser hadoop sudo
$ sudo apt-get update
```

Install SSH, configure SSH password for free login.

```shell
$ sudo apt-get install openssh-server
$ cd ~/.ssh/                     
$ ssh-keygen -t rsa             
$ cat ./id_rsa.pub >> ./authorized_keys
```

Install hadoop under `/usr/local/dir`.

```shell
$ sudo tar -zxf ~/download/hadoop-2.7.7.tar.gz -C /usr/local  
$ cd /usr/local/
$ sudo mv ./hadoop-2.7.7/ ./hadoop           
$ sudo chown -R hadoop ./hadoop   
```

Configure hadoop for local mode.

```shell
$ cd /usr/local/hadoop
$ mkdir ./input
$ cp ./etc/hadoop/*.xml ./input  
$ ./bin/hadoop jar ./share/hadoop/mapreduce/hadoop-mapreduce-examples-*.jar grep ./input ./output 'dfs[a-z.]+'
$ cat ./output/
```

### Install Scala

Install spark 2.4.5. 

```shell
$ sudo tar -zxf ~/download/spark-2.4.5-bin-without-hadoop.tgz -C /usr/local/
$ cd /usr/local
$ sudo mv ./spark-2.4.5-bin-without-hadoop/ ./spark
$ sudo chown -R hadoop:hadoop ./spark 
```

Modify configuration information.

```shell
$ cd /usr/local/spark
$ cp ./conf/spark-env.sh.template ./conf/spark-env.sh
```

Add the following infomation to file  `spark-env.sh` .

```
export SPARK_DIST_CLASSPATH=$(/usr/local/hadoop/bin/hadoop classpath)
```

Validate if you have install spark successfully.

```shell
$ cd /usr/local/spark
$ bin/run-example SparkPi
```

## Run PPI 

You can recompile the file ~/Backend/DDFI.scala, or just run the existed scala jar for trial.

### Recompile

Install sbt for independent Scala programs.

```shell
$ sudo mkdir /usr/local/sbt             　　　
$ cd ~/Downloads 
$ sudo tar -zxvf ./sbt-1.3.8.tgz -C /usr/local 
$ cd /usr/local/sbt
$ sudo chown -R hadoop /usr/local/sbt  　　
$ cp ./bin/sbt-launch.jar ./  
```

Modify  script of sbt installation file.

```shell
$ vim /usr/local/sbt/sbt
```

Add the following contents:

```
#!/bin/bash
SBT_OPTS="-Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256M"
java $SBT_OPTS -jar `dirname $0`/sbt-launch.jar "$@"
```

Check sbt version.

```shell
$ chmod u+x /usr/local/sbt/sbt
$ cd /usr/local/sbt
$ ./sbt sbtVersion
```

Use sbt tool packing Scala program.

```shell
$ vim ./sparkapp/simple.sbt
```

Add the followint contents to `simple.sbt`.

```
name := "Simple Project"
version := "1.0"
scalaVersion := "2.11.8"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0"
```

Compile the DDFI.Scala .

```shell
$ /usr/local/sbt/sbt package
$ /usr/local/spark/bin/spark-submit --class "SimpleGraphX" ~/sparkapp/target/scala-2.11/simple-project_2.11-1.0.jar  ~/stmtList.txt  ~/edgeList.txt ~/variabTab.txt
```

### Run exist already packed jar

 Generage your own probabislistic program CFG files.

```shell
$ cd ~/PPIFront
$ antlr4 DiscretePL.g4
$ javac *.java
$ java GenDiscreteProb ~/Bench/Grass.dp
```

The result will be three file： `stmtList.txt`,  `edgeList.txt` and `variabTab.txt`.

Next, submit the SimpleGraphX to Spark.

```shell
$ /usr/local/spark/bin/spark-submit --class "SimpleGraphX" ~/sparkapp/target/scala-2.11/simple-project_2.11-1.0.jar  ~/stmtList.txt  ~/edgeList.txt ~/variabTab.txt
```

 



