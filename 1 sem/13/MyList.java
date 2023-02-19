//если что, я не успела потестить все, вряд ли оно вообще будет работать
//но я убила на это 4 часа, так что хочу, чтобы хоть кто-то увидел мое детище
import java.util.Arrays;

public class MyList {
    private String[] strings = new String[10];
    private int lastFreeIndex = 0;


    public boolean add(String s){
        if (lastFreeIndex+1>=strings.length){
            String[] newArray = new String[strings.length+10];
            copyArrays(strings,newArray);
            strings = newArray;
        }
        strings[lastFreeIndex] = s;
        lastFreeIndex++;
        return true;
    }
    boolean addAll(MyList otherList) {
        String result[]=new String[strings.length+otherList.size()];
        System.arraycopy(strings,0, result, 0, strings.length);
        String[] wordsArray = new String[otherList.size()];

        for (int i = 0; i < otherList.size(); i++) {
            wordsArray[i] = otherList.get(i);
        }
        System.arraycopy(wordsArray,0, result, wordsArray.length, wordsArray.length);
        return true;
    }
    boolean containsAll(MyList otherList) {
        int a = 0;
        for (int i = 0; i < lastFreeIndex; i ++){
            for (int j = 0; j < otherList.size(); j ++) {
                if (strings[i].equals(otherList.get(j))){
                    a += 1;
                }
            }
        }
        if (a==otherList.size()) {
            return true;
        } else {
            return false;
        }
    }
    boolean isEmpty() {
        String[] empty = {};
        if (strings.equals(empty)) {
            return true;
        } else {
            return false;
        }
    }
    boolean removeAll(MyList otherList) {
        String[] wordsArray = new String[otherList.size()];

        for (int i = 0; i < otherList.size(); i++) {
            wordsArray[i] = otherList.get(i);
        }
        for (int i = 0; i < lastFreeIndex; i++) {
            for (int j = 0; j < wordsArray.length; j++) {
                //я может туплю, но честно не понимаю, почему ругается
                if (strings.contains(wordsArray[j])) {
                    strings.remove(wordsArray[j]);
                }
            }
        }
        return true;
    }

    public String get(int index){
        return strings[index];
    }

    private void copyArrays(String[] source, String[] target){
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }
    public int size(){
        return lastFreeIndex;
    }


    public int indexOf(String S){
        for (int i = 0; i < lastFreeIndex; i ++){
            if (strings[i].equals(S)){
                return i;
            }
        }
        return -1;
    }
    public boolean contains(String S){
        int a = 0;
        for (int i = 0; i < lastFreeIndex; i ++){
            if (strings[i].equals(S)){
                a += 1;
            }
        }
        if (a>=1) {
            return true;
        } else {
            return false;
        }
    }
    public String remove(int index){
        String removedVar = strings[index];
        String[] truncated = new String[strings.length];
        System.arraycopy(strings, 0, truncated, 0, index);
        if (lastFreeIndex - (index + 1) >= 0) {
            System.arraycopy(strings, index + 1, truncated, index, lastFreeIndex - (index + 1));
        }
        strings = truncated;
        lastFreeIndex--;
        return removedVar;
    }
    public void clear(){
        while (lastFreeIndex>0) {
            int cntOfNumb = 0;
            for (int i = lastFreeIndex; i > 0; i--){
                cntOfNumb++;
                for (int j = lastFreeIndex - i; j < lastFreeIndex; j++){
                    strings[j] = strings[j+1];

                }
            }
            lastFreeIndex -= cntOfNumb;
        }
    }

    public boolean remove(String S){
            int cntOfNumb = 0;
            for (int i = lastFreeIndex; i > 0; i--){
                if (strings[i].equals(S)){
                    cntOfNumb++;
                    for (int j = lastFreeIndex - i; j < lastFreeIndex; j++){
                        strings[j] = strings[j+1];
                    }
                }
            }
            lastFreeIndex -= cntOfNumb;
            return true;
    }
//тут должен быть оверрайд, но он почему то удаляет его
public boolean equals(MyList myList, MyList myList1) {
    String[] wordsArray = new String[myList.size()];

    for (int i = 0; i < myList.size(); i++) {
        wordsArray[i] = myList.get(i);
    }
    return Arrays.equals(wordsArray, strings);
}
@Override
public String toString() {
    StringBuilder str = new StringBuilder();
    str.append('[');
    for (int i = 0; i < lastFreeIndex; i++) {
        str.append(strings[i]);
        if (i < lastFreeIndex - 1) {
            str.append(", ");
        }
    }
    str.append(']');
    return str.toString();
}


}