package nextstep.courses.domain;

import java.time.LocalDate;

public class Period {

    private final LocalDate startDate;
    private final LocalDate endDate;

    public Period() {
        this(LocalDate.now(), LocalDate.now().plusDays(60));
    }

    public Period(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("시작 날짜는 종료 날짜보다 먼져여야 합니다.");
        }
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
