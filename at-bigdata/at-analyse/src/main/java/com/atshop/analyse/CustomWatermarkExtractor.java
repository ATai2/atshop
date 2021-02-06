package com.atshop.analyse;

import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

public class CustomWatermarkExtractor implements AssignerWithPeriodicWatermarks<KafkaEvent> {

    private static final long serialVersionUID = -742759155861320823L;

    private long currentTimestamp = Long.MIN_VALUE;

    @Override
    public long extractTimestamp(KafkaEvent event, long previousElementTimestamp) {
        // the inputs are assumed to be of format (message,timestamp)
        this.currentTimestamp = event.getTimestamp();
        return event.getTimestamp();
    }


    @Override
    public Watermark getCurrentWatermark() {
        return new Watermark(currentTimestamp == Long.MIN_VALUE ? Long.MIN_VALUE : currentTimestamp - 1);
    }
}