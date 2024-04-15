package nextstep.courses.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SessionTest {

    public static final Session sessionA = new Session();
    public static final Session sessionB = new Session(true,20, 20000, SessionStatus.RECRUITING);

    @Test
    void 강의는_무료와_유료로_나뉜다() {
        assertThat(sessionA.isFrees()).isTrue();
    }

    @Test
    void 무료_강의는_최대_수강_인원_제한이_없다() {
        assertThat(sessionA.hasMax()).isFalse();
    }

    @Test
    void 유료_강의는_수강_인원이_최대_수강_인원_이내이면_들을_수_있다() {
        assertThat(sessionB.isLeft(new Amount(20))).isTrue();
    }

    @Test
    void 유료_강의는_최대_수강_인원을_초과할_수_없다() {
        assertThat(sessionB.isLeft(new Amount(21))).isFalse();
    }

    @Test
    void 유료_강의는_수강생이_결제한_금액과_수강료가_일치할때_수강신청이_가능하다() {
        assertThat(sessionB.canListen(new Money(20000))).isTrue();
    }

    @Test
    void 유료_강의는_수강생이_결제한_금액과_수강료가_일치하지_않으면_수강_신청_불가하다() {
        assertThat(sessionB.canListen(new Money(19000))).isFalse();
    }

    @Test
    void 강의_수강신청은_강의_상태가_모집중일_때만_가능하다() {
        assertThat(sessionB.canRegister()).isTrue();
    }

    @Test
    void 강의_수강신청은_강의_상태가_대기중_종료일_때_불가하다() {
        assertThat(sessionA.canRegister()).isFalse();
    }
}
