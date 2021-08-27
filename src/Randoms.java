import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private final List<Integer> list = new ArrayList<>();

    public Randoms(int min, int max) {
        int randomNumber = 0;

        while (randomNumber != max) {
            Random random = new Random();
            randomNumber = random.nextInt(max - min + 1);
            randomNumber += min;

            list.add(randomNumber);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int next = 0;

            @Override
            public boolean hasNext() {
                return next < list.size();
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    int value = list.get(next);
                    next++;
                    return value;
                }
                return null;
            }
        };
    }
}