package library.domain.model.reservation.retention;

import library.domain.type.date.Date;

/**
 * 取置日
 * TODO: バリエーション図では貸出準備完了日。
 */
public class RetainedDate {
    // TODO LocalDateを検討する
    Date value;

    public RetainedDate(Date value) {
        this.value = value;
    }

    public Date value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
