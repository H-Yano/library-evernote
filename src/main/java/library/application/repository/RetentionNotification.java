package library.application.repository;

import library.domain.model.reservation.reservation.Reservation;
import library.domain.model.reservation.retention.Retained;

public interface RetentionNotification {
    void retained(Retained retained);
    void notAvailable(Reservation reservation);
}
