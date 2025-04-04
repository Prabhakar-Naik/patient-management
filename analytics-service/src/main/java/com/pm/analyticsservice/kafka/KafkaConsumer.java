package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

/**
 * @author prabhakar, @Date 03-04-2025
 */
@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] event) {
        try {

            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            // ... perform any business related to analytics here

            log.info("Received Patient Event: [PatientId={},PatientFirstName={}, PatientLastName={},PatientEmail={},PatientPhoneNumber={}]",
                    patientEvent.getPatientId(),
                    patientEvent.getFirstName(),
                    patientEvent.getLastName(),
                    patientEvent.getEmail(),
                    patientEvent.getPhone());
        }catch (InvalidProtocolBufferException e) {
            log.error("Error deserializing event {}",e.getMessage());
        }
    }

}
