package com.atshop;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class RollingAdditionMapper extends RichMapFunction<KafkaEvent, KafkaEvent> {

    private static final long serialVersionUID = 1180234853172462378L;

    private transient ValueState<Integer> currentTotalCount;

    @Override
    public KafkaEvent map(KafkaEvent event) throws Exception {
        Integer totalCount = currentTotalCount.value();

        if (totalCount == null) {
            totalCount = 0;
        }
        totalCount += event.getFrequency();

        currentTotalCount.update(totalCount);

        return new KafkaEvent(event.getWord(), totalCount, event.getTimestamp());
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        currentTotalCount = getRuntimeContext().getState(new ValueStateDescriptor<>("currentTotalCount", Integer.class));
    }
}


