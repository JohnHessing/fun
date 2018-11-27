package nl.hessing.anotherfunproject;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class StreamFunWorker {

    void goForIt() {

        Logger logger = LoggerFactory.getLogger(StreamFunWorker.class);
        String[] numbers = {"23", "1", "67", "a1", "A1", "1000", "A54"};

        Arrays.stream(numbers).sorted(this::getCompareResult).forEach(logger::info);
    }

    private int getCompareResult(String o1, String o2) {
        return Integer.valueOf(stripped(o2)).compareTo(Integer.valueOf(stripped(o1)));
    }

    private String stripped(String str) {
        StringBuilder buffer = new StringBuilder();

        StringCharacterIterator it = new StringCharacterIterator(str);
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            if (isNumeric(String.valueOf(ch))) {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    private boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}

