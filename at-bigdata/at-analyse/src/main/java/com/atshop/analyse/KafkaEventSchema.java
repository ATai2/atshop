package com.atshop.analyse;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;

import java.io.IOException;

public   class KafkaEventSchema implements DeserializationSchema<KafkaEvent>, SerializationSchema<KafkaEvent> {


    @Override
    public KafkaEvent deserialize(byte[] bytes) throws IOException {
        return KafkaEvent.fromString(new String(bytes));
    }

    @Override
    public boolean isEndOfStream(KafkaEvent kafkaEvent) {
        return false;
    }

    @Override
    public byte[] serialize(KafkaEvent kafkaEvent) {
        return kafkaEvent.toString().getBytes();
    }

    @Override
    public TypeInformation<KafkaEvent> getProducedType() {
        return TypeInformation.of(KafkaEvent.class);
    }
}