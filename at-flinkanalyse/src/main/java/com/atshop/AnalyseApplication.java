package com.atshop;

import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;

public class AnalyseApplication {
    public static void main(String[] args) throws Exception {

        args = new String[]{"--input-topic", "testkafkaflink", "--output-topic", "test4", "--bootstrap.servers", "127.0.0.1:9092",
                "--zookeeper.connect", "127.0.0.1:2181", "--group.id", "myconsumer"};
        ParameterTool parameterTool = ParameterTool.fromArgs(args);
        if (parameterTool.getNumberOfParameters() < 5) {
            System.out.println("Missing parameters!\n" +
                    "Usage: Kafka --input-topic <topic> --output-topic <topic> " +
                    "--bootstrap.servers <kafka brokers> " +
                    "--zookeeper.connect <zk quorum> --group.id <some id>");
            return;
        }

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 10000));
        env.enableCheckpointing(5000);
        env.getConfig().setGlobalJobParameters(parameterTool);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataStreamSource<KafkaEvent> streamSource = (DataStreamSource<KafkaEvent>) env.addSource(
                new FlinkKafkaConsumer010<>(
                        parameterTool.getRequired("input-topic"),
                        new KafkaEventSchema(),
                        parameterTool.getProperties())
                        .assignTimestampsAndWatermarks(new CustomWatermarkExtractor()))
                .keyBy("word")
                .map(new RollingAdditionMapper());
        streamSource.addSink(
                new FlinkKafkaProducer010<>(
                        parameterTool.getRequired("output-topic"),
                        new KafkaEventSchema(),
                        parameterTool.getProperties()));
//                env.addSource(new SourceFunction<String>() {
//            @Override
//            public void run(SourceContext<String> sourceContext) throws Exception {
//                long c = 0;
//                while (true) {
//                    sourceContext.collect("test" + c++);
//                    Thread.sleep(3000);
//                }
//            }
//
//            @Override
//            public void cancel() {
//
//            }
//        });
//        streamSource.addSink(new MySink());
        env.execute("Spring flink demo");
    }
}
