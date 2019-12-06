package sam;

import java.util.List;

/**
 * SAM
 */
@FunctionalInterface
public interface MyCountable {
    public int myCount(List<Integer> list);

    // java.lang.object에서 내려받은 것이므로 SAM의 총 개수에서 제외시킨다.
    public String toString();
    public boolean equals(Object o);
}
