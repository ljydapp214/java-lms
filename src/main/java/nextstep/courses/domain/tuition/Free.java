package nextstep.courses.domain.tuition;

public class Free {

    private final boolean isFree;

    public Free(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean eqaulTo(boolean b) {
        return isFree == b;
    }
}