import java.util.*;

public class Thread2 extends Thread1 implements Runnable {
    String txt;
    int idnum;
    static int idcounter = 0;

    public Thread2() {
        super();
        this.txt = text;
        this.idnum = idcounter+1;
        Thread2.idcounter++;
    }

    public int counter(char a, String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++)
            if (line.charAt(i) == a)
                count++;
        return count;
    }

    public Character getMapKeyWithHighestValue(Map<Character, Integer> map) {
        char keyWithHighestVal = '-';
        int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                keyWithHighestVal = entry.getKey();
            }
        }
        return keyWithHighestVal;
    }

    public Character getMapKeyWithLowestValue(Map<Character, Integer> map) {
        char keyWithLowestVal = '-';
        int minValueInMap = (Collections.min(map.values()));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == minValueInMap) {
                keyWithLowestVal = entry.getKey();
            }
        }
        return keyWithLowestVal;
    }


    @Override
    public synchronized void run() {
        Set<Character> s1 = new HashSet<>();
        Map<Character, Integer> m0 = new HashMap<>();
        if(idnum ==1) {
            for (char c : txt.toCharArray()) {
                s1.add(c);
            }
            for (char c : s1) {
                m0.put(c, counter(c, txt));
            }
            map = m0;
            System.out.println("Success. Map created");
            System.out.println(m0.toString());

        }
        if(idnum ==2) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<Character, Integer> m1 = map;
            Map<Character, Integer> m2 = new LinkedHashMap<>();
            m2.put(getMapKeyWithHighestValue(m1), Collections.max(m1.values()));
            m1.remove(getMapKeyWithHighestValue(m1), Collections.max(m1.values()));
            m2.put(getMapKeyWithHighestValue(m1), Collections.max(m1.values()));
            m1.remove(getMapKeyWithHighestValue(m1), Collections.max(m1.values()));
            m2.put(getMapKeyWithHighestValue(m1), Collections.max(m1.values()));
            m1.remove(getMapKeyWithHighestValue(m1), Collections.max(m1.values()));
            System.out.println("Often: " + m2.toString());

            Map<Character, Integer> m3 = new LinkedHashMap<>();
            m3.put(getMapKeyWithLowestValue(m1), Collections.min(m1.values()));
            m1.remove(getMapKeyWithLowestValue(m1), Collections.min(m1.values()));
            m3.put(getMapKeyWithLowestValue(m1), Collections.min(m1.values()));
            m1.remove(getMapKeyWithLowestValue(m1), Collections.min(m1.values()));
            m3.put(getMapKeyWithLowestValue(m1), Collections.min(m1.values()));
            m1.remove(getMapKeyWithLowestValue(m1), Collections.min(m1.values()));
            System.out.println("Rare: " + m3.toString());
        }
    }
}




