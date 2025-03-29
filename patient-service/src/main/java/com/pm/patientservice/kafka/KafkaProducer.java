package com.pm.patientservice.kafka;//package com.pm.patientservice.kafka;
//
//import com.pm.patientservice.model.Patient;
//import jakarta.annotation.Nonnull;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
///**
// * @author prabhakar, @Date 18-03-2025
// */
//@Service
//public class KafkaProducer {
//
//    private static final Logger log = LoggerFactory.getLogger(
//            KafkaProducer.class);
//    private final KafkaTemplate<String, byte[]> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendEvent(@Nonnull Patient patient) {
//        PatientEvent event = PatientEvent.newBuilder()
//                .setPatientId(patient.getId().toString())
//                .setName(patient.getName())
//                .setEmail(patient.getEmail())
//                .setEventType("PATIENT_CREATED")
//                .build();
//
//        try {
//            kafkaTemplate.send("patient", event.toByteArray());
//        } catch (Exception e) {
//            log.error("Error sending PatientCreated event: {}", event);
//        }
//    }
//}
