package library.domain.model.bookonloan;

import library.domain.model.bookcollection.BookCollection;
import library.domain.type.date.Date;
import library.domain.type.date.Days;

import java.time.Period;

/**
 * 貸出図書
 */
public class BookOnLoan {
    BookCollection bookCollection;
    LoanDate loanDate;

    public BookOnLoan(BookCollection bookCollection, LoanDate loanDate) {
        this.bookCollection = bookCollection;
        this.loanDate = loanDate;
    }

    public LoanPeriod loanPeriod() {
        return LoanPeriod.loanPeriod(loanDate);
    }

    public DelayPeriod todayDelayPeriod() {
        Date today = Date.now();
        return delayPeriod(today);
    }

    public DelayPeriod delayPeriod(Date date) {
        int delay = Period.between(loanPeriod().value().value(), date.value()).getDays();
        return new DelayPeriod(new Days(delay));
    }
}
