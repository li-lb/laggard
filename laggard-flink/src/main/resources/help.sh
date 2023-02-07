#flink
cd /usr/local/Cellar/apache-flink/1.16.1/libexec/bin

#在bin目录下执行
./start-cluster.sh
./stop-cluster.sh


#kafka
cd /usr/local/Cellar/kafka/3.3.2/bin
nohup ./zookeeper-server-start ../libexec/config/zookeeper.properties
nohup ./kafka-server-start ../libexec/config/server.properties